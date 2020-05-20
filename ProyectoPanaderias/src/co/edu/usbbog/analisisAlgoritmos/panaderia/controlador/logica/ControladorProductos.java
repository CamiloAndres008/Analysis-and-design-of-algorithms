/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.usbbog.analisisAlgoritmos.panaderia.controlador.logica;

import co.edu.usbbog.analisisAlgoritmos.panaderia.controlador.conexion.ProductosDAO;
import co.edu.usbbog.analisisAlgoritmos.panaderia.controlador.conexion.VentasDAO;
import co.edu.usbbog.analisisAlgoritmos.panaderia.modelo.Productos;
import co.edu.usbbog.analisisAlgoritmos.panaderia.modelo.Ventas;

/**
 *
 * @author Camilo y Roberth
 */
public class ControladorProductos {

    public Productos topeProductos;
    public int totalProductos;
    ProductosDAO productosDAO;
    String arr[];
    public ProductosDAO pDAO;
    public VentasDAO vDAO;

    public ControladorProductos() {
        this.totalProductos = 0;
        arr = new String[2];
        this.pDAO = new ProductosDAO();
    }

    public void setTopeProductos(Productos topeProductos) {
        this.topeProductos = topeProductos;
    }

    public void setTotalProductos(int totalProductos) {
        this.totalProductos = totalProductos;
    }

    public Productos getTopeProductos() {
        return topeProductos;
    }

    public int getTotalProductos() {
        return totalProductos;
    }

    public boolean estaVacio() {
        if (topeProductos == null) {
            return true;
        } else {
            return false;
        }

    }

    public boolean agregarProducto(Productos elemento) {
        if (estaVacio() == true) {
            topeProductos = elemento;
            totalProductos++;
            pDAO.crearMySQL(elemento);
            return true;
        } else {
            if (valirdarExistente(elemento) == true) {
                return false;
            } else {
                Productos aux = topeProductos;
                topeProductos = elemento;
                topeProductos.setSiguiente(aux);
                totalProductos++;
                pDAO.crearMySQL(elemento);
                return true;
            }
        }
    }

    public void eliminarProducto(Productos borrado) {
        if (this.topeProductos.getNombre().equalsIgnoreCase(borrado.getNombre())) {
            Productos siguiente = this.topeProductos.getSiguiente();
            this.topeProductos = siguiente;
            this.totalProductos--;
            Productos p = pDAO.buscarPorNombre(borrado.getNombre());
            pDAO.eliminarMySQL(p.getNombre());
        } else {
            Productos anterior = null;
            Productos actual = this.topeProductos;
            boolean encontro = false;
            while (actual != null && !encontro) {
                if (actual.getNombre().equalsIgnoreCase(borrado.getNombre())) {
                    pDAO.eliminarMySQL(borrado.getNombre());
                    encontro = true;
                } else {
                    anterior = actual;
                    actual = actual.getSiguiente();
                }
            }
            if (encontro) {
                anterior.setSiguiente(actual.getSiguiente());
                pDAO.eliminarMySQL(borrado.getNombre());

            }
            this.totalProductos--;
            pDAO.eliminarMySQL(borrado.getNombre());

        }
    }

    public int totalProductos() {
        return this.totalProductos;
    }

    public Productos buscarPorNombre(String buscado) {
        if (pDAO.buscarPorNombre(buscado) == null) {
            Productos aux = topeProductos;
            while (aux != null) {
                if (aux.getNombre().equalsIgnoreCase(buscado)) {

                    return aux;
                }
                aux = aux.getSiguiente();
            }
            return null;
        } else {
            return pDAO.buscarPorNombre(buscado);
        }
    }

    public boolean valirdarExistente(Productos elemento) {
        Productos aux = topeProductos;
        while (aux != null) {
            if (aux.getNombre().equalsIgnoreCase(elemento.getNombre())) {
                return true;
            }
            aux = aux.getSiguiente();
        }
        return false;
    }

    public String[] darProductos() {
        String aviones[] = new String[this.totalProductos];
        String actual = " ";
        Productos aux = this.topeProductos;
        int cont = 0;

        while (aux != null) {
            {
                actual = "Matricula: " + aux.getNombre() + ",......... ";
                aviones[cont] = actual;
                cont++;
            }
            aux = aux.getSiguiente();
        }
        return aviones;
    }

}
