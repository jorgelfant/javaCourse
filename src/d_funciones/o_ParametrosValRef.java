package d_funciones;

import java.util.Scanner;

public class o_ParametrosValRef {
  public static void main(String[] args) {
    //PARAMETROS POR VALOR O REFERENCIA
    //Parametros por valor:En este tipo de parametro aunque durante el procedimiento
    //su valor cambie, el valor no sera asignado a la variable del programa ObjectA.
    //este cambiaria en el sub proceso o funcion pero no en el principal

    //Parametros por referencia:En este tipo de parametro cualquier cambio que sufra la variable
    //en la funcion , la variable del programa ObjectA tambien lo sufrira.
    //de esta manera podremos enviar informacion modificarla y enviar resultados al prog ObjectA
    //Ex x=5; lo modifico en la funcion y esta cambiara su valor en el principal
    int numero;
    Scanner sc = new Scanner(System.in);

    System.out.println("Escriba un numero");
    numero = sc.nextInt();

    System.out.println("El numero aumentado es " + aumentar(numero));

  }

  //PARAMETROS POR VALOR EN JAVA NO EXISTEN EL PASO POR PARAMETRO POR REFERENCIA
  //SOLO POR VALOR. EN PHP SI EXISTE
  private static int aumentar(int num) {
    int aumento = num + 10;
    return aumento;
  }
}

