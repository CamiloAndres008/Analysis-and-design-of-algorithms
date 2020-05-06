/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.usbbog.analisisAlgoritmos.panaderia.modelo;

import java.util.Date;
import java.util.List;

/**
 *
 * @author Camilo y Roberth
 */
public class Ventas {

    private String productosVendidos;
    private String fecha;
    private Integer cantidad;
    private Ventas siguiente;

    public Ventas() {
    }

    public Ventas(String productosVendidos, String fecha, Integer cantidad) {
        this.productosVendidos = productosVendidos;
        this.fecha = fecha;
        this.cantidad = cantidad;
    }

    public String getProductosVendidos() {
        return productosVendidos;
    }

    public void setProductosVendidos(String productosVendidos) {
        this.productosVendidos = productosVendidos;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public Ventas getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(Ventas siguiente) {
        this.siguiente = siguiente;
    }

   
}
