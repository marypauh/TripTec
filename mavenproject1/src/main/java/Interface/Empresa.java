/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Interface;
import Api.Api;
import Structures.LinkedList2;
import Main.Main;
import Structures.GestionSites;
import Structures.ListNode;
import Structures.Site;
import Table.ModeladorTablas;
import com.google.maps.errors.ApiException;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTable;

/**
 *
 * @author marip
 */
public class Empresa extends javax.swing.JFrame {
    
    private int contador = 0;
    
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
       public JTable getTabla_empresa() {
        return tabla_empresa;
    }

    public void setTabla_empresa(JTable tabla_empresa) {
        this.tabla_empresa = tabla_empresa;
    }
    
 /** Creates new form Empresa */
    public Empresa() {
        initComponents();
        this.setLocationRelativeTo(null);
    }
    
    public void actualizarTabla() {

        ModeladorTablas.vaciarTabla(tabla_empresa);
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
            ModeladorTablas.nuevaFila(tabla_empresa, filaNueva);
            temp = temp.getNodoSig();
        }
    }

     public void eliminarDesdeTabla() throws Exception {
        int rowNum = tabla_empresa.getSelectedRow();
        String elim = ModeladorTablas.obtenerValorCelda(tabla_empresa, rowNum, 0);//ModeladorTablas.obtenerValorCelda(tabla_animales, rowNum, 0);
        gestion_sitio.deleteSites(elim);
        actualizarTabla();
    }

   

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tabla_empresa = new javax.swing.JTable();
        lblTitulo = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        btnAgregar = new javax.swing.JButton();
        btnMenu = new javax.swing.JButton();
        txtDistancia = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtDuracion = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        fieldaddress1 = new javax.swing.JTextField();
        fieldaddress2 = new javax.swing.JTextField();
        jButton3 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tabla_empresa.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(tabla_empresa);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 80, 580, 280));

        lblTitulo.setFont(new java.awt.Font("Roboto", 1, 24)); // NOI18N
        lblTitulo.setForeground(new java.awt.Color(255, 255, 255));
        lblTitulo.setText("Crear Ruta Empresa");
        getContentPane().add(lblTitulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 30, -1, -1));

        jPanel1.setBackground(new java.awt.Color(0, 153, 153));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnAgregar.setBackground(new java.awt.Color(255, 255, 255));
        btnAgregar.setForeground(new java.awt.Color(0, 153, 153));
        btnAgregar.setText("Agregar");
        btnAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarActionPerformed(evt);
            }
        });
        jPanel1.add(btnAgregar, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 370, -1, -1));

        btnMenu.setBackground(new java.awt.Color(255, 255, 255));
        btnMenu.setForeground(new java.awt.Color(0, 153, 153));
        btnMenu.setText("Menu");
        btnMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMenuActionPerformed(evt);
            }
        });
        jPanel1.add(btnMenu, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 370, -1, -1));
        jPanel1.add(txtDistancia, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 460, 110, -1));

        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Distancia");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 460, -1, -1));

        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Duración");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 460, -1, -1));
        jPanel1.add(txtDuracion, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 460, 100, -1));

        jButton1.setBackground(new java.awt.Color(255, 255, 255));
        jButton1.setForeground(new java.awt.Color(0, 153, 153));
        jButton1.setText("Actualizar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 370, -1, -1));

        jButton2.setForeground(new java.awt.Color(0, 153, 153));
        jButton2.setText("Elegir origen");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 370, -1, -1));
        jPanel1.add(fieldaddress1, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 80, 110, -1));
        jPanel1.add(fieldaddress2, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 120, 110, -1));

        jButton3.setForeground(new java.awt.Color(0, 153, 153));
        jButton3.setText("Elegir destino");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 370, -1, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 690, 520));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMenuActionPerformed
        Menu menu =  new Menu();
        menu.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_btnMenuActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        this.actualizarTabla();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        int indice = tabla_empresa.getSelectedRow();
        String data = (String)tabla_empresa.getValueAt(indice, 7);
        fieldaddress1.setText(data);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        int indice = tabla_empresa.getSelectedRow();
        String data = (String)tabla_empresa.getValueAt(indice, 7);
        fieldaddress2.setText(data);
    }//GEN-LAST:event_jButton3ActionPerformed

    private void btnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarActionPerformed
        Api api = new Api();
        try {
            String a = String.valueOf(api.getDuration(fieldaddress1.getText(),fieldaddress2.getText()));
            txtDuracion.setText(a+" segundos");
            String b = String.valueOf(api.getDriveDist(fieldaddress1.getText(),fieldaddress2.getText()));
            txtDistancia.setText(b+"  metros");
        } catch (ApiException ex){
            Logger.getLogger(Empresa.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InterruptedException ex) {
            Logger.getLogger(Empresa.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Empresa.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }//GEN-LAST:event_btnAgregarActionPerformed

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgregar;
    private javax.swing.JButton btnMenu;
    private javax.swing.JTextField fieldaddress1;
    private javax.swing.JTextField fieldaddress2;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JTable tabla_empresa;
    private javax.swing.JTextField txtDistancia;
    private javax.swing.JTextField txtDuracion;
    // End of variables declaration//GEN-END:variables

}
