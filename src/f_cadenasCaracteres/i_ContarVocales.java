package f_cadenasCaracteres;

import java.util.Scanner;

public class i_ContarVocales {
  public static void main(String[] args) {
    //Leer una frase y contar el numero de vocales (de cada una) que aparecen

    String frase;
    Scanner sc = new Scanner(System.in);

    System.out.println("Ingrese una frase");
    frase = sc.nextLine();
    frase=frase.toLowerCase();//Importante que la frase sea pasada a minusculas para poner hacer el conteo
                              //ya que mayuscula y minuscula no es igual
    String vocales = "aeiou"; //podria poner esto en un tableau tambien
    int[] repet = new int[vocales.length()];//5

    for (int i = 0; i < frase.length(); i++) {
      for (int j = 0; j < vocales.length() - 1; j++) {
        if (frase.charAt(i) == vocales.charAt(j)) {
          repet[j] += 1;//otra alternatica seria hacer un contador pa cada letra conteoA  conteoE etc
        }
      }
    }
    for (int k = 0; k < repet.length; k++) {
      if (repet[k] != 0) {
        System.out.println("La vocal " + vocales.charAt(k) + " se repite " + repet[k] + " veces");
      }
    }
    //------------------------------------------------------------------------------------------------------------------
    //                  METHODO 1 para encontrar el numero de veces que se repite cada numero EFFICACE
    //------------------------------------------------------------------------------------------------------------------
    /*
    int[] tab = {1, 2, 5, 5, 7, 8, 7, 9, 2, 2, 9, 10, 15, 15, 5, 3, 3, 3, 3, 3, 3};
    int[] rep = new int[tab.length];//en el tb de repeticiones pongo el mismo tamanio que en el tableau

    for (int i = 0; i < tab.length; i++) {
      rep[tab[i]] += 1;//rep[tableau[i]]=rep[tab[i]] + 1;
    }

    for (int i = 0; i < rep.length; i++) {
      if (rep[i] > 1) {  //filtro
        System.out.println("indice " + i + ": " + rep[i] + " fois");
      }
    }*/
    //------------------------------------------------------------------------------------------------------------------
    //                  METHODO 2 para encontrar el numero de veces que se repite cada numero//COMPLICADO
    //------------------------------------------------------------------------------------------------------------------
    /*
    int[] tab = {1, 2, 5, 5, 7, 8, 7, 9, 2, 2, 9, 10, 15, 15, 5, 3, 3, 3, 3, 3, 3};
    int[] tab2 = {1, 2, 3, 5, 7, 8, 9, 10, 15};//se sincroniza con el rep[} 0 0  1 1 etc
    int[] rep = new int[tab.length];//los numero de tab2 vendrian a ser los indices en el rep[]

    for (int i = 0; i < tab.length; i++) {
      for (int j = 0; j < tab2.length; j++) {
        if (tab[i] == tab2[j]) {
          rep[j] += 1;//mejor seria rep[tab[j]] += 1; pero ya seria como en el primer metodo
        }

      }
    }
    for (int FluentApiTest = 0; FluentApiTest < rep.length; FluentApiTest++) { //no es que FluentApiTest valga 2 como indice y 3 como valor sino que FluentApiTest es indice 1 valor 3
      if (rep[FluentApiTest] > 1) {//repeticion es cuando vale mas de 2     tab2 y repeat esatn sincronizados al tener el mismo size
        System.out.println(tab2[FluentApiTest] + " se repite " + rep[FluentApiTest] + " veces");
      }               //       2                       3
    }
*/
  }
}

