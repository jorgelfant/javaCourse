package i_poo.l_interface.jefes_bonus.h;

import java.util.Date;
import java.util.GregorianCalendar;


public class Empleado implements Comparable,Bonus {//implementar Jefes solo pa hacer pruebas

    private final String NOM;//final constante para impedir que el nombre de la persona cambie durante la conception del programa
    private String departamento;//NOM en majuscule car c'est une constante et comme ca le code source le reconnait Exemple_1 de suite
    private Date debutContrat;
    private double salaire;

    private int idObjeto;
    private static int idStatico = 0;//depende de la clase y no del objeto

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
        //this.NOM = NOM;
        this(NOM, 30000, 2000, 1, 1);

    }

    //******************************************************************************************************************
    //                 HEMOS IMPLEMENTADO LA INTERFACE Comparable, esto nos obliga a inicializar su(s) metodo
    //******************************************************************************************************************
    //Quand on écrit la méthode dans la classe on met public pour qu’elle soit accessible
    //Public int car elle return an int

    //Je dois faire une refundition car on a un type objet que je dois transformer en employe, je fais un cast
    //
    public int compareTo(Object miObjeto) {//comparaTo(T o)  return int  compares this object with the specific object for order
        Empleado otroEmpleado = (Empleado) miObjeto;
        //this.salaire=Empleado.salaire;         hubieramos tb podido comparar por iD
        if (this.salaire < otroEmpleado.getSalaire()) {
            return -1;
        }
        if (this.salaire > otroEmpleado.getSalaire()) {
            return 1;
        }
        return 0;
    }
    //******************************************************************************************************************
    //                 HEMOS IMPLEMENTADO LA INTERFACE Bonus, esto nos obliga a inicializar su(s) metodos
    //******************************************************************************************************************
    public String donneBonus(double bonus) {
        return "El bonus es de " + (Bonus.bonusBase + bonus) ;
    }
    //a diferencia de Jefe, cuyo metodo implementado de Jefes le dabamos tb una prime par defaut
    //Empleados no tendra la prime par defaut

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
    /*
    public void setNom(String NOM) {   este metodo no funciona porque no se puede cambiar el valor de una constante
        this.NOM = NOM;
    }
    */
    public String getNOM() {

        return NOM;
    }

    //OBTENEMOS LA VARIABLE STATIC
    //******************************************************************************************************************
    //                     getIdObjeto() VA RETORNAR ID QUE CONTIENE idStatico
    //******************************************************************************************************************
    private void setIdObjeto() {
        this.idObjeto = ++idStatico;//aumenta antes de ser copiado   osea ++0=1 esto podria irr en el constructor
        //el valor de id a cada objeto creado, ya que idStatico funciona con la clase y no con el objeto
        //idObjeto = ++idStatico; o en una sola linea asi podria solo declarar las 2 variables idObjeto e idStatico sin valor
    }

    public int getIdObjeto() {

        return idObjeto;
    }

    public Date getDebutContrat() {

        return debutContrat;
    }

    //******************************************************************************************************************
    //                     PA RECUPERAR EL VALOR DE LA VARIABLE STATICA
    //******************************************************************************************************************

    public static int getIdStatico() {

        return idStatico;
    }

    //******************************************************************************************************************
    //                     METODO INTERNO PARA DAR DATOS GENERALES (version reccourcie)
    //******************************************************************************************************************
    public String datos() {

        return "dame datos " + this.idObjeto + " debut contrat: " + this.debutContrat + " salaire: " + this.salaire;
    }

    //******************************************************************************************************************
    //                                    SALARIO
    //******************************************************************************************************************
    public double getSalaire() {//si fuera final , este metodo no podria ser heredado ni modificado (constante)
        //y por consiguiente no podria tener el mismo nombre y funcionar diferente(polimorfismo)
        return salaire;
    }
    /*
    SOLUTIONS :
    On n’hérite pas d’Empleado , du coup cette classe Jefe n’aurait rien à voir avec Empleado
    OU
    Si l’on a vraiment besoin que la methode herite d’Empleado alors on peut appeler la méthode  différemment

    */


}
