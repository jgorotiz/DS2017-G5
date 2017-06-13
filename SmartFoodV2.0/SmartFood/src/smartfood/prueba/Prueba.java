/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package smartfood.prueba;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

/**
 *
 * @author Mercedes
 */
public class Prueba extends Application {
    
    public Scene scene;
    @Override
    public void start(Stage primaryStage) {
        
//        ArrayList<String> nombres = new ArrayList<>();
//        nombres.add("Ingreso");
//        nombres.add("Consultar");
//        nombres.add("Prueba");
//        System.out.println(nombres);
//        Submenu root = new Submenu("USUARIO", nombres);
//        for(Map.Entry<String, Button>entry :root.getBotones().entrySet()){
//            entry.getValue().setOnAction(new EventHandler<ActionEvent>() {
//                @Override
//                public void handle(ActionEvent event) {
//                    System.out.println("entra");
//                    Parent root = null ;
//                    try {
//                        System.out.println("Aqui");
//                        root = FXMLLoader.load(getClass().getResource("screen/assistant/ListarPlatillos.fxml"));
//                    } catch (IOException ex) {
//                        System.out.println("Error");
//                        Logger.getLogger(Prueba.class.getName()).log(Level.SEVERE, null, ex);
//                    }
//                    scene = new Scene(root);
//                    primaryStage.setScene(scene);
//                }
//            });
//        }
//        scene = new Scene(root.getPanel(), root.getAncho() - 10, root.getAlto());
//        primaryStage.setTitle("Hello World!");
//        primaryStage.setResizable(false);
//        primaryStage.setMaximized(false);
//        primaryStage.setIconified(false);
//        
////        primaryStage.setOnCloseRequest(new EventHandler<WindowEvent>(){
////            @Override public void handle(WindowEvent event) {
////                System.out.println("No puede cerrar de esta manera");
////                event.consume();           //Consumar el evento
////            }  
////        });
//        primaryStage.setScene(scene);
//        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
