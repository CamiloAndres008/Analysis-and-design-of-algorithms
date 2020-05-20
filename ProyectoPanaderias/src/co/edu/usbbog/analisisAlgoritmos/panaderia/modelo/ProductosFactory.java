/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.usbbog.analisisAlgoritmos.panaderia.modelo;

import co.edu.usbbog.analisisAlgoritmos.panaderia.controlador.conexion.ProductosDAO;
import co.edu.usbbog.analisisAlgoritmos.panaderia.controlador.logica.ControladorProductos;
import co.edu.usbbog.analisisAlgoritmos.panaderia.controlador.logica.ControladorVentas;
import java.security.Principal;
import java.util.Date;


/**
 *
 * @author Camilo y Roberth
 */
public class ProductosFactory implements ProductosFactoryMethod {
    ControladorProductos controladorProductos;
   // ProductosDAO pDAO;
    @Override
    public boolean crearProducto(String nombre, String marca, Double costo, Integer cantidad) {
        Productos productoN = new Productos(nombre, marca, costo, cantidad);
        controladorProductos.agregarProducto(productoN);
     //   pdao.crearMySQL(productoN);
        return true;
    }
}
