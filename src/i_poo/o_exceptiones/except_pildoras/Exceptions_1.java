package i_poo.o_exceptiones.except_pildoras;

import javax.swing.*;

public class Exceptions_1 {
    public static void main(String[] args) {
        //EXPLICACION
        //olvido de una coma, entonces error de compilation   ',' expected errores de syntaxis (aprender a escribir bien)
        //MAtrice de 5
        int[] miMatriz = new int[5];

        miMatriz[0] = 5;
        miMatriz[1] = 38;
        miMatriz[2] = 15;
        miMatriz[3] = 92;
        miMatriz[4] = 71;
        miMatriz[5] = 71;//aumento un valor en un tab de 5 (osea tendriamos 6) se sale del tab

        for (int i = 0; i < miMatriz.length; i++) {
            System.out.println("Posicion " + i + " = " + miMatriz[i]);
        }
        //nos da una exception in Thread "main2 " (hilo principal) de typo java.lang.ArrayIndexOutOfBoundsException: 5
        //ligado a la LOGICA y no a la syntaxis, runtimeException yo diria , culpa del programador
        //se ha generado un objeto ERROR de tipo ArrayIndexOutOfBounds que es una clase
        //esta clase heredad de RuntimeException que hereda a la vew de exception
        //DEBIDO A ESTE TIPO DE ERRORER LA EJECUCION NO SE LLEVA A CABO
        //OSEA QUE NUNCA SE LLEGA  A LA 2da parte de nuestro programa que consistia en da nombre y edad
        //SE PARA DONDE OCURRIO EL ERROR

         /*
        Si tenemos por ejemplo un programa de 5000 lineas de codigo, y queremos que esa unica linea que tiene un error
        no impida la ejecucion del rento del programa, es decir que no ejecute la parte que falla pero si ejecute
        el resto, es decir la parte del codigo que no falla.

        No me ejecutes la parte que genera el error pero al menos ejecutame la parte que funciona, asi podemos controlar
        los errores que se puedan llegar a producir en una parte del codigo para que el resto del programa siga su ejecucion*/
        /*
        java.lang.Object
                   |
               java.lang.Throwable
                           |
                       java.lang.Exception
                                     |
                                java.lang.RuntimeException  (EXCEPTION NO COMPROBADA)
                                                   |
                                           java.lang.IndexOutOfBoundsException
                                                                |
                                                        java.lang.ArrayIndexOutOfBoundsException

         osea un error de RunTimeException, culpa de la logica del programador

         Para los errores de tipo IOException en los que no tenemos la culpa, java que es un lenguaje robusto ya
         tiene previstas situaciones para esto tipo de exceptiones, java ya previo esto. Por ejemplo cuando necesitamos ir
         en un programa a una carpeta pa ir a cojer una imagen, se puede producir un error en el que elprogramador no
         tiene culpa. Ex. debemos ir a buscar una imagen en src/proyecto1/bola.gif
         y alguien mueve este archivo de esa carpeta antes de que yo lo ejecute. nuestro programa no funciona.

         Como este tipo de errores, exceptiones son ajenos a nuestras voluntad , java ya tiene prevista una respuesta
         ya planeo que hacer
        */
        //EJEMPLO
        /*                EXCEPTION AJENA A NUESTRA VOLUNTAD, Java ya ha considerado esto y nos obliga a construir
                          la exception preyendo lo que puede eventualmente pasar, como el hecho de que la imagen no este

                            public LaminaConImage(){

                                try{   (intenta esto)
                                   Image=ImageIO.read(new file("src/graficos/bola.gif"));
                                }
                                catch(IOException e){ ( sino funciona Capturamos la exception)
                                    System.out.println("La imagen no se encuentra");
                                }
                            }

         SI SOLO PUSIERAMOS ESTO :  Image=ImageIO.read(new file("src/graficos/bola.gif"));
         java nos daria error, porque nos dice que la exception no esta tratada, es decir que no estamos preveyendo
         lo que podria pasar si la imagen no esta. ESTAMOS OBLIGADOS A CAPTURAR EL POSIBLE ERROR
        */

        String nombre = JOptionPane.showInputDialog("Ingrese su nombre");
        int edad = Integer.parseInt(JOptionPane.showInputDialog("Ingrese su edad"));
        System.out.println("Hola " + nombre + " tienes " + edad + " anos. " + " El programa termino su ejecucion ");


    }
}
