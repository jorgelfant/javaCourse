package i_poo.q_collections.collections_XVI_Queue;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ConcurrentLinkedQueue;

public class B_ConcurrentLinkedQueue {
    public static void main(String[] args) {
    /*
    Comme son nom l'indique, cet objet est thread-safe, donc utilisable dans un environnement multithread. Il fonctionne
    un peu comme l'objet ci-dessus à la différence près que l'élément placé en début de file est celui qui est présent
    depuis le plus longtemps dans la collection donc, par extension, le dernier élément ajouté sera placé en fin de
    collection. Par contre, cet objet n'autorise pas les éléments null .
    */

    //Voici un code d'exemple :

        //ces listes servent uniquement à répertorier les ajouts et suppressions
        List<Integer> listAjout = new ArrayList<Integer>();
        List<Integer> listRetire = new ArrayList<Integer>();
        List<Integer> listAjoutThread = new ArrayList<Integer>();

        //On crée notre collection
        ConcurrentLinkedQueue<Integer> queue = new ConcurrentLinkedQueue<Integer>();

        //Un thread qui va se charger de retirer et d'ajouter des éléments
        MyThread t = new MyThread(queue, listRetire, listAjoutThread);
        t.start();

        //Et nous ajoutons des éléments depuis notre thread principal
        for (int i = 0; i < 10; i++) {
            Random rand = new Random();
            Integer integer = rand.nextInt();
            queue.offer(integer);
            listAjout.add(integer);
            try {
                Thread.currentThread().sleep(1000);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }

        System.out.println(listAjout);
        System.out.println(listAjoutThread);
        System.out.println(listRetire);
    }
}

/*IMPRIME
  [302135980, -715211292, -465293153, 438546225, 1651135923, 774262222, 84799215, -117347279, 204998898, -1088590448]
  [3, 7, 6, 7, 3, 3, 4, 8, 6, 7]
  [302135980, -715211292, 3, -465293153, 7, 438546225, 6, 7, 1651135923, 774262222]
*/
//Ce code parle de lui-même. Les éléments ajoutés en premier sont retirés les premiers, quel que soit le thread qui les insère...
//**********************************************************************************************************************
//                                      CLASE EXTERIOR AL MAIN
//**********************************************************************************************************************
class MyThread extends Thread {
    private ConcurrentLinkedQueue<Integer> queue;
    private List<Integer> list, listAjout;

    //Constructeur
    public MyThread(ConcurrentLinkedQueue<Integer> q, List<Integer> pList, List<Integer> pList2) {
        queue = q;
        list = pList;
        listAjout = pList2;
    }
    //----------------------------------------------------------
    public void run() {
        int nb = 0;
        Random rand = new Random();
        while (true) {
            try {
                this.sleep(1000);
                //On ajoute un élément dans la collection
                Integer ajout = rand.nextInt(10);
                queue.offer(ajout);

                //On retire un élément
                Integer integer = queue.poll();

                //On stocke les deux actions dans nos listes
                list.add(integer);
                listAjout.add(ajout);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            nb++;
            if (nb > 10)
                break;
        }
    }
    //----------------------------------------------------------
    public List<Integer> getList() {
        return list;
    }

    public List<Integer> getListAjout() {
        return listAjout;
    }
}



