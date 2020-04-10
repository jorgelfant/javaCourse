package i_poo.m_clases_internas;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

public class Reloj {
    //Atributos
    private int intervale;
    private boolean son;

    //Constructor
    public Reloj(int intervale, boolean son) {//SOLO la classe Reloj2 PUEDE VER a la class DameHora
        this.intervale = intervale;           //como si fuera una clase en el mismo package
        this.son = son;
    }

    //En plus cette class, aura une méthode de mettre en route le programme
    public void enMarche() {
        ActionListener listener = new DameHora();//esta clase ActionListener solo tiene un metodo dentro
        Timer miTemporisador = new Timer(intervale, listener);//que justamente pide como argumentos un (intervalo(segundos) y un objeto)
        miTemporisador.start();//es como el ejemplo de temporisateur pero metido en un metodo de la clase Reloj2
    }

    //CLASSE INTERNE --elle y accede aux attributs de la classe dans laquelle elle se trouve, su modificador es private
    private class DameHora implements ActionListener {//solo la clase interna puede acceder a los atributos de Reloj2 que la engloba.

        public void actionPerformed(ActionEvent e) {//Methode obligatoire de ActionListener
            Date ahora = new Date();
            System.out.println("Te pongo la hora cada 3 segundos :" + ahora);

            if (son) {//accedemos a los atributos private de la clase dentro de la cual se encuentra nuestra clase
                Toolkit.getDefaultToolkit().beep();
            }
        }
    }
}
//C’est les memes lignes de l’exemple intérieur mais cette fois ci, inclues dans une méthode

//Il nous manque qch car nous avons pas de classe donneHeure qui implemente l’interface ActionListener
//La classe dameHora, va donc être une classe interne
//La classe interne sera dans classe horloge
//Seulement les classes internes autorisent le modificateur d’accès private

//Nouveauté : Class interne : elle y accede aux attributs de la classe dans laquelle elle se trouve,
// sans avoir besoin de setters and getters
/*----------------------------------------------------------------------------------------------------------------------
Avantage de faire comme ca : on a pas besoin de créer des accesseurs setters, getters de la classe horloge pour changer
l’état de la variable et obtenir l’etat de la variable de l’extérieur

Classe interne on la fait quand on a 2 classes qui ont une RELATION ETROITE entre leurs METODES et ATTRIBUTS.
Les classes internes simplifient le code

----------------------------------------------------------------------------------------------------------------------*/
