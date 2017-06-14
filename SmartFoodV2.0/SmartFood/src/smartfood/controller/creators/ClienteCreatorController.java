/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package smartfood.controller.creators;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import smartfood.controller.assistant.ListarPlatillosController;
import smartfood.controller.client.BusquedaPlatilloController;
import smartfood.controller.info.ListaCategoriaController;

/**
 *
 * @author Jose Masson
 */
public class ClienteCreatorController implements Initializable {
    
    private Stage appStage;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        
    }

    public void setAppStage(Stage appStage) {
        this.appStage = appStage;
    }

    public void listarCategorias(MouseEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(ListaCategoriaController.
            class.getResource("/smartfood/screen/info/ListaCategorias.fxml"));
            BorderPane page = (BorderPane) loader.load();
            Stage parent = (Stage) ((Node)event.getTarget()).getScene().getWindow();
            
            Stage dialogStage = new Stage();
            
            dialogStage.setTitle(parent.getTitle());
            dialogStage.initModality(Modality.WINDOW_MODAL);
//            dialogStage.getIcons().add(parent.getIcons().get(0));
            dialogStage.initOwner(((Node)event.getTarget()).getScene().getWindow());
            Scene scene = new Scene(page);
            dialogStage.setScene(scene);

            ListaCategoriaController controller = loader.getController();
            controller.setDialogStage(dialogStage);

            dialogStage.showAndWait();

        } catch (IOException e) {
            System.out.println("Error de carga");
        }
    }
    
    public void buscarPlato(MouseEvent event) {
        
        try {
            FXMLLoader loader = new FXMLLoader(ListaCategoriaController.
            class.getResource("/smartfood/screen/client/BusquedaPlatillo.fxml"));
            BorderPane page = (BorderPane) loader.load();
            Stage parent = (Stage) ((Node)event.getTarget()).getScene().getWindow();
            
            Stage dialogStage = new Stage();
            
            dialogStage.setTitle(parent.getTitle());
            dialogStage.initModality(Modality.WINDOW_MODAL);
//            dialogStage.getIcons().add(parent.getIcons().get(0));
            dialogStage.initOwner(((Node)event.getTarget()).getScene().getWindow());
            Scene scene = new Scene(page);
            dialogStage.setScene(scene);

            BusquedaPlatilloController controller = loader.getController();
            controller.setDialogStage(dialogStage);

            dialogStage.showAndWait();

        } catch (IOException e) {
            System.out.println("Error de carga");
        }
        
    }
    
    public void cerrarSesion(MouseEvent event) {
        try {
            this.handleScreenChanges(event, "/smartfood/screen/login/Login.fxml");
        } catch (IOException ex) {
            System.out.println("No cerró sesion");
        }
    }
    
    public void handleScreenChanges(MouseEvent event, String screenName) 
            throws IOException {
        Parent menu = FXMLLoader.load(getClass().getResource(screenName));
        Scene menuScene = new Scene(menu);
        this.appStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        appStage.close();
        appStage.setScene(menuScene);
        appStage.show();
    }
    
    
}
