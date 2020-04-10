package i_poo.v_design_patterns.G_Autres_Patrons;

public class VIII_Inversion_Of_Control {
}
//======================================================================================================================
//                  Réduire la dépendance à une séquence d'exécution particulière
//======================================================================================================================
/*
Le contrôle est ici un terme utilisé pour désigner l'ordre d'exécution des instructions d'une fonction ou méthode.

L'inversion de contrôle permet de réduire la dépendance d'une classe à un algorithme particulier ou une configuration
particulière quand les méthodes de cette classe ou d'une autre sont utilisées pour effectuer une fonction complexe.
Ce patron de conception est utilisé par certains frameworks. Plutôt que de définir un ordre fixe d'appel aux
instructions dans une méthode, l'application de l'inversion de contrôle permet de faire appeler les divers traitements
quand cela est nécessaire, par une autre classe (une classe du framework) qui implémente un algorithme particulier ou
une configuration particulière.
*/
//======================================================================================================================
//                                           Exemple
//======================================================================================================================
/*
Une application d'évaluation calcule le coût d'une facture en fonction des données fournies par l'utilisateur
(prix unitaire, description, quantité) pour chaque article acheté, en utilisant un framework d'interface utilisateur.

Une application de type console poserait une série de questions à l'utilisateur dans un ordre particulier, et le prix
est donné à la fin en fonction des données entrées. La séquence est codée dans l'application qui contrôle donc la
séquence d'exécution.

Une application de type graphique définit les différents contrôles de son interface graphique en ayant recours au
framework et le prix s'affiche une fois que l'utilisateur clique le bouton "Évaluer". Coté application, le framework
fait appel aux fonctions de l'application lors de certains évènements (clic du bouton "Ajouter un article", clic du
bouton "Évaluer"). Le contrôle donc est inversé : c'est le framework qui contrôle l'exécution de l'application, et
non plus l'application qui contrôle le framework.

L'injection de dépendance est un cas particulier d'inversion de contrôle concernant la dépendance d'une classe à une
autre.
*/
