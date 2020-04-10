package i_poo.v_design_patterns.E_Modelos_GRASP;

public class A_Theorie {
  public static void main(String[] args) {

  }
}
//======================================================================================================================
//                                  Patrons de conception/Patrons GRASP
//======================================================================================================================
/*
GRASP signifie General Responsibility Assignment Software Patterns/Principles.

Ces patrons de conception donnent des conseils généraux sur l'assignation de responsabilité aux classes et objets dans une application. Ils sont issus du bon sens de conception, intuitifs et s'appliquent de manière plus générale.

Une responsabilité est vue au sens conception (exemples : création, détention de l'information, ...) :

    .elle est relative aux méthodes et données des classes,
    .elle est assurée à l'aide d'une ou plusieurs méthodes,
    .elle peut s'étendre sur plusieurs classes.

En UML, l'assignation de responsabilité peut être appliquée à la conception des diagrammes de collaboration.

Les patrons de conception GRASP sont les suivants :

.Expert en information
======================
   Affecter les responsabilités aux classes détenant les informations nécessaires.

.Créateur
============
   Déterminer quelle classe a la responsabilité de créer des instances d'une autre classe.

.Faible couplage
================
   Diminuer le couplage des classes afin de réduire leur inter-dépendances dans le but de faciliter la maintenance du code.

.Forte cohésion
===============
   Avoir des sous-classes terminales très spécialisées.

.Contrôleur
============
   Affecter la responsabilité de réception et traitement de messages systèmes.

.Polymorphisme
==============
   Affecter un nouveau comportement à l'endroit de la hiérarchie de classes où il change.

.Fabrication pure
=================
   Créer des classes séparées pour des fonctionnalités génériques qui n'ont aucun rapport avec les classes du domaine applicatif.

.Indirection
============
   Découpler des classes en utilisant une classe intermédiaire.

.Protection
============
   Ne pas communiquer avec des classes inconnues.

*/
