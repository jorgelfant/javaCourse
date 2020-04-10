package i_poo.v_design_patterns.G_Autres_Patrons;

public class III_Post_Redirect_Get {
  public static void main(String[] args) {

  }
}
//======================================================================================================================
//                    Éviter la soumission multiple d'un formulaire web lors d'un rafraichissement
//======================================================================================================================
/*
Le patron de conception Post-Redirect-Get est une solution spécifique au protocole HTTP pour le développement
de serveur web.

Quand un utilisateur soumet un formulaire web (exemples : une commande, une souscription, une nouvelle version de page wiki)
dont l'envoi est de type POST, le navigateur l'envoie avec la méthode POST, et reçoit une confirmation du serveur après
traitement de la requête et du formulaire.
*/
//======================================================================================================================
//                                              Le problème
//======================================================================================================================
/*
  Sans utilisation du patron de conception, les échanges sont les suivants (seule la première ligne est montrée) :

    .L'utilisateur envoi le formulaire (bouton Submit, OK, ...)

    .Client -> Serveur : envoi du formulaire POST ...

    .Le serveur traite le formulaire

    .Serveur -> Client : envoi de la page de confirmation  HTTP/1.0 200 OK

    .Le client affiche la page qu'il vient de recevoir, et l'utilisateur décide de rafraichir la page.

    .Donc le navigateur répète la même requête POST.

    .Client -> Serveur : ré-envoi du formulaire (donc nouveau traitement par le serveur)  POST ...

*/
//======================================================================================================================
//                                              La solution
//======================================================================================================================
/*
  Ce problème est résolu coté serveur en répondant par une redirection :

    .L'utilisateur envoi le formulaire (bouton Submit, OK, ...)

    .Client -> Serveur : envoi du formulaire  POST ...

    .Le serveur traite le formulaire

    .Serveur -> Client : redirection vers la page de confirmation   HTTP/1.0 303 See Other

    .Client -> Serveur : demande avec la nouvelle URL de la page de confirmation en utilisant la méthode GET   GET ...

    .Serveur -> Client : envoi de la page de confirmation  HTTP/1.0 200 OK

    .Le client affiche la page qu'il vient de recevoir, et l'utilisateur décide de rafraichir la page

    .Donc le navigateur répète la même requête GET.

    .Client -> Serveur : rafraichir sans ré-envoi du formulaire  GET ...


    Le client reçoit une redirection au lieu de la page directement en réponse de l'envoi du formulaire.
    Le protocole HTTP spécifie que la redirection de code 303 doit être faite avec la méthode GET, ce que fait
    le client aussitôt pour recevoir la page de confirmation. Si l'utilisateur rafraîchit la page, le formulaire
    n'est plus renvoyé car la redirection a forcé le changement de méthode à GET.

    Le nom du patron de conception donne donc un résumé des premiers échanges effectués (requête POST, réponse REDIRECT,
    requête GET).

*/
