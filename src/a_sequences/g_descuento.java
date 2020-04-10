package a_sequences;

import java.util.Scanner;

public class g_descuento {
  public static void main(String[] args) {//Una tienda ofrece un descuento de 15% sobre el total de la compra y un
    //un cliente desea saber cuanto debera pagar finalmente
    double totalC, descuento, totalF;
    Scanner sc = new Scanner(System.in);
    System.out.println("Ingrese el total de la compra");
    totalC = sc.nextDouble();
    descuento = totalC * 0.15;//total *15/100

    totalF = totalC - descuento;
    System.out.println("El total de la compra con descuento es " + totalF);
  }
}
