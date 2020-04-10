package i_poo.u_Streams_secuencias_flujos_de_datos.c_java.nio.Java;

//Packages à importer afin d'utiliser l'objet File

import java.io.*;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class A_nio {
    public static void main(String[] args) {
        //java.A_nio
        /*
        Vous l'avez sûrement deviné,A_nio signifie « New I/O ». Comme je vous l'ai dit précédemment, ce package a
        été créé afin d'améliorer les performances sur le traitement des fichiers, du réseau et des buffers.

        Il permet de lire les données (nous nous intéresserons uniquement à l'aspect fichier) d'une façon différente.
        Vous avez constaté que les objets du package java.io traitaient les données par octets. Les objets du
        packagejava.A_nio, eux, les traitent par blocs de données : la lecture est donc accélérée !

        Tout repose sur deux objets de ce nouveau package : les channels et les buffers. Les channels sont en fait
        des flux, tout comme dans l'ancien package, mais ils sont amenés à travailler avec un buffer dont vous
        définissez la taille. Pour simplifier au maximum, lorsque vous ouvrez un flux vers un fichier avec un
        objet FileInputStream, vous pouvez récupérer un canal vers ce fichier. Celui-ci, combiné à un buffer, vous
        permettra de lire votre fichier encore plus vite qu'avec un BufferedInputStream!

        Reprenez le gros fichier que je vous ai fait créer dans la sous-section précédente : nous allons maintenant
        le relire avec ce nouveau package en comparant le buffer conventionnel et la nouvelle façon de faire.

         java.A_nio
         java.A_nio.channels
         java.A_nio.channels.spi
         java.A_nio.charset
         java.A_nio.charset.spi
         java.A_nio.file
         java.A_nio.file.attribute
         java.A_nio.file.spi

        Classes dand java.A_nio:
        ----------------------
          Buffer               public abstract class Buffer extends Object
          ByteBuffer           public abstract class ByteBuffer extends Buffer,implements Comparable<ByteBuffer>
          ByteOrder            public final class ByteOrder extends Object
          CharBuffer           public abstract class CharBuffer extends Buffer implements Comparable<CharBuffer>, Appendable, CharSequence, Readable
          DoubleBuffer         public abstract class DoubleBuffer extends Buffer implements Comparable<DoubleBuffer>
          FloatBuffer          public abstract class FloatBuffer extends Buffer implements Comparable<FloatBuffer>
          IntBuffer            public abstract class IntBuffer extends Buffer implements Comparable<IntBuffer>
          LongBuffer           public abstract class LongBuffer extends Buffer implements Comparable<LongBuffer>
          MappedByteBuffer     public abstract class MappedByteBuffer extends ByteBuffer
          ShortBuffer          public abstract class ShortBuffer extends Buffer implements Comparable<ShortBuffer>

        Exceptions:
        ----------
          BufferOverflowException
          BufferUnderflowException
          InvalidMarkException
          ReadOnlyBufferException
        */
        FileInputStream fis;
        BufferedInputStream bis;
        FileChannel fc;

        try {
            //Création des objets
            fis = new FileInputStream(new File("C:/Users/Jorge/Desktop/dictionnaire.txt"));
            bis = new BufferedInputStream(fis);
            //Démarrage du chrono
            long time = System.currentTimeMillis();
            //Lecture
            while (bis.read() != -1) ;
            //Temps d'exécution
            System.out.println("Temps d'exécution avec un buffer conventionnel : " + (System.currentTimeMillis() - time));

            //Création d'un nouveau flux de fichier
            fis = new FileInputStream(new File("C:/Users/Jorge/Desktop/dictionnaire.txt"));
            //On récupère le canal
            fc = fis.getChannel();
            //On en déduit la taille
            int size = (int) fc.size();
            //On crée un buffer correspondant à la taille du fichier
            ByteBuffer bBuff = ByteBuffer.allocate(size); //ByteBuffer es parte de java.A_nio y es clase abstracta
            //Démarrage du chrono
            time = System.currentTimeMillis();
            //Démarrage de la lecture
            fc.read(bBuff);
            //On prépare à la lecture avec l'appel à flip
            bBuff.flip();
            //Affichage du temps d'exécution
            System.out.println("Temps d'exécution avec un nouveau buffer : " + (System.currentTimeMillis() - time));

            //Puisque nous avons utilisé un buffer de byte afin de récupérer les données
            //Nous pouvons utiliser un tableau de byte
            //La méthode array retourne un tableau de byte
            byte[] tabByte = bBuff.array();

        } catch (IOException e) {
            e.printStackTrace();
        }
        /*RESULTADO

          Temps d'exécution avec un buffer conventionnel : 72
          Temps d'exécution avec un nouveau buffer : 4

          Vous constatez que les gains en performance ne sont pas négligeables. Sachez aussi que ce nouveau package
          est le plus souvent utilisé pour traiter les flux circulant sur les réseaux. Je ne m'attarderai pas sur le
          sujet, mais une petite présentation est de mise. Ce package offre un buffer par type primitif pour la lecture
          sur le channel, vous trouverez donc ces classes :

            .IntBuffer;

            .CharBuffer;

            .ShortBuffer;

            .ByteBuffer;

            .DoubleBuffer;

            .FloatBuffer;

            .LongBuffer.

            Je ne l'ai pas fait durant tout le chapitre afin d'alléger un peu les codes, mais si vous voulez
            être sûrs que votre flux est bien fermé, utilisez la clause finally. Par exemple, faites comme ceci :
        */
        //Nous déclarons nos objets en dehors du bloc try / catch
        /*

                                  ObjectInputStream ois;
                                  ObjectOutputStream oos;

                                  try {
                                      //On travaille avec nos objets
                                  } catch (FileNotFoundException e) {
                                      //Gestion des exceptions
                                  } catch (IOException e) {
                                      //Gestion des exceptions
                                  }
                                  finally{
                                      if(ois != null)ois.close();
                                      if(oos != null)oos.close();
                                  }
        */

        /*
        Avec l'arrivée de Java 7, quelques nouveautés ont vu le jour pour la gestion des exceptions sur les flux.
        Contrairement à la gestion de la mémoire (vos variables, vos classes, etc.) qui est déléguée au garbage collector
        (ramasse miette), plusieurs types de ressources doivent être gérées manuellement.

        Les flux sur des fichiers en font parti mais, d'un point de vue plus général, toutes les ressources que vous
        devez fermer manuellement (les flux réseaux, les connexions à une base de données…). Pour ce genre de flux,
        vous avez vu qu'il vous faut déclarer une variable en dehors d'un bloctry{…}catch{…}afin qu'elle soit accessible
        dans les autres blocs d'instructions, le bloc finally par exemple.

        Java 7 initie ce qu'on appelle vulgairement le « try-with-resources ». Ceci vous permet de déclarer les
        ressources utilisées directement dans le bloc try(…), ces dernières seront automatiquement fermées à la fin du
        bloc d'instructions ! Ainsi, si nous reprenons notre code de début de chapitre qui copie notre fichier test.txt
        vers test2.txt, nous aurons ceci :
        */
        try (FileInputStream fus = new FileInputStream("C:/Users/Jorge/Desktop/dictionnaire.txt");
             FileOutputStream fos = new FileOutputStream("C:/Users/Jorge/Desktop/dictionnaire.txt")) {
            byte[] buf = new byte[8];

            while ((fus.read(buf)) >= 0) {
                fos.write(buf);
                for (byte bit : buf) {
                    System.out.print("\t" + bit + "(" + (char) bit + ")");
                }
                System.out.println();
            }
            System.out.println("Copie terminée !");
        } catch (IOException e) {
            e.printStackTrace();
        }
        //Notez bien que les différentes ressources utilisées sont séparées par un « ; » dans le bloctry!

        /*
        C'est tout de même beaucoup plus clair et plus lisible qu'avant, surtout que vous n'avez plus à vous
        soucier de la fermeture dans le bloc finally. Il faut cependant prendre quelques précautions notamment
        pour ce genre de déclaration :  hay un FileInputStream como parametro en el ObjectInputStream, que no se ve

                 try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("test.txt"))) {
                    //…
                  }

        Le fait d'avoir des ressources encapsulées dans d'autres ne rend pas « visible » les ressources encapsulées.
        Dans le cas précédent, si une exception est levée, le flux correspondant à l'objetFileInputStream ne sera pas fermé.
        Pour pallier ce problème il suffit de bien découper toutes les ressources à utiliser, comme ceci :

                 OSEA NO HACER EMBRICACION DENTRO DE LOS PARAMETROS, y DECLARARLOS DE MANERA INDEPENDIENTE

                 try (FileInputStream fis = new FileInputStream("test.txt");
                   ObjectInputStream ois = new ObjectInputStream(fis)) {
                     //…
                 }

       //***************************************************************************************************************
        Eh ! Avant tu utilisais l'objetFiledans l'instanciation de tes objetsFileInputStreametFileOutputStream!

        Rien ne vous échappe ! Si j'ai changé de façon de faire c'est parce qu'il y a une restriction sur ce mode de
        fonctionnement. Pour rendre la fermeture automatique possible, les développeurs de la plateforme Java 7 ont
        créé une nouvelle interface :java.lang.AutoCloseable.

        Seuls les objets implémentant cette interface peuvent être utilisés de la sorte ! Vous pouvez voir la liste
        des classes autorisées à cette adresse (et vous constaterez que la classeFilen'en fait pas parti).
      ***************************************************************************************************************

        */
    }
}
