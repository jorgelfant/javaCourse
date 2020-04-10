package i_poo.v_design_patterns.A_Modelos_de_Creation.IV_Prototype.V_classes_immutables_final;

import java.util.Date;

public class Exemplo_1 {
  public static void main(String[] args) {

    Date d = new Date();
    MaClasse c = new MaClasse(d);
    d.setYear(98);
    System.out.println(c);

  }
}

/*
Les développeurs Java connaissent tous très bien la notion de classe immuable. Beaucoup ont d'ailleurs pesté
contre sa principale représentante, java.lang.String. L'expression classe immuable est en fait un abus de langage,
un substitut courant pour objet immuable. Un objet dit immuable est une instance de classe dont les membres exportés
(ou visibles, que cela soit par un modificateur d'accès direct ou indirect, protected, public ou package private)
ne peuvent être modifiés après création.

Les classes immuables ont de nombreux avantages en leur faveur et leur utilisation simplifie parfois tellement le
développement que je voulais écrire ce billet pour vous encourager à en utiliser aussi souvent que possible.
De part leur propriété intrinsèque, ces objets ont un seul état. Cette dernière remarque peut vous sembler anodine
mais a de nombreuses répercussions très importantes. Voici en vrac les avantages des objets immuables :

. Ils sont garantis thread-safe
. Ils peuvent être mis en cache
. Ils n'ont besoin ni de constructeur par copie, ni d'implémentation de l'interface Cloneable
. Il n'est pas nécessaire d'en faire une copie défensive
. Leurs invariants sont testés à la création seulement
. Ils constituent d'excellentes clés pour les Map et Set
. Leurs valeurs peuvent être mises en cache par le client sans risque de désynchronisation
. Les classes immuables sont particulièrement adaptées à la représentation de types de données abstraits.
L'API de Java en contient plusieurs exemples : Integer, Color, BigDecimal, etc. La définition de type abstrait
dépend toutefois de votre application. Ainsi, un logiciel affichant le contenu d'un magasin en ligne
(livres, musique, DVD, etc.) pourra utiliser des classes immuables pour représenter les articles.

====================================================================================================================
                                 Créer une classe immuable
====================================================================================================================
Écrire une classe immuable n'est pas une tâche difficile mais demande beaucoup d'attention pour ne pas exporter
indirectement des valeurs. Voici les règles à suivre :

. La classe doit être déclarée final (dans le cas contraire, il serait possible de modifier une instance par héritage)
. Tous les champs doivent être déclarés final
. La référence à this ne doit jamais être exportée
. Tous les champs faisant référence à un objet non immuable doivent être privés, ne jamais être exportés, représenter
. l'unique référence à cet objet et ne jamais modifier l'état de l'objet

Le dernier point est le plus délicat mais évident avec un exemple :
*/

class MaClasse {
  private final Date theDate;
  /*Ce programme affiche Fri Mar 27 00:50:23 PST 1998, notre classe n'est donc pas immuable. Pour résoudre ce problème,
  il faut réaliser une copie défensive des objets non immuables passes en paramètre :*/

  //   public MaClasse(Date theDate) {
  //     this.theDate = theDate;
  //    }

public MaClasse(Date theDate){
  this.theDate=(Date)theDate.clone();//cast, ya que clone() es un metodo de Object (par defaut para clases de la API)
}//esto evita modificaciones ya que se modificaria la copia
  @Override
  public String toString() {
    return theDate.toString();
  }

  public Date getDate() {
    return (Date) theDate.clone();
  }
}

/*
    A première vue, cet exemple est correct puisque le membre theDate est privé, final et jamais exporté. En outre,
    la valeur renvoyée par toString est immuable. En réalité, theDate est bel et bien exporté, indirectement :

    "VER MAIN"

  Cette fois-ci le résultat est bien Mon Mar 27 00:52:18 PST 2006 malgré la modification de l'année.
  Ce qui est vrai pour les paramètres d'entrée de la classe l'est également pour les valeurs que la classe renvoie
  à travers ses différentes méthodes. Ainsi, pour ajouter une methode getDate() à notre classe, nous devrons écrire
  ceci :

    public Date getDate() {
    return (Date) theDate.clone();
  }

  Malheureusement, la copie défensive ne suffit pas toujours. Prenez l'exemple suivant :
*/
class MiaClasse {
  private final Date startDate;
  private final Date endDate;
/*
  public MiaClasse(Date startDate, Date endDate) {
    if (startDate.compareTo(endDate) > 0) {
      throw new IllegalArgumentException("The start date is not <= the end date.");
    }

    this.startDate = (Date) startDate.clone();
    this.endDate = (Date) endDate.clone();
  }*/

  /*
  Ce code semble parfait à première vue mais cache un gros problème potentiel. En effet, il est possible avec un
  thread de modifier startDate et/ou endDate de maniere à ce que la condition soit validée mais que des valeurs
  interdites soient conservées par l'objet. Puisqu'il n'est pas possible de prédire le séquencement des opérations
  multi-thread dans la plupart des environnements, rien ne garantit que le thread principal ne s'arrêtera pas juste
  après l'exécution du if pour donner la main à un second thread qui modifiera startYear pour que sa valeur soit
  supérieure a endYear. La bonne stratégie (la seule en fait) est la suivante :
  */
  public MiaClasse(Date startDate, Date endDate) {
    Date copyStart = (Date) startDate.clone();
    Date copyEnd = (Date) endDate.clone();
     //el thread ya no cambiaria los valores, estos seguirian siendo los mismos ya que son clones y no se modifican
    if (copyStart.compareTo(copyEnd) > 0) {
      throw new IllegalArgumentException("The start date is not <= the end date.");
    }

    this.startDate = copyStart;
    this.endDate = copyEnd;
  }
}
/*
Ce dernier exemple montre bien pourquoi les classes immuables sont souvent intéressantes. Si Date était immuable,
nous pourrions simplement ecrire this.startDate = startDate.

Rendez-vous service, utilisez des classes immuables :)

//----------------------------------------------------------------------------------------------------------------------
//                                             Benefits
//----------------------------------------------------------------------------------------------------------------------
Since the internal state of an immutable object remains constant in time, we can share it safely among multiple threads.

We can also use it freely, and none of the objects referencing it will notice any difference, we can say that immutable
objects are side-effects free.

//----------------------------------------------------------------------------------------------------------------------
//                                           Conclusion
//----------------------------------------------------------------------------------------------------------------------

Immutable objects don’t change their internal state in time, they are thread-safe and side-effects free.
Because of those properties, immutable objects are also especially useful when dealing with multi-thread environments.
*/
