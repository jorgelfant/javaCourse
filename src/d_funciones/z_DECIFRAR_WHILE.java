package d_funciones;

import java.util.Scanner;

public class z_DECIFRAR_WHILE {
    public static void main(String[] args) {
        //Decifrar un mensaje, escrimbimos por ejemplo una palabra o frase
        //esta se almacenara en una matriz, para leer el mensaje
        //deberemos leer el primer elemento de cada fila despues el 2 de cada
        //fila y asi sucesivamente

        //entrada: cadena del mensaje cifrado
        //         2 enteros que definen el tamanio de la matriz
        //Salida: Impresion de la matriz con el mensaje decifrado

        //condiciones y restricciones: No puede ser separado ni por espacios,
        // comas, puntos o cualquier tipo de separacion

        //Datos adicionales: mostrar Null para los datos en blanco de la matriz
        int fila;
        String palabra;

        Scanner sc = new Scanner(System.in);
        System.out.println("Ingrese la palabra");
        palabra = sc.nextLine();
        System.out.println("Ingrese el numero de filas");
        fila = sc.nextInt();

        int a = 0;
        int pos = 0;
        String palabraDecifrada = "";

        int i = 0;
        while (i <= palabra.length() - 1) {//para que vaya hasta el ultimo indice e imprima toda la frase
            if (a > palabra.length() - 1) {
                pos++;
                a = pos;//reiniciar 0   1   2   3   4
            } else {
                palabraDecifrada = palabraDecifrada.concat(palabra.substring(a, a + 1));
                a += fila;
            }
            i++;
        }//peredrscreolasrgonuermopsaaae mstr acep reno          hay que poner 5 y 9
        System.out.println(palabraDecifrada);
    }//frase: "peredrscreolasrgonuermopsaaae mstr acep reno" 5   o  sino "hao omm lii ago" 4
}//COMPOSITION: programar eslomasce rcanoaten ersuperpo deres
//                  0         1         2          3       4
//lee toda la frase una vez comenzando de a=0 y aumentando de 5 en 5  osea 0 5 10 etc
//cuando a super el tamanio de la frase, se le aumenta 1 asi
//pasariamos de nuevo por la frase pero a=1 y aumentando de 5 en 5 osea 1 6 11 etc
