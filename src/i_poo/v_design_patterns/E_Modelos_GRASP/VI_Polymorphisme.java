package i_poo.v_design_patterns.E_Modelos_GRASP;

public class VI_Polymorphisme {
}
//======================================================================================================================
//                      Utiliser le polymorphisme (dérivation à partir d'une classe de base)
//                      pour avoir un comportement différent selon le type d'objet
//======================================================================================================================
/*
Le polymorphisme est une propriété de la programmation objet où une classe peut définir un comportement par défaut
(une méthode de classe), voire ne définir que la signature de la méthode (classe abstraite). Ce comportement pouvant
être redéfini par des sous-classes afin de le modifier pour certains types d'objets.

Sans le polymorphisme, il serait nécessaire d'utiliser plusieurs tests (instructions if ou switch en général) dans
la méthode afin de définir différents comportement en fonction du type d'objet. L'ajout d'un nouveau type oblige la
modification de la méthode pour ajouter un test et un nouveau comportement.

Dans le cas du polymorphisme, l'ajout d'un nouveau type d'objet implique uniquement la création d'une nouvelle classe
étendant la classe de base par un nouveau comportement. Le polymorphisme permet donc une meilleure extensibilité de
l'application.

Le but du patron polymorphisme est d'assigner la responsabilité du changement de comportement au type (à la classe)
concerné.
*/
