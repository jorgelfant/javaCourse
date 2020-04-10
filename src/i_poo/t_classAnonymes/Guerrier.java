package i_poo.t_classAnonymes;

public class Guerrier extends Personnage {

    //CONSTRUCTOR 1
    public Guerrier() {
        this.setEspritCombatif(new EspritCombatif() {
                                   @Override
                                   public void combat() {
                                       System.out.println("Je me bats avec mon pistolet");
                                   }
                               }
        );
    }

    //CONSTRUCTOR 2
    public Guerrier(EspritCombatif espritCombatif, Soin soin, Deplacement deplacement) {
        super(espritCombatif, soin, deplacement);
    }


}
