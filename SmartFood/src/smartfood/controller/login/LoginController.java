/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package smartfood.controller.login;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;

/**
 *
 * @author Jose Masson
 */
public class LoginController implements Initializable {
    
    @FXML
    private TextField user;
//    private Label label;
    
    @FXML
    private void handleButtonAction(ActionEvent event) {
        System.out.println(user.getText());
//        label.setText(user.getText());
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
