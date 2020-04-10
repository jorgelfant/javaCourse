package a_sequences;

import java.util.Scanner;

public class p_InverseMot {//INVERSER UN MOT

  public static void main(String[] args) {
    String palabra;//palabra ingresada
    char palabraInvertidaC;//letras de la palabra
    String palabraInvertidaS="";//necesario iniciarlo para poder poner el aoutput fuera de la boucle
    int largoPalabra;

    Scanner sc = new Scanner(System.in);
    System.out.println("Ingrese una palabra por favor");
    palabra = sc.nextLine();
    largoPalabra = palabra.length();//voy a almacenar aqui el numero de caracteres
//PRIMERA VERSION
    /*
    for (int i = 1; i <= palabra.length(); i++) {
      palabraInvertidaC = palabra.charAt(palabra.length()-i);//o con substring(,) que utiliza palabras no letras
      System.out.print(palabraInvertidaC);//  substring permitiria imprimir la palabra completa fuera del for
    }
*/
    //SeGUNDA VERSION
    int i=1;//si dentro del boucle pongo uno y no y tendria que inicializar antes el valor de palabraInvertidaS=""
    while (largoPalabra != 0) {//largo palabra contiene palabra.length()
      palabraInvertidaS += palabra.substring(largoPalabra - i, largoPalabra);
      //palabra.length()--;//no compila se necesita una variable largoPalabra va contenerlo
      largoPalabra--;
    }System.out.print(palabraInvertidaS);
  }
}
/*2 opciones pongo el output dentro del boucle para asi imprimir una letra a la vez si que haya
riesgo de que una letra aplaste a la otra.

o la otra opcion poner el output afuera del for y  poner  palabraInvertidaS += palabra.substring(largoPalabra-i, largoPalabra);
para que me imprima letra a letra moviendo cada espacio para que una letra no aplaste a la otra, y al final fuera
del for imprimo la plabra invertida ya hecha, para que esto funcione tendria que iniciar palabraInvertidaS=""
para que el output pueda recuperar el valor
* */