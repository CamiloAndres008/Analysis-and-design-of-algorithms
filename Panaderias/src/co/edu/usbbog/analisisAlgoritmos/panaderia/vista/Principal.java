/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.usbbog.analisisAlgoritmos.panaderia.vista;

import co.edu.usbbog.analisisAlgoritmos.panaderia.controlador.conexion.ConexionMySQL;
import co.edu.usbbog.analisisAlgoritmos.panaderia.controlador.conexion.ProductosDAO;
import co.edu.usbbog.analisisAlgoritmos.panaderia.controlador.conexion.VentasDAO;
import co.edu.usbbog.analisisAlgoritmos.panaderia.controlador.logica.ControladorProductos;
import co.edu.usbbog.analisisAlgoritmos.panaderia.controlador.logica.ControladorVentas;
import co.edu.usbbog.analisisAlgoritmos.panaderia.modelo.Productos;
import co.edu.usbbog.analisisAlgoritmos.panaderia.modelo.ProductosFactory;
import co.edu.usbbog.analisisAlgoritmos.panaderia.modelo.Ventas;
import co.edu.usbbog.analisisAlgoritmos.panaderia.facade.Facade;
import java.sql.SQLException;
import javax.swing.JPanel;

/**
 *
 * @author Camilo y Roberth 8:22pm
 */
public class Principal extends javax.swing.JFrame {

    /*
    Relaciones
     */
    //Navegacion paneles
    public InicioJPanel inicioJPanel;
    public GestionPanaderiaJPanel gestionPanaderiaJPanel;
    public NuevaVentaJPanel nuevaVentaJPanel;
    public AgregarProductoJPanel agregarProducto;
    public Buscar_ModificarProductoJPanel buscar_ModificarProductoJPanel;
    public EliminarProductoJPanel eliminarProductoJPanel;
    public EstadisticasJPanel estadisticasJPanel;

    //Panel de dialogo
    public VentanaDialog ventanaDialog;

    //Controladores
    public Productos productos;
    public ProductosDAO pDAO;
    public Ventas ventas;
    public VentasDAO vDAO;

    public ControladorProductos controladorProductos;
    public ControladorVentas controladorVentas;
    ConexionMySQL conexion;
    Facade facade;
    ProductosFactory productosFactory;

    /**
     * Creates new form Principal
     */
    public Principal() {
        this.facade = new Facade();
        this.productosFactory = new ProductosFactory();

        controladorProductos = new ControladorProductos();
        controladorVentas = new ControladorVentas();
        productos = new Productos();
        ventas = new Ventas();

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle("LOGIC");
        setName("pricipalJFrame");
        setResizable(false);
        pack();
        setLocationRelativeTo(null);
        iniciar();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 22, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 16, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Principal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
    //Navegacion desde inicio
    public void iniciar() {
        inicioJPanel = new InicioJPanel(this);
        inicioJPanel.setVisible(true);
        add(inicioJPanel);
        pack();
        setLocationRelativeTo(null);
    }

    //Navegacion entre paneles
    public void irAGestion(JPanel jPanel) {
        remove(jPanel);
        gestionPanaderiaJPanel = new GestionPanaderiaJPanel(this);
        gestionPanaderiaJPanel.setVisible(true);
        add(gestionPanaderiaJPanel);
        pack();
        setLocationRelativeTo(null);
    }

    protected void irANuevaVenta() {
        nuevaVentaJPanel = new NuevaVentaJPanel(this);
        ventanaDialog = new VentanaDialog(this, nuevaVentaJPanel, "Ventana", false, false, DISPOSE_ON_CLOSE);
    }

    protected void irAAgregarProducto() {
        agregarProducto = new AgregarProductoJPanel(this);
        ventanaDialog = new VentanaDialog(this, agregarProducto, "Ventana", false, false, DISPOSE_ON_CLOSE);
    }

    protected void irABuscarProducto() {
        buscar_ModificarProductoJPanel = new Buscar_ModificarProductoJPanel(this);
        ventanaDialog = new VentanaDialog(this, buscar_ModificarProductoJPanel, "Ventana", false, false, DISPOSE_ON_CLOSE);
    }

    protected void irAEliminarProducto() {
        eliminarProductoJPanel = new EliminarProductoJPanel(this);
        ventanaDialog = new VentanaDialog(this, eliminarProductoJPanel, "Ventana", false, false, DISPOSE_ON_CLOSE);
    }

    protected void irAEstadisticas() {
        estadisticasJPanel = new EstadisticasJPanel(this);
        ventanaDialog = new VentanaDialog(this, estadisticasJPanel, "Ventana", false, false, DISPOSE_ON_CLOSE);
    }

}
