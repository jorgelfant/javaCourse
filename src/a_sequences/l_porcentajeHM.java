package a_sequences;

import java.util.Scanner;

public class l_porcentajeHM {
  public static void main(String[] args) {
    //Obtener el porcentaje de hombres y mujeres en una clase
    int porcentajeH, porcentajeM, h, m, total;

    Scanner sc = new Scanner(System.in);
    System.out.println("Ingrese el numero de hombres");
    h = sc.nextInt();
    System.out.println("Ingrese el numero de mujeres");
    m = sc.nextInt();

    total = h + m;
    porcentajeH = (h * 100) / total;// total/parte *100/%
    porcentajeM = (m * 100) / total;

    System.out.println("El porcentaje de hombres es: " + porcentajeH + " y el porcentaje de mujeres es " + porcentajeM);

  }
}
