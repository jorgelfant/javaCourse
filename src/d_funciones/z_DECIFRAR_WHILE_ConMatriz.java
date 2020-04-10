package d_funciones;

import java.util.Scanner;

public class z_DECIFRAR_WHILE_ConMatriz {
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

        String palabra;
        String palabraDecifrada = "";
        int fila;
        int columna;
        int a = 0;
        int pos = 0;
        Scanner sc = new Scanner(System.in);
        System.out.println("Ingrese una palabra");
        palabra = sc.nextLine();

        System.out.println("Ingrese el numero de filas");//en realidad es el i que contiene cada letra 0 5 10 etc
        fila = sc.nextInt();
        System.out.println("Ingrese el numero de columnas");//en realidad es el i que contiene cada letra 0 5 10 etc
        columna = sc.nextInt();

        char[][] tab = new char[fila][columna];

        int i = 0;
        while (i <= palabra.length() - 1) {//recorre toda la palabra 0 a 44 en este caso espacio al final frase
            if (a > palabra.length() - 1) {// 40  41  42  43  44
                pos++;
                a = pos;
            } else {
                palabraDecifrada = palabraDecifrada.concat(palabra.substring(a, a + 1));
                a += fila;
            }
            i++;//no lo pongo dentro del else porque si lo hago contaria tb los espacios
        }     //y la fraseDecifrada tendria el mismo length que la frase inicial
        System.out.println(palabraDecifrada);

        //******************************************************************************************************************
        //                       PONEMOS LA FRASE DECIFRADA EN UNA MATRIZ
        //******************************************************************************************************************
        int avance = 0;
        for (int j = 0; j < fila; j++) {
            for (int k = 0; k < columna; k++) {
                if (avance < palabraDecifrada.length()) {
                    tab[j][k] = palabraDecifrada.charAt(avance);//esto tendra espacios al final porque la frase junta todas las palabras
                    avance++;
                } else {//cuando el iterador avance sea igual al length o mayor va a imprimir esto
                    tab[j][k] = '*';
                }
            }
        }
        //******************************************************************************************************************
        //                                 IMPRESSION
        //******************************************************************************************************************
        for (int j = 0; j < fila; j++) {
            for (int k = 0; k < columna; k++) {
                System.out.print(tab[j][k] + "\t");
            }
            System.out.println();
        }
    }
}
/*
//frase: "peredrscreolasrgonuermopsaaae mstr acep reno " 5 sino "hao omm lii ago" 4

0<palabra.legnth 45 un espacio debe ser agregado al final de la frase
porque 4 9 14 19 24 29 34 39 44   44 cae en el ultimo espacio asi que hay que incluirlo

p	r	o	g	r	a	m	a	r       0  5  10  15  20  25  30  35  40 '45'       0  1  2  3  4  5  6  7  8  9
e	s	l	o	m	a	s	c	e       1  6  11  16  21  26  31  36  41 '46'       10 11 12 13 14 15 16 17 18 19
r	c	a	n	o	a	t	e	n       2  7  12  17  22  27  32  37  42 '47'       20 21 22 23 24 25 26 27 28 29
e	r	s	u	p	e	r	p	o       3  8  13  18  23  28  33  38  43 '44'       30 31 32 33 34 35 36 37 38 39
d   e   r   e   s	*	*	*	*	    4  9  14  19  24  29  34  39  44 '49'       40 41 42 43 44

*/
