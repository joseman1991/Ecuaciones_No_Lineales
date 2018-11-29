/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import javax.swing.JTable;

/**
 *
 * @author JOSE
 */
public class Secante extends Interpolación {

    public Secante(JTable tabla) {
        super(tabla);
    }

    public double obtenerRaiz(Funcion funcion, double a, double b, double precision, int iteraciones) {
        raiz();
        double r = 0;

        int i = 1;

        double f_a;
        double f_b;
        f_a = funcion.eval(a);
        f_b = funcion.eval(b);
        double f_Xi;
        double Xi;
        double e;
        int ki = 0;
        int kd = 0;
        String[] fila;
        do {
            fila = new String[4];
            fila[0] = i + "";

            Xi = a - ((b - a) / (f_b - f_a)) * f_a;
            fila[1] = Xi + "";
           
            e = Math.abs(b - a);
              fila[3] = e + "";
            if (e < precision) {
                r = Xi;
                break;
            }
            
            f_Xi = funcion.eval(Xi);

             

            fila[2] = f_Xi + "";
           

            if ((f_a * f_Xi) < 0) {
                f_b = f_Xi;
                kd = 0;
                ki++;
                b = Xi;
                if (ki > 1) {
                    f_a = f_a / 2;
                }
            } else {
                f_a = f_Xi;
                ki = 0;
                kd++;
                if (kd > 1) {
                    f_b = f_b / 2;
                }
                a = Xi;
            }

            if ((f_Xi * f_a) <= 0) {
                b = Xi;
            } else {
                a = Xi;
            }
            filas.add(fila);
            i++;
        } while (i <= iteraciones);

        filas.add(fila);
        for (int j = 0; j < filas.size(); j++) {
            String[] get = filas.get(j);
            model.addRow(get);
        }
        super.iteraciones = i;
        return r;
    }

    public int getIteraciones() {
        return iteraciones;
    }

}
