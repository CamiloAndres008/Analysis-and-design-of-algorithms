/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.usbbog.datan.niote.modelo;

import java.util.Date;

/**
 *
 * @author Camilo y Roberth
 */
public interface VentasFactoryMethod {

    public Boolean generarVenta(Double ventaT,Date fecha,Integer cantidad,Ventas venta,Productos producto);

}
