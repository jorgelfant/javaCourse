package i_poo.l_interface.personnage_pattern_strategy;

//IMPORTAMOS LOS PACKAGES DONDE HEMOS PUESTO LAS INTERFACES Y SUS SUBCLASSES
//no basta con importar el package, se debe importar despues del package el nombre del archivo (classe /interface/ etc)

import i_poo.l_interface.personnage_pattern_strategy.combat.EspritCombatif;
import i_poo.l_interface.personnage_pattern_strategy.combat.Pacifiste;
import i_poo.l_interface.personnage_pattern_strategy.deplacement.Deplacement;
import i_poo.l_interface.personnage_pattern_strategy.deplacement.Marcher;
import i_poo.l_interface.personnage_pattern_strategy.soin.AucunSoin;
import i_poo.l_interface.personnage_pattern_strategy.soin.Soin;

public abstract class Personnage {//SUPER ABSTRACT CLASS
    /*
    //ACCESSOIRES POUR DETERMINER COMPORTEMENT
    private String armes = ""; //OBLIGADO PONER "" porque en los metodos en los if , el else interpreta "" como un
    private String chaussure = "";                 //String aunque este vacio, SINO ponemos "" , else lo interpretara
    private String sacDeSoin = "";                 //como Null que es el valor de un String no inicializado
    //Null es como decir objeto vacio objeto no presente

    //        "" means a value with empty.
    //        null means no value.  no object nothing*/

    //******************************************************************************************************************
    //                                    VARIABLES de tipo Objeto (hechos con la interface desde afuera)
    //******************************************************************************************************************
    private EspritCombatif espritCombatif = new Pacifiste();//comportamiento par defaut
    private Soin soin = new AucunSoin();                    //comportamiento par defaut
    private Deplacement deplacement = new Marcher();        //comportamiento par defaut
    //******************************************************************************************************************
    //                                    CONSTRUCTOR 1 PAR DEFAUT
    //******************************************************************************************************************
    public Personnage() {
        //OJO en vez de poner afuera las variables inicializadas con un valors par defaut las hubiera podido poner aqui, EGAL
    }
    //******************************************************************************************************************
    //                                          CONSTRUCTOR 2
    //******************************************************************************************************************
    public Personnage(EspritCombatif espritCombatif, Soin soin, Deplacement deplacement) {
        this.espritCombatif = espritCombatif;
        this.soin = soin;
        this.deplacement = deplacement;
    }
    //******************************************************************************************************************
    //                                     SETTERS (si jamais on veut modifier ce qu'on a déjà mis dans le constructeur)
    //******************************************************************************************************************
    //redefinir un type de espritCombatif
    public void setEspritCombatif(EspritCombatif espritCombatif) {
        this.espritCombatif = espritCombatif;
    }
    //redefinir un soin
    public void setSoin(Soin soin) {
        this.soin = soin;
    }
    //redefinir un type de deplacement
    public void setDeplacement(Deplacement deplacement) {
        this.deplacement = deplacement;
    }
    //******************************************************************************************************************
    //                                                GETTERS(no necesario aqui)
    //******************************************************************************************************************
    public EspritCombatif getEspritCombatif() {
        return this.espritCombatif;
    }
    //retourner el type de soin (la methode del type de soin)
    public Soin getSoin() {
        return this.soin;
    }
    //retourner el type de deplacement (la methode del type de deplacement)
    public Deplacement getDeplacement() {
        return this.deplacement;
    }
    //******************************************************************************************************************
    //                                  METHODES (nos servimos del polimorfismo gracias al superType Interface)
    //******************************************************************************************************************
    //On utilise les objets de espritCombatif(variable objet) de façon polymorphe
    public void combattre() {
        this.espritCombatif.combat();//evitamos escribir gracias al metodo que contiene el objeto que tiene el metodo(comportement)
    }
    //On utilise les objets de deplacement de façon polymorphe
    public void seDeplacer() {
        deplacement.deplacer();
    }
    //On utilise les objets de soigner de façon polymorphe
    public void soigner() {
        soin.soigner();
    }

}
