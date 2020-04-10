package i_poo.v_design_patterns.A_Modelos_de_Creation.V_SingleTon;

import java.io.Serializable;

public class Exemple_1 {
  public static void main(String[] args) {
    Singleton tic= Singleton.getInstance();
    Singleton toc= Singleton.getInstance();

    System.out.println(tic);
    System.out.println(toc);
    /*
    Singleton@1b6d3586
    Singleton@1b6d3586
    */
    //se crea a cada vez una instancia k apunta al mismo objeto, cada objeto creado tiene la misma referencia

    /* si el consttructor fuera public ( lo cual no es el caso porque asi funciona en Singleton)
     con un constructor clasico cada new Singleton() almacena la referencia en un Singleton de nombre diferente
     lo que hace que cada uno tenga su referencia propia, al constratio del metodo Singleton.getInstance();
     que inicia la misma variable de tipo Singleton una y otra vez "INSTANCE"

    Singleton tic=new Singleton();
    Singleton toc=new Singleton();

    System.out.println(tic);
    System.out.println(toc);
    */
  }
}
//==================================================================================================================
//                                       Singleton
//==================================================================================================================
        /*
        Ne permettre la création que d'une seule instance d'une classe

        Le singleton est un patron de conception dont l'objet est de restreindre l'instanciation d'une classe à un seul
        objet (ou bien à quelques objets seulement). Il est utilisé lorsque l'on a besoin d'exactement un objet pour
        coordonner des opérations dans un système. Le modèle est parfois utilisé pour son efficacité, lorsque le système
        est plus rapide ou occupe moins de mémoire avec peu d'objets qu'avec beaucoup d'objets similaires.

        On implémente le singleton en écrivant une classe contenant une méthode qui crée une instance uniquement
        s'il n'en existe pas encore. Sinon elle renvoie une référence vers l'objet qui existe déjà. Dans beaucoup de
        langages de type objet, il faudra veiller à ce que le constructeur de la classe soit privé ou bien protégé,
        afin de s'assurer que la classe ne puisse être instanciée autrement que par la méthode de création contrôlée.

        Le singleton doit être implémenté avec précaution dans les applications multi-thread. Si deux processus légers
        exécutent en même temps la méthode de création alors que l'objet unique n'existe pas encore, il faut absolument
        s'assurer qu'un seul créera l'objet, et que l'autre obtiendra une référence vers ce nouvel objet.

        La solution classique à ce problème consiste à utiliser l'exclusion mutuelle pour indiquer que l'objet est en
        cours d'instanciation.

        Dans un langage à base de prototypes, où sont utilisés des objets mais pas des classes, un singleton désigne
        seulement un objet qui n'a pas de copies, et qui n'est pas utilisé comme prototype pour d'autres objets.
        */

//==================================================================================================================
//                                       Diagramme de classes UML
//==================================================================================================================
/*La figure ci-dessous donne le diagramme de classes UML du patron de conception Singleton.*/
        /*                                  ==============================
                                            |       Singleton            |
                                            ==============================
                                            | -instance : Singleton      |
                                            ==============================
                                            | -instance()                |
                                            | +getInstance() : Singleton |
                                            ==============================

                               Diagramme de classes UML du patron de conception Singleton                          */
//==================================================================================================================
//                                       Diagramme de classes UML
//==================================================================================================================

/*Voici une solution écrite en Java (il faut écrire un code similaire pour chaque classe-singleton) :*/

class Singleton {
  private static Singleton INSTANCE = null;//es estatica para poder ponerla en el metodo statico sino no se podria
  /*                          variable estatoca en metodo estatico
   * La présence d'un constructeur privé supprime
   * le constructeur public par défaut.
   */
  private Singleton() {
  }
  /*
   * Le mot-clé synchronized sur la méthode de création
   * empêche toute instanciation multiple même par
   * différents threads.
   * Retourne l'instance du singleton.
   */
  public synchronized static Singleton getInstance() {//en cada creacion se estaria iniciando una y otra vez la misma VARIABLE
    if (INSTANCE == null) {                           // constante INSTANCE , osea que su referencia es la misma cada vez
      INSTANCE = new Singleton();// si enviaramos solo new Singleton() ahi si seria una nueva instancia a cada vez
    }//osea lo que tamos haciendo es a cada rato cambiar el contenido de una misma variable INSTANCE (la referencia viene
    return INSTANCE; //del nombre de la instancia INSTANCE
  }
}

/*==================================================================================================================
 Une solution variante existe cependant. Elle consiste à alléger le travail de la méthode getInstance en déplaçant
 la création de l'instance unique au niveau de la déclaration de la variable référant l'instance unique :
 ==================================================================================================================*/

class SingletonVariante {
  /*
   * Création de l'instance au niveau de la variable.
   */
  private static final SingletonVariante INSTANCE = new SingletonVariante();
  /*
   * La présence d'un constructeur privé supprime
   * le constructeur public par défaut.
   */
  private SingletonVariante() {//private para no poder construir el objeto de manera clasica
  }
  /*
   * Dans ce cas présent, le mot-clé synchronized n'est pas utile.
   * L'unique instanciation du singleton se fait avant
   * l'appel de la méthode getInstance(). Donc aucun risque d'accès concurrents.
   * Retourne l'instance du singleton.
   */
  public static SingletonVariante getInstance() {
    return INSTANCE;
  }
}

/*==================================================================================================================
 À noter que la première implémentation est plus lente, étant donné que la méthode getInstance est synchronisée, les
 processus doivent faire la queue alors que le synchronized n'est utile qu'au premier appel, après l'instanciation,
 il n'y a pas d'erreur possible, toutefois il n'y pas d'autres possibilités : faire un verrouillage au niveau de
 l'objet dans la méthode ne suffit pas[1].

 La dernière implémentation a une faille, il est possible, en sérialisant puis en désérialisant la classe d'obtenir
 une seconde instance[2]. Une troisième implémentation permet de pallier ce problème, le singleton est l'unique
 élément d'une énumération.
 ==================================================================================================================*/

enum SingletonVarianteII implements Serializable {
 INSTANCE
}
