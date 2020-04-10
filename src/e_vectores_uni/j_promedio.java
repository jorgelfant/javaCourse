package e_vectores_uni;

import java.util.Scanner;

public class j_promedio {
  public static void main(String[] args) {
    /*Crear un arreglo unidmensional con un tamano de 5 numeros reales,
    preguntarle al usuario los valores y calcular la suma de todos ellos
    * */
    double[] tab = new double[5];
    //double valor;
    double suma=0;
    Scanner sc = new Scanner(System.in);

    for (int i = 0; i < tab.length; i++) {
      System.out.println("Ingrese el valor " + (i + 1));
      // valor;
      tab[i] = sc.nextDouble();// tab[i] = valor;
      suma=suma +tab[i];
    }
    System.out.println("la suma de los valors es " + suma);
  }
}
