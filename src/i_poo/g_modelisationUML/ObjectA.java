package i_poo.g_modelisationUML;

public class ObjectA {
    //Modéliser ses objets grâce à UML: UNIFIED MODELING LANGUAGE , que l'on peut traduire par « langage de modélisation unifié
    //Il s'agit d'une méhode de modélisation
    //Merise en est une autre

    /*il vous sera sans doute utile de pouvoir schématiser vos classes, leur hiérarchie, leurs dépendances,
    leur architecture, etc. L'idée est de pouvoir, d'un simple coup d'œil, vous représenter le fonctionnement de
    votre logiciel : imaginez UML un peu comme une partition de musique pour le musicien.

    Il fallait trouver un langage commun aux commerciaux, aux responsables de projets informatiques et aux développeurs,
    afin que tout ce petit monde se comprenne. Avec UML, c'est le cas.

    En fait, avec UML, vous pouvez modéliser toutes les étapes du développement d'une application informatique, de sa
    conception à la mise en route, grâce à des diagrammes.

    Il existe bien sûr des outils de modélisation pour créer de tels diagrammes. En ce qui me concerne, j'utilise argoUML.
    Il a le mérite d'être gratuit et écrit en Java, donc multi-plates-formes.

    Cependant, il en existe d'autres, comme :

    boUML,

    Together,

    Poseidon,

    Pyut

    etc.

    Avec ces outils, vous pouvez réaliser les différents diagrammes qu'UML vous propose :

    .le diagramme de use case (cas d'utilisation) permet de déterminer les différents cas d'utilisation d'un
     programme informatique ;

    .le diagramme de classes ; c'est de celui-là que nous allons nous servir. Il permet de modéliser des classes
     ainsi que les interactions entre elles ;

    .les diagrammes de séquences, eux, permettent de visualiser le déroulement d'une application dans un contexte donné ;

    et d'autres encore…

    La figure suivante représente un exemple de DIAGRAMME DE CLASSES. VERSION SIMPLIFIEE sans les méthodes etc


                                              ***********************
                                              *      Object         *
                                              ***********************
                                              *                     *
                                              ***********************
                                              * toString(): String  *
                                              ***********************
                                                         ^
                                                         |
                                                         |
                                                         |
                                                         |
                                              ***********************
                                              *      Ville          *
                                              ***********************
                                              * nomVille(): String  *
                                              ***********************
                                              * nomPays() : String  *
                                              ***********************
                                              * nbreHabitants(): int*
                                              ***********************
                                              * decrisToi(): String *
                                              ***********************
                                              * toString(): String  *
                                              ***********************
                                                          ^
                                                          |
                                                          |
                                                          |
                                                          |
                                              ***********************
                                              *      Capitale       *
                                              ***********************
                                              *                     *
                                              ***********************
                                              * toString(): String  *
                                              ***********************

       En effet, dans certains cas, il est utile de modéliser les classes et l'interaction entre celles-ci,
       ne serait-ce que pour disposer de plus de recul sur son travail. Une autre raison à cela est que certains
       concepts de programmation sont plus faciles à expliquer avec un diagramme qu'avec de longs discours...

       Une classe est modélisée sous la forme représentée sur la figure suivante: Classe en UML

                                              ***********************
                                              *      ObjectA        *
                                              ***********************
                                              * numero: int         *
                                              ***********************
                                              * nom : String        *
                                              ***********************
                                              * bool: boolean       *
                                              ***********************
                                              * getNOM(): String    *
                                              ***********************
                                              * setNom(): String    *
                                              ***********************
                                              * afficher(): String  *
                                              ***********************

       *Voici une classe nommée ObjetA qui a comme attributs :

       .numero de type int ;

       .nom de type String ;

       .bool de type boolean.

       *Ses méthodes sont :

        .getNOM() qui retourne une chaîne de caractères ;

        .setNom() qui ne renvoie rien ;

        .afficher() qui renvoie également une chaîne de caractères.


Nous allons voir une autre flèche d'interaction. Je sais que nous n'avons pas encore rencontré ce cas de figure, mais
il est simple à comprendre.

De la même façon que nous pouvons utiliser des objets de type String dans des classes que nous développons, nous pouvons
aussi utiliser comme variable d'instance, ou de classe, un objet que nous avons codé. La figure suivante modélise ce cas.


***********************
*       ObjectA       *
***********************
*  obj: Objectc       *
***********************                           ***********************
*  obj []: ObjectD    *                           *     ObjectC         *
*********************** ----------------------\   **********************
*getObjectC(): ObjectC*                       /   *                     *
***********************                           ***********************
*getObjectD(): ObjectD*                           *                     *
***********************                           ***********************
           ^           ^
           |             *
           |                *
           |                   *
           |                       *
           |                            *
***********************                      *     ***********************
*       ObjectB       *                            *     ObjectD         *
***********************                            ***********************
*                     *                            *                     *
***********************                            ***********************
*                     *                            *                     *
***********************                            ***********************


ObjetA (et donc l'ObjetB) possède une variable de classe de type ObjetC, ainsi qu'une méthode dont le type de retour
est ObjetC (car la méthode retourne un ObjetC). Vous pouvez lire ce diagramme comme suit : l'ObjetA a un ObjetC
(donc une seule instance d'ObjetC est présente dans ObjetA).

Nous devons le lire comme ceci : l'ObjetA est
composé de plusieurs instances d'ObjetD. Vous pouvez d'ailleurs remarquer que la variable d'instance correspondante
est de type tableau…
*/

    //Voici le code Java correspondant à ce diagramme.

    protected ObjectC obj = new ObjectC();//objeto de classe ObjectC
    protected ObjectD[] objD = new ObjectD[10];//10 objetos de tipo ObjectD

    public ObjectC getObj() {
        return obj;
    }

    public ObjectD[] getObjD() {
        return objD;
    }

    //Il est bien évident que ces classes ne font strictement rien. Je les ai utilisées à titre d'exemple pour la modélisation.
    /*
    UML vous permet de représenter les liens entre vos classes.

    .Vous pouvez y modéliser leurs attributs et leurs méthodes.

    .Vous pouvez représenter l'héritage avec une flèche signifiant « est un ».

    .Vous pouvez représenter l'appartenance avec une flèche signifiant « a un ».

    .Vous pouvez représenter la composition avec une flèche signifiant « est composé de ».
    */

}
