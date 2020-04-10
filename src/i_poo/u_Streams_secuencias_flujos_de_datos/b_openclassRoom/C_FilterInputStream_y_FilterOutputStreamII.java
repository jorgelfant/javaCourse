package i_poo.u_Streams_secuencias_flujos_de_datos.b_openclassRoom;

import java.io.*;

public class C_FilterInputStream_y_FilterOutputStreamII {
    public static void main(String[] args) {
         /*
        La différence de temps est vraiment énorme : 1,578 seconde pour la première méthode et 0,094 seconde
        pour la deuxième ! Vous conviendrez que l'utilisation d'un buffer permet une nette amélioration des
        performances de votre code. Faisons donc sans plus tarder le test avec l’écriture :
        */
        //Nous déclarons nos objets en dehors du bloc try/catch
        FileInputStream fis;
        FileOutputStream fos;
        BufferedInputStream bis;
        BufferedOutputStream bos;

        try {
            fis = new FileInputStream(new File("C:/Users/Jorge/Desktop/dictionnaire.txt"));
            fos = new FileOutputStream(new File("C:/Users/Jorge/Desktop/test/dictionnaire_nuevo.txt"));

            bis = new BufferedInputStream(new FileInputStream(new File("C:/Users/Jorge/Desktop/dictionnaire.txt")));
            bos = new BufferedOutputStream(new FileOutputStream(new File("C:/Users/Jorge/Desktop/test/dictionnaire_new.txt")));
            //int tamanio = fis.available();//nos da el tamanio , es decir el numero de bytes que componen el file
            //byte[] buf = new byte[tamanio];//el bon plan es poner la talla real aqui y no solo la de 8 que es ocurrida byte[] buf = new byte[8]
                                           //esto agiliza muchisimo y la impresion se hace casi al instante
            byte[] buf = new byte[8];
            //On récupère le temps du système
            long startTime = System.currentTimeMillis();

            while ((fis.read(buf)) != -1) {
                fos.write(buf);
            }
            //On affiche le temps d'exécution
            System.out.println("Temps de lecture + écriture avec FileInputStream et FileOutputStream : " + (System.currentTimeMillis() - startTime));

            //On réinitialise
            startTime = System.currentTimeMillis();

            while ((bis.read(buf)) != -1) {
                bos.write(buf);
            }
            //On réaffiche
            System.out.println("Temps de lecture + écriture avec BufferedInputStream et BufferedOutputStream : " + (System.currentTimeMillis() - startTime));

            //On ferme nos flux de données
            fis.close();
            bis.close();
            fos.close();
            bos.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        /*
        Là, la différence est encore plus nette, comme le montre la figure suivante.
          Temps de lecture + écriture avec FileInputStream et FileOutputStream : 2491
          Temps de lecture + écriture avec BufferedInputStream et BufferedOutputStream : 24

          SUPER UTIL DE USAR BufferInputStream
          -------------------------------------------------------------------------------------
          Si hiciera como en el ejemplo en el que se hacia asi
            int m ;
            long startTime = System.currentTimeMillis();

            while ((m = fis.read()) != -1) {
                fos.write(m);
            }
            //On affiche le temps d'exécution
            System.out.println("Temps de lecture + écriture avec FileInputStream et FileOutputStream : " + (System.currentTimeMillis() - startTime));

            //On réinitialise
            int n ;
            startTime = System.currentTimeMillis();

            while ((n = bis.read()) != -1) {
                bos.write(n);
            }

            Vemos que el tiempo que se demora copiando es mucho mayor para el primer FileInputStream FileOutputStream
            ya que escribe uno por uno.

          Temps de lecture + écriture avec FileInputStream et FileOutputStream : 19827
          Temps de lecture + écriture avec BufferedInputStream et BufferedOutputStream : 94

          esto porque no usamos el byte[] buf = new byte[8]; en parametro

            while ((fis.read(buf)) != -1) {
                fos.write(buf);
            }
        */


    }
}
