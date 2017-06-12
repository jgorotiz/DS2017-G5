/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package smartfood.controller.assistant;

import java.io.InputStream;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import smartfood.classes.connection.Conexion;
import smartfood.classes.food.Categoria;
import smartfood.classes.food.Plato;

/**
 *
 * @author Jose Masson
 */
public class ListarPlatillosController implements Initializable {

    private int idRestaurante;
    
    @FXML
    private TableView<Plato> platos;
    
    @FXML
    private TableColumn<Plato, String> nombrePlato;
    
    @FXML
    private TableColumn<Plato, String> nombreCategoria;
    
    @FXML
    private ObservableList<Plato> listaPlatos;
    
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        
        this.nombrePlato.
                setCellValueFactory(new PropertyValueFactory<>("nombre"));
        this.nombreCategoria.
                setCellValueFactory(new PropertyValueFactory<>("categoria"));
       
        
        this.nombrePlato.setStyle("-fx-alignment: CENTER;");
        this.nombreCategoria.setStyle("-fx-alignment: CENTER;");
        
        this.showCategoryResults();
    }
    
    private void showCategoryResults() {
        
        Conexion cn;
        
        ResultSet resultados;
       
        cn = new Conexion();
        
        try {
            
            this.idRestaurante = 1;
            
            resultados = Plato.getListadoXRestaurante(cn, this.idRestaurante);
            
            this.createDishList(resultados);
            
            this.platos.setItems(this.listaPlatos);
        }
        catch (Exception e) {
            System.out.println("No carga");
        }
        finally {
            try {
                cn.getConnection().close();
                
            } catch (SQLException ex) {
                System.out.println("Error en cierre de conexion");
            }
        }
        
    }
    
    private void createDishList(ResultSet r) throws SQLException {
        
        this.listaPlatos = FXCollections.observableArrayList();
        
        while (r.next()) {
            
            Integer idPlatillo = r.getInt(1);
            String nombre = r.getString(2);
            String descripcion = r.getString(3);
            String tipo = r.getString(4);
            String nomCategoria = r.getString(5);
            String restaurante = Integer.toString(this.idRestaurante);
            InputStream img = r.getBinaryStream(4);
            String serv = r.getString(7);
            Image imagen = new Image(img);
            
            
            Plato p;
            
            p = new Plato(idPlatillo, nombre, descripcion, imagen, nomCategoria, 
                    tipo, serv, restaurante);
            this.listaPlatos.add(p);
            
        }
        
    }
}
