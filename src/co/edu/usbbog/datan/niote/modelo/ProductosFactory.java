/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.usbbog.datan.niote.modelo;

import co.edu.usbbog.datan.niote.controlador.conexion.ProductosDAO;
import co.edu.usbbog.datan.niote.controlador.logica.ControladorProductos;
import java.security.Principal;

/**
 *
 * @author Camilo y Roberth
 */
public class ProductosFactory implements ProductosFactoryMethod {

    Principal principal;
    ControladorProductos controlador;
    private ProductosDAO pdao;

    @Override
    public Boolean crearProducto(String nombre, String marca, Double costo, Integer cantidad) {

        Productos productoN = new Productos(nombre, marca, costo, cantidad);
        System.out.println(productoN);
        //  pdao.crearMySQL(productoN);
        return true;
    }
}
