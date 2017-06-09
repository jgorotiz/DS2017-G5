/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package smartfood.classes.food;

import java.sql.Date;

/**
 *
 * @author Jose Masson
 */
public class Tipo {
    
    private int idTipo;
    private String nombreTipo;
    private Date fechaRegistro;

    public Tipo(int idTipo, String nombreTipo, Date fechaRegistro) {
        this.idTipo = idTipo;
        this.nombreTipo = nombreTipo;
        this.fechaRegistro = fechaRegistro;
    }

    public int getIdTipo() {
        return idTipo;
    }

    public void setIdTipo(int idTipo) {
        this.idTipo = idTipo;
    }

    public String getNombreTipo() {
        return nombreTipo;
    }

    public void setNombreTipo(String nombreTipo) {
        this.nombreTipo = nombreTipo;
    }

    public Date getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(Date fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }
    
}
