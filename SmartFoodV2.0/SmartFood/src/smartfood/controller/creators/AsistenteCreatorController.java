/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package smartfood.controller.creators;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;
import javafx.stage.Stage;

/**
 *
 * @author Jose Masson
 */
public class AsistenteCreatorController implements Initializable {
    
    private Stage appStage;
    
    private int idRestaurante;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        
    }

    public void setAppStage(Stage appStage) {
        this.appStage = appStage;
    }

    public void setIdRestaurante(int idRestaurante) {
        this.idRestaurante = idRestaurante;
    }
    
    public void agregarPlato() {
        
    }
    
    public void listarPlatos() {
        
    }
    
    public void listarCategorias() {
        
    }
    
    public void cerrarSesion() {
        
    }
    
}
