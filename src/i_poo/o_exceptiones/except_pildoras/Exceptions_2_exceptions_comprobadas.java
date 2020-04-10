package i_poo.o_exceptiones.except_pildoras;

import javax.swing.*;

public class Exceptions_2_exceptions_comprobadas<image> extends JPanel {
    //Exceptions comprobadas y no comprobadas.
    //Lanzamiento de exceptions
    //Debemos ver la Class "ImageIO" en la API java que tiene el metodo read (2 con sobrecarga de metodos)
    //read (File input)      read (ImageInputStream  stram)     usaremos el primero que pide un file osea un archivo

    /*
    al cliquear en este metodo vemos la forma de declarar este metodo
              _________________________________________________
              |public static BufferedImage read(File input)   |
              |                          throws IOException   | tiene una clausula throws IOException
              -------------------------------------------------

    Que quiere decir esto?
    cuando un metodo lleva la clausula throw

                 public static BufferedImage read(File input) throws IOException {
                       ..........
                       ..........
                       ..........
                       ..........
                 }
     quiere decir que el metodo en cuestion hace 2 cosas: Si toodo va bien este metodo tiene que return un
     objeto de tipo "BufferedImage" lo que viene en la declaracion del metodo que es dicho sea de paso estatico y public
     el metodo recibe un argumento de tipo File.

      Pero esto es si toodo va bien y el metodo hace bien su trabajo, si no hay imprevistos y luego tenemos la clausula
      "Throws IOException"

      Esto quiere decir que si ocurre un fallo inesperado pues el metodo en vez de realizar su trabajo que consiste a
      devolvernos un objeto de tipo "BufferedImage", lo que va a hacer es lanzar (throw) un "objeto" perteneciente
      a la clase "IOException"
      Como java es un lenguaje 100% orientado objetos, incluco los errores son objetos, asi que lo que lanza el throw
      es un objeto de la classe IOException. Es decir que se crea el objeto de IOException.

      y al pertenecer a IOException, estariamos hablando de un error controlado (no es nuestra culpa) java ha previsto
      la creation de un objeto de tipo IOException en caso de que el metodo no funcione.

      cuando el error (exception) es controlado osea de tipo IOException, el propio lenguaje JAVA nos obliga a tratar o
      manipular ese error.

      en otras palabras nuestro metodo no puede implementarse si un throws IOException para prevenir un eventual error
      que puede ocurrir y que java ya ha previsto.

      asi java nos obliga a usas la estructura

      try{
         .............
      }
      catch(IOException){    (capturar cojer una exception para realizar el codigo alternativo o PLAN B)
         ..............
      }

      que quiere decir, intenta hacer tu trabajo y si no puedes , en vez de detener el programa realiza esta otra cosa
      se parece a un if()  else
    */

    //EJEMPLO
    /*
              public LaminaConImagen(){
                  //EXCEPTION COMPROBADA
                  try{
                      imagen= ImageIO.read(new File("src/desktop/paris.jpg"));//metodo que nos pide objeto de tipo File()
                      //este metddo nos obliga a construir un try catch sino dara error
                  }
                  catch (IOException e){
                      System.out.println("La imagen no se encuentra");
                  }

              }
*/
private image imagen;

}
