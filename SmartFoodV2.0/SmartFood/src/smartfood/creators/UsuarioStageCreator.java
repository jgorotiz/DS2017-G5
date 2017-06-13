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
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import smartfood.controller.assistant.AsistenteController;
import smartfood.controller.assistant.PlatilloInfoAsistenteController;
import smartfood.controller.info.ListaCategoriaController;

/**
 *
 * @author Mercedes
 */
public final class UsuarioStageCreator {
    
    public static Stage usuarioStageCreator(String url){
        
        Stage stage = new Stage();
        Parent root = null;
        File archivo = new File(url);
        try {
            root = FXMLLoader.load(archivo.toURL());
        } catch (IOException ex) {
            Logger.getLogger(LoginCreator.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        Scene scene = new Scene(root);
        
        stage.setScene(scene);
        return stage;
    
    }
    
    public static Stage usuarioStageCreator(String url, int idRestaurante,
            MouseEvent event) {
        
        try {
            
            System.out.println("Hola");
            File archivo = new File(url);
            FXMLLoader loader = FXMLLoader.load(archivo.toURL());
            System.out.println("Mundo");
            BorderPane page = (BorderPane) loader.load();
            Stage parent = (Stage) ((Node)event.getTarget()).getScene().
                    getWindow();
            
            Stage dialogStage = new Stage();
            
            dialogStage.setTitle(parent.getTitle());
            dialogStage.initModality(Modality.WINDOW_MODAL);
//            dialogStage.getIcons().add(parent.getIcons().get(0));
            dialogStage.initOwner(((Node)event.getTarget()).getScene().getWindow());
            Scene scene = new Scene(page);
            dialogStage.setScene(scene);
            
            
            System.out.println(loader.getController().getClass());
            AsistenteController controller = loader.getController();
            controller.setDialogStage(dialogStage);
            controller.setIdRestaurante(idRestaurante);

            return dialogStage;

        } catch (IOException e) {
            System.out.println("Problemas en carga");
            return null;
        }
        
    }
}
