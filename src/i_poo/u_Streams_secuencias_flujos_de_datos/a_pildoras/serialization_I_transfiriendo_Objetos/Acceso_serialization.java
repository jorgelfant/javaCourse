package i_poo.u_Streams_secuencias_flujos_de_datos.a_pildoras.serialization_I_transfiriendo_Objetos;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class Acceso_serialization {
    public static void main(String[] args) {
        //Serializacion   TRANSFIRIENDO OBJETOS
        /*
          En que consiste?
          ----------------

          Serializar consiste en CONVERTIR UN OBJETO que podamos haber creado nosotros dentro de un programa JAVA
          en una succesion de Bytes.

          Con el objetivo de poder almacenar ese objeto en un medio de almacenamiento, discoDuro, etc
                                                                           -----
                                                                           |   Disco Duro etc
         ---------------                                                   |
         |             |                    BYTE                           |   ordenador remoto
         |             | ------------------------------------------------  |
         |    Objeto   |          Enteros entre 0 y 255                    |
         |             | ------------------------------------------------  |
         |             |   65  125  45  225  185  195 215  45  10  250     |
         --------------                                                    |
                                                                           |
                                                                           |
                                                                           |
                                                                           -----

         Y en el futuro restaurar o recomponer ese objeto, al estado en el que se encontraba cuando lo serializamos

         SERIALIZAR = CONVERTIR EN BYTES

         y sobre toodo la serializacion se utiliza en java para, ese objeto que hemos convertido en Bytes, distribuirlo
         a travez de la RED a ordenadores remotos. Y que en entos ordenadores remotos este objeto sea restablecido
         al estado en el que se encontraba cuando se serializo.

         Que clases necesitamos en JAVA para realizar esta tarea : Vamos a tener que utilizar una nueva interface

                                                 interface
                                              ****************
                                              * Serializable *
                                              ****************

                  Class                                                            Class
        ************************                                           ************************
        *  ObjectOutputStream  *                                           *  ObjectInputStream  *
        ************************                                           ************************

                 method                                                            method
        ************************                                           ************************
        *      writeObject()   *                                           *      readObject()    *
        ************************                                           ************************


        Serializable  es una interface de manejo sencillo porque no tiene metodo ninguno, entonces aquella
        clase que implemente esta interface, no se ve obligada (como ocurre con otras) a sobreescribir
        ningun metodo.

        Lo unico que hay que hacer es indicarle a una clase que implemente esta interface y ya.
        Y que implica esto? que una clase implemente la interface Serializable ?

        Pues implica que le estamos diciendo a nuestro programa de java que los objetos de las clases que implementan
        Serialisable, son susceptibles de ser convertidos en Bytes para tranferlirlos a travez de la red a
        ordenadores remotos o guardarlos en el disco duro. Hacer con ellos lo que queramos.

        Ademas de esta interface SERIALIZABLE , vamos a necesitar manejar 2 clases :

                   Class                                                            Class
        ************************                                           ************************
        *  ObjectOutputStream  *                                           *  ObjectInputStream  *
        ************************                                           ************************

        construye un flujo de                                              Crea un flujo de datos que
        datos a travez de la cual                                          a travez del cual es posible
        es posible transferir un                                           que viaje un objeto pero desde
        objeto desde dentro hacia                                          afuera hacia adentro. Un objeto
        afuera es decir de nuestro                                         remoto hacia dentro de nuestro
        programa de java hacia un                                          programa y luego  ya dentro del
        medio de almacenamiento o                                          programa recomponer esos bytes
        hacia un ordenador remoto                                          que han entrado en el objeto
        o hacia otra fuente de                                             correspondiente.
        almacenamiento desconocido.


        estas clases tienen sus correspondientes metodos, entre los que podemos destacas:

                 method                                                            method
        ************************                                           ************************
        *      writeObject()   *                                           *      readObject()    *
        ************************                                           ************************
         Crea ese objeto, esa                                               Lee esa succesion de bytes
         succesion de bytes para                                            que nos entra por el flujo
         lanzarla a travez de                                               de datos InputStream hacia
         ese flujo de datos hacia                                           nuestro programa.
         afuera.
        */

//**********************************************************************************************************************

        //EJEMPLO: trabajamos con 2 clases conocidas Jefe y Empleado

        Administrador jefe = new Administrador("Juan", 80000, 2005, 12, 15);
        jefe.setPrime(5000);//metodo de su clase padre Jefe

        Empleado[] personal = new Empleado[3];//creamos un tb de Empleado
        personal[0] = jefe;
        personal[1] = new Empleado("Ana", 25000, 2008, 10, 1);
        personal[2] = new Empleado("Luis", 18000, 2012, 9, 15);

        //Lo que vamos a hacer es SERIALIZAR el objeto personal ( osea el array)
        //Esto implica que lo vamos a convertir en una succession de bytes para almacenar este objeto
        // de tipo Empleado que se llama personal, en nuestro disco duro .

        //Y despues lo que haremos es rescatarlo del disco duro e imprimir el resultado en consola
        //Asi lo primero que debemos hacer es ver cual es el tipo del objeto que queremos serializar
        //vemos que es de tipo Empleado asi que es Empleado que debe implementar Serializable
        //Empleado implements Serializable

        //Y con esto lo que hemos hecho es decirle a nuestro codigo de programacion que aquellos objetos que
        //pertenezcan a esta clase Empleado son susceptibles o pueden convertirse en Bytes

        //Si vemos la description de Serializable en la API de java vemos que :

        /*
        public interface Serializable

        Serializability of a class is enabled by the class implementing the java.io.Serializable interface.
        Classes that do not implement this interface will not have any of their state serialized or deserialized.
        All subtypes of a serializable class are themselves serializable. The serialization interface has no methods
        or fields and serves only to identify the semantics of being serializable.
        */

        //Siguiente paso : construir on objeto de typo ObjectOutputStream  ( que es como el puente)

        /*  ObjectOutputStream

        public class ObjectOutputStream
           extends OutputStream
        implements ObjectOutput, ObjectStreamConstants


         Constructors
         Modifier	                            Constructor and Description
         --------                               ---------------------------
         protected	                            ObjectOutputStream()
                                                   Provide a way for subclasses that are completely
                                                   reimplementing ObjectOutputStream to not have to allocate
                                                   private data just used by this implementation of ObjectOutputStream.

                                             	ObjectOutputStream(OutputStream out)
                                                   Creates an ObjectOutputStream that writes to the specified OutputStream.


        */
        //**************************************************************************************************************
        //                                        SALIDA y ENTRADA DEL OBJETO
        //**************************************************************************************************************

        //El constructor que vamos a usar lanza una exception
        try {//pide un argumento de tipo OutputStream , podemos implementar un objeto de clase FileOutputStream que hereda de OutputStream
            //esta clase era usada para transmitir bytes es decir archivos videos PDF  Word, etc
            ObjectOutputStream salida = new ObjectOutputStream(new FileOutputStream("C:/Users/Jorge/Desktop/Test/empleado.dat"));
            ObjectInputStream entrada = new ObjectInputStream(new FileInputStream("C:/Users/Jorge/Desktop/Test/empleado.dat"));
            salida.writeObject(personal);//el objeto que queremos llevar al exteior en este caso es personal , que es un array
            //     metodo void, no devuelve nada    writeObject() write the specified object to the ObjectOutstream
            //System.out.println(entrada.readObject());//Read an object from the ObjectInputStream.  retorna un objeto de tipo Object
            //casting pa decirle que el Object es en realidad Empleado, o hubieramos podido almacenarlo  en Object[]
            Empleado[] tab = (Empleado[]) entrada.readObject();//ya que sabemos que este objeto es un array de tipo empleado
            for (Empleado e: tab) {
                System.out.println(e);//o con toString
            }

            salida.close();
            entrada.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        //al pulsar en run, empleado.dat es exportado a la carpeta Test


    }
}
