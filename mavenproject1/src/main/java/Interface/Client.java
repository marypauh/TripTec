/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Interface;
import Api.Api;
import Main.Main;
import Structures.GestionEdges;
import Structures.ListNode;
import Structures.Site;
import Table.ModeladorTablas;
import com.google.maps.errors.ApiException;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTable;
import Structures.GestionSites;
import Structures.Graph;

/**
 *
 * @author marip
 */
public class Client extends javax.swing.JFrame {
    public int contador = 0;
    Api api = new Api();
    
    public GestionSites gestion_sitios;

    public GestionSites getGestion_sitios() {
        return gestion_sitios;
    }

    public void setGestion_sitios(GestionSites gestion_sitios) {
        this.gestion_sitios = gestion_sitios;
    }

    
    
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
       public JTable getTabla_cliente() {
        return tabla_cliente;
    }

    public void setTabla_cliente(JTable tabla_cliente) {
        this.tabla_cliente = tabla_cliente;
    }
    
 /** Creates new form Empresa */
    public Client() {
        initComponents();
        this.setLocationRelativeTo(null);
    }
    
    public void actualizarTabla() {

        ModeladorTablas.vaciarTabla(tabla_cliente);
        Object[] filaNueva;
        ListNode<Site> temp = gestion_sitios.getSites().getInicio();
        for (int i = 0; i < gestion_sitios.getSites().getSize(); i++) {
            filaNueva = new Object[]{temp.getElemento().getId(),
                temp.getElemento().getName(),
                temp.getElemento().getPrice(),
                temp.getElemento().getDescription(),
                temp.getElemento().getActivities(),
                temp.getElemento().getLat(),
                temp.getElemento().getLng(),
                temp.getElemento().getAddress()};
            ModeladorTablas.nuevaFila(tabla_cliente, filaNueva);
            temp = temp.getNodoSig();
        }
    }

     public void eliminarDesdeTabla() throws Exception {
        int rowNum = tabla_cliente.getSelectedRow();
        String elim = ModeladorTablas.obtenerValorCelda(tabla_cliente, rowNum, 0);//ModeladorTablas.obtenerValorCelda(tabla_animales, rowNum, 0);
        gestion_sitios.deleteSites(elim);
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

        btnMenu = new javax.swing.JButton();
        txtDistancia = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        txtDuracion = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        btnActualizar = new javax.swing.JButton();
        txtName = new javax.swing.JTextField();
        fieldaddress2 = new javax.swing.JTextField();
        fieldAddress1 = new javax.swing.JTextField();
        btnOrigen = new javax.swing.JButton();
        btnDestino = new javax.swing.JButton();
        txtide1 = new javax.swing.JTextField();
        txtid2 = new javax.swing.JTextField();
        txtName2 = new javax.swing.JTextField();
        btnTour = new javax.swing.JButton();
        btnAgregar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabla_cliente = new javax.swing.JTable();
        lblTitulo = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnMenu.setBackground(new java.awt.Color(255, 255, 255));
        btnMenu.setForeground(new java.awt.Color(0, 153, 153));
        btnMenu.setText("Menu");
        btnMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMenuActionPerformed(evt);
            }
        });
        getContentPane().add(btnMenu, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 370, -1, -1));
        getContentPane().add(txtDistancia, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 440, 110, -1));

        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Distancia");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 440, -1, -1));
        getContentPane().add(txtDuracion, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 440, 100, -1));

        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Duración");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 440, -1, -1));

        btnActualizar.setBackground(new java.awt.Color(255, 255, 255));
        btnActualizar.setForeground(new java.awt.Color(0, 153, 153));
        btnActualizar.setText("Actualizar");
        btnActualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActualizarActionPerformed(evt);
            }
        });
        getContentPane().add(btnActualizar, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 370, -1, -1));

        txtName.setText("jTextField1");
        getContentPane().add(txtName, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 100, -1, -1));

        fieldaddress2.setText("jTextField1");
        getContentPane().add(fieldaddress2, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 180, -1, -1));

        fieldAddress1.setText("jTextField1");
        getContentPane().add(fieldAddress1, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 140, -1, -1));

        btnOrigen.setForeground(new java.awt.Color(0, 153, 153));
        btnOrigen.setText("Elegir origen");
        btnOrigen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOrigenActionPerformed(evt);
            }
        });
        getContentPane().add(btnOrigen, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 370, -1, -1));

        btnDestino.setForeground(new java.awt.Color(0, 153, 153));
        btnDestino.setText("Elegir Destino");
        btnDestino.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDestinoActionPerformed(evt);
            }
        });
        getContentPane().add(btnDestino, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 370, -1, -1));

        txtide1.setText("jTextField1");
        getContentPane().add(txtide1, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 240, -1, -1));

        txtid2.setText("jTextField1");
        getContentPane().add(txtid2, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 290, -1, -1));

        txtName2.setText("jTextField1");
        getContentPane().add(txtName2, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 340, -1, -1));

        btnTour.setForeground(new java.awt.Color(0, 153, 153));
        btnTour.setText("Ver Tour");
        btnTour.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTourActionPerformed(evt);
            }
        });
        getContentPane().add(btnTour, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 440, -1, -1));

        btnAgregar.setBackground(new java.awt.Color(255, 255, 255));
        btnAgregar.setForeground(new java.awt.Color(0, 153, 153));
        btnAgregar.setText("Agregar");
        btnAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarActionPerformed(evt);
            }
        });
        getContentPane().add(btnAgregar, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 370, -1, -1));

        tabla_cliente.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(tabla_cliente);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 80, 560, 275));

        lblTitulo.setFont(new java.awt.Font("Roboto", 1, 24)); // NOI18N
        lblTitulo.setForeground(new java.awt.Color(255, 255, 255));
        lblTitulo.setText("Crear Ruta Cliente");
        getContentPane().add(lblTitulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 30, -1, -1));

        jPanel1.setBackground(new java.awt.Color(0, 153, 153));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 670, 480));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMenuActionPerformed
        Menu menu =  new Menu();
        menu.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_btnMenuActionPerformed

    private void btnActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizarActionPerformed
        this.actualizarTabla();
    }//GEN-LAST:event_btnActualizarActionPerformed

    private void btnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarActionPerformed
        Api api = new Api();
        try {
            String a = String.valueOf(api.getDuration(fieldAddress1.getText(),fieldaddress2.getText()));
            txtDuracion.setText(a);
            String b = String.valueOf(api.getDriveDist(fieldAddress1.getText(),fieldaddress2.getText()));
            txtDistancia.setText(b);
        } catch (ApiException ex){
            Logger.getLogger(Empresa.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InterruptedException ex) {
            Logger.getLogger(Empresa.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Empresa.class.getName()).log(Level.SEVERE, null, ex);
        }
        String id = String.valueOf(contador);
        String nombre = txtName.getText();
       String duracion = txtDuracion.getText();
       String distancia = txtDistancia.getText();
        int origen = Integer.parseInt(txtide1.getText());
        int destino = Integer.parseInt(txtid2.getText());
        String address = fieldAddress1.getText();
       
        this.getGestion_edges().createEdges(id,nombre,duracion,distancia,address);
        
        Graph graph = new Graph();
        graph.addEdge(origen, destino,0);
    }//GEN-LAST:event_btnAgregarActionPerformed

    private void btnOrigenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOrigenActionPerformed
        int indice = tabla_cliente.getSelectedRow();
        String data = (String)tabla_cliente.getValueAt(indice, 7);
        fieldAddress1.setText(data);
        String name = (String)tabla_cliente.getValueAt(indice, 1);
        txtName.setText(name);
        String id = (String)tabla_cliente.getValueAt(indice,0);
        txtide1.setText(id);
    }//GEN-LAST:event_btnOrigenActionPerformed

    private void btnDestinoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDestinoActionPerformed
        int indice = tabla_cliente.getSelectedRow();
        String data = (String)tabla_cliente.getValueAt(indice, 7);
        fieldaddress2.setText(data);
        String id = (String)tabla_cliente.getValueAt(indice,0);
        txtid2.setText(id);
        String name = (String)tabla_cliente.getValueAt(indice, 1);
        txtName2.setText(name);
    }//GEN-LAST:event_btnDestinoActionPerformed

    private void btnTourActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTourActionPerformed
        TourClient clienttour = new TourClient();
        clienttour.setVisible(true);
         this.setVisible(false);
        
         clienttour.setGestion_edges(Main.edges);// global lista
        
        
        Object[] columnasEdges = new Object[] {"Id","Nombre","Distancia","Duracion", "Direccion"};        
        clienttour.getTabla_tour().setModel(ModeladorTablas.generarModeloDeTabla(5, columnasEdges));
        clienttour.getTabla_tour().setAutoCreateRowSorter(true);
        clienttour.actualizarTabla();
        
    }//GEN-LAST:event_btnTourActionPerformed

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnActualizar;
    private javax.swing.JButton btnAgregar;
    private javax.swing.JButton btnDestino;
    private javax.swing.JButton btnMenu;
    private javax.swing.JButton btnOrigen;
    private javax.swing.JButton btnTour;
    private javax.swing.JTextField fieldAddress1;
    private javax.swing.JTextField fieldaddress2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JTable tabla_cliente;
    private javax.swing.JTextField txtDistancia;
    private javax.swing.JTextField txtDuracion;
    private javax.swing.JTextField txtName;
    private javax.swing.JTextField txtName2;
    private javax.swing.JTextField txtid2;
    private javax.swing.JTextField txtide1;
    // End of variables declaration//GEN-END:variables

}
