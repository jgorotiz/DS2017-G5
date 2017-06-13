/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package smartfood;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author Jonathan Gorotiza
 */
public class pruebasExpresionesRegulares {
    public static void main(String[] args) {
        //para nombres y apellidos
        Pattern nombres = Pattern.compile("[A-Za-z]{1,100}");
        Matcher encaja0 = nombres.matcher("fdfdfJKgf");
        System.out.println(encaja0.matches());

        //para correos
        Pattern correo = Pattern.compile("[A-Za-z0-9._-]*@[a-z]*.[a-z]*");
        Matcher encaja = correo.matcher("jgordvdf@gmail.com");
        System.out.println(encaja.matches());

        //para edad
        Pattern edad = Pattern.compile("[0-9]{1,2}");
        Matcher encaja1 = edad.matcher("39");
        System.out.println(encaja1.matches());
        
        //para usuario con letras y numeros
        Pattern usuario = Pattern.compile("[A-Za-z0-9]{1,20}");
        Matcher encaja2 = usuario.matcher("fdfdfJKgf");
        System.out.println(encaja0.matches());
    }
    
}
