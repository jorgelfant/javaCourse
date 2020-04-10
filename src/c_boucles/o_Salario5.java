package c_boucles;

import java.util.Scanner;

public class o_Salario5 {
    public static void main(String[] args) {
    /*Dadas las horas trabajadas de 5 personas y la tarifa de pago,
    calcular el salario y la suma de todos los salarios*/
        //ESTE EJERCICIO DEBE HACERCE CON ARREGLOS PARA PODER HACER EL CALCULO FUERA DEL FOR
        //A QUE CADA INDICE ALMACENARIIA SU VALOR
        double pSal;

        double pagoH;

        double horas;


        double sumaSal = 0;

        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < 5; i++) {
            System.out.println("Ingresar las horas trabajadas de la persona " + (i + 1));
            horas = sc.nextInt();
            System.out.println("Ingresar el pago por hora trabajada de la persona " + (i + 1));
            pagoH = sc.nextInt();

            pSal = horas * pagoH;
            sumaSal = sumaSal + pSal;//o abajo del output
            System.out.println("El salario de la persona " + (i + 1) + " es " + pSal);
        }
        System.out.println("La suma de todos los salarios es " + sumaSal);
    }
}

