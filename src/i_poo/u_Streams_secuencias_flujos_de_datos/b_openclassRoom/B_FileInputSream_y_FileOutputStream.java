package i_poo.u_Streams_secuencias_flujos_de_datos.b_openclassRoom;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class B_FileInputSream_y_FileOutputStream {
    public static void main(String[] args) {
        //Les objets FileInputStream et FileOutputStream
        //lire dans un fichier ;
        //
        //écrire dans un fichier.
        //Ces classes héritent des classes abstraites InputStream et OutputStream, présentes dans le packagejava.io.
        /*
        Nous allons enfin commencer à travailler avec notre fichier. Le but est d'aller en lire le contenu et
        de le copier dans un autre, dont nous spécifierons le nom dans notre programme, par le biais d'un programme Java.

        metodos read
        ------------
         int	             read()
                             Reads a byte of data from this input stream.

         int	             read(byte[] b)
                             Reads up to b.length bytes of data from this input stream into an array of bytes.

         int	             read(byte[] b, int off, int len)
                             Reads up to len bytes of data from this input stream into an array of bytes.



                             public int read(byte[] b)
                                          throws IOException
                              Reads up to b.length bytes of data from this input stream into an array of bytes.
                              This method blocks until some input is available.

                              Esete metodo funciona como un buffer, es decir que lee el numero de bytes
                              que el byte tab [] tenga , es decir su length
        */


        //declaration des objets en dehors du bloc try/catch
        FileInputStream fis = null;
        FileOutputStream fos = null;

        try {
            // On instancie nos objets :
            // fis va lire le fichier
            // fos va écrire dans le nouveau !    "C:/Users/Jorge/Desktop/Test/plano.jpg"
            fis = new FileInputStream("C:/Users/Jorge/Desktop/fotito.jpg");//busco donde esta
            fos = new FileOutputStream("C:/Users/Jorge/Desktop/test/fotito.jpg");//lo pongo en otro directorio

            // On crée un tableau de byte pour indiquer le nombre de bytes lus à chaque tour de boucle
            byte[] buf = new byte[8];
            // On crée une variable de type int pour y affecter le résultat de la lecture ,Vaut -1 quand c'est fini
            //en vez de int n=0 y luego  (n=fis.read(buf))>=0    podemos solamente
            while ((fis.read(buf)) >= 0) {//read normalmente lee cada byte le voy a decir que lea un tab de int d 8 en 8
                // On écrit dans notre deuxième fichier avec l'objet adéquat
                fos.write(buf);
                // On affiche ce qu'a lu notre boucle au format byte et au format char
                for (byte bit : buf) {
                    System.out.print("\t" + bit + "(" + (char) bit + ")");
                }
                System.out.println();
                //Nous réinitialisons le buffer à vide au cas où les derniers byte lus ne soient pas un multiple de 8
                //Ceci permet d'avoir un buffer vierge à chaque lecture et ne pas avoir de doublon en fin de fichier
                buf = new byte[8];
            }
            System.out.println("Copie terminée !");
        } catch (IOException e) {//2 tipos de exceptions que pueden surgir
            // Cette exception est levée si l'objet FileInputStream ne trouve aucun fichier
            e.printStackTrace();
        }// Celle-ci se produit lors d'une erreur d'écriture ou de lecture
        finally {
            // On ferme nos flux de données dans un bloc finally pour s'assurer que ces instructions seront exécutées
            // dans tous les cas même si une exception est levée !
            try {
                if (fis != null)//quiere decir que el fichier existe y lo cierra sino no porque simplemente nunca se abrio
                    fis.close();//ya que no existia
            } catch (IOException e) {// si no existe hay una exception
                e.printStackTrace();
            }
            try {
                if (fos != null)//quiere decir que el fichier existe
                    fos.close();
            } catch (IOException e) {// si no existe hay una exception
                e.printStackTrace();
            }
        }
        /*
        Pour que l'objetFileInputStream fonctionne, le fichier doit exister ! Sinon l'exception FileNotFoundException est
        levée. Par contre, si vous ouvrez un flux en écriture (FileOutputStream) vers un fichier inexistant,
        celui-ci sera créé automatiquement !

        Le bloc finally permet de s'assurer que nos objets ont bien fermé leurs liens avec leurs fichiers respectifs,
        ceci afin de permette à Java de détruire ces objets pour ainsi libérer un peu de mémoire à votre ordinateur.
        */
    }
}
