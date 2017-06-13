/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package smartfood.prueba;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.net.URL;
import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;
import javafx.stage.Stage;
import smartfood.classes.connection.Conexion;

/**
 *
 * @author Jose Masson
 */
public class ImagenPruebaController implements Initializable {
    
    @FXML
    private ImageView imagen;
    
//    public void seleccionarImagen(MouseEvent event) {
//        FileChooser fileChooser = new FileChooser();
//        fileChooser.setTitle("Abrir Imagen");
//        fileChooser.getExtensionFilters().addAll(
//                new ExtensionFilter("Text Files", "*.txt"),
//                new ExtensionFilter("Image Files", "*.png", "*.jpg", "*.gif"),
//                new ExtensionFilter("Audio Files", "*.wav", "*.mp3", "*.aac"),
//                new ExtensionFilter("All Files", "*.*"));
//        File selectedFile = fileChooser.showOpenDialog((Stage) ((Node) event.getSource()).getScene().getWindow());
//        
//        if (selectedFile != null) {
//            
//            Image img = new Image(selectedFile.toURI().toString());
//            imagen.setImage(img);
//            
//            this.guardarImagen(selectedFile);
//            System.out.println("Imagen guardada con éxito");
//            
//        }
//        
//    }
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        this.obtenerImagen();
    }
    
    private void guardarImagen(File img) {
        Conexion cn;
        
        cn = new Conexion();
        
        
        try {
            FileInputStream x;
            x = new FileInputStream(img);
            CallableStatement cst = cn.getConnection().prepareCall("{call"
                    + " actualizarImg(?, ?)}");
            cst.setInt(1, 1);
            cst.setBinaryStream(2, (InputStream) x, (int)img.length());
            cst.execute(); 

        } catch (SQLException ex) { 
        } catch (FileNotFoundException ex) {
            Logger.getLogger(ImagenPruebaController.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally {
            try {
                cn.getConnection().close();
            } catch (SQLException ex) {
                Logger.getLogger(ImagenPruebaController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    private void obtenerImagen() {
        Conexion cn;
        cn = new Conexion();
        
        try {
            
            CallableStatement cst;
            System.out.println("Joder la vida");
            cst = cn.getConnection().prepareCall("{call"
                    + " obtenerImg(?, ?)}");
            cst.setInt(1, 1);
            
            cst.execute(); 
            
            System.out.println("Hola SmartFood");
            
            cst.registerOutParameter(2, java.sql.Types.BINARY);
            
            InputStream is;
            is = cst.getBlob(2).getBinaryStream();
            
            Image image = new Image(is);
            
            this.imagen.setImage(image);
            
        } catch (SQLException ex) {
            System.out.println("No carga imagen");
        }
        finally {
            try {
                cn.getConnection().close();
            } catch (SQLException ex) {
                Logger.getLogger(ImagenPruebaController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }   
        
    }
    
}
