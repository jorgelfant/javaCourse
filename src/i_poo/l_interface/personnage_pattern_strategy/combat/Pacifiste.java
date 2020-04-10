package i_poo.l_interface.personnage_pattern_strategy.combat;

public class Pacifiste implements EspritCombatif{
    public void combat(){
        System.out.println("Je ne combats pas !");
    }
}
