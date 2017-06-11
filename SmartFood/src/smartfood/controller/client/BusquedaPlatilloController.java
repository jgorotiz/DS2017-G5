/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package smartfood.controller.client;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import smartfood.classes.alerts.GeneralAlert;
import smartfood.classes.alerts.WarningAlert;
import smartfood.classes.connection.Conexion;
import smartfood.classes.food.Plato;
import smartfood.controller.info.ListaCategoriaController;
import smartfood.controller.info.PlatilloInfoController;

/**
 *
 * @author Jose Masson
 */
public class BusquedaPlatilloController implements Initializable {

    @FXML
    private ComboBox choiceBox;
    
    @FXML
    private TextField searchBox;
    
    @FXML
    private TableView<Plato> table;
    
    @FXML
    private TableColumn<Plato, String> nombrePlatillo;
    
    @FXML
    private TableColumn<Plato, String> nombreRestaurante;
    
    @FXML
    private ObservableList<Plato> listaPlatillos;
    
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        this.choiceBox.getItems().addAll("Nombre", "Descripción");
        
        this.nombrePlatillo.
                setCellValueFactory(new PropertyValueFactory<>("nombre"));
        this.nombreRestaurante.
                setCellValueFactory(new PropertyValueFactory<>("restaurante"));
    }
    
    public void showResults() {
        
        Conexion cn;
        
        cn = new Conexion();
        
        String texto;
        
        texto = (String) this.choiceBox.getSelectionModel().getSelectedItem();
        
        ResultSet r;
        
        try {
            
            if (texto == null) {
                GeneralAlert g = new WarningAlert(null, "Seleccione un criterio");
                g.showAlert();
            }
            else {
                if (texto.equals("Nombre")) {
                    r = Plato.getListadoXNombre(cn, this.searchBox.getText());
                    this.createDishList(r);
                }
                else if (texto.equals("Descripción")) {
                    r = Plato.getListadoXDescripcion(cn, this.searchBox.getText());
                    this.createDishList(r);
                }
                
                this.table.setItems(listaPlatillos);
            }
            
            
        }
        catch (Exception e) {
            
        }
        finally {
            try {
                cn.getConnection().close();
                
            } catch (SQLException ex) {
                System.out.println("Error en cierre de conexion");
            }
        }
        
        this.clearSearchBox();
        
    }
    
    private void clearSearchBox() {
        this.searchBox.clear();
    }
    
    public void showDishInfo(MouseEvent event) {
        
        Plato p;
        
        p = this.table.getSelectionModel().getSelectedItem();
        if (p != null) {
            this.showDishInfo(p, event);
        }
        else {
            GeneralAlert g = new WarningAlert(null, "Seleccione un platillo");
            g.showAlert();
        }
    }
    
    private void showDishInfo(Plato p, MouseEvent event) {
        try {
            
            FXMLLoader loader = new FXMLLoader(ListaCategoriaController.
                    class.getResource("../../screen/info/PlatilloInfo.fxml"));
            BorderPane page = (BorderPane) loader.load();
            Stage parent = (Stage) ((Node)event.getTarget()).getScene().getWindow();
            
            Stage dialogStage = new Stage();
            
            dialogStage.setTitle(parent.getTitle());
            dialogStage.initModality(Modality.WINDOW_MODAL);
//            dialogStage.getIcons().add(parent.getIcons().get(0));
            dialogStage.initOwner(((Node)event.getTarget()).getScene().getWindow());
            Scene scene = new Scene(page);
            dialogStage.setScene(scene);

            PlatilloInfoController controller = loader.getController();
            controller.setDialogStage(dialogStage);
            controller.setPlato(p);

            dialogStage.showAndWait();

        } catch (IOException e) {
           
        }
        
    }
    
    private void createDishList(ResultSet r) throws SQLException {
        
        this.listaPlatillos = FXCollections.observableArrayList();
        
        while (r.next()) {
            
            String nombre = r.getString(1);
            String descripcion = r.getString(2);
            String tipo = r.getString(3);
            String nomCategoria = r.getString(4);
            String nomRestaurante = r.getString(5);
            InputStream img = r.getBinaryStream(6);
            Image imagen = new Image(img);
            
            
            Plato p;
            
            p = new Plato(nombre, descripcion, tipo, nomCategoria, 
                    nomRestaurante, imagen);
            
            this.listaPlatillos.add(p);
            
        }
        
    }
}
