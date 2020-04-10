package i_poo.t_classAnonymes;


public class Civil extends Personnage {

    //CONSTRUCTOR 1
    public Civil() {

    }
    //CONSTRUCTOR 2
    public Civil(EspritCombatif espritCombatif, Soin soin, Deplacement deplacement) {
        super(espritCombatif, soin, deplacement);
    }


}
