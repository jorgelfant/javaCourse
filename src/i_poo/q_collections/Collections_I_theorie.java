package i_poo.q_collections;

public class Collections_I_theorie {
    //******************************************************************************************************************
    //                                     COLLECTIONS I
    //******************************************************************************************************************
    /*


     ----------
    |Colection|    ====>    ALMACEN DE OBJETOS DINAMICO
    ----------
    De hecho ya hemos trabajado con una COLLECTION, una collection de tipo LISTA ==> el ArrayList

    Los array tambien son almacenes, no de objetos solamente, sino que tambien puede almacenar datos primitivos
    etc

    La diferencia entre un ARRAY y una COLLECTION, es que una collection es un "ALMACEN DINAMICO"
    es decir que a diferencia de un ARRAY, ese almacen dinamico puede AUMENTAR o DISMINUIR durante la ejecucion
    de un programa mientras que un Array tiene ya tamanio fijo. Mientras que una collection si en un principio
    lo hemos disenado para almacenar 10 objetos, si debido a algo necesitamos modificar su tamanio entonces
    esta collection es capaza de crecer o decrecer

    //////////
     VENTAJAS  ===>  1) Puede cambiar de tamanio
    //////////
                     2)Pueden ir provistas de ordenamiento (podemos ordenar los objetos que hay en una collection)

                     3)Se puede insertar y eliminar elementos de forma dinamica

    Para trabajar con COLLECTIONES tenemos que tener el ecosystema (FRAMEWORK) para trabajar con todas las
    colections possibles.

    FRAMEWORK=====> clases o interfaces para trabajar con algo en concreto

    *por ejemplo el FRAMEWORK de SWING:

         -Hace referencia a todas las clases e interfaces que tenemos en el paquete SWING para crear
          aplicaciones interfaces de ususario con SWING.

   //-------------------------------------------------------------------------------------------------------------------
                  PARA TRABAJAR CON COLLECTIONS tenemos que CONOCER EL FRAMEWORK de las COLLECTIONS
   //-------------------------------------------------------------------------------------------------------------------

               *Estas collections vienen determinadas por una SERIE DE INTERFACES: Map no hereda de Collection

                                        INTERFACE
                                    ********************
                                    *   Collection     *
                                    ********************
                                             |
               /-----------------------------------------------------------\
             /                               |                              \
        Interface                        Interface                      Interface                   Interface
    ********************            ********************           ********************         ********************
    *       Set        *            *      List        *           *       Queue      *         *       Map        *
    ********************            ********************           ********************         ********************
             |                                                               |                            |
             |                                                              |                             |
        INTERFACE                                                           |                         INTERFACE
    ********************                                         ********************            ********************
    *    SortedSet     *                                         *     Deque        *            *    SortedMap     *
    ********************                                         ********************            ********************
    .Permet aussi d'avoir un stockage                             .Permet d'insérer et          .cette interface permet
     par ordre croissant.                                          d'enlever des elements        de stocker des éléments
                                                                   aux deutx bouts de la         ordonnés par ordre croissant,
                                                                   collection                    très utile pour des listes
                                                                   un peu comme une pile         de numéros de téléphone,
                                                                   de cartes.                    de dictionnaire etc

          ESTE ES EL ECOSISTEMA DE INTERFACES QUE DEBEREMOS CONOCER Y MANEJAR PARA TRABAJAR CON COLLECTIONES

                   TENGAMOS EN CUENTA QUE LAS COLLECTIONS SON PARA ALMACENAR OBJETOS

************************************************************************************************************************
*                                                 Set:                                                                 *
************************************************************************************************************************

====> Permite ALMACENAR una COLLECTION DE OBJETOS NO REPETIDOS y SIN ORDENAR

     .Imaginemos que necesitemos almacenar en una collection de objetos "titulares de una cuenta corriente"
      en este caso una collection Set seria la mas adecuanda pa no repetir clientes y ademas tan sin ordenar
      los titulares de una cuenta corriente (2, 3 o 7) no se van a repetir.

     .Y ademas tendra poca importancia que los titulares de la cuenta corriente esten ordenados o no.
      En estos casos usamos una interface de tipo "Set"

     .cette interface permet donc de stocker des objets. Normal, c'est une collection ! Mais les classes
     implémentant cette interface ne tolèrent pas les doublons de données. Ainsi, ce genre de collection
     est tout indiqué pour gérer des éléments uniques : un calendrier, une liste de cartes à jouer etc.

************************************************************************************************************************
*                                                 List:                                                                 *
************************************************************************************************************************

====> Permite ALMACENAR una COLLECTION DE OBJETOS QUE PUEDEN ESTAR REPETIDOS y que estas INDEXADOS CON VALORES NUMERICOS
      estan ordenadas
     indice:  0    1    2     3     4     5 ........etc

     .List ofrece acceso aleatorio, es decir que una vez que tenemos una coleccion de objetos dentro de una List
      podemos acceder al elemento 20 , al 15, etc al que queramos

     .Mientras mas cosas permite realizar una coleccion mas lenta va ser su ejecucion (su eficiencia)

     .List permite hacer mas cosas que Set, sin embargo Set es mas rapido (Lo poco que hace lo hace rapido)

     .cette interface se présente sous la forme d'une liste ordonnée qui accepte les valeurs en double.
      Vous avez donc intérêt à contrôler parfaitement le contenu de vos données si vous utilisez ce type d'interface !

************************************************************************************************************************
*                                                 Queue:          (colas)                                              *
************************************************************************************************************************

====> La collection Queue no permite el ACCESO ALEATORIO , es decir no puedo acceder al 15 , al 12, al 20

      .Solo se permite acceder a elementos que se encuentren al INICIO de la QUEUE o al FINAL o a ambos
       POR ESO SE LE LLAMA COLA.

      .Segun van saliendo elementos por delante se van incluyendo elementos por detras o viceversa

      .funciona de forma parecida a lo que es una COLA DE PERSONAS esperando algo


************************************************************************************************************************
*                                                 Map:                                                                 *
************************************************************************************************************************

====> Permite crear una collection de elementos repetibles es decir que pueden haber elementos repetidos
      INDEXADOS por CLAVE UNICA ARBITRATIA

      .Es decir que al contrario que con los List los cuales identificamos por sus index (numeros)
       0   1    2   3  etc

      .En una collection de tipo Map, IDENTIFICAMOS a esos objetos con una CLAVE que no tiene porque ser un valor numerico

      .Es decir, a la hora de almacenar OBJETOS EN UN MAP lo podemos hacer de la siguiente forma:

      elem1-->Juan      elem1 identifica a un elemento que puede ser una persona
      elem2-->Maria
        ^       ^
     Clave   Elemento

     // MAP => Array asociativo en PHP //

////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
 *  Y luego Set y Map tienen cada una una SubInterface que permiten hacer ALGUNAS COSAS MAS EN CUANTO A ORDENAMIENTO
 *  ALGUNAS COSAS MAS ESPECIFICAS

 * ES RECOMENDABLE IR A LA API DE JAVA y que veamos que metodos tienen , para saber que metodos debemos implementar
 * a la hora de implementar una de estas interfaces

 *A la hora de implementar nuestros programas y crear unas colecciones del tipo que sean deberemos MANEJAR UNAS CLASES

 *CADA UNA DE ESTAS INTERFACES TIENEN ( dentro de lo que seria el FRAMEWORK de COLLECTIONS ) unas CLASES ASOCIADAS

************************************************************************************************************************
*             Por ejemplo en la API de JAVA hay unas cuantas CLASES que implementan la INTERFACE LIST
*             y son estas clases de la API DE JAVA las que tendremos que utilizat si queremos crear
*             una colection de tipo LIST   y lo mismo ocurre con el resto de INTERFACES
************************************************************************************************************************

Como List es casi siempre la mas utilizada empezaremos a mencionar las clases que implementan esta INTERFACE
y veremos algunas clases que ya hemos utilizado :

                                                          INTERFACE
       VENTAJAS                                     ********************                        DESVENTAJAS
                                                    *   Collection     *
 *Acceso aleatorio                                  ********************          * Bajo rendimiento en operaciones concretas
                     metod static                            |                      que se resolverian mejor con otras
 *Estan ordenadas (Collection.sort())                        |                      interfaces.
                                                         INTERFACE
 *Agregar y eliminar sin restriccion                ********************
                                                    *       List       *
 *ListIterator  modifica en cualquier direccion     ********************
                                                             |
 *Sintaxis similar a ARRAYS                                  |
                                                             |
               /-------------------------------------------------------------------------------------\
             /                               |                              \                         \
           Class                           Class                           Class                      Class
    ********************            ********************           ********************         ************************
    *    ArrayList     *            *    LinkedList    *           *      Vector      *         * CopyOnWriteArrayList *
    ********************            ********************           ********************         ************************


    como una interface no se puede instanciar, debemos utilizar las clases que la implementan

    *La diferencia fundamental entre unas COLLECTIONS y otras COLLECTIONS es el tema de la EFICIENCIA

    *OTRA DIFERENCIA ES QUE HAY COLLECTIONS ESPECIFICAS PARA PROGRAMACION CONCURRENTE para MULTI THREADS

    *Mientras mas eficiente sea un programa mejor

    *Ejemplo  int a=5;     byte a=5;  cual de las 2 sera mas eficiente? byte porque consume menos memoria

    *CON LAS COLECCIONES OCURRE LO MISMO

    *Muchas veces los elementos dinamicos de una coleccion podemos almacenarlos en una List pero tambien en un Set o Queue

    *Casi siempre usaremos un ArrayList ou un LinkedList    y muy rara vez porque se consideran obsoletos un
    *Vector o copyOnWriteArrayList


              /-------------------------------------------------------------------------------------\
             /                               |                              \                         \
           Class                           Class                           Class                      Class
    ********************            ********************           ********************         ************************
    *    ArrayList     *            *    LinkedList    *           *      Vector      *         * CopyOnWriteArrayList *
    ********************            ********************           ********************         ************************

   .Muy rapida accediendo a        .Listas enlazadas.              .Considerada como            .Utilizada en programas
    elementos.                                                      collection obsoleta          concurrentes.

   .Se adapta a un gran            .tiene una gran eficiencia      .Utilizada unicamente        .Eficiente en operaciones
    numero de escenarios.           agregando y eliminando          en operaciones de            de lectura pero muy poco
                                    elementos. aunque no tanto      concurrencia, multi          eficiente en operaciones
   .si se agregan                   leyendo elementos (imprimir)    thread.                      de escritura.
    y eliminan elementos
    muchas veces conviene           si voy a aregar un elmento
    talves un LinkedList.           una vez y luego voy a acceder
                                    muchas veces a ese mismo
                                    elemento conviene mas el
                                    ArrayList.

   conveniente con pocos            osea conveniente con muchos
   pa acceder varias veces          elementos.


   *Lo que hemos mencionado sobre la interdace List, pues ocurre lo mismo con el resto de interfaces


   POR EJEMPLO:
************************************************************************************************************************
*                   Por ejemplo tenemos la interface Set con sus ventajas y desventajas
************************************************************************************************************************

                                                          INTERFACE
       VENTAJAS                                     ********************                        DESVENTAJAS
                                                    *   Collection     *
 *No permite elementos duplicados                   *******************          * no tiene acceso aleatorio
                                                             |
 *Uso sencillo del metodo add que                            |                   * Poca eficiencia a la hora de ordenar
  ademas asegura no elementos                            INTERFACE                 elementos (y no siempre se puede)
  duplicados.                                       ********************
                                                    *        Set       *
                                                    ********************
                                                             |
                                                             |
                                                             |
           /---------------------------------------------------------------------------------------------------\
         /                    |                     |              \                   \                       \
     Class                  Class                 Class             Class              Class                    Class
*************        *******************       ***********       ***********      **************     ************************
*  HashSet   *       *  LinkedHashSet  *       * TreeSet *       * EnumSet *      *CopyOnWrite *     *ConcurrentSkipListSet *
*************        *******************       ***********      ************       ArraySet    *     ************************

.Rapida.             .Ordenacion x entrada.    .Es ordenado.    .La mejor para    .Especifico        .Especifico concurrencia.
                                                                 tipos enumer_     concurrencia.
.No duplicados.      .Eficiente al acceder.    .Poco eficient.   ados.                               .Admite ordenacion.
                                                                                  .Eficiente
.No ordenacion.      .No eficiente al                                              lectura.          .con muchos elementos no
                      agregar.                                                                        es suficiente.
.No acceso aleat.                                                                 .Poca eficien_
                                                                                   cia escritura.

                                                                                  .Poco eficiente
                                                                                   al eliminar.

************************************************************************************************************************
*                                                 QUEUE
************************************************************************************************************************



                                                          INTERFACE
       VENTAJAS                                     ********************                        DESVENTAJAS
                                                    *   Collection     *
 *Muy rapido al acceder al primero                  ********************         * no tiene acceso aleatorio
  y ultimo elemento.                                         |
                                                             |                   * Poca eficiencia a la hora de ordenar
  *Permite crear colas de elementos                      INTERFACE                 elementos (y no siempre se puede)
   muy eficientes.                                  ********************
                                                    *      Queue       *
                                                    ********************
                                                             |
                                                             |
                                                             |
           /---------------------------------------------------------------------------------------------------\
         /                         |                         |                        \                         \
     Class                       Class                      Class                     Class                    Class
*************         **********************         **************          ****************        ************************
*ArrayDeque *         *LinkedBlockingDeque *         * LinkedList *          *PriorityQueue *        *PriorityBlockingQueue *
*************         **********************         **************          ****************        ************************
.Gran eficiencia.     .Utilizado en program_         .Rendimiento            .Para utilizar          .Igual que el anterior
                       acion concurrente.             inferior al             un comparador.          pero mas eficiente en
.La mas usada.                                        ArrayDeque.                                     programacion concurrente.
                                                                             .El primer elemento
                                                                              dependera de propiedad
                                                                              elegida.


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
           /---------------------------------------------------------------------------------------------------\
         /                    |                     |               \                   \                       \
     Class                  Class                 Class             Class              Class                    Class
*************        *******************       ***********       ***********      **************     ************       *************
*  HashMap  *        *  LinkedHashMap  *       * TreeMap  *      * EnumMap *      *WeakHashMap *     *HashTable *       *Concurrent *
*************        *******************       ***********       ***********      **************     ************        HashMap

.No ordenacion.      .Ordenacion por          .Ordenado por      .Permite enum    .Utilizado para    .considerado       .Utilizado en
                      insercion.               clave.             como claves.     crear elementos    obsoleto.          concurrencia.
.Eficiente.                                                                        que vaya
                     .Eficiente lectura.      .Poco eficiente    .Muy eficiente.   borrando el       .Utilizado en      .No permite
.il accepte           en todas sus                                                 sistema si no      operaciones        nulos.
 la valeur null      .Poca eficiencia          operaciones.                        se utilizan.       de concurrencia.
                      escritura.
.il n'est pas                                                                     .Muy poco efi_     .n'accepte pas
 Thread Safe.                                                                      ciente.           la valeur null

                                                                                                     .il est Thread Safe.
    */


/* *********************************************************************************************************************
Les collections Java forment donc un framework qui permet de gérer des structures d'objets. Ce framework est constitué
d'un ensemble d'interfaces dont les différentes fonctionnalités sont implémentées par des classes concrètes.


                                                   Interface globale
                                                   -----------------
Ce sont les interfaces dont toutes les autres se servent afin d'avoir un comportement global commun. Ces deux interfaces
représentent le plus haut niveau d'abstraction du framework.

Collection : c'est le plus petit dénominateur commun de toutes les interfaces. Comme vous l'aurez remarqué,
toutes les interfaces (hormis les Map) implémentent cette dernière. Cette interface ne permet pas de gérer la
notion de doublon ou de tri automatique. Ces notions seront employées dans les classes implémentant les interfaces
spécifiques nommées ci-dessous.

Map : ce type de collection permet de stocker deux éléments de type générique sous la forme clé-valeur. Cela permet
d’avoir un maximum de souplesse dans la gestion de vos objets.

***********************************************************************************************************************/

/* *********************************************************************************************************************
                                           Interfaces de premier niveau
                                          ------------------------------
Implémenter les interfaces de premier niveau va vous permettre de gérer les notions de doublons, de valeurs null, etc.
Pour cela, vous devrez respecter certaines contraintes dans vos collections. Voici les différents types d'interfaces
possibles :

.Set : cette interface permet donc de stocker des objets. Normal, c'est une collection ! Mais les classes implémentant
cette interface ne tolèrent pas les doublons de données. Ainsi, ce genre de collection est tout indiqué pour gérer
des éléments uniques : un calendrier, une liste de cartes à jouer etc.

.List : cette interface se présente sous la forme d'une liste ordonnée qui accepte les valeurs en double. Vous avez donc
intérêt à contrôler parfaitement le contenu de vos données si vous utilisez ce type d'interface !

.Queue : ce type de collections peut s'apparenter à une file d'attente. Ce sera à vous de gérer la façon d'ordonner les
éléments qu'elles contiennent.

.SortedMap : cette interface permet de stocker des éléments ordonnés par ordre croissant, très utile pour des listes de
numéros de téléphone, de dictionnaire etc.
***********************************************************************************************************************/
/* *********************************************************************************************************************
                                               Interfaces de deuxième niveau
                                               --------------------------------
Ce deuxième niveau d'interfaces, présentées ci-dessous, va vous permettre de rajouter des fonctionnalités et/ou
contraintes supplémentaires à vos collections :

.SortedSet : permet aussi d'avoir un stockage ranger par ordre croissant.

.Deque : permet d'insérer et d'enlever des éléments aux deux bouts de la collections, un peu comme une pile de carte.

Avant de vous expliquer comment utiliser toutes ces collections, je vais commencer par vous montrer les fonctionnalités
de base, comme le tri et le parcours. Cependant, si vous ne vous sentez pas à l'aise pour utiliser la généricité sur
les collections, je vous invite fortement à relire la section concernée dans mon cours sur Java.

***********************************************************************************************************************/
/* *********************************************************************************************************************
                                               Les méthodes usuelles
                                          --------------------------------
Avant de clore ce chapitre je vous propose de faire un rapide tour d'horizon sur les méthodes qu’offrent les
interfaces mères. Ce sera rapide et sans douleur, promis. :)

Les méthodes de l'interface Collection
--------------------------------------

Méthode                                              Description

clear()                                              Supprime tous les éléments de la collection.

addAll(Collection<? extends E> c)                    permet d'ajouter tout le contenu d'une autre collection
                                                     dans une nouvelle instance. Retourne true si l'action a abouti.

containsAll(Collection<?> c)                         Retourne true si la collection contient tous les éléments
                                                     de la collection passée en paramètre.

isEmpty()                                            Retourne true si la collection ne contient aucun élément.


removeAll(Collection<?> c)                           Supprime tous les éléments de la collection se trouvant dans la
                                                     collection passée en paramètre.

retainAll(Collection<?> c)                           Ne conserve dans la collection que les éléments présents dans
                                                     la collection passée en paramètre.


Les méthodes de l'interface Map
-------------------------------

Méthode                                               Description

clear()                                               Supprime tous les éléments de la collection.

containsKey(Object key)                               Retourne true si la key passée en paramètre est présente dans la Map.

containsValue(Object value)                           Idem que la méthode ci-dessus mais pour la valeur cette fois.

isEmpty()                                             Retourne true si la Map est vide.

removeAll(Collection<?> c)                            Supprime tous les éléments de la collection se trouvant dans
                                                      la collection passée en paramètre.

putAll(Map<? extends K,? extends V> m)                Remplit la collection avec le contenu de l'objet passé en paramètre.
                                                      Retourne true s'il a réussi.
------------------------------------------------------------------------------------------------------------------------

Il existe aussi une classe qui se nomme Collections, qui contient un bon nombre de méthode usuelles mais qui ne
fonctionnent que sur certaines interfaces. Je vous les présenterai donc au moment opportun. :)

Avant de clore ce chapitre, je tiens à ajouter une dernière chose. Je ne sais pas si vous avez remarqué mais,
depuis le début de ce chapitre, j'instancie mes collections d'une certaine façon :

//La syntaxe en diamant est utilisable depuis Java 7
//Mais ce n'est pas là mon propos ;)

List<Integer> list = new ArrayList<>();
Set<String> set = new TreeSet<>();
Map<Double, Double> map = new HashMap<>();

J'utilise l'interface comme type d'objet, afin de vous faciliter la tâche au cas où vous souhaiteriez changer
d'implémentation... En procédant de la sorte, si vous ne souhaitez plus utiliser une ArrayList mais une LinkedList,
vous n'avez qu'un mot à changer.

C'est une bonne règle de conduite et je vous invite à l'utiliser.

Nous avons vu pas mal de notions importantes ici et vous devriez mieux contrôler vos collections maintenant

que vous savez les parcourir, les trier etc.

Je vous propose maintenant de passer en revue les différentes implémentations en commençant par les List.

***********************************************************************************************************************/



}
