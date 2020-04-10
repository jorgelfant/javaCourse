package i_poo.u_Streams_secuencias_flujos_de_datos.a_pildoras.acceso_ficheros_III_ManenoArchivos_Byte;

public class AccesoFichero {
    public static void main(String[] args) {
        //MANEJO DE ARCHIVOS    Streams Byte

        /*
         Los Stream Byte nos permiten no solo manejar archivos de TEXTO sino tb cualquien OTRO TIPO DE ARCHIVOS .

         Utilidad:
         ---------                                                         -----
                                                                           |   VLC media player
         ---------------                                                   |
         |             |                   STREAM BYTE                     |   WORD
         |             | ------------------------------------------------  |
         |    CODIGO   |          Enteros entre 0 y 255                    |  EXCELL
         |             | ------------------------------------------------  |
         |             |   65  125  45  225  185  195 215  45  10  250     |   PDF
         --------------                                                    |
                                                                           | POWER POINT
                                                                           |
                                                                           |
                                                                           -----
        Se convierte en una poderosa herramienta para enviar y recibir cualquier tipo de informacion o archivos
        desde un programa JAVA.

        En informatica cualquier tipo de archivo es susceptible de CONVERTIRSE EN UNA SUCCESION DE Bytes
        archivos de video, texto, PDF, archivos de audio, etc cualquier cosa.

        esto nos permite que si lo convertimos en Bytes pues recibir informacion de cualquier tipo de archivos
        en nuestro programa JAVA o al reves enviar hacia el exterior informacion de cualquier tipo de archivo
        que podamos tener guardado en nuestra pc.
//**********************************************************************************************************************
//Para poder manipular Streams Bytes en JAVA necesitamos conocer 2 CLASS:  las 2 heredan de :
//**********************************************************************************************************************
       "InputStream" que es Abstract                             "InputStream" que es Abstract

                       C                                                         C
        FileInputStream                                          FileOutputStream
               |                                                        |
               |                                                        |
             read()                                                  write()

             close()                                                  close()                                          */

        //1er Ejemplo leer un archivo cualquiera como por ejemplo una imagen

        /*
        constructores de

        Constructor and Description
         FileInputStream(File file)
              Creates a FileInputStream by opening a connection to an actual file, the file named by
              the File object file in the file system.
         FileInputStream(FileDescriptor fdObj)
              Creates a FileInputStream by using the file descriptor fdObj, which represents an existing
              connection to an actual file in the file system.
         FileInputStream(String name)
              Creates a FileInputStream by opening a connection to an actual file, the file named
              by the path name name in the file system.
        */
       /*
        try {
            FileInputStream lectura = new FileInputStream("C:/Users/Jorge/Desktop/Test/plano.jpg");
            int archivo = lectura.read();
            System.out.println(archivo);
        } catch (IOException e) {
            System.out.println("No se encontro la imagen");
            //e.printStackTrace();
        }
    }*/
        LeerEscribirFichero lectura = new LeerEscribirFichero();
        lectura.lee();//hay muchisimos de bytes que forman parte la imagen, la consola de idea o eclipse
                      //no es capaza de reprensetar miles y miles de bytes, tiene limites (muchas lineas si pero hay un limite)
        //Es decir que los bytes que estamos viendo no son todos los bytes que forman parte de la imagen sino parte de
        //ellos lo que si es que imprime el ultima que seria 217

        lectura.escribe();//va a copiar los bytes almacenados en el fichier es decir va a hacer una copia con otro nombre
        //en el mismo fichero


       //Con este codigo hariamos lo mismo
       // LeerEscribirFichero hola=new LeerEscribirFichero();
       // hola.leeEscribe();


    }
}