package i_poo.q_collections.collections_XI_Map;

import java.util.HashMap;
import java.util.Map;

public class main_Map {
    public static void main(String[] args) {
        //Maps
        /*
        ************************************************************************************************************************
*                                                        MAP
************************************************************************************************************************


       VENTAJAS                                                                      DESVENTAJAS

 *Asociacion clave-->Valor.                                                    * no tiene acceso aleatorio

 *No claves iguales.                                                           * Poca eficiencia a la hora de ordenar
                                                          INTERFACE                 elementos (y no siempre se puede)
                                                    ********************
                                                    *        Map       *
                                                    ********************
                                                             |
                                                             |
                                                             |
           /---------------------------------------------------------------------------------------------------------------\
         /                    |                     |               \                   \                       \          \
     Class                  Class                 Class             Class              Class              Class           Class
*************        *******************       ***********       ***********      **************     ************       *************
*  HashMap  *        *  LinkedHashMap  *       * TreeMap  *      * EnumMap *      *WeakHashMap *     *HashTable *       *Concurrent *
*************        *******************       ***********       ***********      **************     ************        HashMap

.No ordenacion.      .Ordenacion por          .Ordenado por      .Permite enum    .Utilizado para    .considerado       .Utilizado en
                      insercion.               clave.             como claves.     crear elementos    obsoleto.          concurrencia.
.Eficiente.                                                                        que vaya
                     .Eficiente lectura.      .Poco eficiente    .Muy eficiente.   borrando el       .Utilizado en      .No permite
                                               en todas sus                        sistema si no      operaciones        nulos.
                     .Poca eficiencia          operaciones.                        se utilizan.       de concurrencia.
                      escritura.
                                                                                   .Muy poco efi_
                                                                                    ciente.
        */

        //Esto es parecido a introducir informacion a una tabla de 2 columnas en SQL por ejemplo en la cual la primera
        //columna es un campo clave....   clave -> valor   un campo clave ya sabemos que no puede quedar vacia ni repetir
        //la informacion que hay en su interior, e identifica de forma unica a cada registro. A_PrincipalFile caracteristica de un mapa.
        //En un Map de java si podemos dejar la clave vacia, pero lo que no podemos hacer nunca, es repetir las claves
        //es decir que cada valor que almacenemos en una collection de tipo Map tiene su correspondiente clave asociada
        //que sera unica identificativa para cada objeto almacenado dentro de esta collection

//**********************************************************************************************************************
//                                         COSAS A TENER EN CUENTA A LA HORA DE CONSTRUIR UN MAP
//**********************************************************************************************************************

        //es como almacenar informacion en una table de 2 columnas :
        /*
                                           -----------------------------
                                           |   Clave      |   Valor    |
                                           |              |            |
                                           -----------------------------
                                           |       1      |  Valor 1   |
                                           |              |            |
                                           -----------------------------
                                           |       2      |  Valor 2   |
                                           |              |            |
                                           -----------------------------
                                           |       3      |  Valor 3   |
                                           |              |            |
                                           -----------------------------



          la collection Map recibe 2 tipos genericos como parametros,  Map<K,V>

          FluentApiTest hace referencia a la clave
          V hace referencia al valor

          Porque son tipos genericos? Porque podemos usar tanto como clave como con valor cualquier tipo que se nos ocurra
          cualquier tipo de objeto , no tiene porque ser la clave un numero , puede ser cualquier otra cosa que sea unica
          para cada elemento .

          Para poder hacer esta asociacion clave valor, es decir para poder introducir elementos dentro de este Map
          y que cada uno tenga asociada su clave correspondiente vamos a utilizar el metodo :

          put(K,V)   que pertenece a la interface Map
          este metodo recibe 2 tipos genericos, la clave y el valor

           FluentApiTest -----> V
           1 -----> Valor 1

          tenemos muchos otros metodos, entre los que destacan el metodo :

          V                       get(Object key)

          permite obtener el valors de una clave en concreto
          preguntamos por la clave y deuelve el valor

//**********************************************************************************************************************

         Otra cosa muy importante de esta interface Map es que tiene una INTERFACE INTERNA esto es como las clases internas
         Las interfaces tambien pueden tener interfaces internas .

         Y en el caso de la interface Map , cuenta con una interface interna que es la interface Map.Entry
         Esta interface Map tiene el metodo:

         Set <Map.Entry<K,V>>                                 entrySet()
                                                              nos devuelve une colection de tipo Set

        Nested class Summary          clase interna
        ---------------------

        Modifier and type                                     Interface and Description
        -----------------                                     -------------------------
        static interface                                      Map.entry<K,V>
                                                                 A map entry (Key-value pair)
//**********************************************************************************************************************
         */

        //Ejemplo de Map que va a almacenar Empleados, cada empleado tendra su correspondiente clave

        HashMap<String, Empleado> personal = new HashMap<>();//HashMaps construido
        //         K      V
        //put(K key,V value)   associates the specified value with the specified key in this Map

        //Si los 4 elementos tuvieran la misma clave solo agregaria uno, el ultimo ya que se irian aplastando

        personal.put("145", new Empleado("Jorge"));
        personal.put("146", new Empleado("Sandra"));
        personal.put("147", new Empleado("Carlos"));
        personal.put("148", new Empleado("Gérard"));

        //            KEY  VALUE

        // V                        remove(Object key)
        //                          removes the mapping for a key from this map if it is present

        System.out.println(personal);
        personal.remove("145");//elimina el objeto
        System.out.println(personal);

        // podemos substituir un elemento poniendo su clave, y luego el nuevo valor con replace
        personal.replace("147", new Empleado("Charles"));
        System.out.println(personal);

        // podemos substituir un elemento volviendo a escribir un elemento con la misma clave, lo aplasta con put
        personal.put("148", new Empleado("Gerardo"));
        System.out.println(personal);

        //Set<Map.Entry<K,V>>                             entrySet()
        //                                                returns a Set view of the mappings contained in this map
        //                                                una vista de toodo lo almacenado en el mapa en forma de collection

        System.out.println(personal.entrySet());//devuelve collection de tipo set y que la imprima

        //la interface interna de map tb tiene sus propios metodos
        for (Map.Entry<String, Empleado> indice : personal.entrySet()) {
            String clave = indice.getKey();
            Empleado valor = indice.getValue();
            System.out.println(clave +""+valor);
        }

        /*
        Gracias por tus videos y explicaciones Juan. En el caso de los mapas,
        tambien podemos acceder al conjundo de claves con el metodo .keySet() para obtener las claves
        en el bucle foreach, personalmente me resulta mas sencillo y creo que simplica el código.
        El caso del video en el minuto 19:25 sería...

        for( String p: personal.keySet() ){
         System.out.println( "Clave: " + p + ", Valor: " + personal.get(p) );
        }

        Del mismo modo, podemos acceder al conjunto de valores directamente, con el metodo .values(). Para el ejemplo del video en el minuto 19:25 sería...

        for(Empleado e:personal.values()){
         System.out.println( "Clave: " + e  );
        }
        */

    }
}
