/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.usbbog.datan.niote.controlador.logica;

import co.edu.usbbog.datan.niote.modelo.Productos;
import co.edu.usbbog.datan.niote.modelo.Ventas;
import co.edu.usbbog.datan.niote.vista.Principal;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Camilo y Roberth
 */
public class ControladorVentas {

    private Principal principal;
    public Ventas topeVentas;
    public int totalVentas;
    ControladorProductos controladorProductos;
    String arr[];

    public ControladorVentas() {
        this.totalVentas = 0;
        arr = new String[2];
    }

    public void setTopeVentas(Ventas topeVentas) {
        this.topeVentas = topeVentas;
    }

    public void setTotalVentas(int totalVentas) {
        this.totalVentas = totalVentas;
    }

    public Ventas getTopeVentas() {
        return topeVentas;
    }

    public int getTotalVentas() {
        return totalVentas;
    }

    public boolean vacio() {
        if (topeVentas == null) {
            return true;
        } else {
            return false;
        }
    }

    public boolean nuevaVenta(Ventas elemento, Productos producto, Integer cantidad) {
        if (vacio() == true) {
            topeVentas = elemento;
            totalVentas++;
            restarProducto(producto, cantidad);
            return true;
        } else {
            Ventas aux = topeVentas;
            topeVentas = elemento;
            topeVentas.setSiguiente(aux);
            restarProducto(producto, cantidad);
            totalVentas++;
            return true;

        }
    }

    public String[] mostrarVentas() {
        String aviones[] = new String[this.totalVentas];
        String actual = "";
        Ventas aux = this.topeVentas;
        int cont = 0;

        while (aux != null) {
            {
                actual = "Usuario: " + aux.getFecha() + ", Contraseña: " + aux.getVentaTotal();
                aviones[cont] = actual;
                cont++;
            }
            aux = aux.getSiguiente();
        }
        return aviones;
    }

    public void restarProducto(Productos producto, Integer cantidad) {
        producto.setCantidad(producto.getCantidad() - cantidad);
    }

    //
    public Double calcularPrecio(String producto, Integer cantidad) {
        Productos productoIngresado = null;
        productoIngresado = controladorProductos.buscarPorNombre(producto);
        return productoIngresado.getCosto() * cantidad;
    }

}
