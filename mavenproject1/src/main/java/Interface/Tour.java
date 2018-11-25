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
    public Tour(){
        initComponents();
        this.setLocationRelativeTo(null);
    }
    
    
    Api api = new Api();
    TextFile txt = new TextFile();
    
    
    public GestionEdges gestion_edges; // DEBE ESTAR DECLARADO E INICIALIZADO 

    public GestionEdges getGestion_edges() {
        return gestion_edges;
    }

    public void setGestion_edges(GestionEdges gestion_edges) {
        this.gestion_edges = gestion_edges;
    }
    /**
     * GENERAR GETTER AND SETTER DE LA TABLA
     *
     * @return
     */
       public JTable getTabla_tour() {
        return tabla_tour;
    }

    public void setTabla_tour(JTable tabla_tour) {
        this.tabla_tour = tabla_tour;
    }
        public void actualizarTabla() {

        ModeladorTablas.vaciarTabla(tabla_tour);
        Object[] filaNueva;
        ListNode<Edge> temp = gestion_edges.getEdges().getInicio();
        for (int i = 0; i < gestion_edges.getEdges().getSize(); i++) {
            filaNueva = new Object[]{temp.getElemento().getId(),
                temp.getElemento().getName(),
                temp.getElemento().getDuration(),
                temp.getElemento().getDistance(),
                temp.getElemento().getAddress(),};
            ModeladorTablas.nuevaFila(tabla_tour, filaNueva);
            temp = temp.getNodoSig();
        }
    }

     public void eliminarDesdeTabla() throws Exception {
        int rowNum = tabla_tour.getSelectedRow();
        String elim = ModeladorTablas.obtenerValorCelda(tabla_tour, rowNum, 0);//ModeladorTablas.obtenerValorCelda(tabla_animales, rowNum, 0);
        gestion_edges.deleteSites(elim);
        actualizarTabla();
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabla_tour = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        btnMenu = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(0, 153, 153));
        jPanel1.setForeground(new java.awt.Color(0, 102, 102));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tabla_tour.setModel(new javax.swing.table.DefaultTableModel(
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
        tabla_tour.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabla_tourMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tabla_tour);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 80, 460, 250));

        jLabel1.setFont(new java.awt.Font("Roboto", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Tour de la empresa");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 30, -1, -1));

        btnMenu.setBackground(new java.awt.Color(255, 255, 255));
        btnMenu.setForeground(new java.awt.Color(0, 153, 153));
        btnMenu.setText("Menu");
        btnMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMenuActionPerformed(evt);
            }
        });
        jPanel1.add(btnMenu, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 340, -1, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, -1, 560, 380));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tabla_tourMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabla_tourMouseClicked
        int indice = tabla_tour.getSelectedRow();
        try {
            api.getLocation((String)tabla_tour.getValueAt(indice,3));
        } catch (IOException ex) {
            Logger.getLogger(Tour.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(Tour.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_tabla_tourMouseClicked

    private void btnMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMenuActionPerformed
        Empresa emp = new Empresa();
        emp.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_btnMenuActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnMenu;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tabla_tour;
    // End of variables declaration//GEN-END:variables
}
