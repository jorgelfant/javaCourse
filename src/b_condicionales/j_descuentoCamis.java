package b_condicionales;

import java.util.Scanner;

public class j_descuentoCamis {
  public static void main(String[] args) {
    //Calcular el total a pagar por la compra de camisas. Si se compran 3 camisas o mas se aplica un descuento de
    //20% sobre el total de la compra y si son menos de 3 camisas un descuento de 10%
    double totalC, totalF, descuento, nbCam, precioC;

    Scanner sc = new Scanner(System.in);
    System.out.println("Ingrese el numero de camisas");
    nbCam = sc.nextDouble();
    System.out.println("Ingrese el precio por camisa");
    precioC = sc.nextDouble();
    totalC = nbCam * precioC;

    if (nbCam > 3) {
      descuento = totalC * 0.20;//double
      totalF = totalC - descuento;
    } else {
      descuento = totalC * 0.10;//double
      totalF = totalC - descuento;
    }
    System.out.println("El precio de las camisas es  " + totalF);
  }
}
