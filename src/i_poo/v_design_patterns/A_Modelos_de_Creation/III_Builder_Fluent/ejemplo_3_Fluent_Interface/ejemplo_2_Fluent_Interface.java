package i_poo.v_design_patterns.A_Modelos_de_Creation.III_Builder_Fluent.ejemplo_3_Fluent_Interface;

public class ejemplo_2_Fluent_Interface {
  public static void main(String[] args) {
    /*

    //******************************************************************************************************************
    //                              Le fluent interface
    //******************************************************************************************************************

    Ce n’est pas un builder à proprement parler, mais le principe est le même :

    Il s’agit en fait de l’utilisation du design pattern fluent lors de la construction d’un objet mutable
    (également appelée désignation chaînée : les setters préfixés par ‘with‘ renvoient également l’instance
    à la place de void)
   */

                //   Boat erika = new Boat().withCaptain(hadock).withSize(2);

    /*
    //******************************************************************************************************************
    //                              Pourquoi utiliser le fluent interface comme builder?
    //******************************************************************************************************************

    Le fluent interface permet d’éviter efficacement l’anti-pattern « Telescoping Constructor Pattern »,
    en particulier sur les instances immutables :


                   Boat(int size) {
                     //...
                   }
                   Boat(int size, Human captain) {
                    // ...
                   }
                   Boat(int size, Human captain, boolean inWood, boolean motor) {
                     //...
                     }
                   Boat(int size, Human captain, boolean inWood, boolean motor, boolean sail) {
                     //...
                     } }

                   Boat aurore = new Boat(hadock , false, true, false);

     */

  }
}
