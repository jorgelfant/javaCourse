package d_funciones;

import java.util.Scanner;

public class x_NumeroAbin {
    public static void main(String[] args) {
        int numero;
        String binario = "";
        Scanner sc = new Scanner(System.in);

        System.out.println("Ingrese un numero");
        numero = sc.nextInt();
        //9= 9/2=4 res=1  4/2=2 res=0   2/2=1 res=0  1/2=0.5 res=1
        for (int i = numero; i > 0; i /= 2) {//en cada iteracion el numero se dividira por 2
            if (i % 2 == 0) {
                binario = binario.concat("0");//convierte int en string
            } else {
                binario = binario.concat("1");//convierte int en string
            }
        }
        for (int i = binario.length() - 1; i >= 0; i--) {//de atras pa adelante
            System.out.print(binario.charAt(i));
        }
    }
}
//4/2  2/2  1/2     0   0    1    i*2+