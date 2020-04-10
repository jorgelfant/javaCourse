package b_condicionales;

import java.util.Scanner;

public class s_aniversario {
    public static void main(String[] args) {
        /*Elaborar un programa que muestre el significado de cada decada hasta los 60*/
        int decada;
        Scanner sc = new Scanner(System.in);

        System.out.println("Elija una decada");
        decada = sc.nextInt();

        switch (decada) {
            case 10:
                System.out.println("Bodas de hojalata");
                break;
            case 20:
                System.out.println("Bodas de porcelana");
                break;
            case 30:
                System.out.println("Bodas de perlas");
                break;
            case 40:
                System.out.println("Bodas de rubi");
                break;
            case 50:
                System.out.println("Bodas de oro");
                break;
            case 60:
                System.out.println("Bodas de diamante");
                break;
            default:
                System.out.println("Ingrese una decada entre 10 y 60");
        }
    }
}
