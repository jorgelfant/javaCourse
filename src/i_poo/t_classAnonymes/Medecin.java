package i_poo.t_classAnonymes;

public class Medecin extends Personnage {

    //CONSTRUCTOR 1
    public Medecin() {
        this.setSoin(new Soin() {
            public void soigner() {
                System.out.println("Je donne les premiers soins !");
            }
        });
    }

    //CONSTRUCTOR 2
    public Medecin(EspritCombatif espritCombatif, Soin soin, Deplacement deplacement) {
        super(espritCombatif, soin, deplacement);
    }

}
