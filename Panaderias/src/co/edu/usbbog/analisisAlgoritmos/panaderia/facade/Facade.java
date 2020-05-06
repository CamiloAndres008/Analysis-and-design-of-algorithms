/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.usbbog.analisisAlgoritmos.panaderia.facade;

import co.edu.usbbog.analisisAlgoritmos.panaderia.modelo.Productos;
import co.edu.usbbog.analisisAlgoritmos.panaderia.modelo.ProductosFactory;
import co.edu.usbbog.analisisAlgoritmos.panaderia.modelo.Ventas;
import co.edu.usbbog.analisisAlgoritmos.panaderia.modelo.VentasFactory;

/**
 *
 * @author Camilo y Roberth
 */
public class Facade {

    private ProductosFactory pFactory;
    private VentasFactory vFactory;
    public void nuevoProducto(String nombre,String marca,Double costo,Integer cantidad ) {
        pFactory.crearProducto(nombre, marca, costo, cantidad);
    }
    
    public void nuevaVenta(Ventas venta,String productoVendido,String fecha, Integer cantidad){
        vFactory.generarVenta(productoVendido, fecha, cantidad);
    }
}
