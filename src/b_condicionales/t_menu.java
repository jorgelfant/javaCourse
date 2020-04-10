package b_condicionales;

import java.util.Scanner;

public class t_menu {
    public static void main(String[] args) {
        //Menu que tenga 3 opciones:
        //opcion 1: Elevar un numero a la potencia X
        //opcion 2: Sacar la raiz cuadrada de un numero
        //opcion 3:Salir
        int opcion;
        int numero;
        int potencia;
        char resp;
        Scanner sc = new Scanner(System.in);

        do {
            do {
                System.out.println("Ingrese una opcion: \nOpcion 1: Elevar numero a una potencia x \nOpcion 2: Sacar raiz cuadrada " +
                        "de un numero \nOpcion 3: Salir ");
                opcion = sc.nextInt();
            } while (opcion != 1 && opcion != 2 && opcion != 3);

            System.out.println("Ingrese un numero");
            numero = sc.nextInt();

            if (opcion == 1) {
                System.out.println("Ingrese la potencia");
                potencia = sc.nextInt();
                System.out.println("resultado de su operacion es " + Math.pow(numero, potencia));
            } else if (opcion == 2) {
                System.out.println("resultado de su operacion es " + Math.sqrt(numero));
            }
            do {
                System.out.println("Desea continuar ? 'si' o 'no'");
                sc.nextLine();
                resp = sc.nextLine().charAt(0);
            } while (resp != 's' && resp != 'n');

            if (resp == 'n') {//ou !='s'
                System.out.println("Hasta luego");
            }
        } while (resp == 's');
    }
}
