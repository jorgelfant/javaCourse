package c_boucles;

import java.util.Scanner;

public class k_SiNo {
  public static void main(String[] args) {
    //Programa que haga un menu del tipo (S/N) y el programa termina hasta que el usuario escriba "S"

    char response;
    Scanner sc = new Scanner(System.in);
    System.out.println("Quieres ir a la fiesta ?");
    response = sc.nextLine().charAt(0);//ou sc.nextLine().response.charAt(0)

    while (response == 'n') {
      System.out.println("Seguire insistiendo hasta que digas que si!");
      System.out.println("Quieres ir a la fiesta ?");
      response = sc.nextLine().charAt(0);//ou sc.nextLine().response.charAt(0)
    }
    System.out.println("Genial, sabia que aceptarias! vamos!!");
  }
}
