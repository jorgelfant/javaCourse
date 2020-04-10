package b_condicionales;

import java.util.Scanner;

public class l_descuentoColorB {
    public static void main(String[] args) {
    /*En una tienda de descuentos se hace una promocion en la cual se hace un descuento dobre el
    valor total de la compra segun el color de la bolita que el cliente saque al pagar de la caja.
    Si la bolita es de color blanco no se hace descuento
    verde el descuento es de 10%
    amarilla el descuento es de 25%
    roja el descuento es de 100%
    Solo hay bolitas de los colores mencionados(4)
    * */
        double descuento;
        double valorCompra;
        double valorCompraDesc;
        int aleatorio = (int) (Math.random() * 4);

        Scanner sc = new Scanner(System.in);
        System.out.println("Cual es el valor total de la compra ?");
        valorCompra = sc.nextDouble();

        System.out.println("Elija una bolita :\nblanco: No hay descuento \nverde: 10% de dscuento \namarillo: 25% de descuento " +
                "\nrojo 100% de descuento");

        if (aleatorio == 1) {
            descuento = 0;
            valorCompraDesc = valorCompra - descuento;
            System.out.println("No hay descuento, El valor de la compra es " + valorCompraDesc);
        } else if (aleatorio == 2) {
            descuento = valorCompra * 0.10;
            valorCompraDesc = valorCompra - descuento;
            System.out.println("El valor de la compra es " + valorCompraDesc);
        } else if (aleatorio == 3) {
            descuento = valorCompra * 0.25;
            valorCompraDesc = valorCompra - descuento;
            System.out.println("El valor de la compra es " + valorCompraDesc);
        } else {
            System.out.println("El valor de la compra es gratis");
        }
    }
}
