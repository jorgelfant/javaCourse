package i_poo.l_interface.personnage_pattern_strategy;

import i_poo.l_interface.personnage_pattern_strategy.combat.EspritCombatif;
import i_poo.l_interface.personnage_pattern_strategy.deplacement.Deplacement;
import i_poo.l_interface.personnage_pattern_strategy.soin.Operation;
import i_poo.l_interface.personnage_pattern_strategy.soin.Soin;

public class Chirurgien extends Personnage {
    /*
    // je ne combats pas,  je me deplace a pieds

    //************************************Methode propre à Medecin******************************************************
    public void soigner(){
        if(this.getsacDeSoin().equals("gros sac"))
            System.out.println("Je fais des merveilles.");
        else
            System.out.println("Je fais des opérations.");
    }
    */
    //----------------------------------------------------------------------------------------------------------------------
    //SUPER IMPORTANTE AGREGAR(igual o modificado) LOS 2 CONSTRUCTORES EN LA SUBCLASE, SOLO SE PUEDE USAR EL CONSTRUCTOR
    // QUE HA SIDO REESCRITO EN LA SUBCLASSE PARA CREAR UN OBJETO DE LA SUPER CLASE
    //si solo agrego el 1ro, solo podre usar el primero
    //si agrego el 2do solo podre usar el segundo
    //si AGREGO AMBOS entonces PODRE USAR AMBOS!!!!
//----------------------------------------------------------------------------------------------------------------------
    //CONSTRUCTOR 1
    public Chirurgien() {
        this.setSoin(new Operation()); //utilizamos el seter para cambiar el valor de la variable par defaut
    }                                               //de la super classe Personnage
    //un PERSONNAGE par defaut no opera pero un CHIRURGIEN SI!!

    //CONSTRUCTOR 2
    public Chirurgien(EspritCombatif espritCombatif, Soin soin, Deplacement deplacement) {
        super(espritCombatif, soin, deplacement);
    }

    //Asi podremos construir objetos de la subclasse con cualquiera de los 2 constructores;
    //EN EL PAR DEFAUT ES OPCIONAL PONER super() ya que lo pongamos o no este pointe (automaticamente)
    // al constructeur sin parametros del padre una vez que lo reescribimos en la subclase.
}
