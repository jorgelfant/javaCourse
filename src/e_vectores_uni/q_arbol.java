package e_vectores_uni;

import java.util.Scanner;

public class q_arbol {
    public static void main(String[] args) {

        int n;
        Scanner sc = new Scanner(System.in);
        System.out.println("Imndique el numero de iteraciones");
        n = sc.nextInt();

        for (int i = 0; i < n; i++) {//podria i valer 0 pero es menos complicaco si le doy 1

            for (int j = (n - i); j > 0; j--) {//espacios (n-i) +1 porque i vale 1, asi imprimera qm 5 veces la 1 ves 4 la sda etc
                System.out.print("-");//este for podria haberse hecho con j++  j<n , solo que habria tenido (n-i)-1
            }
            for (int k = n - (2 * i + 1); k < n; k++) {//esto funciona (int FluentApiTest = n - (i*2+ 1-i)-i; FluentApiTest < n; FluentApiTest++) pero muy largo
                System.out.print(i % n);
            }//3er FOR OPTIONAL
            for (int k = (n - i); k > 0; k--) {//espacios (n-i) +1 porque i vale 1, asi imprimera qm 5 veces la 1 ves 4 la sda etc
                System.out.print("-");
            }
            System.out.println();
        }
    }
}


