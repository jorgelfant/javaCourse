package d_funciones.a_numberPow;

import java.util.Scanner;
//1) METODO UNO PARA LLAMAR A UN METODO , HACER EL METODO ENLA CLASE PRINCIPAL FUERA DEL METODO MAIN
/*
  Cuando se hace una funcion en la misma clase del principal fuera de la metode principal
  la clase debe ser declarada statica ( privada o publica) para que esta pueda ser invocada de la case principal
  cuando escribimos el metodo en el principal no es necesario escribir el nombre de la clase antes
  Cubo_numero.cuboNumero( 5); porque ya estamos en la clase donde ha sido creada, solo basta el nombre del metodo

2) METODO UNO PARA LLAMAR A UN METODO , HACER EL METODO EN UNA CLASE EXTERNA
SI metodo declarado como estatic, hara falta poner el nombre de la clase antes del metodo Math.pow() por ejemplo

3)el metodo no es estatic no hara falta poner el nombre de la clase antes de invocarlo, sin embarco habra que
crear un objeto de esta clase para poner utilizar el metodo
*/

public class Cubo_numero {
  public static void main(String[] args) {
    int numero;
    Scanner sc = new Scanner(System.in);
    System.out.println("Ingrese un numero por favor");
    numero = sc.nextInt();
    //METODO 1
    System.out.println("El cuadrado del numero es " + cuadradoNumero(numero));
    //METHODO 2 LLAMAR AL METODO EN OTRA CLASE Y QUE ES ESTATIDO
    System.out.println("El cubo del numero es " + FuncionCn.cuboNumero(numero));
    //METHODO 3 LLAMAR AL METODO EN OTRA CLASE Y QUE NO ES DECLARADO ESTATICO , creacion de objeto
    FuncionCnBis metodo3 = new FuncionCnBis();
    System.out.println("El numero elevado a 5 " + metodo3.cincoNumero(numero));
  }

  //metodo declarado en la clase en la que lo utilizare version 1
  private static int cuadradoNumero(int numero) {//public o private o defaut
    int cubo;
    cubo = (int) Math.pow(numero, 2);
    return cubo;
  }
}
