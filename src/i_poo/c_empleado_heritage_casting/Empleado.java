package i_poo.c_empleado_heritage_casting;

import java.util.Date;
import java.util.GregorianCalendar;

public class Empleado {
    /*
    on crée une classe essai, on crée une classe employé, mais de forme plus simple. Une classe employé capable
    de construire instances (objets) dans lesquels l’employé ait juste un NOM et une section dans l’entreprise.
    Tous les employés qui commencent dans l’entreprise commencent dans le département d’administration.
    */
    private final String NOM;//final constante para impedir que el nombre de la persona cambie durante la conception del programa
    private String departamento;//NOM en majuscule car c'est une constante et comme ca le code source le reconnait Exemple_1 de suite
    private Date debutContrat;
    private double salaire;

    private int idObjeto;
    private static int idStatico = 0;//depende de la clase y no del objeto

    //EL CONSTRUCTOR SIRVE A DAR UN ESTADO INICIAL A NUESTROS OBJETOS
    //ES POSIBLE ESCOJER QUE ESTADO INICIAL DESEAMOS DAR A NUESTROS OBJETOS CREANDO DIFERENTES CONSTRUCTORES
    //NOMBRE DIFFERENT DE PARAMETRES les différencient OU LE TIPE DE PARAMETRE
    //******************************************************************************************************************
    //                                         CONSTRUCTOR 1 (SURCHARGE DE CONSTRUCTEURS)
    //******************************************************************************************************************

    //On peut créer autant de constructeur que l'on veut mais avec des paramètres différents
    public Empleado(String NOM, double salaire, int annee, int mois, int jour) {
        this.NOM = NOM;                             //pas besoin de declarer annee mois jour car c pour un autre constructeur
        this.salaire = salaire;
        GregorianCalendar calendrier = new GregorianCalendar(annee, mois - 1, jour);//creation objet calendrier
        this.debutContrat = calendrier.getTime();//este metodo return un variable(objeto) de tipo Date

        setIdObjeto();//ponemos la funcion solo en este constructor, y no en el otro porque la funcion del otro constructor
        //es entrar a este constructor para sirviendose en sus parametros llenar datos por defecto
        //ya que si estuviera en los 2 a cada llamado del constructor esta funcion se ejecutaria 2 veces
        //una en el otro constructor y otra aqui
    }

    //******************************************************************************************************************
    //                                         CONSTRUCTOR 2 (SURCHARGE DE CONSTRUCTEURS)
    //******************************************************************************************************************

    //Imaginos que l'on connaît pas le salaire d'un des employé car il vient de commencer à travailler dans l'entreprise
    //On connaît que son NOM, à ce moment là on ne peut pas donner le même état initial à cet objet
    //On connaît que le NOM et on cherchera à donner les autres données para defaut de base car on connaît pas les vrais
    public Empleado(String NOM) {
        //this.NOM = NOM;
        this(NOM, 30000, 2000, 1, 1);//VALEUR PAR DEFAUT APPEL A L'AUTRE CONSTRUCTEUR AVEC LE
        //this.departamento = "Administration";             //même nombre de paramètres et lui passe les valeurs corresponantes
        //NOM donc qui est le seul paramètre que je connais ira se
        //stocker dans NOM mais de l'autre constructeur

        // setIdObjeto(); idObjeto = ++idStatico; va a buscar el aumentador que sera private y se hara de forma automatica
        // no accessible
    }
    //LA manière d'appeler le constructeur aidera JAVA a identifier de quel constructeur il s'agit

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
    /*
    On va créer un autre setter ou le mot final aura du sens
    Si l’on veut s’assurer que la variable NOM ne se modifie pendant les milliers de lignes de code d’un programme.
    Il faut déclarer cette variable comme constante
    */

    //OBTENEMOS LA VARIABLE STATIC
    //******************************************************************************************************************
    //                     getIdObjeto() VA RETORNAR ID QUE CONTIENE idStatico
    //******************************************************************************************************************
    //ESTO PERMITIRA ASOCIAR EL ID AL OBJETO
    //si solo pusieramos id++, en el objeto habria que imprimir los datos despues de este para que la variable static
    //siga a vanzando 1 2 3 etc
    //
    //EmpleadoFinal empleado1 = new EmpleadoFinal("Jorge");
    //System.out.println(EmpleadoFinal.getId());  y asi sucesivamente
    //
    //
    //esto porque la variable estatica funciona de manera independiente al objeto
    //si crearamos 3 objetos y despues de estos 3 queremos imprimir los datos, nos daria el mismo EmpleadoFinal.getId()
    // a los 3  en este caso daria 3 a cada objeto. ya que la creacion de objeto hace avanzar al contador pero este
    //no esta afiliado al objeto

    private void setIdObjeto() {
        this.idObjeto = ++idStatico;//aumenta antes de ser copiado   osea ++0=1 esto podria irr en el constructor
        //el valor de id a cada objeto creado, ya que idStatico funciona con la clase y no con el objeto
        //idObjeto = ++idStatico; o en una sola linea asi podria solo declarar las 2 variables idObjeto e idStatico sin valor
    }

    public int getIdObjeto() {

        return idObjeto;
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
