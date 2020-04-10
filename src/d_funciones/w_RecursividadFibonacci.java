package d_funciones;

import java.util.Scanner;

public class w_RecursividadFibonacci {
    public static void main(String[] args) {
        //Implementar una funcion recursiva que realice la serie FIBONNACI

        // x=0;
        // y=1;
        // v_design_patterns=1;
        //0 1 1 2 3 5 8 13 21 .....fibonnaci
     /*
    v_design_patterns=x+y;1 2 3 5 8 13 21 34
    x=y;  1 1 2 3 5 8  13 21
    y=v_design_patterns;  1 2 3 5 8 13 21 34

    v_design_patterns=1 2 3 5 8 13 21 34....
    */
        int numero;
        Scanner sc = new Scanner(System.in);
        System.out.println("Ingrese un numero");
        numero = sc.nextInt();
        System.out.print("0 "); //pa que imprima el 0 antes hacemos como si contaramos el 0
        //el return de fibonacci solo envia un valor por eso en el principal hacemos un boucle para que nos envie todos
        for (int i = 1; i < numero; i++) {//no imprime el 0 por eso empieza de 1 para que i sea 1
            System.out.print(fibonacci(i) + " ");//si pongo de 1 a 4 imprimira 1 1 2 3
        }//al poner 4 por ejemplo decimos que queremos los 4 primeros valores
    }

    private static int fibonacci(int numero) {//cada numero se va descomponiendo izquierda y derecha trabajan separados de manera independiente// al final se suman
        if (numero == 1 || numero == 2) {//caso base// 1 y 2 en el for por ejemplo no entras al else..se quedan en el if y envian 1
            return 1;
        } else {//caso recursivo+ imaginemos el numero 4 en la 1era pasada seria f(3) + f(2)   el f(2) dara 1..f(3) --> f(2) + f(1) =1 + 1
            return fibonacci(numero - 1) + fibonacci(numero - 2);
        }//elemento que queremos hayar es igual a la suma de los 2 anteriores
    }
}//IMAGINEMOS QUE QUIERO HAYAR EL ELEMENTO EN LA POSICION 4:
// el elemento 0 no se puede imprimir, se empieza a contar desde 1
//en este algoritmo vamos a entregar un solo valor
//fibonacci(3)+fibonacci(2) esto seria luego giran de nuevo y
//fibonacci(2) + fibonacci(1) aqui ya serian 1 y 2 y cumplirian con el caso base
// fibonacci(2) + fibonacci(1) +fibonacci(2)
//      1       +     1        +     1 =3 el ma posicion 4 esta entonces el 3
//este algoritmo no toma encuenta el 0      0 1 1 2 3 5 ....
//esto solo retorna un valor asi que necesitamos un boucle para obtener todos
//los valores
