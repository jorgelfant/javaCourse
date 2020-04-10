package i_poo.v_design_patterns.C_Modelos_de_Comportamiento.II_Command;

public class Exemple_I {
  public static void main(String[] args) {
//==================================================================================================================
//                                         6) TEST
//==================================================================================================================
    Light lamp = new Light();
    Command switchUp = new TurnOnCommand(lamp);
    Command switchDown = new TurnOffCommand(lamp);

    Switch s = new Switch(switchUp, switchDown);

    s.flipUp();
    s.flipDown();
    /*RESULTADO
         The light is on
         The light is off
    */
  }
}
//==================================================================================================================
//                               Encapsuler l'invocation d'une commande
//==================================================================================================================
    /*
    Commande est un patron de conception de type comportemental qui encapsule la notion d'invocation.
    Il permet de séparer complètement le code initiateur de l'action, du code de l'action elle-même. Ce patron de
    conception est souvent utilisé dans les interfaces graphiques où, par exemple, un item de menu peut être connecté
    à différentes Commandes de façons à ce que l'objet d'item de menu n'ait pas besoin de connaître les détails de
    l'action effectuée par la Commande.

    À utiliser lorsque : il y a prolifération de méthodes similaires, et que le code de l'interface devient difficile
    à maintenir.

    Symptômes:
        .Les objets possèdent trop de méthodes publiques à l'usage d'autres objets.
        .L'interface est inexploitable et on la modifie tout le temps.
        .Les noms des méthodes deviennent de longues périphrases.

    Un objet Commande sert à communiquer une action à effectuer, ainsi que les arguments requis. L'objet est envoyé
    à une seule méthode dans une classe, qui traite les Commandes du type requis. L'objet est libre d'implémenter le
    traitement de la Commande par un switch, ou un appel à d'autres méthodes (notamment des méthodes surchargées dans
    les sous-classes). Cela permet d'apporter des modifications aux Commandes définies simplement dans la définition
    de la Commande, et non dans chaque classe qui utilise la Commande.
    */

//==================================================================================================================
//                                           Diagramme de classes
//==================================================================================================================
    /*
    Le patron de conception Commande peut être représenté par le diagramme de classes UML suivant :

                                                                       Interface
               -----------------------                           -----------------------
               |     Invocateur      |<>-------------------------|       Commande      |
               -----------------------                           -----------------------
               |                     |                           |                     |
               -----------------------                           -----------------------
               | + evenement1(...)   |                           |                     |
               | + evenement2(...)   |                           | + execute()         |
               -----------------------                           -----------------------
                                                                          /\
                                                                          |
                                                                          |
              -----------------------                            -----------------------
              |     Recepteur       |                            |  CommandeConcrete   |
              -----------------------                            -----------------------
              |                     |                            |                     |
              -----------------------                            -----------------------
              | + actionA(...)      |                            |                     |
              | + actionB(...)      |                            | + execute()         |
              -----------------------                            -----------------------

                        Diagramme de classes UML du patron de conception Commande
    */


//==================================================================================================================
//                                           Utilisations
//==================================================================================================================
/*
Ce patron de conception peut être utilisé pour implémenter divers comportements :

.Défaire sur plusieurs niveaux
       Les actions de l'utilisateur sont enregistrées par empilement de commandes. Pour les défaire, il suffit de
       dépiler les dernières commandes et d'appeler leur méthode undo() pour annuler chaque commande.

.Comportement transactionnel
       La méthode d'annulation est appelée rollback() et permet de revenir en arrière si quelque chose se passe mal au
       cours d'une transaction (un ensemble de commandes). Exemples : installateurs de programmes, modification de base
       de données.

.Barre de progression
       Si chaque Commande possède une méthode d'estimation de durée, il est possible de représenter la progression de
       l'exécution d'un ensemble de tâches (Commandes).

.Menu et boutons (interface graphique)
       En Swing et Delphi, un objet Action est une Commande à laquelle on peut associer un raccourci clavier, une icône,
       un texte d'info-bulle ...

.Wizards
       Pour implémenter les boîtes de dialogue de type Wizard, une instance de Commande est créée. Chaque fois que
       l'utilisateur passe à la page suivante avec le bouton "Suivant" ("Next" en anglais), les valeurs entrées sont
       enregistrées dans la Commande. Le bouton "Terminer" ("Finish" en anglais) provoque l'exécution de la Commande.

.Ensemble de threads (ThreadPool en anglais)
       Un ensemble de threads exécute des tâches (Commandes) stockées dans une file.

.Enregistrement de macros
       Chaque action de l'utilisateur peut être enregistrée sous la forme d'une séquence de Commande qui peut être
       rejouée par la suite. Pour enregistrer les macros sous la forme de scripts, chaque commande possède une méthode
       toScript() pour générer le script correspondant.
*/
//==================================================================================================================
//                                           Exemple
//==================================================================================================================
/*
Considérons un interrupteur simple (switch en anglais). Dans cet exemple, on configure le switch avec deux commandes :
une pour allumer la lumière, et une pour l'éteindre.

L'avantage de cette implémentation particulière du patron Commande est que l'interrupteur peut être utilisé avec
n'importe quel périphérique, pas seulement une lampe. Dans l'exemple suivant l'interrupteur allume et éteint une lampe,
mais le constructeur accepte toute classe dérivée de Command comme double paramètre. On peut, par exemple, configurer
le switch pour démarrer et arrêter un moteur.
*/

//==================================================================================================================
//                                           1) Invocateur
//==================================================================================================================
class Switch {
  private Command flipUpCommand;
  private Command flipDownCommand;

  public Switch(Command flipUpCmd, Command flipDownCmd) {//estos argumentos las clases apagar y prender que a su vez tiene al light dentro
    this.flipUpCommand = flipUpCmd;
    this.flipDownCommand = flipDownCmd;
  }

  public void flipUp() {
    flipUpCommand.execute();
  }

  public void flipDown() {
    flipDownCommand.execute();
  }
}

//==================================================================================================================
//                                           2) Récepteur
//==================================================================================================================
class Light {
  public Light() {
  }

  public void turnOn() {
    System.out.println("The light is on");
  }

  public void turnOff() {
    System.out.println("The light is off");
  }
}

//==================================================================================================================
//                                           3) Commande
//==================================================================================================================
interface Command {
  void execute();
}

//==================================================================================================================
//                        4) Commande concrète pour allumer la lumière
//==================================================================================================================
class TurnOnCommand implements Command {
  private Light theLight;

  public TurnOnCommand(Light light) {
    this.theLight = light;
  }

  public void execute() {
    theLight.turnOn();
  }
}

//==================================================================================================================
//                        5) Commande concrète pour allumer la lumière
//==================================================================================================================
class TurnOffCommand implements Command {
  private Light theLight;

  public TurnOffCommand(Light light) {
    this.theLight = light;
  }

  public void execute() {
    theLight.turnOff();
  }
}
