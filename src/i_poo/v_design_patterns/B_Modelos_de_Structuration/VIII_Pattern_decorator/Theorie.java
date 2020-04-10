package i_poo.v_design_patterns.B_Modelos_de_Structuration.VIII_Pattern_decorator;

import java.io.*;

public class Theorie {
  public static void main(String[] args) throws FileNotFoundException {
    /*Vous avez pu remarquer que les objets de ce chapitre utilisent des instances d'objets de même supertype dans
      leur constructeur. Rappelez-vous cette syntaxe :*/

    DataInputStream dis = new DataInputStream(new BufferedInputStream(new FileInputStream(new File("sdz.txt"))));

    /*La raison d'agir de la sorte est simple : c'est pour ajouter de façon dynamique des fonctionnalités à un objet.
      En fait, dites-vous qu'au moment de récupérer les données de notre objetDataInputStream, celles-ci vont d'abord
      transiter par les objets passés en paramètre. Ce mode de fonctionnement suit une certaine structure et une certaine
      hiérarchie de classes : c'est le pattern decorator.

      Ce pattern de conception permet d'ajouter des fonctionnalités à un objet sans avoir à modifier son code source.
      Afin de ne pas trop vous embrouiller avec les objets étudiés dans ce chapitre, je vais vous fournir un autre
      exemple, plus simple, mais gardez bien en tête que les objets du packagejava.ioutilisent ce pattern. Le but du
      jeu est d'obtenir un objet auquel nous pourrons ajouter des choses afin de le « décorer »… Vous allez travailler
      avec un objetGateauqui héritera d'une classe abstraitePatisserie. Le but du jeu est de pouvoir ajouter des couches
      à notre gâteau sans avoir à modifier son code source.

      Vous avez vu avec le pattern strategy que la composition (« A un ») est souvent préférable à l'héritage
      (« Est un ») : vous aviez défini de nouveaux comportements pour vos objets en créant un supertype d'objet par
      comportement. Ce pattern aussi utilise la composition comme principe de base : vous allez voir que nos objets
      seront composés d'autres objets. La différence réside dans le fait que nos nouvelles fonctionnalités ne seront pas
      obtenues uniquement en créant de nouveaux objets, mais en associant ceux-ci à des objets existants. Ce sera cette
      association qui créera de nouvelles fonctionnalités !

      Nous allons procéder de la façon suivante :

          .nous allons créer un objetGateau;

          .nous allons lui ajouter uneCoucheChocolat;

          .nous allons aussi lui ajouter uneCoucheCaramel;

          .nous appellerons la méthode qui confectionnera notre gâteau.

      Tout cela démarre avec un concept fondamental : l'objet de base et les objets qui le décorent doivent être du
      même type, et ce, toujours pour la même raison, le polymorphisme, le polymorphisme, et le polymorphisme !

      Vous allez comprendre. En fait, les objets qui vont décorer notre gâteau posséderont la même méthodepreparer()
      que notre objet principal, et nous allons faire fondre cet objet dans les autres. Cela signifie que nos objets
      qui vont servir de décorateurs comporteront une instance de typePatisserie; ils vont englober les instances les
      unes après les autres et du coup, nous pourrons appeler la méthodepreparer()de manière récursive !

      Vous pouvez voir les décorateurs comme des poupées russes : il est possible de mettre une poupée dans une autre.
      Cela signifie que si nous décorons notregateauavec un objet CoucheChocolatet un objet CoucheCaramel, la situation
      pourrait être symbolisée par la figure suivante.


       _______________              ___________________                   ______________________________________
      |    Gateau    |             |  CoucheChocolat  |                  |    ______________                   |
      |  preparer()  |       +     |    preparer()    |   --------->     |   |    Gateau   |   CoucheChocolat  |
      ---------------              -------------------                   |   |  preparer() |     preparer()    |
                                                                         |   ---------------                   |
                                                                         --------------------------------------

      ______________________________________                            _______________________________________________________________
     |    ______________                   |                           |     ______________________________________                   |
     |   |    Gateau   |   CoucheChocolat  |      ----------------     |    |    ______________                   |                   |
     |   |  preparer() |     preparer()    |  +  | CoucheCaramel |     |    |   |    Gateau   |   CoucheChocolat  |  CoucheCaramel    |
     |   ---------------                   |     |    preparer() | --> |    |   |  preparer() |     preparer()    |    preparer()     |
     --------------------------------------      ----------------      |    |   ---------------                   |                   |
                                                                       |    --------------------------------------                    |
                                                                       ---------------------------------------------------------------

                                           Encapsulation des objets
                                           ------------------------


      L'objet CoucheCaramel contient l'instance de la classe CoucheChocolat qui, elle, contient l'instance de Gateau:
      en fait, on va passer notre instance d'objet en objet ! Nous allons ajouter les fonctionnalités des objets
      « décorants » en appelant la méthode preparer() de l'instance se trouvant dans l'objet avant d'effectuer les
      traitements de la même méthode de l'objet courant, comme à la figure suivante.

      _____________________________________________________________      _____________________________________________________________
     |    ______________________________________                  |     |    ______________________________________                  |
     |   |    ______________                   |                  |     |   |    ______________                   |                  |
     |   |   |    Gateau   |   CoucheChocolat  |  CoucheCaramel   |     |   |   |    Gateau   |   CoucheChocolat  |  CoucheCaramel   |
     |   |   |  preparer() |     preparer()    |    preparer()    |     |   |   |  preparer() |     preparer()    |    preparer()    |
     |   |   ---------------      |  ^         |        |         |     |   |   ---------------      ^  |         |        ^         |
     |   ----------^--------------|--|---------         |         |     |   ----------|--------------|--|---------         |         |
     --------------|--------------|--|------------------|---------      --------------|--------------|--|------------------|---------
                   |              |  |                  |                             |              |  |                  |
                   ---------------   -------------------                              ---------------   -------------------

                      Etape 1                                                Etape 2

                                            Invocation des méthodes
                                            -----------------------

     Nous verrons, lorsque nous parlerons de la classeThread, que ce système ressemble fortement à la pile d'invocations
     de méthodes. La figure suivante montre à quoi ressemble le diagramme de classes de notre exemple.


                                                ----------------------
                                               |   Patisserie        |
                                               |                     |<--------------
                                               | preparer(): String  | 1            |
                                               ----------------------               |
                                                   ^           ^                    |
                                                   |           |                    | tendra una instance de type Patisserie
                                                   |           |                    |
                                                   |           |                    |
                                            ------------    ------------------   1  |
                                            | Gateau   |    |   Couche        | ----
                                            |          |    |                 |
                                            |          |    | pat: Patisserie |
                                            |          |    | nom: String     |
                                            -----------     ------------------
                                                             ^        ^      ^
                                                             |        |      |
                                                             |        |      --------
                                                             |        |             |
                                             -----------------  ----------------  -----------------
                                            | CoucheChocolat |  |CoucheCaramel |  | CoucheBiscuit |
                                            |                |  |              |  |               |
                                            |                |  |              |  |               |
                                            -----------------   ---------------   -----------------

                                                          DIAGRAMME DE CLASSES
*/
  }
}
