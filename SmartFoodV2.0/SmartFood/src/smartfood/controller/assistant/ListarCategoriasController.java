/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package smartfood.controller.assistant;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import smartfood.classes.alerts.ConfirmationAlert;
import smartfood.classes.alerts.GeneralAlert;
import smartfood.classes.alerts.InfoAlert;
import smartfood.classes.alerts.WarningAlert;
import smartfood.classes.connection.Conexion;
import smartfood.classes.food.Categoria;
import smartfood.classes.food.Plato;
import smartfood.controller.info.ListaCategoriaController;
import smartfood.interfaces.OpcionesBotones;

/**
 *
 * @author Jose Masson
 */
public class ListarCategoriasController implements Initializable, 
        OpcionesBotones {
    
    private int cargas;
    
    private int idRestaurante;
    
    private Stage app;
    
    @FXML
    private TableView<Categoria> categorias;
    
    @FXML
    private TableView<Plato> platillos;
    
    @FXML
    private TableColumn<Categoria, String> nombreCategoria;
    
    @FXML
    private TableColumn<Categoria, Integer> totalPlatillos;
   
    @FXML
    private TableColumn<Plato, String> nombrePlato;
    
    @FXML
    private TableColumn<Plato, String> tipoPlato;
    
    @FXML
    private ObservableList<Categoria> listaCategorias;
    
    @FXML
    private ObservableList<Plato> listaPlatillos;
    
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        
        this.nombreCategoria.
                setCellValueFactory(new PropertyValueFactory<>("nombreCategoria"));
        this.totalPlatillos.
                setCellValueFactory(new PropertyValueFactory<>("totalPlatillos"));
        
        this.totalPlatillos.setStyle("-fx-alignment: CENTER-RIGHT;");
        
        this.nombrePlato
                .setCellValueFactory(new PropertyValueFactory<>("nombre"));
        
        this.tipoPlato
                .setCellValueFactory(new PropertyValueFactory<>("tipo"));
        
        this.cargas = 1;
    }
    
    @Override
    public void salir() {
        ConfirmationAlert confirmation = new ConfirmationAlert();
        
        confirmation.setMensaje("¿Desea salir del sistema?");
        confirmation.showAlert();
        
        if (confirmation.getResult().get() == ButtonType.OK) {
            GeneralAlert g;
            g = new InfoAlert();
            g.setMensaje("Usted ha salido del sistema");
            g.showAlert();
            System.exit(0);
        }
        
    }
    
    public void showCategoryResults() {
        
        if (this.cargas == 1) {
            Conexion cn;

            ResultSet resultados;

            cn = new Conexion();

            try {

                resultados = Categoria.getListadoCategoriasXRestaurante(cn, 
                        this.idRestaurante);

                this.createCategoryList(resultados);

                this.categorias.setItems(listaCategorias);
                
                this.cargas = 0;
            }
            catch (Exception e) {

            }
            finally {
                try {
                    cn.getConnection().close();

                } catch (SQLException ex) {
                    System.out.println("Error en cierre de conexion");
                }
            }
        }
        else {
            
            GeneralAlert g;
            
            g = new WarningAlert();
            
            g.setMensaje("Ya se ha cargado la lista de categorías");
            
            g.showAlert();
            
        }
        
    }
    
    private void showDishResults(Categoria c) {
        Conexion cn;
        
        ResultSet resultados;
       
        cn = new Conexion();
        
        try {
            
            resultados = Plato.getListadoXCategoriaYRestaurante(cn, 
                    c.getIdCategoria(), this.idRestaurante);
            
            this.createDishList(resultados);
            
            if (this.listaPlatillos.size() > 0) {
            
                this.platillos.setItems(this.listaPlatillos);
                
            } else {
                
                GeneralAlert g = new WarningAlert(null, "Seleccione un platillo");
                g.showAlert();
                
            }
        }
        catch (Exception e) {
            
        }
        finally {
            try {
                cn.getConnection().close();
                
            } catch (SQLException ex) {
                System.out.println("Error en cierre de conexion");
            }
        }
    }
    
    private void createCategoryList(ResultSet r) throws SQLException {
        
        this.listaCategorias = FXCollections.observableArrayList();
        
        while (r.next()) {
            
            Integer idPlatillo = r.getInt(1);
            String nomCategoria = r.getString(3);
            Integer totPlatillos = r.getInt(2);
            
            
            Categoria c;
            
            c = new Categoria(nomCategoria, totPlatillos, idPlatillo);
            
            System.out.println(c);
            
            this.listaCategorias.add(c);
            
        }

    }
    
    private void createDishList(ResultSet r) throws SQLException {
        
        this.listaPlatillos = FXCollections.observableArrayList();
        
        while (r.next()) {
            
            Integer idPlatillo = r.getInt(1);
            String nombre = r.getString(2);
            String descripcion = r.getString(3);
            String tipo = r.getString(4);
            String nomCategoria = r.getString(5);
            String restaurante = Integer.toString(this.idRestaurante);
            InputStream img = r.getBinaryStream(6);
            String serv = r.getString(7);
            Image imagen = new Image(img);
            
            
            Plato p;
            
            p = new Plato(idPlatillo, nombre, descripcion, imagen, nomCategoria, 
                    tipo, serv, restaurante);
            this.listaPlatillos.add(p);
            
        }
        
    }
    
    
    public void showInfo(MouseEvent event) {
        
        Categoria c;
        
        c = this.categorias.getSelectionModel().getSelectedItem();
        if (c != null) {
            this.showFoodCategory(c);
        }
        else {
            GeneralAlert g = new WarningAlert(null, "Seleccione una categoría");
            g.showAlert();
        }
        
    }
    
    public void showDishInfo(MouseEvent event) {
        
        Plato p;
        
        p = this.platillos.getSelectionModel().getSelectedItem();
        if (p != null) {
            this.showDishInfo(p, event);
        }
        else {
            GeneralAlert g = new WarningAlert(null, "Seleccione un platillo");
            g.showAlert();
        }
    }
    
    private void showFoodCategory(Categoria categoria) {
       
        this.showDishResults(categoria);
        
    }
    
    private void showDishInfo(Plato p, MouseEvent event) {
        try {
            
            FXMLLoader loader = new FXMLLoader(ListaCategoriaController.
                    class.getResource("/smartfood/screen/assistant/PlatilloInfoAsistente.fxml"));
            BorderPane page = (BorderPane) loader.load();
            Stage parent = (Stage) ((Node)event.getTarget()).getScene().getWindow();
            
            Stage dialogStage = new Stage();
            
            dialogStage.setTitle(parent.getTitle());
            dialogStage.initModality(Modality.WINDOW_MODAL);
//            dialogStage.getIcons().add(parent.getIcons().get(0));
            dialogStage.initOwner(((Node)event.getTarget()).getScene().getWindow());
            Scene scene = new Scene(page);
            dialogStage.setScene(scene);

            PlatilloInfoAsistenteController controller = loader.getController();
            controller.setDialogStage(dialogStage);
            controller.setPlato(p);

            dialogStage.showAndWait();

        } catch (IOException e) {
            System.out.println("Error de carga");
        }
        
    }

    public void setDialogStage(Stage dialogStage) {
        this.app = dialogStage;
    }

    public void setIDRestaurante(int idRestaurante) {
        this.idRestaurante = idRestaurante;
    }
    
    @FXML
    public void volver() {
        this.app.close();
    }
}
