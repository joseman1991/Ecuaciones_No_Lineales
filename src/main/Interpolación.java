/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import java.util.ArrayList;
import java.util.List;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author JOSE
 */
public class Interpolación {

    protected final JTable tabla;
    protected final DefaultTableModel model;
    protected final List<String[]> filas;
    protected int iteraciones;

    public Interpolación(JTable tabla) {
        this.tabla = tabla;
        model = (DefaultTableModel) tabla.getModel();
        filas = new ArrayList<>();
    }

    public void raiz() {
        filas.clear();
        while (model.getRowCount() > 0) {
            model.removeRow(0);
        }
    }

}
