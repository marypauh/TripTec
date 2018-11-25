/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Table;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author marip
 */
public class ModeladorTablas {
    
    private static DefaultTableModel modelo;

    /**
     * Permite gemerar modelado para las tablas
     * @param columnas
     * @param identificadores
     * @return 
     */
    public static DefaultTableModel generarModeloDeTabla(int columnas, Object[] identificadores) {
        DefaultTableModel modeloGenerico = new DefaultTableModel();
        modeloGenerico.setColumnCount(columnas);
        modeloGenerico.setColumnIdentifiers(identificadores);
        return modeloGenerico;
    }

    /**
     * Permite vaciar cualquier tabla del programa con solo llamarlo
     * @param nombre_tabla 
     */
    public static void vaciarTabla(JTable nombre_tabla) {
        modelo = (DefaultTableModel) nombre_tabla.getModel();
        modelo.getDataVector().removeAllElements();
    }

    /**
     * Permite ingresar nuevas filas a la tabla
     * @param nombre_tabla
     * @param filaNueva 
     */
    public static void nuevaFila(JTable nombre_tabla, Object[] filaNueva) {
        modelo = (DefaultTableModel) nombre_tabla.getModel();
        modelo.addRow(filaNueva);
    }

    /**
     * proporciona el valor exacto de una celda de una determinada fila seleccionada
     * @param nombre_tabla
     * @param fila
     * @param columna
     * @return 
     */
    public static String obtenerValorCelda(JTable nombre_tabla, int fila, int columna) {
        return (String) nombre_tabla.getValueAt(fila, columna);
    }
    
    
}
