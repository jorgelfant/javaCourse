package i_poo.o_exceptiones.except_pildoras;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Exceptions_4_exceptions_comprob_y_noComprob {
    //EXCEPTIONES COMPRABADA Y NO COMPROBADAS , PERFECCIONAMIENTO DEL EJERCICIO ANTERIOR
    //en una exception no comprobada (FluentApiTest depende de nuestra logica) no es obligatorio implementar el tray catch
    public static void main(String[] args) {

        System.out.println("Que deseas hacer?");
        System.out.println("1. Introducir datos ");
        System.out.println("2. Salir del programa ");

        Scanner sc = new Scanner(System.in);//abrir

        int decision = sc.nextInt();

        if (decision == 1) {
            try {//el metodo pedirDatos() throws InputMismatchException para implementar el try catch (aunque no obligado)
                pedirDatos();
            } catch (InputMismatchException e) {
                System.out.println("El tipo de dato insertado no corresponde al tipo de variable pedida");
            }
        } else {
            System.out.println("Adios !");
            System.exit(0);
        }
        sc.close();//cerrar
    }

    //METODO                               o RuntimeException su padre es mas generico
    //poner el try catch dentro del propio metodo no tiene mucho sentido, la exception debe ser capturada desde afuera
    public static void pedirDatos() throws InputMismatchException {//si nuestro metodo va bien ejecutalo y sino crear un objeto
        Scanner sc = new Scanner(System.in);

        System.out.println("Introduce tu nombre, por favorr");
        String nombre = sc.nextLine();
        System.out.println("Introduce tu edad, por favor");
        int edad = sc.nextInt();
        System.out.println("Hola " + nombre + " el proximo anio tendras " + (edad + 1) + " anioss");

        sc.close();

        System.out.println("Hemos terminado");//esta linea se ejecutara si las cosas van bien o si las cosas van mal
    }
}
