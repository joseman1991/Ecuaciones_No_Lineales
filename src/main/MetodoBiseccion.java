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
public class MetodoBiseccion extends Interpolación {

    public MetodoBiseccion(JTable tabla) {
        super(tabla);
    }

    public double obtenerRaiz(Funcion funcion, double a, double b, double precision, int iteraciones) {
        raiz();
        double r = 0;

        int i = 1;

        double f_a;
        double f_b;
        double f_Xi;
        double Xi;
        double e;
        String[] fila;
        do {
            Xi = (a + b) / 2;
            fila = new String[8];
            f_a = funcion.eval(a);
            f_b = funcion.eval(b);
            f_Xi = funcion.eval(Xi);
            e = Math.abs(b - a);

            fila[0] = i + "";
            fila[1] = a + "";
            fila[2] = b + "";
            fila[3] = Xi + "";
            fila[4] = f_a + "";
            fila[5] = f_b + "";
            fila[6] = f_Xi + "";
            fila[7] = e + "";

            if ((b - a) < precision) {
                r = Xi;
                break;
            }

            if ((f_Xi * f_a) <= 0) {
                b = Xi;
            } else {
                a = Xi;
            }
            filas.add(fila);
            i++;
        } while (i <= iteraciones);

        fila = new String[8];
        fila[0] = i + "";
        fila[1] = a + "";
        fila[2] = b + "";
        fila[3] = Xi + "";
        fila[4] = f_a + "";
        fila[5] = f_b + "";
        fila[6] = f_Xi + "";
        fila[7] = e + "";

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
