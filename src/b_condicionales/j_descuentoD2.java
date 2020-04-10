package b_condicionales;

import java.util.Scanner;

public class j_descuentoD2 {
  public static void main(String[] args) {
    /*En un supermercado se hace una promocion, , mediante la cual el cliente obtiene
    un descuento dependiendo de un numero que se escoje al azar.Si el numero escojido es menor que
    74 el descuento es de 15% sobre el total de la compra
    si es mayor o igual que 74 el descuento es de 20%
    obtener cuando dinero se le descuenta
     */

    double totalC, descuento, totalConD;

    int aleatorio = (int) (Math.random() * 100);//random return un double entre 0.0 et 1.0
    Scanner sc = new Scanner(System.in);

    System.out.println("Digite el total de la compra");
    totalC = sc.nextInt();

    if (aleatorio < 74) {
      descuento = totalC * 0.15;
      totalConD = totalC - descuento;
    } else {
      descuento = totalC * 0.20;
      totalConD = totalC - descuento;
    }
    System.out.println("El numero es " + aleatorio + " El precio con un descuento de " + descuento + "% es " + totalConD);
  }
}
