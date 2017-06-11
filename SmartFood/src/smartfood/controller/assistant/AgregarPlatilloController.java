/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package smartfood.controller.assistant;

import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import smartfood.classes.alerts.GeneralAlert;
import smartfood.classes.alerts.WarningAlert;
import smartfood.classes.connection.Conexion;
import smartfood.classes.food.Categoria;
import smartfood.classes.food.Servido;
import smartfood.classes.food.Tipo;

/**
 *
 * @author Jose Masson
 */
public class AgregarPlatilloController implements Initializable {

    @FXML
    private ComboBox<Categoria> categoriaPlato;
    
    @FXML
    private ComboBox<Tipo> tipoPlato;
    
    @FXML
    private ComboBox<Servido> servidoPlato;
    
    @FXML
    private ObservableList<Categoria> listaCategorias;
    
    @FXML
    private ObservableList<Tipo> listaTipos;
    
    @FXML
    private ObservableList<Servido> listaServidos;
    
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        this.llenarCategorias();
        this.llenarTipos();
        this.llenarServidos();
    }
    
    private void llenarCategorias() {
        
        Conexion cn;
        
        ResultSet resultados;
       
        cn = new Conexion();
        
        try {
            
            resultados = Categoria.getListadoCategorias(cn);
            
            this.createCategoryList(resultados);
            
            this.categoriaPlato.setItems(this.listaCategorias);
            
            this.categoriaPlato.setCellFactory((ListView<Categoria> param) -> 
                    new ListCell<Categoria>(){
                @Override
                public void updateItem(Categoria item, boolean empty){
                    super.updateItem(item, empty);
                    if(!empty) {
                        setText(item.getNombreCategoria());
                        setGraphic(null);
                    }
                }
            });
            
        }
        catch (Exception e) {
            
        }
        finally {
            try {
                cn.getConnection().close();
                
            } catch (SQLException ex) {
                GeneralAlert g = new WarningAlert();
                g.setMensaje("Error en el cierre de conexión");
                g.showAlert();
            }
        }
        
    }
    
    private void llenarTipos() {
        
        Conexion cn;
        
        ResultSet resultados;
       
        cn = new Conexion();
        
        try {
            
            resultados = Tipo.getListadoTipos(cn);
            
            this.createTypeList(resultados);
            
            this.tipoPlato.setItems(this.listaTipos);
            
            this.tipoPlato.setCellFactory((ListView<Tipo> param) -> 
                    new ListCell<Tipo>(){
                @Override
                public void updateItem(Tipo item, boolean empty){
                    super.updateItem(item, empty);
                    if(!empty) {
                        setText(item.getNombreTipo());
                        setGraphic(null);
                    }
                }
            });
            
        }
        catch (Exception e) {
            
        }
        finally {
            try {
                cn.getConnection().close();
                
            } catch (SQLException ex) {
                GeneralAlert g = new WarningAlert();
                g.setMensaje("Error en el cierre de conexión");
                g.showAlert();
            }
        }
        
    }
    
    private void llenarServidos() {
        
        Conexion cn;
        
        ResultSet resultados;
       
        cn = new Conexion();
        
        try {
            
            resultados = Servido.getListadoServidos(cn);
            
            this.createServeList(resultados);
            
            this.servidoPlato.setItems(this.listaServidos);
            
            this.servidoPlato.setCellFactory((ListView<Servido> param) -> 
                    new ListCell<Servido>(){
                @Override
                public void updateItem(Servido item, boolean empty){
                    super.updateItem(item, empty);
                    if(!empty) {
                        setText(item.getNombreServido());
                        setGraphic(null);
                    }
                }
            });
            
        }
        catch (Exception e) {
            
        }
        finally {
            try {
                cn.getConnection().close();
                
            } catch (SQLException ex) {
                GeneralAlert g = new WarningAlert();
                g.setMensaje("Error en el cierre de conexión");
                g.showAlert();
            }
        }
        
    }
    
    private void createCategoryList(ResultSet r) throws SQLException {
        
        this.listaCategorias = FXCollections.observableArrayList();
        
        while (r.next()) {
            
            Integer idCategoria = r.getInt(1);
            String nomCategoria = r.getString(2);
            
            Categoria c;
            
            c = new Categoria(idCategoria, nomCategoria);

            this.listaCategorias.add(c);
            
        }
    }
    
    private void createTypeList(ResultSet r) throws SQLException {
        
        this.listaTipos = FXCollections.observableArrayList();
        
        while (r.next()) {
            
            Integer idTipo = r.getInt(1);
            String nomTipo = r.getString(2);
            
            Tipo t;
            
            t = new Tipo(idTipo, nomTipo);

            this.listaTipos.add(t);
            
        }
    }
    
    private void createServeList(ResultSet r) throws SQLException {
        
        this.listaServidos = FXCollections.observableArrayList();
        
        while (r.next()) {
            
            Integer idServido = r.getInt(1);
            String nomServido = r.getString(2);
            
            Servido s;
            
            s = new Servido(idServido, nomServido);

            this.listaServidos.add(s);
            
        }
    }
    
    public void mostrarTipo() {
        Tipo t = this.obtenerTipo();
        
        if (t!= null) {
            System.out.println(t.getIdTipo());
            System.out.println(t.getNombreTipo());
        }
        else {
            System.out.println("null");
        }
        
    }
    
    private Tipo obtenerTipo() {
        Tipo t;
        
        t = this.tipoPlato.getSelectionModel().getSelectedItem();
        
        return t;
    }
    
}
