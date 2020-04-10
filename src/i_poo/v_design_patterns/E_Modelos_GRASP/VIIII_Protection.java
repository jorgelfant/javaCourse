package i_poo.v_design_patterns.E_Modelos_GRASP;

public class VIIII_Protection {
}
//======================================================================================================================
//                                    Protected variations / Don't Talk to Strangers :
//         Assigner les responsabilités afin que des variations ne produisent aucun effet indésirable sur le système
//======================================================================================================================
/*
Le but du patron de conception Protection est d'assigner les responsabilités afin que des variations dans des
classes (instabilité) ne produisent aucun effet indésirable sur le reste du système. Ce patron de conception
est utilisé en prévision d'évolutions de l'application logicielle, afin d'éviter que de nouvelles fonctionnalités
ne viennent perturber l'existant.

Pour mettre en œuvre la protection contre les variations, on peut :

     .créer des méthodes pour accéder aux attributs d'une classe,
     .créer une interface pour gérer de nouvelles classes en définissant les méthodes qui pourront être appelées,
     .créer des classes intermédiaires (voir le patron de conception indirection).

Il faut veiller à ne pas trop anticiper les changements possibles afin d'éviter de complexifier la structure de
l'application en créant trop de classes intermédiaires ou d'interfaces.

Ce patron est aussi utilisé en prévision d'évolution de classes externes utilisées dans l'application. Il faut éviter
d'utiliser directement ces classes externes afin de ne pas avoir une forte dépendance. Si une classe externe évolue
(changement de nom de méthode, ou du type d'objet retourné), l'application n'aura pas besoin d'être modifiée en profondeur.
*/

//======================================================================================================================
//                                              Exemples
//======================================================================================================================
/*

Bibliothèque
============

Dans le pseudo-code suivant, l'obtention d'un livre particulier passe par l'utilisation de la classe Collection
(classe que l'on ne connait pas, qui pourrait évoluer, ou ne plus faire partie de l'application) :

                       Collection c = bibliothèque.getCollection();
                       Livre l = c.getLivre("Patrons de conception");

En appliquant le principe du patron de conception protection, la bibliothèque est responsable de l'utilisation
de la classe inconnue pour obtenir un livre particulier :

                       Livre l = bibliothèque.getLivre("Patrons de conception")
*/
