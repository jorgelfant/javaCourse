package i_poo.k_abstract.persona;

import java.util.Date;
import java.util.GregorianCalendar;

public class Empleado extends Persona {
    //private final String NOM; On mettra ca dans personne
    private String departamento;
    private Date debutContrat;
    private double salaire;

    private int idObjeto;
    private static int idStatico = 0;

    public Empleado(String NOM, double salaire, int annee, int mois, int jour) {
        super(NOM); //USAMES EL CONSTRUCTOR DE PERSONA en el que solo habia NOM ( o un SETTER en caso de un constructeur sin parametros)

        this.salaire = salaire;
        GregorianCalendar calendrier = new GregorianCalendar(annee, mois - 1, jour);//creation objet calendrier
        this.debutContrat = calendrier.getTime();//este metodo return un variable(objeto) de tipo Date

        setIdObjeto();
    }

    //Eliminamos 2eme constructeur
  /*public Empleado(String NOM) {
        //this.NOM = NOM;
        this(NOM, 30000, 2000, 1, 1);//VALEUR PAR DEFAUT APPEL A L'AUTRE CONSTRUCTEUR AVEC LE

    }
    */
    public void setDepartamento(String departamento) {

        this.departamento = departamento;
    }

    public String getDepartamento() {

        return departamento;
    }

    /* YA ESTA DECLARARO EN PERSONNA asi que lo eliminamos aqui
    public String getNOM() {

        return NOM;
    }
    */
    private void setIdObjeto() {
        this.idObjeto = ++idStatico;//aumenta antes de ser copiado   osea ++0=1 esto podria irr en el constructor
        //el valor de id a cada objeto creado, ya que idStatico funciona con la clase y no con el objeto
        //idObjeto = ++idStatico; o en una sola linea asi podria solo declarar las 2 variables idObjeto e idStatico sin valor
    }

    public int getIdObjeto() {

        return idObjeto;
    }

    public static int getIdStatico() {

        return idStatico;
    }


    public double getSalaire() {//si fuera final , este metodo no podria ser heredado ni modificado (constante)
        //y por consiguiente no podria tener el mismo nombre y funcionar diferente(polimorfismo)
        return salaire;
    }

    public Date getDebutContrat() {
        return debutContrat;
    }


    //ABSTRACT INICIAR ESTO ES NECESARIO PORQUE HEREDAMOS DE UNA CLASE ABSTRACTA SINON ERROR
    public String donne_description() {//METODO ABSTRACTO
        return "dame datos, Nom: " + super.getNOM() + " " + this.idObjeto + " debut contrat: " + this.debutContrat + " salaire: " + this.salaire;
    }

}
