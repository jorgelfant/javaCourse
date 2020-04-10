package i_poo.m_clases_internas_locales;

import javax.swing.*;


public class Principale_InnerClass {
    public static void main(String[] args) {
      /*-------------------------------------CLASSES INTERNES LOCALES---------------------------------------------------
        Une classe interne local= une class dans une méthode (ce qui est dans la méthode est accessible que depuis la méthode)

        UTILITE : Les CLASSES dans des METHODES sont utiles quand on va instancier la CLASSE INTERNE une fois,

        (Créer un seul objet de la classe interne)

        *Aide a simplifier encore plus le code

        *Quand on met une classe dans une méthode, la porte de cette classe est restreinte à la méthode dans laquelle
         elle se trouve :

        *Ceci a l’avantage d’encapsuler encore plus cette classe interne (meme la classe qui l’englobe ne peut pas y acceder)
         sauf si elle utilise la méthode dans laquelle on a déclaré cette classe interne
         -------------------------------------------------------------------------------------------------------------*/
      /*----------------------------------------------------------------------------------------------------------------
       .La CLASSE INTERNE dans un programme peut etre local ou non
        LA CLASSE INTERNE DECLAREE DANS UNE METHODE NE DOIT AVOIR AUCUN MODIFICATEUR D'ACCES

        class clase_externa{

           public void metodo(){
              class clase_interna_local{
                codigo de la clase interna;
              }
              codigo del metodo;
           }
           codigo de la clase externa;

        }

        *On reprend l’exemple précédent
        *On va convertir la classe interne dans une classe interne dans méthode (local)
        *Ca peut se faire quand la classe interne est utilisée une seule fois

        * On l’utilise une seule fois au moment de créer un objet listener (oyente)
        *On met la classe dans la méthode, en supprimant le modificateur private
      ----------------------------------------------------------------------------------------------------------------*/
        //esto daria error porque ahora los parametros estan en el metodo
        //Reloj2 miReloj = new Reloj2(3000, true);
        Reloj2 miReloj = new Reloj2();
        miReloj.enMarche(3000, true);//los parametros ahora en el metodo cuyo codigo creara el objeto
        JOptionPane.showMessageDialog(null, "Appuyer sur accepter pour arrêter");
        System.exit(0);
        /*codigo del metodo enMarche (sin contar la clase interna) que ta dentro tb
        ActionListener listener = new DameHora();
        Timer miTemporisador = new Timer(intervale, listener);
        miTemporisador.start();
        */

    }
}
