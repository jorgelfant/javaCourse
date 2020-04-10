package i_poo.v_design_patterns.G_Autres_Patrons;

public class Generation_Gap {
}
//======================================================================================================================
//	Écart de génération : Créer une sous-classe d'une classe générée automatiquement pour personnaliser le comportement.
//======================================================================================================================
/*
Ce patron de conception est utilisé quand une classe est générée automatiquement par un outil, pour créer une
interface graphique par exemple. Tout ne peut être automatiquement généré, il est forcément nécessaire de spécifier
les détails du comportement de la classe, impossible à générer automatiquement à partir du modèle graphique de l'outil.

Quand le modèle abstrait à partir duquel est généré la classe est modifié, l'outil peut supprimer le code qui a été
modifié quand il régénère la classe. Certains outils marquent avec des commentaires les endroits du code où le développeur
peut modifier le code ; l'inconvénient étant que le compilateur n'interdit pas la modification en dehors des marques.
D'autres outils comparent le code originalement généré au code personnalisé actuel pour ré-appliquer les changements
au nouveau code généré ; mais en général, cela ne fonctionne que si les modifications sont peu nombreuses.

La solution proposée par ce patron de conception est de créer une classe dérivée de celle générée automatiquement et
d'effectuer toutes les personnalisations dans cette sous-classe. Seule la sous-classe dépend de la classe générée.
Toutes les autres classes doivent utiliser cette sous-classe au lieu de la classe générée.

Ce patron s'applique dans les conditions citées précédemment et il faut également que le code régénéré conserve les
attributs et méthodes précédents utilisés par la sous-classe.
*/
