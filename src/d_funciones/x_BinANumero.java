package d_funciones;

import java.util.Scanner;

public class x_BinANumero {
    public static void main(String[] args) {
        //Numero a binario
        String numero;
        int suma = 0;
        int convert;
        Scanner sc = new Scanner(System.in);

        System.out.println("Ingrese un numero binario");
        numero = sc.nextLine();
        //Ex:1011 = 11
        for (int i = 0; i < numero.length(); i++) {//comienzo desde adelante 0 , podria tb haber
            if (numero.charAt(i) == '1') {           //comenzado a contar desde el inicio
                convert = (int) Math.pow(2, numero.length() - (i + 1));
                suma = suma + convert;
            }
        }
        System.out.println(numero + " = " + suma);
    }// 2^3 2^2 2^1 2^0    etc...
}  //  8   4   2   1
