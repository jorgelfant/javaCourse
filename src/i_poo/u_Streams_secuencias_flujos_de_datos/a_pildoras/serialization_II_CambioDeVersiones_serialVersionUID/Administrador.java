package i_poo.u_Streams_secuencias_flujos_de_datos.a_pildoras.serialization_II_CambioDeVersiones_serialVersionUID;

public class Administrador extends Empleado {

    private double prime;
    //serialVersionUID
    private static final long serialVersionUID=1L;

    public Administrador(String NOM, double salaire, int annee, int mois, int jour) {
        super(NOM, salaire, annee, mois, jour);
        prime = 0;
    }


    public void setPrime(int prime) {
        this.prime = prime;
    }

    public double getSalaire() {
        double salaireBase = super.getSalaire();
        return salaireBase + prime;
    }

    public String toString() {
        return super.toString() + ", Prima: " + prime;
    }
}
