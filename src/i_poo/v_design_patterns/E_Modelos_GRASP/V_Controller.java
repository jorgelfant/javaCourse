package i_poo.v_design_patterns.E_Modelos_GRASP;

public class V_Controller {
}
//======================================================================================================================
//                   Assigner la responsabilité de traiter les messages systèmes (évènements)
//======================================================================================================================
/*
Un contrôleur est une classe qui traite les messages systèmes. Certains messages systèmes sont générés par des
sources externes à l'application en cours de conception.

Il est conseillé d'assigner cette responsabilité :

     .soit à une classe représentant l'organisation globale ou le système global (contrôleur de façade),
     .soit à une classe représentant un acteur du domaine (contrôleur de rôle),
     .soit à une classe artificielle représentant un cas d'utilisation (contrôleur de cas d'utilisation).

Dans la cas des interfaces graphiques, en suggérant la création d'une classe contrôleur séparée, ce patron de
conception encourage le faible couplage en réduisant les dépendances entre l'interface graphique et le modèle.
*/
//======================================================================================================================
//                                             Exemples
//======================================================================================================================
/*
Bibliothèque
============

  Dans un logiciel de gestion de Bibliothèque, la responsabilité de traiter le message "Supprimer tel livre" peut être assigné :

      .soit à la classe Bibliothèque (contrôleur de façade),
      .soit à la classe Libraire (contrôleur de rôle),
      .soit à la classe Suppression (contrôleur de cas d'utilisation).

 */
