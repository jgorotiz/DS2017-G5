/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package smartfood;

import javafx.application.Application;
import javafx.stage.Stage;
import smartfood.creators.LoginCreator;

/**
 *
 * @author Jose Masson
 */
public class SmartFood extends Application {
    
    @Override
    public void start(Stage stage) throws Exception {
        
        stage = LoginCreator.loginCreator();
        stage.setTitle("SmartFood 2.0"); 
        stage.show();
        
    }
    

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
