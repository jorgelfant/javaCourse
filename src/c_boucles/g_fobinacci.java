package c_boucles;

import java.util.Scanner;

public class g_fobinacci {
  public static void main(String[] args) {
    //serie fibonnaci 1 2 3 5 8 13 21.....
    //entrada=numero de elementos
    //salida serie fibonnaci
    int x = 0;
    int y = 1;
    int z = 1;
    int numero;
    /*
    v_design_patterns=x+y;1 2 3 5 8 13 21 34
    x=y;  1 1 2 3 5 8  13 21
    y=v_design_patterns;  1 2 3 5 8 13 21 34

    v_design_patterns=1 2 3 5 8 13 21 34....
    */
    Scanner sc = new Scanner(System.in);
    System.out.println("Digite el numero de elementos");
    numero = sc.nextInt();

    for (int i = 1; i <= numero; i++) {
      z = x + y;
      x = y;
      y = z;
      System.out.println(z);
    }


  }
}
