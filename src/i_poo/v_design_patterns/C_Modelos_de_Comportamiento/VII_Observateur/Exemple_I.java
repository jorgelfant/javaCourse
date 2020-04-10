package i_poo.v_design_patterns.C_Modelos_de_Comportamiento.VII_Observateur;

import javax.swing.*;
import java.util.Observable;
import java.util.Observer;

public class Exemple_I {
  public static void main(String[] args) {

  }
}
//======================================================================================================================
//                            OBSERVER : Intercepter un évènement pour le traiter
//======================================================================================================================
/*
Le patron de conception observateur/observable est utilisé en programmation pour envoyer un signal à des modules
qui jouent le rôle d'observateur. En cas de notification, les observateurs effectuent alors l'action adéquate en
fonction des informations qui parviennent depuis les modules qu'ils observent (les "observables").
*/
//======================================================================================================================
//                                               Utilité
//======================================================================================================================
/*
La notion d'observateur/observable permet de découpler des modules de façon à réduire les dépendances aux
seuls phénomènes observés.
*/
//======================================================================================================================
//                                               Utilitation
//======================================================================================================================
/*
Dès que l'on a besoin de gérer des événements, quand une classe déclenche l'exécution d'une ou plusieurs autres.

Dans une interface graphique utilisant MVC (Modèle-Vue-Contrôleur), le patron Observateur est utilisé pour associer
Modèle et Vue.

Par exemple, en Java Swing, le modèle est censé notifier la vue de toute modification en utilisant
PropertyChangeNotification.

Les Java beans sont les observés, les éléments de la vue sont les observateurs. Tout changement dans le modèle est
alors visible sur l'interface graphique.
*/
//======================================================================================================================
//                                               Illustration
//======================================================================================================================
/*
Prenons comme exemple une classe qui produit des signaux (données observables), visualisés à travers des panneaux
(observateurs) d'une interface graphique. On souhaite que la mise à jour d'un signal modifie le panneau qui l'affiche.
Afin d'éviter l'utilisation de threads ou encore d'inclure la notion de panneau dans les signaux il suffit d'utiliser
le patron de conception observateur/observable.

Le principe est que chaque classe observable contienne une liste d'observateurs, ainsi à l'aide d'une méthode de
notification l'ensemble des observateurs sont prévenus. La classe observée hérite de "Observable" qui gère la liste
des observateurs. La classe Observateur est quant à elle purement abstraite, la fonction de mise à jour ne pouvant
être définie que par une classe spécialisée.
*/

//======================================================================================================================
//                                               Exemples
//======================================================================================================================
//L'exemple ci-dessous montre comment utiliser l'API du langage Java qui propose des interfaces et des objets abstraits
// liées à ce patron de conception.

//======================================================================================================================
//           1) On crée une classe qui étend java.util.Observable et dont la méthode de mise à jour
//              des données setData lance une notification des observateurs (1) :
//======================================================================================================================

class Signal extends Observable {
  void setData(byte[] lbData) {
    setChanged(); // Positionne son indicateur de changement
    notifyObservers(); // (1) notification
  }
}

//======================================================================================================================
//           2) On crée le panneau d'affichage qui implémente l'interface java.util.Observer.
//              Avec une méthode d'initialisation (2), on lui transmet le signal à observer (2).
//              Lorsque le signal notifie une mise à jour, le panneau est redessiné (3).
//======================================================================================================================
class JPanelSignal extends JPanel implements Observer {

  void init(Signal lSigAObserver) {
    lSigAObserver.addObserver(this); // (2) ajout d'observeur
  }
  //CLASE DE OBSERVER
  public void update(Observable observable, Object objectConcerne) {
    repaint();  // (3) traitement de l'observation
  }
}
