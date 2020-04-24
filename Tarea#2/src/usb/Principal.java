/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package usb;

import java.util.Scanner;

/**
 *
 * @author Camilo y Roberth
 */
public class Principal {

    public static void main(String[] args) {

        Scanner lector = new Scanner(System.in);

        try {
            /*
            Digitacion del valor
             */
            System.out.println("Ingrese la cantidad");
            Integer valor = lector.nextInt();
            /*
        Inicializacion de las diferentes cantidades de billetes
             */
            int cien = 0;
            int cincuenta = 0;
            int veinte = 0;
            int diez = 0;
            int cinco = 0;
            int dos = 0;
            int uno = 0;
            boolean salir = true;
            while (salir) {

                /*
            Obtencion de las cantidades de billetes 
                 */
                if (valor >= 100) {
                    cien = cien + 1;
                    valor = valor - 100;
                } else if (valor >= 50) {
                    cincuenta = cincuenta + 1;
                    valor = valor - 50;
                } else if (valor >= 20) {
                    veinte = veinte + 1;
                    valor = valor - 20;
                } else if (valor >= 10) {
                    diez = diez + 1;
                    valor = valor - 10;
                } else if (valor >= 5) {
                    cinco = cinco + 1;
                    valor = valor - 5;
                } else if (valor >= 2) {
                    dos = dos + 1;
                    valor = valor - 2;
                } else if (valor >= 1) {
                    uno = uno + 1;
                    valor = valor - 1;
                } else {
                    salir = false;
                }
            }

            /*
        Impresion del resultado
             */
            System.out.println(valor);
            System.out.println(cien + " nota(s) de R$ 100,00");
            System.out.println(cincuenta + " nota(s) de R$ 50,00");
            System.out.println(veinte + " nota(s) de R$ 20,00");
            System.out.println(diez + " nota(s) de R$ 10,00");
            System.out.println(cinco + " nota(s) de R$ 5,00");
            System.out.println(dos + " nota(s) de R$ 2,00");
            System.out.println(uno + " nota(s) de R$ 1,00");
        } catch (Exception InputMismatchException) {
            System.out.println("No se pueden digitar datos alfanmericos");
        }
    }
}
