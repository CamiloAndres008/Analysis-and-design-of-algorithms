/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador.logica;

import javax.swing.JList;
import javax.swing.JOptionPane;
import modelador.Pais;

/**
 *
 * @author Usuario
 */
public class ControladorPais {

    public Pais topePais;
    public int totalPaises;

    String arr[];

    public ControladorPais() {
        this.totalPaises = 0;
        arr = new String[2];
    }

    public void setTopePais(Pais topePais) {
        this.topePais = topePais;
    }

    public void setTotalPaises(int totalPaises) {
        this.totalPaises = totalPaises;
    }

    public Pais getTopePais() {
        return topePais;
    }

    public int getTotalPaises() {
        return totalPaises;
    }

    public boolean estaVacio() {
        if (topePais == null) {
            return true;
        } else {
            return false;
        }

    }

    public boolean agregar(Pais elemento) {
        if (estaVacio() == true) {
            topePais = elemento;
            totalPaises++;
            return true;
        } else {
            if (validarExiste(elemento) == true) {
                return false;
            } else {
                Pais aux = topePais;
                topePais = elemento;
                topePais.setSiguiente(aux);
                totalPaises++;
                return true;
            }
        }
    }

    public void eliminar(String borrado) {
        if (this.topePais.getNombrePais().equalsIgnoreCase(borrado)) {
            Pais siguiente = this.topePais.getSiguiente();
            this.topePais = siguiente;
            this.totalPaises--;
        } else {
            Pais anterior = null;
            Pais actual = this.topePais;
            boolean encontro = false;

            while (actual != null && !encontro) {
                if (actual.getNombrePais().equalsIgnoreCase(borrado)) {
                    encontro = true;
                } else {
                    anterior = actual;
                    actual = actual.getSiguiente();
                }
            }
            if (encontro) {
                anterior.setSiguiente(actual.getSiguiente());
            }
            this.totalPaises--;
        }
    }

    public Pais buscarPorNombre(String buscado) {
        Pais aux = topePais;

        while (aux != null) {
            if (aux.getNombrePais().equalsIgnoreCase(buscado)) {
                return aux;
            }
            aux = aux.getSiguiente();
        }
        return null;
    }

    public boolean validarExiste(Pais elemento) {
        Pais aux = topePais;
        while (aux != null) {
            if (aux.getNombrePais().equalsIgnoreCase(elemento.getNombrePais())) {
                return true;
            }
            aux = aux.getSiguiente();
        }
        return false;
    }

    public String[] darPaises() {
        String paises[] = new String[this.totalPaises];
        String actual = " ";
        Pais aux = this.topePais;
        int cont = 0;

        while (aux != null) {
            {
                actual = "Nombre: " + aux.getNombrePais() + ", N°. Contagiados: " + aux.getNumContagiados() + ", N°. Muertes: " + aux.getNumMuertes();
                paises[cont] = actual;
                cont++;
            }
            aux = aux.getSiguiente();
        }
        return paises;
    }

    public int totalPaises() {
        return this.totalPaises;
    }

}
