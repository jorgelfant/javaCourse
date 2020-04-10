package i_poo.c_empleado_heritage_casting;

public class Jefe extends Empleado {
    //Si queremos crear jefes y que estos reciban ademas del salario un incentivo
    //me sirve la classe empleado? si porque un jefe es un empleado

    //Mi classe Empleado tiene 2 constructores, uno por defaut y otro con parametros (surcharge de constructeurs)

    /*CAS PARFAIT POUR UN HERITAGE,  créer une nouvelle classe appelé chef et qu’elle hérite d’employé, et celle-ci
    doit hériter d’employé ! pourquoi ? car un chef continue d’avoir un nom, un salaire, une date de debut et aura
    en plus une prime. L’idéal serait de créer une classe chef qui nous permettent de créer des objets de type chef
    qui herite  toutes les caracteristiques de la classe employé pour ajouter nom, salaire et date_debut et en plus
    rajoute la fonctionnalité de donner une prime

    Un chef est toujours un employé ??? OUI     sous classe , classe fille
    Un employé est toujours un chef ? NON     un employé peut etre un secrataire, maintenance, etc
    mais pas forcement un CHEF.

    Quand on met rien eclipse assume qu’on appelle a un constructeur par defaut dans ce cas public employee, et là
    eclipse decouvre qu’il n’y a pas de constructeur par default qui recoive 0 parametres car les 2 constructeurs
    recoivent parametres, d’où l’erreur

    Super() ; était valide quand le constructeur de l’exemple precedent ne recevait pas de parametres,
    Mais ici les 2 constructeurs recoivent parametres (la classe père a 2 constructeurs)

    EN fonction de parametres qu’on met, il appelera au 1 constructeur ou au deuxieme
    5 parametres 1 constructeur
    1 parametre 2 constructeur */

    //******************************************************************************************************************
    //                                CONSTRUCTEUR
    //******************************************************************************************************************

    private double prime;

    public Jefe(String NOM, double salaire, int annee, int mois, int jour) {
        super(NOM, salaire, annee, mois, jour);//avec super on importe le constructeur de la superClass
    }

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
