package i_poo.k_abstract.persona;

public abstract class Persona {//tenemos un metodo abstracto aqui que declaramos nuestra class ABSTRACT
    private final String NOM;


    public Persona(String NOM) {//CONSTRUCTOR
        this.NOM = NOM;
    }

    public String getNOM() {//NON ABSTRACT car el est ecrite de la mm manière pour toutes les classes
        return NOM;
    }

    public abstract String donne_description();//ABSTRACT car elle n'est pas la même dans toutes es classes filles
}

//TOUTES LES CLASSES DEVANT HERITER DE Personne DEVRONT INITIALISER OU PLUTOT CREER CETTE METHODE
//CAR DANS LA CLASSE ABSTRACT ELLE EST JUSTE DECLAREE POUR FORCER AUX CLASSES FILLES DE L'INITIALISER

//LES CLASSES FILLES AURONT DONC   public String decrisToi(){..........} on construit la méthode donc

//CREER UNE CLASSE ABSTRACT avec DES METHODES ABSTRACT ne fait que créer une structure de base (patron de diseno)
// plateforme que l’on doit suivre obligatoirement dans ta HIERARCHIE D’HERITAGE .

//Parce que quand on va créer un programme comme celui qu’on a par exemple : toutes les classes qui heritent
// de personne doivent avoir un prénom, on crée donc la méthode donne_prénom dans la classe personne

//Cette méthode pourra être inscrite de la meme manière pour toutes les classes ? OUI


//Dans cette conception d’héritage ai-je besoin d’une méthode donne_description pour tous les objets ? OUI

//Et maintenant oui, dans chacune des classes tu construis la méthode donne description.
//Cette méthode donne_description pourra être la meme pour tous les objets ? cette méthode pourra etre construite
// de la meme manière pour tous les objets ? non .

//Car la description sera différente en fonction de l’objet : employe, chef, directeur, eleve.

//*Dans ce cas je devrai déclarer la méthode comme abstract car tous les objects qui héritent de personne,
// les classes qui héritent de personne doivent avoir une description mais la méthode sera différente pour
// chacune de ces classes ! chaque methode dans sa classe sobreecribira donc la méthode de base

//Maintenant on pourrait se demander : POURQUOI ne pas avoir déclaré cette méthode (abstract) comme une méthode normale????
//public String donne_description()   Dans la classe personne et non comme une méthode abstract ???

/*
*On aurait pas pu le faire que la méthode donne description de la classe eleve retourne quelque chose de différent
 par rapport à l’autre classe fille employe du coup comme la méthode donne_description varie d’une méthode à l’autre,
 je n’aurais pas pu la créer dans la classe personne  MAINTENANT il nous reste le principal pour essayer le fonctionnement de nos classes !!

*/



