package d_funciones.c_PosNeg;

import java.util.Scanner;

public class PosNeg {
  public static void main(String[] args) {
    //Crear una funcion que reciba un numero y devuelva un numero con el valor -1 si el numero es negativo
    //1 si el numero es positivo
    //0 si es cero
    int numero;
    Scanner sc = new Scanner(System.in);

    System.out.println("Ingrese un numero");
    numero = sc.nextInt();

    System.out.println(decir(numero));
  }

  private static int decir(int numero) {
    if (numero == 0) {
      return 0;
    } else if (numero > 0) {
      return 1;
    } else {
      return -1;
    }
  }
}

