package i_poo.v_design_patterns.F_Patrons_DEntreprise;

public class IV_Separeted_Interface {
}
//======================================================================================================================
//                    Définir l'interface dans un paquetage différent de l'implémentation
//======================================================================================================================
/*
La qualité de la structure d'un système peut être améliorer en réduisant le couplage entre les parties du système.
Une solution est de regrouper les classes en paquetages et de contrôler les dépendances entres eux. Des règles de
dépendances peuvent alors être établies et respectées, comme par exemple éviter qu'une classe du domaine ne dépende
d'une classe de la partie présentation.

Cependant, il est parfois nécessaire d'appeler des méthodes en contredisant ces règles de structure. Pour cela,
il suffit de créer une interface dans le même paquetage, et de l'implémenter dans un autre. De cette façon, les
classes utilisant l'interface ne dépendront pas de l'implémentation dont elles ne savent rien.

L'interface séparée fournie un point d'entrée pour une passerelle.
*/
