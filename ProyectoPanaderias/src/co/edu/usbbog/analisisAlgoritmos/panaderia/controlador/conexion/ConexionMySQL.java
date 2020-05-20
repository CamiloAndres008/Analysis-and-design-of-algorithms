/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.usbbog.analisisAlgoritmos.panaderia.controlador.conexion;

import com.mysql.jdbc.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Camilo y Roberth
 */
public class ConexionMySQL {
    private final String ip;
    private final int port;
    private final String user;
    private final String db;
    private final String password;
    private Connection con;
    
    public ConexionMySQL(String ip, int port, String db, String user, String password) {
        this.ip = ip;
        this.port = port;
        this.db = db;
        this.user = user;
        this.password = password;
    }
    
    public boolean conectar(){
        String path = 
                "jdbc:mysql://" + this.ip + 
                ":" + this.port + 
                "/" + this.db + 
                "?user=" + this.user +
                "&password=" + this.password;  
        System.out.println(path);
        try {
            this.con = (Connection) DriverManager.getConnection(path);
            if (this.con!=null) {
                return true;
            } else {
                return false;
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return false;
        }
    }   

    public Connection getCon() {
        return con;
    }
}