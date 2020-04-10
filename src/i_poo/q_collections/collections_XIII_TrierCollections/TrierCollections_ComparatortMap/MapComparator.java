package i_poo.q_collections.collections_XIII_TrierCollections.TrierCollections_ComparatortMap;

import java.util.Comparator;
import java.util.Map;

// On va  trier une Map<Integer, CD> d'abord sur le CD
public class MapComparator implements Comparator<Integer> {//clases de la API Comparator<Integer>

    private Map<Integer, CD> map;

    public MapComparator(Map<Integer, CD> map) {
        this.map = map;
    }
    //Pk este constructor con parametro ? porque mas abajo en el metodo reescrito compare(), estamos diciendole
    //que compare objetos, lo cual significa que compara 2 objetos. pero sino le damos ningun objeto a comparar
    //va dar error, al ponerle un Map como parametro al constructor, este tendra el key y el Value, que es nuestro
    //objeto CD , asi el metodo tendra un objeto cual utilizar para la comparacion. Toodo esto trabajando con
    //Integer del Map que es el Key

    //Tipo de orden en funcion de la clase generica CD  (Key, Value)
    @Override
    public int compare(Integer key1, Integer key2) {// (CD un, CD deux)  y luego comparabamos de fente
        CD cd1 = map.get(key1);//esto regresa el valor del Key que es CD(...,...,..,)
        CD cd2 = map.get(key2);

        return cd1.compareTo(cd2);//esto va comparar los 2 objetos de type cd, comenzando por el 1er parametro
    }                             //si no son iguales se para ahi, si son iguales compara el sgt parametro

}
