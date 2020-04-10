package d_funciones;

import java.util.Scanner;

public class w_Recursividad_sumar {
    public static void main(String[] args) {
        //Implementar un subprograma recursivo que permita sumar los digitos de un numero
        //123 seria 6 por ejemplo
        //*******************************************************************************************
    /*SIN RECURSIVIDAD opcion 1
    //*******************************************************************************************
    System.out.println("Ingrese el numero");
    numero = sc.nextLine();
    int convert;
    int suma=0;
    for (int i = 0; i < numero.length(); i++) {
      convert = Integer.parseInt(numero.substring(i,i+1));
      suma=suma+convert;
    }
    System.out.println(suma);
    //*******************************************************************************************
    /*SIN RECURSIVIDAD opcion 2
    //*******************************************************************************************

    System.out.println("Ingrese el numero");
    numero = sc.nextLine();
    int convert;
    int suma = 0;
    while(numero!=0) {   1   2   3  =6     123  12   1           3   2   0,1
      digito =numero%10;
      numero=numero/10;
      suma = suma + digito;
    }
    System.out.println(suma);
    */
        //*******************************************************************************************
        //CON RECURSIVIDAD opcion 2
        //*******************************************************************************************
        int numero;
        Scanner sc = new Scanner(System.in);
        System.out.println("Ingresar un numero");
        numero = sc.nextInt();

        System.out.println(sumar(numero));
    }

    private static int sumar(int numero) {
        if (numero == 0) {//eje: 5  5 + 4 + 3 + 2 +1 cuando llega a 1 envia 1
            return numero;//aqui numero ya vale 0 es como decir si numero==0 regresa 0//ou numero==1 return 1
        } else {
            return (numero % 10) + sumar(numero / 10);//ex:23/10 + (23%10)
        }//                                                       2  +   3
    }//EJEMPLO 123     123/10     +    123%10
}  //              sumar(12)    +       3   el numero es 12 osea no igual a 0
//              sumar(1) + 2 +       3   12/10 = 1 el numero aun no es 0 entonces 1 + 2 (2 seria el residuo)
//1  sumar(123/10) +(123%10)     = sumar(12) +(3)
//2  sumar(12/10) + (12%10)      =sumar(1)       +(2) +(3)
//3  sumar(1/10)  +(1%10)        =sumar(0)       +(1) +(2) +(3)
//4 sumar(0) cuando vea que 0 es 0 esto eliminara la funcion 0 enviara 0 osea  0 +1 + 2 + 3

//sumar(numero/10) sirve como la condicion en este ejemplo que me permite hacer la iteraciones