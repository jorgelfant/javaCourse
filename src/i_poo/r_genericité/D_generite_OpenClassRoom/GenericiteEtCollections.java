package i_poo.r_genericité.D_generite_OpenClassRoom;

import java.util.ArrayList;
import java.util.List;

public class GenericiteEtCollections {
    public static void main(String[] args) {
        //Généricité et collections
        /*
        Vous pouvez aussi utiliser la généricité sur les objets servant à gérer des collections.
        C'est même l'un des points les plus utiles de la généricité !

        En effet, lorsque vous listiez le contenu d'un ArrayList par exemple, vous n'étiez jamais
        sûrs à 100 % du type de référence sur lequel vous alliez tomber (normal, puisqu'un ArrayList
        accepte tous les types d'objets)… Eh bien ce calvaire est terminé et le polymorphisme va pouvoir
        réapparaître, plus puissant que jamais !

        Voyez comment utiliser la généricité avec les collections :
        */
        System.out.println("Liste de String");
        System.out.println("------------------------------");
        List<String> listeString = new ArrayList<String>();
        listeString.add("Une chaîne");
        listeString.add("Une autre");
        listeString.add("Encore une autre");
        listeString.add("Allez, une dernière");

        for (String str : listeString)
            System.out.println(str);

        System.out.println("\nListe de float");
        System.out.println("------------------------------");

        List<Float> listeFloat = new ArrayList<Float>();
        listeFloat.add(12.25f);
        listeFloat.add(15.25f);
        listeFloat.add(2.25f);
        listeFloat.add(128764.25f);

        for (float f : listeFloat)
            System.out.println(f);

    /*
       Liste de String
       ------------------------------
       Une chaîne
       Une autre
       Encore une autre
       Allez, une dernière

       Liste de float
       ------------------------------
       12.25
       15.25
       2.25
       128764.25
    */
    /*
    La généricité sur les listes est régie par les lois vues précédemment : pas de type float dans un ArrayList<String>.

    Vu qu'on y va crescendo, on pimente à nouveau le tout !

    Héritage et généricité
    ----------------------

    Là où les choses sont pernicieuses, c'est quand vous employez des classes usant de la généricité
    avec des objets comprenant la notion d'héritage ! L'héritage dans la généricité est l'un des concepts
    les plus complexes en Java. Pourquoi ? Tout simplement parce qu'il va à l'encontre de ce que vous avez
    appris jusqu'à présent…

    Acceptons le postulat suivant
    -----------------------------

    Nous avons une classe Voiture dont hérite une autre classe VoitureSansPermis, ce qui nous donnerait
    le diagramme représenté à la figure suivante.

             ********************************           ********************************
             *           Voiture            *           *     VoitureSansPermis        *
             ********************************           ********************************
             *        valeur: T             *  <------- *        valeur: T             *
             ********************************           ********************************
             * setValeur(val: T): void      *           * setValeur(val: T): void      *
             * getValeur(): T               *           * getValeur(): T               *
             ********************************           ********************************

                                       Hiérarchie de classes

     Jusque-là, c'est simplissime. Maintenant, ça se complique :

    List<Voiture> listVoiture = new ArrayList<Voiture>();
    List<VoitureSansPermis> listVoitureSP = new ArrayList<VoitureSansPermis>();

    listVoiture = listVoitureSP;   //Interdit !

    Si vous avez l'habitude de la covariance des variables, sachez que cela n'existe pas avec la généricité !
    En tout cas, pas sous la même forme.

    Imaginez deux secondes que l'instruction interdite soit permise ! Dans listVoiture, vous avez le contenu
    de la liste des voitures sans permis, et rien ne vous empêche d'y ajouter une voiture. Là où le problème
    prend toute son envergure, c'est lorsque vous voudrez sortir toutes les voitures sans permis de votre
    variable listVoiture. Eh oui ! Vous y avez ajouté une voiture ! Lors du balayage de la liste, vous aurez,
    à un moment, une référence de type VoitureSansPermis à laquelle vous tentez d'affecter une référence de
    type Voiture. Voilà pourquoi ceci est interdit.

    Une des solutions consiste à utiliser le wildcard : « ? ». Le fait de déclarer une collection avec le wildcard, comme ceci :
    */
        ArrayList<?> list;
    /*
    … revient à indiquer que notre collection accepte n'importe quel type d'objet. Cependant,
    nous allons voir un peu plus loin qu'il y a une restriction.

    Je vais maintenant vous indiquer quelque chose d'important. Avec la généricité, vous pouvez aller encore plus loin.
    Nous avons vu comment restreindre le contenu d'une de nos listes, mais nous pouvons aussi l’élargir ! Si je veux
    par exemple qu'un ArrayList puisse avoir toutes les instances de Voiture et de ses classes filles… comment faire ?

    Ce qui suit s'applique aussi aux interfaces susceptibles d'être implémentées par une classe !
    */

        //List n'acceptant que des instances de Voiture ou de ses sous-classes
        // List<? extends Voiture> listVoitureSP = new ArrayList<VoitureSansPermis>();

    /*
    Une application de ceci consiste à écrire des méthodes génériques, par exemple une méthode qui permet
    de lister toutes les valeurs de notre ArrayList cité précédemment :
    */
        //List n'acceptant que des instances de Voiture ou de ses sous-classes
        //List<? extends Voiture> listVoitureSP = new ArrayList<VoitureSansPermis>();
        //afficher(listVoitureSP);
     /*
     Eh, attends ! On a voulu ajouter des objets dans notre collection et le programme ne compile plus !

     Oui… Ce que je ne vous avais pas dit, c'est que dès que vous utilisez le wildcard,
     vos listes sont verrouillées en insertion : elles se transforment en collections en lecture seule..

     En fait, il faut savoir que c'est à la compilation du programme que Java ne vous laisse pas faire :
     le wildcard signifie « tout objet », et dès l'utilisation de celui-ci, la JVM verrouillera la compilation
     du programme afin de prévenir les risques d'erreurs. Dans notre exemple, il est combiné avec extends
     (signifiant héritant), mais cela n'a pas d'incidence directe : c'est le wildcard la cause du verrou
     (un objet générique comme notre objet Solo déclaré Solo<?> solo; sera également bloqué en écriture).

     Par contre, ce type d'utilisation fonctionne à merveille pour la lecture :
     */
        //Liste de voiture
        List<Voiture> listVoiture = new ArrayList<Voiture>();
        listVoiture.add(new Voiture());
        listVoiture.add(new Voiture());
        // listVoiture.add(new VoitureSansPermis());  esto es posible ya que una voiture sin permis es una voiture
        //lo que no es posible es meter una lista en otra sirviendose de la herencia, es un...

        List<VoitureSansPermis> listVoitureSP = new ArrayList<VoitureSansPermis>();
        listVoitureSP.add(new VoitureSansPermis());
        listVoitureSP.add(new VoitureSansPermis());

        affiche(listVoiture);//affiche una lista que actua sobre la clase Voiture y sus subclases
        affiche(listVoitureSP);
        affichage(listVoiture);//aficha una lista que actua sobre una clase y sus clases mas arriba en la jerarquia (superClass)
        /*
        L'utilité du wildcard est surtout de permettre de retrouver le polymorphisme avec les collections.
        Afin de mieux cerner l'intérêt de tout cela, voici un petit exemple de code :
        */
        System.out.println("******************************************************************************************");

        //TEST avec la class Garage creo un objeto de tipo Garage
        Garage garage = new Garage();
        garage.add(listVoiture);//agrega el la liste interna et imprime las voitures
        System.out.println("--------------------------");
        garage.add(listVoitureSP);//agrega las voitures sans permis en la lista interna (ya llena con voitures) e imprime la list
        //POLIMORPHISME porque se fusionan en las clase interna del metodo las voitures asi como las voitures sin permis
        // y se usa el toString de cada tipo  Voitures et VoituresSansPermis

        /*
        Essayez donc : ce code fonctionne parfaitement et vous permettra de constater que le polymorphisme
        est possible avec les collections. Je conçois bien que ceci est un peu difficile à comprendre, mais
        vous en aurez sûrement besoin dans une de vos prochaines applications !
        */
    }

    //**********************************************************************************************************************
    //                                           Methode GENERIQUE
    //**********************************************************************************************************************
    /*Avant que vous ne posiez la question, non, déclarer la méthode affiche(List<Voiture> list) {…}
    ne vous permet pas de parcourir des listes de VoitureSansPermis, même si celle-ci hérite de la classe Voiture.

    Les méthodes déclarées avec un type générique sont verrouillées afin de n'être utilisées qu'avec
    ce type bien précis, toujours pour les mêmes raisons ! Attendez : ce n'est pas encore tout.
    Nous avons vu comment élargir le contenu de nos collections (pour la lecture), nous allons voir
    comment restreindre les collections acceptées par nos méthodes.

    La signification de l'instruction suivante est donc que la méthode autorise un objet de type List
    de n'importe quelle superclasse de la classe Voiture (y compris Voiture elle-même).*/

   /* static void afficher(ArrayList<? extends Voiture> list) {
        for (Voiture v : list)
            System.out.println(v.toString() + "\n");
    }*/

    //Avec cette méthode, on accepte aussi bien les collections de Voiture que les collection de VoitureSansPermis
    //… autorise n'importe quel objet de type List dont Voiture est la superclasse.
    static void affiche(List<? extends Voiture> list) {
        for (Voiture v : list)
            System.out.print(v.toString() + "\n");
    }
    /*La signification de l'instruction suivante est donc que la méthode autorise un objet de type List
    de n'importe quelle superclasse de la classe Voiture (y compris Voiture elle-même).*/

    //Avec cette méthode, on accepte aussi bien les collections de Voiture que les collections d'Object :
    // superclasse de toutes les classes
    static void affichage(List<? super Voiture> list) {
        for (Object v : list)//Object pa indicar que puede haber un padre, o incluso un abuelo  VoitureSansPermis Voiture Object
            System.out.print(v.toString() + "\n"); //de esta manera con Object el for tomara a toodas las superclases en cuenta
    }                                             //si solo pusiera voiture, no tomaria en cuenta a Object u otra SC de Voiture

}


//**********************************************************************************************************************
//                                              CLASES EXTERNAS
//**********************************************************************************************************************
class Voiture {
    public Voiture() {
    }

}

class VoitureSansPermis extends Voiture {
    public VoitureSansPermis() {
    }
}

//**********************************************************************************************************************
//CLASS Garage
class Garage {
    List<Voiture> list = new ArrayList<Voiture>();

    public void add(List<? extends Voiture> listVoiture) {
        for (Voiture v : listVoiture) {
            list.add(v);
        }
        System.out.println("Contenu de notre garage :");
        for (Voiture v : list) {
            System.out.print(v.toString() + "\n");
        }
    }
}
/*
     .La généricité est un concept très utile pour développer des objets travaillant avec plusieurs types de données.

     .Vous passerez donc moins de temps à développer des classes traitant de façon identique des données différentes.

     .La généricité permet de réutiliser sans risque le polymorphisme avec les collections.

     .Cela confère plus de robustesse à votre code.

     .Vous pouvez coupler les collections avec la généricité !

     .Le wildcard (?) permet d'indiquer que n'importe quel type peut être traité et donc accepté !

     .Dès que le wildcard (?) est utilisé, cela revient à rendre ladite collection en lecture seule !

     .Vous pouvez élargir le champ d'acceptation d'une collection générique grâce au mot-clé extends.

     .L'instruction ? extends MaClasse autorise toutes les collections de classes ayant pour supertype MaClasse.

     .L'instruction ? super MaClasse autorise toutes les collections de classes ayant pour type MaClasse et tous ses supertypes !

     .Pour ce genre de cas, les méthodes génériques sont particulièrement adaptées et permettent d'utiliser
      le polymorphisme dans toute sa splendeur !
*/