/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package smartfood;

import com.sun.org.apache.bcel.internal.generic.AALOAD;
import java.io.File;
import smartfood.prueba.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
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
import smartfood.classes.user.Usuario;

/**
 *
 * @author Mercedes
 */
public class Prueba extends Application {
    
    public Scene scene;
    @Override
    public void start(Stage primaryStage) {
       
        Usuario u = new Usuario();
        u.setRol("as");
        primaryStage = creadorSubmenu(u);
        primaryStage.setResizable(false);
        primaryStage.setMaximized(false);
        primaryStage.setIconified(false);
        
//        primaryStage.setOnCloseRequest(new EventHandler<WindowEvent>(){
//            @Override public void handle(WindowEvent event) {
//                System.out.println("No puede cerrar de esta manera");
//                event.consume();           //Consumar el evento
//            }  
//        });¿
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
    public static Stage creadorSubmenu(Usuario u){
        
        Stage stage = new Stage();
        Submenu root = null;
        if(u.getRol().equalsIgnoreCase("cliente")){
            ArrayList<String> labels = new ArrayList<>();
            labels.add("Listar Categ.");
            labels.add("Buscar Plato");
            labels.add("Cerrar Sesion");
            
            ArrayList<String> links = new ArrayList<>();
            links.add("src/smartfood/screen/info/ListaCategorias.fxml");
            links.add("src/smartfood/screen/client/BusquedaPlatillo.fxml");
            links.add("exit");
            root = new Submenu("CLIENTE", labels, links);
        }else{
            ArrayList<String> labels = new ArrayList<>();
            labels.add("Agregar Plato");
            labels.add("Listar Platos");
            labels.add("Listar Categ.");
            labels.add("Cerrar Sesion");
            
            ArrayList<String> links = new ArrayList<>();
            links.add("src/smartfood/screen/assistant/AgregarPlatillo.fxml");
            links.add("src/smartfood/screen/assistant/ListarPlatillos.fxml");
            links.add("src/smartfood/screen/info/ListaCategorias.fxml");
            links.add("exit");
            root = new Submenu("ASISTENTE", labels, links);
        }
        System.out.println(root.getBotones().size());
        for(Map.Entry<String, Button>entry :root.getBotones().entrySet()){
            System.out.println(entry.getKey());
            if(entry.getKey().equalsIgnoreCase("exit")){
                entry.getValue().setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        stage.close();
                    }
                });
            }else{
                entry.getValue().setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    Parent root = null ;

                    try {
                        File archivo = new File(entry.getKey());
                        System.out.println(archivo.exists());
                        root = FXMLLoader.load(archivo.toURL());
                    } catch (IOException ex) {
                        System.out.println("Error");
                        Logger.getLogger(Prueba.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    Scene scene = new Scene(root);
                    stage.close();
                    Stage nueva = new Stage();
                    nueva.setScene(scene);
                    nueva.showAndWait();
                    stage.show();

                }
            });
            }
        }
        stage.setTitle(u.getRol().toUpperCase());
             
        
        Scene scene = new Scene(root.getPanel(), root.getAncho() - 10, root.getAlto());
        stage.setScene(scene);
        return stage;
    }
    
}
