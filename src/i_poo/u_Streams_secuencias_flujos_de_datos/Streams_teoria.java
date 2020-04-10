package i_poo.u_Streams_secuencias_flujos_de_datos;

public class Streams_teoria {
    public static void main(String[] args) {
        //Streams_teoria(SECUENCIAS)   o flujos de datos
        /*
        Sirven para diferentes propositos, como por ejemplo enviar informacion desde un programa java
        a un sitio remoto a traves de la red. Para esto usaremos secuencias o streams .

        Tambien se utiliza para acceder a ficheros externos, para poder leer informacion que haya en un dossier
        dentro de nuestro pc o para poder escribir en un dossier que pudieramos tener en nuestro ordenador.

        Porque surge la necesidad en un programa java de usar archivos externos?

        Lo que hemos hecho hasta ahora en nuestros programas java es almacenar la informacion en variables, Arrays ,
        en objetos. Y esta informacion que guardamos es temporal. Ya que lo que estamos haciendo es guardar esta
        informacion en la MEMORIA RAM de la pc que es una memoria volatil. Y esto se elimina al terminar el programa
        su ejecucion o al apagar el pc.

        Y claro a la hora de crear aplicaciones JAVA muchas veces surge la necesidad de almacenar la informacion
        no de forma temporal sino de forma permanente para que en un futuro podamos acceder a esa informacion.

        O enviar una informacion a traves de la red.

        Si queremos almanecar la informacion de manera permanente en vez de almacenar la informacion en la ram del equipo
        necesitaremos almacenar la informacion en un dispositivo fisico:

        --------------------
        |       RAM        |
        --------------------
                 ^
                 |
                 |
             ----------                                          -----------
             | codigo |                            USB <-------  |  codigo |  ----->  CD
             |        |                                          |         |
             |        |                                          |         |
             |        |                       DISQUETTE <------- |         |  ----->DISCO DURO
             ----------                                          -----------

         Asi para efecturar este tipo de operacion necesitamos manejar STREAMS (secuencias o flujos de datos )
         Asi si en un futuro necesitamos acceder a esta informacion nuevamente, como fue guardada en uno de estos
         dispositivos, la informacion sera accesible a traves de un dossier que podra ser de diferentes tipos.

         Como abordamos a la hora de programar en JAVA estos Streams_teoria, estas secuencias (flujos de datos) ?

         //*************************************************************************************************************
         //                              FORMAS DE ABORDAR LOS STREAMS
         //*************************************************************************************************************
         Se pueden abordar de 2 formas: como

         FLUJOS DE BYTES                          y como                     FLUJOS DE CARACTERES

         ---------------                                                       ---------------
         | 1010101010  |                                                       |  fghfghfg    |
         | 1010101010  |                                                       |  gfhgfhfg    |
         | 1010101010  |                                                       |  trytryrt    |
         | 1010101010  |                                                       |  gfhgfhgfh   |
         |             |                                                       |              |
         --------------                                                        ----------------

         Es decir que a la hora de acceder a un archivo donde pueda haber informacion o donde queramos escribir
         informacion lo podemos haces utilizando bytes o utilizando caracteres(letras).

         CUANDO UTILIZAREMOS UNA FORMA O LA OTRA?   Dependera de lo que querramos hacer
         A veces es mas comodo con una forma y otras veces es mas comodo la otra .

         si queremos almacenar informacion que vamos a leer (documento de texto una carta ) usaremos
         Streams_teoria de caracteres (FLUJOS O SECUENCIAS DE CARACTERES) de tal forma que abriremos el fichero
         con el lector correspondiente y podremos leer la informacion

         PERO por ejemplo si queremos enviar una informacion que genera un programa de java, a un sitio remoto
         es mas comodo hacerlo con un FLUJO DE BYTES , ya que no necesitamos LEER  esa informacion, solamente
         necesitamos enviarla , y para enviar informacion normalement es mas comodo hacerlo con un flujo de bytes
         y no como un flujo de caracteres

         Dans un premier TEMPS, vamos a abordar la forma de acceder a la informacion como flujo de caracteres
         y en un futuro en el curso veremos como trabajar con Stream o flujos de Bytes.

         si fueramos a hacerlo como FLUJO DE BYTES pues utilizariamos principalmente 2 clases de la API de JAVA


                  FLUJOS DE BYTES                                            FLUJOS DE BYTES

                   ---------------                                         ---------------
                   | 1010101010  |   <--Secuencia                          |  1010101010  |
                   | 1010101010  |         de                              |  1010101010  |
                   | 1010101010  |       Entrada                           |  1010101010  |
                   | 1010101010  |                                         |  1010101010  |
                   |             |                   Secuencia  ------->   |              |
                   --------------                        de                ----------------
                                                      Salida
    LA clase:      InputStream                                               OutputStream

    Estas 2 clases son abstractas , todas las clases que hacen referencia al acceso de informacion, a secuencias
    a STREAMS de datos, son clases que pertenecen al paquete Java.io

    InputStream    ---> Para cuando querramos ver la informacion almacenada en un archivo

    OutputStream    ---> Para cuando querramos escribir la informacion en bytes en un archivo o fichero

    sin embargo si queremos hacerlo con Stream o secuencia de caracteres usaremos las clases abstractas
    Reader y Writer:


         ---------------                                                       ---------------
         | fghfghfg    |   <--Secuencia                                        |  fghfghfg    |
         | fghfghfg    |          de                                           |  gfhgfhfg    |
         | fghfghfg    |       Entrada                                         |  trytryrt    |
         | fghfghfg    |                                   Secuencia  -------> |  gfhgfhgfh   |
         |             |                                       de              |              |
         --------------                                       Salida           ----------------

            Reader                                                                  Writer

    que tambien pertenecen al paquete Java.io
    todas estas clases tanto si es para trabajar con secuencias de caracteres como secuencias de Bytes tienen
    un ECOSISTEMA muy amplio de clases que heredan de ellas . Hay que verificar en la api de java toodo lo que
    se puede hacer con estas clases.

    Comenzaremos por ver como acceder a la informacion almacenada en un FICHERO DE TEXTO usando Streams_teoria de caracteres
    Es decir, que usaremos Reader y Writer, si no estas clases directamente, si otras clases que heredan de ellas.

    Haremos un ejemplo de fichero desde el cual podamos leer la informacion almacenada en el fichero desde nuestro programa
    java

    Creamos un nuevo dossier acceso_fichero con 2 clases un main y una clase pa acceder al fichero  "LeerEscribirFichero"
    Lo primero es decirle a JAVA donde se encuentra nuestro fichero


         ---------------                                                   ---------------
         |             |                   STREAM                          |  fghfghfg    |
         |             | ------------------------------------------------  |  gfhgfhfg    |
         |    CODIGO   | ------------------------------------------------  |  trytryrt    |
         |             |                  PA escribir o leer               |  gfhgfhgfh   |
         |             |                  informacion en un archivo        |              |
         --------------                   de texto                         ----------------













        */
    }
}
