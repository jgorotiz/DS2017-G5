/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package smartfood.controller.client;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import smartfood.classes.alerts.GeneralAlert;
import smartfood.classes.alerts.WarningAlert;
import smartfood.classes.constants.Constantes;
import smartfood.classes.user.Usuario;
import smartfood.models.Almuerzo;
import smartfood.models.Bebida;
import smartfood.models.Postre;

/**
 *
 * @author jlmp1
 */
public class ReservarAlmuerzoController implements Initializable {
    
    private Usuario usuario;
    
    private Stage appStage;
    
    private Almuerzo almuerzo;
    
    @FXML
    private TextField nombreSopa;
    
    @FXML
    private TextField nombreSegundo;
    
    @FXML
    private TextField tipoAlmuerzo;
    
    @FXML
    private TextField restaurante;
    
    @FXML
    private TextField costoAlmuerzo;
    
    @FXML
    private TextField totalReserva;
    
    @FXML
    private CheckBox bebida;
    
    @FXML
    private CheckBox postre;
    
    @FXML
    private ComboBox tipoPago;
    
    private boolean cargado;
    
    private boolean bebidaAgregada;
    
    private boolean postreAgregado;
    
    private boolean extrasHabilitados;

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
    
    public void setDialogStage(Stage dialogStage) {
        this.appStage = dialogStage;
    }
    
    public void setAlmuerzo(Almuerzo a) {
        this.almuerzo = a;
    }
    
    @FXML
    public void volver() {
        this.appStage.close();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        this.disableExtras();
        this.createPays();
        this.tipoPago.setDisable(Constantes.DESACTIVAR_EXTRA);
        this.cargado = true;
    }
    
    private void showAlmuerzoInfo() {
        this.enableExtras();
        this.nombreSopa.setText(this.almuerzo.getSopa());
        this.nombreSegundo.setText(this.almuerzo.getSegundo());
        this.costoAlmuerzo.setText(this.formatearDecimal(this.almuerzo.getCosto()));
        this.restaurante.setText(this.almuerzo.getRestaurante());
        this.tipoAlmuerzo.setText(this.almuerzo.getTipo());
        this.totalReserva.setText(this.formatearDecimal(this.almuerzo.getCosto()));
        this.tipoPago.setDisable(!Constantes.DESACTIVAR_EXTRA);
        this.disableExtrasXTipo();
    }
    
    private void createPays() {
        this.tipoPago.getItems().addAll(
        "Tarjeta de Crédito",
        "Carné Estudiantil");

    }
    
    private void enableExtras() {
        this.bebida.setDisable(!Constantes.DESACTIVAR_EXTRA);
        this.postre.setDisable(!Constantes.DESACTIVAR_EXTRA);
    }
     
    private void disableExtras() {
        this.bebida.setDisable(Constantes.DESACTIVAR_EXTRA);
        this.postre.setDisable(Constantes.DESACTIVAR_EXTRA);
    }
    
    private void disableExtrasXTipo() {
        if (!this.tipoAlmuerzo.getText().equalsIgnoreCase("ejecutivo")) {
            this.disableExtras();
        }
    }
    
    public void loadAlmuerzoInfo() {
        
        if (this.cargado) {
            
            this.showAlmuerzoInfo();
            
            this.cargado = false;
            
        }
        else {
            
            GeneralAlert g;
            
            g = new WarningAlert();
            
            g.setMensaje("Ya se ha cargado la información del almuerzo");
            
            g.showAlert();
        
        }
        
    }
    
    public void agregarBebida(MouseEvent e) throws CloneNotSupportedException {
        
        Almuerzo a;
        
        a = (Almuerzo) this.almuerzo.clone();
        
        if (this.postreAgregado) {
            a = new Postre(a);
        }
        
        if (this.bebida.isSelected()) {
            this.bebidaAgregada = true;
            a = new Bebida(a);
            
            
        }
        else {
            this.bebidaAgregada = false;
        }
        this.totalReserva.setText(this.formatearDecimal(a.getCosto()));
    }

    public void agregarPostre(MouseEvent e) throws CloneNotSupportedException {
        
        Almuerzo a;
        
        a = (Almuerzo) this.almuerzo.clone();
        
        if (this.bebidaAgregada) {
            a = new Bebida(a);
        }
        
        if (this.postre.isSelected()) {
            this.postreAgregado = true;
            a = new Postre(a);            
        }
        else {
            this.postreAgregado = false;
        }
        
        this.totalReserva.setText(this.formatearDecimal(a.getCosto()));
        
    }
    
    private String formatearDecimal(double decimal) {
        return String.format("%.2f", decimal);
    }
}
