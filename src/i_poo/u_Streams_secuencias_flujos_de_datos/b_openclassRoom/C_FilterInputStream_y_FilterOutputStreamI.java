package i_poo.u_Streams_secuencias_flujos_de_datos.b_openclassRoom;

//Packages à importer afin d'utiliser l'objet File

import java.io.*;

public class C_FilterInputStream_y_FilterOutputStreamI {
    public static void main(String[] args) {
        /*
        Il existe à présent des objets beaucoup plus faciles à utiliser, mais qui travaillent néanmoins
        avec les deux objets que nous venons d'étudier. Ces objets font également partie de la hiérarchie
        citée précédemment. Seulement, il existe une superclasse qui les définit.

        Les objets FilterInputStream et FilterOutputStream

                    InputStream                                                OutputStream
                        ^                                                            ^
                        |                                                            |
  FileInputStream--------------FilterInputStream                FileOutputStream--------------FilterOutputStream
                                       ^                                                               ^
                                       |                                                               |
                 BufferedInputStream---|----LineNumberInputStream                BufferedOutputStram---|--LineNumberOutputStream
                                       |                                                               |
                                       |                                                               |
                                       |                                                               |
                     DataInputStream------PushbackInputStream                       DataOutputStream-------PushbackOutputStream


                                             Hiérarchie des classes du package java.io

        Vous pouvez voir qu'il existe quatre classes filles héritant deFilterInputStream
        (de même pour FilterOutputStream(les classes dérivant de FilterOutputStream ont les mêmes fonctionnalités, mais en écriture)):

        DataInputStream: offre la possibilité de lire directement des types primitifs (double,char,int)
        grâce à des méthodes comme readDouble(),readInt()…

        BufferedInputStream: cette classe permet d'avoir un tampon à disposition dans la lecture du flux.
        En gros, les données vont tout d'abord remplir le tampon, et dès que celui-ci est plein, le programme
        accède aux données.

        PushbackInputStream: permet de remettre un octet déjà lu dans le flux entrant.

        LineNumberInputStream: cette classe offre la possibilité de récupérer le numéro de la ligne lue à un instant T.
           (DEPRECATED)
       -----------------------------------------------------------------------------------------------------------------

        Ces classes prennent en paramètre une instance dérivant des classes InputStream(pour les classes
        héritant de FilterInputStream) ou de OutputStream(pour les classes héritant deFilterOutputStream).

        Puisque ces classes acceptent une instance de leur superclasse en paramètre, vous pouvez cumuler les
        filtres et obtenir des choses de ce genre :
        */
        /*
        FileInputStream fis = new FileInputStream(new File("toto.txt"));
        DataInputStream dis = new DataInputStream(fis);
        BufferedInputStream bis = new BufferedInputStream(dis);
        //Ou en condensé :
        BufferedInputStream bis = new BufferredInputStream(new DataInputStream(new FileInputStream(new File("toto.txt"))));
        */
        //**************************************************************************************************************
        //                                               COMPARACION
        //**************************************************************************************************************
        /*
        Afin de vous rendre compte des améliorations apportées par ces classes, nous allons lire un énorme fichier
        texte (3,6 Mo) de façon conventionnelle avec l'objet vu précédemment, puis grâce à un buffer.

        Récupérez le fichier compressé grâce à un logiciel de compression/décompression et remplacez le contenu de
        votre fichier test.txt par le contenu de ce fichier. Maintenant, voici un code qui permet de tester le temps
        d'exécution de la lecture :
        */

        //Nous déclarons nos objets en dehors du bloc try/catch
        FileInputStream fis;
        BufferedInputStream bis;
        try {
            fis = new FileInputStream(new File("C:/Users/Jorge/Desktop/dictionnaire.txt"));
            bis = new BufferedInputStream(new FileInputStream(new File("C:/Users/Jorge/Desktop/dictionnaire.txt")));
            byte[] buf = new byte[8];

            //On récupère le temps du système
            long startTime = System.currentTimeMillis();
            //Inutile d'effectuer des traitements dans notre boucle
            while (fis.read(buf) != -1) ;
            //On affiche le temps d'exécution
            System.out.println("Temps de lecture avec FileInputStream : " + (System.currentTimeMillis() - startTime));

            //On réinitialise
            startTime = System.currentTimeMillis();
            //Inutile d'effectuer des traitements dans notre boucle
            while (bis.read(buf) != -1) ;
            //On réaffiche
            System.out.println("Temps de lecture avec BufferedInputStream : " + (System.currentTimeMillis() - startTime));

            //On ferme nos flux de données
            fis.close();
            bis.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        /*Et le résultat, visible à la figure suivante, est encore une fois bluffant.

        Comparatif de lecture avec et sans filtre

          Temps de lecture avec FileInputStream : 917
          Temps de lecture avec BufferedInputStream : 14
        */

        /*
        La différence de temps est vraiment énorme : 1,578 seconde pour la première méthode et 0,094 seconde
        pour la deuxième ! Vous conviendrez que l'utilisation d'un buffer permet une nette amélioration des
        performances de votre code. Faisons donc sans plus tarder le test avec l’écriture : en el II
        */

    }
}
