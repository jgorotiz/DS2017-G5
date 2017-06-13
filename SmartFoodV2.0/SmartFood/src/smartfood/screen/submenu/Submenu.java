/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package smartfood.screen.submenu;

import smartfood.prueba.*;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.TextAlignment;

/**
 *
 * @author Mercedes
 */
public class Submenu {
    private Pane panel;
    private HashMap<String,Button> botones = new HashMap<>();
    private double ancho = 673;
    private int alto = 573;
    
    public Submenu(String encabezado, ArrayList<String> labels, ArrayList<String> links){
        int acum = 0;
        this.panel = new Pane();
        Label lEncabezado = new Label(encabezado);
        lEncabezado.setAlignment(Pos.CENTER);
        lEncabezado.setLayoutX(390);
        lEncabezado.setFont(new Font("Cambria", 50));
        lEncabezado.setTextFill(Color.DARKRED);
        if(lEncabezado.getWidth() > 500){
            this.ancho = lEncabezado.getWidth();
        }
        lEncabezado.setLayoutY(60);
        acum = acum + 150;
        panel.getChildren().add(lEncabezado);
        for(int i=0; i < labels.size(); i++){
            Button bt = new Button(labels.get(i));
            bt.setLayoutX(390);
            bt.setLayoutY(acum);
            Image boton = new Image(new File("src/smartfood/images/etimadera.png").toURI().toString());
            
            bt.setBackground(new Background(new BackgroundImage(boton, 
                BackgroundRepeat.NO_REPEAT, BackgroundRepeat.REPEAT, BackgroundPosition.CENTER, BackgroundSize.DEFAULT)));
            
            bt.setMaxSize(200, 80);
            bt.setPrefSize(200, 80);
            bt.setOnMouseEntered(new estimular(bt, true));
            bt.setOnMouseExited(new estimular(bt, false));
            bt.setFont(Font.font(null, FontWeight.BOLD, 20));
            bt.setTextFill(Color.DARKBLUE);
            bt.setTextAlignment(TextAlignment.CENTER);
            acum = acum + 100;
            botones.put(links.get(i),bt);
            panel.getChildren().add(bt);
        }
        
        Image fondo = new Image(new File("src/smartfood/images/gastronomy.jpg").toURI().toString());
        this.panel.setBackground(new Background(new BackgroundImage(fondo, BackgroundRepeat.NO_REPEAT,
                BackgroundRepeat.REPEAT, BackgroundPosition.CENTER, BackgroundSize.DEFAULT)));
        
        this.panel.setMaxSize(ancho, alto);
        this.panel.setPrefSize(ancho, alto);
        
        
        
   
    }
    
    public Pane getPanel() {
        return panel;
    }

    public void setPanel(Pane panel) {
        this.panel = panel;
    }

    public HashMap<String, Button> getBotones() {
        return botones;
    }

    public void setBotones(HashMap<String, Button> botones) {
        this.botones = botones;
    }

    public double getAncho() {
        return ancho;
    }

    public void setAncho(double ancho) {
        this.ancho = ancho;
    }

    public int getAlto() {
        return alto;
    }

    public void setAlto(int alto) {
        this.alto = alto;
    }
    
    private class estimular implements EventHandler<MouseEvent> {
        Button btn;
        boolean estimulo;

        public estimular(Button btn, boolean estimulo) {
            this.btn = btn;
            this.estimulo = estimulo;
        }
        
        @Override
        public void handle(MouseEvent event) {
            DropShadow shadow = new DropShadow();
            shadow.setColor(Color.CORAL);
            if (estimulo) {
                btn.setEffect(shadow);
            }
            else {
                btn.setEffect(null);
            }
        }
    }
    
}
