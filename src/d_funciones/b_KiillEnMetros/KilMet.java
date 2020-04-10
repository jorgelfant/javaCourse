package d_funciones.b_KiillEnMetros;

import java.util.Scanner;

public class KilMet {
    //Programa que permite transformar kilometros en metros
    public static void main(String[] args) {
        int numero;
        Scanner sc = new Scanner(System.in);
        System.out.println("Inserte un numero por favor");
        numero = sc.nextInt();
        //1
        int result = transform(numero);
        System.out.println(numero + " kilometros equivalen a " + result + " metros");
        //2
        System.out.println(numero + " kilometros equivalen a " + tranformar.transform(numero) + " metros");
        //3
        transform2 cambio = new transform2();
        System.out.println(numero + " kilometros equivalen a " + cambio.tranformar(numero) + " metros");

    }

    private static int transform(int numero) {
        int kil;
        kil = numero * 1000;
        return kil;
    }

}
