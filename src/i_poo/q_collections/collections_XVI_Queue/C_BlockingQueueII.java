package i_poo.q_collections.collections_XVI_Queue;

import java.util.Random;
import java.util.concurrent.SynchronousQueue;

public class C_BlockingQueueII {
    public static void main(String[] args) {
        /*
        4) SynchronousQueue<E>

        Cet objet a un fonctionnement bien particulier car il ne tolère un nouvel ajout que s'il y a une tentative
        de retrait de ce même élément... De ce fait, vous devriez en tirer une conclusion évidente : cet objet n'a
        une capacité que d'un seul élément.

        En partant de ce postulat, vous ne devriez donc pas être surpris des autres particularités de cet objet, à savoir :

            .la méthode peek() retourne systématiquement la valeur null ;

            .null n'est pas une valeur autorisée ;

            .la tête de la file correspond à l'élément qui est censé être inséré ;

            .cet objet est destiné aux transferts d'objets entre threads.

        Cet objet étant un peu spécial, je vous donne un code d'exemple :
        */

        SynchronousQueue<String> sq = new SynchronousQueue<String>();

        Producteur p = new Producteur(sq);
        Consommateur c = new Consommateur(sq);
        p.start();
        c.start();

    }
}
//**********************************************************************************************************************
//                                      CLASE EXTERIOR AL MAIN
//**********************************************************************************************************************

/**
 * Cette classe se charge de mettre des données dans la collection
 */
class Producteur extends Thread {
    private SynchronousQueue<String> queue;

    public Producteur(SynchronousQueue<String> q) {
        queue = q;
    }

    public void run() {
        Random rand = new Random();

        for (int i = 0; i < 5; i++) {
            String str = "N° " + rand.nextInt(100);
            try {
                queue.put(str);
                System.out.println("Ajout de l'élément " + str + " dans la collection OK");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
//**********************************************************************************************************************
//                                      CLASE EXTERIOR AL MAIN
//**********************************************************************************************************************

/**
 * Cette classe se charge de récupérer la donnée
 */
class Consommateur extends Thread {
    private SynchronousQueue<String> queue;

    public Consommateur(SynchronousQueue<String> q) {
        queue = q;
    }

    public void run() {
        for (int i = 0; i < 5; i++) {
            //On met une temporisation pour éviter les tours de boucle à vide
            try {
                this.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            String str = queue.poll();
            System.out.println("Elément " + str + " retiré de la collection");
        }
    }
    /*IMPRIME
       Elément N° 37 retiré de la collection
       Ajout de l'élément N° 37 dans la collection OK
       Elément N° 99 retiré de la collection
       Ajout de l'élément N° 99 dans la collection OK
       Elément N° 21 retiré de la collection
       Ajout de l'élément N° 21 dans la collection OK
       Ajout de l'élément N° 33 dans la collection OK
       Elément N° 33 retiré de la collection
       Ajout de l'élément N° 8 dans la collection OK
       Elément N° 8 retiré de la collection
    */

    // Impressionnant, n'est-ce pas ? Et vous pouvez bien voir que,
    // tant que nous ne tentons pas de récupérer la première valeur, il est impossible d'en insérer une nouvelle !
}

