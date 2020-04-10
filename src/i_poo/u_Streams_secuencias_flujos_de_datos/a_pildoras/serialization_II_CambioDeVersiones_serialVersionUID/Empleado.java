package i_poo.u_Streams_secuencias_flujos_de_datos.a_pildoras.serialization_II_CambioDeVersiones_serialVersionUID;

import java.io.Serializable;
import java.util.Date;
import java.util.GregorianCalendar;

public class Empleado implements Serializable {


    private final String NOM;
    private String departamento;
    private Date debutContrat;
    private double salaire;

    private int idObjeto;
    private static int idStatico = 0;
    //serialVersionUID
    private static final long serialVersionUID=1L;

    //******************************************************************************************************************
    //                                         CONSTRUCTOR 1 (SURCHARGE DE CONSTRUCTEURS)
    //******************************************************************************************************************
    public Empleado(String NOM, double salaire, int annee, int mois, int jour) {
        this.NOM = NOM;                             //pas besoin de declarer annee mois jour car c pour un autre constructeur
        this.salaire = salaire;
        GregorianCalendar calendrier = new GregorianCalendar(annee, mois - 1, jour);//creation objet calendrier
        this.debutContrat = calendrier.getTime();//este metodo return un variable(objeto) de tipo Date

        setIdObjeto();
    }

    //******************************************************************************************************************
    //                                         CONSTRUCTOR 2 (SURCHARGE DE CONSTRUCTEURS)
    //******************************************************************************************************************
    public Empleado(String NOM) {
        this(NOM, 30000, 2000, 1, 1);//VALEUR PAR DEFAUT APPEL A L'AUTRE CONSTRUCTEUR AVEC LE
    }

    //******************************************************************************************************************
    //                                 SETTER Y GETTER DE departamento
    //******************************************************************************************************************
    public void setDepartamento(String departamento) {

        this.departamento = departamento;
    }

    public String getDepartamento() {

        return departamento;
    }

    //******************************************************************************************************************
    //                                   NOM sin getter porque como es final no podra cambiar
    //******************************************************************************************************************
    public String getNOM() {

        return NOM;
    }

    private void setIdObjeto() {
        this.idObjeto = ++idStatico;
    }

    public int getIdObjeto() {
        return idObjeto;
    }

    //******************************************************************************************************************
    //                            Da la fecha de inicio del contrato
    //******************************************************************************************************************
    public Date getDebutContrat() {
        return debutContrat;
    }

    //******************************************************************************************************************
    //                            PA RECUPERAR EL VALOR DE LA VARIABLE STATICA
    //******************************************************************************************************************
    public static int getIdStatico() {
        return idStatico;
    }

    //******************************************************************************************************************
    //                                 Aumentar SALAIRO
    //******************************************************************************************************************
    public void aumenterSalaire(double pourcentage) {
        double augmentation = salaire * pourcentage / 100;
        salaire += augmentation;
    }

    //******************************************************************************************************************
    //                                    SALARIO
    //******************************************************************************************************************
    public double getSalaire() {
        return salaire;
    }

    //******************************************************************************************************************
    //                     METODO INTERNO PARA DAR DATOS GENERALES (version reccourcie)
    //******************************************************************************************************************
    public String toString() {

        return "Empleado " + this.idObjeto + ", Nombre: " + this.NOM + ", debut contrat: " + this.debutContrat + ", salaire: " + this.salaire;
    }
}
