package h_java;

public class B_datos {
    //METODO 1 para llenar arreglo
    public static int[] rellenarArreglo(int numero) {
        int[] arreglo = new int[10];
        for (int i = 0; i < arreglo.length; i++) {
            arreglo[i] = numero;
            numero += 5;//numero=numero+5;
        }
        return arreglo;//imprimir(arreglo) podriamos usar la funcion imprimir aqui
    }

    //METODO 2 para imprimirlo
    public static void imprimir(int[] array) {//CETTE FONCTIION POURRAIT ETRE DANS LA FONCTION RELLENAR (una funcion dentro de otra)
        System.out.println("Imprimir datos: ");
        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i]);
        }
    }
}

