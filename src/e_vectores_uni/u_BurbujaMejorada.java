package e_vectores_uni;

import java.util.Scanner;

public class u_BurbujaMejorada {
  public static void main(String[] args) {
    int temp;
    int numero;
    int[] tab = new int[10];
    boolean ordenado; //servira en caso que querramos hacer mas eficiente a nuestro algoritmo burbuja y que no haga
    //mas vueltas de las necesarias

    Scanner sc = new Scanner(System.in);
    for (int i = 0; i < tab.length; i++) {
      System.out.println("Ingrese un numero");
      numero = sc.nextInt();
      tab[i] = numero;
    }
    /*METODO BURBUJA SIMPLE
    // ou (int j=1; j < tab.length; j++) 5-1=4  0 1 2 3
    for (int j=0; j < tab.length-1; j++) {//Dar vueltas al arreglo tamanio-1 o comenzar a partir de 1
      for (int  FluentApiTest= 0; FluentApiTest < tab.length-1; FluentApiTest++) {
        if (tab[FluentApiTest] > tab[FluentApiTest + 1]) {//invierto el simbolo< pa orden descendente o imprimp el ultimo for i=tab.length;i>0;i--
          temp = tab[FluentApiTest];
          tab[FluentApiTest] = tab[FluentApiTest + 1];
          tab[FluentApiTest + 1] = temp;
        }
      }
    }*/
    //Podemos hacer una pequenia modificacion al algoritmo porque normalmente cuando ordena el arreglo, hace una vuelta
    //de mas cuando ya sabemos que el arreglo esta ordenado en la penultima iteracion 2  0 1 2 3 la 3ra de 4
    //es por esta vuelta suplementaria que el algoritmo burbuja no es tan eficiente!!! porque el algo no se da cuenta
    // que el algoritmo ya esta ordenado antes de efectuar todas las vueltas, osea que hace vueltas de mas
    //esta modificacion lo haria mas eficiente

    //para esto vamos a agregar una variable boolean

    //METODO BURBUJA MEJORADO    quitamos el for externo y ahora recorreremos el arreglo con while
    ordenado = false;
    int i = 0;           // 0<(5-1) 0 1 2 3   Necesitamos que ordenado comienze siendo falso pa entrar en la boucle
    int conteo = 0;//vueltas

    while (!ordenado && i < tab.length - 1) { //y que dentro ordenado cambie de valor
      ordenado = true;//importante declarar true al inicio para dar un valor inicial dentro
      for (int k = 0; k < tab.length - 1; k++) {
        if (tab[k] > tab[k + 1]) {//invierto el simbolo< pa orden descendente o imprimp el ultimo for i=tab.length;i>0;i--
          temp = tab[k];
          tab[k] = tab[k + 1];
          tab[k + 1] = temp;
          ordenado = false;//poner dentro del if para que haya cambio, como un conteo que cuenta al entrar en un if
          //si se cambia un elemento con otro temp = tab[FluentApiTest]; ordenado pasa a ser false
        }//si los valores se intercambian ordenado es false pero si ya no se cambian al regresar arriba ordenado sera true
      }// porque ya no entra al if
      i++;
      if (!ordenado) {//if conteo ==false;
        conteo++;//numero de vueltas=numero de veces que se entro al if me los cuenta teniendo en cuenta el estado
      }          // de ordenado al salir del for, si han habiado cambios entonces el valor saldra valiendo false
    }            //al subir valiendo falso baja y obtiene de nuevo ordenado true y si no hay cambios, seguira
    //valiendo true asique al llegar a la condicion esta ya no se cumplira y saldra de la boucle
    System.out.println("el arreglo se ordeno en " + conteo + " vueltas");//conteo ou i

    //IMPRESSION
    for (int indices : tab) {//affiche le tableau ordonné , el ultimo arreglo es bueno con for each
      System.out.print(indices + " ");
    }

  }
}
