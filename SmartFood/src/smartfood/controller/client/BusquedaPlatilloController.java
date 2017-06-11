/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package smartfood.controller.client;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import smartfood.classes.alerts.GeneralAlert;
import smartfood.classes.alerts.WarningAlert;
import smartfood.classes.food.Plato;
import smartfood.controller.info.ListaCategoriaController;
import smartfood.controller.info.PlatilloInfoController;

/**
 *
 * @author Jose Masson
 */
public class BusquedaPlatilloController implements Initializable {

    @FXML
    private ComboBox choiceBox;
    
    @FXML
    private TextField searchBox;
    
    @FXML
    private TableView<Plato> table;
    
    @FXML
    private TableColumn<Plato, String> nombrePlatillo;
    
    @FXML
    private TableColumn<Plato, String> nombreRestaurante;
    
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        this.choiceBox.getItems().addAll("Nombre", "Descripción");
        
        this.nombrePlatillo.
                setCellValueFactory(new PropertyValueFactory<>("nombre"));
        this.nombreRestaurante.
                setCellValueFactory(new PropertyValueFactory<>("restaurante"));
    }
    
    public void showResults() {
        
        String texto;
        
        texto = this.choiceBox.getSelectionModel().getSelectedItem().toString();
        
        if (texto.equals("Nombre")) {
            
        }
        else if (texto.equals("Descripción")) {
            
        } 
        
    }
    
    private void clearSearchBox() {
        this.searchBox.clear();
    }
    
    public void showDishInfo(MouseEvent event) {
        
        Plato p;
        
        p = this.table.getSelectionModel().getSelectedItem();
        if (p != null) {
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
                    class.getResource("../../screen/info/PlatilloInfo.fxml"));
            BorderPane page = (BorderPane) loader.load();
            Stage parent = (Stage) ((Node)event.getTarget()).getScene().getWindow();
            
            Stage dialogStage = new Stage();
            
            dialogStage.setTitle(parent.getTitle());
            dialogStage.initModality(Modality.WINDOW_MODAL);
//            dialogStage.getIcons().add(parent.getIcons().get(0));
            dialogStage.initOwner(((Node)event.getTarget()).getScene().getWindow());
            Scene scene = new Scene(page);
            dialogStage.setScene(scene);

            PlatilloInfoController controller = loader.getController();
            controller.setDialogStage(dialogStage);
            controller.setPlato(p);

            dialogStage.showAndWait();

        } catch (IOException e) {
           
        }
        
    }
}
