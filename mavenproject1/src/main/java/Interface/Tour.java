/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interface;

import Api.Api;
import Structures.Edge;
import Structures.GestionEdges;
import Structures.GestionSites;
import Structures.ListNode;
import Structures.Site;
import Table.ModeladorTablas;
import TextFile.TextFile;
import java.io.IOException;
import java.util.LinkedList;
import java.util.logging.Level;
import java.util.logging.Logger;
import static javafx.scene.input.KeyCode.T;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import sun.swing.table.DefaultTableCellHeaderRenderer;
/**
 *
 * @author kevca
 */
public class Tour extends javax.swing.JFrame {

    /**
     * Creates new form Tour
     */
    public Tour(String a,String b,String c,String d){
        initComponents();
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("Nombre");
        model.addColumn("Origen");
        model.addColumn("Destino");
        model.addColumn("Direccion");
        model.addRow(new  Object[]{a,b,c,d});
        jTable1.setModel(model);
    }
    
    
    Api api = new Api();
    TextFile txt = new TextFile();
    
    
    public GestionEdges gestion_tour; // DEBE ESTAR DECLARADO E INICIALIZADO 

    public GestionEdges getGestion_tour() {
        return gestion_tour;
    }

    public void setGestion_sitio(GestionEdges gestion_tour) {
        this.gestion_tour = gestion_tour;
    }
    /**
     * GENERAR GETTER AND SETTER DE LA TABLA
     *
     * @return
     */
       public JTable getTabla_sitios() {
        return jTable1;
    }

    public void setTabla_sitios(JTable tabla_sitios) {
        this.jTable1 = tabla_sitios;
    }
        public void actualizarTabla() {

        ModeladorTablas.vaciarTabla(jTable1);
        Object[] filaNueva;
        ListNode<Edge> temp = gestion_tour.getEdges().getInicio();
        for (int i = 0; i < gestion_tour.getEdges().getSize(); i++) {
            filaNueva = new Object[]{temp.getElemento().getId(),
                temp.getElemento().getName(),
                temp.getElemento().getDuration(),
                temp.getElemento().getDistance(),
                temp.getElemento().getAddress(),};
            ModeladorTablas.nuevaFila(jTable1, filaNueva);
            temp = temp.getNodoSig();
        }
    }

     public void eliminarDesdeTabla() throws Exception {
        int rowNum = jTable1.getSelectedRow();
        String elim = ModeladorTablas.obtenerValorCelda(jTable1, rowNum, 0);//ModeladorTablas.obtenerValorCelda(tabla_animales, rowNum, 0);
        gestion_tour.deleteSites(elim);
        actualizarTabla();
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(0, 153, 153));
        jPanel1.setForeground(new java.awt.Color(0, 102, 102));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 80, 460, 250));

        jLabel1.setFont(new java.awt.Font("Roboto", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Tour de la empresa");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 30, -1, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, -1, 560, 380));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        int indice = jTable1.getSelectedRow();
        try {
            api.getLocation((String)jTable1.getValueAt(indice,3));
        } catch (IOException ex) {
            Logger.getLogger(Tour.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(Tour.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jTable1MouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}
