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
public class Ventas {

    private Date fecha;
    private Double ventaTotal;
    private Ventas siguiente;

    public Ventas() {
    }

    public Ventas(Double vnetaTotal, Date fechaActual) {
        this.ventaTotal = vnetaTotal;
        this.fecha = fechaActual;
    }

    public Double getVentaTotal() {
        return ventaTotal;
    }

    public void setVentaTotal(Double ventaTotal) {
        this.ventaTotal = ventaTotal;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Ventas getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(Ventas siguiente) {
        this.siguiente = siguiente;
    }

}
