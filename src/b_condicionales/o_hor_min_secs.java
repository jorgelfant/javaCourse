package b_condicionales;

import java.util.Scanner;

public class o_hor_min_secs {
    public static void main(String[] args) {
//Programa que lea una hora minutos y segundos y que diga que hora es un segundo despues;
        int h, m, s;
        Scanner sc = new Scanner(System.in);
        System.out.println("Ingrese las horas");
        h = sc.nextInt();
        System.out.println("Ingrese los minutos");
        m = sc.nextInt();
        System.out.println("Ingrese los segundos");
        s = sc.nextInt();

        if ((h >= 0) && (h <= 23) && (m >= 0) && (m <= 59) && (s >= 0) && (s <= 59)) {
            s++;//On incremente
            if (s == 60) {//las condiciones estan ligadas por eso no es conveniendte utilizar else if, porque los if se ejecutan juntos
                s = 0;
                m++;
                if (m == 60) {
                    m = 0;
                    h++;
                    if (h == 24) {
                        h = 0;
                    }
                }
            }
            System.out.println("Dans une seconde il sera " + h + " heures " + m + " minutes et " + s + " secondes");
        } else {
            System.out.println("Los datos ingresados no son correctos");
        }
    }
}

