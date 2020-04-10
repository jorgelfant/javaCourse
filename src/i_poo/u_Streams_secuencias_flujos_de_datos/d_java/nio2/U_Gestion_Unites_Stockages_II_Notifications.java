package i_poo.u_Streams_secuencias_flujos_de_datos.d_java.nio2;

public class U_Gestion_Unites_Stockages_II_Notifications {
  public static void main(String[] args) {
    //******************************************************************************************************************
    //                            Les notifications de changements dans un répertoire
    //******************************************************************************************************************
    /*Avant Java 7, pour obtenir des notifications lorsque les éléments d'un répertoire étaient modifiés, il fallait
      développer son propre mécanisme de polling ou utiliser une bibliothèque comme JPathWatch ou JNotify.

      Un polling sur le contenu du répertoire permet de savoir si une modification est intervenue dans les fichiers
      d'un répertoire : ceci consiste à rechercher des modifications de façon périodique en vérifiant le statut de
      tous les fichiers du répertoire par rapport à leur précédent état.

      Java 7 propose l'API WatchService qui offre cette fonctionnalité en standard : NIO2 propose la classe
      WatchService qui permet d'obtenir des événements sur des actions réalisées sur un répertoire surveillé du
      système de fichiers. L'API WatchService est performante mais elle n'est pas récursive.

      L'utilisation de l'API WatchService pour obtenir des notifications requiert la mise en oeuvre de plusieurs étapes :

         .créer une instance de type WatchService

         .enregistrer cette instance auprès du répertoire concerné en précisant le type de notifications auquel on
          souhaite s'abonner (création, modification, suppression). Un objet de type WatchKey est obtenu suite à cet
          enregistrement.

         .utiliser une boucle pour obtenir les événements encapsulés dans un objet de type WatchKey

         .utiliser l'objet de type WatchKey : il faut parcourir et traiter les événements qu'il contient

         .chaque objet de type WatchKey doit être réinitialisé

         .une fois que l'objet WatchService n'est plus utile, il est préférable d'invoquer sa méthode close() pour
          libérer les ressources natives utilisées                                                                    */

  }
}
