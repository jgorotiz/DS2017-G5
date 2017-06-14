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
import java.util.regex.Matcher;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;
import javafx.stage.Stage;
import smartfood.classes.alerts.ConfirmationAlert;
import smartfood.classes.alerts.GeneralAlert;
import smartfood.classes.alerts.InfoAlert;
import smartfood.classes.alerts.WarningAlert;
import smartfood.classes.connection.Conexion;
import smartfood.classes.constants.Constantes;
import smartfood.classes.food.Categoria;
import smartfood.classes.food.Plato;
import smartfood.classes.food.Servido;
import smartfood.classes.food.Tipo;
import smartfood.classes.validaciones.Validaciones;

/**
 *
 * @author Jose Masson
 */
public class AgregarPlatilloController implements Initializable {

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
    
    private boolean ingresoValido;
    
    private boolean imagenValida;
    
    private int idRestaurante;
    
    private Stage app;
    
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        this.llenarCategorias();
        this.llenarTipos();
        this.llenarServidos();
        
        Validaciones.addTextLimiter(nombrePlatillo, Constantes.MAX_LENGHT_TEXT);
        Validaciones.addTextLimiter(descripcionPlatillo, 
                Constantes.MAX_LENGHT_DESCR);
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
                new ExtensionFilter("Imágenes", "*.png", "*.jpg", "*.gif", 
                        "*.bmp"),
                new ExtensionFilter("Todos los Archivos", "*.*"));
        this.file = fileChooser.showOpenDialog((Stage) ((Node) event.getSource()).getScene().getWindow());
        
        if (this.file != null) {
            
            Image img = new Image(this.file.toURI().toString());
            this.imagenPlatillo.setImage(img);
            
            this.imagenValida = true;
            
        }
        else {
            
            this.imagenValida = false;
            
        }
        
    }
    
    public void agregarPlato() {
        this.agregarPlatillo();
    }
    
    private void agregarPlatillo() {
        
        Conexion cn;
        
        cn = new Conexion();
        
        String nombre = this.nombrePlatillo.getText();
        String desc = this.descripcionPlatillo.getText();
        
        Categoria c = this.obtenerCategoria();
        Tipo tip = this.obtenerTipo();
        Servido s = this.obtenerServido();
        
        
        boolean existePlato;
        
        existePlato = Plato.existePlatillo(nombre, this.idRestaurante);
        
        this.ingresoValido = this.validarIngreso(nombre, desc, 
                this.obtenerCategoria(), s, tip);
        
        if (!this.ingresoValido && !existePlato) {
            this.mostrarNoExito("Platillo no ha sido agregado con éxito");
        }
        else if (this.ingresoValido && !existePlato) {
            
            Integer categoria = c.getIdCategoria();
            Integer tipo = tip.getIdTipo();
            Integer servido = s.getIdServido();
            
            Integer res = this.idRestaurante;
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

            ConfirmationAlert confirmation = new ConfirmationAlert();

            confirmation.setMensaje("¿Desea agregar el platillo al restaurante?");
            confirmation.showAlert();

            if (confirmation.getResult().get() == ButtonType.OK) {
                Plato.agregarPlatillo(cn, p);

                this.limpiarCampos();
                this.mostrarExito();
                
            }
            
            
        }
        else if(this.ingresoValido && existePlato) {
            this.mostrarNoExito("Platillo ya existe en el restaurante");
        }
        
    }

    public void setIDRestaurante(int idRestaurante) {
        this.idRestaurante = idRestaurante;
    }

    public void setDialogStage(Stage dialogStage) {
        this.app = dialogStage;
    }
    
    @FXML
    public void volver() {
        this.app.close();
    }
    
    private void mostrarExito() {
        
        GeneralAlert g;
        
        g = new InfoAlert();
        
        g.setMensaje("Platillo agregado con éxito");
        
        g.showAlert();
        
    }
    
    private void mostrarNoExito(String s) {
        
        GeneralAlert g;
        
        g = new WarningAlert();
        
        g.setMensaje(s);
        
        g.showAlert();
        
    }
    
    private void limpiarCampos() {
        
        this.nombrePlatillo.setText("");
        this.descripcionPlatillo.setText("");
        this.categoriaPlato.getSelectionModel().clearSelection();
        this.tipoPlato.getSelectionModel().clearSelection();
        this.servidoPlato.getSelectionModel().clearSelection();
        this.imagenPlatillo.setImage(null);
        
    }
    
    private boolean validarIngreso(String n, String des, Categoria c,
            Servido s, Tipo t) {
        
        return (c != null && s != null && t != null && this.imagenValida
                && this.validarDescripcion(des) 
                && this.validarNombrePlatillo(n));
        
    }
    
    private boolean validarDescripcion(String des) {
        
        Matcher encajaDescripcion;
        encajaDescripcion = Validaciones.obtenerMatcher(".{1,200}", des);

        return encajaDescripcion.matches();
        
    }
    
    private boolean validarNombrePlatillo(String n) {
        
        Matcher encajaNombre;
        encajaNombre = Validaciones.obtenerMatcher("[A-Za-z\\p{Punct}\\p{L}\\s]"
                + "?+(\\s?[A-Za-z0-9\\p{Punct}\\p{L}]*){1,30}", n);
        return encajaNombre.matches();
        
    }
}
