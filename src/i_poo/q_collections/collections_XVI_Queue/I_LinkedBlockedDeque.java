package i_poo.q_collections.collections_XVI_Queue;

import java.util.Random;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.TimeUnit;

public class I_LinkedBlockedDeque {
    public static void main(String[] args) {
        // clase BloquingDeque<E> que hereda de la interface BlockingDeque (que hereda de Deque)
        /*
        Cette implémentation se base sur une suite de nœuds liés entre eux. Elle gère une autorisation de capacité
        via un constructeur spécifique mais, en l'absence de ce paramètre, la capacité maximum autorisée correspond
        à la valeur définit dans l'objet Integer par la constante Integer.MAX_VALUE et, tout comme l'objet ci-dessus,
        les différentes opérations faites sur cet objet sont en temps constant.

        Voici un code qui met en pratique cet objet :

        */
        //Création d'une collection n'acceptant que 10 entrées
        LinkedBlockingDeque<Integer> lbd = new LinkedBlockingDeque<Integer>(10);
        //Nous allons tester la concurrence sur cette collection
        MonThread t1 = new MonThread(null, 0, lbd);
        MonThread t2 = new MonThread(TimeUnit.MILLISECONDS, 10L, lbd);

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
            lbd.pollLast();
        //après cette série de suppressions, le premier thread arrive à terminer son travail

        //Nous attendons quelques secondes
        try {
            System.out.println("Pause de 3 secondes");
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        LinkedBlockingDeque<Integer> lbd2 = new LinkedBlockingDeque<Integer>(3);
        //Nous tentons maintenant de mettre le contenu  notre première collection
        //dans la seconde, mais ceci lèvera une exception car le contenu de la première est trop volumineux
        //pour la seconde !
        System.out.println("Capacité restante : " + lbd.remainingCapacity());
        System.out.println("Capacité restante : " + lbd2.remainingCapacity());
        lbd.drainTo(lbd2);

        System.out.println(lbd2);
    }
}

//**********************************************************************************************************************
//                                      CLASE EXTERIOR AL MAIN
//**********************************************************************************************************************
class MonThread extends Thread {
    private TimeUnit tu;
    private long timeout;
    private LinkedBlockingDeque<Integer> lbd;

    public MonThread(TimeUnit tu, long timeout, LinkedBlockingDeque<Integer> lbd) {
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
                        this.lbd.putFirst(integer);

                    } else
                        this.lbd.putLast(integer);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            //Sinon, on ne bloque que quelques secondes
            else {
                try {
                    if ((i % 2) == 0) {
                        this.lbd.offerFirst(integer, this.timeout, this.tu);
                    } else {
                        this.lbd.offerLast(integer, this.timeout, this.tu);
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            try {
                this.sleep(100);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }

        //On affiche le résultat lors de la fin du traitement
        System.out.println("À la fin du thread " + this.getName() + " : " + lbd);
    }
}
/*
Vous pouvez voir que le premier thread attend indéfiniment que la collection ait de nouveau de l'espace pour
pouvoir y ajouter des éléments alors que le second thread se contente de jeter l'éponge et continue sans se
poser de questions.

Vous avez pu voir que cette interface est tout de même pratique et n'est pas très difficile à utiliser.

Vous commencez maintenant à avoir une bonne vision de ce que permet le framework Collections mais il vous manque
encore une corde à votre arc : l'interface Map<E> , et c'est ce que nous allons voir tout de suite ! :pirate:
*/
