/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package smartfood.controller.assistant;

import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import smartfood.classes.food.Categoria;
import smartfood.classes.food.Servido;
import smartfood.classes.food.Tipo;

/**
 *
 * @author Jose Masson
 */
public class ModificarPlatilloController implements Initializable {

    @FXML
    private TextField nombrePlatillo;
    
    @FXML
    private TextArea descripcionPlatillo;
    
    @FXML
    private ImageView imagenPlatillo;
    
    @FXML
    private ComboBox<Categoria> categoriaPlato;
    
    @FXML
    private ComboBox<Tipo> tipoPlato;
    
    @FXML
    private ComboBox<Servido> servidoPlato;
    
    @FXML
    private ObservableList<Categoria> listaCategorias;
    
    @FXML
    private ObservableList<Tipo> listaTipos;
    
    @FXML
    private ObservableList<Servido> listaServidos;
    
    @FXML
    private File file;
    
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        
    }
    
}
