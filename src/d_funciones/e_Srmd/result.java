package d_funciones.e_Srmd;

import java.util.Scanner;

public class result {//I

  public static void main(String[] args) {
    int numero1;
    int numero2;
    int numero3;
    Scanner sc = new Scanner(System.in);
    System.out.println("Ingrese 3 numeros");
    numero1 = sc.nextInt();
    numero2 = sc.nextInt();
    numero3 = sc.nextInt();

    operaciones(numero1, numero2);
    System.out.println(sumMulti(numero1, numero2,numero3));
  }
//methode 1
  private static void operaciones(int numero1, int numero2) {
    int suma = numero1 + numero2;
    int resta = numero1 - numero2;
    int multi = numero1 * numero2;
    int div = numero1 / numero2;
    int mod = numero1 % numero2;

    System.out.println("La suma es " + suma + "\nla resta es " + resta + "\nLa multiplicacion es " + multi + "\nla division es "
        + div + "\nel modulo es " + mod);
  }
  //methode 2
  private static String sumMulti(int numero1, int numero2, int numero3) {//para poder retornar string y int la funcion debe ser string
    int suma = numero1 + numero2 + numero3;
    int multi = numero1 * numero2 * numero3;
    return "La suma es " + suma +" y la multiplicacion es "+ multi;
  }
}
