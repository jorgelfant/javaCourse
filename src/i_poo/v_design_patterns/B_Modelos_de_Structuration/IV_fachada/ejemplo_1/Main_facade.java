package i_poo.v_design_patterns.B_Modelos_de_Structuration.IV_fachada.ejemplo_1;

public class Main_facade {
  public static void main(String[] args) {
    /*
      Une bonne pratique de conception est d'essayer de limiter le couplage existant entre des fonctionnalités
      proposées par différentes entités. Dans la pratique, il est préférable de développer un petit nombre de
      classes et de proposer une classe pour les utiliser. C'est ce que propose le motif de conception façade.

      Le but est de proposer une interface facilitant la mise en oeuvre d'un ensemble de classes généralement
      regroupées dans un ou plusieurs sous-systèmes. Le motif Façade permet d'offrir un niveau d'abstraction
      entre l'ensemble de classes et celles qui souhaitent les utiliser en proposant une interface de plus haut
      niveau pour utiliser les classes du sous-système.

      //****************************************************************************************************************
      //               Exemple : un client qui utilise des classes d'un sous-système directement
     //*****************************************************************************************************************

     ---------------
    |    Client    |
    ---------------
           |
           |
          ---
          | |             ---------------
          | | ---------> |    ClientA   |
          | |    1       ---------------
          | |  Instancie       | |
          | |                  --
          | |                  |           ---------------
          | | -----------------|--------> |    ClientB   |
          | |     2            |          ---------------
          | |  Instancie       |               | |
          | |                  |               --
          | |                  |               |         ---------------
          | | -----------------|---------------|------> |    ClientC   |
          | |     3            |               |        ---------------
          | |  Instancie       |               |             | |
          | |                  |               |             --
          | |                  |               |             |         ---------------
          | |------------------|---------------|-------------|------> |    ClientD   |
          | |     4            |               |             |        ---------------
          | |  Instancie       |               |             |             | |
          | |                  |               |             |             --
          | |                  |               |             |             |
          | |                  |               |             |             |
          | |----------------> --              |             |             |
          | |      5          | |              |             |             |
          | |  methodeA       | |              |             |             |
          | |                 --               |             |             |
          | |                  |               |             |             |
          | |------------------|---------------|-------------|---------->  --
          | |      6           |               |             |            | |
          | |   methodeD       |               |             |            | |
          | |                  |               |             |            --
          | |------------------|---------------|-----------> --            |
          | |      7           |               |            | |            |
          | |   methodeC       |               |            | |            |
          | |                  |               |            --             |
          | |                  |               |             |             |
          | |------------------|-------------> --            |             |
          | |      8           |              | |            |             |
          | |   methodeB       |              | |            |             |
          | |                  |              --             |             |
          | |                  |              |              |             |
          | |------------------|--------------|---------->  --             |
          | |      9           |              |            | |             |
          | |   methodeC       |              |            | |             |
          --                   |              |            --              |


       Cet exemple volontairement simpliste va être modifié pour mettre en oeuvre le modèle de conception Façade.

       Employer ce modèle aide à simplifier une grande partie de l'interface pour utiliser les classes du sous-système.
       Il facilite la mise en oeuvre de plusieurs classes en fournissant une couche d'abstraction supplémentaire entre
       ces dernières et les classes qui les utilisent. Le modèle Façade permet donc de faciliter la compréhension et
       l'utilisation d'un sous-système complexe que ce soit pour faciliter l'utilisation de tout ou partie du système
       ou pour forcer une utilisation particulière de celui-ci.


                                   -------------                          --------------
                                   |  Client1  |                          |   Client2  |
                                   ------------                           -------------
                                         *                                       *
                                           *                                   *
                                             *                               *
                                               *                           *
                                                 *                       *
                                                   *                   *
                                                     *               *
                                                  ----------------------
--------------------------------------------------|      Facade        |---------------------
|                                                 |--------------------|                    |
|                                                 | + methode1()       |                    |
|                                                 |                    |                    |
|                                                 | + methode2()       |                    |
|                                                 |                    |                    |
|                                                 ---------------------                     |
|                                              *       *   *      *                         |
|                                       *           *      *        *                       |
|                                 *              *         *          *                     |
|                           *                 *            *            *                   |
|                      *                   *               *              *                 |
|                 *                     *                  *                *               |
|            *                       *                     *                  *             |
|      -------------        --------------        --------------       --------------       |
|     |   ClasseA  |       |   ClasseB   |       |    ClasseC  |      |   ClasseD   |       |
|     |------------|       |-------------|       |-------------|      |-------------|       |
|     |            |       |             |       |             |      |             |       |
|     -------------        --------------        --------------       --------------        |
|                                                                                           |
--------------------------------------------------------------------------------------------


  Les classes du sous-système encapsulent les traitements qui seront exécutés par des appels de méthodes de l'objet Façade.
  Ces classes ne doivent pas connaître ni, de surcroît, avoir de référence sur l'objet Façade.


  La façade propose un ensemble de méthodes qui vont réaliser les appels nécessaires aux classes du sous-système pour
  offrir des fonctionnalités cohérentes. Elle propose une interface pour faciliter l'utilisation du sous-système en
  implémentant les traitements requis pour utiliser les classes de celui-ci.

  La classe qui implémente le modèle Façade encapsule les appels aux différentes classes impliquées dans l'exécution
  d'un traitement cohérent. Elle fait donc office de point d'entrée pour utiliser le sous-système.

  Ce modèle requiert plusieurs classes :

       .Le client qui va utiliser la façade
       .La façade
       .Les classes du sous système utilisées par la façade


    Exemple :

   -------------
  |    Client  |
  --------------
        |
        |                   ---------------
       --- --------------> |    Facade   |
       | |      1          ---------------
       | |  Instancie              |
       | |                         |
       | |                        ---
       | |                        | |             ---------------
       | |                        | | ---------> |    ClientA   |
       | |                        | |    1.1     ---------------
       | |                        | |  Instancie       | |
       | |                        | |                  --
       | |                        | |                  |           ---------------
       | |                        | | -----------------|--------> |    ClientB   |
       | |                        | |     2            |          ---------------
       | |                        | |  Instancie       |               | |
       | |                        | |                  |               --
       | |                        | |                  |               |         ---------------
       | |                        | | -----------------|---------------|------> |    ClientC   |
       | |                        | |     3            |               |        ---------------
       | |                        | |  Instancie       |               |             | |
       | |                        | |                  |               |             --
       | |                        | |                  |               |             |         ---------------
       ---                        | |------------------|---------------|-------------|------> |    ClientD   |
        |                         | |     4            |               |             |        ---------------
        |                         | |  Instancie       |               |             |             | |
        |                         | |                  |               |             |             --
        |                         | |                  |               |             |             |
       --- ---------------------> | |                  |               |             |             |
       | |          5             | |----------------> --              |             |             |
       | |       methode1         | |      5.1        | |              |             |             |
       | |                        | |   methodeA      | |              |             |             |
       | |                        | |                 --               |             |             |
       | |                        | |                  |               |             |             |
       | |                        | |------------------|---------------|-------------|---------->  --
       | |                        | |     5.2          |   methodeD    |             |            | |
       | |                        | |   Methode        |               |             |            | |
       | |                        | |                  |               |             |            --
       | |                        | |------------------|---------------|-----------> --            |
       | |                        | |     5.3          |   methodeC    |            | |            |
       ---                        | |   Instancie      |               |            | |            |
        |                         | |                  |               |            --             |
       --- ---------------------> | |                  |               |             |             |
       | |          6             | |------------------|-------------> --            |             |
       | |      methode2          | |     6.1          |   methodeB   | |            |             |
       | |                        | |   Instancie      |              | |            |             |
       | |                        | |                  |              --             |             |
       | |                        | |                  |              |              |             |
       | |                        | |------------------|--------------|---------->  --             |
       | |                        | |     6.2          |   methodeC   |            | |             |
       | |                        | |   Instancie      |              |            | |             |
       --                         --                   |              |            --              |


Le code à utiliser dans la classe client est réduit ce qui va en faciliter la maintenance. La façade masque donc
les complexités du sous-système utilisé et fournit une interface simple d'accès pour les clients qui l'utilisent. */

    TestFacade facade = new TestFacade();
    //facade.classeA.methodeA(); Tamnbien es posible de hacer esto, ya que classeA funciona como variable de la clase TestFacade
    facade.methode1();           //podemos entonces invocar esa variable y luego su metodo si queremos
    facade.methode2();           //la variable de ClasseA que ta en testFacade no esta en private, si lo ponemos en private
  /*                             //podriamos obtenerla con un getter y asi poder usar luego sus metodos etc
    Methode2 :                   //facade.getClasseA.methodeA();   facade.getClasseA daria la variable y asi luego usamos su methode
    - MethodeA ClasseA
    - MethodeD ClasseD
    - MethodeC ClasseC
    Methode1 :
    - MethodeB Classe B
    - MethodeC ClasseC
  */
  }
}
/*
Le modèle Façade peut être utilisé pour :

     .Faciliter l'utilisation partielle d'un sous-système complexe ou de plusieurs classes
     .Masquer l'existence d'un sous-système
     .Ajouter des fonctionnalités sans modifier le sous-système
     .Assurer un découplage entre le client et le sous-système (par exemple pour chaque couche d'une architecture
      logicielle N tiers)

L'utilisation d'une façade permet au client de limiter le nombre d'objets à utiliser puisqu'il se contente simplement
d'appeler une ou plusieurs méthodes de la façade. Ce sont ces méthodes qui vont utiliser les classes du sous-système,
masquant ainsi au client toute la complexité de leur mise en oeuvre.

Il peut être pratique de définir une façade sans état (les méthodes de la façade n'utilisent pas de membres statiques
de la classe) car dans ce cas, une seule et unique instance de la façade peut être définie côté client en mettant en
oeuvre le modèle de conception singleton prévu à cet effet.

Il est possible de proposer des fonctionnalités supplémentaires dans la façade qui enrichissent la mise en oeuvre
du sous-système.

La façade peut aussi être utilisée pour masquer le sous-système. Elle peut encapsuler les classes du sous-système
et ainsi cacher au client l'existence du sous-système. Cette mise en oeuvre facilite le remplacement du sous-système
par un autre : il suffit simplement de modifier la façade pour que le client continue à fonctionner.

Il est possible que toutes les fonctionnalités proposées par les classes du sous-système ne soient pas accessibles
par la façade : son but est de simplifier leurs utilisations mais pas de proposer toutes les fonctionnalités.

Ce motif de conception est largement utilisé.
*/
