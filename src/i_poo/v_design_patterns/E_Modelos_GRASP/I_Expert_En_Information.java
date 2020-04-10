package i_poo.v_design_patterns.E_Modelos_GRASP;

public class I_Expert_En_Information {
}
//======================================================================================================================
//                     Assigner la requête d'information à la classe détenant l'information
//======================================================================================================================
/*
Le principe de l'expert en information est d'assigner la responsabilité d'une requête à la classe qui détient
les informations nécessaires. Il s'agit de créer la méthode là où les données se trouvent.

Il s'agit d'appliquer le principe « Celui qui sait le fait » ou de mettre les services avec les attributs.
*/

//======================================================================================================================
//                                             Exemples
//======================================================================================================================
/*
Bibliothèque
============
Dans un logiciel de gestion de bibliothèque, nous avons créé les classes Bibliothèque et Catalogue. Nous voulons
ajouter une méthode retournant le livre en fonction de son numéro. À quelle classe assigner cette responsabilité ?

La classe susceptible de détenir les informations nécessaires est la classe Catalogue. On lui ajoute donc cette
méthode de recherche de livre.

Facturation
===========

Dans un logiciel de gestion de vente, nous avons les classes et attributs suivants :

----------------
|   Facture    |
---------------                                          --------------
    Contient un ensemble de produit facturé. Attribut : |   Client    |
                                                        ---------------

------------------
| ProduitFacturé |
------------------                                                 --------------
    Contient un lien vers la description d'un article. Attribut : |   Client    |
                                                                  ---------------

------------------
|     Article    |
------------------                        ------------    ---------------------         ------------------
    Description d'un article. Attributs : |   nom    | , |   prix_unitaire    | (TTC) , |  identifiant   |
                                          ------------   ----------------------         ------------------

À quelle(s) classe(s) assigner la responsabilité de calculer le total de la facture ?

          ------------------
La classe | ProduitFacturé | connaît l'article utilisé et la quantité commandée. On lui ajoute une méthode
          ------------------
----------------                                     -------------
| sousTotal()  | qui demandera le prix unitaire à l' |  Article  |  et le multipliera par la quantité.
----------------                                     -------------
          -----------                                                                           -----------
La classe | Facture | connaît la liste de tous les produits facturés. On lui ajoute une méthode | total() | qui effectue
          -----------                                                                           -----------
                                                                         ------------------                        ----------------
la somme des sous-totaux demandés aux différentes instances de la classe | ProduitFacturé | en appelant la méthode | sousTotal(). |
                                                                         ------------------                        ----------------

Cet exemple illustre comment une responsabilité peut être répartie sur plusieurs classes. Chaque classe est
responsable de la partie qui la concerne.

Cet exemple démontre également que ce patron de conception favorise l'encapsulation : Une classe n'a pas besoin
                                               -----------
de connaître la structure interne de la classe | Facture | pour calculer le montant total dû.
                                               -----------
*/
