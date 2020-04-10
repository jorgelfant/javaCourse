package b_condicionales;

import java.util.Scanner;

public class K_precioPagar {
  public static void main(String[] args) {
/*Calcular el total que una persona debe pagar en una llantera si el precio de cada llanta es 800 euros
si se compran menos de 5 llantas y de 700 si se compran mas
* */
    int nbllantas;
    int precioTotal;
    int ahorro;

    Scanner sc = new Scanner(System.in);
    System.out.println("Cuantas llantas va a comprar ?");
    nbllantas = sc.nextInt();

    if (nbllantas < 5) {
      precioTotal = nbllantas * 800;
    } else {
      precioTotal = nbllantas * 700;
    }
    //ahorro y descuento deberian estar en el if y en el else para que java los detecte bien si solo esta en 1 hay problemas
    //sino ahorro y descuento se ponen afuera del if y else O un print personalisado en el if y otro en el else
    ahorro=(nbllantas*800)-precioTotal;

    System.out.println("Usted ha comprado " + nbllantas + " llantas por un valor de " + precioTotal + " el ahorro es " +
        ahorro);
  }
}

