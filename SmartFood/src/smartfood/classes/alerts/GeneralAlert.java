/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package smartfood.classes.alerts;

/**
 *
 * @author Jose Masson
 */
public abstract class GeneralAlert {
    
    private String encabezado;
    
    private String mensaje;

    public GeneralAlert(String encabezado, String mensaje) {
        this.encabezado = encabezado;
        this.mensaje = mensaje;
    }

    public String getEncabezado() {
        return encabezado;
    }

    public void setEncabezado(String encabezado) {
        this.encabezado = encabezado;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }
    
    public abstract void showAlert();
    
}
