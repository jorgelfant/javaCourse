package b_condicionales;

import java.util.Scanner;

public class r_kiloFrutas {
    public static void main(String[] args) {
        //Una fruteria ofrece las manzanas con descuento segun:
        //0-2 kilos 0% de descuento
        //2.01-5  kilos 10% de descuento
        //5.01-10 kilos 15% de descuento
        //mas 10.1kilos 20% de descuento

        double kilos;
        double descuento;
        double precioK ;
        double precioFinal;
        Scanner sc = new Scanner(System.in);

        System.out.println("Cuantos kilos de manzanas desea comprar?");
        kilos = sc.nextInt();

        precioK = 5 * kilos;

        if (kilos <= 2) {
            descuento = 0;
        } else if (kilos <= 5) {
            descuento = precioK * 0.10;
        } else if (kilos <= 10) {
            descuento = precioK * 0.15;
        } else {
            descuento = precioK * 0.20;
        }
        precioFinal = precioK - descuento;
        System.out.println("El precio final por " + kilos + " kilos es " + precioFinal + "euros");
    }
}
