/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.usbbog.analisisAlgoritmos.panaderia.modelo;

import java.util.Date;
import java.util.Objects;

/**
 *
 * @author Camilo y Roberth
 */
public class Productos {

    private String nombre;
    private String marca;
    private Double costo;
    private int cantidad;
     
    private Productos siguiente;

    public Productos() {
    }

    public Productos(String nombre, String marca, Double costo, int cantidad) {
        this.nombre = nombre;
        this.marca = marca;
        this.costo = costo;
        this.cantidad = cantidad;
    }    
    
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    

    public Double getCosto() {
        return costo;
    }

    public void setCosto(Double costo) {
        this.costo = costo;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

   

    public Productos getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(Productos siguiente) {
        this.siguiente = siguiente;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 97 * hash + Objects.hashCode(this.nombre);
        hash = 97 * hash + Objects.hashCode(this.marca);
        hash = 97 * hash + Objects.hashCode(this.costo);
        hash = 97 * hash + this.cantidad;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Productos other = (Productos) obj;
        if (this.cantidad != other.cantidad) {
            return false;
        }
        if (!Objects.equals(this.nombre, other.nombre)) {
            return false;
        }
        if (!Objects.equals(this.marca, other.marca)) {
            return false;
        }
        if (!Objects.equals(this.costo, other.costo)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Productos{" + "nombre=" + nombre + ", marca=" + marca  + ", costo=" + costo + ", cantidad=" + cantidad + '}';
    }

}
