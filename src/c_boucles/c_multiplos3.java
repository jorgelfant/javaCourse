package c_boucles;

import java.util.Scanner;

public class c_multiplos3 {
    public static void main(String[] args) {
        //multiplos de 3 de 1 a n
        int n;
        Scanner sc = new Scanner(System.in);
        System.out.println("Ingrese un numero");
        n = sc.nextInt();

        for (int i = 1; i <= n; i++) {
            if (i % 3 == 0) {//o multiplos de 5 u otro numero
                System.out.println(i + " es multiplo de 3");
            }
        }
    }
}
