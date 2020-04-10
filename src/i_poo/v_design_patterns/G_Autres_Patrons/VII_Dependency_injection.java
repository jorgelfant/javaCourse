package i_poo.v_design_patterns.G_Autres_Patrons;

public class VII_Dependency_injection {
}
//======================================================================================================================
//
//======================================================================================================================
/*
L'injection de dépendance consiste à éviter une dépendance directe entre deux classes, et définissant dynamiquement la dépendance plutôt que statiquement.

Une classe A dépend d'une autre classe B quand la classe A possède un attribut de type B, ou possède une méthode utilisant la classe B (type de paramètre, valeur de retour, variable locale, appel de méthode de la classe B).

Pour mettre en œuvre l'injection de dépendance :

    .Créer une interface I déclarant les méthodes de la classe B utilisées par la classe A ;

    .Déclarer la classe B comme implémentation de cette interface I ;

    .Remplacer toute référence à la classe B par des références à l'interface I ;

    .Si la classe A instancie des instances de B à son initialisation, alors remplacer l'instanciation par
     un passage d'une instance de l'interface I au(x) constructeur(s) de A ;

    .Si besoin, ajouter une méthode pour spécifier l'instance de l'interface I à utiliser.

//======================================================================================================================
// Bien entendu, l'injection de dépendances ne se limite pas à l'injection par interface. Il existe 4 types
// d'injections de dépendances :
//======================================================================================================================


     1) injection par constructeur ;
     2) injection par interface ;
     3) injection par mutateur ;
     4) injection par champs.

     Toutes ces injections ne seront pas abordées puisque les bibliothèques Java ne supportent pas tous les types
     d'injection. Si vous êtes intéressés par une injection spécifique, des nombreuses ressources sont disponibles
     sur internet.

===============================================

===============================================
erface. Les interfaces en java permettent
interfaces sont ensuites implémentées par


asse A ne dépend donc plus de B directement


-----------------------                 --------------------
|     Classe A        |                 |    Classe B      |
-----------------------   DEPENDANCE    --------------------
|                     |---------------->|                  |
|                     |                 |                  |
-----------------------                 --------------------

               public class A {
                  public static void main(String[] args)
                     B b = new B();
                     b.someMethod();
                  }
               }

Avantages :
Rapide à developper
Inconvénients :
Statique
Disperse les dépendances dans le code

//======================================================================================================================
                                            Les interfaces :
//======================================================================================================================

Le java fournit un moyen de simplifier la gestion des dépendances : l'Interface. Les interfaces en java permettent de
définir des méthodes et leurs paramètres sans en définir le code. Ces interfaces sont ensuites implémentées par les
classes dont on dépend.

Ici, on crée une interface I définissant la méthode someMethod() et la classe A ne dépend donc plus de B directement
mais de I qui peut être implémenté par n'importe quelle autre classe.

-----------------------                 --------------------              ---------------------
|     Classe A        |                 |    Interface I   |              |    Classe B       |
-----------------------                 --------------------  implemente  ---------------------
|                     |---------------->|                  |<-------------|                   |
|                     |                 |                  |              |                   |
-----------------------                 --------------------              ---------------------
           |                                                                         /\
           |                                                                         |
           ---------------------------------------------------------------------------
                                                 DEPENDANCE

Cela se fait donc dans le code de A comme suit :

                public class A {
                   public static void main(String[] args)
                      I b = new B();
                      b.someMethod();
                   }
                }

Comme nous pouvons le constater, nous avons gardé le new ce qui fait qu'il reste une dépendance indirecte dans A.

Avantages :
  .Toujours rapide à developper
  .Possibilité de changer d'implémentation
Inconvénients :
  .Dépendance toujours là
  .Disperse les dépendances dans le code


//======================================================================================================================
                                            Les Factories :
//======================================================================================================================
Afin d'avoir du code java propre, la comunauté java à instauré des principes de programmations. Ces principes sont
appelés des Design Pattern. Parmis ces design pattern on peut trouver le pattern factory. Ce pattern permet d'avoir
une classe factory qui va gérer les dépendances. Cette factory possède des méthodes qui vont instancier la dépendance
(ici B) et la retourner. Chaque fois qu'une dépendance devra être résolue (besoin d'un objet de type I) , la classe
appelante utilisera la factory.

-----------------------                 --------------------              ---------------------
|     Classe A        |                 |    Interface I   |              |    Classe B       |
-----------------------                 --------------------  implemente  ---------------------
|                     |---------------->|                  |<-------------|                   |
|                     |                 |                  |              |                   |
-----------------------                 --------------------              ---------------------
          |                                                                          /\
          |                             --------------------                         |
          ----------------------------->|      Factory     |-------------------------
                                        --------------------   DEPENDANCE
                                        |                  |
                                        |                  |
                                        --------------------

Cela se fait donc dans le code de factory comme suit :
=====================================================

               public class factory {
                  public I getDependency()
                     return new B();
                  }
               }

Et dans A :
===========
              public class A {
                 public static void main(String[] args) {
                    I b = new factory().getDependency();
                    b.someMethod();
                 }
              }

Avantages :
   .Possibilité de changer d'implémentation
   .Centralisation des dépendances à un seul endroit
Inconvénients :
   .Lourd à utiliser
   .Pas connu par tous les développeurs


//======================================================================================================================
                                       L'injection par constructeur :
//======================================================================================================================
Les developpement d'applications java ayant besoin de plus en plus de tests, l'injection par factory ne suffit plus.
Effectivement, cette dernière ne permet pas d'avoir une configuration de production et une configuration de tests.
Une solution pour permettre de choisir le mode de lancement (configuration) est de passer l'implémentation directement
dans le constructeur de notre classe (ici A)


-----------------------
|     Super classe    |
-----------------------
|                     |
|                     |
-----------------------
          |
          |
          \/
-----------------------                 --------------------              ---------------------
|     Classe A        |                 |    Interface I   |              |    Classe B       |
-----------------------                 --------------------  implemente  ---------------------
|                     |---------------->|                  |<-------------|                   |
|                     |                 |                  |              |                   |
-----------------------                 --------------------              ---------------------


Cela se fait donc dans le code de A comme suit :
==============================================

                      public class A {
                         I inst;

                         public A(I inst) {
                            this.inst=inst;
                         }

                         public void doWork() {
                            inst.someMethod();
                         }
                      }

Et dans la classe appelante :
============================

                     public static void main(String[] args) {
                        A a = new A(factory().getDependency());
                        a.doWork();
                     }

Avantages :
==========
  .Possibilité de changer d'implémentation
  .Possibilité de gérer les dépendances au plus haut de l'application
Inconvénients :
=============
  .Dispersion du code (classes et sous classes)

Cette méthode est l'une des plus "propre" et des plus pratique pour faire de l'injection de dépendance. Cependant,
des frameworks existent pour éviter au developpeur de gérer ses injections.

//======================================================================================================================
                                       Les frameworks
//======================================================================================================================
Il existe peu de frameworks pour faire de l'injection de dépendances, je ne présenterai que les 2 plus grands
frameworks et les plus récents sur ce site.

Voici certains frameworks recencés à ce jour :
  .PicoContainer (injection par constructeur)
  .Excalibur (injection par Interface): anciennement connu sous le nom d'Avalon
  .Spring IoC (injection par mutateur)
  .Google Guice (injection par champs et constructeur)
*/


