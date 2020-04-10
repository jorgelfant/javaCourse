package i_poo.v_design_patterns.F_Patrons_DEntreprise;

public class VI_Plugin {
}
//======================================================================================================================
//                      Utiliser des services sans dépendre de l'implémentation
//======================================================================================================================
/*
Une classe peut utiliser les services d'une autre classe sans avoir à dépendre d'une implémentation concrète des
services. Il peut exister plusieurs implémentations de ces services, pour différents contextes d'utilisation
(ex: communication locale, communication distante, ...). Toutes les classes implémentant ces services doivent
implémenter une interface commune qui pourra être utilisée par l'application. Ainsi l'application peut utiliser
n'importe quelle implémentation des services sans avoir à en connaître les détails ni dépendre d'une implémentation
particulière.

L'instance de la classe implémentant l'interface des services est passée à la classe utilisatrice, soit au constructeur
pour maintenir le lien durant la vie de l'objet, soit à la méthode appelée pour une utilisation ponctuelle des services.
*/
