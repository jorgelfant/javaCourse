package e_vectores_uni;

public class b_Pares {

  //Rellenar arreglo con los numeros pares comprendidos entre 1 y 20 y los muestre en orden ascendente
  public static void main(String[] args) {
    int[] tab = new int[20];
    int conteo = 0;

    for (int i = 1; i <= tab.length; i++) {
      if (i % 2 == 0) {
        tab[conteo] = i;
        //System.out.println(tab[conteo]); con esto no haria falta hacer otro for
        conteo++;
      }
    }
    for (int i = 0; i < conteo; i++) {
      System.out.println(tab[i]);
    }
  }
}
