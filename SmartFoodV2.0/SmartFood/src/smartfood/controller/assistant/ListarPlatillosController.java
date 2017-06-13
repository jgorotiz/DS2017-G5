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
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.Window;
import smartfood.classes.alerts.GeneralAlert;
import smartfood.classes.alerts.WarningAlert;
import smartfood.classes.connection.Conexion;
import smartfood.classes.food.Plato;
import smartfood.controller.info.ListaCategoriaController;
//import smartfood.controller.info.PlatilloInfoController;

/**
 *
 * @author Jose Masson
 */
public class ListarPlatillosController implements Initializable {

    private Stage app;
    
    @FXML
    private int idRestaurante;
    
    @FXML
    private TableView<Plato> platos;
    
    @FXML
    private TableColumn<Plato, String> nombrePlato;
    
    @FXML
    private TableColumn<Plato, String> nombreCategoria;
    
    @FXML
    private ObservableList<Plato> listaPlatos;
    
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        
        this.nombrePlato.
                setCellValueFactory(new PropertyValueFactory<>("nombre"));
        this.nombreCategoria.
                setCellValueFactory(new PropertyValueFactory<>("categoria"));
       
        
        this.nombrePlato.setStyle("-fx-alignment: CENTER;");
        this.nombreCategoria.setStyle("-fx-alignment: CENTER;");
        
        this.showCategoryResults();
    }
    
    public void setIDRestaurante(int idRestaurante) {
        this.idRestaurante = idRestaurante;
    }
    
    public void showCategoryResults() {
        
        System.out.println("Este es de lista platillos " + this.idRestaurante);
        
        Conexion cn;
        
        ResultSet resultados;
       
        cn = new Conexion();
        
        try {
            
            resultados = Plato.getListadoXRestaurante(cn, this.idRestaurante);
            
            this.createDishList(resultados);
            
            this.platos.setItems(this.listaPlatos);
        }
        catch (Exception e) {
            System.out.println("No carga");
        }
        finally {
            try {
                cn.getConnection().close();
                
            } catch (SQLException ex) {
                System.out.println("Error en cierre de conexion");
            }
        }
        
    }
    
    private void createDishList(ResultSet r) throws SQLException {
        
        this.listaPlatos = FXCollections.observableArrayList();
        
        while (r.next()) {
            
            Integer idPlatillo = r.getInt(1);
            String nombre = r.getString(2);
            String descripcion = r.getString(3);
            String tipo = r.getString(6);
            String nomCategoria = r.getString(5);
            String restaurante = Integer.toString(this.idRestaurante);
            InputStream img = r.getBinaryStream(4);
            String serv = r.getString(7);
            Image imagen = new Image(img);
            
            
            Plato p;
            
            p = new Plato(idPlatillo, nombre, descripcion, imagen, nomCategoria, 
                    tipo, serv, restaurante);
            this.listaPlatos.add(p);
            
        }
        
    }
    
    public void showDishInfo(MouseEvent event) {
        
        Plato p;
        
        p = this.platos.getSelectionModel().getSelectedItem();
        if (p != null) {
            
//            p.setCategoria("Hola Mundo");
//            this.platos.refresh();
            this.showDishInfo(p, event);
            
        }
        else {
            GeneralAlert g = new WarningAlert(null, "Seleccione un platillo");
            g.showAlert();
        }
    }
    
    private void showDishInfo(Plato p, MouseEvent event) {
        try {
            
            FXMLLoader loader = new FXMLLoader(ListaCategoriaController.
                    class.getResource("../../screen/assistant/PlatilloInfoAsistente.fxml"));
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
    
    public void modifyDishInfo(MouseEvent event) {
        
        Plato p;
        
        p = this.platos.getSelectionModel().getSelectedItem();
        if (p != null) {
            
            this.modifyDishInfo(p, event);
            
        }
        else {
            GeneralAlert g = new WarningAlert(null, "Seleccione un platillo");
            g.showAlert();
        }
    }
    
    private void modifyDishInfo(Plato p, MouseEvent event) {
        try {
            
            FXMLLoader loader = new FXMLLoader(ListaCategoriaController.
                    class.getResource("../../screen/assistant/ModificarPlatillo.fxml"));
            BorderPane page = (BorderPane) loader.load();
            
            Window w;
            w = ((Node)event.getTarget()).getScene().getWindow();
            Stage parent = (Stage) w;
            
            Stage dialogStage = new Stage();
            
            dialogStage.setTitle(parent.getTitle());
            dialogStage.initModality(Modality.WINDOW_MODAL);
//            dialogStage.getIcons().add(parent.getIcons().get(0));
            dialogStage.initOwner(w);
            Scene scene = new Scene(page);
            dialogStage.setScene(scene);

            ModificarPlatilloController controller = loader.getController();
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
}
