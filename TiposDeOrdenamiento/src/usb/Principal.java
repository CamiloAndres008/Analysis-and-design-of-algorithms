package usb;

import java.util.Scanner;

public class Principal {

    public static void main(String[] args) {

        int tamano;

        Scanner lector = new Scanner(System.in);
        System.out.println("Digite la longitud del vector");

        tamano = lector.nextInt();

        // Crear array de tama�o N digitado por el usuario
        int ArrayN[] = new int[tamano];

        /**
         * Bucle para rellenar el array con lo que el usuario digite
         */
        for (int i = 0; i < ArrayN.length; i++) {
            System.out.println("Digite el numero para el elemento " + (i + 1) + " : ");
            ArrayN[i] = lector.nextInt();
        }

        /**
         * Metodo para mostrar el arreglo desardonado
         */
        System.out.println("********* Sin Ordenar ********");
        mostrarArreglo(ArrayN);
        System.out.println("�Quiere ordenar el arreglo? S/N");
        String respuestaUsuario = lector.next();

        // Si la persona digita "S"=si
        if (respuestaUsuario.equalsIgnoreCase("S")) {
            System.out.println("******ORDENADO******");
            //bubbleSort(ArrayN);
            //insercionDirecta(ArrayN);
            //divisor(ArrayN, 1, 1);
        }
    }

    /**
     * Metodo para mostrar el arreglo
     *
     * @param arrayN
     */
    private static void mostrarArreglo(int[] arrayN) {
        System.out.println("|------------------------|");
        for (int i = 0; i < arrayN.length; i++) {
            System.out.println("Elemento" + (i + 1) + "-------->" + arrayN[i] + "\n");
        }
    }

    // Bubble Sort -> ORdenamiento Burbuja
    /**
     * Metodo para organizar el arreglo mediante burbuja
     *
     * @param arrayN
     */
    private static void bubbleSort(int[] arrayN) {
        //Ciclo array a array-1	
        for (int i = 0; i < arrayN.length - 1; i++) {
            for (int j = 0; j < arrayN.length - 1; j++) {
                //Preguntar (anterior con el siguiente)
                if (arrayN[j] > arrayN[j + 1]) {
                    int temp = arrayN[j + 1];
                    arrayN[j + 1] = arrayN[j];
                    arrayN[j] = temp;
                }
            }
        }
        //Se llama el metodo para imprimir el arreglo organizado
        mostrarArreglo(arrayN);
    }

    /**
     * Metodo para organizar el arreglo mediante insercion directa
     *
     * @param arrayN
     */
    private static void insercionDirecta(int[] arrayN) {
        int aux1, aux2;
        for (int i = 1; i < arrayN.length; i++) { //Desde el segundo elemento
            aux1 = arrayN[i]; //Guardo un elemento
            aux2 = i - 1; //Inicio en el anterior
            while ((aux2 >= 0) && (aux1 < arrayN[aux2])) { //Mientras queden en posicion valor aux sea menor a los que desplazo             
                arrayN[aux2 + 1] = arrayN[aux2];
                aux2--;
            }
            arrayN[aux2 + 1] = aux1;
        }
        //Se llama el metodo para imprimir el arreglo organizado
        mostrarArreglo(arrayN);
    }

    private static void seleccion(int[] arrayN) {
        int menor, pos, temp;
        for (int i = 0; i < arrayN.length; i++) { //Tomamos el elemento menor como el primero
            menor = arrayN[i]; //El menor lo guarod y el resto falta por organizar
            pos = i; //En esta variable se guarda la posicion

            for (int j = i + 1; j < arrayN.length; j++) { //Busqueda en el resto del vector
                if (arrayN[j] < menor) {
                    menor = arrayN[j]; //Menor que el actual
                    pos = j;
                }
            }

            //Si hay alguno menor lo intercambio
            if (pos != i) {
                temp = arrayN[i];
                arrayN[i] = arrayN[pos];
                arrayN[pos] = temp;
            }
        }
        //Se llama el metodo para imprimir el arreglo organizado
        mostrarArreglo(arrayN);
    }

    private void divisor(int arrayN[], int izquierda, int derecha) {

        if (derecha > izquierda) {
            int mitad = ((derecha + izquierda) / 2);
            divisor(arrayN, izquierda, mitad); //Parte izquierda
            divisor(arrayN, mitad + 1, derecha); //Parte derecha
            mergeSort(arrayN, izquierda, mitad + 1, derecha); //Entrega de los valores
        }

    }

    private void mergeSort(int ArrayN[], int izquieda, int mitad, int derecha) {

        int contador = 0;

        int i = izquieda, j = mitad, d = derecha, tamanio = ArrayN.length;

        int[] aux = new int[tamanio]; //Se crea un vector auxiliar para almacenar las divisiones

        while ((i <= mitad - 1) && (j <= derecha)) { //Mientras i esta en la parte izquuierda y j en la derecha, se realizara el proceso

            if (ArrayN[i] <= ArrayN[j]) { //Se comparan los valores
                aux[d++] = ArrayN[i++];
            } else {
                aux[d++] = ArrayN[j++];
            }
        }

        //Toma los valores y los pone en su correcta posicion
        while (i <= mitad - 1) {
            aux[d++] = ArrayN[i++];
        }
        while (j <= derecha) {
            aux[d++] = ArrayN[j++];
        }

        for (i = izquieda; i <= derecha; i++) {
            ArrayN[i] = aux[i];
        }

        //Impresion del arreglo ordenado
        mostrarArreglo(ArrayN);

    }

    private void generarMargeSort(int ArrayN[], int izquierda, int derecha) {
        divisor(ArrayN, 1, 1);
    }
}
