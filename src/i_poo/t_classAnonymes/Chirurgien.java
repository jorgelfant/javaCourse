package i_poo.t_classAnonymes;

public class Chirurgien extends Personnage {

    //CONSTRUCTOR 1
    public Chirurgien() {
        setSoin(new Soin() {
            @Override
            public void soigner() {
                System.out.println("Je fais des opérations !");
            }
        });

    }
    //CONSTRUCTOR 2
    public Chirurgien(EspritCombatif espritCombatif, Soin soin, Deplacement deplacement) {
        super(espritCombatif, soin, deplacement);
    }

}
