package d_funciones;

import java.util.Scanner;

public class r_CambioMoneda {
    public static void main(String[] args) {
        //Desarrollar un programa que pueda calcular el valor del tipo de cambio de moneda
        // ( de tu moneda-hacia dolar y viceversa )

        //Procedure principale
        tipoCambio();
    }

    private static void tipoCambio() {//PROCEDURE QUE ME PERMITE HACER EL TIPO DE CAMBIO
        int option;
        char respuesta;//lo pongo afuera para que sirva a todos los if
        double valor;
        Scanner sc = new Scanner(System.in);

        do {
            System.out.println("Cambio de divisa \n sol a dolar: 1 \n dolar a sol: 2 \n sol a euro: 3 \n euro a sol: 4 \n Terminar: 5");
            System.out.println("Digite la opcion de menu");
            option = sc.nextInt();//valor tb podria haber venido fuera pero para que sea personalisado va adentro de cada uno
            if (option == 1) {
                do {
                    System.out.println("Ingrese el valor");
                    valor = sc.nextDouble();
                    //cambiar de sol a dolar
                    System.out.println(valor + " dolares son " + cambioAdolar(valor) + " dolares");
                    sc.nextLine();
                    do {
                        System.out.println("Desea convertir otro valor a soles ? 'si' o 'no'");
                        respuesta = sc.nextLine().charAt(0);
                    } while (respuesta != 's' && respuesta != 'n');
                } while (respuesta == 's');
            } else if (option == 2) {
                do {
                    System.out.println("Ingrese el valor");
                    valor = sc.nextDouble();
                    //cambiar de dolar a sol
                    System.out.println(valor + " soles son " + cambioAsol(valor) + " soles");
                    sc.nextLine();
                    do {
                        System.out.println("Desea convertir otro valor a soles ? 'si' o 'no'");
                        respuesta = sc.nextLine().charAt(0);
                    } while (respuesta != 's' && respuesta != 'n');
                } while (respuesta == 's');
            } else if (option == 3) {
                do {
                    System.out.println("Ingrese el valor");
                    valor = sc.nextDouble();
                    //cambiar de sol a euro
                    System.out.println(valor + " soles son " + cambioAeuro(valor) + " euros");
                    sc.nextLine();
                    do {
                        System.out.println("Desea convertir otro valor a euros ? 'si' o 'no'");
                        respuesta = sc.nextLine().charAt(0);
                    } while (respuesta != 's' && respuesta != 'n');
                } while (respuesta == 's');
            } else if (option == 4) {
                do {
                    System.out.println("Ingrese el valor");
                    valor = sc.nextDouble();
                    //cambiar de euro a sol
                    System.out.println(valor + " euros son " + cambioAsol2(valor) + " soles");
                    sc.nextLine();
                    do {
                        System.out.println("Desea convertir otro valor a soles ? 'si' o 'no'");
                        respuesta = sc.nextLine().charAt(0);
                    } while (respuesta != 's' && respuesta != 'n');
                } while (respuesta == 's');
            } else if (option == 5) {
                System.out.println("Hasta luego");
            } else {
                System.out.println("La opcion debe estar comprendida entre 1 y 5");
            }
        } while (option != 5);
    }

    private static double cambioAdolar(double valor) {
        double dolar = 3.32;
        return valor / dolar;
    }

    private static double cambioAsol(double valor) {
        double dolar = 3.32;
        return valor * dolar;
    }

    private static double cambioAeuro(double valor) {
        double euro = 3.87;
        return valor / euro;
    }

    private static double cambioAsol2(double valor) {
        double euro = 3.87;
        return valor * euro;
    }
}
