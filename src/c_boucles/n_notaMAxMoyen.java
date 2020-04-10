package c_boucles;

import java.util.Scanner;

public class n_notaMAxMoyen {
  public static void main(String[] args) {
    /*
     *Tiene un conjunto de calificaciones de un grupo de 10 alumnos.
     * realizar un algoritmo para calcular la calificacion promedio y la calificacion
     * mas baja de todoo el grupo
     * */
    double nota;
    double suma = 0;
    double min = 99999;
    Scanner sc = new Scanner(System.in);
    for (int i = 0; i < 10; i++) {
      System.out.println("Ingrese la nota " + (i + 1));
      nota = sc.nextInt();
      suma = suma + nota;
      if (nota < min) {
        min = nota;
      }
    }
    System.out.println("La nota mas baja es  " + min + " y el promedio es " + (suma / 10));//ou 10 en lugar de conteo
  }
}
