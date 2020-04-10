package e_vectores_uni;

import java.util.Scanner;

public class l_OrdenIntro {
  public static void main(String[] args) {
//Crear un arreglo unidimensional con "n"caracteres, ingrese los elementos por teclado,
    //guardarlos en el arreglo  y mostrarlos en el orden inverso al introducido

    int elementos;
    Scanner sc = new Scanner(System.in);

    System.out.println("Ingrese el numero de elementos");
    elementos = sc.nextInt();

    int[] tab = new int[elementos];

    for (int i = 0; i < tab.length; i++) {
      System.out.println("Ingrese el numero");
      tab[i] = sc.nextInt();
    }
    for (int j = elementos - 1; j >= 0; j--) {//0 1 2 3 4 5 ...
      System.out.print(tab[j] + " ");
    }


  }
}
