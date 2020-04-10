package d_funciones;

import java.util.Scanner;

public class s_CantidaBillCambio {
    public static void main(String[] args) {
  /*Escriba un subprograma cambio() que tenga un parametro en numero entero y 6 parametros
  de referencia en numero entero nombrados cien, cincuenta, veinte, diez, cinco y uno, respectivamente.
  La funcion tiene que considerar el valor entero transmitido como una cantidad en dolares y convertir el
  valor en el numero menor de billetes equivalentes
  */
        int dolar; //por referencia hubira podido guardar este bloque en una funcion
        Scanner sc = new Scanner(System.in);//y asignarle un valor dentro de la funcion a dolar
        System.out.println("Ingrese un valor");//en el principal solo hubiera declarado los valores
        dolar = sc.nextInt();
        //
        cambio(dolar);
    }

    private static void cambio(int dolar) {
        int billete100 = dolar / 100;//7;
        int billete50 = (dolar % 100) / 50;
        int billete20 = ((dolar % 100) % 50) / 20;//36/20=1
        int billete10 = (((dolar % 100) % 50) % 20) / 10;//16/10=1
        int billete5 = ((((dolar % 100) % 50) % 20) % 10) / 5;//16/10=1
        int billete1 = ((((dolar % 100) % 50) % 20) % 10) % 5;

        //cuando se usa else if solo una condicion se aplica , si dejamos en if , examinara todas y solo se cumplen las validas
        System.out.println("En " + dolar + " dolares hay");
        if (billete100 >= 1) {
            System.out.println(billete100 + " billetes de 100 dolares");
        }
        if (billete50 >= 1) {
            System.out.println(billete50 + " billetes de 50 dolares");
        }
        if (billete20 >= 1) {
            System.out.println(billete20 + " billetes de 20 dolares");
        }
        if (billete10 >= 1) {
            System.out.println(billete10 + " billetes de 10 dolares");
        }
        if (billete5 >= 1) {
            System.out.println(billete5 + " billetes de 5 dolares");
        }
        if (billete1 >= 1) {
            System.out.println(billete1 + " billetes de 1 dolares");
        }
    }
}
