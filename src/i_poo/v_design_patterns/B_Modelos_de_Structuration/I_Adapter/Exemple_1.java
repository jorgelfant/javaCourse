package i_poo.v_design_patterns.B_Modelos_de_Structuration.I_Adapter;

public class Exemple_1 {
  public static void main(String[] args) {

    Client client = new Client();

    IDeveloppeur developpeur1 = new DeveloppeurLambda();
    client.Utiliser(developpeur1);

    Architecte architecte = new Architecte();
    IDeveloppeur developpeur2 = new Adaptateur(architecte);
    client.Utiliser(developpeur2);
  }
}

//==================================================================================================================
//     Convertir une interface existante afin de la rendre compatible avec une autre interface
//==================================================================================================================
    /*
    Adaptateur est un patron de conception qui permet de convertir l'interface d'une classe en une autre
    interface que le client attend. Adaptateur fait fonctionner un ensemble de classes qui n'auraient pas
    pu fonctionner sans lui, à cause d'une incompatibilité d'interfaces.

    Exemple:
    -------
       .Vous voulez intégrer une classe que vous ne voulez/pouvez pas modifier.

    Exemple:
    -------
       .Une API tiers convient à votre besoin fonctionnel, mais la signature de ses méthodes ne vous convient pas.
       .Vous voulez normaliser l'utilisation d'anciennes classes sans pour autant en reprendre tout le code.

    //==================================================================================================================
    //                                  Diagramme de classes UML
    //==================================================================================================================
    Le patron de conception Adaptateur peut être représenté par le diagramme de classes UML suivant :
                                 I
                          -----------------
                          | IAdaptateur   |
                          -----------------
                          |               |
                          -----------------
                          | + requete()   |
                          -----------------
                                 /\
                                 |
                                 |
                          -----------------             ---------------------------
                          |  Adaptateur   |             |         Adapté          |
                          -----------------   utilise   ---------------------------
                          |               | ----------->|                         |
                          -----------------             ---------------------------
                          | + requete()   |             | + requêteSpécifique()   |
                          -----------------             ---------------------------

                          Diagramme de classes UML du patron de conception Adaptateur


     .IAdaptateur : Définit l'interface métier utilisée par la classe cliente.

     .Adapté : Définit une interface existante devant être adaptée.

     .Adaptateur : Fait correspondre l'interface de Adapté à l'interface IAdaptateur, en convertissant l'appel
                   aux méthodes de l'interface IAdaptateur en des appels aux méthodes de la classe Adapté.

    //==================================================================================================================
    //                                     Conséquences
    //==================================================================================================================
    Un objet Adaptateur sert de liaison entre les objets manipulés et un programme les utilisant, à simplifier
    la communication entre deux classes. Il est utilisé pour modifier l'interface d'un objet vers une autre interface.

    */
    //==================================================================================================================
    //                              Un adaptateur pour faire un carré aux coins ronds.
    //==================================================================================================================
    interface IDeveloppeur {
      String EcrireCode();
    }

/// <summary> concrétisation normale de "IAdaptateur" par une classe </summary>
class DeveloppeurLambda implements IDeveloppeur {
  public String EcrireCode() {
    return "main = putStrLn \"Algorithme codé\"";
  }
}

//==================================================================================================================
//                            "Adapté" qui n'a pas la signature "IAdaptateur"
//==================================================================================================================
class Architecte {
  public String EcrireAlgorithme() {
    return "Algorithme";
  }
}
    //==================================================================================================================
    //                      "Adaptateur" qui encapsule un objet qui n'a pas la bonne signature</summary>
    //==================================================================================================================

class Adaptateur implements IDeveloppeur {
  Architecte _architecte;

  public Adaptateur(Architecte archi) {
    _architecte = archi;
  }

  public String EcrireCode() {
    return "let main() = printfn \"{0} codé\"" + _architecte.EcrireAlgorithme();
  }
}

    //==================================================================================================================
    //                      "Client" qui n'utilise que les objets qui respectent la signature </summary>
    //==================================================================================================================

class Client {
  void Utiliser(IDeveloppeur developpeur) {
    System.out.println(developpeur.EcrireCode());
  }
}
