package i_poo.v_design_patterns.B_Modelos_de_Structuration.VI_Proxy;

public class Exemple_1 {
  public static void main(String[] args) {
    Image image1 = new ProxyImage("HiRes_10MB_Photo1");
    Image image2 = new ProxyImage("HiRes_10MB_Photo2");
    Image image3 = new ProxyImage("HiRes_10MB_Photo3");


    image1.displayImage(); // chargement nécessaire   este objeto tendra un objeto RealImage con su referencia
    image2.displayImage(); // chargement nécessaire   este objeto tendra otro objeto RealImage con una referencia distinta
    image1.displayImage(); // pas de chargement nécessaire, déjà fait
    // la troisième image ne sera jamais chargée : pas de temps gaspillé

    // se vera que image1.displayImage(); ya genero un objeto RealImage, entonces al querer llamar al mismo metodo
    //este vera que el objeto ya existe y regresara el mismo que ya fue creado o mejor dicho su referencia

    /*RESULTADO
       Chargement de HiRes_10MB_Photo1
       Affichage de  HiRes_10MB_Photo1
       Chargement de HiRes_10MB_Photo2
       Affichage de  HiRes_10MB_Photo2
       Affichage de  HiRes_10MB_Photo1
    */
  }
}

//======================================================================================================================
//                                               Proxy  (procuration)
//======================================================================================================================
/*
GERER L'ACCES A UN OBJET

Un proxy est une classe se substituant à une autre classe. Par convention et simplicité, le proxy implémente
la même interface que la classe à laquelle il se substitue. L'utilisation de ce proxy ajoute une indirection à
l'utilisation de la classe à substituer. Le proxy sert à gérer l'accès à un objet, il agit comme un intermédiaire
entre la classe utilisatrice et l'objet.

Un proxy est un cas particulier du patron de comportement État. Un proxy implémente une et une seule interface,
donc se substitue à une seule classe. Un état peut implémenter un nombre quelconque d'interfaces.

Un proxy est utilisé principalement pour contrôler l'accès aux méthodes de la classe substituée. Un état est utilisé
pour changer dynamiquement d'interface.

Outre l'utilisation principale du proxy (contrôle des accès), ce dernier est également utilisé pour simplifier
l'utilisation d'un objet « complexe » à la base. Par exemple, si l'objet doit être manipulé à distance (via un réseau)
ou si l'objet est consommateur de temps.

Il existe différents types de Proxy ayant un comportement ou un rôle différent :

     .Remote proxy : fournir une référence sur un objet situé sur un espace d'adressage différent, sur la même machine
      ou sur une autre,

     .Virtual proxy : retarder l'allocation mémoire des ressources de l'objet jusqu'à son utilisation réelle,

     .Copy-on-write proxy : une forme de proxy virtuel pour retarder la copie de l'objet jusqu'à demande par la
      classe utilisatrice, utilisé notamment pour la modification concurrente par différents threads,

     .Protection (access) proxy : fournir à chaque classe cliente un accès à l'objet avec des niveaux de protection
      différents,

     .Firewall proxy : protéger l'accès à l'objet par des classes « malveillantes » ou vice-versa,

     .Synchronization proxy : fournir plusieurs accès à l'objet synchronisé entre différentes classes utilisatrices
      (cas de threads multiples),

     .Smart reference proxy : fournir des actions supplémentaires à chaque accès à l'objet (compteur de références, ...),

     .Cache proxy : stocker le résultat d'opérations coûteuse en temps, afin de pouvoir les partager avec les différentes
      classes utilisatrices.
*/
//======================================================================================================================
//                                           Diagramme de classes
//======================================================================================================================
/*
  Le patron de conception Proxy peut être représenté par le diagramme de classes UML suivant :

                                       Interface
                                  ----------------------
                                  | InterfaceObjet     |
                                  ----------------------
                                  |                    |
                                  ----------------------
                                  | + fonctionA(...)   |
                                  | + fonctionB(...)   |
                                  ----------------------
                                            /\
                                            |
                                            |
                --------------------------------------------------------------
                |                                                            |
      ----------------------             délègue à                  ----------------------
      |        Proxy       | -------------------------------------> |       Objet        |
      ----------------------                                        ----------------------
      |                    |                                        |                    |
      ----------------------                                        ----------------------
      | + fonctionA(...)   |                                        | + fonctionA(...)   |
      | + fonctionB(...)   |                                        | + fonctionB(...)   |
      ----------------------                                        ----------------------

                      Diagramme de classes UML du patron de conception Proxy

     .La classe cliente utilise l'interface InterfaceObjet pour accéder à l'objet via le Proxy,

     .InterfaceObjet : interface partagée par le Proxy et l'objet accédé,

     .Proxy : contrôle l'accès à l'objet. Chaque méthode délègue sa tâche à l'objet accédé, en contrôlant l'accès
      (vérifications, requête par réseau, ...),

     .Objet : objet accédé indirectement.
*/
//======================================================================================================================
//                                           Exemples
//======================================================================================================================
/*
L'exemple Java suivant implémente un Proxy virtuel. La classe ProxyImage est utilisée pour retarder le long
chargement d'un fichier jusqu'à ce que le chargement soit réellement nécessaire. Si le fichier n'est pas nécessaire,
le chargement coûteux en temps n'a pas du tout lieu.
*/
interface Image {
  public void displayImage();
}
//********************************************************

class RealImage implements Image {
  private String filename;

  public RealImage(String filename) {
    this.filename = filename;
    loadImageFromDisk();
  }

  private void loadImageFromDisk() {
    System.out.println("Chargement de " + filename);
    // Opération potentiellement coûteuse en temps
  }

  public void displayImage() {
    System.out.println("Affichage de  " + filename);
  }
}

//********************************************************

class ProxyImage implements Image {
  private String filename;
  private Image image;

  public ProxyImage(String filename) {
    this.filename = filename;
  }

  public void displayImage() {
    if (image == null) {
      image = new RealImage(filename); // Chargement sur demande seulement
    }
    image.displayImage();
  }
}

