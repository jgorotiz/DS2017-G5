/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package smartfood.controller.assistant;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.input.MouseEvent;
import smartfood.classes.food.Restaurante;

/**
 * FXML Controller class
 *
 * @author jlmp1
 */
public class SeleccionarRestauranteController implements Initializable {

    @FXML
    private Button backButton;
    
    @FXML
    private Button acceder;
    
    @FXML
    private TableView<Restaurante> restaurantes;
    
    @FXML
    private TableColumn<Restaurante, String> nombreRestaurante;
    
    @FXML
    private ObservableList<Restaurante> listaRestaurantes;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void volver(MouseEvent event) {
    }

    @FXML
    private void salir(MouseEvent event) {
    }
    
//    SeleccionarRestaurante
}
