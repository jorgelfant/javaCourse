package b_condicionales;

import java.util.Scanner;

public class l_descuentoMoto {
  public static void main(String[] args) {
/*Una distribuidora de motos tiene una promo de fin de anio que consiste en lo siguiente:
marca honda descuento de 5%
marca yamaha descuento 8%
marca suzuki descuento 10%
otras marcas 2%
 */
    String marca;
    double descuento;
    double precio;
    double precioF;//o se inicia la variable a 0 permitiendo de imprimir el system ot una sola vez al final de if
    //o no se inicializa y de ese modo se debe poner cada salida desntro de cada condicion if
    Scanner sc = new Scanner(System.in);
    System.out.println("Ingrese la marca de moto : \nMarcas aceptadas: \nhonda \nyamaha \nsuzuki \notras");
    marca = sc.nextLine();
    System.out.println("Ingrese el precio de la moto");
    precio = sc.nextInt();

    if (marca.equals("honda") || marca.equals("yamaha") || marca.equals("suzuki") || marca.equals("otras")) {
      if (marca.equals("honda")) {
        descuento = precio * 0.05;
        precioF = precio - descuento;
        System.out.println("El precio por la moto de marca " + marca + " es " + precioF);
      } else if (marca.equals("yamaha")) {
        descuento = precio * 0.08;
        precioF = precio - descuento;
        System.out.println("El precio por la moto de marca " + marca + " es " + precioF);
      } else if (marca.equals("suzuki")) {
        descuento = precio * 0.10;
        precioF = precio - descuento;
        System.out.println("El precio por la moto de marca " + marca + " es " + precioF);
      } else if (marca.equals("otras")) {
        descuento = precio * 0.02;
        precioF = precio - descuento;
        System.out.println("El precio por la moto de marca " + marca + " es " + precioF);
      }
    } else {
      System.out.println("Inserte una marca valida");
    }
  }
}
