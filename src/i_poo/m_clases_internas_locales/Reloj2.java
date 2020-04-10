package i_poo.m_clases_internas_locales;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

public class Reloj2 {
    //Constructor no necesario
    //al ser puestas aqui ,deben ser declaradas FINAL (REGLA)
    //On est pas obligé de déclarer final int car on ne l’utilise pas
    public void enMarche( int intervale, final boolean son) {
        //CLASE INTERNA LOCAL (dentro del metodo) es util pa encapsular y cuando solo se hara un objeto de esta clase
        //ejemplo: un objeto de tipo ActionListener
        //el modificador de la class ne puede ser public (normalmente este es private) ni private, se BORRA el modificador
         class DameHora implements ActionListener {//solo la clase interna puede acceder a los atributos de Reloj2 que la engloba.
            public void actionPerformed(ActionEvent e) {//Methode obligatoire de ActionListener
                Date ahora = new Date();
                System.out.println("Te pongo la hora cada 3 segundos :" + ahora);

                if (son) {//accedemos a los atributos private de la clase dentro de la cual se encuentra nuestra clase
                    Toolkit.getDefaultToolkit().beep();
                }
            }
        }//codigo del metodo
        ActionListener listener = new DameHora();//esta clase ActionListener solo tiene un metodo dentro
        Timer miTemporisador = new Timer(intervale, listener);//que justamente pide como argumentos un (intervalo(segundos) y un objeto)
        miTemporisador.start();//es como el ejemplo de temporisateur pero metido en un metodo de la clase Reloj2
    }
}//CLASSE INTERNE --elle y accede aux attributs de la classe dans laquelle elle se trouve
/*-------------------------------------------------------------------------
La classe est encapsuléé, elle est même pas visible para la classe externe, on va voir si ca peut etre encore plus
simplifié.

La clase interna peut accéder aux attributs de la classe externe et aux attributs de la méthode qui l'englobe
Mais la CLASSE EXTERNE ne peut pas accéder à la classe interne sauf à travers la méthode.

Nos avions déclaré 2 variables "intervale" et "son" dans la classe EXTERNE
NOUS POUVONS LES SUPPRIMER ET LES DECLARER COMME "VARIABLES LOCALES" DE LA METODO EnMarche

Ceci a permis de Simplifier le code énormément

DETALLES:
En lugar de poner Toolkit.getDefaultToolkit().beep();
podriamos poner

Toolkit entorno=Toolkit.getDefaultKit();  //recupera el entorno y lo pone en un objeto de tipo Toolkit (getter)
entorno.beep();   el objeto entorno de la clase Toolkit utiliza el metodo beep()

*/