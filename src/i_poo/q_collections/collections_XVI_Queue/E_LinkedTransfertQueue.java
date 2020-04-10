package i_poo.q_collections.collections_XVI_Queue;

import java.util.Random;
import java.util.concurrent.LinkedTransferQueue;
import java.util.concurrent.TimeUnit;

public class E_LinkedTransfertQueue {
    public static void main(String[] args) {
        //clase que hereda de BlockingQueue

        //LinkedTransferQueue<E>

        //Cet objet est donc l'implémentation de l'interface mentionné ci-dessus. Cet objet rajoute deux méthodes utiles :

        /*
          .getWaitingConsumerCount() : retourne une estimation des threads attendant des éléments de la collection ;

          .hasWaitingConsumerCount() : retourne true si au moins un thread attend un élément de la collection.

          Voici un code d'exemple de cet objet. Attention, ça pique un peu :
        */

        LinkedTransferQueue<String> queue = new LinkedTransferQueue<String>();

        //nous créons un thread de production
        ProducteurThread pt1 = new ProducteurThread(queue, ProducteurThread.TIMEOUT);
        //nous n'allons pas bloquer la récupération dans ce thread
        ConsommateurThread ct1 = new ConsommateurThread(queue, ConsommateurThread.POLL);

        pt1.start();
        ct1.start();
        // Ici, la temporisation dans le consommateur
        // est trop grande par rapport à la temporisation
        // dans la méthode d'ajout
        // très peu de contenu devrait être OK, le premier élément en fait...
        try {
            Thread.sleep(15000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Premier test terminé ! \n\n");

        queue = new LinkedTransferQueue<String>();
        ProducteurThread pt2 = new ProducteurThread(queue, ProducteurThread.DEFAULT);
        ConsommateurThread ct2 = new ConsommateurThread(queue, ConsommateurThread.TAKE);


        pt2.start();
        ct2.start();
        //pas de soucis ici car la temporisation permet de tout récupérer
        //il n'y a pas de blocage lors de l'ajout de nouveaux éléments dans la collection

        try {
            Thread.currentThread().sleep(15000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Second test terminé ! \n\n");

        queue = new LinkedTransferQueue<String>();
        ProducteurThread pt3 = new ProducteurThread(queue, ProducteurThread.BLOCK);
        ConsommateurThread ct3 = new ConsommateurThread(queue, ConsommateurThread.TAKE);

        // pas de soucis ici car la temporisation permet de
        // tout récupérer et donc de tout ajouter
        pt3.start();
        ct3.start();


        try {
            Thread.currentThread().sleep(15000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Troisième test terminé ! \n\n");


        System.out.println("---------------------------------------------------------");
        System.out.println("Utilisation de la méthode hasWaitingConsumer()");
        System.out.println("---------------------------------------------------------");

        queue = new LinkedTransferQueue<String>();
        ConsommateurThread ct4 = new ConsommateurThread(queue, ConsommateurThread.TAKE);
        ConsommateurThread ct5 = new ConsommateurThread(queue, ConsommateurThread.TAKE);
        ct4.start();

        try {
            Thread.currentThread().sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //départ légèrement différé du deuxième Thread consommateur
        ct5.start();

        Random rand = new Random();
        System.out.println("Nombre de thread attendant des éléments : " + queue.getWaitingConsumerCount());
        while (queue.hasWaitingConsumer()) {
            System.out.println("Nombre de thread attendant des éléments : " + queue.getWaitingConsumerCount());
            String str = "DATA_" + rand.nextInt(100);
            try {
                queue.transfer(str);
                System.out.println("Elément ajouté avec succès : " + str);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            //Cette temporisation permet d'aérer les tours de boucle
            //et ainsi laisser le temps aux deux threads d'aller jusqu'à leur
            //méthode take() pour informer l'objet qu'un thread attend un élément
            try {
                Thread.currentThread().sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("----------------------------------");
        System.out.println("FIN DES TESTS !");
    }
}

/*
Le premier test utilise la temporisation lors de l'insertion dans l'objet. Hors le thread qui est censé récupérer
ces valeurs est décalé dans le temps donc très peu de valeurs sont donc mises dans la collection.

Le deuxième test permet de voir que nous pouvons ajouter des données dans la collection sans attendre qu'un thread
ne demande un élément, c'est le test le plus simple car il n'y a pas de verrou.

Le troisième reprend l'idée du premier test mais sans temporisation lors de l'ajout de données, du coup, pour ce test,
tous les éléments sont insérés et tous sont récupérés.

Le dernier test, lui, met en évidence la façon d'utiliser l'attente de récupération. Ayant mis des temporisation
dans les threads consommateurs, il faut mettre une temporisation dans la boucle car c'est l'invocation de la méthode
take() qui informe l'objet qu'un thread attend un élément.

Ici, j'ai volontairement fait démarrer les deux thread consommateurs en différé pour que vous puissiez bien voir le
nombre de threads demandeur à chaque tour de boucle.

La méthode take() informe l'objet qu'un thread attend un élément, il en va de même pour la méthode
poll(long timeout, TimeUnit unit).

Voilà, vous savez tout !
*/
//**********************************************************************************************************************
//                                            CLASE EXTERNA AL MAIN
//**********************************************************************************************************************
class ProducteurThread extends Thread {

    private LinkedTransferQueue<String> ltq;
    private int modeDeTransfert = 0;
    public final static int BLOCK = 1, TIMEOUT = 2, DEFAULT = 0;

    public ProducteurThread(LinkedTransferQueue<String> q, int mode) {
        ltq = q;
        modeDeTransfert = mode;
    }

    public void run() {
        Random rand = new Random();

        for (int i = 0; i < 5; i++) {
            String str = "Random_" + rand.nextInt(20);

            long start = System.currentTimeMillis();

            //Pour ce mode, on pousse en bloquant une attente d'un autre thread
            if (modeDeTransfert == 1) {
                try {
                    ltq.transfer(str);
                    //on mesure le temps d'ajout
                    long end = System.currentTimeMillis();
                    System.out.println("Elément " + str + " inséré en " + ((end - start) / 1000) + " seconde");
                } catch (InterruptedException e1) {
                    e1.printStackTrace();
                }
            }
            //Pour celui-ci, nous mettons une temporisation
            else if (modeDeTransfert == 2) {
                try {
                    //On récupère le statut du transfert
                    boolean bool = ltq.tryTransfer(str, 1000, TimeUnit.MILLISECONDS);
                    //on mesure le temps d'ajout
                    long end = System.currentTimeMillis();
                    System.out.println("Résultat de l'ajout avec temporisation : " + bool);
                    if (bool) {
                        System.out.println("Elément " + str + " inséré en " + ((end - start) / 1000) + " seconde");
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            //Et par défaut, pas de temporisation et pas de blocage
            else {
                ltq.offer(str);
                System.out.println("Elément " + str + " inséré !");
            }

            //Une temporisation pour ralentir le tout
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

//**********************************************************************************************************************
//                                            CLASE EXTERNA AL MAIN
//**********************************************************************************************************************
class ConsommateurThread extends Thread {
    private LinkedTransferQueue<String> ltq;
    private int modeRecuperation = 0;
    public static int POLL = 1, TAKE = 2;

    public ConsommateurThread(LinkedTransferQueue<String> q, int mode) {
        ltq = q;
        modeRecuperation = mode;
    }

    public void run() {
        for (int i = 0; i < 5; i++) {
            try {
                //La temporisation est grande
                //pour vous montrer le blocage de la méthode transfert
                //avec temporisation
                Thread.sleep(2500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            //avec ce mode, pas de blocage lors de la récupération
            if (modeRecuperation == 1) {
                System.out.print("Récupération de la valeur : " + ltq.poll());
            }
            //ici, un blocage se fait lors de la récupération s'il n'y a pas d'élément
            else {
                try {
                    System.out.println("Récupération de la valeur : " + ltq.take());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }

        System.out.println("---------------------------------------------------------");
        System.out.println("Statut de la collection à la fin du thread " + this.getName());
        System.out.println(ltq);
        System.out.println("---------------------------------------------------------");
    }
}
