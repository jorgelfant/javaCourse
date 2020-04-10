package i_poo.o_exceptiones.except_pildoras;

import javax.swing.*;
import java.io.EOFException;

public class Exceptions_5_formaManual {
    //Lanzamiento de exceptions de forma manual  CLAUSULA "throw"
    public static void main(String[] args) {
        //NO CONFUNDIR throws con throw
        //throws la usamos en la declaracion de un metodo para indicar que este metodo podria indicar una exception
        //Mientras que la clausula "throw" sin "s" la podemos usar en cualquier punto del codigo para indicar que
        //en ese punto concreto del codigo se lanza una exception
        String elMail = JOptionPane.showInputDialog("Introduce mail");

        try {//el error podria estar en si es <3 es por eso FluentApiTest creamos ahi la exception(error)
            examinaMail(elMail);
        }
        catch(EOFException e){
            System.out.println("La direccion de email no es correcta");
        }
        //el problema es que si pusieramos a@.  esto cumpliria con las condiciones y daria correcto
        //pero sabemos que este tipo de email no es correcto
        //hay muchas soluciones
        //podemos decir que si un email tieene <=3 lanzar una EXCEPTION en el punto del codigo que querramos con throw
    }

    public static void examinaMail(String elMail) throws EOFException {//errores de este tipo (FluentApiTest pusimos al azar) son obligatorios
        int arroba = 0;                                                //de atrapar ya que exceptiones comprobadas
        boolean punto = false;
        //ESTO ES LANZAR UNA EXCEPTION DE MANERA MANUAL CON LA CLAUSULA throw, creamos el objeto y lo lanzamos en el punto elejido
        //pero no tiene sentido porque no corresponde el tipo de error lanzado con lo que ha ocurrido
        if (elMail.length() <= 3) {//le decimos que lance la exceptio, PERO de que tipo seria esta exception??
            /*redundante
            //ArrayIndexOutOfBoundsException miException = new ArrayIndexOutOfBoundsException();//crear exception y lanzar la instancia
            //throw miException;//aunque no tendria sentido porque ya sabemos que no es un error de este tipo*/
            throw new EOFException();//mas corto simplifica el codigo
            //la ponemos aqui porque este es el lugar donde puede dar error if (elMail.length() <= 3)
        } else {

            for (int i = 0; i < elMail.length(); i++) {
                if (elMail.charAt(i) == '@') {
                    arroba++;
                }
                if (elMail.charAt(i) == '.') {
                    punto = true;
                }
            }

            if (arroba == 1 && punto) {
                System.out.println("Es correcto");
            } else {
                System.out.println("Incorrecto");
            }
        }
    }
}
/*IMPORTANTE
  si tenemos un metodo en el que en algun punto se lanza una exception con "throw" como en el ejemplo
  debemos indicarle al metodo en su declaracion que podria lanzar un metodo de este tipo:

  public static void examinaMail(String elMail) throws ArrayIndexOutOfBoundsException{
  }
  Lo que conseguimos con esto es que cuando el resto de programadores vean este metodo que yo cree, sepan
  que este metodo podria lanzar una exception y que convendria capturarla

  Luego entonces cuando indicamos que el metodo podria lanzar una exception  lo que deberiamos hacer es
   capturar esta exception con  un try{} catch(){}

   EN EL EJEMPLO ANTERIOR  DECIAMOS AL METODO THROWS UNA EXCEPTION PERO NUNCA PONIAMOS O CREABAMOS EN UN LUGAR
   DETERMINADO LA EXCEPTION (en su caso InputMismatchException) sin embargo aqui SI LO HEMOS HECHO.

   LA DIFERENCIA ES QUE ESTA EXCEPCION  QUE HEMOS FABRICADO NOSOTROS VA OCURRIR SI O SI porque somos nosotros los
   que manualmente la estamos PROVOCANDO con la clausula "throw".

   Aunque no tiene sentido en este programa porque esta exception "EOFException" ocurre cuando se llega
    a un final inesperado a la hora de recorrer un archivo externo y no es la tarea que estamos realizando en el codigo
*/
