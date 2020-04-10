package i_poo.l_interface.jefes_bonus.h;

public class Teorie {

        //Interfaces : ensemble de directives qui doivent respecter les classes
        //Il y a une certaine ressemblance entre une classe abstract et une interface

        //Par exemple nous pouvons avoir une classe exemple 1 et cette classe 1 peut implémenter, inclure, hériter
        //Une interface.

        //Ceci implique que si l’interface a à l’intérieur une série de directrices établies, ces directrices
        //sont obligatoirement dans la classe qui hérite cette interface.

        //Las INTERFACES son un conjunto de directrices que deben cumplir las clases (DIRECTRICE=METHODE)

        /*
         **************
         * INTERFACE
         **************
                |
                |implements
                |
         ***************
         * CLASE EJEMPLO
         ***************
         */

        //Les INTERFACES establecen los comportamientos (directrices) A CUMPLIR EN LAS CLASES

        //Si une interface par exemple a défini à l’intérieur 2 méthodes, la classe qui hérite, implémente cette
        // interface, aura aussi ces 2 méthodes. Quelque chose de semblable à ce que l’on a vu avec les classes abstract
        //Les interfaces établissent le comportement (directrices) à accomplir par les classes qui implémentent ces interfaces

        /*--------------------------------------------------------------------------------------------------------------
         Caractéristiques des interfaces:
         Les interfaces, de même que les classes nous les avons prédéfinies (celles qui viennent dans l’API de java)
         et nous avons aussi des classes propres que nous construisons. C’est pareil avec les interfaces, il y en a
         des prédéfinies dans l’API de java et celles que nous construisons. pour les inclure dans d’autres classes
         que l’on puisse créer.

         *Les interfaces peuvent seulement contenir:
          1. Des méthodes abstract
          2. Des constantes (NO TIENEN VARIBLES)

         * elles sont stockées dans un fichier .class
         * Nous ne pouvons pas les instancier ( pas d'usage new ..)
         * Toutes les methodes son public abstract....Elles ne s'implementent pas ( no se inicializan)


         **************        /-- /METHODOS ABSTRACT/
         * INTERFACE     -----
         **************        \-- /CONSTANTES/

         *Elles peuvent pas avoir avoir des méthodes qui ne soient pas abstract, méthodes implémentées ni variables.
         *Ceci nous rappelle encore ce qu’est une classe abstract.

         *En plus de ces caractéristiques principales des interfaces en java il faut tenir compte du fait que les
         *interfaces de même qu’avec les classes sont stockées dans un fichier.class.

         *A chaque fois que l’on crée une interface au moment de compiler un programme, un fichier.class est généré
         * pour chacune des interfaces que l’on puisse avoir .

         *Il faut aussi savoir que les interfaces ne peuvent pas être instanciées (on peut pas utiliser le new)
          Comme c’était le cas avec une class abstract.

         *toutes les méthodes sont public et abstract et elles sont juste définies (déclarées) comme avec abstract.

         //////////////////////////////////////////////////////////////////////////////////////////////////////////
         * NOUVEAUTE: si l’on ne met pas le modificateur d’acces public et le mot reservé abstract.
         * Ils sont sous entendus. Au moment de créer une méthode, c’est pareil si on met public et abstract
         * car si on ne le met pas c’est sous entendu et c’est comme si on l’avait mis.
         //////////////////////////////////////////////////////////////////////////////////////////////////////////

         *Les interfaces n’ont pas de variables, mais constantes

         *En gros: Les interfaces déterminent le comportement des classes qui vont implementer, hériter de cette interface.
         * Elles ont des méthodes abstract, et elles ne peuvent pas être instanciées. Presque pareil qu’une classe abstract

         /////////SI CECI RESSEMBLE AUTANT A UNE CLASSE ABSTRACT, QUEL EST L'INTERET DES INTERFACES????/////////////////

//----------------------------------------------------------------------------------------------------------------------
//                           RESSEMBLENCES ENTRE ABSTRACT et INTERFACE :
//----------------------------------------------------------------------------------------------------------------------

         1) Une class abstract définissait le comportement de ses sous clases. Les interfaces font qch pareil

         2) Les classes abstract avaient des méthodes abstract, les interfaces pareil , elles ont seulement
            la definition de la méthode.

         3) Une classe qui hérite d’une class abstract est obligée d’implementer, à réécrire la méthode de la class abstract.

         4) Avec une interface c’est la même chose !! si une interface a 2 méthodes on est obligé de réécrire ces
            2 méthodes qui seront toujours abstract.

//--------------------------------------------------------------------------------------------------------------------//
//                           DIFFERENCE SUBTILE entre ABSTRACT et INTERFACE :
//--------------------------------------------------------------------------------------------------------------------//
         * abstract class xxx peuvent accueillir des méthodes pas abstract…une classe abstract avait une
         * méthode abstract et beaucoup d’autres qui n’étaient pas abstract. Dès qu’il y avait une méthode
         * abstract la class devait être abstract.

         *Ça ne se passe pas de la même manière avec les interfaces. Les interfaces ont juste des méthodes abstract.

//--------------------------------------------------------------------------------------------------------------------//
//                           ALORS POURQUOI ON A BESOIN DES INTERFACES?? :
//--------------------------------------------------------------------------------------------------------------------//
         *POUR 2 RAISONS FONDAMENTALES:

         1)La COMPROBATION STRICTE qui fait JAVA

         2)LE PROBLEME de L'HERITAGE SIMPLE

         *On avait vu que JAVA n’admettait pas l’héritage multiple. On ne peut pas avoir une classe qui hérite de
          2 classes à la fois. C++ a l’héritage multiple.

          Ceci était un peu un handicap car le langage avait moins de puissance. Pour régler ce problème et avoir
          qch qui ressemble à l’héritage multiple nous avons les INTERFACES !!!

//--------------------------------------------------------------------------------------------------------------------//
//                                          EJEMPLO
//--------------------------------------------------------------------------------------------------------------------//

         * Dans Usage_employe nous avons une classe Chef,  cette classe Chef hérite à la fois de la classe Employe
         * Imaginons que dans cette situation on veuille donner à la classe Chef un comportement spécial

         * C’est-à-dire que nous voulons etre obligé d’implementer, créer 2 méthodes d’obligado cumplimiento
           en la classe Chef.

         * On pourrait le faire avec une abstract class ??? NON car la classe Chef hérite déjà de la class employe.
         * On pourrait pas créer une abstract class ou se définissent ces 2 méthodes abstract et que chef hérite à
           la fois de cette abstract class pour qu’elle nous oblige à implémenter ces 2 méthodes.

         *Donc si l’on veut donner à la class chef un comportement à suivre (méthodes), ce que l’on fait
         * c’est implémenter (hériter) INTERFACES.

         *On peut implémenter une unique Interface ou on peut dire à la classe Chef d’implementer 2 Interfaces,
         * 3 Interfaces, 4 ou 5, etc parce que on peut implémenter, inclure, hériter d’une unique INTERFACE ou
         * des plusieurs INTERFACES

                   **************
                   * Empleado
                   **************
                         |
                         |extends
                         |
                   ***************   implements    /---//Interface1//
                   *     Chef     ----------------
                   ***************                 \---//Interface2//

         * D’un côté on hérite de la class Employe et d’un autre côté si on a besoin nous pouvons faire
         * que la class Chef implémente, hérite ou inclue 2 INTERFACES qui déterminent le comportement
         * à suivre par la class Chef.

         * De cette manière, si en INTERFACE 1 nous avons 2 méthodes abstract et en INTERFACE 2 nous avons
         * 1 méthode abstract, la class Chef est obligée à implémenter 3 méthodes .


          Class Chef extends Employe implements interface1, interface2

          ON NE PEUT PAS INSTANCIER UNE INTERFACE ( OU UNE CLASS ABSTRACT)
          MAIS NOUS POUVONS UTILISER el principio de substitution  o covariance de variables

          por ejemplo con la interface Comparable no se puede:

          Comparable ejemplo=new Comparable();

          Mais on peut utiliser le principe de substitution comme nous le faisons avec 2 classes
          Employe directeur_commercial=new Chef(«Sandra »,85000, 2011, 05,06) ;

          C'EST à DIRE :

          Comparable exemple=new Empleado(« Antoine »,55000, 1996, 06, 08) ;
          Ceci est possible

          De ce fait, nous pouvons utiliser l’instruction instanceOf pour savoir si une instance (objet)
          appartient à une classe ou pour savoir si une instance (objet) de type interface appartient aussi à une classe

          Par exemple nous avons la class Chef qui hérite de la class Employe et on peut demander avec un if
          Si le nom de l’instance directeur_commercial est une instance de Chef

 Empleado directeur_commercial=new Jefe("Sandra",85000,2011,5,6);      Comparable ejemplo=new Empleado("Luis",75000,2010,5,6);

 if(directeur_commercial instanceOf Jefe){                              if(ejemplo instanceOf emmpleado){


 }                                                                      }

         */

}
