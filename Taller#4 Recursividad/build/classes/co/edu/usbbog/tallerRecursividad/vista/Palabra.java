/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.usbbog.tallerRecursividad.vista;

/**
 *
 * @author Camilo y Roberth
 */
public class Palabra {
    public String palabra;
    public int repeticiones = 1;

    public Palabra(String palabra) {
        this.palabra = palabra;
    }

    public String getPalabra() {
        return palabra;
    }

    public void setPalabra(String palabra) {
        this.palabra = palabra;
    }

    public int getRepeticiones() {
        return repeticiones;
    }

    public void setRepeticiones(int repeticiones) {
        this.repeticiones = repeticiones;
    }

    @Override
    public String toString() {
        return palabra + ": "+ repeticiones+" veces";
    }
    
}

