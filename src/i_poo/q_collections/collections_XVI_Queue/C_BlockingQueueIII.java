package i_poo.q_collections.collections_XVI_Queue;

import java.util.concurrent.DelayQueue;
import java.util.concurrent.Delayed;
import java.util.concurrent.TimeUnit;

public class C_BlockingQueueIII {
    public static void main(String[] args) {
        /*

        5) DelayQueue<E extends Delayed>

        Encore une implémentation particulière qui n'accepte que des objets qui implémentent l'interface Delayed.
        Cette dernière ne redonne les éléments qu'elle contient uniquement lorsque le délai d'expiration est
        arrivé à son terme.

        Comment savoir si le délai est arrivé à expiration ?

        C'est simple, l'interface Delayed demande à redéfinir une méthode, getDelay(TimeUnit tu) et c'est via cette
        méthode que l'objet de collection arrive à savoir si le délai est arrivé à expiration : lorsque la dite méthode
        retourne une valeur inférieure ou égale à 0.

        Voici un code d'exemple :

        */
        MyObject obj1 = new MyObject("Obj1", 500);
        MyObject obj2 = new MyObject("Obj2", 1000);
        MyObject obj3 = new MyObject("Obj3", 1500);
        MyObject obj4 = new MyObject("Obj4", 20000);

        DelayQueue<MyObject> dq = new DelayQueue<MyObject>();
        dq.put(obj1);
        dq.put(obj2);
        dq.put(obj3);
        dq.put(obj4);

        //Les éléments sont bien dans la collection mais non utilisables
        System.out.println(dq);
        System.out.println(dq.poll());

        for (int i = 0; i < 10; i++) {
            //On attend 300 ms
            try {
                Thread.sleep(300);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            MyObject my = dq.poll();
            System.out.println(my);
        }
    }
}

/*
Les objets sont donc récupérables mais uniquement lorsque leur délai a expiré. C'est simple mais encore fallait-il le savoir...
*/
//**********************************************************************************************************************
//                                      CLASE EXTERIOR AL MAIN
//**********************************************************************************************************************
class MyObject implements Delayed {
    private String nom;
    private long origine, delay;

    public MyObject(String name, long d) {
        nom = name;
        origine = System.currentTimeMillis();
        delay = d;
    }

    public long getDelay(TimeUnit unit) {
        return unit.convert(
                delay - (System.currentTimeMillis() - origine),
                TimeUnit.MILLISECONDS);
    }

    public int compareTo(Delayed delayed) {
        if (delayed == this) {
            return 0;
        }

        long d = (getDelay(TimeUnit.MILLISECONDS) - delayed.getDelay(TimeUnit.MILLISECONDS));
        return ((d == 0) ? 0 : ((d < 0) ? -1 : 1));
    }


    public String toString() {
        return "MyObject [nom=" + nom + "]";
    }
}


