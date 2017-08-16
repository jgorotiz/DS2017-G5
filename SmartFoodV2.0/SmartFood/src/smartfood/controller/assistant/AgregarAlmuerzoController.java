/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package smartfood.controller.assistant;

import java.io.File;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Calendar;
import java.util.Date;
import java.util.ResourceBundle;
import java.util.regex.Matcher;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import smartfood.classes.alerts.ConfirmationAlert;
import smartfood.classes.alerts.GeneralAlert;
import smartfood.classes.alerts.InfoAlert;
import smartfood.classes.alerts.WarningAlert;
import smartfood.classes.connection.Conexion;
import smartfood.classes.constants.Constantes;
import smartfood.classes.food.Categoria;
import smartfood.classes.food.Plato;
import smartfood.classes.food.Servido;
import smartfood.classes.food.Tipo;
import smartfood.classes.validaciones.Validaciones;

/**
 *
 * @author jlmp1
 */
public class AgregarAlmuerzoController implements Initializable {

    @FXML
    private TextField nombreSopa;
    
    @FXML
    private TextField nombreSegundo;
    
    @FXML
    private TextField costoAlmuerzo;
    
    @FXML
    private ComboBox tipoAlmuerzo;
    
    private boolean ingresoValido;
    
    private boolean imagenValida;
    
    private int idRestaurante;
    
    private Stage app;
    
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        
        Validaciones.addTextLimiter(this.nombreSopa, Constantes.MAX_LENGHT_TEXT);
        Validaciones.addTextLimiter(this.nombreSegundo, 
                Constantes.MAX_LENGHT_DESCR);
        this.fillType();
    }
    
    private void fillType() {
        this.tipoAlmuerzo.getItems().addAll(
            "Estudiantil",
            "Ejecutivo");
    }
    
    private String obtenerTipo() {
        String t;
        
        t = (String) this.tipoAlmuerzo.getSelectionModel().getSelectedItem();
        
        return t;
    }
    
    public void guardarAlmuerzo() {
        this.agregarAlmuerzo();
    }
    
    private void agregarAlmuerzo() {
        
        Conexion cn;
        
        cn = new Conexion();
        
        String sopa = this.nombreSopa.getText();
        String segundo = this.nombreSegundo.getText();
        String tipo = this.obtenerTipo();
        float costo = Float.parseFloat(this.costoAlmuerzo.getText());
        
        System.out.println("Hola Mundo");
    }
    
//    public void agregarPlato() {
//        this.agregarPlatillo();
//    }
//    
//    private void agregarPlatillo() {
//        
//        Conexion cn;
//        
//        cn = new Conexion();
//        
//        String nombre = this.nombrePlatillo.getText();
//        String desc = this.descripcionPlatillo.getText();
//        
//        Categoria c = this.obtenerCategoria();
//        Tipo tip = this.obtenerTipo();
//        Servido s = this.obtenerServido();
//        
//        
//        boolean existePlato;
//        
//        existePlato = Plato.existePlatillo(nombre, this.idRestaurante);
//        
//        this.ingresoValido = this.validarIngreso(nombre, desc, 
//                this.obtenerCategoria(), s, tip);
//        
//        if (!this.ingresoValido && !existePlato) {
//            this.mostrarNoExito("Platillo no ha sido agregado con éxito");
//        }
//        else if (this.ingresoValido && !existePlato) {
//            
//            Integer categoria = c.getIdCategoria();
//            Integer tipo = tip.getIdTipo();
//            Integer servido = s.getIdServido();
//            
//            Integer res = this.idRestaurante;
//    //        InputStream img = Plato.obtenerBinarioImagen(file);
//
//            Date utilDate = new Date();
//            Calendar cal = Calendar.getInstance();
//            cal.setTime(utilDate);
//            cal.set(Calendar.MILLISECOND, 0);
//
//            Timestamp t;
//
//            t = new Timestamp(cal.getTimeInMillis());
//            
//            Plato p = new Plato(nombre, desc, this.file, Integer.toString(categoria),
//                Integer.toString(tipo), Integer.toString(servido), 
//                    Integer.toString(res), t);
//
//            ConfirmationAlert confirmation = new ConfirmationAlert();
//
//            confirmation.setMensaje("¿Desea agregar el platillo al restaurante?");
//            confirmation.showAlert();
//
//            if (confirmation.getResult().get() == ButtonType.OK) {
//                Plato.agregarPlatillo(cn, p);
//
//                this.limpiarCampos();
//                this.mostrarExito();
//                
//            }
//            
//            
//        }
//        else if(this.ingresoValido && existePlato) {
//            this.mostrarNoExito("Platillo ya existe en el restaurante");
//        }
//        
//    }

    public void setIDRestaurante(int idRestaurante) {
        this.idRestaurante = idRestaurante;
    }

    public void setDialogStage(Stage dialogStage) {
        this.app = dialogStage;
    }
    
    @FXML
    public void volver() {
        this.app.close();
    }
    
    private void mostrarExito() {
        
        GeneralAlert g;
        
        g = new InfoAlert();
        
        g.setMensaje("Almuerzo agregado con éxito");
        
        g.showAlert();
        
    }
    
    private void mostrarNoExito(String s) {
        
        GeneralAlert g;
        
        g = new WarningAlert();
        
        g.setMensaje(s);
        
        g.showAlert();
        
    }
    
    private void limpiarCampos() {
        this.nombreSopa.setText("");
        this.nombreSegundo.setText("");
        this.costoAlmuerzo.setText("");
        this.tipoAlmuerzo.getSelectionModel().clearSelection();
    }
    
    private boolean validarIngreso(String n, String des, Categoria c,
            Servido s, Tipo t) {
        
        return (c != null && s != null && t != null && this.imagenValida
                && this.validarDescripcion(des) 
                && this.validarNombrePlatillo(n));
        
    }
    
    private boolean validarDescripcion(String des) {
        
        Matcher encajaDescripcion;
        encajaDescripcion = Validaciones.obtenerMatcher(".{1,200}", des);

        return encajaDescripcion.matches();
        
    }
    
    private boolean validarNombrePlatillo(String n) {
        
        Matcher encajaNombre;
        encajaNombre = Validaciones.obtenerMatcher("[A-Za-z\\p{Punct}\\p{L}\\s]"
                + "?+(\\s?[A-Za-z0-9\\p{Punct}\\p{L}]*){1,30}", n);
        return encajaNombre.matches();
        
    }
    
}
