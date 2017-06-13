/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package smartfood.controller.assistant;

import javafx.stage.Stage;

/**
 *
 * @author Jose Masson
 */
public class AsistenteController {
    
    private Stage appStage;
    
    private int idRestaurante;

    public AsistenteController(int idRestaurante) {
        this.idRestaurante = idRestaurante;
    }

    public int getIdRestaurante() {
        return idRestaurante;
    }
    
    public void setIdRestaurante(int idRestaurante) {
        this.idRestaurante = idRestaurante;
    }
    
    public void setDialogStage(Stage dialogStage) {
        this.appStage = dialogStage;
    }
    
    
    
}
