/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package smartfood.creators;

import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import smartfood.classes.user.Usuario;

/**
 *
 * @author Mercedes
 */
public class AsistenteStageCreator {
    private Stage stage;
    private Usuario u;
    private String idRestaurante;

    public AsistenteStageCreator(Usuario u, String url, String idRestaurante, 
            MouseEvent event) {
        this.stage = UsuarioStageCreator.usuarioStageCreator(url, 
                Integer.parseInt(idRestaurante), event);
        this.u = u;
        this.idRestaurante = idRestaurante;
    }

    public Stage getStage() {
        return stage;
    }

    public void setStage(Stage stage) {
        this.stage = stage;
    }

    public Usuario getU() {
        return u;
    }

    public void setU(Usuario u) {
        this.u = u;
    }

    public String getIdRestaurante() {
        return idRestaurante;
    }

    public void setIdRestaurante(String idRestaurante) {
        this.idRestaurante = idRestaurante;
    }
    
}
