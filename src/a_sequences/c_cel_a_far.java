package a_sequences;

import java.util.Scanner;

public class c_cel_a_far {
  public static void main(String[] args) {//Convertir grados celsius a grados fahrenheit
    //formula F=9/5 C+32
    int gradosC ;
    int gradosF ;

    Scanner sc = new Scanner(System.in);
    System.out.println("Ingrese los grados que desea convertir");

    gradosC = sc.nextInt();
    gradosF = ((9*gradosC)/5 +32);
    System.out.println(gradosC + " grados celsius son " + gradosF + " grados fahrenheit");
  }
}
