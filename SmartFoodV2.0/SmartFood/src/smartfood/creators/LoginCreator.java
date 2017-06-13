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

/**
 *
 * @author Mercedes
 */
public final class LoginCreator {
    
    public static Stage loginCreator() throws MalformedURLException{
        
        Stage stage = new Stage();
        Parent root = null;
        File archivo = new File("src/smartfood/screen/login/Login.fxml");
        try {
            root = FXMLLoader.load(archivo.toURL());
        } catch (IOException ex) {
            Logger.getLogger(LoginCreator.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        Scene scene = new Scene(root);
        
        stage.setScene(scene);
        return stage;
    }
}
