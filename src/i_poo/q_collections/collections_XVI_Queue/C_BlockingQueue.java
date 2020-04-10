package i_poo.q_collections.collections_XVI_Queue;

import java.util.Random;
import java.util.concurrent.*;


public class C_BlockingQueue {
    public static void main(String[] args) {
        /*
        Cette interface rajoute aussi des contraintes à l'interface Queue<E>  que nous avons vu précédemment.
        Ce type de collection n'accepte pas les valeurs null  et lève une exception si vous tentez d'en insérer
        une mais ce qui caractérise cette interface est une notion de blocage pour les actions ne pouvant pas
        être faites immédiatement mais qui pourraient l'être dans un futur plus ou moins proche. Ce blocage
        intervient sur les méthodes usuelles de nos collections (ajout, suppression, consultation) lorsque vous
        essayez d'ajouter des éléments dans une collection qui n'en accepte plus.

        Tu veux dire que ce genre de collection ont une taille définie ?

        En fait, c'est vous qui avez la possibilité de définir une taille et, si vous ajoutez un élément alors
        que la collection a atteint sa taille maximum, c'est à ce moment qu'il peut y avoir une exception, un
        blocage ou autre en fonction de la méthode utilisée. Voici un tableau qui représente les différents types
        de rendu en fonction des méthodes employées sur les éléments de la collection :

       Type de Methode    |   Lève une exception   | Retourne une valeur  | Bloque le thread  |  Bloque le thread
                          |                        |                      |  indéfiniment     |  pendant une durée
     -------------------------------------------------------------------------------------------------------------------
                          |                         |                     |                   |
         Méthode          |    add(E elem)          |   offer(E elem)     |  put(E elem)      |  offer(E elem,
         d'utilisation    |                         |                     |                   |  long timeout, TimeUnit unit)
     -------------------------------------------------------------------------------------------------------------------
         Méthode de       |                         |                     |                   |
         récupération     |   remove()              |    poll()           |  take()           | poll(long timeout,
         avec suppression |                         |                     |                   | TimeUnit unit)
     -------------------------------------------------------------------------------------------------------------------
         Méthode de       |                         |                     |                   |
         récupération     |                         |                     |                   |
         sans             |    get()                |    peek()           |                   |
         suppression      |                         |                     |                   |
     -------------------------------------------------------------------------------------------------------------------

     De par son mode de fonctionnement, les implémentations de cette interface sont tout indiquées pour gérer des
     collections dont les objets sont produits (ajoutés) via un thread à part, et sont consultés ou utilisés via un
     troisième thread. Pour faire simple, ces objets sont très utiles dans un environnement multithread. Parlons
     maintenant de ces implémentations.

     Je ne vais pas vous donner un code pour chaque objet, sachant qu'ils fonctionnent grosso-modo de la même manière
     et qu’ils ont juste quelques spécificités chacun...

     5 clases heredan dd blockingQueue:

     1) ArrayBlockingQueue<E>

     Cet objet gère donc son contenu via un tableau et l'ordre de ses éléments sous la forme FIFO. L'élément en
     fin de collection est celui qui fait partie de la collection depuis le plus longtemps, je vous laisse donc
     en tirer les conclusions qui s'imposent pour l'élément en fin de collection.

     Par contre, vu que ces éléments sont censés travailler en mode multithread, l'ordre d'accès n'est pas réellement
     garanti, dans le cas où un thread insère les éléments et un autre les récupère. De ce fait, il existe un constructeur
     qui permet de passer un booléen qui force le mode FIFO.

     Autre point important : vous devez spécifiez la taille de ce type de collection. De ce fait vous n'aurez plus la
     possibilité modifier cette dernière et, si vous dépassez la taille limite, vous recevrez une belle exception !
     -------------------------------------------------------------------------------------------------------------------

     2) L'objet LinkedBlockingQueue<E>

     Cet objet, lui, fonctionne avec une suite de nœuds liés entres eux. Tout comme l'objet ci-dessus, il gère
     ces éléments en FIFO avec comme premier élément, celui qui y est dans la collection depuis le plus longtemps.
     Par contre, vous n'êtes pas obligé de spécifier une quantité maximum d'éléments et, si vous optez pour cette
     solution, la capacité maximum correspondra à la valeur de l'attribut statique de la classe Integer : Integer.MAX_VALUE.
     Les nœuds supplémentaires seront donc créés de façon dynamique.

     -------------------------------------------------------------------------------------------------------------------

     3) PriorityBlockingQueue<E>

     Cette classe utilise le même ordonnancement que l'objet PriorityQueue<E>  en y ajoutant la notion de blocage
     entre les threads. Elle utilise donc le même mécanisme pour ordonner ses éléments donc les éléments qu'elle
     contient doivent être comparables ou nous devons fournir un comparateur à notre instance pour qu'elle sache
     trier ses valeurs. De plus, cet objet ne prévoit pas de fonctionnement particulier pour les éléments considérés
     comme égaux.

     Par contre, bien que cette implémentation est théoriquement sans limites, il se peut que certaines insertions
     échouent par manque de mémoire, levant ainsi une exception de type OutOfMemoryError .

     Autre point important, l'iterateur retourné par cet objet ne vous permet pas de parcourir les éléments triés,
     vous aurez une vue anarchique de son contenu. Si vous voulez parcourir les éléments triés, vous n'aurez pas
     d'autre choix que d'utiliser la conversion de notre collection en tableau et d'utiliser la méthode de tri de
     l'objet Arrays, comme ceci : Arrays.sort(pq.toArray()).

     Voici un code qui vous montre le fonctionnement de ces trois objets :
        */

        //Nous allons tester avec trois implémentations pour commencer

        //test de l'implémentation LinkedBlockingQueue
        LinkedBlockingQueue<Integer> lbq = new LinkedBlockingQueue<Integer>(10);
        System.out.println("Exemple avec l'objet LinkedBlockingDeque<T> : ");
        System.out.println("----------------------------------------------");
        doIt(lbq);

        System.out.println("----------------------------------------------");

        //test de l'implémentation ArrayBlockingQueue
        ArrayBlockingQueue<Integer> abq = new ArrayBlockingQueue<Integer>(10);
        System.out.println("Exemple avec l'objet ArrayBlockingQueue<T> : ");
        System.out.println("----------------------------------------------");
        doIt(abq);


        System.out.println("----------------------------------------------");

        //test de l'implémentation PriorityBlockingQueue
        PriorityBlockingQueue<Integer> pbq = new PriorityBlockingQueue<Integer>(10);
        System.out.println("Exemple avec l'objet PriorityBlockingQueue<T> : ");
        System.out.println("----------------------------------------------");
        doIt(pbq);

    }

    static void doIt(BlockingQueue<Integer> bq) {
        //Création d'une collection n'acceptant que 10 entrées
        BlockingQueue<Integer> lbq = bq;
        //Nous allons tester la concurrence sur cette collection
        SampleThread t1 = new SampleThread(null, 0, lbq);
        SampleThread t2 = new SampleThread(TimeUnit.MILLISECONDS, 10L, lbq);

        //Nous lançons les threads
        //t1 ne nous rendra pas la ArrayLista_teoria car nous tentons d'ajouter des éléments
        //Alors que la collection sera considérée comme pleine
        t1.start();
        //alors que ce Thread terminera normalement car nous ne bloquons le thread
        //que pendant un certain temps
        t2.start();

        //On attend quelques secondes et on lance une suppression des éléments
        try {
            System.out.println("Pause de 10 secondes");
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Suppression de quelques éléments de la collection");
        for (int i = 0; i < 10; i++)
            lbq.poll();
        //après cette série de suppressions, le premier thread arrive à terminer son travail

        //Nous attendons quelques secondes
        try {
            System.out.println("Pause de 3 secondes");
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        LinkedBlockingQueue<Integer> lbq2 = new LinkedBlockingQueue<Integer>(3);
        //nous tentons maintenant de mettre le contenu  notre première collection
        //dans la seconde, mais ceci lèvera une exception car le contenu de la première est trop volumineux
        //pour la seconde !
        System.out.println("Capacité restante : " + lbq.remainingCapacity());
        System.out.println("Capacité restante : " + lbq2.remainingCapacity());
        try {
            lbq.drainTo(lbq2);
        } catch (IllegalStateException e) {
            System.out.println("La queue est pleine !! ");
        }

        System.out.println(lbq2);
    }
}

//**********************************************************************************************************************
//                                      CLASE EXTERIOR AL MAIN
//**********************************************************************************************************************
class SampleThread extends Thread {
    private TimeUnit tu;
    private long timeout;
    private BlockingQueue<Integer> lbd;

    public <T> SampleThread(TimeUnit tu, long timeout, BlockingQueue<Integer> lbd) {
        this.tu = tu;
        this.timeout = timeout;
        this.lbd = lbd;
    }

    public void run() {
        Random rand = new Random();
        for (int i = 0; i < 10; i++) {

            Integer integer = rand.nextInt(20);

            //Si pas de critère de durée
            //On utilise la méthode qui bloque le thread indéfiniment
            if (this.tu == null) {
                try {
                    if ((i % 2) == 0) {
                        this.lbd.put(integer);

                    } else
                        this.lbd.put(integer);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            //Sinon, on ne bloque que quelques secondes
            else {
                try {
                    if ((i % 2) == 0) {
                        this.lbd.offer(integer, this.timeout, this.tu);
                    } else {
                        this.lbd.offer(integer, this.timeout, this.tu);
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            try {
                this.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        //On affiche le résultat lors de la fin du traitement
        System.out.println("À la fin du thread " + this.getName() + " : " + lbd);
    }
}
