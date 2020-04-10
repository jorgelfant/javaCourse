package i_poo.q_collections.collections_XIII_TrierCollections.TrierCollections_ComparatortMap;

import java.util.Comparator;
import java.util.Map;

public class MapComparatorDesc implements Comparator<Integer> {
    //Orden en funcion de la clase de la API Integer

    private Map<Integer, CD> map;

    public MapComparatorDesc(Map<Integer, CD> map) {
        this.map = map;
    }

    //Ordenamor en funcion de la key del Map  <Key,Value>
    public int compare(Integer key1, Integer key2) {
        //En comparant la clé dans ce sens
        //les éléments seront rangés par ordre décroissant d'indice
        return key2.compareTo(key1);
    }

}
