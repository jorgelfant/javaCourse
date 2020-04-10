package i_poo.q_collections.collections_XIII_TrierCollections.TrierCollections_ComparatortMap;

import java.util.*;

public class mainMap {
    public static void main(String[] args) {
        /*
        Maintenant, voyons comment trier une Map... Dans ce cas, il nous faudra une classe concrète car nous
        allons avoir besoin de stocker le contenu à trier. Un ArrayLista_teoria

        Nous allons ensuite créer une nouvelle classe de type TreeMap qui aura notre comparateur en paramètre dans
        son constructeur, il ne nous restera plus qu'à ajouter le contenu de la Map que nous souhaitons trier dans
        celle qui contiendra le contenu trié.

        Afin de vous montrer ce fonctionnement, je vous propose de trier une  Map<Integer, CD> d'abord sur le CD et
        ensuite sur l'indice de façon décroissante. Voici mes codes
        */

        Map<Integer, CD> map1 = new HashMap<>();//HashMap ya viene ordenado por default siguiento las Key
        map1.put(1, new CD("Les arcandiers", "7€", 7d));
        map1.put(3, new CD("Frank Zappa", "Tinseltown rebellion", 10.25d));
        map1.put(5, new CD("Frank Zappa", "Bongo Fury", 10.25d));
        map1.put(4, new CD("King Crimson", "red", 15.30d));
        map1.put(2, new CD("Joe Zawinul", "World tour", 12.15d));

        //dans ce cas de figure, notre Map est triée par indice croissant
        //Primer Map
        Set<Map.Entry<Integer, CD>> es1 = map1.entrySet();//.entrySet() retorna una collection de tipo Set<Map.Entry<K,V>>
        //Iterator
        Iterator<Map.Entry<Integer, CD>> it = es1.iterator();

        while (it.hasNext()) {
            Map.Entry entry = it.next();//almaceno esto en el tipo interface Map.entry   (esto agrupa <K,V>)
            System.out.println("clé : " + entry.getKey() + " - valeur : " + entry.getValue());
        }

        //Nous allons maintenant trier par ordre de CD
        System.out.println("-----------------------------------");

        //**************************************************************************************************************
        //                                              ORDEN 2   MapComparator
        //**************************************************************************************************************
        //Segundo Map= en el cual metemos el primero que se va ordenar en funcion del ordenamiento que especificamos
        // en el parametro
        //                                            Creo un objeto de la clase que hice MapComparator o MapComparatorDesc

        //MapComparator hola=new MapComparator(map1); iria en parametro para decirle al Map<Integer,CD> como ordenarse

        //MapComparator ordena los Maps en funcion de los <Key,Value>   value , es decir de los objetos de tipo CD
        //esto comparara los elementos de mi objeto primero (String, String, Double) s

        //nous passons notre comparateur dans le constructeur
        //en lui spécifiant le contenu de la collection que nous allons lui passer
        //ordenara en funcion de los parametros del objeto CD  que hace de Value
        Map<Integer, CD> map2 = new TreeMap<>(new MapComparator(map1));//pongo el objeto de tipo MapComparator que

        /* O SINO sin usar la clase externa MapComparator, usariamos una clase interna en el parametro new Comparator....

        Map<Integer, CD> map2 = new TreeMap<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer key1, Integer key2) {// (CD un, CD deux)  y luego comparabamos de fente
                CD cd1 = map1.get(key1);//esto regresa el valor del Key que es CD(...,...,..,)
                CD cd2 = map1.get(key2);

                return map1.get(key1).compareTo(map1.get(key2));//esto va comparar los 2 objetos de type cd, comenzando por el 1er parametro
            }
        });
        */

        //implementa comparator solo que en este caso
        // a nuestro constructor le pusimos un parametro
        //de tipo Map
        //Que estamos haciendo? en nuestro map2 que esta vacio vamos a insertarle un TreeMap (que ya tiene el metodo pa ordenar dentro)
        //por eso un TreeMap pa no tener que usa Collections.Sort()
        //al insertarle el objeto de la clase MapComparator que implementa Comparator este va a decirle como ordenarse
        //pero como en este caso pusimos un parametro en la clase que implementa comparator, esto quiere decir
        //que lo que seguira este ordenamiento es el objeto de tipo collection Map que ponemos en el parametro new MapComparator(map1)
        //Asi esto nos dara el map1 que hicimos al principio ordenado de la manera MapComparator

        //De esta manera en vez de crear objetos de tipo Map e ir metiendolos en map2, metemos primero la manera de ordenar
        //del objeto que pondremos en nuestro map2
        //y luego con  putAll() le agregamos map1
        map2.putAll(map1);
        Set<Map.Entry<Integer, CD>> es2 = map2.entrySet();
        Iterator<Map.Entry<Integer, CD>> it2 = es2.iterator(); //Creamos un nuevo iterador que pasara revista al map2

        while (it2.hasNext()) {
            Map.Entry<Integer, CD> entry = it2.next();//referencia a los 2 parametros del map con la interface interna Map.Entry
            System.out.println("clé : " + entry.getKey() + " - valeur : " + entry.getValue());
        }

        System.out.println("-----------------------------------");

        //**************************************************************************************************************
        //                                        ORDEN 3   MapComparatorDesc
        //**************************************************************************************************************
        //Cambiamos solo el tipo de objeto que implementa Comparator
        Map<Integer, CD> map3 = new TreeMap<>(new MapComparatorDesc(map1));
        map3.putAll(map1);

        Set<Map.Entry<Integer, CD>> es3 = map3.entrySet();
        Iterator<Map.Entry<Integer, CD>> it3 = es3.iterator();

        while (it3.hasNext()) {
            Map.Entry<Integer, CD> entry = it3.next();
            System.out.println("clé : " + entry.getKey() + " - valeur : " + entry.getValue());
        }
       /*
       asi hemos creado 2 formas diferentes de ordenar con Comparator<T>
       en realidad el parametro que ponemos en el Comparator no aporta nada siempre y cuando luego
       pongamos por ejemplo map3.addAll(map1) aqui map3 ya tendria un orden dado antes de ponerle
       los elementos de la collection map1

       sin embargo si hacemos map3=map1; no funcionaria porque la referencia ya no apuntaria a map3 sino a la ref de map1
       y tendria el orden de map1

       ESTO SIEMPRE Y CUANDO TRATEMOS CON EL KEY ya que si intentamos hacer esto con CD es decir Value, no funciona

       -----------------------------------------------------------------------------------------------------------------
       Quand vaut-il mieux utiliser un comparateur plutôt que l'interface Comparable ?

       Dites-vous bien que l'implémentation de l'interface Comparable permet de donner à vos objets une façon de les
       comparer par défaut, c'est donc par le biais de cette interface qu'il faut définir un tel comportement. Par contre,
       avec l'interface Comparator vous pouvez définir des méthodes de comparaison marginale afin de remplacer ponctuellement
       l'ordre préétabli. C'est donc à vous de juger quel comportement est prédominant par rapport à un autre et donc mettre
       le comportement le plus fréquent dans compareTo(T elem).

       */

    }
}
