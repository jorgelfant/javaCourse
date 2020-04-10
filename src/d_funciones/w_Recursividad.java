package d_funciones;

import java.util.Scanner;

public class w_Recursividad {
    public static void main(String[] args) {
        //RECURSVIDAD importante en la modularidad
        //Es una tecnica de programacion que se utiliza para realizar
        //una llamada a una funcion desde ella misma
        //Es como un ciclo

        //toda funcion recursiva tiene que tener una condicion
        //que ponga final a la recursividad, es decir, que el
        //programa o funcion deje de llamarse a si mismo cuando
        //se cumpla la condicion, sino se formaria un boucle infinito

        //EJEMPLO:HALLAR EL FACTORIAL DE UN NUMERO CON RECURSIVIDAD
        int numero;
        Scanner sc = new Scanner(System.in);
        System.out.println("Ingrese un numero");
        numero = sc.nextInt();

        System.out.println(factorial(numero));//lamado de la funcion recursiva
    }
    //Funcion factorial normal
  /*
  private static int factorial(int numero) {
    int factorial = 1;
    for (int i = 1; i < numero; i++) {
      factorial = factorial * i;
    }
    return factorial;
  }*/
    //Funcion factorial RECURSIVA
    //0!=1 caso base
    //1!=1
    //2!=2
    //3!=6
    //4!=24; etc
    private static int factorial(int numero) {
        if (numero == 0) {//caso base cuando llega a 0 que retorno 1
            return 1;   //para impedir boucle infinito aqui acaba
        } else {//caso recursivo
            return numero * factorial(numero - 1);
        }
        //5 * 4 * 3 * 2 *1 * 0! cuando numero=0 retorna 1 entonces 5 * 4 * 3 * 2 *1 * 1
    }
}
