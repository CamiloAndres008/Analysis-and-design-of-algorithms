/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.usbbog.datan.niote.modelo;

import co.edu.usbbog.datan.niote.controlador.conexion.ProductosDAO;
import co.edu.usbbog.datan.niote.controlador.logica.ControladorProductos;
import co.edu.usbbog.datan.niote.controlador.logica.ControladorVentas;
import java.security.Principal;
import java.util.Date;

/**
 *
 * @author Camilo y Roberth
 */
public class VentasFactory implements VentasFactoryMethod {

    Principal principal;
    ControladorVentas controlador;
    private ProductosDAO pdao;

    @Override
    public Boolean generarVenta(Double ventaT, Date fecha, Integer cantidad, Ventas venta, Productos producto) {

        Ventas ventasN = new Ventas(ventaT, fecha);
        controlador.nuevaVenta(venta, producto, cantidad);
        return true;
    }
}
