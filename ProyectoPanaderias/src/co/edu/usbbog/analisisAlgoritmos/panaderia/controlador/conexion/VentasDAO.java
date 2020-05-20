/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.usbbog.analisisAlgoritmos.panaderia.controlador.conexion;

import co.edu.usbbog.analisisAlgoritmos.panaderia.modelo.Productos;
import co.edu.usbbog.analisisAlgoritmos.panaderia.modelo.Ventas;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Camilo y Roberth
 */
public class VentasDAO implements VentasDTO {

    private final ConexionMySQL mySQL;
    static Connection conexion = null;
    static Statement sentencia;
    static ResultSet resultado;

    public VentasDAO() {
        this.mySQL = new ConexionMySQL("127.0.0.1", 3306, "panaderia", "root", "password");
    }

    public static void conectar() {
        String ruta = "jdbc:mysql://localhost/Panaderia";
        String user = "root";
        String pass = "password";
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conexion = DriverManager.getConnection(ruta, user, pass);
            sentencia = conexion.createStatement();
            System.out.println("Conectado");
        } catch (Exception e) {
            System.out.println("No conectado");
        }
    }

    public boolean crearMySQL(Ventas venta) {

        if (venta != null) {
            String sql = "INSERT INTO panaderia.ventas (productos,fecha,cantidad) VALUES(";
            sql += "\"" + venta.getProductosVendidos() + "\"" + ", ";
            sql += "\"" + venta.getFecha() + "\""+", ";
            sql += venta.getCantidad();

            sql += ");";
            System.out.println(sql);
            if (this.mySQL.conectar()) {
                Connection con = this.mySQL.getCon();
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

    /*public boolean editarMySQL(Ventas venta) {
        if (venta != null) {
            String sql = "UPDATE panaderia.productos SET marca=";
            sql += "\"" + producto.getMarca() + "\"" + ", ";
            sql += "costo= " + producto.getCosto() + ", ";
            sql += "cantidad= " + producto.getCantidad();
            sql += " WHERE nombre=";
            sql += "\"" + producto.getNombre() + "\"";
            sql += ";";
            System.out.println(sql);
            if (this.mySQL.conectar()) {
                Connection con = this.mySQL.getCon();
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
    }*/
    public boolean eliminarMySQL(Integer idVenta) {
        String sql = "DELETE FROM panaderia.ventas WHERE "
                + "idVenta = " + "\"" + idVenta + "\"" + ";";
        System.out.println(sql);

        if (this.mySQL.conectar()) {
            Connection con = this.mySQL.getCon();
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
    }

    public boolean mostrarProductos() {
        String sql = "SELECT * FROM persona_db.ventas;";
        System.out.println(sql);
        if (this.mySQL.conectar()) {
            Connection con = this.mySQL.getCon();
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
    }

    public boolean buscarPorNombre(Integer idVenta) {
        ConexionBD obj_DB_Connection = new ConexionBD();
        Connection connection = obj_DB_Connection.get_connection();
        PreparedStatement ps = null;
        try {

            String query = "select * from panaderia.productos where idVenta=";
            query += "\"" + idVenta + "\"" + ";";
            ps = connection.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                System.out.println("Prducto[ " + "nombre: " + rs.getString("nombre") + " marca: " + rs.getString("marca") + " fecha: " + rs.getString("fecha_vencimiento") + " costo: " + rs.getInt("costo") + " cantidad: " + rs.getInt("cantidad") + " ]");
            }
            return true;
        } catch (Exception e) {
            System.out.println(e);
        }
        return false;
    }

    @Override
    public boolean editarMySQL(Ventas venta) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String obtenerVentaDelDia(String dia) {
        ConexionBD obj_DB_Connection = new ConexionBD();
        Connection connection = obj_DB_Connection.get_connection();
        PreparedStatement ps1 = null;

        PreparedStatement ps2 = null;
        try {
            String use = "USE `panaderia`;";
            String query = "SELECT SUM(vent.cantidad*pro.costo) as ventaDelDia FROM panaderia.ventas as vent inner join panaderia.productos as pro on vent.productos=pro.nombre where vent.fecha=";
            query += "" + dia + "" + ";";
            System.out.println(query);
            ps1 = connection.prepareStatement(use);
            System.out.println(use);
            ps2 = connection.prepareStatement(query);
            ResultSet rs = ps2.executeQuery();
            while (rs.next()) {
                return "Ventas: " + rs.getDouble("ventaDelDia");
            }
            
        } catch (Exception e) {
            System.out.println(e);
        }
        return null;
    }
}
