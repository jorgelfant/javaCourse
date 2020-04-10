package a_sequences;

import java.util.Scanner;

public class f_promedio {//Calcular el promedio aritmetico de 3 numeros

  public static void main(String[] args) {
    double n1, n2, n3, promedio;

    Scanner sc = new Scanner(System.in);
    System.out.println("Ingrese 3 notas");
    n1 = sc.nextDouble();
    n2 = sc.nextDouble();
    n3 = sc.nextDouble();

    promedio = (n1 + n2 + n3) / 3;
    System.out.println("El promedio de las 3 notas es " + promedio);
  }
}
