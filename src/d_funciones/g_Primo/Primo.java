package d_funciones.g_Primo;

import java.util.Scanner;

public class Primo {//DETERMINAR SI UN NUMERO ES PRIMO O NO

    public static void main(String[] args) {
        int numero;
        Scanner sc = new Scanner(System.in);

        System.out.println("Ingrese un numero");
        numero = sc.nextInt();

        int result = primo(numero);//appel de fonction!
        System.out.println(result);
    }

    //FUNCION NUMERO PRIMO
    private static int primo(int numero) {
        int count = 0;
        for (int i = 1; i <= numero; i++) {
            if (numero % i == 0) {
                count++;
            }
        }
        if (count > 2) {
            return 0;
        } else {
            return 1;
        }
    }
}
