package i_poo.v_design_patterns.G_Autres_Patrons;

public class V_Lazy_Evaluation {
}
//======================================================================================================================
//       Retarder l'évaluation d'une fonction ou expression jusqu'à utilisation concrète du résultat
//======================================================================================================================
/*
Avantage : Gagner du temps d'exécution

L'évaluation retardée consiste à ne pas exécuter du code avant que les résultats de ce code ne soient réellement
nécessaires. Cela permet de gagner du temps en évitant de calculer un résultat qui pourrait ne pas être utilisé.

Il peut s'appliquer au calcul des termes d'une série infinie. Seuls les termes utilisés sont calculés. Par opposition,
l'évaluation immédiate nécessiterait le calcul de tous les termes qui ne se terminerait donc pas.

Le patron de conception Copie sur modification est une forme d'évaluation retardée.
*/
