package i_poo.u_Streams_secuencias_flujos_de_datos.d_java.nio2;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

/*La gestion de la mémoire par la JVM, notamment grâce au garbage collector, a grandement amélioré la productivité
    des développeurs et la fiabilité des applications. Cependant le ramasse-miettes n'est pas capable de faire seul
    la libération des ressources notamment dans le cas de ressources natives fournies par le système d'exploitation
    sous-jacent de la JVM. Ce type de ressources doit être libéré explicitement par le développeur qui doit invoquer
    la méthode adéquate généralement dans un bloc try/finally.*/
public class V_Gestion_des_erreurs_et_liberation_ressources_IV {
  public V_Gestion_des_erreurs_et_liberation_ressources_IV() {//constructor
  }
  public static void main(String[] args) {
    InputStream file = null;
    try {
      file = new FileInputStream(new File("test.bin"));
      byte fileContent[] = new byte[(int) file.available()];
      file.read(fileContent);
    } catch (IOException ioe) {
      ioe.printStackTrace();
    } finally {
      try {
        file.close();
      } catch (IOException ioe) {
      // traitement de l'exception au besoin
      }
    }
  }
}
/*
  L'invocation de la méthode close() dans la clause finally doit être faite dans un bloc try/catch car elle peut lever
  une exception de type IOException.

  Il est possible de déclarer plusieurs ressources dans un bloc try : leurs méthodes close() seront toutes invoquées
  même si une de ces invocations lève une exception durant sont exécution.

  Si une exception de type IOException est levée dans les traitements du bloc try et une autre dans le bloc finally
  générée par le compilateur pour fermer les ressources, c'est toujours l'exception du bloc try qui sera propagée.

  Il est possible d'avoir des informations sur l'exception masquée en utilisant la méthode getSuppressed() de la classe
  Throwable.

  Il n'est généralement pas pratique d'utiliser en même temps les instructions catch et finally avec l'instruction try.
  Il est préférable d'utiliser simplement un bloc finally avec le try et de laisser la gestion des exceptions à un
  niveau supérieur.

  public void maMethode() throws IOException {

                                 try {
                                    // ...
                                 } finally {
                                    // ...
                                 }
  }

*/
