package b_condicionales;

import java.util.Scanner;

public class l_descuentoAlmacen {
  public static void main(String[] args) {
/*En un almacen se hace un descuento a los clientes cuya compra supere los 1000 euros
cual sera la cantidad que pagara una persona por su compra?
* */
    double precioTotal, precioDesc;
    double descuento;
    Scanner sc = new Scanner(System.in);
    System.out.println("Ingrese el total");
    precioTotal = sc.nextInt();

    if (precioTotal > 1000) {
      descuento = precioTotal * 0.20;
      precioDesc = precioTotal - descuento;
      System.out.println("El precio final es " + precioDesc);
    } else {
      System.out.println("El precio final es " + precioTotal);
    }

  }
}

