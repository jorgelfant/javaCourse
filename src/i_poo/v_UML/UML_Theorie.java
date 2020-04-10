package i_poo.v_UML;

import java.util.*;

public class UML_Theorie {
  public static void main(String[] args) {
/*
    Document libro = Factory.createDoc(5, "hola", new Livre("Jorge"));
    Document CD = Factory.createDoc(6, "Ciao", new CD("Jorge", "Luis"));
    System.out.println(libro);
    System.out.println(CD);

 */

    //System.out.println(tic.getFormat().getClass().getSimpleName());

    Mediatheque mediatheque = new Mediatheque();

    Document tic = mediatheque.getDocs().get(0);

    if(mediatheque.verificationAd("jorgelu5")!=null){
      mediatheque.preter(tic);
      mediatheque.preter(tic);
    }


  }
}

//==================================================================
class Document implements Comparable<Document> {
  //FACTORY
  private final Id id;
  private final Titre titre;
  private final Format format;

  public Document(Id id, Titre titre, Format format) {
    this.id = id;
    this.titre = titre;
    this.format = format;
  }

  //**************************
  public Id getId() {
    return this.id;
  }

  //**************************
  public Titre getTitle() {
    return this.titre;
  }

  //**************************
  public Format getFormat() {
    return this.format;
  }
  //**************************

  //ESTE SERA EL ORDEN DE BASE
  public int compareTo(Document o2) {
    return this.format.getClass().getSimpleName().compareTo(o2.getFormat().getClass().getSimpleName());
  }

  public String toString() {
    return "Document: " + this.format.getClass().getSimpleName() + ", ID: " + this.id + ", titre: " + this.titre;
  }


  public boolean estDisponible(Mediatheque mediatheque) {
    String docName = this.getTitle().toString();
    boolean trouve = false;
    if (mediatheque.getDocByTitle(docName) != null) {
      System.out.println("Le " + this.getFormat().getClass().getSimpleName() + " est dans la médiathèque");
      trouve = true;
    } else {
      System.out.println("Le " + this.getFormat().getClass().getSimpleName() + " n'est pas dans la médiathèque");
    }
    return trouve;
  }

  public boolean emprunter(Mediatheque mediatheque) {
    return true;//emprunt effectué
  }
/*
  public Document getDoc() {
    return this;//emprunt effectué
  }
*/

  /*
  public static Document createDoc(int id, String titre, Document doc) {
    doc.setId(id);
    doc.setTitle(titre);
    return doc;
  }

   */
}

//==================================================================
final class Id {
  private int id;

  public Id(int id) {
    this.id = id;
  }

  @Override
  public String toString() {
    return this.id + "";
  }
}

//===============================
final class Titre {
  private String titre;

  public Titre(String titre) {
    this.titre = titre;
  }

  @Override
  public String toString() {
    return this.titre;
  }
}

//============================
final class Auteur {
  private String auteur;

  public Auteur(String auteur) {
    this.auteur = auteur;
  }

  @Override
  public String toString() {
    return this.auteur;
  }
}

//============================
final class Interprete {
  private String interprete;

  public Interprete(String interprete) {
    this.interprete = interprete;
  }

  @Override
  public String toString() {
    return this.interprete;
  }
}

//============================
class Compositeur {
  private String compositeur;

  public Compositeur(String compositeur) {
    this.compositeur = compositeur;
  }

  @Override
  public String toString() {
    return this.compositeur;
  }
}

//==================================================================
interface Format {
  public Format getType();
}

//----------------------------------------------------------------------------------------------------------------------
//                                           Livre
//----------------------------------------------------------------------------------------------------------------------
final class Livre implements Format {
  private final Auteur auteur;

  //constructeur 1
  public Livre(final Auteur auteur) {
    this.auteur = auteur;
  }

  public Auteur getauteur() {
    return this.auteur;
  }

  public Livre getType() {
    return this;//emprunt effectué
  }
}

//----------------------------------------------------------------------------------------------------------------------
//                                    CD con su builder
//----------------------------------------------------------------------------------------------------------------------
final class CD implements Format {
  private final Interprete interprete;
  private final Compositeur compositeur;


  public CD(final Interprete interprete, final Compositeur compositeur) {
    this.interprete = interprete;
    this.compositeur = compositeur;
  }


  public Interprete getInterprete() {
    return this.interprete;
  }

  public Compositeur getCompositeur() {
    return this.compositeur;
  }

  public CD getType() {
    return this;//emprunt effectué
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
  private Adherant adherant;

  //tendria que ser declarada static class Adherant
  //================================================CONSTRUCTOR=========================================================
  //Va inicia con un stock de 10 documentos
  public Mediatheque() {

    Document libro1 = new Document(new Id(1), new Titre("El senor de los anillos"), new Livre(new Auteur("Tolkin")));
    Document libro2 = new Document(new Id(2), new Titre("Dracula"), new Livre(new Auteur("Copola")));
    Document libro3 = new Document(new Id(3), new Titre("The Tower"), new Livre(new Auteur("Charles")));
    Document libro4 = new Document(new Id(4), new Titre("Game Of Thrones"), new Livre(new Auteur("George Martin")));
    Document libro5 = new Document(new Id(5), new Titre("Spiderman"), new Livre(new Auteur("Raimi")));

    Document cd1 = new Document(new Id(6), new Titre("Briam Adams"), new Livre(new Auteur("John")));
    Document cd2 = new Document(new Id(7), new Titre("Green Day"), new Livre(new Auteur("They")));
    Document cd3 = new Document(new Id(8), new Titre("Poker Face"), new Livre(new Auteur("Lady Gaga")));
    Document cd4 = new Document(new Id(9), new Titre("Hans Zimmer"), new Livre(new Auteur("Him")));
    Document cd5 = new Document(new Id(10), new Titre("Briam Adams"), new Livre(new Auteur("John")));

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

  //===========================================Verification d'Adhésion==================================================

  public Adherant verificationAd(String identifiant) {
    adherant = null;
    for (Adherant adherant : adherants) {
      if (adherant.getIdentifiant().equalsIgnoreCase(identifiant)) {
        this.adherant = adherant;
        System.out.println("Adhérant trouvé !");
      }
    }
    return adherant;
  }

  //===================================================Prêter===========================================================
  public void preter(Document doc) {
    if (doc.estDisponible(this) && adherant.empruntPossible()) {
      adherant.emprunter(doc);
      this.removeDoc(doc);
      System.out.println("<<" + doc.getTitle().toString() + ">>" + " emprunté avec succès !");
    } else {
      System.out.println("L'emprunt du : " + doc.getFormat().getClass().getSimpleName() + "<<" + doc.getTitle().toString() + ">>" + " n'a pas pu être effectué !");
    }
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
      if (documento.getTitle().toString().equalsIgnoreCase(title)) {
        doc = documento;
      }
    }
    return doc;
  }

  //recherche de tous les livres d’un auteur donné======================================================================

  public ArrayList<Document> getDocByAutor(String autor) {
    ArrayList<Document> livres = new ArrayList<>();

    for (Document documento : documents) {
      if (documento.getFormat().getClass().getSimpleName().equals("Livre")) {
        Livre livre = (Livre) documento.getFormat();
        if (livre.getauteur().toString().equalsIgnoreCase(autor)) {
          livres.add(documento);
        }
      }
    }
    return livres;
  }

  //recherche de tous les CD d’un interprète ou compositeur donné=======================================================
  public ArrayList<Document> getDocByCompInter(String interCompo) {
    ArrayList<Document> cds = new ArrayList<>();
    for (Document documento : documents) {
      if (documento.getClass().getSimpleName().equals("CD")) {
        CD cd = (CD) documento.getFormat();
        if (cd.getCompositeur().toString().equalsIgnoreCase(interCompo) || cd.getInterprete().toString().equalsIgnoreCase(interCompo)) {
          cds.add(documento);
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
        return o1.getTitle().toString().compareTo(o2.getTitle().toString());
      }
    });
  }

  //orden por ID
  /*
  public void triParID() {
    documents.sort(new Comparator<Document>() {//ou Collections.sort
      @Override
      public int compare(Document o1, Document o2) {
        return o1.getId() - o2.getId();
      }
    });
  }
*/
  //muestra los documentos, recomendable usar el metodo de ordenamiento que nos convenga, antes de utilizar showDocs
  public void showDocs() {
    for (Document document : documents) {
      System.out.println(document);
    }
  }
}

/*======================================================================================================================*/

class Emprunt {
  private Calendar dateEmprunt;
  private Document doc;

  public Emprunt(Document doc) {
    this.doc = doc;
    //this.mediatheque=mediatheque;
    this.dateEmprunt = Calendar.getInstance();
  }

  public Calendar getDateEmprunt() {
    return this.dateEmprunt;
  }

  public String getDocName() {
    return this.doc.getTitle().toString();
  }

  public boolean estEnRetard() {
    Calendar cal = getDateEmprunt();
    if (doc.getFormat().getClass().getSimpleName().equalsIgnoreCase("Livre")) {
      cal.add(Calendar.WEEK_OF_MONTH, 3);
    } else {
      cal.add(Calendar.WEEK_OF_MONTH, 2);
    }

    Date dateLimite = cal.getTime();
    //System.out.println(dateLimite);
    Calendar actual = Calendar.getInstance();
    //actual.add(Calendar.WEEK_OF_MONTH, 3);
    Date dateActuelle = actual.getTime();
    //System.out.println(dateActuelle);
    return dateLimite.before(dateActuelle);//si fecha limite es inferior a la fecha actual entonces el retard = false
  }

}

/*======================================================================================================================
                                              RENDRE
======================================================================================================================*/
class Rendre {
  private Document doc;

  public Rendre(Document document) {
    this.doc = document;
  }

  public void rendre() {
    System.out.println("L'adhérant a rendu le  : " + doc.getFormat().getClass().getSimpleName() + doc.getTitle().toString());
  }

}

/*======================================================================================================================
                                             GESTION
======================================================================================================================*/
//==========================================CLASE INTERNA ADHERANT====================================================

class Adherant {
  //private ArrayList<Document> docus = documents;//referencia al arraylist de la mediatheque
  private int numAdherantStatic;//ponemos aqui la static porque la clase interna para poder tener esta variable
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

  public void emprunter(Document doc) {//public boolean emprunterLivre(Livre livre,MEdiatheque mediatheque)
    ajouterEmprunt(new Emprunt(doc));
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
