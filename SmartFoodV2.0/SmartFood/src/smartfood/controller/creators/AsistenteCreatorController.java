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
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import smartfood.controller.assistant.AgregarPlatilloController;
import smartfood.controller.assistant.ListarCategoriasController;
import smartfood.controller.assistant.ListarPlatillosController;
import smartfood.controller.info.ListaCategoriaController;

/**
 *
 * @author Jose Masson
 */
public class AsistenteCreatorController implements Initializable {
    
    private Stage appStage;
    
    private int idRestaurante;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        
    }

    public void setAppStage(Stage appStage) {
        this.appStage = appStage;
    }

    public void setIdRestaurante(int idRestaurante) {
        this.idRestaurante = idRestaurante;
    }
    
    public void agregarPlato(MouseEvent event) {
        
        try {
            
            FXMLLoader loader = new FXMLLoader(ListaCategoriaController.
                    class.getResource("../../screen/assistant/AgregarPlatillo.fxml"));
            BorderPane page = (BorderPane) loader.load();
            Stage parent = (Stage) ((Node)event.getTarget()).getScene().getWindow();
            
            Stage dialogStage = new Stage();
            
            dialogStage.setTitle(parent.getTitle());
            dialogStage.initModality(Modality.WINDOW_MODAL);
//            dialogStage.getIcons().add(parent.getIcons().get(0));
            dialogStage.initOwner(((Node)event.getTarget()).getScene().getWindow());
            Scene scene = new Scene(page);
            dialogStage.setScene(scene);

            AgregarPlatilloController controller = loader.getController();
            controller.setDialogStage(dialogStage);
            controller.setIDRestaurante(this.idRestaurante);

            dialogStage.showAndWait();

        } catch (IOException e) {
            System.out.println("Error de carga");
        }
        
    }
    
    public void listarPlatos(MouseEvent event) {
        
        try {
            FXMLLoader loader = new FXMLLoader(ListaCategoriaController.
            class.getResource("../../screen/assistant/ListarPlatillos.fxml"));
            BorderPane page = (BorderPane) loader.load();
            Stage parent = (Stage) ((Node)event.getTarget()).getScene().getWindow();
            
            Stage dialogStage = new Stage();
            
            dialogStage.setTitle(parent.getTitle());
            dialogStage.initModality(Modality.WINDOW_MODAL);
//            dialogStage.getIcons().add(parent.getIcons().get(0));
            dialogStage.initOwner(((Node)event.getTarget()).getScene().getWindow());
            Scene scene = new Scene(page);
            dialogStage.setScene(scene);
            
            ListarPlatillosController controller = loader.getController();
//            loade
            controller.setIDRestaurante(this.idRestaurante);
            controller.setDialogStage(dialogStage);
            System.out.println("Este es de asistente creator " + this.idRestaurante);
            

            dialogStage.showAndWait();

        } catch (IOException e) {
            System.out.println("Error de carga");
        }
        
    }
    
    public void listarCategorias(MouseEvent event) {
        
        try {
            FXMLLoader loader = new FXMLLoader(ListaCategoriaController.
            class.getResource("../../screen/assistant/ListarCategorias.fxml"));
            BorderPane page = (BorderPane) loader.load();
            Stage parent = (Stage) ((Node)event.getTarget()).getScene().getWindow();
            
            Stage dialogStage = new Stage();
            
            dialogStage.setTitle(parent.getTitle());
            dialogStage.initModality(Modality.WINDOW_MODAL);
//            dialogStage.getIcons().add(parent.getIcons().get(0));
            dialogStage.initOwner(((Node)event.getTarget()).getScene().getWindow());
            Scene scene = new Scene(page);
            dialogStage.setScene(scene);

            ListarCategoriasController controller = loader.getController();
            controller.setDialogStage(dialogStage);
            controller.setIDRestaurante(this.idRestaurante);

            dialogStage.showAndWait();

        } catch (IOException e) {
            System.out.println("Error de carga");
        }
        
    }
    
    public void cerrarSesion() {
        
    }
    
}
