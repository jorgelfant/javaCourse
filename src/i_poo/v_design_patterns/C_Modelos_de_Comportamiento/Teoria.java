package i_poo.v_design_patterns.C_Modelos_de_Comportamiento;

public class Teoria {
  public static void main(String[] args) {
    /*
    Lorsqu'on parle de pattern, il peut s'agir d'un motif, un modèle, une structure... C'est un phénomène
    que l'on observe de façon répétée, par exemple dans un jeu vidéo, un "boss" possède très souvent des patterns,
    dont il faudra exploiter pour le vaincre.

    Dans Super Mario Bros., Bowser crache des boules de feu et saute à des intervalles réguliers, il suit donc
    certains patterns.

    Dans le développement, un pattern constitue une solution générique pour un type de problème rencontré.

    Selon les personnes, un Design Pattern peut être appelé "motif de conception", "modèle de conception" ou encore
    "patron de conception", mais la signification reste la même.

    Définition
    Finalement un Design Pattern est une solution à un problème récurrent dans la conception d'applications orientées objet.
    Nous allons voir que le Design Pattern Visiteur permet de concevoir un application où il sera facile d’ajouter des
    fonctionnalités à une classe sans la modifier.

    Caractéristiques
    ----------------
    Un Design Pattern est représenté par 4 caractéristiques :
    1) Nom : qui permet de l’identifier clairement
    2) Problématique : description du problème auquel il répond
    3) Solution : description de la solution souvent accompagnée d’un schéma UML
    4) Conséquences : les avantages et les inconvénients de cette solution

    Les 23 Designs Patterns peuvent être regroupés en 3 familles :

    1) Création : ils permettent d’instancier et de configurer des classes et des objets.
    2) Structure : ils permettent d’organiser les classes d’une application.
    3) Comportement : ils permettent d'organiser les objets pour qu’ils collaborent entre eux.

    Comment s'en servir ?
    1) Trouver le problème
    2) Identifier le Design Pattern qui pourrait résoudre le problème
    3) Créer sa propre solution en utilisant la solution générique du Design Pattern

    Il est important de bien identifier le problème de conception avant de choisir un pattern, sinon le
    pattern choisi s'adaptera mal avec le problème et pourrait créer encore plus de problème qu'au départ.

    //******************************************************************************************************************
    //              PRÉSENTATION RAPIDE DU DESIGN PATTERN VISITOR
    //******************************************************************************************************************
    Sa famille:
    Le Design Pattern Visiteur appartient à la famille des patterns comportementaux. Cette famille
    s'intéresse principalement aux comportements entre différents objets, en effet le visiteur est une interface
    définissant de nouvelles opérations sur une autre classe.

    Principe:

    Le Pattern Visiteur permet de séparer des données et les traitements associés pour ces données.
    Ce modèle de conception permet à une classe externe d'être informée du type exact d'instances d'un ensemble de classes.

    En pratique, le modèle de conception visiteur est réalisé de la façon suivante : chaque classe pouvant
    être « visitée » doit mettre à disposition une méthode publique « accepter » prenant comme argument un
    objet du type « visiteur ». La méthode « accepter » appellera la méthode « visite » de l'objet du type
    « visiteur » avec pour argument l'objet visité. De cette manière, un objet visiteur pourra connaître la
    référence de l'objet visité et appeler ses méthodes publiques pour obtenir les données nécessaires au
    traitement à effectuer (calcul, affichage, etc.).

    Il est possible de créer des dérivées de la classe visiteuse, on peut créer autant d’opérations différentes
    pouvant être appliquée à la classe visitée sans avoir à en modifier le code.

    Intérêt:

    On peut facilement ajouter de nouveaux traitements sans toucher à la hiérarchie de nos objets (en POO "classique",
    on aurait implémenté de nouvelles méthodes pour ajouter de nouvelles fonctionnalités). Grâce aux Visiteurs :

    .le code est plus clair (des fonctionnalités différentes se trouvent dans des Visiteurs différents)
    .des équipes différentes peuvent travailler sur des fonctionnalités différentes sans gêner les autres équipes
    .on n'est pas obligé de tout recompiler à chaque ajout d'une fonctionnalité (seul le code du Visiteur est recompilé)
    */

    /******************************************************************************************************************
                           PREMIÈRE ÉTAPE: On définit une interface qui représente un élément.

                          interface CarElement {
                            void accept(CarElementVisitor visitor);
                            // Méthode à définir par les classes implémentant CarElements
                          }
    //*****************************************************************************************************************/
    /******************************************************************************************************************
                           DEUXIEME ÉTAPE: On crée les classes qui étendent de cette interface.   Wheel.java
     Engine.java   Body.java   Car.java
     //****************************************************************************************************************/
    /******************************************************************************************************************
     TROISIEME ÉTAPE: On crée une interface qui représente Visitor que sera "CarElementVisitor"
    //*****************************************************************************************************************/
    /******************************************************************************************************************
     QUATRIEME ÉTAPE: On crée deux classes visitor qui étendent l'interface précédente.
     CarElementPrintVisitor.java
     CarElementDoVisitor.java
     //****************************************************************************************************************/

    /******************************************************************************************************************
     CINQUIEME ÉTAPE: On crée une classe de test pour la démonstration grâce aux deux classes précédentes.
     TestVisitorDemo.java
     //****************************************************************************************************************/

    /******************************************************************************************************************
     SIXIEME ÉTAPE: On vérifie que tout cela fonctionne.
     //****************************************************************************************************************/

  }
}
