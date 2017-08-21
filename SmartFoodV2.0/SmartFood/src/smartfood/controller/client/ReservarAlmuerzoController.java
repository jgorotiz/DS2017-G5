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
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import smartfood.classes.alerts.GeneralAlert;
import smartfood.classes.alerts.WarningAlert;
import smartfood.classes.constants.Constantes;
import smartfood.classes.user.Usuario;
import smartfood.models.Almuerzo;

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
    
    private boolean cargado;
    
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
        this.cargado = true;
    }
    
    private void showAlmuerzoInfo() {
        this.nombreSopa.setText(this.almuerzo.getSopa());
        this.nombreSegundo.setText(this.almuerzo.getSegundo());
        this.costoAlmuerzo.setText(Double.toString(this.almuerzo.getCosto()));
        this.restaurante.setText(this.almuerzo.getRestaurante());
        this.tipoAlmuerzo.setText(this.almuerzo.getTipo());
        this.totalReserva.setText(Double.toString(this.almuerzo.getCosto()));
//        this.almuerzo.
        this.disableExtras();
    }
    
    private void disableExtras() {
        if (!this.tipoAlmuerzo.getText().equalsIgnoreCase("ejecutivo")) {
            this.bebida.setDisable(Constantes.DESACTIVAR_EXTRA);
            this.postre.setDisable(Constantes.DESACTIVAR_EXTRA);
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
}
