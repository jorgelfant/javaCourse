package i_poo.v_design_patterns.E_Modelos_GRASP;

public class II_Createur {
}
//======================================================================================================================
//                             Assigner la création d'objets à la classe qui l'utilise
//======================================================================================================================
/*
Le principe du créateur est d'assigner la responsabilité de la création des instances d'une classe A. Cette
responsabilité est assignée à la classe B si au moins l'une des conditions suivantes est vraie :

    .B contient des instances de A,
    .B est une agrégation d'instances de A,
    .B utilise des instances de A de manière détaillée,
    .B possède des informations pour créer des instances de A.
*/
//======================================================================================================================
//                                              Exemples
//======================================================================================================================
/*
Bibliotheque
============
Dans un logiciel de gestion de bibliothèque, nous avons créé les classes Bibliothèque, Catalogue et Livre.
Nous voulons ajouter une méthode de création de livres. À quelle classe assigner cette responsabilité ?

La classe dont l'utilisation est très liée à celle de Livre est la classe Catalogue. On lui ajoute donc cette
méthode de création de livre.

Facturation
============

Dans un logiciel de gestion de vente, nous avons les classes et attributs suivants :

-----------
| Facture |
-----------
                                                        ----------
    Contient un ensemble de produit facturé. Attribut : | client | ,
                                                        ----------
------------------
| ProduitFacturé |
------------------

         Contient un lien vers la description d'un article. Attribut : quantité,

-----------
| Article |
-----------
                                              -------  -----------------        ---------------
        Description d'un article. Attributs : | nom |, | prix_unitaire | (TTC), | identifiant |.
                                              -------  -----------------        ---------------

À quelle(s) classe(s) assigner la responsabilité d'ajouter un nouveau produit facturé (une nouvelle instance
             ------------------
de la classe | ProduitFacturé | ) ?
             ------------------
          -----------                           ------------------
La classe | Facture | contient des instances de | ProduitFacturé |. Elle est donc responsable de leur création.
          -----------                           ------------------


*/
