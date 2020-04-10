package e_vectores_uni;

public class g_rellenar100 {
  public static void main(String[] args) {
    /*Hacer i, programa que rellene un array con los 100 primeros numeros pares y muestre su suma*/
    int[] tab = new int[100];
    int suma = 0;
    int count = 0;
    for (int i = 1; i <= 200; i++) {
      if (i % 2 == 0) {
        tab[count] = i;
        count++;
      }
    }
    for (int i = 0; i < count; i++) {
      suma = suma + tab[i];
    }
    System.out.println(suma);
  }
}
