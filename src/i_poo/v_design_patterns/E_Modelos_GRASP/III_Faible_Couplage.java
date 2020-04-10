package i_poo.v_design_patterns.E_Modelos_GRASP;

public class III_Faible_Couplage {
}
//======================================================================================================================
//                 	Low coupling : Affaiblir la dépendances entre classes et modules
//======================================================================================================================
/*
Le couplage mesure la dépendance entre des classes ou des modules.

Le faible couplage favorise :

    .la faible dépendance entre les classes,
    .la réduction de l'impact des changements dans une classe,
    .la réutilisation des classes ou modules.

Pour affaiblir le couplage, il faut :

    .diminuer la quantité de paramètres passés entre les modules,
    .éviter d'utiliser des variables globales (par exemple, si une mauvaise valeur est assignée, détecter la
     fonction/classe incorrecte est plus difficile), il vaut mieux passer les valeurs en paramètres.
*/
//======================================================================================================================
//                                            	Exemples
//======================================================================================================================
/*
Facturation
***********
Dans un logiciel de gestion de vente, nous avons les classes suivantes :

-----------
| Facture |
-----------
    Contient un ensemble de produit facturé et est associée à un mode de paiement,
------------
| Paiement |
------------
    Décrit un mode de paiement (espèces, chèque, carte bancaire, à crédit, ...),
----------
| Client |
----------
    Effectue les commandes.
                                          ----------
On ajoute une méthode payer() à la classe | Client |. On étudie le couplage dans les deux cas suivants :
                                          ----------
                   -----------                      ------------                        -----------
     1) La méthode | payer() | crée une instance de | Paiement | et l'assigne à l'objet | Facture |.
                   -----------                      ------------                        -----------
                   -----------                              -----------                          ------------
     2) La méthode | payer() | délègue l'action à la classe | Facture | qui crée une instance de | Paiement | et l'assigne.
                   -----------                              -----------                          ------------
                                                            -----------              ----------
Le couplage est plus faible dans le deuxième car la méthode | payer() | de la classe | Client | n'a pas besoin de
                                                            -----------              ----------
                               ------------
savoir qu'il existe une classe | Paiement |, c'est à dire qu'elle ne dépend pas de l'existence ou non de cette classe.
                               ------------
*/
