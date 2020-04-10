package b_condicionales;

import java.util.Scanner;

public class h_signoAries {
  public static void main(String[] args) {//Ingresar por teclado el nombre y signo de cualquier persona e imprima
    //el nombre de l apersona solo si esta es de signo aries
    String nombre, signo;

    Scanner sc = new Scanner(System.in);
    System.out.println("Ingrese su nombre");
    nombre = sc.nextLine();
    System.out.println("Ingrese su signo");
    signo = sc.nextLine();

    if (signo.equals("aries")) {//nombre =="aries" no es valido, se comparan strings en java con equals
      System.out.println("El nombre de la persona de signo aries es " + nombre);
    }
    else{
      System.out.println("La persona no es aries");
    }
  }
}
