/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package smartfood.controller.info;


import java.io.File;
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
import javafx.scene.input.MouseEvent;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;
import javafx.stage.Stage;
import smartfood.classes.alerts.GeneralAlert;
import smartfood.classes.alerts.WarningAlert;
import smartfood.classes.connection.Conexion;
import smartfood.classes.food.Categoria;
import smartfood.classes.food.Plato;

/**
 *
 * @author Jose Masson
 */
public class ListaCategoriaController implements Initializable {
    
    @FXML
    private TableView<Categoria> categorias;
    
    @FXML
    private TableView<Plato> platillos;
    
    @FXML
    private TableColumn<Categoria, String> nombreCategoria;
    
    @FXML
    private TableColumn<Categoria, Integer> totalPlatillos;
   
    @FXML
    private TableColumn<Plato, String> nombrePlato;
    
    @FXML
    private TableColumn<Plato, String> nomRestaurante;
    
    @FXML
    private ObservableList<Categoria> listaCategorias;
    
    @FXML
    private ObservableList<Plato> listaPlatillos;
    
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        
        this.nombreCategoria.
                setCellValueFactory(new PropertyValueFactory<>("nombreCategoria"));
        this.totalPlatillos.
                setCellValueFactory(new PropertyValueFactory<>("totalPlatillos"));
        
        this.totalPlatillos.setStyle("-fx-alignment: CENTER-RIGHT;");
        
        this.nombrePlato
                .setCellValueFactory(new PropertyValueFactory<>("nombre"));
        
        this.nomRestaurante
                .setCellValueFactory(new PropertyValueFactory<>("restaurante"));
        
        this.showCategoryResults();
    }
    
    private void showCategoryResults() {
        
        Conexion cn;
        
        ResultSet resultados;
       
        cn = new Conexion();
        
        try {
            
            resultados = Categoria.getCategorias(cn);
            
            this.createCategoryList(resultados);
            
            this.categorias.setItems(listaCategorias);
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
    
    private void showDishResults(Categoria c) {
        Conexion cn;
        
        ResultSet resultados;
       
        cn = new Conexion();
        
        try {
            
            resultados = Plato.getListadoXCategoria(cn, c.getIdCategoria());
            
            this.createDishList(resultados);
            
            this.platillos.setItems(this.listaPlatillos);
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
    
    private void createCategoryList(ResultSet r) throws SQLException {
        
        this.listaCategorias = FXCollections.observableArrayList();
        
        while (r.next()) {
            
            Integer idPlatillo = r.getInt(1);
            String nomCategoria = r.getString(3);
            Integer totPlatillos = r.getInt(2);
            
            
            Categoria c;
            
            c = new Categoria(nomCategoria, totPlatillos, idPlatillo);
            
            System.out.println(c);
            
            this.listaCategorias.add(c);
            
        }

    }
    
    private void createDishList(ResultSet r) throws SQLException {
        
        this.listaPlatillos = FXCollections.observableArrayList();
        
        while (r.next()) {
            
            String nombre = r.getString(1);
            String descripcion = r.getString(2);
            String tipo = r.getString(3);
            String nomCategoria = r.getString(4);
            String nombreRestaurante = r.getString(5);
            
            
            Plato p;
            
            p = new Plato(nombre, descripcion, tipo, nomCategoria, 
                    nombreRestaurante);
            
            this.listaPlatillos.add(p);
            
        }
        
    }
    
    
    public void showInfo(MouseEvent event) {
        
        Categoria c;
        
        c = this.categorias.getSelectionModel().getSelectedItem();
        if (c != null) {
            this.showFoodCategory(this.categorias.getSelectionModel().getSelectedItem(), event);
        }
        else {
            GeneralAlert g = new WarningAlert(null, "Seleccione una categoría");
            g.showAlert();
        }
//        else {
//            AlertsSystem.showWarning(3);
//        }
    }
    
    private void showFoodCategory(Categoria categoria, MouseEvent event) {
       
        this.showDishResults(categoria);
        
    }
}
