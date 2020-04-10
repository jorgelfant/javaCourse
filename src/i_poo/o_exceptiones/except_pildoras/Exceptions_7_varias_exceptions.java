package i_poo.o_exceptiones.except_pildoras;

import javax.swing.*;

public class Exceptions_7_varias_exceptions {
    public static void main(String[] args) {
        //CAPTURA DE VARIAS EXCEPTIONS
        //Esto ocurre cuando en un programa de java tenemos un metodo y este metodo a la hora de ejecutarlo genera
        //o puede llegar a generar exceptiones de diferentes tipos. 3, 4 exceptions y diferentes
        try {
            division();
        } catch (ArithmeticException e) {//catch (ArithmeticException |NumberFormatException e) { .... } en uno solo
            System.out.println("No se permite la division / 0");
        } catch (NumberFormatException e) {
            System.out.println("Se debe introducir un int y no otra cosa");
            System.out.println(e.getMessage());//EJEMPLO DE UTILISATION DE ESTOS 3 metodos
            System.out.println("Se ha generado un error de esto tipo:  "+e.getClass().getName());
            //nos da la clase de la exception    class java.lang.NumberFormatException
        }
    }//VARIOS CATCHS PA CAPTURAR VARIAS EXCEPTIONES SIENDO ESPECIFICO / CONCRETO
    //En estos casos se suelen utilizar tambien 3 metodos,
    // getMessage() ---viene de la clase Throwable y devuelve un String   --nos devuelve un string sobre el error (lo que escribimos)
    // getClass()   ---iene de la clase Object
    // getName() ----pertenece a la clase class
    //NOS INFORMAS DE QUE CLASE DE ERROR HA OCURRIDO.....SUELE SER BASTANTE UTIL

    //DESDE JAVA 7 AHORA SE PUEDEN PONER VARIAS EXCEPTIONES EN UN SOL CATCH
    // catch (ArithmeticException |NumberFormatException e) { .... }

    //METHODE
    public static void division() {//nuestro metodo puede llegar a lanzar diferentes exceptiones o except de diferente tipo
        int num1 = Integer.parseInt(JOptionPane.showInputDialog("Introduce el numerador"));
        int num2 = Integer.parseInt(JOptionPane.showInputDialog("Introduce el denominador"));
        System.out.println("El resultado es " + (num1 / num2));//si el denominador es 0 esto daria una exception:
    }                                        //Exception in thread "main2" java.lang.ArithmeticException: / by zero
    //que hereda de RuntimeException (no controlada) UNCHECKED
}                                            //y si en vez de introducir un int introducimos otra cosa:
// //Exception in thread "main2" java.lang.numerFormat exception
//que hereda tambien de RuntimeException (no controlada) UNCHECKED
//NO ES BUENA PRACTICA CAPTURAR EXCEPTIONES DE TIPO NO COMPROBADAS RUNTIMEEXCEPTION, no es una buena practica
//SI QUEREMOS CAPTURAR ESTAS EXCEPTIONES HAY UNA FORMA DE HACERLO PERO TAMPOCO ES UNA BUENA PRACTICA,
//si metemos dentro de un try la llamada al metodo y en el catch(Exception e) pero no es buena practica pk es muy generico
//el system.out.println diria por ejemplo hay un erro!...pero que error? es muy generico lo que se debe hacer es capturar
//estas exceptiones una a una pa tener algo mas preciso
//SOLO ESTAMOS PRACTICANDO PARA CUANDO DEBAMOS TRABAJAR MAS ADELANTE CON LAS COMPROBADAS (base de datos etc)

//para atrapar entonces varias exceptions despues del try podemos usar varios catch
