package i_poo.v_design_patterns.C_Modelos_de_Comportamiento.I_Chain_of_Responsability;

public class Exemple_I {
  public static void main(String[] args) {
//======================================================================================================================
//                                Classe principale de l'application.
//======================================================================================================================
    // Construire la chaîne de responsabilité
    //   StdoutLogger -> EmailLogger -> StderrLogger
    Logger l, l1;
    l1 = l = new StdoutLogger(Logger.DEBUG);//2
    l1 = l1.setNext(new EmailLogger(Logger.NOTICE));//1
    l1 = l1.setNext(new StderrLogger(Logger.ERR));//0

    // Traité par StdoutLogger
    l.message("Entering function y.", Logger.DEBUG);//2
    // Traité par StdoutLogger et EmailLogger
    l.message("Step1 completed.", Logger.NOTICE);//1
    // Traité par les trois loggers
    l.message("An error has occurred.", Logger.ERR);//0
  }
}
//======================================================================================================================
//                                       Chain of Responsibility
//======================================================================================================================
/*
Permettre à un nombre quelconque de classes d'essayer de répondre à une requête sans connaître
les possibilités des autres classes sur cette requête.

Le patron de conception Chaîne de responsabilité permet à un nombre quelconque de classes d'essayer de répondre à
une requête sans connaître les possibilités des autres classes sur cette requête. Cela permet de diminuer le couplage
entre objets. Le seul lien commun entre ces objets étant cette requête qui passe d'un objet à l'autre jusqu'à ce que
l'un des objets puisse répondre
*/

//======================================================================================================================
//                                          Utilisation
//======================================================================================================================
/*
Dès lors qu'une information doit recevoir plusieurs traitements, ou juste être transmise entre différents objets.
*/

//======================================================================================================================
//                                          Variante
//======================================================================================================================
/*
Une variante de ce patron de conception est un arbre de responsabilité, où chaque nœud de traitement transmet
l'objet non plus à un seul autre nœud mais à plusieurs nœuds (exemple : un interpréteur de document XML).
*/
//======================================================================================================================
//                                            EXEMPLE
//======================================================================================================================
//======================================================================================================================
//                            Classe de gestion de journalisation abstraite.
//======================================================================================================================
abstract class Logger {
  public static final int ERR = 0, NOTICE = 1, DEBUG = 2;
  protected int level;
  //L'élément suivant dans la chaîne de responsabilité.
  protected Logger next;

  protected Logger(int level) {
    this.level = level;
    this.next = null;
  }

  public Logger setNext(Logger l) {
    next = l;
    return l;
  }

  public void message(String msg, int priority) {
    if (priority <= level)
      writeMessage(msg);

    if (next != null)
      next.message(msg, priority);
  }
  //abstract method
  abstract protected void writeMessage(String msg);
}

//======================================================================================================================
//                                Journalisation sur la sortie standard.
//======================================================================================================================
class StdoutLogger extends Logger {
  public StdoutLogger(int level) {
    super(level);
  }

  protected void writeMessage(String msg) {
    System.out.println("Writing to stdout: " + msg);
  }
}

//======================================================================================================================
//                                       Journalisation par courriel.
//======================================================================================================================
class EmailLogger extends Logger {
  public EmailLogger(int level) {
    super(level);
  }

  protected void writeMessage(String msg) {
    System.out.println("Sending via email: " + msg);
  }
}

//======================================================================================================================
//                                      Journalisation sur l'erreur standard.
//======================================================================================================================
class StderrLogger extends Logger {
  public StderrLogger(int level) {
    super(level);
  }

  protected void writeMessage(String msg) {
    System.err.println("Sending to stderr: " + msg);
  }
}

