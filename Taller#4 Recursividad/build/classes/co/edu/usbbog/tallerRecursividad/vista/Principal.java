/*

 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.usbbog.tallerRecursividad.vista;

import co.edu.usbbog.tallerRecursividad.controlador.CargarFichero;
import co.edu.usbbog.tallerRecursividad.controlador.ControladorPunto3;
import co.edu.usbbog.tallerRecursividad.controlador.ControladorPunto5;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Scanner;

/**
 *
 * @author Camilo y Roberth
 */
public class Principal {

    Scanner lectorMetodos = new Scanner(System.in);

    static int factorialIterativop1(int valor) {
        int resultado = 1;
        for (int i = 1; i <= valor; i++) {
            resultado = resultado * i;
        }
        return resultado;
    }

    static int factorialRecursivop1(int valor) {
        int resultado = 0;
        if (valor == 1) {
            return 1;
        } else {
            //Funcion recursiva
            resultado = valor * factorialRecursivop1(valor - 1);
        }
        return resultado;
    }

    static void fibonacciIterativop2(int valor) {
        int aux1 = 0, aux2 = 1, total = 1;
        System.out.print(aux1 + " ");
        for (int i = 1; i < valor; i++) {
            System.out.print(total + " ");
            total = aux1 + aux2;
            aux1 = aux2;
            aux2 = total;
        }

    }

    static int fibonacciRecursivop2(int valor) {
        int resultado = 0;
        if (valor == 0 || valor == 1) {
            return valor;
        } else {
            //Funcion recursiva
            resultado = fibonacciRecursivop2(valor - 1) + fibonacciRecursivop2(valor - 2);
        }
        return resultado;
    }

    static void impresionSerieFibonacciRecursivop2(int tamanio) {
        for (int i = 0; i < tamanio; i++) {
            System.out.print(fibonacciRecursivop2(i) + " ");
        }
    }

    static String invertirNumeroIterativop3(int valor) {
        String invertirNumeroString = String.valueOf(valor), invertirNumeroInvertido = null;
        for (int i = invertirNumeroString.length() - 1; i >= 0; i--) {
            invertirNumeroInvertido = invertirNumeroInvertido + invertirNumeroString.charAt(i);
        }
        return invertirNumeroInvertido;
    }

    static String invertirNumeroRecursivop3(int numeroAInvertir) {
        String numeroInvertidoString;
        if (numeroAInvertir < 10) {
            numeroInvertidoString = String.valueOf(numeroAInvertir);
            return numeroInvertidoString;
        } else {
            numeroInvertidoString = String.valueOf(numeroAInvertir % 10) + invertirNumeroRecursivop3(numeroAInvertir / 10);
            return numeroInvertidoString;
        }
    }

    static int[] llenadoVector(int tamanio) {
        Scanner lectorLlenado = new Scanner(System.in);
        int[] vector = new int[tamanio];
        for (int i = 0; i < tamanio; i++) {
            System.out.println("Digite el numero de la pos (" + (i + 1) + ")");
            vector[i] = lectorLlenado.nextInt();
        }
        return vector;
    }

    static int sumaVectorIterativop4(int vector[]) {
        Scanner lectorSumaVector = new Scanner(System.in);
        int sumaTotal = 0;
        for (int i = 0; i < vector.length; i++) {
            sumaTotal = sumaTotal + vector[i];
        }
        return sumaTotal;
    }

    static int sumaVectorRecursivop4(int vector[], int numero) {
        if (numero == 0) {
            return vector[numero];
        } else {
            return vector[numero] + sumaVectorRecursivop4(vector, numero - 1);

        }
    }

    static int numeroMenorVectorIterativop5(int vector[]) {
        int menor = vector[0];
        for (int i = 0; i < vector.length; i++) {
            if (vector[i] < menor) {
                menor = vector[i];
            }
        }
        return menor;
    }

    static int numeroMenorVectorRecursivop5(int vector[], int tamanio) {
        if (tamanio == 0) {
            return vector[0];
        } else {
            if (vector[tamanio] < numeroMenorVectorRecursivop5(vector, tamanio - 1)) {
                return vector[tamanio];
            } else {
                return numeroMenorVectorRecursivop5(vector, tamanio - 1);
            }
        }

    }

    static void calculadorap6(int numero1, int numero2) {
        int suma, resta, multiplicacion, division, potencia;
        if (numero1 > 0 && numero2 > 0) {
            suma = numero1 + numero2;
            System.out.println("Suma: " + suma);
            resta = numero1 - numero2;
            System.out.println("Resta:" + resta);
            multiplicacion = numero1 * numero2;
            System.out.println("Multiplicacion:" + multiplicacion);
            if (numero2 == 0) {
                System.out.println("No se puede dividir entre 0");
            } else {
                division = numero1 / numero2;
                System.out.println("Division:" + division);
            }
            potencia = (int) Math.pow(numero1, numero2);
            System.out.println("Potencia:" + potencia);
        } else {
            System.out.println("Solo se pueden numeros naturales");
        }
    }

    static int sumaRecursivop6(int numero1, int numero2) {
        if (numero1 == 0) {
            return numero2;
        } else if (numero2 == 0) {
            return numero1;
        } else {
            return 1 + sumaRecursivop6(numero1, numero2 - 1);
        }
    }

    static int restarRecursivop6(int numero1, int numero2) {
        if (numero1 == 0) {
            return -numero2;
        } else if (numero2 == 0) {
            return numero1;
        } else if (numero1 > numero2) {
            return 1 + restarRecursivop6(numero1, numero2 + 1);
        } else if (numero2 > numero1) {
            return -1 + restarRecursivop6(numero1 + 1, numero2);
        } else if (numero1 == numero2) {
            return 0;
        }
        return 0;
    }

    static int multiplicarRecursivop6(int numero1, int numero2) {
        if (numero1 == 0 || numero2 == 0) {
            return 0;
        } else if (numero1 == 1) {
            return numero2;
        } else if (numero2 == 1) {
            return numero1;
        } else {
            return numero1 + multiplicarRecursivop6(numero1, numero2 - 1);
        }
    }

    static int dividirRecursivop6(int numero1, int numero2) {
        if (numero2 > numero1) {
            return 0;
        } else if (numero1 == numero2) {
            return 1;
        } else {
            return 1 + dividirRecursivop6(numero1 - numero2, numero2);
        }
    }

    static int potenciaRecursivop6(int numero1, int numero2) {
        if (numero2 == 0) {
            return 1;
        } else {
            if (numero2 == 1) {
                return numero1;
            } else {
                return numero1 * potenciaRecursivop6(numero1, numero2 - 1);
            }
        }
    }

    static String[][] llenadoMatriz(int tamaniox, int tamanioy) {
        String[][] vector = new String[tamaniox][tamanioy];
        Scanner lectorLlenado = new Scanner(System.in);
        for (int i = 0; i < tamaniox; i++) {
            for (int j = 0; j < tamanioy; j++) {
                System.out.println("Digite el numero de la pos (" + (i + 1) + "," + (j + 1) + ")");
                vector[i][j] = lectorLlenado.next();
            }
        }
        return vector;
    }

    static void buscarStringIterativop7(String[][] matriz, String buscar) {
        int indice = -1;
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                if (buscar.equals(matriz[i][j])) {
                    indice = i;
                    System.out.println("Si esta");
                    break;
                } else {
                    System.out.println("No esta");
                }

            }
        }
    }

    static void buscarStringRecursivop7(String[][] matriz, String buscado, int tamaniox, int tamanioy) {
        if (buscado.equals(matriz[tamaniox][tamanioy])) {
            System.out.println("Si esta");
        } else if (tamanioy < matriz[tamanioy].length - 1 && tamaniox < matriz[tamaniox].length) {
            buscarStringRecursivop7(matriz, buscado, tamaniox, tamanioy);
            System.out.println("Si esta");
        }
        if (tamanioy == matriz[tamanioy].length - 1 && tamaniox < matriz[tamaniox].length - 1) {
            tamanioy = 0;
            tamaniox = tamaniox + 1;
            buscarStringRecursivop7(matriz, buscado, tamaniox, tamanioy);
            System.out.println("Si esta");
        } else {
            System.out.println("No esta");
        }
    }

    static boolean palindromop3_1(String valor) {
        if (valor.length() <= 1) {
            return true;
        } else {
            if (valor.charAt(0) == valor.charAt(valor.length() - 1)) {
                return palindromop3_1(valor.substring(1, valor.length() - 1));
            } else {
                return false;
            }
        }
    }

    static void permutaciones3_2(String a, LinkedList<String> conjunto) {
        if (conjunto.size() == 1) {
            System.out.println(a + conjunto.get(0));
        }
        for (int i = 0; i < conjunto.size(); i++) {
            String b = conjunto.remove(i);
            permutaciones3_2(a + b, conjunto);
            conjunto.add(i, b);
        }
    }

    static void poema() throws IOException {
        CargarFichero fichero = new CargarFichero();
        String cadena = fichero.poemaFile();
        System.out.println(cadena);
        fichero.vocal(cadena, 0, 0);
        fichero.consonante(cadena, 0, 0);
        fichero.espacio(cadena, 0, 0);
        fichero.palabras(cadena, 0);
    }

    static void torres3_5() {
        ControladorPunto5 t1 = new ControladorPunto5();
        t1.push(4);
        t1.push(3);
        t1.push(2);
        t1.push(1);
        ControladorPunto5 t2 = new ControladorPunto5();
        ControladorPunto5 t3 = new ControladorPunto5();
        boolean valor = true;
        while (valor) {
            t1.toString();
            t2.toString();
            t3.toString();
            System.out.println("¿De que torre quiere extraer?");
            Scanner lectorpunto5 = new Scanner(System.in);
            String opcionTorre = lectorpunto5.nextLine();
            String aux;
            switch (opcionTorre) {
                case "A":
                    System.out.println("¿A que torre va a mover?");
                    aux = lectorpunto5.nextLine();
                    switch (aux) {
                        case "B":
                            t2.pushh(t1.popp());
                            break;
                        case "C":
                            t3.pushh(t1.popp());
                            break;
                    }
                    break;
                case "B":
                    System.out.println("¿A que torre va a mover?");
                    aux = lectorpunto5.nextLine();
                    switch (aux) {
                        case "A":
                            t1.pushh(t2.popp());
                            break;
                        case "C":
                            t3.pushh(t2.popp());
                            break;
                    }
                    break;
                case "C":
                    System.out.println("¿A que torre va a mover?");
                    aux = lectorpunto5.nextLine();
                    switch (aux) {
                        case "A":
                            t1.pushh(t3.popp());
                            break;
                        case "B":
                            t2.pushh(t3.popp());
                            break;
                    }
                    break;
                default:
                    break;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        Scanner lector = new Scanner(System.in);
        System.out.println("***MENU***");
        System.out.println("Bienvenido");
        System.out.println("¿Que ejercicio quiere realizar?");
        System.out.println("***2 parte***");
        System.out.println("P1. Factorial");
        System.out.println("P2. Fibonacci");
        System.out.println("P3. Invertir numero");
        System.out.println("P4. Suma vector");
        System.out.println("P5. Num. menor");
        System.out.println("P6. Calculadora");
        System.out.println("P7. Buscar String");
        System.out.println("***3 parte***");
        System.out.println("P1_1(8). Palindromo");
        System.out.println("P1_1(9). Canciones");
        System.out.println("P1_1(10). Poemas");

        System.out.println("");
        int opcion = lector.nextInt();
        switch (opcion) {
            case 0:
                System.out.println("Vuelva Pronto");
                System.exit(0);
                break;
            case 1:
                System.out.println("Digite el numero");
                int numeroFactorial = lector.nextInt();
                System.out.println("Iterativo: " + factorialIterativop1(numeroFactorial));
                System.out.println("Recursivo: " + factorialRecursivop1(numeroFactorial));
                break;
            case 2:
                System.out.println("Digite el numero");
                int numeroFibonacci = lector.nextInt();
                System.out.println("Iterativo");
                fibonacciIterativop2(numeroFibonacci);
                System.out.println("Recursivo: " + fibonacciRecursivop2(numeroFibonacci));
                break;
            case 3:
                System.out.println("Digite el numero");
                int numeroAInvertir = lector.nextInt();
                System.out.println("Iterativo: " + invertirNumeroIterativop3(numeroAInvertir));
                System.out.println("Recursivo: " + invertirNumeroRecursivop3(numeroAInvertir));

                break;
            case 4:
                System.out.println("Digite el tamanio del vector");
                int tamanio = lector.nextInt();
                System.out.println("Iterativo: " + sumaVectorIterativop4(llenadoVector(tamanio)));
                System.out.println("Recursivo: " + sumaVectorRecursivop4(llenadoVector(tamanio), tamanio));
                break;
            case 5:
                System.out.println("Digite el tamanio del vector");
                int tamanioMenor = lector.nextInt();
                System.out.println("Iterativo: " + numeroMenorVectorIterativop5(llenadoVector(tamanioMenor)));
                System.out.println("Recursivo: " + numeroMenorVectorRecursivop5(llenadoVector(tamanioMenor), tamanioMenor));
                break;
            case 6:
                System.out.println("Digite el numero 1 y el numero 2");
                int numero1 = lector.nextInt();
                int numero2 = lector.nextInt();
                System.out.println("Iterativo: ");
                calculadorap6(numero1, numero2);
                System.out.println("Recursivo: Suma: " + sumaRecursivop6(numero1, numero2) + " Resta" + restarRecursivop6(numero1, numero2) + " Multiplicar: " + multiplicarRecursivop6(numero1, numero2) + " Division: " + dividirRecursivop6(numero1, numero2) + " Potencia:" + potenciaRecursivop6(numero1, numero2));
                break;
            case 7:
                System.out.println("Digite el tamanio de la matriz");
                int tamaniox = lector.nextInt();
                int tamanioy = lector.nextInt();
                System.out.println("Digite el String a buscar");
                String buscado = lector.next();
                System.out.println("Iterativo: ");
                buscarStringIterativop7(llenadoMatriz(tamaniox, tamanioy), buscado);
                System.out.println("Recursivo: ");
                buscarStringRecursivop7(llenadoMatriz(tamaniox, tamanioy), buscado, tamaniox, tamanioy);
                break;
            case 8:
                LinkedList<String> valores = new LinkedList<String>();
                String valoresDigitados;
                System.out.println("Digite el tamanio");
                int n = lector.nextInt();

                System.out.print("Entrada valores");
                for (int i = 0; i < n; i++) {
                    valoresDigitados = lector.next();
                    valores.add(valoresDigitados);
                }
                permutaciones3_2(" ", valores);
                break;
            case 9:
                ControladorPunto3 con= new ControladorPunto3();
                System.out.println("Cancion: ");
                String a = con.cancionFile(); 
                System.out.println("*¨*¨*CANCION: LETRA*¨*¨*");
                System.out.println(a);
               // con.vocal(a, 0);
                break;
            case 10:
                poema();
                break;
            case 11:
                torres3_5();
                break;
            default:
                System.out.println("Opcion no valida");
                break;
        }
    }
}
