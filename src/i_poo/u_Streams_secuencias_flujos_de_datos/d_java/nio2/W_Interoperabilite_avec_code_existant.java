package i_poo.u_Streams_secuencias_flujos_de_datos.d_java.nio2;

import java.io.IOException;

public class W_Interoperabilite_avec_code_existant {
  public static void main(String[] args) throws IOException {
    /*
    Les objets de type Path obtenus sur le système de fichiers par défaut sont interopérables avec des objets de type
    java.io.File. Les objets de type Path obtenus sur d'autres systèmes de fichiers peuvent ne pas être interopérables.

    Pour faciliter le portage de code utilisant l'API java.io vers NIO2, la classe java.io.File propose la méthode toPath()
    qui crée une instance de type Path à partir des informations encapsulées dans l'instance de type File.
    */

                         // Path input = file.toPath();

    //Il est ainsi facile de bénéficier des fonctionnalités offertes par NIO2 sans avoir à tout réécrire.

                        // file.delete();

    //Il est possible de réécrire cette portion de code en utilisant NIO2.

                       //Path fp = file.toPath();
                       //Files.delete(fp);

    /*
    Inversement, la classe Path propose la méthode toFile() permettant de créer une instance de la classe
    java.io.File qui correspond aux informations encapsulées dans l'instance de type Path.
    */

  }
}
