/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package usb;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Camilo y Roberth
 */
public class Principal {

    /**
     * Punto 1 Los parametros que entran van a ser validados. Objetivo: Generar
     * una lista donde el primer numero es el menor entre los dos de entrada y
     * el segundo numero es hasta donde llegara la lista y saber cual es la suma
     * de los numeros que estan en la lista. Salida: Lista de numeros desde el
     * menor hasta el mayor con la suma de estos.
     *
     * @param numero1
     * @param numero2
     */
    public void punto1(int numero1, int numero2) {
        // Definicion de variables.
        int tamanio;
        int serie;
        tamanio = Math.abs(numero1 - numero2);
        ArrayList<Integer> array = new ArrayList<Integer>();
        int aux, suma = 0;

        //Validacion de cual es el numero menor para inciiar con este la lista.
        if (numero1 > numero2) {
            //For para generar la lista de numeros con la suma interior.
            for (int i = 0; i < tamanio + 1; i++) {
                serie = numero2 + i;
                array.add(serie);
                suma = array.get(i) + suma;
                aux = suma;
            }
            System.out.println(array.toString() + "Sum= " + suma);
        } else {
            //For para generar la lista de numeros con la suma interior.
            for (int i = 0; i < tamanio + 1; i++) {
                serie = numero1 + i;
                array.add(serie);
                suma = array.get(i) + suma;
                aux = suma;
            }
            System.out.println(array.toString() + " Sum= " + suma);
        }
    }

    /**
     * Punto 2 Los parametros que entran van a ser validados. Objetivo: Saber si
     * fueron ingresados de forma creciente o decreciente. Salida: Decreciente
     * si el primer numero es mayor que el dos o creciente de lo contrario.
     *
     * @param numero1
     * @param numero2
     */
    public void punto2(int numero1, int numero2) {
        //Validacion de cual de los numero es mayor o menor
        if (numero1 < numero2) {
            //Si el numero 1 es menor que el 2 es creciente 
            System.out.println("Creciente");
        } else {
            //Si el numero 2 es menor que el 1 es decreciente 
            System.out.println("Decreciente");
        }
    }

    public static void main(String[] args) {

        Scanner lector = new Scanner(System.in);
        Principal p = new Principal();
        try {
            System.out.println("Digite los dos numeros");
            int numero1 = lector.nextInt();
            int numero2 = lector.nextInt();
            System.out.println(" ");
            p.punto1(numero1, numero2);
            // p.punto2(numero1, numero2);
        } catch (Exception InputMismatchException) {
            System.out.println("No se pueden ingresar datos alfanumericos, solo en enteros");
        }

    }
}
