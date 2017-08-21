/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package smartfood.controller.client;

import smartfood.controller.assistant.*;
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
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.Window;
import smartfood.classes.alerts.ConfirmationAlert;
import smartfood.classes.alerts.GeneralAlert;
import smartfood.classes.alerts.InfoAlert;
import smartfood.classes.alerts.WarningAlert;
import smartfood.classes.connection.Conexion;
import smartfood.interfaces.OpcionesBotones;
import smartfood.models.Almuerzo;
import smartfood.models.AlmuerzoBuilder;
import smartfood.models.AlmuerzoDirector;

/**
 *
 * @author Jose Masson
 */
public class ListarAlmuerzosController implements Initializable, 
        OpcionesBotones {

    private Stage app;
    
    private int cargas;
    
    @FXML
    private int idRestaurante;
    
    @FXML
    private TableView<Almuerzo> almuerzos;
    
    @FXML
    private TableColumn<Almuerzo, String> sopa;
    
    @FXML
    private TableColumn<Almuerzo, String> segundo;
    
    @FXML
    private TableColumn<Almuerzo, String> tipo;
    
    @FXML
    private TableColumn<Almuerzo, Double> costo;
    
    @FXML
    private TableColumn<Almuerzo, String> restaurante;
    
    @FXML
    private ObservableList<Almuerzo> listaAlmuerzos;
    
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
    
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        
        this.setCellValues();
        
//        
//        this.nombrePlato.setStyle("-fx-alignment: CENTER;");
//        this.nombreCategoria.setStyle("-fx-alignment: CENTER;");
//        
        this.cargas = 1;
        this.showResults();
        
        System.out.println(this.cargas);
    }
    
    private void setCellValues() {
        this.sopa.
                setCellValueFactory(new PropertyValueFactory<>("sopa"));
        this.segundo.
                setCellValueFactory(new PropertyValueFactory<>("segundo"));
        this.costo.
                setCellValueFactory(new PropertyValueFactory<>("costo"));
        this.restaurante.
                setCellValueFactory(new PropertyValueFactory<>("restaurante"));
        this.tipo.
                setCellValueFactory(new PropertyValueFactory<>("tipo"));
    }
    
    private void showResults() {
        
        if (this.cargas == 1) {
            Conexion cn;

            ResultSet resultados;

            cn = new Conexion();

            try {

                resultados = Almuerzo.getListado(cn);

                this.createAlmuerzoList(resultados);

                this.almuerzos.setItems(this.listaAlmuerzos);
                
                this.cargas = 0;
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
        else {
            
            GeneralAlert g;
            
            g = new WarningAlert();
            
            g.setMensaje("Ya se ha cargado la lista de almuerzos");
            
            g.showAlert();
        
        }
        
    }
    
    private void createAlmuerzoList(ResultSet r) throws SQLException {
        
        this.listaAlmuerzos = FXCollections.observableArrayList();
        
        while (r.next()) {
            
            String sopaR = r.getString(1);
            String segundoR = r.getString(2);
            String tipoR = r.getString(3);
            double costoR = r.getDouble(4);
            String restauranteR = r.getString(5);
            
            AlmuerzoDirector director = new AlmuerzoDirector();
            AlmuerzoBuilder almuerzoBuilder = new AlmuerzoBuilder();
            director.setAlmuerzoBuilder(almuerzoBuilder);
            director.construirAlmuerzo(sopaR, segundoR, costoR, tipoR, 
                    restauranteR);
            
            Almuerzo almuerzo;
            almuerzo = director.getAlmuerzo();
            this.listaAlmuerzos.add(almuerzo);     
        }
        
    }
    
    public void reservarAlmuerzo(MouseEvent event) {
        
        Almuerzo a;
        
        a = this.almuerzos.getSelectionModel().getSelectedItem();
        if (a != null) {
            
            this.reservarAlmuerzo(a, event);
            
        }
        else {
            GeneralAlert g = new WarningAlert(null, "Seleccione un almuerzo");
            g.showAlert();
        }

    }
    
    private void reservarAlmuerzo(Almuerzo almuerzo, MouseEvent event) {
        try {
            
            FXMLLoader loader = new FXMLLoader(ListarAlmuerzosController.
                    class.getResource("/smartfood/screen/client/ReservarAlmuerzo.fxml"));
            BorderPane page = (BorderPane) loader.load();
            Stage parent = (Stage) ((Node)event.getTarget()).getScene().getWindow();
            
            Stage dialogStage = new Stage();
            
            dialogStage.setTitle(parent.getTitle());
            dialogStage.initModality(Modality.WINDOW_MODAL);
//            dialogStage.getIcons().add(parent.getIcons().get(0));
            dialogStage.initOwner(((Node)event.getTarget()).getScene().getWindow());
            Scene scene = new Scene(page);
            dialogStage.setScene(scene);

            ReservarAlmuerzoController controller = loader.getController();
            controller.setAlmuerzo(almuerzo);
            controller.setDialogStage(dialogStage);
            

            dialogStage.showAndWait();
            this.almuerzos.refresh();

        } catch (IOException e) {
            System.out.println(e);
        }
    }
    
//    
//    public void showDishInfo(MouseEvent event) {
//        
//        Plato p;
//        
//        p = this.platos.getSelectionModel().getSelectedItem();
//        if (p != null) {
//            
//            this.showDishInfo(p, event);
//            
//        }
//        else {
//            GeneralAlert g = new WarningAlert(null, "Seleccione un platillo");
//            g.showAlert();
//        }
//    }
//    
//    private void showDishInfo(Plato p, MouseEvent event) {
//        try {
//            
//            FXMLLoader loader = new FXMLLoader(ListaCategoriaController.
//                    class.getResource("/smartfood/screen/assistant/PlatilloInfoAsistente.fxml"));
//            BorderPane page = (BorderPane) loader.load();
//            Stage parent = (Stage) ((Node)event.getTarget()).getScene().getWindow();
//            
//            Stage dialogStage = new Stage();
//            
//            dialogStage.setTitle(parent.getTitle());
//            dialogStage.initModality(Modality.WINDOW_MODAL);
////            dialogStage.getIcons().add(parent.getIcons().get(0));
//            dialogStage.initOwner(((Node)event.getTarget()).getScene().getWindow());
//            Scene scene = new Scene(page);
//            dialogStage.setScene(scene);
//
//            PlatilloInfoAsistenteController controller = loader.getController();
//            controller.setDialogStage(dialogStage);
//            controller.setPlato(p);
//
//            dialogStage.showAndWait();
//
//        } catch (IOException e) {
//            System.out.println("Error de carga");
//        }
//        
//    }
//    
//    public void modifyDishInfo(MouseEvent event) {
//        
//        Plato p;
//        
//        p = this.platos.getSelectionModel().getSelectedItem();
//        if (p != null) {
//            
//            this.modifyDishInfo(p, event);
//            
//        }
//        else {
//            GeneralAlert g = new WarningAlert(null, "Seleccione un platillo");
//            g.showAlert();
//        }
//    }
//    
//    private void modifyDishInfo(Plato p, MouseEvent event) {
//        try {
//            
//            FXMLLoader loader = new FXMLLoader(ListaCategoriaController.
//                    class.getResource("/smartfood/screen/assistant/ModificarPlatillo.fxml"));
//            BorderPane page = (BorderPane) loader.load();
//            
//            Window w;
//            w = ((Node)event.getTarget()).getScene().getWindow();
//            Stage parent = (Stage) w;
//            
//            Stage dialogStage = new Stage();
//            
//            dialogStage.setTitle(parent.getTitle());
//            dialogStage.initModality(Modality.WINDOW_MODAL);
////            dialogStage.getIcons().add(parent.getIcons().get(0));
//            dialogStage.initOwner(w);
//            Scene scene = new Scene(page);
//            dialogStage.setScene(scene);
//
//            ModificarPlatilloController controller = loader.getController();
//            controller.setDialogStage(dialogStage);
//            controller.setPlato(p);
//
//            dialogStage.showAndWait();
//
//        } catch (IOException e) {
//            System.out.println("Error de carga");
//        }
//        
//    }

    public void setDialogStage(Stage dialogStage) {
        this.app = dialogStage;
    }
    
    @FXML
    public void volver() {
        this.app.close();
    }
}
