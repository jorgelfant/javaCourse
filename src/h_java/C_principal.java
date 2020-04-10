package h_java;

import java.util.Scanner;

public class C_principal {
    public static void main(String[] args) {
        int[] array = {7, 4, 2, 100, 8, 0, 9, 5, 120, 300};
        Scanner sc = new Scanner(System.in);

        System.out.println("Ingrese un numero");
        int n = sc.nextInt();

        if (buscarNumero(n, array)) {//if la condicion==true
            System.out.println("El numero se encontro");
        } else {
            System.out.println("El numero no se encontro");
        }
    }

    //METODO que pedira un numero y un arreglo
    public static boolean buscarNumero(int n, int[] tableau) {//argumento y parametro se pueden llamar igual o diferente array / tableau
        boolean siEsta = false;
        int i = 0;
        while (i < tableau.length && !siEsta) {
            if (n == tableau[i]) {
                siEsta = true;
                //conteo++;
            }//ou if(conteo>0) siEsta=true; break;  y break pa que salga
            i++;//tambien nos va a servir para determinar el numero de vueltas
        }
        if (siEsta) {
            System.out.println("Posicion del numero " + (i - 1));
        }
        return siEsta;
    }
}
