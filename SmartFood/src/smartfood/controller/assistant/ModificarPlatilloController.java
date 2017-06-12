/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package smartfood.controller.assistant;

import java.io.File;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Calendar;
import java.util.Date;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import smartfood.classes.alerts.GeneralAlert;
import smartfood.classes.alerts.WarningAlert;
import smartfood.classes.connection.Conexion;
import smartfood.classes.food.Categoria;
import smartfood.classes.food.Plato;
import smartfood.classes.food.Servido;
import smartfood.classes.food.Tipo;

/**
 *
 * @author Jose Masson
 */
public class ModificarPlatilloController implements Initializable {

    private Stage appStage;
    
    private int idRestaurante;
    
    @FXML
    private TextField nombrePlatillo;
    
    @FXML
    private TextArea descripcionPlatillo;
    
    @FXML
    private ImageView imagenPlatillo;
    
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
    
    @FXML
    private File file;
    
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        this.llenarCategorias();
        this.llenarTipos();
        this.llenarServidos();
    }
    
    public void setDialogStage(Stage dialogStage) {
        this.appStage = dialogStage;
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
    
    private Categoria obtenerCategoria() {
        
        Categoria c;
        
        c = this.categoriaPlato.getSelectionModel().getSelectedItem();
        
        return c;
        
    }
    
    private Tipo obtenerTipo() {
        Tipo t;
        
        t = this.tipoPlato.getSelectionModel().getSelectedItem();
        
        return t;
    }
    
    private Servido obtenerServido() {
        
        Servido s;
        
        s = this.servidoPlato.getSelectionModel().getSelectedItem();
        
        return s;
        
    }
    
    public void seleccionarImagen(MouseEvent event) {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Abrir Imagen");
        fileChooser.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter("Imágenes", "*.png", "*.jpg", "*.gif", 
                        "*.bmp"),
                new FileChooser.ExtensionFilter("Todos los Archivos", "*.*"));
        this.file = fileChooser.showOpenDialog((Stage) ((Node) event.getSource()).getScene().getWindow());
        
        if (this.file != null) {
            
            Image img = new Image(this.file.toURI().toString());
            this.imagenPlatillo.setImage(img);
            
//            this.guardarImagen(selectedFile);
//            System.out.println("Imagen guardada con éxito");
            
        }
        
    }
    
    public void setPlato(Plato p) {
        this.nombrePlatillo.setText(p.getNombre());

        if (this.servidoPlato.getItems().contains(new Servido(p.getServido()))) {
            this.servidoPlato.getSelectionModel().select(new Servido(p.getServido()));
        }

        if (this.tipoPlato.getItems().contains(new Tipo(p.getTipo()))) {
            this.tipoPlato.getSelectionModel().select(new Tipo(p.getTipo()));
        }
        
        if (this.categoriaPlato.getItems().contains(new Categoria(p.getCategoria()))) {
            this.categoriaPlato.getSelectionModel().select(new Categoria(p.getCategoria()));
        }
//        this.categoriaPlato.setText(p.getCategoria());
        this.descripcionPlatillo.setText(p.getDescripcion());
        this.imagenPlatillo.setImage(p.getImagen());
//        this.nameField.setText(p.getName());
//        if (this.specialtyList.getItems().contains(p.getSpecialty())) {
//            this.specialtyList.getSelectionModel().select(p.getSpecialty());
//        }
//        this.costField.setText(p.getPrice().toString());
//        this.description.setText(p.getDescription());
    }
    
    public void agregarPlato() {
        this.agregarPlatillo();
    }
    
    private void agregarPlatillo() {
        
        Conexion cn;
        
        cn = new Conexion();
        
        String nombre = this.nombrePlatillo.getText();
        Integer categoria = this.obtenerCategoria().getIdCategoria();
        Integer tipo = this.obtenerTipo().getIdTipo();
        Integer servido = this.obtenerServido().getIdServido();
        String desc = this.descripcionPlatillo.getText();
        Integer res = 1;
//        InputStream img = Plato.obtenerBinarioImagen(file);
        
        Date utilDate = new Date();
        Calendar cal = Calendar.getInstance();
        cal.setTime(utilDate);
        cal.set(Calendar.MILLISECOND, 0);

        Timestamp t;
        
        t = new Timestamp(cal.getTimeInMillis());
        
        Plato p = new Plato(nombre, desc, this.file, Integer.toString(categoria),
            Integer.toString(tipo), Integer.toString(servido), 
                Integer.toString(res), t);
        
        System.out.println(Plato.agregarPlatillo(cn, p));
        
        System.out.println("Agregado con éxito");
    }
    
}
