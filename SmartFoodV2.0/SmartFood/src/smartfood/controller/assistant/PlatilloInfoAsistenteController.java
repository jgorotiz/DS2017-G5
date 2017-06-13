/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package smartfood.controller.assistant;

import smartfood.controller.info.*;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import smartfood.classes.food.Plato;

/**
 *
 * @author Jose Masson
 */
public class PlatilloInfoAsistenteController implements Initializable {

    private Stage appStage;
    
    @FXML
    private TextField nombrePlatillo;
    @FXML
    private TextField tipoPlato;
    @FXML
    private TextField servidoPlato;
    @FXML
    private TextField categoriaPlato;
    @FXML
    private TextArea descripcionPlatillo;

    @FXML
    private ImageView imagenPlatillo;
    
    public void setDialogStage(Stage dialogStage) {
        this.appStage = dialogStage;
    }
    
    public void setPlato(Plato p) {
        this.nombrePlatillo.setText(p.getNombre());
        this.servidoPlato.setText(p.getServido());
        this.tipoPlato.setText(p.getTipo());
        this.categoriaPlato.setText(p.getCategoria());
        this.descripcionPlatillo.setText(p.getDescripcion());
        this.imagenPlatillo.setImage(p.getImagen());
    }

    @FXML
    public void handleOk() {
        this.appStage.close();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        
    }
    
}
