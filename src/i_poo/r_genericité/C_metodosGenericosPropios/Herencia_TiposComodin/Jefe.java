package i_poo.r_genericité.C_metodosGenericosPropios.Herencia_TiposComodin;

public class Jefe extends Empleado {//hereda de Empleado

    private double prime;

    public Jefe(String nom, int edad, double salaire) {
        super(nom, edad, salaire);//avec super on importe le constructeur de la superClass
    }

    public double getPrime() {
        return prime;
    }


}
