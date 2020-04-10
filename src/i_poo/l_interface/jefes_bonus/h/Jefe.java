package i_poo.l_interface.jefes_bonus.h;

public class Jefe extends Empleado implements Jefes {//al implementar Jefes lo obligamos a inicializar el metodo de la interface
    //Jefe tambien tendra el metodo que tiene la interface (metodo heredado de otra interface Bonus)
    // jefes extends bonus
    //******************************************************************************************************************
    //                                     CONSTRUCTEUR
    //******************************************************************************************************************

    private double prime;

    public Jefe(String NOM, double salaire, int annee, int mois, int jour) {
        super(NOM, salaire, annee, mois, jour);//avec super on importe le constructeur de la superClass
    }

    //******************************************************************************************************************
    //                                METODO ABSTRACT DE LA INTERFACE
    //******************************************************************************************************************
    //si Jefe ya no implementara Jefes no necesitariamos poner este metodo ya que empleado la tiene y Jefe hereda de Empleado
    //pero esto solo en el caso de pruebas en el que empleado implementara tb JEfes
    public String prendreDecisions(String decision) {
        return "La decision es : " + decision;//o solo decision
    }

    //la interface Jefes ha heredado de otra interface Bonus, Jefes contiene entonces sus metodos y los de Bonus( que sera un interface MERE)
    //la clase que hereda Jefes debe en consecuencia inicializar ambos metodos

    /*
    On dit de retourner d’un coté  le bonus de base (1500) ( constante de salaries) + le bonus qu’on passera
    par parametre + la prime 2000. Car les chefs ont plus de privilges dont une prime
    */

    public String donneBonus(double bonus) {
        double prime = 2000;
        return "El bonus es de " + (Bonus.bonusBase + bonus + prime);
    }                              //bonusbase constante statica de la classe Bonus

    //******************************************************************************************************************
    //                                SETTER POUR DONNER LA PRIME
    //******************************************************************************************************************
    public void setPrime(int prime) {
        this.prime = prime;
    }

    //En Empleado teniamos un metodo para dar salario pero no prime
    //******************************************************************************************************************
    //                                GETTER POUR DONNER LA PRIME
    //******************************************************************************************************************
    public double getSalaire() {//POLIMORFISMO en esta classe hija el metodo getSalaire sera remplazado por la nueva
        //double salaireChef = super.getSalaire();
        return super.getSalaire() + prime;
    }

    //Si cette methode etait final dans la SuperClass et que je peux pas la modifier mais que je veux quand même m'en servir
    // la solution serait de changer de nom para poder usarla

    /*
    public double getSalaire2() {               //cambio el nombre
        //double salaireChef = getSalaire();
        return super.getSalaire() + prime;      //Asi podria usarla qm sin modificarla
    }
    */
}

