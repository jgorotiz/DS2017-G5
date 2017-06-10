/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package smartfood.controller.login;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import smartfood.classes.connection.Conexion;

/**
 *
 * @author Jose Masson
 */
public class LoginController implements Initializable {
    
    private Stage stage;
    
    @FXML
    private TextField user;
//    private Label label;
    
    @FXML
    private void handleButtonAction(ActionEvent event) {
        System.out.println("Hola Mundo");
//        File file = new File("../screen/login/Login.fxml");
//        System.out.println(file.isFile());
//        try {
//            
////            Parent root = FXMLLoader.load(LoginController.class
////                    .getResource("../../screen/login/Login.fxml"));
//            Parent root = FXMLLoader.load(getClass()
//                    .getResource("/smartfood/screen/client/BusquedaPlatillo.fxml"));
//            
//            Scene scene = new Scene(root);
//            
//            stage.setScene(scene);
//            stage.showAndWait();
//
//        } catch (IOException ex) {
//            System.out.println("Error en carga");
//        }
    }
    
    @FXML
    private void exit(MouseEvent event) {
        System.exit(0);
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }    
    
}
