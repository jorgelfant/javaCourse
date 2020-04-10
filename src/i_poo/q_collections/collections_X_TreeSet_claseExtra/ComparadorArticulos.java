package i_poo.q_collections.collections_X_TreeSet_claseExtra;

import java.util.Comparator;

public class ComparadorArticulos implements Comparator {

    @Override
    public int compare(Object o1, Object o2) {//return 0 1 o -1
        Articulo otro1 = (Articulo) o1;
        Articulo otro2 = (Articulo) o2;

        String desc1 = otro1.getDescription();
        String desc2 = otro2.getDescription();

        return desc1.compareTo(desc2);//esto envia el resultado de la comparacion 0 1 o -1
    }
}
