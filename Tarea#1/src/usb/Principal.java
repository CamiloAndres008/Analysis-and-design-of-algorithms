/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package usb;

import java.text.DecimalFormat;
import java.util.Scanner;

/**
 *
 * @author Camilo y Roberth
 */
public class Principal {

    /*public String calcular(Double tiempo, Double velocidad) {
        Double distancia = velocidad * tiempo;;
        return System.out.println(resultado.format(distancia / 12)); //resultado =  (distancia/12);
    }*/
    public static void main(String[] args) {
        DecimalFormat resultado = new DecimalFormat("#.000");
        Scanner lector = new Scanner(System.in);
        Integer tiempo, velocidad;

        try {

            /**
             * Digitacion de los datos
             */
            System.out.println("Digite el tiempo que duro el viaje (en horas)");
            tiempo = lector.nextInt();
            System.out.println("Digite la velocidad media del viaje (en Km/h)");
            velocidad = lector.nextInt();

            /**
             * Ecuacion de distancia
             */
            Double distancia = (double) velocidad * tiempo;
            System.out.println("Litros de combustibles necesarios: " + resultado.format(distancia / 12)); //resultado =  (distancia/12);
        } catch (Exception InputMismatchException) {
            System.out.println("No se pueden digitar datos alfanmericos");
        }
    }
}
