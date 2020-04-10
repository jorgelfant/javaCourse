package d_funciones.h_promedio;

import java.util.Scanner;

public class promedio {
    public static void main(String[] args) {
        //Promedio de 3 notas , aprobado con 10.5
        double nota1;
        double nota2;
        double nota3;
        Scanner sc = new Scanner(System.in);
        System.out.println("Ingrese sus 3 notas");
        nota1 = sc.nextInt();
        nota2 = sc.nextInt();
        nota3 = sc.nextInt();

        promedios(nota1, nota2, nota3);//el metodo no puede llamarse como la clase
    }

    private static void promedios(double nota1, double nota2, double nota3) {
        double promedio = (nota1 + nota2 + nota3) / 3;
        if (promedio > 10.5) {
            System.out.println("Has aprobado !");
        } else {
            System.out.println("Mejora tus notas");
        }
    }
}
