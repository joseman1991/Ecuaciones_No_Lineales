/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import javax.swing.JOptionPane;
import javax.swing.JTable;

/**
 *
 * @author JOSE
 */
public class MetodoNewton extends Interpolación {

    public MetodoNewton(JTable tabla) {
        super(tabla);
    }

    public double obtenerRaiz(Funcion f, Funcion derivada, Funcion fRaiz, double Xo, double precision, int iteraccion) {
        raiz();
        double r = 0;
        int i = 1;
        String fila[];
        double X_i1;
        double X_i = Xo;
        double e;
        double fxi;
        double dx_xi;

        if (f.eval(X_i) == 0) {
            JOptionPane.showMessageDialog(tabla, "No existe raiz ingresa otro valor de Xo", "Error", JOptionPane.ERROR_MESSAGE);
            return 0;
        }

        do {
            fxi = f.eval(X_i);
            dx_xi = derivada.eval(X_i);           
            X_i1 = X_i - (fxi / dx_xi);
            e = Math.abs(X_i1 - X_i);
            fila = new String[5];
            fila[0] = i + "";
            fila[1] = X_i + "";
            fila[4] = e + "";
            if (e <= precision) {
                r = X_i1;
                filas.add(fila);
                break;
            }
            fila[2] = fxi + "";
            fila[3] = dx_xi + "";
            filas.add(fila);
            X_i = X_i1;
            i++;
        } while (i <= iteraccion);

        super.iteraciones = i;
        if (i > iteraccion) {
            JOptionPane.showMessageDialog(tabla, "La sucesión de aproximaciones no converge a la raíz", "Información", JOptionPane.INFORMATION_MESSAGE);
            return 0;
        }
        for (int j = 0; j < filas.size(); j++) {
            String[] get = filas.get(j);
            model.addRow(get);
        }

        return r;
    }

    public int getIteraciones() {
        return iteraciones;
    }

}
