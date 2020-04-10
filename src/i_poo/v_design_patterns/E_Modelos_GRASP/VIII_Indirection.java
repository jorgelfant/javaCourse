package i_poo.v_design_patterns.E_Modelos_GRASP;

public class VIII_Indirection {
}
//======================================================================================================================
//                      Découpler des classes en utilisant une classe intermédiaire
//======================================================================================================================
/*
Afin d'éviter le fort couplage entre deux classes, ou une dépendant à une interface spécifique, il est recommandé
de créer une classe intermédiaire.

Il faut cependant ne pas créer trop de classes intermédiaires afin d'éviter de mauvaises performances (temps/mémoire).
*/

//======================================================================================================================
//                                             Exemples
//======================================================================================================================
/*
Paiement en ligne
=================

La communication avec un serveur bancaire peut se faire grâce à un modem en utilisant des fonctions de l'API
du système d'exploitation. La création d'une classe Modem pour appeler l'API permet d'éviter l'appel à celle-ci
dans les classes communiquant par modem. L'application sera plus facilement portée pour un autre système en ne
changeant que la classe Modem.

*/
