/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package smartfood.controller.assistant;

import java.io.IOException;
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
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import smartfood.classes.alerts.ConfirmationAlert;
import smartfood.classes.alerts.GeneralAlert;
import smartfood.classes.alerts.InfoAlert;
import smartfood.classes.alerts.WarningAlert;
import smartfood.classes.connection.Conexion;
import smartfood.classes.food.Restaurante;
import smartfood.classes.user.Usuario;
import smartfood.controller.creators.AsistenteCreatorController;
import smartfood.controller.info.ListaCategoriaController;

/**
 * FXML Controller class
 *
 * @author jlmp1
 */
public class SeleccionarRestauranteController implements Initializable {

    private Stage app;
    
    private Usuario usuario;
    
    private boolean cargado;
    
    @FXML
    private Button cerrarSesion;
    
    @FXML
    private Button acceder;
    
    @FXML
    private TableView<Restaurante> restaurantes;
    
    @FXML
    private TableColumn<Restaurante, String> nombreRestaurante;
    
    @FXML
    private ObservableList<Restaurante> listaRestaurantes;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        this.cargado = true;
        this.nombreRestaurante.
                setCellValueFactory(new PropertyValueFactory<>("nombre"));
        this.acceder.setDisable(cargado);
    }    

    @FXML
    private void volver(MouseEvent event) {
            GeneralAlert g;
        
        try {
            
            ConfirmationAlert confirmation = new ConfirmationAlert();
        
            confirmation.setMensaje("¿Desea cerrar sesión?");
            confirmation.showAlert();
        
            if (confirmation.getResult().get() == ButtonType.OK) {
                
                g = new InfoAlert();
                g.setMensaje("Usted ha cerrado sesión con éxito");
                g.showAlert();
                
                this.handleScreenChanges(event, "/smartfood/screen/login/Login.fxml");
        }

        } catch (IOException ex) {
            g = new WarningAlert();
            g.setMensaje("No ha cerrado sesión");
            g.showAlert();
            
        }
    }
    
    public void handleScreenChanges(MouseEvent event, String screenName) 
            throws IOException {
        Parent menu = FXMLLoader.load(getClass().getResource(screenName));
        Scene menuScene = new Scene(menu);
        this.app = (Stage) ((Node) event.getSource()).getScene().getWindow();
        this.app.close();
        this.app.setScene(menuScene);
        this.app.show();
    }
    
    @FXML
    private void salir(MouseEvent event) {
    }

    public void setApp(Stage app) {
        this.app = app;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
    
    public void showResults(MouseEvent event) {
        
        if (this.cargado) {
            Conexion cn;

            ResultSet resultados;

            cn = new Conexion();

            try {
                
                resultados = Restaurante.getRestaurantesXUsuario(cn, 
                        this.usuario.getIdUsuario());
                
                System.out.println("Hola Aqui estoy");

                this.createRestaurantList(resultados);

                if (this.listaRestaurantes.size() > 0) {
            
                    this.restaurantes.setItems(this.listaRestaurantes);
                    
                    this.acceder.setDisable(!cargado);
                
                    this.cargado = false;
                
                } else {
                
                    GeneralAlert g = new WarningAlert(null, "No existen restau"
                            + "rantes registrados para este usuario");
                    g.showAlert();
                
                }
                
                    
            }
            catch (Exception e) {
                System.out.println(e);
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
            
            g.setMensaje("Ya se ha cargado la lista de restaurantes");
            
            g.showAlert();
        
        }
        
    }
    
    private void createRestaurantList(ResultSet r) throws SQLException {
        
        this.listaRestaurantes = FXCollections.observableArrayList();
        
        while (r.next()) {
            
            Integer idRes = r.getInt(1);
            String nombre = r.getString(2);
            
            Restaurante res;
            
            res = new Restaurante();
            res.setIdRestaurante(idRes);
            res.setNombre(nombre);
            this.listaRestaurantes.add(res);
        
        }
    }
    
    public void cargarAsistente(MouseEvent event) {
        
        Restaurante seleccionado;
        
        seleccionado = this.restaurantes.getSelectionModel().getSelectedItem();
        
        if (seleccionado != null) {
            this.cargarAsistente(event, seleccionado);
        }
        else {
            
            GeneralAlert g;
            
            g = new WarningAlert();
            
            g.setMensaje("Seleccione un restaurante a administrar");
            
            g.showAlert();
            
        }
        
    }
    
    private void cargarAsistente(MouseEvent event, Restaurante res) {
        try {

            FXMLLoader loader = new FXMLLoader(ListaCategoriaController.
            class.getResource("/smartfood/screen/creators/AsistenteCreator.fxml"));

            BorderPane page = (BorderPane) loader.load();
            Stage parent = (Stage) ((Node)event.getTarget()).getScene().getWindow();

            Stage dialogStage = new Stage();

            dialogStage.setTitle(parent.getTitle());
            dialogStage.initModality(Modality.WINDOW_MODAL);
    //            dialogStage.getIcons().add(parent.getIcons().get(0));
            dialogStage.initOwner(((Node)event.getTarget()).getScene().getWindow());

            parent.close();
            Scene scene = new Scene(page);
            dialogStage.setScene(scene);

            AsistenteCreatorController controller = loader.getController();
            controller.setAppStage(dialogStage);
            controller.setRestaurante(res);
            controller.setNombreRestaurante(res.getNombre());
//            controller.setIdRestaurante(idRes);

            dialogStage.showAndWait();

        } catch (IOException e) {
            System.out.println("Error de carga");
        }
    }
    
}
