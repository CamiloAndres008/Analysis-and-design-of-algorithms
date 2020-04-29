/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.usbbog.datan.niote.controlador.conexion;

import co.edu.usbbog.datan.niote.modelo.Productos;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

/**
 *
 * @author Camilo y Roberth
 */
public class ProductosDAO implements ProductosDTO {

    private final ConexionBD mySQL;

    public ProductosDAO() {
        this.mySQL = new ConexionBD();
    }

    @Override
    public boolean crearMySQL(Productos productos) {
        if (productos != null) {
            String sql = "INSERT INTO panaderia_db.producto VALUES(";
            sql += productos.getNombre() + ", ";
            sql += "'" + productos.getMarca() + "'" + ", ";
            sql += "'" + productos.getCosto() + "'" + ", ";
            sql += productos.getCantidad() + ", ";

            sql += ");";
            System.out.println(sql);
            if (this.mySQL.obtenerConexion() != null) {
                Connection con = this.mySQL.obtenerConexion();
                try {
                    Statement stm = con.createStatement();
                    stm.execute(sql);
                    stm.close();
                    con.close();
                    return true;
                } catch (SQLException ex) {
                    System.out.println(ex.getMessage());
                    return false;
                }
            } else {
                return false;
            }
        } else {
            return false;
        }
    }

    @Override
    public boolean editarMySQL(Productos productos) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean eliminarMySQL(String nombre) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Productos> buscarTodoLosProductosMySQL() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Productos buscarProductosPorNombreMySQL(String nombre) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int cantidadProductosMySQL() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
