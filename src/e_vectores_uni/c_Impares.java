package e_vectores_uni;

public class c_Impares {
  public static void main(String[] args) {
//Hacer un programa que rellene un array con los numeros impares comprendidos entre 1 y 20 y los muestre enpantalla en
// orden descendente
    int[] tab = new int[20];
    int conteo = 0;

    for (int i = 0; i < tab.length; i++) {
      if (i % 2 != 0) {
        tab[conteo] = i;
        conteo++;
      }
    }
    for (int i = 0; i < conteo; i++) {
      System.out.println(tab[i]);
    }
  }
}
