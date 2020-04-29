/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.usbbog.datan.niote.controlador.conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Camilo y Roberth
 */
public class ConexionBD {

    private static String DRIVER = "com.mysql.jdbc.Driver";
    private static String USUARIO = "root";
    private static String CONTRASENA = "password";
    private static String URL = "jdbc:mysql://localhost:3306/panaderia_db";

    public ConexionBD() {
    }

    static {
        try {
            Class.forName(DRIVER);
        } catch (ClassNotFoundException e) {
            JOptionPane.showMessageDialog(null, "Error" + e);
        }
    }

    public Connection obtenerConexion() {
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(URL, USUARIO, CONTRASENA);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error" + e);
        }
        return conn;
    }
}
