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
                setCellValueFactory(new PropertyValueFactory<>("nombreCategoria"));
       
        
        this.nombrePlato.setStyle("-fx-alignment: CENTER;");
        this.nombreCategoria.setStyle("-fx-alignment: CENTER;");
        
        this.showCategoryResults();
    }
    
    private void showCategoryResults() {
        
        Conexion cn;
        
        ResultSet resultados;
       
        cn = new Conexion();
        
        try {
            
            resultados = Categoria.getCategorias(cn);
            
            this.createDishList(resultados);
            
            this.platos.setItems(this.listaPlatos);
        }
        catch (Exception e) {
            
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
            
            String nombre = r.getString(1);
            String descripcion = r.getString(2);
            String tipo = r.getString(3);
            String nomCategoria = r.getString(4);
            String nombreRestaurante = r.getString(5);
            InputStream img = r.getBinaryStream(6);
            Image imagen = new Image(img);
            
            
            Plato p;
            
            p = new Plato(nombre, descripcion, tipo, nomCategoria, 
                    nombreRestaurante, imagen);
            
            this.listaPlatos.add(p);
            
        }
        
    }
}
