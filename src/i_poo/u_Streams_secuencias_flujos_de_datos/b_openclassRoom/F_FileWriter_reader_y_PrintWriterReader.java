package i_poo.u_Streams_secuencias_flujos_de_datos.b_openclassRoom;

import java.io.*;

public class F_FileWriter_reader_y_PrintWriterReader {
    public static void main(String[] args) {
        /*
        Comme nous l'avons vu, les objets travaillant avec des flux utilisent des flux binaires.
        La conséquence est que même si vous ne mettez que des caractères dans un fichier et que vous le sauvegardez,
        les objets étudiés précédemment traiteront votre fichier de la même façon que s’il contenait des données binaires !
        Ces deux objets, présents dans le packagejava.io, servent à lire et écrire des données dans un fichier texte.
        */
        File file = new File("testFileWriter.txt");
        FileWriter fw;
        FileReader fr;

        try {
            //Création de l'objet
            fw = new FileWriter(file);
            String str = "Bonjour à tous, amis Zéros !\n";
            str += "\tComment allez-vous ? \n";
            //On écrit la chaîne
            fw.write(str);
            //On ferme le flux
            fw.close();

            //Création de l'objet de lecture
            fr = new FileReader(file);
            str = "";
            int i = 0;
            //Lecture des données
            while((i = fr.read()) != -1)
                str += (char)i;

            //Affichage
            System.out.println(str);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        /*
        Vous pouvez voir que l'affichage est bon et qu'un nouveau fichier (la lecture d'un fichier inexistant entraîne
        l’exceptionFileNotFoundException, et l'écriture peut entraîner uneIOException) vient de faire son apparition
        dans le dossier contenant votre projet Eclipse !

        Depuis le JDK 1.4, un nouveau package a vu le jour, visant à améliorer les performances des flux, buffers, etc.
        traités parjava.io. En effet, vous ignorez probablement que le package que nous explorons depuis le début existe
        depuis la version 1.1 du JDK. Il était temps d'avoir une remise à niveau afin d'améliorer les résultats obtenus
        avec les objets traitant les flux. C'est là que le packagejava.nioa vu le jour !
        */
    }
}
