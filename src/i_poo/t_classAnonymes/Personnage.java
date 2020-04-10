package i_poo.t_classAnonymes;

//IMPORTAMOS LOS PACKAGES DONDE HEMOS PUESTO LAS INTERFACES Y SUS SUBCLASSES
//no basta con importar el package, se debe importar despues del package el nombre del archivo (classe /interface/ etc)

public abstract class Personnage {//SUPER ABSTRACT CLASS

    //******************************************************************************************************************
    //                                    VARIABLES de tipo Objeto (hechos con la interface desde afuera)
    //******************************************************************************************************************
    private EspritCombatif espritCombatif = new EspritCombatif() {
        public void combat() {
            System.out.println("Je ne me combats pas !");
        }
    };
    private Soin soin = new Soin() {
        @Override
        public void soigner() {
            System.out.println("Je ne soigne pas !");
        }
    };
    private Deplacement deplacement = new Deplacement() {
        @Override
        public void deplacer() {
            System.out.println("Je me déplace à pieds !");
        }
    };

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
