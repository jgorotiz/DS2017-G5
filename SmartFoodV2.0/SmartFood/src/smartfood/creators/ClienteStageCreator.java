/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package smartfood.creators;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import smartfood.classes.user.Usuario;

/**
 *
 * @author Mercedes
 */
public class ClienteStageCreator {
    private Stage stage;
    private Usuario u;

    public ClienteStageCreator(Usuario u, String url) {
        this.stage = UsuarioStageCreator.usuarioStageCreator(url);
        this.u = u;
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
    
    
    
}
