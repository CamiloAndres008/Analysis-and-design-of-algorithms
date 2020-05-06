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
public class VentasFactory implements VentasFactoryMethod {

    ControladorVentas controladorVentas;
    ControladorProductos controladorProductos;
    private ProductosDAO pdao;

    @Override
    public Boolean generarVenta(String productosVendidos, String fecha, Integer cantidad) {
        Productos pVendido = controladorProductos.buscarPorNombre(productosVendidos);
        Ventas ventasN = new Ventas(productosVendidos, fecha, cantidad);
        controladorVentas.nuevaVenta(ventasN, pVendido, cantidad);
        return true;
    }
}
