package i_poo.v_design_patterns.E_Modelos_GRASP;

public class VII_Fabrication_Pure {
}
//======================================================================================================================
//                    Assigner la responsabilité de certains traitement complexes à de nouvelles classes
//======================================================================================================================
/*
Certaines opérations complexes requièrent un ensemble d'objets génériques qui n'ont aucun rapport avec le domaine
et dont la responsabilité ne peut être assignée à des classes du domaine, afin d'éviter le fort couplage.

La responsabilité doit être assignée à de nouvelles classes, fabriquées expressément pour effectuer l'opération.
*/

//======================================================================================================================
//                                                Exemples
//======================================================================================================================
/*
Bibliothèque
============

Dans un logiciel de gestion de Bibliothèque, la responsabilité de sauvegarder les informations à propos d'un livre
dans une base de données ne doit pas être assignée à la classe Livre elle-même, mais à des classes séparées,
indépendantes (donc plus génériques et réutilisables). Ces classes sont alors utilisées par la classe Livre pour
effectuer la sauvegarde.
*/
