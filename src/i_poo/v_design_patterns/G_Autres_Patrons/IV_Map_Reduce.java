package i_poo.v_design_patterns.G_Autres_Patrons;

public class IV_Map_Reduce {
}
//======================================================================================================================
//                          Parallélisation d'un traitement sur des données volumineuses.
//======================================================================================================================
/*
Map-Reduce est le nom d'un framework de Google permettant de paralléliser un traitement sur des données volumineuses
sur plusieurs machines d'un réseau (des nœuds). L'idée de base vient des fonctions Map et Reduce de la programmation fonctionnelle.

Le traitement de déroule en deux étapes principales :

Map
===

Le problème est subdivisé par le nœud principal, en sous-problèmes qui sont soumis aux différents nœuds qui peuvent
à leur tour le subdiviser davantage. Par exemple, pour rechercher une personne dans une base de données distribuée
d'annuaire mondial un nœud pourrait recevoir la tâche de rechercher cette personne dans la base des personnes vivant
en Espagne.

Reduce
======

Les nœuds remontent le résultat du traitement aux nœuds les ayant sollicités. Ces nœuds parents construisent un
résultat et le remonte à leur tour, et ainsi de suite jusqu'au nœud principal. Pour l'exemple précédent, le nœud
peut retourner le numéro de téléphone, le pays de la personne trouvée...
*/
