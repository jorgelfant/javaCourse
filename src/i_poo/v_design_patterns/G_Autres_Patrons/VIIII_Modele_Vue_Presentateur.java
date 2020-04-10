package i_poo.v_design_patterns.G_Autres_Patrons;

public class VIIII_Modele_Vue_Presentateur {
}
//======================================================================================================================
//                                Architecture des classes interagissant avec l'utilisateur
//======================================================================================================================
/*
Ce patron de conception est dérivé du patron Modèle-Vue-Contrôleur (MVC) [archive]. Il définit trois types de rôles :

Modèle
======
Les classes représentant les données manipulées à travers l'interface utilisateur.

Vue
===
Les classes présentant une vue des données à l'utilisateur.

Présentateur
============

     Partie communicant avec les deux autres pour traduire et transmettre les commandes de l'utilisateur envoyée de la
     vue vers le modèle et pour formater et afficher les données du modèle dans la vue.

Le principe est de découpler la vue et le modèle, en utilisant le présentateur comme intermédiaire.

Utiliser ce patron permet d'avoir plusieurs vues d'un même modèle (exemple: une table de données sous la forme d'un
tableau modifiable et sous la forme d'un graphique). Et une même vue peut présenter les données de plusieurs modèles
(vue combinée ou synthèse).

Plusieurs vues d'un même modèle peuvent être présentées simultanément. Quand l'utilisateur interagit avec une vue pour
effectuer une modification, la vue transmet la requête au présentateur. Celui-ci la transmet au modèle
(généralement avec transformation des paramètres, ou en appelant plus d'une méthode du modèle). Puis le présentateur
notifie toutes les vues afin de les mettre à jour pour prendre en compte la modification effectuée.
*/
