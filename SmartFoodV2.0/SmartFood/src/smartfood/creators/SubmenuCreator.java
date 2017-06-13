/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package smartfood.creators;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import smartfood.classes.user.Usuario;
import smartfood.screen.submenu.Submenu;

/**
 *
 * @author Mercedes
 */
public final class SubmenuCreator {
    public static Stage submenuCreator(Usuario u){
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
                entry.getValue().setOnMouseClicked(new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent event) {
                    
                    Stage nueva = null ;
                    if(u.getRol().equalsIgnoreCase("cliente")){
                        ClienteStageCreator cs = new ClienteStageCreator(u, entry.getKey());
                        nueva = cs.getStage();
                    }else if(u.getRol().equalsIgnoreCase("asistente")){
                        String idRestaurante = "123";
                        AsistenteStageCreator as = new AsistenteStageCreator(u, entry.getKey(), idRestaurante);
                        nueva = as.getStage();
                    }
                    stage.close();
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
