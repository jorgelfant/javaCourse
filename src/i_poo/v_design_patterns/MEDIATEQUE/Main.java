package i_poo.v_design_patterns.MEDIATEQUE;

import java.util.*;

public class Main {
  public static void main(String[] args) {


    Mediatheque mediatheque = new Mediatheque();
    ArrayList<Document> docs = mediatheque.getDocs();

    Livre un = (Livre) docs.get(0);
    Livre deux = (Livre) docs.get(1);
    Livre trois = (Livre) docs.get(2);
    Livre quatre = (Livre) docs.get(3);
    Livre cinq = (Livre) docs.get(4);
    CD seis = (CD) docs.get(5);

    //HACEMOS UN TEST EN CASO DE QUE SE SEA ADHERANT O NO
    Mediatheque.Adherant ad = null;
    try {
      ad = mediatheque.verificationAd("jorgelu5");
    } catch (Exception e) {
      System.out.println("error");
    } finally {
      if (ad != null) {
        ad.emprunterLivre(un);
        ad.emprunterLivre(deux);
        ad.emprunterLivre(trois);
        ad.emprunterLivre(quatre);
        ad.emprunterLivre(cinq);
        ad.emprunterCD(seis);
      } else {
        System.out.println("Vous n'êtes pas adhérant dans notre médiathèque");
      }
    }
    System.out.println();
    System.out.println(ad);
    //ad.emprunterLivre(toc.estDisponible(mediatheque));


    /*
    EmpruntLivre hey = new EmpruntLivre(libro);
    System.out.println(hey.estEnRetard());
    System.out.println();

    System.out.println(libro.estDisponible(tic));
*/
    /*
    tic.verificationAd("fgf");
*/
  }
}
/*
Objectif(s) : Héritage simple

//----------------------------------------------------------------------------------------------------------------------
//                                             Médiathèque
//----------------------------------------------------------------------------------------------------------------------


Exercice 1. Médiathèque :
*************************

On souhaite réaliser un programme permmettant de gérer les adhérents d’une médiathèque et leurs emprunts. On considère
les règles de gestion suivantes :

        – les documents gérés sont de deux types : livre ou CD ;
        – un document est identifié par un numéro ;
        – un document a un titre ;
        – un CD est un document qui a un interprète et un compositeur ;
        – un livre est un document qui a un auteur ;
        – certains documents sont empruntables, d’autres non (ils sont seulement consultables sur place).
        – Un adhérent peut avoir jusqu’à cinq emprunts en cours qui seront indifféremment des livres et des CDs.
          Il ne peut emprunter de documents que s’il n’est pas en retard pour l’un de ses emprunts ;
        – Un adhérent peut garder un livre pendant trois semaines mais ne peut garder un CD que deux semaines.




                                                                                  --------------------------
                                                                                  |      Personne          |
                                                                                  --------------------------
                                                                                  |                        |
                                                                                  |  - lista: List         |
                                             -------------------------------------|  + tomar : Prestamo    |
                                             |                                    |  + devolver : Prestamo |
                                             |                                    |  + consultar : Prestamo|
                                             |                                    -------------------------
                                             |                                               /\
                                             |                                               |
                                             |                                ------------------------------
                                             |                               |                             |
                                             |                    ---------------------------      --------------------
                                             |                    |        Adherente        |      |   NonAdherente   |
                                             |                    ---------------------------      --------------------
                                             |                    |                         |      | - autor : String |
                                             |                    |                         |      |                  |
                                             |                    | - AccionAd : Documento  |      |                  |
                                             |                    |                         |      |                  |
                                             |                    |                         |      |                  |
                                             |                    ---------------------------      --------------------
                                             |
                                            \/
                                         Interface
                                   ---------------------
                                   |      AccionAd     |
                                   ---------------------
                                   |                   |
                                   | * accion(Doc doc) |
                                   |                   |
                                   ---------------------
                                            /\
                                            |
             -----------------------------------------------------------------
            |                               |                                |
 ---------------------------    ---------------------------    ---------------------------
 |        Prestamo         |    |        Consulta         |    |        Devolucion       |
 ---------------------------    ---------------------------    ---------------------------
 |                         |    |                         |    |                         |
 | * accion(Doc doc)       |    | * accion(Doc doc)       |    | * accion(Doc doc)       |
 |                         |    |                         |    |                         |
 |                         |    |                         |    |                         |
 ---------------------------    ---------------------------    ---------------------------






                                                                     ---------------------------
                                                                     |        Documento        |
                                                                     ---------------------------
                                                                     | - id : int              |
                                                                     | - titulo : String       |
                                                                     ---------------------------
                                                                     |                         |
                                                                     | +toString() : void      |
                                                                     | *tomarPrestado() : void |
                                                                     | *serConsultado() : void |
                                                                     | *serDevuelto() : void   |
                                                                     ---------------------------
                                                                                 /\
                                                                                 |
                                                                       ------------------------
                                                                      |                       |
                                               -------------------------                   --------------------
                                               |        Livre          |                   |       CD         |
                                               -------------------------                    -------------------
                                               | - Interprete : String |                   | - autor : String |
                                               | - compositor : String |                   |                  |
                                               |                       |                   |                  |
                                               |                       |                   |                  |
                                               |                       |                   |                  |
                                               -------------------------                   --------------------


*/
// Les documents
// *************

/*======================================================================================================================
   Question 1.1. Construire une classe Document qui satisfait les règles ci-dessus. Penser à respecter le principe
   d’encapsulation (cf. cours). Redéfinir la méthode toString(), qui retourne un objet de type String décrivant l’état
   de l’objet au moment de l’appel.
======================================================================================================================*/
abstract class Document implements Comparable<Document> {
  private int id;
  private String titre;

  //constructor
  public Document(int id, String titre) {
    this.id = id;
    this.titre = titre;
  }

  //**************************
  public void setId(int id) {
    this.id = id;
  }

  //**************************
  public int getId() {
    return this.id;
  }

  //**************************
  public void setTitle() {
    this.titre = titre;
  }

  //**************************
  public String getTitle() {
    return this.titre;
  }

  //ESTE SERA EL ORDEN DE BASE
  public int compareTo(Document o2) {
    return this.getClass().getSimpleName().compareTo(o2.getClass().getSimpleName());
  }

  public String toString() {
    return "Document: " + this.getClass().getSimpleName() + ", ID: " + this.id + ", titre: " + this.titre;
  }


  public boolean estDisponible(Mediatheque mediatheque) {
    String docName = this.getTitle();
    if (mediatheque.getDocByTitle(docName) != null) {
      return true;
    }
    return false;
  }

  public boolean emprunter(Mediatheque mediatheque) {
    return true;//emprunt effectué
  }

  public abstract void execute();
}

/*======================================================================================================================
   Question 1.2. Construire les classes Livre et CD qui dérivent de la classe Document, et satisfont les régles de
   gestions cidessus. Penser toujours à respecter le principe d’encapsulation. Tester ces classes.

   Question 1.3. Ajouter les méthodes suivantes (attention au choix de la classe de définition) :
     – public boolean estEmpruntable()
     – public boolean emprunter() qui retourne TRUE ou FALSE selon que l’emprunt a pu être effectué ou pas.
======================================================================================================================*/
//----------------------------------------------------------------------------------------------------------------------
//                                           Livre
//----------------------------------------------------------------------------------------------------------------------
class Livre extends Document {
  private String auteur;

  //constructeur 1
  public Livre(int id, String titre, String auteur) {
    super(id, titre);
    this.auteur = auteur;
  }

  //constructeur 2 qui va appeler constructeur 1
  public Livre(int id, String titre) {
    this(id, titre, "auteurInconnu");
  }

  public void setAuteur(String auteur) {
    this.auteur = auteur;
  }

  public String getauteur() {
    return this.auteur;
  }

  public String toString() {
    return super.toString() + ", auteur" + this.auteur;
  }

  public void execute() {

  }
}

//----------------------------------------------------------------------------------------------------------------------
//                                    CD con su builder
//----------------------------------------------------------------------------------------------------------------------
class CD extends Document {
  private String interprete;
  private String compositeur;


  private CD(int id, String titre, String interprete, String compositeur) {
    super(id, titre);
    this.interprete = interprete;
    this.compositeur = compositeur;
  }

  //BUILDER
  public static class builderCD {
    private int id;
    private String titre;
    private String interprete;
    private String compositeur;

    //constructeur
    public builderCD(int id, String titre) {
      this.id = id;
      this.titre = titre;
      this.interprete = "interpreteInconnu";
      this.compositeur = "compositeurInconnu";
    }

    //**************************
    public builderCD getInterprete(String interprete) {
      this.interprete = interprete;
      return this;
    }

    //**************************
    public builderCD getCompositeur(String compositeur) {
      this.compositeur = compositeur;
      return this;
    }

    public CD regresaCd() {
      return new CD(id, titre, interprete, compositeur);
    }
  }
  //**********fuera del builder*********************

  public void setInterprete(String interprete) {
    this.interprete = interprete;
  }

  public String getInterprete() {
    return this.interprete;
  }

  //**************************
  public void setCompositeur(String compositeur) {
    this.compositeur = compositeur;
  }

  public String getCompositeur() {
    return this.compositeur;
  }

  public String toString() {
    return super.toString() + ", compositor: " + this.getCompositeur() + ", interprete: " + this.getInterprete();
  }

  public void execute() {

  }
}

/*======================================================================================================================
   Question 1.4. Construire une classe Mediatheque qui permet de gérer un ensemble de documents, en utilisant un tableau.
   Cette classe doit être munie des fonctionnalités publiques suivantes :
        – ajout d’un document quelconque
        – recherche d’un document par titre
        – recherche de tous les livres d’un auteur donné
        – recherche de tous les CD d’un interprète ou compositeur donné
//====================================================================================================================*/

class Mediatheque {

  private ArrayList<Document> documents = new ArrayList<>();//tab de cdocuments
  private ArrayList<Adherant> adherants = new ArrayList<>();//tab de Adherants
  private static int numAdherantStatic;//ponemos aqui la static porque la clase interna para poder tener esta variable

  //tendria que ser declarada static class Adherant
  //================================================CONSTRUCTOR=========================================================
  //Va inicia con un stock de 10 documentos
  public Mediatheque() {

    Livre libro1 = new Livre(1, "The Hobbit", "Tolkin");
    Livre libro2 = new Livre(2, "Batman", "Copola");
    Livre libro3 = new Livre(3, "The Lord Of The Rings", "Tolkin");
    Livre libro4 = new Livre(4, "Game Of Thrones", "George Martin");
    Livre libro5 = new Livre(5, "Spiderman", "Raimi");

    CD cd1 = new CD.builderCD(6, "Heaven").getCompositeur("Brian Adams").getInterprete("John").regresaCd();
    CD cd2 = new CD.builderCD(7, "American Idiot").getCompositeur("Green Day").getInterprete("They").regresaCd();
    CD cd3 = new CD.builderCD(8, "Poker Face").getInterprete("Lady Gaga").regresaCd();//compositeur inconnu
    CD cd4 = new CD.builderCD(9, "Pirates").getCompositeur("Hans Zimmer").getInterprete("Him").regresaCd();
    CD cd5 = new CD.builderCD(10, "Superman").getCompositeur("Hans Zimmer").getInterprete("Him").regresaCd();

    //se agregan estos documentos
    ajoutDoc(libro1, libro2, libro3, libro4, libro5, cd1, cd2, cd3, cd4, cd5);

    Adherant adherant1 = new Adherant("jorgelu5");
    Adherant adherant2 = new Adherant("jorgel_fant");
    Adherant adherant3 = new Adherant("200311402");
    Adherant adherant4 = new Adherant("Mario");
    Adherant adherant5 = new Adherant("Luis");

    //se agregan estos documentos
    ajoutAd(adherant1, adherant2, adherant3, adherant4, adherant5);
  }

  //==========================================CLASE INTERNA ADHERANT====================================================

  class Adherant {
    private Mediatheque mediatheque;
    //private ArrayList<Document> docus = documents;//referencia al arraylist de la mediatheque
    private int numAdherant;
    private String identifiant;
    private Emprunt[] MesEmprunts;
    private int nbEmprunts = 0;

    public Adherant(String identifiant) {
      this.identifiant = identifiant;
      this.numAdherant = ++numAdherantStatic;//atrapo el aumento cada vez que se crea un adherant ou "++adherant"
      MesEmprunts = new Emprunt[5];
    }

    //=========================================METHODES=================================================================
    //la clase externa Mediatheque utilizara en uno de sus methodos donde devuelve un adherante si este existe,
    //este metodo de la clase interna en el que ad.setMediatheque(this) osea mediatheque en parentesis
    private void setMediatheque(Mediatheque mediatheque) {
      this.mediatheque = mediatheque;
    }
    //=========================================getNumAdherant===========================================================

    public int getNumAdherant() {
      return this.numAdherant;
    }
    //=========================================getIdentifiant===========================================================

    public String getIdentifiant() {
      return this.identifiant;
    }
    //=========================================getMesemprunts===========================================================

    public String getMesemprunts() {
      String emprunts = "";
      for (int i = 0; i < nbEmprunts; i++) {
        emprunts += "\n" + MesEmprunts[i].getDocName();
      }
      return emprunts;
    }

    //=========================================METHODES=================================================================

    //public boolean estEnRetard() qui retourne vrai si au moins un des emprunts de cet adhérent est en retard
    public boolean estEnRetard() {
      boolean retard = false;
      for (int i = 0; i < nbEmprunts; i++) {
        if (MesEmprunts[i].estEnRetard()) {
          retard = true;
        }
      }
      return retard;
    }

    //===================================public boolean empruntPossible()===============================================
    // qui retourne vrai si cet adhérent peut emprunter, c’est-à-dire s’il
    // n’est pas en retard et s’il a moins de 5 emprunts en cours ;
    public boolean empruntPossible() {
      boolean possible = false;
      if (nbEmprunts < 5) {
        if (!estEnRetard()) {
          possible = true;
        } else {
          System.out.println("Vous avez du retard dans le retour de vos emprunts !");
        }
      } else {
        System.out.println("Nombre maximum d'umprunts atteint!");
      }
      return possible;
    }

    //=============================public boolean emprunterLivre(Livre, Calendar)=======================================

    public boolean emprunterLivre(Livre livre) {//public boolean emprunterLivre(Livre livre,MEdiatheque mediatheque)
      boolean emprunte = false;
      if (empruntPossible() && livre.estDisponible(mediatheque)) {
        ajouterEmprunt(new EmpruntLivre(livre));
        emprunte = true;
        mediatheque.removeDoc(livre);
        System.out.println("<<" + livre.getTitle() + ">>" + " emprunté avec succès !");
      } else {
        System.out.println("L'emprunt du cd: " + "<<" + livre.getTitle() + ">>" + " n'a pas pu être effectué !");
      }
      return emprunte;
    }
    //=============================public boolean emprunterCD(CD, Calendar)=============================================

    public boolean emprunterCD(CD cd) {
      boolean emprunte = false;
      if (empruntPossible() && cd.estDisponible(mediatheque)) {
        ajouterEmprunt(new EmpruntCD(cd));
        emprunte = true;
        mediatheque.removeDoc(cd);
        System.out.println(cd.getTitle() + " emprunté avec succès !");
      } else {
        System.out.println("L'emprunt du cd: " + "<<" + cd.getTitle() + ">>" + " n'a pas pu être effectué !");
      }
      return emprunte;
    }

    //=============================private void ajouterEmprunt(Emprunt)=================================================

    private void ajouterEmprunt(Emprunt emprunt) {
      MesEmprunts[nbEmprunts] = emprunt;
      nbEmprunts++;
    }

    //=====public toString(), qui retourne un objet de type String décrivant l’état de l’objet au moment de l’appel.====

    public String toString() {
      if (nbEmprunts != 0) {
        return this.getIdentifiant() + " a emprunté : " + this.getMesemprunts();
      } else {
        return this.getIdentifiant() + " n'a pas d'emprunts en cours !";
      }
    }

  }
  //=============================================Fin D'ADHERANT=========================================================
  //===========================================Verification d'Adhésion==================================================

  //la clase externa puede acceder incluso a los atributos private de la interna
  //nos retorna un aderhant con una copia de la referencia de la mediatheque
  public Adherant verificationAd(String identifiant) {
    //puede regresar null o el adherant si este esta en el arraylist
    Adherant ad = searchAdParID(identifiant);
    ad.setMediatheque(this);//IMPORTANT
    return ad;
  }

  //===========================================Verification d'Adhésion==================================================


  //======================================recherche d’un document par titre=============================================

  public Adherant searchAdParID(String identifiant) {
    Adherant ad = null;
    for (Adherant adherant : adherants) {
      if (adherant.getIdentifiant().equalsIgnoreCase(identifiant)) {
        ad = adherant;
      }
    }
    return ad;
  }
  //======================================Donne l'arrayList de documents================================================

  public ArrayList<Document> getDocs() {
    return documents;
  }
  //======================================Donne l'arrayList de Adherants================================================

  public ArrayList<Adherant> getAd() {
    return adherants;
  }

  //======================================ajout d’un Adherant===========================================================

  public void ajoutAd(Adherant... adherant) {
    adherants.addAll(Arrays.asList(adherant));
  }

  //======================================ajout d’un document quelconque================================================

  public void ajoutDoc(Document... documento) {
    for (Document doc : documento) {
      documents.add(doc);
    }
  }

  //======================================enleve un document quelconque=================================================

  public void removeDoc(Document doc) {//borra el objeto
    documents.remove(doc);
  }

  //==================================recherche d’un document par titre=================================================

  public Document getDocByTitle(String title) {
    Document doc = null;
    for (Document documento : documents) {
      if (documento.getTitle().equalsIgnoreCase(title)) {
        doc = documento;
      }
    }
    return doc;
  }

  //recherche de tous les livres d’un auteur donné======================================================================

  public ArrayList<Livre> getDocByAutor(String autor) {
    ArrayList<Livre> livres = new ArrayList<>();

    for (Document documento : documents) {
      if (documento.getClass().getSimpleName().equals("Livre")) {
        Livre livre = (Livre) documento;
        if (livre.getauteur().equalsIgnoreCase(autor)) {
          livres.add(livre);
        }
      }
    }
    return livres;
  }

  //recherche de tous les CD d’un interprète ou compositeur donné=======================================================
  public ArrayList<CD> getDocByCompInter(String interCompo) {
    ArrayList<CD> cds = new ArrayList<>();
    for (Document documento : documents) {
      if (documento.getClass().getSimpleName().equals("CD")) {
        CD cd = (CD) documento;
        if (cd.getCompositeur().equalsIgnoreCase(interCompo) || cd.getInterprete().equalsIgnoreCase(interCompo)) {
          cds.add(cd);
        }
      }
    }
    return cds;
  }

  /*====================================================================================================================
   Un peu de tri...
   On souhaite pouvoir trier les documents par type (d’abord les cds), puis par titre (alphabétiquement), et enfin par
   numéro (croissant) identifiant. Autrement dit, on souhaite trier les documents selon l’ordre lexicographique <lex sur
   les documents (on a donc d1 <lex d2 ssi ..)
   ===================================================================================================================*/
  //orden por tipo
  public void tribyType() {
    Collections.sort(documents);
  }

  //orden por ID
  public void triParTitre() {
    documents.sort(new Comparator<Document>() {//ou Collections.sort
      @Override
      public int compare(Document o1, Document o2) {
        return o1.getTitle().compareTo(o2.getTitle());
      }
    });
  }

  //orden por ID
  public void triParID() {
    documents.sort(new Comparator<Document>() {//ou Collections.sort
      @Override
      public int compare(Document o1, Document o2) {
        return o1.getId() - o2.getId();
      }
    });
  }

  //muestra los documentos, recomendable usar el metodo de ordenamiento que nos convenga, antes de utilizar showDocs
  public void showDocs() {
    for (Document document : documents) {
      System.out.println(document);
    }
  }
}
/*======================================================================================================================
   Question 1.5. Munir la classe Document d’une méthode permettant de comparer deux documents avec <lex (on rappelle que
   la classe String possède une méthode public int compareTo(String t) qui renvoit un entier négatif ssi la chaîne
   est plus petite que t)
======================================================================================================================*/


/*======================================================================================================================
   Question 1.6. Munir la classe Document d’une méthode permettant l’affichage à l’écran de tous les documents à
   disposition, triés
======================================================================================================================*/


// Les adhérents (subsidiaire) --complementario
// ***************************


/*======================================================================================================================
   Question 1.7. Construire une classe Emprunt caractérisée par un attribut dateEmprunt de type Calendar (cf Annexe),
   un constructeur ayant un paramètre dateEmprunt de type Calendar, et une méthode de signature et retour public
   abstract boolean estEnRetard() permettant de déterminer si un emprunt est en retard.
======================================================================================================================*/
abstract class Emprunt {
  private Calendar dateEmprunt;
  private Document doc;

  /*
    public Emprunt(Calendar dateEmprunt) {
      this.dateEmprunt = dateEmprunt;
    }
  */
  public Emprunt() {
    this.dateEmprunt = Calendar.getInstance();
  }

  public Calendar getDateEmprunt() {
    return this.dateEmprunt;
  }

  public String getDocName() {
    return this.doc.getTitle();
  }

  public abstract boolean estEnRetard();

}
/*======================================================================================================================
   Question 1.8. Construire deux classes dérivant de la classe Emprunt :
   1. EmpruntLivre caractérisée par un attribut leLivre de type Livre, un constructeur avec deux paramètres dateEmprunt
   et livre, et la méthode estEnRetard().
   2. EmpruntCD caractérisée par un attribut leCD de type CD, un constructeur avec deux paramètres dateEmprunt et
   leCD et la méthode estEnRetard().
======================================================================================================================*/

class EmpruntLivre extends Emprunt {
  private Livre leLivre;

  public EmpruntLivre(Livre livre) {
    super();
    this.leLivre = livre;
    //this.mediatheque=mediatheque;
  }

  public String getDocName() {
    return this.leLivre.getTitle();
  }

  public boolean estEnRetard() {
    Calendar cal = getDateEmprunt();
    cal.add(Calendar.WEEK_OF_MONTH, 3);
    Date dateLimite = cal.getTime();

    //System.out.println(dateLimite);

    Calendar actual = Calendar.getInstance();
    //actual.add(Calendar.WEEK_OF_MONTH, 3);
    Date dateActuelle = actual.getTime();
    //System.out.println(dateActuelle);

    return dateLimite.before(dateActuelle);//si fecha limite es inferior a la fecha actual entonces el retard = false
  }
}

//======================================================================================================================
class EmpruntCD extends Emprunt {
  private CD leCD;

  public EmpruntCD(CD cd) {
    super();
    this.leCD = cd;
  }

  public String getDocName() {
    return this.leCD.getTitle();
  }

  public boolean estEnRetard() {
    Calendar cal = getDateEmprunt();
    cal.add(Calendar.WEEK_OF_MONTH, 2);
    Date dateLimite = cal.getTime();

    //System.out.println(dateLimite);

    Calendar actual = Calendar.getInstance();
    //actual.add(Calendar.WEEK_OF_MONTH, 3);
    Date dateActuelle = actual.getTime();
    //System.out.println(dateActuelle);

    return dateLimite.before(dateActuelle);//si fecha limite es inferior a la fecha actual entonces el retard = false
  }
}

//======================================================================================================================
class AucunEmprunt extends Emprunt {
  public boolean estEnRetard() {
    return false;
  }

}

/*======================================================================================================================
                                              CONSULTER
======================================================================================================================*/
abstract class Consulter {

  public abstract void Consulte();

}

//======================================================================================================================
class ConsulterLivre extends Consulter {
  private Livre leLivre;

  public ConsulterLivre(Livre leLivre) {
    this.leLivre = leLivre;
  }

  public void Consulte() {
    System.out.println("L'adhérant consulte le livre : " + leLivre.getTitle());
  }
}

//======================================================================================================================
class ConsulterCD extends Consulter {
  private CD cd;

  public ConsulterCD(CD cd) {
    this.cd = cd;
  }

  public void Consulte() {
    System.out.println("L'adhérant consulte le CD : " + cd.getTitle());
  }
}

//======================================================================================================================
class AucunConsult extends Consulter {

  public void Consulte() {
    System.out.println("L'adhérant ne consulte aucun document ");
  }
}

/*======================================================================================================================
                                              RENDRE
======================================================================================================================*/
abstract class Rendre {

  public abstract void rendre();

}

//======================================================================================================================
class RendreLivre extends Rendre {
  private Livre leLivre;

  public RendreLivre(Livre leLivre) {
    this.leLivre = leLivre;
  }

  public void rendre() {
    System.out.println("L'adhérant a rendu le livre : " + leLivre.getTitle());
  }
}

//======================================================================================================================
class RendreCD extends Rendre {
  private CD cd;

  public RendreCD(CD cd) {
    this.cd = cd;
  }

  public void rendre() {
    System.out.println("L'adhérant a rendu le CD : " + cd.getTitle());
  }
}

//======================================================================================================================
class AucunRendu extends Rendre {

  public void rendre() {
    System.out.println("L'adhérant n'a aucun rendu");
  }
}

/*======================================================================================================================
   Question 1.9. Redéfinir la méthode toString() pour chacune des trois classes ci-dessus.
======================================================================================================================*/




/*======================================================================================================================
Question 1.10. Construire une classe Adherent caractérisée par :
    1. les attributs suivants :
         (a) numAdh de type int,
         (b) nom de type String,
         (c) lesEmpruntsEnCours de type tableau d’objets de type Emprunt, et
         (d) nbEmpruntsEnCours de type int ;

    2. le constructeur public Adherent(int numAdh, String nom)

    3. les méthodes suivantes :
         (a) public boolean estEnRetard() qui retourne vrai si au moins un des emprunts de cet adhérent est en retard ;
         (b) public boolean empruntPossible() qui retourne vrai si cet adhérent peut emprunter, c’est-à-dire s’il
             n’est pas en retard et s’il a moins de 5 emprunts en cours ;
         (c) public boolean emprunterLivre(Livre, Calendar)
         (d) public boolean emprunterCD(CD, Calendar)
         (e) private void ajouterEmprunt(Emprunt)
         (f) public toString(), qui retourne un objet de type String décrivant l’état de l’objet au moment de l’appel.
//====================================================================================================================*

 */
/*======================================================================================================================
                                             GESTION
======================================================================================================================*/


