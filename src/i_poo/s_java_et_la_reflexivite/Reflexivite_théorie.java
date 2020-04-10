package i_poo.s_java_et_la_reflexivite;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class Reflexivite_théorie {
    public static void main(String[] args) {
        /*Java et la réflexivité

        La réflexivité, aussi appelée introspection, consiste à DECOUVRIR DE FACON DYNAMIQUE DES
        INFORMATIONS relatives à une CLASSE ou à un OBJET. C'est notamment utilisé au niveau de
        la machine virtuelle Java lors de l'exécution du programme. En gros, la machine virtuelle
        "stocke les informations relatives à une classe dans un objet".

        "La réflexivité n'est que le moyen de connaître toutes les informations concernant une classe donnée".
        Vous pourrez même créer des instances de classe de façon dynamique grâce à cette notion.

        Ce chapitre va sûrement vous intéresser ! Alors, allons-y…

        L'objet Class
        *************

        Concrètement, que se passe-t-il ? Au chargement d'une classe Java, votre JVM crée automatiquement un objet.
        Celui-ci récupère toutes les caractéristiques de votre classe ! Il s'agit d'un objet Class.

        Exemple : vous avez créé trois nouvelles classes Java. À l'exécution de votre programme, la JVM va créer
        un objet Class pour chacune d'elles. Comme vous devez vous en douter, cet objet possède une multitude de
        méthodes permettant d'obtenir tous les renseignements possibles et imaginables sur une classe.

        Dans ce chapitre, nous allons visiter la classe String. Créez un nouveau projet ainsi qu'une classe contenant
        la méthode main. Voici deux façons de récupérer un objet Class :                                           */

        //objects Class
        Class c1 = String.class; //1ère façon de récupérer l'objet Class
        Class c2 = new String().getClass();
        System.out.println(c1);
        System.out.println(c2);
        //La fameuse méthode finale dont je vous parlais dans le chapitre sur l'héritage
        //Cette méthode vient de la classe Object

        /*Maintenant que vous savez récupérer un objet Class, nous allons voir ce dont il est capable.
        Nous n'allons examiner qu'une partie des fonctionnalités de l'objet Class : je ne vais pas tout
        vous montrer, je pense que vous êtes dorénavant à même de chercher et de trouver tout seuls.
        Vous avez l'habitude de manipuler des objets, à présent.*/

        //**************************************************************************************************************
        //                                Connaître la superclass d'une Class
        //**************************************************************************************************************

        //Voici un petit code qui va répondre à la question de la superclasse :
        System.out.println("La superclasse de la classe " + String.class.getName() + " est : " + String.class.getSuperclass());
        //Qui donne "La superclasse de la classe java.lang.String est : class java.lang.Object"

        /*Notez que la classe Object n'a pas de superclasse. Normal, puisqu'elle se trouve au sommet de la hiérarchie.
        Donc si vous remplacez la classe String de l'exemple précédent par la classe Object, vous devriez obtenir :

        La superclasse de la classe java.lang.Object est : null

        En plus de ça, l'objet Class permet de connaître la façon dont votre objet est constitué :
        interfaces, classe mère, variables…                                                                          */
        System.out.println();

        //**************************************************************************************************************
        //                              Connaître la liste des interfaces d'une classe
        //**************************************************************************************************************

        //On récupère un objet Class
        Class c3 = new String().getClass();
        //Class c = String.class; est équivalent

        //La méthode getInterfaces retourne un tableau de Class
        Class[] faces = c3.getInterfaces();
        //Pour voir le nombre d'interfaces
        System.out.println("Il y a " + faces.length + " interfaces implémentées");
        //On parcourt le tableau d'interfaces
        for (int i = 0; i < faces.length; i++)
            System.out.println(faces[i]);
        /*IMPRIME
            Il y a 3 interfaces implémentées
            interface java.io.Serializable
            interface java.lang.Comparable
            interface java.lang.CharSequence
        */
        System.out.println();
        //**************************************************************************************************************
        //                              Connaître la liste des méthodes de la classe
        //**************************************************************************************************************

        /*La méthode getMethods() de l'objet Class nous retourne un tableau d'objets Method présents dans le package
        java.lang.reflect. Vous pouvez soit faire l'import à la main, soit déclarer un tableau d'objets Method et
        utiliser le raccourci Ctrl + Shift + O.

        Voici un code qui retourne la liste des méthodes de la classe String :                                        */
        Class c4 = new String().getClass();
        Method[] m1 = c4.getMethods();

        System.out.println("Il y a " + m1.length + " méthodes dans cette classe");
        //On parcourt le tableau de méthodes
        for (int i = 0; i < m1.length; i++)
            System.out.println(m1[i]);

        /*Vous pouvez constater que l'objet Method regorge lui aussi de méthodes intéressantes.
        Voici un code qui affiche la liste des méthodes, ainsi que celle de leurs arguments respectifs :*/

        Class c5 = new String().getClass();
        Method[] m2 = c5.getMethods();

        System.out.println("Il y a " + m2.length + " méthodes dans cette classe");
        //On parcourt le tableau de méthodes
        for (int i = 0; i < m2.length; i++) {
            System.out.println(m2[i]);

            Class[] p = m2[i].getParameterTypes();
            for (int j = 0; j < p.length; j++) {
                System.out.println(p[j].getName());
            }
            System.out.println("----------------------------------\n");
        }

        System.out.println();
        //**************************************************************************************************************
        //                 Connaître la liste des champs (variable de classe ou d'instance)
        //**************************************************************************************************************
        /*Ici, nous allons procéder de la même façon qu'avec la liste des méthodes sauf que cette fois,
        la méthode invoquée retournera un tableau d'objets Field. Voici un code qui affiche la liste des
        champs de la classe String.                                                                                   */

        Class c6 = new String().getClass();
        Field[] m = c6.getDeclaredFields();

        System.out.println("Il y a " + m.length + " champs dans cette classe");
        //On parcourt le tableau de Fields
        for (int i = 0; i < m.length; i++)
            System.out.println(m[i].getName());

        System.out.println();
        //**************************************************************************************************************
        //                 Connaître la liste des constructeurs de la classe
        //**************************************************************************************************************
        //Ici, nous utiliserons un objet Constructor pour lister les constructeurs de la classe :
        Class c7 = new String().getClass();
        Constructor[] construc = c7.getConstructors();
        System.out.println("Il y a " + construc.length + " constructeurs dans cette classe");
        //On parcourt le tableau des constructeurs
        for (int i = 0; i < construc.length; i++) {
            System.out.println(construc[i].getName());

            Class[] param = construc[i].getParameterTypes();
            for (int j = 0; j < param.length; j++)
                System.out.println(param[j]);

            System.out.println("-----------------------------\n");
        }
        /*
               Vous constatez que l'objet Class regorge de méthodes en tout genre !
               Et si nous essayions d'exploiter un peu plus celles-ci ?

               Dans un premier temps, créez un nouveau projet avec une
               méthode main ainsi qu'une classe correspondant au diagramme en figure suivante.
               Crearemos una nueva clase

                                       *********************************************
                                       *                   Paire                   *
                                       *********************************************
                                       * valeur1: String                           *
                                       * valeur2: String                           *
                                       *********************************************
                                       * toString(): String                        *
                                       * getValeur1(): String                      *
                                       * getValeur2(): String                      *
                                       * setValeur1(): void                        *
                                       * setValeur2(): void                        *
                                       * Paire(): void                             *
                                       * Paire(val1 : String, val2 : String): void *
                                       *********************************************
        */

    }
}
