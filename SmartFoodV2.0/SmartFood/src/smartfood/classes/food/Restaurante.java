/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package smartfood.classes.food;

/**
 *
 * @author Jose Masson
 */
public class Restaurante {
    
    private int idRestaurante;
    private String nombre;
    private String ubicacion;

    public Restaurante(int idRestaurante, String nombre, String ubicacion) {
        this.idRestaurante = idRestaurante;
        this.nombre = nombre;
        this.ubicacion = ubicacion;
    }

    public int getIdRestaurante() {
        return idRestaurante;
    }

    public void setIdRestaurante(int idRestaurante) {
        this.idRestaurante = idRestaurante;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }
    
//    public String obtenerNombreRestaurante(Conexion cn, int idRes) {
//        Conexion cn;
//
//           cn = new Conexion();
//
//
//           try {
//               FileInputStream x;
//               x = new FileInputStream(img);
//               CallableStatement cst = cn.getConnection().prepareCall("{call"
//                       + " actualizarImg(?, ?)}");
//               cst.setInt(1, 1);
//               cst.setBinaryStream(2, (InputStream) x, (int)img.length());
//               cst.execute(); 
//
//           } catch (SQLException ex) { 
//           }
//    }
    
}
