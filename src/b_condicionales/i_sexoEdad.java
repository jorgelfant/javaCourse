package b_condicionales;

import java.util.Scanner;

public class i_sexoEdad {
  public static void main(String[] args) {
    //Ingresar el nombre, edad y sexo de la persona, se imprime el nombre si la persona es mayor y hombre
    String nombre, sexo;
    int edad;
    Scanner sc = new Scanner(System.in);
    System.out.println("Ingrese su nombre");
    nombre = sc.nextLine();
    System.out.println("Ingrese su sexo");
    sexo = sc.nextLine();
    System.out.println("Ingrese su edad");
    edad = sc.nextInt();

    if (sexo.equals("hombre") && edad >= 18) {
      System.out.println(nombre + " puede entrar porque es hombre y mayor de edad");
    } else {
      System.out.println(nombre + " no puede entrar ");
    }
  }
}
