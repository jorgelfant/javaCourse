package i_poo.l_interface.personnage_pattern_strategy;

import i_poo.l_interface.personnage_pattern_strategy.combat.EspritCombatif;
import i_poo.l_interface.personnage_pattern_strategy.deplacement.Deplacement;
import i_poo.l_interface.personnage_pattern_strategy.soin.Soin;


public class Civil extends Personnage {
    /*
    //al no poner nada agarrara el metodo combattre() par defaut del padre  "Je ne combats pas"
    public void combattre() {
        //metodo combattre de Personnage redefinido
        if (this.getArmes().equals("couteau")) {
            System.out.println("Attaque au couteau !");
        } else {
            System.out.println("Je ne combats pas");
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
    public Civil() {
      //Aqui en el constructeur par defaut no reescribimos ninguna variable porque un civil es lo mas cercano a una persona
      // PERSONNAGE, asi el constructeur par defaut de Civil reprendra los valor par defaut de Personnage
    }
    //CONSTRUCTOR 2
    public Civil(EspritCombatif espritCombatif, Soin soin, Deplacement deplacement) {
        super(espritCombatif, soin, deplacement);
    }

    //Asi podremos construir objetos de la subclasse con cualquiera de los 2 constructores;
    //EN EL PAR DEFAUT ES OPCIONAL PONER super() ya que lo pongamos o no este pointe (automaticamente)
    // al constructeur sin parametros del padre una vez que lo reescribimos en la subclase.
}
