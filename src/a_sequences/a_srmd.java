package a_sequences;

import java.util.Scanner;

public class a_srmd {
  public static void main(String[] args) {
    //Demander 2 chiffres et faire une somme, soustraction, multiplication et division
    //int nb1,nb2=0;
    int n1;
    int n2;
    Scanner sc = new Scanner(System.in);
    System.out.println("enter 2 numbers");
    n1 = sc.nextInt();
    n2 = sc.nextInt();

    int somme = n1 + n2;
    int sous = n1 - n2;
    int multi = n1 * n2;
    int div = n1 / n2;

    System.out.println("Le résultat de la somme est " + somme + "\nLe résultat de la soustraction est " + sous +
        "\nLe résultat de la multiplication est " + multi + "\nLe résultat de la division est " + div);


  }
}
