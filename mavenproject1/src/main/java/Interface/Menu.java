/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interface;

import Table.ModeladorTablas;
import Main.Main;

/**
 *
 * @author marip
 */
public class Menu extends javax.swing.JFrame {

    /**
     * Creates new form Menu
     */
    public Menu() {
        initComponents();
        this.setLocationRelativeTo(null);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        lblTitulo = new javax.swing.JLabel();
        btnInfo = new javax.swing.JButton();
        btnRuta = new javax.swing.JButton();
        btnGestion = new javax.swing.JButton();
        btnTourE = new javax.swing.JButton();
        btnTourC = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(0, 153, 153));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblTitulo.setFont(new java.awt.Font("Roboto", 1, 24)); // NOI18N
        lblTitulo.setForeground(new java.awt.Color(255, 255, 255));
        lblTitulo.setText("TRIPTEC");
        jPanel1.add(lblTitulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(172, 34, -1, -1));

        btnInfo.setBackground(new java.awt.Color(255, 255, 255));
        btnInfo.setForeground(new java.awt.Color(0, 153, 153));
        btnInfo.setText("Información Clientes");
        btnInfo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInfoActionPerformed(evt);
            }
        });
        jPanel1.add(btnInfo, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 110, -1, -1));

        btnRuta.setBackground(new java.awt.Color(255, 255, 255));
        btnRuta.setForeground(new java.awt.Color(0, 153, 153));
        btnRuta.setText("Mejor Ruta");
        jPanel1.add(btnRuta, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 240, -1, -1));

        btnGestion.setBackground(new java.awt.Color(255, 255, 255));
        btnGestion.setForeground(new java.awt.Color(0, 153, 153));
        btnGestion.setText("Gestión Sitios");
        btnGestion.setActionCommand("");
        btnGestion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGestionActionPerformed(evt);
            }
        });
        jPanel1.add(btnGestion, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 110, -1, -1));

        btnTourE.setBackground(new java.awt.Color(255, 255, 255));
        btnTourE.setForeground(new java.awt.Color(0, 153, 153));
        btnTourE.setText("Tour Empresa");
        btnTourE.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTourEActionPerformed(evt);
            }
        });
        jPanel1.add(btnTourE, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 180, -1, -1));

        btnTourC.setBackground(new java.awt.Color(255, 255, 255));
        btnTourC.setForeground(new java.awt.Color(0, 153, 153));
        btnTourC.setText("Tour Cliente");
        jPanel1.add(btnTourC, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 180, -1, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(2, -2, 460, 300));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnTourEActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTourEActionPerformed
        Empresa emp = new Empresa();
        emp.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_btnTourEActionPerformed

    private void btnGestionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGestionActionPerformed
        GestionSitios gestion = new GestionSitios();
        gestion.setVisible(true);
        this.setVisible(false);
        
         gestion.setGestion_sitio(Main.sites);// global lista
        
        Object[] columnasSitios = new Object[] {"Id","Nombre","Precio","Descripcion","Actividades","Latitud", "Longitud", "Direccion"};        
        gestion.getTabla_sitios().setModel(ModeladorTablas.generarModeloDeTabla(8, columnasSitios));
        gestion.getTabla_sitios().setAutoCreateRowSorter(true);
        gestion.actualizarTabla();
    }//GEN-LAST:event_btnGestionActionPerformed

    private void btnInfoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInfoActionPerformed
        Informacion info = new Informacion();
        info.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_btnInfoActionPerformed

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnGestion;
    private javax.swing.JButton btnInfo;
    private javax.swing.JButton btnRuta;
    private javax.swing.JButton btnTourC;
    private javax.swing.JButton btnTourE;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lblTitulo;
    // End of variables declaration//GEN-END:variables
}
