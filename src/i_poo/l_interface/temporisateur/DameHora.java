package i_poo.l_interface.temporisateur;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

public class DameHora implements ActionListener {
    public void actionPerformed(ActionEvent e) {//Methode obligatoire de ActionListener
        Date ahora = new Date();//implementamos el metodo decimos por ejemplo que queremos que nos envie un objeto
        //de tipo date que contiene la hora
        //Toute les 5 secondes il donnera cette instruction
        System.out.println("Te pongo la hora cada 5 segundos :" + ahora);
    }
}
/*
On va maintenant creer l’objet dans le main2
La classe donne_heure n’a pas de constructeur, java utilise donc le constructeur par default,
Celui qui recoit pas de parametres et qui est sous entendu

*/