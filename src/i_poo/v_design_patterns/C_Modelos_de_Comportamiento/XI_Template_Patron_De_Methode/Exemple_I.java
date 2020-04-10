package i_poo.v_design_patterns.C_Modelos_de_Comportamiento.XI_Template_Patron_De_Methode;

public class Exemple_I {
  public static void main(String[] args) {
    Monopoly mon=new Monopoly();
  }
}
//======================================================================================================================
//                      Définir un modèle de méthode en utilisant des méthodes abstraites
//======================================================================================================================
/*
La technique du patron de méthode est un patron de conception comportemental utilisé en génie logiciel.

Un patron de méthode définit le squelette d'un algorithme à l'aide d'opérations abstraites dont le comportement
concret se trouvera dans les sous-classes, qui implémenteront ces opérations.

Cette technique, très répandue dans les classes abstraites, permet de:

    .Fixer clairement des comportements standards qui devraient être partagés par toutes les sous-classes,
     même lorsque le détail des sous-opérations diffère.

    .Factoriser du code qui serait redondant s'il se trouvait répété dans chaque sous-classe.

La technique du patron de méthode a ceci de particulier que c'est la méthode de la classe parent qui appelle
des opérations n'existant que dans les sous-classes. C'est une pratique courante dans les classes abstraites,
alors que d'habitude dans une hiérarchie de classes concrètes c'est le contraire : ce sont plutôt les méthodes
des sous-classes qui appellent les méthodes de la super-classe comme morceau de leur propre comportement.

L'implémentation d'un patron de méthode est parfois appelée méthode socle parce qu'elle ancre solidement un
comportement qui s'applique alors à toute la hiérarchie de classes par héritage. Pour s'assurer que ce comportement
ne sera pas redéfini arbitrairement dans les sous-classes, on déclare la méthode socle final en Java, ou bien non
virtuelle en C++.

Les méthodes servant de "briques de comportement" à la méthode socle devraient être déclarées abstract en Java,
ou bien virtuelles pures en C++.
*/
//======================================================================================================================
//                                           Diagramme UML
//======================================================================================================================
/*
Le patron de conception Patron de méthode peut être représenté par le diagramme de classes UML suivant :

                                     --------------------------
                                     |    PatronDeMethode     |
                                     --------------------------
                                     |                        |
                                     --------------------------
                                     | + PatronDeMethode(...) |
                                     | + actionA(...)         |
                                     | + actionB(...)         |
                                     | + actionC(...)         |
                                     | + actionD(...)         |
                                     --------------------------
                                                 /\
                                                 |
                                                 |
                                      --------------------------
                                      |        Methode         |
                                      --------------------------
                                      |                        |
                                      --------------------------
                                      | + PatronDeMethode(...) |
                                      | + actionA(...)         |
                                      | + actionB(...)         |
                                      | + actionC(...)         |
                                      --------------------------
                    Diagramme de classes UML du patron de conception Patron de méthode

La méthode patronDeMéthode() appelle les méthodes abtraites ou concrètes. Les méthodes abstraites sont implémentées
par les classes dérivées. Les méthodes concrètes peuvent être redéfinies par les classes dérivées (comportement
différent de celui par défaut).
*/
//======================================================================================================================
//                                             EXEMPLES
//======================================================================================================================

/**
 * Classe abstraite servant de base commune à divers
 * jeux de société où les joueurs jouent chacun leur tour.
 */
abstract class JeuDeSociete {
  protected int nombreDeJoueurs;

  abstract void initialiserLeJeu();
  abstract void faireJouer(int joueur);
  abstract boolean partieTerminee();
  abstract void proclamerLeVainqueur();

  /* Une méthode socle : */
  //METODO QUE NO PUEDE SER MODIFICADO POR LAS SUBCLASES
  final void jouerUnePartie(int nombreDeJoueurs) {
    this.nombreDeJoueurs = nombreDeJoueurs;
    initialiserLeJeu();

    // Premier joueur :
    int j = 0;
    while (!partieTerminee()) {
      faireJouer(j);
      // Joueur suivant :
      j = (j + 1) % nombreDeJoueurs;
    }

    proclamerLeVainqueur();
  }
}

//======================================================================================================================
//                        On peut maintenant dériver cette classe pour implanter divers jeux :
//======================================================================================================================
class Monopoly extends JeuDeSociete {
  /* Implémentation concrète des méthodes nécessaires */

  void initialiserLeJeu() {
    // distribuer les billets, placer les pions, ...
  }

  void faireJouer(int joueur) {
    // lancer le dé, avancer, action selon la case d'arrivée...
  }

  boolean partieTerminee() {
    // il y a un joueur ruiné ou nombre de tours prédéfini écoulé, ...
    return true;
  }

  void proclamerLeVainqueur() {
    // ...
  }

  /* Déclaration des composants spécifiques au jeu du Monopoly */

  // Pions, cases, cartes, billets, ...
}

//======================================================================================================================
//
//======================================================================================================================
class Echecs extends JeuDeSociete {
  /* Implémentation concrète des méthodes nécessaires */

  void initialiserLeJeu() {
    // Placer les pions sur l'échiquier, ...
  }

  void faireJouer(int joueur) {
    // Choisir une pièce, l'avancer, prise ou promotion, ...
  }

  boolean partieTerminee() {
    // Échec et mat ou abandon, ...
    return true;
  }

  void proclamerLeVainqueur() {
    // ...
  }

  /* Déclaration des composants spécifiques au jeu d'échecs */

  // Pions et échiquier, ...
}

/*
La technique du patron de méthode fixe un cadre pour toutes les sous-classes. Cela implique certaines restrictions :
dans l'exemple ci-dessus, on ne peut pas faire hériter une classe JeuDuTarot de la classe abstraite JeuDeSociété,
parce que dans une partie de Tarot, l'ordre des joueurs n'est pas linéaire : il dépend du joueur qui vient de ramasser
le pli.

On peut décider de ne pas déclarer la méthode socle comme final en Java (ou bien décider de la déclarer virtual en C++),
afin de la rendre plus souple. Ainsi la classe JeuDuTarot pourrait parfaitement hériter de la classe JeuDeSociété,
à condition de redéfinir la méthode jouerUnePartie() pour tenir compte des règles du Tarot. Mais cette pratique est
critiquable.

Il est important de se poser la question dès l'écriture de la super-classe : Les sous-classes auront-elles le droit
de redéfinir les comportements fondamentaux codés dans la super-classe ?. L'avantage est bien sûr une souplesse accrue.
L'inconvénient peut être la perte de la cohérence interne de l'objet, si la surcharge des méthodes socles est mal conçue.

Pour reprendre l'exemple précédent, on pourrait mettre en place une méthode qui retourne le prochain joueur, qui serait
implémentée différemment dans la classe JeuDuTarot et dans une classe d'un jeu où chaque joueur joue successivement.
*/
