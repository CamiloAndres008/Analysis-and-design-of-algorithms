/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.usbbog.datan.niote.controlador.conexion;

import co.edu.usbbog.datan.niote.modelo.Productos;
import java.util.List;

/**
 *
 * @author 305
 */
public interface ProductosDTO {
    
    public boolean crearMySQL(Productos productos);

    public boolean editarMySQL(Productos productos);

    public boolean eliminarMySQL(String nombre);

    public List<Productos> buscarTodoLosProductosMySQL();

    public Productos buscarProductosPorNombreMySQL(String nombre);

    public int cantidadProductosMySQL();
}