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
import java.util.regex.Matcher;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.ButtonType;
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
import smartfood.classes.alerts.ConfirmationAlert;
import smartfood.classes.alerts.GeneralAlert;
import smartfood.classes.alerts.InfoAlert;
import smartfood.classes.alerts.WarningAlert;
import smartfood.classes.connection.Conexion;
import smartfood.classes.constants.Constantes;
import smartfood.classes.food.Plato;
import smartfood.classes.validaciones.Validaciones;
import smartfood.controller.info.ListaCategoriaController;
import smartfood.controller.info.PlatilloInfoController;
import smartfood.interfaces.OpcionesBotones;

/**
 *
 * @author Jose Masson
 */
public class BusquedaPlatilloController implements Initializable, 
        OpcionesBotones {

    private Stage app;
    
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
    
    private boolean busquedaValida;
    
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        this.choiceBox.getItems().addAll("Nombre", "Descripción");
        
        this.nombrePlatillo.
                setCellValueFactory(new PropertyValueFactory<>("nombre"));
        this.nombreRestaurante.
                setCellValueFactory(new PropertyValueFactory<>("restaurante"));
        
        Validaciones.addTextLimiter(searchBox, Constantes.MAX_LENGHT_DESCRIP);
    }
    
    @Override
    public void salir() {
        ConfirmationAlert confirmation = new ConfirmationAlert();
        
        confirmation.setMensaje("¿Desea salir del sistema?");
        confirmation.showAlert();
        
        if (confirmation.getResult().get() == ButtonType.OK) {
            GeneralAlert g;
            g = new InfoAlert();
            g.setMensaje("Usted ha salido del sistema");
            g.showAlert();
            System.exit(0);
        }
        
    }
    
    public void showResults() {
        
        Conexion cn;
        
        cn = new Conexion();
        
        String texto;
        
        texto = (String) this.choiceBox.getSelectionModel().getSelectedItem();
        
        ResultSet r;
        
        GeneralAlert g;
        
        try {
            
            
            if (texto == null) {
                g = new WarningAlert(null, "Seleccione un criterio");
                g.showAlert();
            }
            else {
                
                texto = texto.trim();
                
                this.busquedaValida = this.esValido();
                
                String bus;
                    
                bus = this.searchBox.getText().trim();
                
                if (this.busquedaValida) {
                    if (texto.equals("Nombre")) {
                        r = Plato.getListadoXNombre(cn, bus);
                        this.createDishList(r);
                    }
                    else if (texto.equals("Descripción")) {
                        r = Plato.getListadoXDescripcion(cn, bus);
                        this.createDishList(r);
                    }
                    
                    int totalItems;
                    
                    totalItems = this.listaPlatillos.size();
                    
                    GeneralAlert info = new InfoAlert();
                    
                    info.setEncabezado(null);
                    info.setMensaje("Se han encontrado " + 
                            Integer.toString(totalItems) + " registro(s)");
                    
                    info.showAlert();
                    this.table.setItems(listaPlatillos);

                    
                }
                else {
                    
                    if (this.listaPlatillos != null) {
                        this.table.getItems().removeAll(listaPlatillos);
                        this.table.refresh();
                    }
                    
                    g = new WarningAlert(null, "Valor no válido");
                    g.showAlert();
                }
            }
            
        }
        catch (Exception e) {
            g = new WarningAlert(null, "Error inesperado");
            g.showAlert();
        }
        finally {
            try {
                cn.getConnection().close();
                
            } catch (SQLException ex) {
                g = new WarningAlert(null, "Error en el cierre de conexión");
                g.showAlert();
            }
        }
        
        this.clearSearchBox();
        
    }
    
    private void clearSearchBox() {
        this.searchBox.clear();
    }
    
    private boolean esValido() {
        String bus;
        
        bus = this.searchBox.getText().trim();
        
        Matcher match = Validaciones
                .obtenerMatcher("[A-Za-z0-9\\p{Punct}\\p{L}\\s]?+(\\s?[A-Za-z0-9"
                        + "\\p{Punct}\\p{L}]*){1,30}", bus);
        
        if (bus.length() != 0) {
            return match.matches();
        }
        return false;

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
                    class.getResource("/smartfood/screen/info/PlatilloInfo.fxml"));
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

    public void setDialogStage(Stage dialogStage) {
        this.app = dialogStage;
    }
    
    @FXML
    public void volver() {
        this.app.close();
    }
}
