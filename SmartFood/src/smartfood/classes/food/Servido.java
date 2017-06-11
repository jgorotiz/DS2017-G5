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
public class Servido {
    
    private int idServido;
    private String nombreServido;
    private Date fechaRegistro;

    public Servido(int idServido, String nombreServido, Date fechaRegistro) {
        this.idServido = idServido;
        this.nombreServido = nombreServido;
        this.fechaRegistro = fechaRegistro;
    }

    public Servido(int idServido, String nombreServido) {
        this.idServido = idServido;
        this.nombreServido = nombreServido;
    }

    public int getIdServido() {
        return idServido;
    }

    public void setIdServido(int idServido) {
        this.idServido = idServido;
    }

    public String getNombreServido() {
        return nombreServido;
    }

    public void setNombreServido(String nombreServido) {
        this.nombreServido = nombreServido;
    }

    public Date getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(Date fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }
    
    @Override
    public String toString() {
        return this.nombreServido;
    }
    
}
