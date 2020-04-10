package b_condicionales;

import java.util.Scanner;

public class b_aprobado {
  public static void main(String[] args) {
    /*Determinar si un alumno aprueba o no un curso, sabiendo que aprueba si el promedio de sus 3 notas es mayor o igual
    a 10.5*/
    double n1, n2, n3, promedio;
    Scanner sc = new Scanner(System.in);
    System.out.println("Ingrese sus 3 notas");

    n1 = sc.nextDouble();
    n2 = sc.nextDouble();
    n3 = sc.nextDouble();

    promedio = (n1 + n2 + n3) / 3;
    if (promedio >= 10.5) {
      System.out.println("Enbuenahora has pasado!!");
    } else {
      System.out.println(" Vuelve a intentarlo");
    }
  }
}
