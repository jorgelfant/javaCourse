package i_poo.u_Streams_secuencias_flujos_de_datos.b_openclassRoom;

//Packages à importer afin d'utiliser l'objet File

import java.io.*;

public class E_Objects_CharArraywriter_reader_y_StringWriter_reader {
    public static void main(String[] args) {
        // Les objets CharArray(Writer/Reader) et String(Writer/Reader)

        // Nous allons utiliser des objets :
        /*
          .CharArray(Writer/Reader);

          .String(Writer/Reader).

          Ces deux types jouent quasiment le même rôle. De plus, ils ont les mêmes méthodes que leur classe mère.
          Ces deux objets n'ajoutent donc aucune nouvelle fonctionnalité à leur objet mère.

          public class CharArrayReader
               extends Reader
               This class implements a character buffer that can be used as a character-input stream.

          public class StringReader
                 extends Reader
                 A character stream whose source is a string.

          Leur principale fonction est de permettre d'écrire un flux de caractères dans un buffer adaptatif :
          un emplacement en mémoire qui peut changer de taille selon les besoins (nous n'en avons pas parlé dans
          le chapitre précédent afin de ne pas l'alourdir, mais il existe des classes remplissant le même rôle que
          ces classes-ci :

          ByteArray(Input/Output)Stream).


          Commençons par un exemple commenté des objets CharArray(Writer/Reader):
        */
        CharArrayWriter caw = new CharArrayWriter();
        CharArrayReader car;

        try {
            caw.write("Coucou les Zéros");
            //Appel à la méthode toString de notre objet de manière tacite
            System.out.println(caw);

            //caw.close() n'a aucun effet sur le flux
            //Seul caw.reset() peut tout effacer
            caw.close();

            //On passe un tableau de caractères à l'objet qui va lire le tampon
            car = new CharArrayReader(caw.toCharArray());
            int i;
            //On remet tous les caractères lus dans un String
            String str = "";
            while ((i = car.read()) != -1) {//cada caracter es un byte
                str += (char) i;//va completando el String caracter a caracter
            }
            System.out.println(str);

        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println();
        /*
        Je vous laisse le soin d'examiner ce code ainsi que son effet. Il est assez commenté pour que
        vous en compreniez toutes les subtilités. L'objet String(Writer/Reader)fonctionne de la même façon :
        */
        StringWriter sw = new StringWriter();
        StringReader sr;

        try {
            sw.write("Coucou les Zéros");
            //Appel à la méthode toString de notre objet de manière tacite
            System.out.println(sw);

            //caw.close() n'a aucun effet sur le flux
            //Seul caw.reset() peut tout effacer
            sw.close();

            //On passe un tableau de caractères à l'objet qui va lire le tampon
            sr = new StringReader(sw.toString());//cuando se trata d eun String to String regresa el string, ejemplo "hola"
            int i;
            //On remet tous les caractères lus dans un String
            String str = "";
            while ((i = sr.read()) != -1) {
                str += (char) i;
            }
            System.out.println(str);

        } catch (IOException e) {
            e.printStackTrace();
        }
        /*
        En fait, il s'agit du même code, mais avec des objets différents ! Vous savez à présent comment écrire un flux
        de texte dans un tampon de mémoire. Je vous propose maintenant de voir comment traiter les fichiers de texte
        avec des flux de caractères.
        */

    }
}
