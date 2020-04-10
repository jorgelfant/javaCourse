package i_poo.v_design_patterns.A_Modelos_de_Creation.V_SingleTon;

public class Exemple_2 {
  public static void main(String[] args) {


  }
}

//==================================================================================================================
//                                   Singleton (Singleton)
//==================================================================================================================
    /*
    Ce motif de conception propose de n'avoir qu'une seule et unique instance d'une classe dans une application.

    Le Singleton est fréquemment utilisé dans les applications car il n'est pas rare de ne vouloir qu'une seule
    instance pour certaines fonctionnalités (pool, cache, ...). Ce modèle est aussi particulièrement utile pour
    le développement d'objets de type gestionnaire. En effet ce type d'objet doit être unique car il gère d'autres
    objets par exemple un gestionnaire de logs.

    La mise en oeuvre du design pattern Singleton doit :

       .assurer qu'il n'existe qu'une seule instance de la classe
       .fournir un moyen d'obtenir cette instance unique

    Un singleton peut maintenir un état (stateful) ou non (stateless).

    La compréhension de ce motif de conception est facile mais son implémentation ne l'est pas toujours, notamment,
    à cause de quelques subtilités de Java et d'une attention particulière à apporter dans le cas d'une utilisation
     multithreads.

    Ce design pattern peut avoir plusieurs implémentations en Java.

    1) une implémentation classique avec initialisation tardive

       .le ou les contructeurs ont un attribut de visibilité private pour empêcher toute instanciation de l'extérieur
        de la classe : ne pas oublier de redéfinir le constructeur par défaut si aucun constructeur
        n'est explicitement défini

       .l'unique instance est une variable de classe
       .un getter static permet de renvoyer l'instance et de la créer au besoin
       .redefinir la méthode clone pour empêcher son utilisation
       .la classe est déclarée final pour empêcher la création d'une classe fille

    */
final class MonSingleton {

  private static MonSingleton instance;

  private MonSingleton() {
    // traitement du constructeur
  }

  public static MonSingleton getInstance() {

    if (instance == null) {
      instance = new MonSingleton();
    }
    return instance;
  }

  @Override
  public Object clone() throws CloneNotSupportedException {
    throw new CloneNotSupportedException();
  }
}

/*
Cette implémentation est simple mais malheureusement, elle n'est pas threadsafe. Dans un contexte multithreads,
il est possible que les deux premiers appels concomitants puissent créer deux instances. Chaque thread reçoit alors
une instance distincte ce qui ne répond pas aux contraintes du design pattern.

//==================================================================================================================
//                     2) une implémentation thread-safe classique avec initialisation tardive
//==================================================================================================================

Le plus simple et le plus sûr pour éviter ce problème est de sécuriser l'accès au getter avec le mot clé synchronized.

*/
final class MonSingleton2 {

  private static MonSingleton2 instance;

  private MonSingleton2() {
// traitement du constructeur
  }

  public static synchronized MonSingleton2 getlnstance() {
    if (instance == null) {
      instance = new MonSingleton2();
    }
    return instance;
  }

  @Override
  public Object clone() throws CloneNotSupportedException {
    throw new CloneNotSupportedException();
  }
}
/*
Cette solution est thread-safe mais elle induit un coût en terme de performance, lié à la synchronisation de la méthode,
qui peut devenir génant si la méthode est appelée fréquemment de façon concomitante.
*/
//==================================================================================================================
//                     3) une implémentation classique non thread-safe avec initialisation tardive
//==================================================================================================================
/*
La partie qui doit vraiment être thread safe est la création de l'instance ce qui correspond uniquement à la première
invocation de la méthode. Il peut être alors tentant de ne synchroniser que la création de l'instance.
*/

final class MonSingleton3 {

  private static MonSingleton3 instance;

  private MonSingleton3() {
    // traitement du constructeur
  }

  public static MonSingleton3 getInstance() {
    if (instance == null) {
      synchronized (MonSingleton3.class) {
        instance = new MonSingleton3();
      }
    }
    return instance;
  }

  @Override
  public Object clone() throws CloneNotSupportedException {
    throw new CloneNotSupportedException();
  }
}
/*
Le but est d'éviter de poser un verrou sur le moniteur de la classe à chaque invocation de la méthode. Malheureusement,
cette solution n'est pas thread-safe.

Le thread 1 entre dans le bloc securisé et avant l'assignation de la reference créé par le constructeur à la variable
instance, le scheduler passe la main au thread 2 qui teste si l'instance est null et c'est le cas donc il va attendre
la sortie du bloc sécurisé du thread 1 pour exécuter à son tour le bloc de code sécurisé. Les deux threads obtiennent
chacun une instance distincte.
*/

//==================================================================================================================
//           4) une implémentation classique avec initialisation tardive non thread-safe avec double-checked
//==================================================================================================================
/*
Une autre implémentation utilisée est celle nommée double-checked : elle consiste à retester si l'instance est bien
null après la pose du verrou au cas ou un autre thread aurait déjà passé le premier test.
*/
final class MonSingleton4 {

  private static MonSingleton4 instance;

  private MonSingleton4() {
    // traitement du constructeur
  }

  public static MonSingleton4 getInstance() {
    if (instance == null) {
      synchronized (MonSingleton4.class) {
        if (instance == null) {
          instance = new MonSingleton4();
        }
      }
    }
    return instance;
  }

  @Override
  public Object clone() throws CloneNotSupportedException {
    throw new CloneNotSupportedException();
  }
}

/*
Cette solution, elle aussi, peut ne pas fonctionner non plus correctement si le compilateur, par optimisation,
assigne la référence alors que l'objet n'est pas encore initialisé (son constructeur n'est pas encore invoqué).

Ainsi le premier thread pourrait ne pas avoir une instance entièrement initialisée.
*/
//==================================================================================================================
//           5) une implémentation threadsafe avec initialisation au chargement de la classe
//==================================================================================================================
/*
Cette implémentation qui exploite une spécificité de Java est simple, rapide et sûre.
*/
final class MonSingleton5 {

  private static MonSingleton5 instance = new MonSingleton5();

  public static MonSingleton5 getlnstance() {
    return instance;
  }

  private MonSingleton5() {
  }
}

/*
Cette implémentation est thread-safe car les spécifications du langage Java impose à la JVM d'avoir initialisée
une variable static avant sa première utilisation.
*/
//==================================================================================================================
//                     6) une implémentation threadsafe avec initialisation tardive
//==================================================================================================================
/*
L'utilisation d'une classe interne statique permet une initialisation tardive garantie par les spécifications de la JVM.
*/
class MonSingleton6 {

  private MonSingleton6() {
  }

  private static class MonSingletonWrapper {//class interne
    private final static MonSingleton6 instance = new MonSingleton6();
  }

  public static MonSingleton6 getInstance() {
    return MonSingletonWrapper.instance;
  }
}
/*
Il existe plusieurs précautions à prendre lors de la mise en oeuvre du Singleton. Il est tentant d'utiliser
des singletons mais ceux-ci peuvent être à l'origine de certaines difficultés dans des cas biens précis :

     .les tests unitaires : il n'est pas facile de créer des mocks de singletons

     .la distribution de l'application dans plusieurs JVM : l'utilisation du Singleton peut poser des problèmes
      car chaque JVM aura son propre Singleton

     .le singleton peut être récupéré par le ramasse-miettes dans des JVM antérieures à la version 2. La seule
      solution dans ce cas est d'empécher le ramassette-miette de récupérer la mémoire des classes chargées (-Xnoclassgc),
      Ce problème ne concerne pas les JVM 1.3 et supérieures.

     .si la classe est chargée par plusieurs classloaders alors plusieurs instances existeront (une pour chaque classloader).
      Ceci est dû au fait qu'une même classe chargée par deux classloaders sera présente deux fois dans la permgen.

*/
