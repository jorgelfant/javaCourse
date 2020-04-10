package i_poo.r_genericité.C_metodosGenericosPropios.Herencia_TiposComodin;

public class Empleado {

    private String nom;
    private int edad;
    private double salaire;


    public Empleado(String nom, int edad, double salaire) {
        this.nom = nom;
        this.edad = edad;
        this.salaire = salaire;
    }

    public String dameDatos() {
        return "El empleado se llama " + nom + ". tiene " + edad + " anios." + " y un salario de " + salaire;
    }

}

