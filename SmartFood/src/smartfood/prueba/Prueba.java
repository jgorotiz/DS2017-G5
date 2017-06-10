/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package smartfood.prueba;

import java.util.ArrayList;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

/**
 *
 * @author Mercedes
 */
public class Prueba extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        
        ArrayList<String> nombres = new ArrayList<>();
        nombres.add("Ingreso");
        nombres.add("Consultar");
        nombres.add("Prueba");
        System.out.println(nombres);
        Submenu root = new Submenu("USUARIO", nombres);
        
        Scene scene = new Scene(root.getPanel(), root.getAncho() - 10, root.getAlto());
        primaryStage.setTitle("Hello World!");
        primaryStage.setResizable(false);
        primaryStage.setMaximized(false);
        primaryStage.setIconified(false);
//        primaryStage.setOnCloseRequest(new EventHandler<WindowEvent>(){
//            @Override public void handle(WindowEvent event) {
//                System.out.println("No puede cerrar de esta manera");
//                event.consume();           //Consumar el evento
//            }  
//        });
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
