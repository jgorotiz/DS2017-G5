/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package smartfood.controller.creators;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.TextAlignment;
import javafx.stage.Modality;
import javafx.stage.Stage;
import smartfood.classes.alerts.ConfirmationAlert;
import smartfood.classes.alerts.GeneralAlert;
import smartfood.classes.alerts.InfoAlert;
import smartfood.classes.alerts.WarningAlert;
import smartfood.classes.food.Restaurante;
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
    
    private Restaurante res;
    
    private int idRestaurante;
    
    @FXML
    private Label restaurante;
    
    @FXML
    private Label nombreRestaurante;
    
    @FXML
    private Label encabezado;
    
    @FXML
    private Button boton1;
    
    @FXML
    private Button boton2;
    
    @FXML
    private Button boton3;
    
    @FXML
    private Button boton4;
    
    @FXML
    private GridPane grid;
    
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        Image boton = new Image(new File("src/smartfood/images/etimadera.png").toURI().toString());
        this.boton1.setBackground(new Background(new BackgroundImage(boton, 
                BackgroundRepeat.NO_REPEAT, BackgroundRepeat.REPEAT, BackgroundPosition.CENTER, BackgroundSize.DEFAULT)));
        this.boton1.setMaxSize(200, 140);
        this.boton1.setPrefSize(200, 140);
        this.boton1.setFont(Font.font(null, FontWeight.BOLD, 20));
        this.boton1.setTextFill(Color.DARKBLUE);
        this.boton1.setTextAlignment(TextAlignment.CENTER);
        this.boton2.setBackground(new Background(new BackgroundImage(boton, 
                BackgroundRepeat.NO_REPEAT, BackgroundRepeat.REPEAT, BackgroundPosition.CENTER, BackgroundSize.DEFAULT)));
        this.boton2.setMaxSize(200, 140);
        this.boton2.setPrefSize(200, 140);
        this.boton2.setFont(Font.font(null, FontWeight.BOLD, 20));
        this.boton2.setTextFill(Color.DARKBLUE);
        this.boton2.setTextAlignment(TextAlignment.CENTER);
        this.boton3.setBackground(new Background(new BackgroundImage(boton, 
                BackgroundRepeat.NO_REPEAT, BackgroundRepeat.REPEAT, BackgroundPosition.CENTER, BackgroundSize.DEFAULT)));
        this.boton3.setMaxSize(200, 140);
        this.boton3.setPrefSize(200, 140);
        this.boton3.setFont(Font.font(null, FontWeight.BOLD, 20));
        this.boton3.setTextFill(Color.DARKBLUE);
        this.boton3.setTextAlignment(TextAlignment.CENTER);
        
        this.boton4.setBackground(new Background(new BackgroundImage(boton, 
                BackgroundRepeat.NO_REPEAT, BackgroundRepeat.REPEAT, BackgroundPosition.CENTER, BackgroundSize.DEFAULT)));
        this.boton4.setMaxSize(200, 140);
        this.boton4.setPrefSize(200, 140);
        this.boton4.setFont(Font.font(null, FontWeight.BOLD, 20));
        this.boton4.setTextFill(Color.DARKBLUE);
        this.boton4.setTextAlignment(TextAlignment.CENTER);
        
        this.restaurante.setFont(new Font("Cambria", 40));
        this.restaurante.setTextAlignment(TextAlignment.CENTER);
        this.restaurante.setTextFill(Color.DARKRED);
        
        this.nombreRestaurante.setFont(new Font("Cambria", 30));
        this.nombreRestaurante.setTextAlignment(TextAlignment.CENTER);
        this.nombreRestaurante.setTextFill(Color.TOMATO);
        
        this.encabezado.setFont(new Font("Cambria", 40));
        this.encabezado.setTextAlignment(TextAlignment.CENTER);
        this.encabezado.setTextFill(Color.DARKRED);
        
        Image fondo = new Image(new File("src/smartfood/images/gastronomy.jpg").toURI().toString());
        this.grid.setBackground(new Background(new BackgroundImage(fondo, BackgroundRepeat.NO_REPEAT,
                BackgroundRepeat.REPEAT, BackgroundPosition.CENTER, BackgroundSize.DEFAULT)));
    }

    public void setAppStage(Stage appStage) {
        this.appStage = appStage;
    }

    public void setIdRestaurante(int idRestaurante) {
        this.idRestaurante = idRestaurante;
    }
    
    public void setRestaurante(Restaurante res) {
        this.res = res;
    }
    
    public void setNombreRestaurante(String nombre) {
        this.nombreRestaurante.setText(nombre);
    }
    
    public void agregarPlato(MouseEvent event) {
        
        try {
            
            FXMLLoader loader = new FXMLLoader(ListaCategoriaController.
                    class.getResource("/smartfood/screen/assistant/AgregarPlatillo.fxml"));
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
            controller.setIDRestaurante(this.res.getIdRestaurante());

            dialogStage.showAndWait();

        } catch (IOException e) {
            System.out.println("Error de carga");
        }
        
    }
    
    public void listarPlatos(MouseEvent event) {
        
        try {
            FXMLLoader loader = new FXMLLoader(ListaCategoriaController.
            class.getResource("/smartfood/screen/assistant/ListarPlatillos.fxml"));
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
            controller.setIDRestaurante(this.res.getIdRestaurante());
            controller.setDialogStage(dialogStage);

            dialogStage.showAndWait();

        } catch (IOException e) {
            System.out.println("Error de carga");
        }
        
    }
    
    public void listarCategorias(MouseEvent event) {
        
        try {
            FXMLLoader loader = new FXMLLoader(ListaCategoriaController.
            class.getResource("/smartfood/screen/assistant/ListarCategorias.fxml"));
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
            controller.setIDRestaurante(this.res.getIdRestaurante());
            controller.setDialogStage(dialogStage);
            

            dialogStage.showAndWait();

        } catch (IOException e) {
            System.out.println("Error de carga");
        }
        
    }
    
    public void cerrarSesion(MouseEvent event) {
        
        GeneralAlert g;
        
        try {
            
            ConfirmationAlert confirmation = new ConfirmationAlert();
        
            confirmation.setMensaje("¿Desea cerrar sesión?");
            confirmation.showAlert();
        
            if (confirmation.getResult().get() == ButtonType.OK) {
                
                g = new InfoAlert();
                g.setMensaje("Usted ha cerrado sesión con éxito");
                g.showAlert();
                
                this.handleScreenChanges(event, "/smartfood/screen/login/Login.fxml");
        }

        } catch (IOException ex) {
            g = new WarningAlert();
            g.setMensaje("No ha cerrado sesión");
            g.showAlert();
            
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
