package i_poo.v_design_patterns.F_Patrons_DEntreprise;

public class V_Registry {
}
//======================================================================================================================
//                    Définir un objet global pour trouver les objets et services communs
//======================================================================================================================
/*
Pour trouver un objet, on commence à partir d'un autre objet en suivant les associations et en navigant dans la
structure de l'application. Par exemple, pour trouver toutes les commandes d'un client, on démarre avec une référence
à l'objet client et on utilise une méthode pour obtenir les commandes passées par celui-ci.

Cependant, il n'y a pas toujours une référence directe à l'objet de départ. Par exemple, on part du numéro du client
sans avoir directement l'objet représentant le client. L'application peut prévoir une classe fournissant le service de
trouver l'objet client à partir d'un numéro, mais il reste à savoir comment obtenir le service lui-même.

La solution est de créer un objet global permettant de trouver les différents services communs de l'application.
Par exemple, avoir un registre des services, dont celui de trouver un client à partir de son numéro.
*/
