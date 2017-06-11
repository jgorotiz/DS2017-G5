/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package smartfood.controller.info;

import smartfood.controller.client.*;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import smartfood.classes.connection.Conexion;
import smartfood.classes.food.Categoria;

/**
 *
 * @author Jose Masson
 */
public class ListaCategoriaController implements Initializable {
    
    @FXML
    private TextField searchBox;
    
    @FXML
    private TableView<Categoria> table;
    
    @FXML
    private TableColumn<Categoria, String> nombreCategoria;
    
    @FXML
    private TableColumn<Categoria, Integer> totalPlatillos;
    
    @FXML
    private ObservableList<Categoria> categorias; 
   
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        
        this.nombreCategoria.
                setCellValueFactory(new PropertyValueFactory<>("nombreCategoria"));
        this.totalPlatillos.
                setCellValueFactory(new PropertyValueFactory<>("totalPlatillos"));
        
        this.totalPlatillos.setStyle("-fx-alignment: CENTER-RIGHT;");
        
        this.showResults();
    }
    
    private void showResults() {
        
        Conexion cn;
        
        ResultSet resultados;
       
        cn = new Conexion();
        
        try {
            
            resultados = Categoria.getCategorias(cn);
            
            this.createList(resultados);
            
            this.table.setItems(categorias);
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
    
    private void createList(ResultSet r) throws SQLException {
        
        this.categorias = FXCollections.observableArrayList();
        
        while (r.next()) {
            Integer totPlatillos = r.getInt(1);
            String nomCategoria = r.getString(2);
            
            Categoria c;
            
            c = new Categoria(nomCategoria, totPlatillos);
            
            this.categorias.add(c);
            
        }

    }
    
}
