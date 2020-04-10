package i_poo.u_Streams_secuencias_flujos_de_datos.d_java.nio2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class O_LECTURE_ECRITURE_BUFFER {
  public static void main(String[] args) {
    /*
    La lecture et l'écriture bufférisées d'un fichier
    ------------------------------------------------
    Avant Java 7, pour lire un fichier avec un tampon, il fallait invoquer le constructeur de la classe
    BufferedReader en lui passant en paramètre un objet de type Reader.

                BufferedReader in = new BufferedReader(new FileReader("monfichier.txt"));

    A partir de Java 7, il est possible d'utiliser la méthode newBufferedReader() de la classe Files.
    */
    /*
           try {
             BufferedReader in = Files.newBufferedReader(Paths.get("C:/Users/Jorge/Desktop/dictionnaire.txt"), Charset.forName("ISO-8859-1"));
           } catch (IOException e) {
             e.printStackTrace();
           }
    */
    /*
    Le résultat est quasiment le même mais il est nécessaire de préciser le jeu d'encodage des caractères.
    La classe FileReader utilise toujours le jeu par défaut du système. Même si ce n'est pas une bonne pratique,
    il est possible d'obtenir ce jeu d'encodage de caractères en invoquant la méthode

    java.nio.charset.Charset.defaultCharset().

    La méthode newBufferedReader() de la classe Files renvoie un objet de type BufferedReader qui permet de lire
    le fichier dont le chemin et le jeu de caractères d'encodage sont fournis en paramètres.
    */


    //******************************************************************************************************************
    //                                  newBufferedReader()
    //******************************************************************************************************************
    //La méthode newBufferedReader() ouvre un fichier de type texte pour des lectures avec un tampon.
    // Elle retourne un objet de type BufferedReader.

    Path fichier = Paths.get("C:/Users/Jorge/Desktop/test2/dictionnaire.txt");
    Charset charset = Charset.forName("ISO_8859_1");
    try (BufferedReader reader = Files.newBufferedReader(fichier, charset)) {
      String line;
      while ((line = reader.readLine()) != null) {
        System.out.println(line);
      }
    } catch (IOException ioe) {
      ioe.printStackTrace();
    }
    //******************************************************************************************************************
    //                                         newBufferedWriter()
    //******************************************************************************************************************
    /*La méthode newBufferedWriter() ouvre un fichier de type texte pour des écritures avec un tampon.
    Elle retourne un objet de type BufferedWriter.*/

     /*La méthode write() de bufferdWriter et no de Files

      /*void	                                    write(String s, int off, int len)
                                                     Writes a portion of a String.

       void	                                      write(char[] cbuf, int off, int len)
                                                     Writes a portion of an array of characters.

       void	                                      write(int c)
                                                     Writes a single character.
                                                     */

    Path fichier2 = Paths.get("C:/Users/Jorge/Desktop/test2/nuevoTexto.txt");//si el texto no existe lo crea
    Charset charset2 = Charset.forName("ISO_8859_1");

    String contenu = "Contenu du fichier";//lo que vamos a escribir en el texto
    try (BufferedWriter writer = Files.newBufferedWriter(fichier2, charset2)) {
      writer.write(contenu, 0, contenu.length());//el 3er parametro es pa decir hasta FluentApiTest numero del length escribimos
    } catch (IOException ioe) {
      ioe.printStackTrace();
    }
  }

  //********************************************************************************************************************
  //                                           Metodo fuera del main
  //********************************************************************************************************************
  public static void testNewBufferedReader() throws IOException {
    Path sourcePath = Paths.get("C:/Users/Jorge/Desktop/test2/dictionnaire.txt");
    try (BufferedReader reader = Files.newBufferedReader(sourcePath, StandardCharsets.ISO_8859_1)) {

      String line;
      while ((line = reader.readLine()) != null) {
        System.out.println(line);
      }
    }
  }
}
