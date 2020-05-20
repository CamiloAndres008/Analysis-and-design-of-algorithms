/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.usbbog.analisisAlgoritmos.panaderia.controlador.conexion;

import co.edu.usbbog.analisisAlgoritmos.panaderia.modelo.Ventas;

/**
 *
 * @author Camilo y Roberth
 */
public interface VentasDTO {
    public boolean crearMySQL(Ventas venta);

    public boolean editarMySQL(Ventas venta);

    public boolean eliminarMySQL(Integer idVenta);

    public boolean mostrarProductos();
    
    public boolean buscarPorNombre(Integer idVenta);
    
    public String obtenerVentaDelDia(String dia);
}
