package i_poo.u_Streams_secuencias_flujos_de_datos.a_pildoras.serialization_II_CambioDeVersiones_serialVersionUID;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class Acceso_serialization {
    public static void main(String[] args) {
        // Serialization 2 , CAMBIO DE VERSIONES   -  serialVersionUID

        // Vamos a ver que pasa cuando cambiamos de version el programa que se encarga de serializar objetos
        // Cambiar de version significa, actualizar el programa, mejorarlo, modificar alguna cosa en el programa
        // que se encarga de serializar objetos.

        //Veremos que significa la constante "serialVersionUID" y como podemos usar esta constante en nuestro beneficio

        /*

         ---------------                                                   ---------------
         |             |                                                   |              |
         |             |                                                   |              |
         |    CODIGO   |                                                   |   CODIGO     |
         |             |                                                   |              |
         |             |                                                   |              |
         --------------                                                    ----------------
                                             INTERNET

             Mi PC                                                              OTRA PC

         Pongamonos en el escenario, en el que tenemos un EMISOR y que tenemos un RECEPTOR
         Y el emisor quiere enviar por la red  un objeto que se encuentra dentro de un programa java
         al receptor. este era uno de los objetivos que tenia serializar objetos.

         Para esto sirve Serialization para poder enviar objeto a un receptor (y recuperar).
         Si queremos que esto sea posible, tanto el emisor que se encarga de enviar el objeto
         como el receptor que va a leer el objeto serializado que le llega por la red, deben
         tener una COPIA IDENTICA DEL PROGRAMA JAVA, deben tener la MISMA VERSION DEL PROGRAMA
         JAVA.

         Cuando creamos un programa JAVA, aunque nosotros no lo vemos, ese programa JAVA tiene una huella
         que pues podemos asemejar a un numero identificativo unico para este programa JAVA que acabamos
         de crear.

         Es como un DNI, los programas java tienen un numero identificativo denominado "SHA"  que es
         la huella del programa. Esta huella la realiza el compilador de java de forma automatica
         y la realiza en funcion de las clases, subclases, metodos y campos que tiene una clase.

         Es decir que el compilador JAVA analiza detenidamente como esta construida esa clase
         y en funcion de como este construida pues genera esa huella.

         En un programa JAVA esta huella consiste en una succesion de 20 bytes que se denonima:
         "serialVersionUID"

         Luego entonces si el emisor quiere SERIALIZAR UN OBJETO para enviarselo al RECEPTOR.
         AMBOS DEBEN TENER UNA COPIA IDENTICA DEL PROGRAMA, es decir una copia con el miso
         "serialVersionUID" es decir que esto debe ser el mismo tanto para el emisor como para
         el receptor.

         Y si esto es asi pues se SERIALIZA el objeto y se envia por la red al receptor sin ningun
         problema. En el mundo del software los programas mejoran continuamente.

         Esto puede llegar a ser un problema a la hora de serializar objetos, si por ejemplo
         el programa cambia, a la hora de serializar un objeto y ese cambio que ha sufrido el programa
         pues no lo distribuimos a todos los receptores que van a recibir un objeto serializado nos
         vamos a encontrar con un problema.

         Porque cuando un programa cambia, pues o bien modificando un metodo o bien quitando o agregando
         campos dentro de esta clase o cualquier otro cambio, entonces tambien cambia la huella "SHA"
         el serialVersionUID.

         con lo cual si el programa del emisor no es exactamente el mismo que el del programa del receptor
         , quiere decir que cada programa va a tener un seriaVersionUID diferente. generado automaticamente
         por el compilador de JAVA.

         ---------------                                                   ---------------
         |             |                                                   |              |
         |             |                                                   |              |
         |  PROGRAMA   |                                                   |   PROGRAMA   |
         |             |                                                   |              |
         |             |                                                   |              |
         --------------                                                    ----------------
                                             INTERNET
       65748601234546789675L                                              -965089988079125687L
         serialVersionUID.                                                  serialVersionUID.
             Mi PC                                                              OTRA PC


         Y que ocurre cuando el serialVersionUID es diferente ? Pues en ese caso el emisor serializara el objeto
         intentara enviarlo al receptor, pero el receptor no lo podra leer.

         JAVA hace una comprobacion muy estricta a la hora de SERIALIZAR OBJETOS.
         Ve que el objeto serializado pues tenga el mismo serialVersioUID que el programa
         que va a tratar de leer el objeto.

         Vamos a utilizar el ejemplo del video anterior para hacer un ejemplo, en el cual
         serializaremos el objeto. Pero despues de serializar el objeto vamos a cambiar algo en este programa.
         e intentaremos leer el archivo serializado despues para ver que si hemos cambiado algo pues no es posible.

         Vamos a hacer una simulacion como emisor y recptor al mismo time.
        */
        Administrador jefe = new Administrador("Juan", 80000, 2005, 12, 15);
        jefe.setPrime(5000);//metodo de su clase padre Jefe

        Empleado[] personal = new Empleado[3];//creamos un tb de Empleado
        personal[0] = jefe;
        personal[1] = new Empleado("Ana", 25000, 2008, 10, 1);
        personal[2] = new Empleado("Luis", 18000, 2012, 9, 15);


        //este programa hace las 2 tareas, envia el objeto y lo recupera
        try {
            ObjectOutputStream salida = new ObjectOutputStream(new FileOutputStream("C:/Users/Jorge/Desktop/Test/empleado.dat"));
            salida.writeObject(personal);
            salida.close();

            ObjectInputStream entrada = new ObjectInputStream(new FileInputStream("C:/Users/Jorge/Desktop/Test/empleado.dat"));
            Empleado[] tab = (Empleado[]) entrada.readObject();
            entrada.close();

            for (Empleado e : tab) {
                System.out.println(e);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        //VAMOS A IMAGINAR LO SIGUIENTE: Imaginemos que en este momento en el cual hemos generado el objeto
        //SOMOS EL EMISOR , pero ahora vamos a ponernos de parte del RECEPTOR. Vamos a imaginar que somos
        //El receptor de este objeto serializado y que necesitamos leerlo.

        //despues de enviar el objeto podemos comentar esas 3 lineas encargadas de enviar el objeto y dejamos solo
        //las lineas que se encargan de leer el objeto y de IMPRIMIRLO EN PANTALLA, entonces como el objeto ya
        //esta en la carpeta lo leemos y toodo bien!

        //Esto es como si fueramos el receptor en otra pc que tiene el mismo seriaVersionUID

        //Ahora quitamos el comentario de las 3 lineas que se encargan de enviar el objeto, y nos volvemos
        //a poner en la piel del EMISOR y borramos el empleado.dat de la carpeta para repetir el proceso desde
        //el principio.

        //Somos el EMISOR , pero el emisor antes de enviar este objeto va a modificar algo en el programa
        //por ejemplo en Empleado cambiamos la variable salaire à salaires con "s" es un pequenio cambio.
        //ahora repetimos el proceso y enviamos el archivo y leemos. toodo ok

        //Sin embargo ahora nos vamos a poner en la piel del receptor que el no ha cmabiado la variable
        //salaire à salaires (es decir que el no ha recibido la actualizacion del programa)

        //comentamos de nuevo las 3 primeras lineas, y ejecutamos el programa pa leer el objeto como si lo acabaramos
        //de recibir. Damos a play y vemos que no funciona

        /*ME DA UN ERROR :

        local class incompatible: stream classdesc serialVersionUID = -2305366018050777225,
                                        local class serialVersionUID = 2255412720280589731

        El receptor tiene una version del programa antigua, contrariamente al emisor que cambio algo
        esto pasa cuando se cambia una variable o un metodo etc
        */

        //**************************************************************************************************************
        //                                       SOLUTION
        //**************************************************************************************************************
        /*
         ---------------                                                   ---------------
         |             |                                                   |              |
         |             |                                                   |              |
         |  PROGRAMA   |                                                   |   PROGRAMA   |
         |             |                                                   |              |
         |             |                                                   |              |
         --------------                                                    ----------------
                                             INTERNET

         serialVersionUID.                                                  serialVersionUID.
             Mi PC                                                              OTRA PC

             La solucion para por declarar nosotros en nuestro programa nuestro propio "serialVersioUID"
             No dejar que el compilador JAVA genere automaticamente ese serialVersionUID y generarlo nosotros
             de forma MANUAL.
        */
        //**************************************************************************************************************
        //                                        COMO HACERLO?
        //**************************************************************************************************************
        /*
        Creando una CONSTANTE estatica encapsulada

        private static final long serialVersionUID = 1L;     //con L porque es long
                                                             //pa no complicarnos ponemos 1

        si cambiamos de version pues lo ponemos en 2
        si volvemos a cambiar pues lo ponemos en 3
        */
        //**************************************************************************************************************
        //                                       ESTO QUE IMPLICA?
        //**************************************************************************************************************
        /*
        Que si el programa del receptor como el programa del emisor tienen declararo en cualquier punto del codigo
        esta constante de clase serialVersionUID   ....da igual que el programa del emisor cambie y se actualize
        y no se haya informado de esa actualizacion al receptor ya que la huella no sera generada automaticamente por el
        compilador de JAVA y NO CAMBIA al modificar algo en el programa sino que la huella sigue siendo la misma para
        ambas partes.

        Tanto para el programa del emisor como para el programa del receptor y asi a pesar del cambio pues se pueda
        serializar un objeto y enviarlo por la red y que el receptor pueda leerlo .

        asi si yo he modificado una variable o algo y envio luego un objeto el recibira la nueva version y se le actualizara
        automaticamente. ya que el objeto que enviamos es de tipo Empleado, y los cambios efectuados fueron en una
        variable de tipo Empleado (creo)

        cuando creamos una clase que implemente la interface Serializable, o que creemos una clase que hereda de otra
        que la implementa ( como Administrador) Eclipse lanza el warning (idea no)

        esto es para decirnos si queremos crear esta constante serialVersionUID nosotros

       si lo hacemos debemos hacerlo en la clase que implemnta Serializable (Empleado)  y tambien en la clase que hereda
       de Empleado (Administrador)

       se puede hacer manualmente o decirle a eclipse que lo haga de manera automatica poniendo la huella que el mismo
       creo como constante!  una seria de 20 bytes

       ya habiendo hecho esto , lo que significa es que vamos a poder serializar objetos, vamos a poder guardas cambios
       y a pesar de los cambios que vamos a hacer, el objeto podra ser leido

        */
    }
}
