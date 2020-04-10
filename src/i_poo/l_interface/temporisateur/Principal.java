package i_poo.l_interface.temporisateur;

import javax.swing.*;

public class Principal {
    public static void main(String[] args) {
        /*
        Dernier exemple d’interface, avant de commencer à expliquer les classes internes
        On va élaborer un temporisateur, un programme qui déclence une action chaque x secondes
        En console par exemple
        Pour élaborer un temporisateur en java on a besoin de la classe Timer
        Dans l’API on a plusieurs Timer

        De différents programmeurs ont donné par hasar le meme nom à leurs classes,
        Et ceci est possible du moment ou chaque classe soit stocké dans un package différent
        Objectifs des packages : Pouvoir créer classes avec le meme nom qu’autres programmeurs
        Pas de problème si c’est dans des packages différents

        Chacune de ces classes fait quelque chose de différent même si tout est lié au temps

        On va devoir importer le package

        Cette classe a un constructeur, Timer avec 2 parametres

        Le premier un int , et le deuxieme un parametre de type interface

        Timer(int delay, ActionListener listener)

        Exécute une action toutes les x millisecondes
        Declence une action toutes les 8000 millisecondes (8 secondes), et comme deuxieme parametre un objet de type interface

        ceci a une metodo start()    Starts the Timer, causing it to start sending action events to its listeners
        on importe java.swing qui a Timer

        On utilse le constructeur de Timer pour créer un objet
        Je veux par exemple qu’un message apparaisse toute les 5 secondes
        Le 2eme parametre de type interface on ne l’a pas crée encore, pour l’instant on l’appelera listener

        Si on clique sur ActionListener

        Si nous voulons utiliser cette interface, il faudrait importer le package

        Java.awt.event

        On avait vu que quand on implement une interface on est obligé de developper toutes les methodes de cette interface
        *Nous devons donc voir quelles méthodes a cette interface pour savoir les méthodes que nous devons developper
        * au momement d’implementer cette interface . Dans ce cas notre interface a juste une méthode

        Cette méthode est invoked quand une action advient
        //actionPerformed(ActionEvent e)
        C’est-à-dire que toutes les 5 secondes nous allons executer une action, on verra laquelle

        */


        /*
        Quand nous executerons cette methodes, ce qu’on fait c’est qu’on appellera cette methode
        actionPerformed(ActionEvent e) car elle est invoqué quand une action advienne

        Dans d’autre langage de programmation comme javascript on met une fonction comme 2 parametre et on dit
        que chaque 5 seconder execute cette fonction
        Relativement simple.

        Comme java est 100% orienté objet, java nous oblige à passer un objet, et cet objet doit être de type interface.
        Interface ActionListener .

        *On doit donc créer une classe qui implémente l’interface ActionListener pour ensuite créer un objet appartenant
        *à cette classe
        ----------------------------------------------------------------------------------------------------------------
        Au moment d’importe java.util.* ;
        Je peux utiliser la classe Date et je peux construire un objet Date
        Mais ca me crée une erreur dans le main2 car il se trouve que le package java.util contient aussi une
        classe Timer différente. On a importe les packages complets avec *. Il y a donc un conflit
        ----------------------------------------------------------------------------------------------------------------

        *Solution : Importer juste la classe dont on a besoin et pas tout le package
        Toute les 5 secondes il donnera cette instruction

        On va maintenant creer l’objet dans le main2
        La classe dameHora n’a pas de constructeur, java utilise donc le constructeur par default,
        Celui qui recoit pas de parametres et qui est sous entendu
        */

        //Creamos este objeto para poder ponerlo como parametro despues en el constructor de Timer
        DameHora listener = new DameHora();//se hace un objeto con el constructor par defaut de la interface ( que DameHora implementa)
        //esto solo tiene una classe inicializada propia a la interface ActionListener
        Timer monTemporisador = new Timer(5000, listener);// objeto de tipo Timer  metodo:start();
        monTemporisador.start();
        //Probleme quand java arrive a la derniere instruction, le programme meurt, son exécution s’arrête

        /*On doit donc se dévrouiller pour qu’il continue son execution
         Et qu’il soit en execution le temps que nous le souhaitons
         On pourrait utiliser une fenetre ShowInput Dialog
         Quand cette fenetre apparait et attend qch le programme continue en execution*/

        JOptionPane.showMessageDialog(null, "Pulsa aceptar para detener");

        /*
        Nous va donner une fenetre dans laquelle apparait le texte appuyer pour arreter et en dessous une touche accepter.
        En appuyant sur accepter, le programme continueJra son execution vers le bas et pour que le programme s’arrete
        on ajoute :
        System.exit(0) ; // arrete execution du programme

        la fenetre de Joption pane impide que la lectura del codigo llegue a System.exit(0) que es lo que hace que salgamos
        del programa ( y que se pare ) para continuar les doy ok al ventana de JOptionPane
         y el codigo continua slu lectura hacia abajo y llega
        a System.exit(0);
        */
        System.exit(0);
        /*
        On avait vu qu’on pouvait pas instancier une interface (ActionListener)
        Mais on pouvait instancier une interface en lui disant que c’est egal a un objet, celui qui l’implemente :
        ActionListener exemple=new donne_heure() ;
        Class donne_heure implements ActionListener

        LOS 2 FUNCIONAN:
        ActionListener exemple=new donne_heure() ;//interface padre//
        donne_heure exemple=new donne_heure() ;

        */


    }
}
