/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import javax.swing.JOptionPane;
import org.nfunk.jep.JEP;

/**
 *
 * @author Darwin
 */
public class Funcion {

    JEP j = new JEP();
/**
 * 
 * @param def  la funcion ingresada como String de la que se desea btener la raiz
 */
    public Funcion(String def) {
        j.addVariable("x", 0);
        j.addStandardConstants();
        j.addStandardFunctions();
         j.setImplicitMul(true);
        j.parseExpression(def);
        if (j.hasError()) {
            JOptionPane.showMessageDialog(null, " error  al convertir la funcion");
        }
    }
    
    /**
     * 
     * @param x punto en el que se evaluara la funcion
     * @return retorna el valor de la funcion evaluada en el punto x
     */
    public double eval(double x){
        double r;
        j.addVariable("x",x);
        r=j.getValue();
        if (j.hasError()) {
            JOptionPane.showMessageDialog(null, " error  al convertir la funcion");
        }
        return r;     
    }
    
}
