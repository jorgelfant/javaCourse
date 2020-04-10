package b_condicionales;

import java.util.Scanner;

public class a_edad {
  public static void main(String[] args) {//mayor de edad para votar o no
    int edad;
    Scanner sc=new Scanner(System.in);
    System.out.println("Ingrese su edad");
    edad=sc.nextInt();

    if(edad>=18){
      System.out.println("Puedes votar ");
    }
    else{
      System.out.println("vuelve cuando seas mayor de edad");
    }
  }
}
