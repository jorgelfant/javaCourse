package i_poo.l_interface.personnage_pattern_strategy.soin;

public class AucunSoin implements Soin{
    public void soigner(){
        System.out.println("Je ne donne AUCUN soin !");
    }
}
