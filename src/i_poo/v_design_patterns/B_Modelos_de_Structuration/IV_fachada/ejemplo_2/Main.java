package i_poo.v_design_patterns.B_Modelos_de_Structuration.IV_fachada.ejemplo_2;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class Main {
  public static void main(String[] args) {
//======================================================================================================================
//                                           Classe utilisatrice
//======================================================================================================================
    UserfriendlyDate d = new UserfriendlyDate("1980-08-20");
    System.out.println("Date : " + d);
    d.addDays(20);
    System.out.println("20 jours après : " + d);
    /*RESULTADO:
      Date : 1980-08-20
      20 jours après : 1980-09-09
    */
  }
}
//==================================================================================================================
//                                         Façade
//==================================================================================================================
    /*
    Proposer une interface simple et unique afin de camoufler la complexité d'utilisation de toute une bibliothèque,
    en fournissant moins de fonctionnalités mais suffisamment à la plupart des utilisateurs

    Le patron de conception façade a pour but de cacher une conception et une interface ou un ensemble d'interfaces
    complexes difficiles à comprendre (cette complexité étant apparue "naturellement" avec l'évolution du
    sous-système en question). La façade permet de simplifier cette complexité en fournissant une interface simple
    du sous-système. Habituellement, la façade est réalisée en réduisant les fonctionnalités de ce dernier mais en
    fournissant toutes les fonctions nécessaires à la plupart des utilisateurs.

    La façade encapsule la complexité des interactions entre les objets métier participant à un workflow.

    L'utilisation d'une façade a les avantages suivants :

          .simplifier l'utilisation et la compréhension d'une bibliothèque logicielle car la façade possède des méthodes
           pratiques pour les tâches courantes,

          .rendre le code source de la bibliothèque plus lisible pour la même raison,

          .réduire les dépendances entre les classes utilisatrices et les classes internes à la bibliothèque puisque
           la plupart des classes utilisatrices utilisent la façade, ce qui autorise plus de flexibilité pour le
           développement du système,

          .rassembler une collection d'API complexes en une unique et meilleure API (orientée tâches utilisateurs).

    Un adaptateur est utilisé quand la façade doit respecter une interface particulière et doit supporter un
    comportement polymorphique.
    */

//==================================================================================================================
//                                    Diagramme des classes UML
//==================================================================================================================
    /*
    Le patron de conception Façade peut être représenté par le diagramme de classe UML suivant :


                                                -----------------
                                                |   Client      |
                                                -----------------
                                                        |
                                                        |
                                                -----------------
                                                |    Façade     |
                                                -----------------
                                                |               |
                                                -----------------
                                                | +faireTâche() |
                                                -----------------
                                                        |\
                    ----------------------------------- | -----------------------------------
                   |                                    |                                    \
                  |                                     |                                     \
          -----------------                      -----------------                    -----------------
          |    Façade     |                      |    Façade     |                    |    Façade     |
          -----------------                      -----------------                    -----------------
          |               |                      |               |                    |               |
          -----------------                      -----------------                    -----------------
          | ...           |                      | ...           |                    | ...           |
          -----------------                       ----------------                    -----------------
                                 Diagramme de classes UML du patron de conception Façade
    */
//==================================================================================================================
// L'exemple suivant cache une API de gestion de calendrier compliquée, derrière une façade plus simple. Il affiche
//==================================================================================================================

//======================================================================================================================
//                                           Façade
//======================================================================================================================

class UserfriendlyDate {
  GregorianCalendar gcal;

  public UserfriendlyDate(String isodate_ymd) {
    String[] a = isodate_ymd.split("-");
    gcal = new GregorianCalendar(Integer.parseInt(a[0]),// année
      Integer.parseInt(a[1]) - 1,  // mois (0 = Janvier)
      Integer.parseInt(a[2]));  // jour
  }

  public void addDays(int days) {
    gcal.add(Calendar.DAY_OF_MONTH, days);
  }

  public String toString() {
    return String.format("%1$tY-%1$tm-%1$td", gcal);
  }
}

