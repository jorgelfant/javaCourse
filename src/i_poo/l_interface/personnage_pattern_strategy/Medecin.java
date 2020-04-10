package i_poo.l_interface.personnage_pattern_strategy;

import i_poo.l_interface.personnage_pattern_strategy.combat.EspritCombatif;
import i_poo.l_interface.personnage_pattern_strategy.deplacement.Deplacement;
import i_poo.l_interface.personnage_pattern_strategy.soin.PremierSoin;
import i_poo.l_interface.personnage_pattern_strategy.soin.Soin;

public class Medecin extends Personnage {
    /*
    public void combattre() {
        //metodo combattre de Personnage redefinido
        if (this.getArmes().equals("pisolet")) {
            System.out.println("Attaque au pistolet !");
        } else {
            System.out.println("vive le scalpel !");
        }
    }

    //************************************Methode propre à Medecin******************************************************
    public void soigner() {
        //metodo combattre de Personnage redefinido
        if (this.getsacDeSoin().equals("petit sac")) {
            System.out.println("Je peux recoudre les blessures.");
        } else {
            System.out.println("Je soigne les blessures.");
        }
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
    public Medecin() {
        this.setSoin(new PremierSoin()); //utilizamos el seter para cambiar el valor de la variable par defaut
    }                                               //de la super classe Personnage
    //un PERSONNAGE par defaut no donne aucun soin pero un MEdecin SI!!

    //CONSTRUCTOR 2
    public Medecin(EspritCombatif espritCombatif, Soin soin, Deplacement deplacement) {
        super(espritCombatif, soin, deplacement);
    }

    //Asi podremos construir objetos de la subclasse con cualquiera de los 2 constructores;
    //EN EL PAR DEFAUT ES OPCIONAL PONER super() ya que lo pongamos o no este pointe (automaticamente)
    // al constructeur sin parametros del padre una vez que lo reescribimos en la subclase.
}
