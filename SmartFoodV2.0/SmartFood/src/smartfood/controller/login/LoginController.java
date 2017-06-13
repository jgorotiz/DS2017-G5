/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package smartfood.controller.login;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import smartfood.creators.SubmenuCreator;
import smartfood.classes.connection.Conexion;
import smartfood.classes.user.Usuario;

/**
 *
 * @author Jose Masson
 */
public class LoginController implements Initializable {
    
    private Usuario usuario;
    
    @FXML
    private TextField user;
    
    @FXML
    private PasswordField password;
//    private Label label;
    
    @FXML
    private void login(MouseEvent event) {
        
        Usuario usuarioSistema;
        
        ArrayList<String> validador;
        
        String u = this.user.getText().trim();
        String p = this.password.getText().trim();
        
        validador = Usuario.buscarUsuario(u, p);
        
        int existeUsuario = Integer.parseInt(validador.get(0));
//         else {
            if(existeUsuario == 1) {
                System.out.println(validador.get(1));
                usuarioSistema = new Usuario();
                usuarioSistema.setUsuario(u);
                usuarioSistema.setContrasenia(p);
                usuarioSistema.setRol(validador.get(1));
                usuarioSistema.setIdUsuario(Integer.parseInt(validador.get(2)));
                
                
                Stage stage= SubmenuCreator.submenuCreator(usuarioSistema);
                                
                System.out.println("Ingreso exitoso");
                stage.showAndWait();
                
                
//                AlertsSystem.showInfo(1);
//                handleScreenChanges(event,"/simacom/screen/menu/mainMenu.fxml" );
            }
            else {
                usuarioSistema = null;
                System.out.println("Valiste ingresando");
//                AlertsSystem.showAlert(4);
//                this.clearFields();
            }
            //else
                    //handleScreenChanges(event,"/simacom/screen/login/login.fxml" );
                    //handleScreenChanges(event,"/simacom/screen/login/login.fxml" );     
//        }
        
//        Usuario u;
//        
//        u = new Usuario();
//        
//        if (u != null) {
//            
//        }
//        else {
//            
//        }
//        System.out.println("Hola Mundo");
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
