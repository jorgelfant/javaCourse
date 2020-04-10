package d_funciones;

import java.util.Scanner;

public class q_Menu_DoWhile {
    public static void main(String[] args) {

        principal();//funcion ObjectA que contiene su cuerpo y otras funciones dentro

    }

    //FUNCIONES Y PROCEDURES  una funcion puede poseder otras funciones
//1 ObjectA es una procedure
    private static void principal() {
        int numero;
        int exponente;
        int opcion;
        Scanner sc = new Scanner(System.in);
/*
    Disene un algoritmo que muestre un menu al usuario con las sgtes opciones: potenciacion/raiz cuadrada
    y terminar. Que cada opcion la realize una funcion o procedimiento
    */
        do {//avec do while pas besoin d'iniciar la variable antes, podemos solo declarla
            System.out.println("Elija una de las opciones siguientes: \n Potenciacion: 1 \n Raiz cuadrada: 2 \n Terminar: 3");
            opcion = sc.nextInt();

            if (opcion == 1) {
                System.out.println("Elija un numero");
                numero = sc.nextInt();
                System.out.println("Elija  un exponente");
                exponente = sc.nextInt();
                System.out.println(potenciacion(numero, exponente));
            } else if (opcion == 2) {
                System.out.println("Elija un numero");
                numero = sc.nextInt();
                System.out.println(raizCuadrada(numero));
            } else if (opcion == 3) {
                System.out.println(terminar());
            } else {
                System.out.println("Los valores deben estar comprendidos entre 1 y 3");
            }
            System.out.println();
        } while (opcion != 3);
    }

    //2 funcion que estara en la funcion ObjectA
    private static double potenciacion(double numero, double exponente) {
        return Math.pow(numero, exponente);
    }

    //3 funcion que estara en la funcion ObjectA
    private static double raizCuadrada(double numero) {
        return Math.sqrt(numero);
    }

    //4 funcion que estara en la funcion ObjectA
    private static String terminar() {
        return "Hasta luego";
    }

}
