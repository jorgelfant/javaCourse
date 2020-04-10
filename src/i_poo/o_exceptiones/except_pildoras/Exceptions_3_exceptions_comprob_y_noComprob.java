package i_poo.o_exceptiones.except_pildoras;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Exceptions_3_exceptions_comprob_y_noComprob {
    //EXCEPTIONES COMPRABADA Y NO COMPROBADAS , lanzamiento de exceptions ( throws / try /catch)
    public static void main(String[] args) {

        System.out.println("Que deseas hacer ?");
        System.out.println("1. Introducir datos");
        System.out.println("2. Salir del programa");

        Scanner sc = new Scanner(System.in);//abrir

        int decision = sc.nextInt();

        if (decision == 1) {
            pedirDatos(); //podriamos haber hecho el try catch aqui tb
        } else {
            System.out.println("Adios");
            System.exit(0);
        }
        sc.close();//cerrar
    }

    //METODO                               o RuntimeException su padre es mas generico
    public static void pedirDatos() throws InputMismatchException {//si nuestro metodo va bien ejecutalo y sino crear un objeto
        try {
            Scanner sc = new Scanner(System.in);//abro                 //exception de tipo InputMismatchException que hereda de
            //RunTimeException, la cual no obliga a usar un try catch
            System.out.println("Introduce tu nombre, por favor");      //si lo ejecutamos funcionara aun sin el try catch
            String nombre = sc.nextLine();
            System.out.println("Introduce tu edad, por favor");
            int edad = sc.nextInt();//imaginemos que en vez de introducir un int en edad pongamos otra cosa, string por ex
            //esto daria un Exception in thread "main2" java.util.InputMismatchException
            //es decir que el error es de tipo InputMismatchException..debemos saber si este hereda de IOException o RunTimeException
            //para saber si es un error que no depende de mi (exception comprobada)  o no comprobada ( que depende de la logica)
            System.out.println("Hola " + nombre + " el proximo anio tendras " + (edad + 1) + " anios");

            sc.close();//cierro
        } catch (InputMismatchException e) {//sino se crea un objeto InputMismatchException que se almacena en la "e" para capturalo
                 //o RuntimeException e  (su padre)
            System.out.println("El tipo de dato insertado no corresponde al tipo de variable pedida");//y que nos imprima esta linea
        }

        System.out.println("Hemos terminado");//esta linea se ejecutara si las cosas van bien o si las cosas van mal
    }
}
/*
java.lang.Object
        java.lang.Throwable
                java.lang.Exception
                         java.lang.RuntimeException
                                    java.util.NoSuchElementException
                                                   "java.util.InputMismatchException"

Como el error es de tipo no comprobada "RunTimeException" (que depende del programador de su logica) entonces
no estoy obligado a usar un TRY{} CATCH() {}

PERO EL HECHO QUE NO ESTE OBLIGADO, NO QUIERE DECIR QUE NO LO PUEDA UTILIZAR, y es que muchas veces es que tenemos
en un programa de estzd caracteristicas, descubrimos que es probable que durante la ejecucion del programa haya
una exception, un error, pero no se nos ocurre como mejorar el codigo para que este error no ocurra.

SOLUCIONES HAY AUNQUE NO SE NOS OCURRAN, QUE PODEMOS HACER? :

DECIR QUE A LOS METODOS QUE HEMOS CREADO NOSOTROS DENTRO DE NUESTRO PROGRAMA QUE "LANCEN UNA EXCEPTION"
CONCRETAMENTE PODEMOS DECIRLE QUE LANCE UNA EXCEPTION DE ESTE TIPO "InputMismatchException" que es la mas susceptible
de pasar en nuestro ejemplo.

y despues de decirle que lanze una exception capturarla con un CATCH, COMO HACER??? pues utilizando
ejemplo throws IOException o throws RunTimeException

                 "LA CLAUSULA throws "

             <<<<<<AUNQUE ESTO NO ESTA CONSIDERADO UNA BUENA PRACTICA DE PROGRAMACION >>>>>
                  porque se puede mejorar el codigo para que no de este tipo de error

 ENTONCES PORQUE CONTROLAR EL ERROR LANZANDO UNA EXCEPTION Y CAPTURANDOLA CON UN TRY CATCH?si se puede mejorar
 el codigo pa que esto no ocurra??

 Pero hay veces en que llega a ser un recurso y nos ayuda a entender el funcionamiento de la clausula "throws"
 al momento de hacer el catch se debe indicar de que tipo de EXCEPTION se trata .

 DEBE SER LA MISMA QUE LANZA EL METODO o una QUE ESTE POR ENCIMA EN LA JERARQUIA (padre, abuelo etc)
 en nuestro caso podriamos usar RuntimeException o Exception(que es su super clase)
*/
