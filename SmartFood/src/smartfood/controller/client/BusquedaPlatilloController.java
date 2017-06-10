/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package smartfood.controller.client;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import smartfood.classes.food.Plato;

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
    
}
