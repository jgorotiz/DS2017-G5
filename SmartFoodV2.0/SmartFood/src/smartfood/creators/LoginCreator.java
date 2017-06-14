/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package smartfood.creators;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author Mercedes
 */
public final class LoginCreator {
    
    public static Stage loginCreator() throws IOException{
        
        Stage stage;
        
        Parent root;
        
        stage = new Stage();
        
        File archivo = new File("src/smartfood/screen/login/Login.fxml");
        
        URL url;
        
        url = archivo.toURI().toURL();
        
        root = FXMLLoader.load(url);
        
        Scene scene = new Scene(root);
        
        stage.setScene(scene);
        
        return stage;


    }
    
}
