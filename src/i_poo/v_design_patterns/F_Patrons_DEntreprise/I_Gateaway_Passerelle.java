package i_poo.v_design_patterns.F_Patrons_DEntreprise;

public class I_Gateaway_Passerelle {
}
//======================================================================================================================
//                         Permettre un accès orienté objet à une ressource non objet
//======================================================================================================================
/*
Les logiciels les plus intéressants fonctionnent rarement seuls. Même le système orienté objet le plus pur a souvent
affaire à des choses non objets comme une base de données relationnelle, des transactions, et des structures de
données XML.

On utilise généralement une API spécialisée pour accéder à de telles ressources externes. Ces API sont naturellement
compliquées du fait qu'elles prennent en compte la nature de la ressource. Pour utiliser une ressource (telle une base
de données SQL, ou des données XML), il est nécessaire de comprendre l'API (Par exemple, JDBC pour la base de données,
ou W3C ou JDOM pour le XML). Cela ne fait pas que compliquer la compréhension de l'appplication, mais cela complique
également le changement : passer d'une base de données SQL à une structure XML.

La solution est d'encapsuler le code spécial API dans une classe dont l'interface ressemble à un objet normal. Les
autres objets accèdent à la ressource à travers cette passerelle qui transforme les appels de méthodes en appels
appropriés à l'API spécialisée.
*/
