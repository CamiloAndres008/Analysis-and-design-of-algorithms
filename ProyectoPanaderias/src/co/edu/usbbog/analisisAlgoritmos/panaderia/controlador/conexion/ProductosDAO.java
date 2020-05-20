/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.usbbog.analisisAlgoritmos.panaderia.controlador.conexion;

import co.edu.usbbog.analisisAlgoritmos.panaderia.modelo.Productos;
import com.mysql.jdbc.ResultSetRow;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.sql.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Camilo y Roberth
 */
public class ProductosDAO implements ProductosDTO {

    private final ConexionMySQL mySQL;
    static Connection conexion = null;
    static Statement sentencia;
    static ResultSet resultado;

    public ProductosDAO() {
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

    public boolean crearMySQL(Productos producto) {
        if (producto != null) {
            String sql = "INSERT INTO panaderia.productos VALUES(";
            sql += "\"" + producto.getNombre() + "\"" + ", ";
            sql += "\"" + producto.getMarca() + "\"" + ", ";
            sql += producto.getCosto() + ", ";
            sql += producto.getCantidad();
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

    public boolean editarMySQL(Productos producto) {
        if (producto != null) {
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
    }

    public boolean eliminarMySQL(String producto) {
        String sql = "DELETE FROM panaderia.productos WHERE "
                + "nombre = " + "\"" + producto + "\"" + ";";
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

    public Productos buscarPorNombre(String nombre) {
        ConexionBD obj_DB_Connection = new ConexionBD();
        Connection connection = obj_DB_Connection.get_connection();
        PreparedStatement ps = null;
        Productos pro = new Productos();
        try {
            String query = "select * from panaderia.productos where nombre=";
            query += "\"" + nombre + "\"" + ";";
            ps = connection.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            System.out.println(query);
            while (rs.next()) {
                pro = new Productos(rs.getString("nombre"), rs.getString("marca"), rs.getDouble("costo"), rs.getInt("cant"));
                return pro;
            }
        } catch (Exception e) {
            System.out.println(e);
            return null;
        }
        return pro;
    }

    public boolean restarCantidad(Productos producto) {
        if (producto != null) {
            String sql = "UPDATE productos SET cant=";
            sql += "\"" + producto.getCantidad() + "\"" + " ";
            sql += "WHERE nombre='" + producto.getNombre() + "\'";
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

    }

    public List<Productos> buscarTodosLosProductos() {
        ConexionBD obj_DB_Connection = new ConexionBD();
        Connection connection = obj_DB_Connection.get_connection();
        PreparedStatement ps = null;
        String sql = "SELECT * FROM panaderia.productos;";
        List<Productos> listaProductos = new ArrayList<>();
        if (this.mySQL.conectar()) {
            try {

                ps = connection.prepareStatement(sql);
                ResultSet rs = ps.executeQuery();

                System.out.println(" - * - * " + rs.getRow());
                while (rs.next()) {
                    Productos e = new Productos(rs.getString("nombre"),
                            rs.getString("marca"),
                            rs.getDouble("costo"),
                            rs.getInt("cant")
                    );
                    listaProductos.add(e);
                }
                rs.close();
                connection.close();
            } catch (SQLException ex) {
                Logger.getLogger(ProductosDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return listaProductos;
    }
    
}
