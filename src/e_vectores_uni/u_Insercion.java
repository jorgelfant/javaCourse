package e_vectores_uni;

import java.util.Scanner;

public class u_Insercion {
  public static void main(String[] args) {
    //METODO POR INSERCION
    int elementos;
    int temp;
    int pos;
    Scanner sc = new Scanner(System.in);

    System.out.println("Ingrese el numero de elementos del arreglo");
    elementos = sc.nextInt();

    int[] tab = new int[elementos];

    for (int i = 0; i < tab.length; i++) {
      System.out.println("Ingrese el numero ");
      tab[i] = sc.nextInt();
    }
    /*
     si numlzq>numActual
     cambio
    */
    // 3 2 5 4 1       int= 1                int=2                 int=3               int=4
    // _ 3 5 4 1  pos=1 tab[pos]= 2 / pos=2  2 3 5 4 1     / pos=3  2 3 4 5 1  /  pos=4  1 2 3 4 5  /
    // 0 1 2 3 4
    //Este algoritmo trabaja con los indices de derecha e izquierda
    for (int i = 1; i < tab.length; i++) {//a la izquierda del indice 0 no hay nada entonces cambiamos 0 a 1 para que funcione
      pos = i;//1 2 3 4                   //ademas daria una vuelta por las puras si fuera 0 asi que por eso mejor 1
      temp = tab[i];
      while (pos > 0 && tab[pos - 1] > temp) {
        tab[pos] = tab[pos - 1];
        pos--;//ou pos=pos-1
      }
      tab[pos] = temp;//temp=tab[i]=2 en el 1 essai
    }
    for (int indice : tab) {
      System.out.print(indice + " ");
    }
  }
}
