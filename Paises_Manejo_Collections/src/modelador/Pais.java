/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelador;

import java.util.Objects;

/**
 *
 * @author Camilo y Roberth
 */
public class Pais {

    //Variables de Pais
    public Pais siguiente;

    private String nombrePais;
    private Integer numContagiados;
    private Integer numMuertes;

    /**
     * Constructor para inicializar la clase
     */
    public Pais() {
        this.nombrePais = "";
        this.numContagiados = 0;
        this.numMuertes = 0;

    }

    /**
     * Constructor de Pais, en este caso, es obligatorio agregar todas las
     * variables para que sea agregado un pais.
     *
     * @param nombrePais
     * @param numContagiados
     * @param numMuertes
     */
    public Pais(String nombrePais, Integer numContagiados, Integer numMuertes) {
        this.nombrePais = nombrePais;
        this.numContagiados = numContagiados;
        this.numMuertes = numMuertes;
    }

    /*
    Getters y Setters
     */
    public String getNombrePais() {
        return nombrePais;
    }

    public void setNombrePais(String nombrePais) {
        this.nombrePais = nombrePais;
    }

    public Integer getNumContagiados() {
        return numContagiados;
    }

    public void setNumContagiados(Integer numContagiados) {
        this.numContagiados = numContagiados;
    }

    public Integer getNumMuertes() {
        return numMuertes;
    }

    public void setNumMuertes(Integer numMuertes) {
        this.numMuertes = numMuertes;
    }

    public Pais getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(Pais siguiente) {
        this.siguiente = siguiente;
    }

    /**
     * Metodo toString
     *
     * @return Pais
     */
    @Override
    public String toString() {
        return "Pais( " + "nombre:" + nombrePais + ", numero de contagiados:" + numContagiados + ", numero de muertes:" + numMuertes + ')';
    }

    /**
     * Metodo hashCode
     *
     * @return hash
     */
    @Override
    public int hashCode() {
        int hash = 5;
        hash = 43 * hash + Objects.hashCode(this.nombrePais);
        hash = 43 * hash + Objects.hashCode(this.numContagiados);
        hash = 43 * hash + Objects.hashCode(this.numMuertes);
        return hash;
    }

    /**
     * Metodo equals
     *
     * @param obj
     * @return verdadero si ya esta agregado, falso si no lo esta
     */
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
        final Pais other = (Pais) obj;
        if (!Objects.equals(this.nombrePais, other.nombrePais)) {
            return false;
        }
        if (!Objects.equals(this.numContagiados, other.numContagiados)) {
            return false;
        }
        if (!Objects.equals(this.numMuertes, other.numMuertes)) {
            return false;
        }
        return true;
    }
}
