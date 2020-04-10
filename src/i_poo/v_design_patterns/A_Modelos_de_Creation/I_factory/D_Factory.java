package i_poo.v_design_patterns.A_Modelos_de_Creation.I_factory;

import static java.lang.StrictMath.cos;
import static java.lang.StrictMath.sin;

public class D_Factory {
  public static void main(String[] args) {
    /*
    //******************************************************************************************************************
    //                                              Utilisation
    //******************************************************************************************************************

     Les fabriques sont utilisées dans les toolkits ou les frameworks, car leurs classes sont souvent dérivées par
     les applications qui les utilisent.

     Des hiérarchies de classes parallèles peuvent avoir besoin d'instancier des classes les une des autres.

    //******************************************************************************************************************
    //                                    Autres avantages et variantes
    //******************************************************************************************************************
     Bien que la principale utilisation de la Fabrique soit d'instancier dynamiquement des sous-classes, elle
     possède d'autres avantages qui ne sont pas liés à l'héritage des classes. On peut donc écrire des fabriques
     qui ne font pas appel au polymorphisme pour créer plusieurs types d'objets (on fait alors appel à des méthodes
     statiques).

    //******************************************************************************************************************
    //                                          Noms descriptifs
    //*****************************************************************************************************************

    Les langages orientés objet doivent généralement avoir un nom de constructeur identique au nom de la classe,
    ce qui peut être ambigu s'il existe plusieurs constructeurs (par surcharge). Les méthodes de fabrication n'ont pas
    cette obligation et peuvent avoir un nom qui décrit mieux leur fonction. Dans l'exemple suivant, les nombres
    complexes sont créés à partir de deux nombres réels qui peuvent être interprétés soit comme coordonnées polaires,
    soit comme coordonnées cartésiennes ; l'utilisation de méthodes de fabrication ne laisse aucune ambiguïté :       */

    Complex c = Complex.fromPolar(1, Math.PI); // Identique à fromCartesian(-1, 0)

    //Le constructeur de la classe est ici privé, ce qui oblige à utiliser les méthodes de fabrication
    // qui ne prêtent pas à confusion.
  }
}

//******************************************************************************************************************
//                                          Fuera del main
//*****************************************************************************************************************
class Complex {
  public static Complex fromCartesian(double real, double imag) {
    return new Complex(real, imag);
  }

  public static Complex fromPolar(double rho, double theta) {
    return new Complex(rho * cos(theta), rho * sin(theta));
  }
  //CONSTRUCTEUR PRIVE   ce qui oblige à utiliser les méthodes de fabrication qui ne prêtent pas à confusion.
  private Complex(double a, double b) {
    //...
  }
}
