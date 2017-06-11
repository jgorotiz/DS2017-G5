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
import smartfood.classes.connection.Conexion;
import smartfood.classes.food.Categoria;

/**
 *
 * @author Jose Masson
 */
public class ListaCategoriaController implements Initializable {
    
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
    
    public void showInfo(MouseEvent event) {
        if (this.table.getSelectionModel().getSelectedItem() != null) {
            this.showFoodCategory(this.table.getSelectionModel().getSelectedItem(), event);
        }
//        else {
//            AlertsSystem.showWarning(3);
//        }
    }
    
    private void showFoodCategory(Categoria categoria, MouseEvent event) {
        System.out.println("Hola Mundo en " + categoria.getNombreCategoria());
        
//        FileChooser fileChooser = new FileChooser();
//        fileChooser.setTitle("Open Resource File");
//        fileChooser.getExtensionFilters().addAll(
////            new ExtensionFilter("Text Files", "*.txt"),
//            new ExtensionFilter("Image Files", "*.png", "*.jpg", "*.gif"),
//            new ExtensionFilter("Audio Files", "*.wav", "*.mp3", "*.aac"));
////            new ExtensionFilter("All Files", "*.*"));
//        Stage stage;
//        stage = new Stage();
//        File selectedFile = fileChooser.showOpenDialog(stage);
//        System.out.println(selectedFile.isFile());
//        if (selectedFile != null) {
//           stage.display(selectedFile);
//        }
    
    
    }
}
