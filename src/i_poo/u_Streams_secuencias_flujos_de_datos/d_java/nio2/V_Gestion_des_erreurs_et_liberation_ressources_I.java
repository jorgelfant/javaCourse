package i_poo.u_Streams_secuencias_flujos_de_datos.d_java.nio2;

import java.io.IOException;

public class V_Gestion_des_erreurs_et_liberation_ressources_I {
  public static void main(String[] args) throws IOException {
    //******************************************************************************************************************
    //                          La gestion des erreurs et la libération des ressources
    //******************************************************************************************************************
    /*
    Lors d'opérations d'entrées-sorties de nombreuses erreurs inattendues peuvent survenir, par exemple un fichier
    qui n'existe pas, un manque de droit d'accès, une erreur de lecture, ...

    Toutes ces erreurs sont encapsulées dans une exception de type IOException ou d'un de ses sous-types. Toutes
    les méthodes qui réalisent des opérations d'entrées-sorties peuvent lever ces exceptions.

    Avant Java 7, les opérations de type I/O devaient être utilisées dans un bloc try et les exceptions pouvant
    être levées, traitées dans des blocs catch. La fermeture des flux devait être assurée dans un bloc finally pour
    garantir son exécution dans tous les cas.
    */
  /*
                      Charset charset = Charset.forName("UTF-8");
                      String contenu = "Bonjour";
                      BufferedWriter writer = null;
                      try {
                        writer = Files.newBufferedWriter(file, charset);
                        writer.write(contenu, 0, contenu.length());
                      } catch (IOException ioe) {
                        ioe.printStackTrace();
                      } finally {
                        if (writer != null) {
                          writer.close();
                        }
                      }
*/
  }
}
