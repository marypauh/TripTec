/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interface;

import Api.Api;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import TextFile.TextFile;
import java.io.File;
import javax.swing.JTable;
import Table.ModeladorTablas;
import Structures.Site;
import Structures.ListNode;
import Structures.GestionSites;
import Main.Main;
import Structures.Graph;
        

/**
 *
 * @author marip
 */
public class GestionSitios extends javax.swing.JFrame {
    
    Main main = new Main();
    int contador = main.contador;

    Api api = new Api();
   TextFile txt = new TextFile();
   
   
    public GestionSites gestion_sitio; // DEBE ESTAR DECLARADO E INICIALIZADO 

    public GestionSites getGestion_sitios() {
        return gestion_sitio;
    }

    public void setGestion_sitio(GestionSites gestion_sitio) {
        this.gestion_sitio = gestion_sitio;
    }

    /**
     * GENERAR GETTER AND SETTER DE LA TABLA
     *
     * @return
     */
       public JTable getTabla_sitios() {
        return tabla_sitios;
    }

    public void setTabla_sitios(JTable tabla_sitios) {
        this.tabla_sitios = tabla_sitios;
    }
    
    public GestionSitios() {
        initComponents();
        this.setLocationRelativeTo(null);
    }
    
    public void actualizarTabla() {

        ModeladorTablas.vaciarTabla(tabla_sitios);
        Object[] filaNueva;
        ListNode<Site> temp = gestion_sitio.getSites().getInicio();
        for (int i = 0; i < gestion_sitio.getSites().getSize(); i++) {
            filaNueva = new Object[]{temp.getElemento().getId(),
                temp.getElemento().getName(),
                temp.getElemento().getPrice(),
                temp.getElemento().getDescription(),
                temp.getElemento().getActivities(),
                temp.getElemento().getLat(),
                temp.getElemento().getLng(),
                temp.getElemento().getAddress()};
            ModeladorTablas.nuevaFila(tabla_sitios, filaNueva);
            temp = temp.getNodoSig();
        }
    }

     public void eliminarDesdeTabla() throws Exception {
        int rowNum = tabla_sitios.getSelectedRow();
        String elim = ModeladorTablas.obtenerValorCelda(tabla_sitios, rowNum, 0);//ModeladorTablas.obtenerValorCelda(tabla_animales, rowNum, 0);
        gestion_sitio.deleteSites(elim);
        actualizarTabla();
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        fieldLong = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        fieldAct = new javax.swing.JTextArea();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        fieldDescription = new javax.swing.JTextArea();
        jLabel6 = new javax.swing.JLabel();
        fieldLat = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        fieldAddress = new javax.swing.JTextArea();
        btnMenu = new javax.swing.JButton();
        btnSearch = new javax.swing.JButton();
        fieldName = new javax.swing.JTextField();
        fieldPrice = new javax.swing.JTextField();
        btnDelete = new javax.swing.JButton();
        btnActualzar = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        tabla_sitios = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Roboto", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Gestionar Sitios Turísticos");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 20, -1, -1));

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Nombre");
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 80, -1, -1));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Longitud");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 180, -1, -1));
        getContentPane().add(fieldLong, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 180, 180, -1));

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Descripcion");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 110, 140, 70));

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Precio");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 70, -1, -1));

        fieldAct.setColumns(20);
        fieldAct.setRows(5);
        jScrollPane3.setViewportView(fieldAct);

        getContentPane().add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 120, 190, 110));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Dirección");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 260, -1, -1));

        fieldDescription.setColumns(20);
        fieldDescription.setRows(5);
        jScrollPane2.setViewportView(fieldDescription);

        getContentPane().add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 70, 250, 160));

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Actividades");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 120, -1, -1));
        getContentPane().add(fieldLat, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 120, 170, -1));

        fieldAddress.setColumns(20);
        fieldAddress.setRows(5);
        jScrollPane1.setViewportView(fieldAddress);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 260, 790, 110));

        btnMenu.setBackground(new java.awt.Color(255, 255, 255));
        btnMenu.setForeground(new java.awt.Color(0, 153, 153));
        btnMenu.setText("Menu");
        btnMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMenuActionPerformed(evt);
            }
        });
        getContentPane().add(btnMenu, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 390, -1, -1));

        btnSearch.setBackground(new java.awt.Color(255, 255, 255));
        btnSearch.setForeground(new java.awt.Color(0, 153, 153));
        btnSearch.setText("Registrar");
        btnSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchActionPerformed(evt);
            }
        });
        getContentPane().add(btnSearch, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 390, -1, -1));
        getContentPane().add(fieldName, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 70, 170, -1));
        getContentPane().add(fieldPrice, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 70, 180, -1));

        btnDelete.setForeground(new java.awt.Color(0, 153, 153));
        btnDelete.setText("Eliminar");
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });
        getContentPane().add(btnDelete, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 390, -1, -1));

        btnActualzar.setForeground(new java.awt.Color(0, 153, 153));
        btnActualzar.setText("Actualizar");
        btnActualzar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActualzarActionPerformed(evt);
            }
        });
        getContentPane().add(btnActualzar, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 390, -1, -1));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Latitud");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 120, -1, -1));

        tabla_sitios.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane4.setViewportView(tabla_sitios);

        getContentPane().add(jScrollPane4, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 450, 690, 340));

        jPanel1.setBackground(new java.awt.Color(0, 153, 153));
        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 940, 800));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnActualzarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualzarActionPerformed
       this.actualizarTabla();
    }//GEN-LAST:event_btnActualzarActionPerformed

    private void btnSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchActionPerformed
        if (!fieldLat.getText().isEmpty() && !fieldLong.getText().isEmpty()){
            //buscar direccion
            double lat = Double.parseDouble(fieldLat.getText());
            double lng = Double.parseDouble(fieldLong.getText());
            try {
                fieldAddress.setText(api.reverseGeocode(lat,lng));
            } catch (Exception ex) {
                Logger.getLogger(GestionSitios.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        else if(!fieldAddress.getText().isEmpty()){
            try {
                //Busca la longitud y latitud de la direccion indicada
                String latitude = String.valueOf(api.geocodelat(fieldAddress.getText()));
                fieldLat.setText(latitude);

                String longitude = String.valueOf(api.geocodelng(fieldAddress.getText()));
                fieldLong.setText(longitude);
            } catch (Exception ex) {
                Logger.getLogger(GestionSitios.class.getName()).log(Level.SEVERE, null, ex);
            }
        }else
        {
            JOptionPane.showMessageDialog(null, "Debe ingresar la longitud y latitud o ingresar la dirección del sitio");
        }
       try {
            
           txt.TextFile("Nombre del lugar:  "+fieldName.getText()+"  "+"Descripcion:  "+fieldDescription.getText()+"  "+"Precio:  "+fieldPrice.getText()+"  "+"Actividades:  "+fieldAct.getText()+"  "+"Latitu-d: "+fieldLat.getText()+"  "+"Longitud:  "+fieldLong.getText()+"   "+"Dirección:  "+fieldAddress.getText());

        } catch (IOException ex) {
          Logger.getLogger(GestionSitios.class.getName()).log(Level.SEVERE, null, ex);
       }
        
        int id;
        String id2,name, price, description,activities,lat, lng, address;
        id = contador++;
        name = this.fieldName.getText();
        description = this.fieldDescription.getText();
        price = this.fieldPrice.getText();
        activities = this.fieldAct.getText();
        lat = this.fieldLat.getText();
        lng = this.fieldLong.getText();
        address = this.fieldAddress.getText();
        id2 = Integer.toString(id);
        
        this.getGestion_sitios().createSites(id2, name, price, description, activities, lat, lng,address);
        this.actualizarTabla();
        
        Graph graph = new Graph();
        graph.addVertex(id);
        
        
        
    }//GEN-LAST:event_btnSearchActionPerformed

    private void btnMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMenuActionPerformed
        Menu menu = new Menu();
        menu.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_btnMenuActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
          try {

            eliminarDesdeTabla();

        } catch (Exception ex) {
            //ystem.out.println(ex.getMessage());
        }
    }//GEN-LAST:event_btnDeleteActionPerformed

    /**
     * @param args the command line arguments
     */
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnActualzar;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnMenu;
    private javax.swing.JButton btnSearch;
    private javax.swing.JTextArea fieldAct;
    private javax.swing.JTextArea fieldAddress;
    private javax.swing.JTextArea fieldDescription;
    private javax.swing.JTextField fieldLat;
    private javax.swing.JTextField fieldLong;
    private javax.swing.JTextField fieldName;
    private javax.swing.JTextField fieldPrice;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTable tabla_sitios;
    // End of variables declaration//GEN-END:variables
}
