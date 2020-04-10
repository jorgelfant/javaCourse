package d_funciones.f_AreaPerim;

import java.util.Scanner;

public class AreaPerimetro {
    public static void main(String[] args) {
//Calcular area y perimetro de un rectangulo dada su base y altura
        int base;
        int altura;
        Scanner sc = new Scanner(System.in);
        System.out.println("Ingresar la base");
        base = sc.nextInt();
        System.out.println("Ingresar la altura");
        altura = sc.nextInt();

        System.out.println("El area del rectangulo es " + area(base, altura) + " y el perimetro es " + perimetro(base, altura) +
                " El area de un cuadrado es " + areaCuadrado(base, altura));
    }

    //metodo 1 area rectangulo
    private static int area(int base, int altura) {
        return base * altura;
    }

    //metodo 2 perimetro rectangulo
    private static int perimetro(int base, int altura) {

        return (int) Math.pow(base, 2) + (int) Math.pow(altura, 2);
    }

    //metodo 2 area cuadrado
    private static int areaCuadrado(int lado1, int lado2) {
        return lado1 * lado2;
    }
}
