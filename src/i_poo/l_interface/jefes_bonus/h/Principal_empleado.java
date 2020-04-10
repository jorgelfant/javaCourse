package i_poo.l_interface.jefes_bonus.h;

import java.util.Arrays;

public class Principal_empleado {
    public static void main(String[] args) {

        //On va créer un objet de la classe Jefe
        Jefe jefeRH = new Jefe("Luis", 60000, 2010, 3, 25);//1
        jefeRH.setPrime(3000);//doy prime
        System.out.println(jefeRH.getSalaire());//va utilisar el metodo redefinido

        //ARREGLO MIS EMPLEADOS
        Empleado[] misEmpleados = new Empleado[6];

        misEmpleados[0] = new Empleado("Jorge", 60000, 2010, 3, 5);//2
        misEmpleados[1] = new Empleado("Maria", 32000, 2015, 5, 2);//3
        misEmpleados[2] = new Empleado("Carol", 20000, 2013, 7, 3);//4
        misEmpleados[3] = new Empleado("Claudia", 50000, 2011, 1, 25);//5

        misEmpleados[4] = jefeRH;//1

        misEmpleados[5] = new Jefe("July", 70000, 2001, 1, 5);//6

        for (Empleado e : misEmpleados) {
            System.out.println(e.getIdObjeto() + " " + e.getSalaire());
        }

        Jefe convertido = (Jefe) misEmpleados[5];

        convertido.setPrime(200);
        System.out.println(convertido.getSalaire());

        //EL TAB NO ESTA ORDENADO , IMAGINEMOS QUE QUEREMOS ORDENARLO POR SALARIO (YA NO POR IDobjeto

        //*COMMENT ON POURRAIT FAIRE CELA ?
        //Dans l’API de java , il y a une classe Arrays, qui a une méthode qui nous permet d’ordonner tableaux
        //Arrays--->sort

        //Dans l’API les noms qui sont en cursive ne sont pas de classes, ce sont des INTERFACES (prédéfinies)

        //Il y a beaucoup de méthodes sort, pk ?? SURCHARGE DE METHODES

        //Ils retournent rien ( void) et sont statics……Arrays.sort

        //Mon array est de type Employe
        //Je dois donc chercher dans L’API de java une méthode sort qui me permette de ranger des tableaux
        // de type objet car Employe est un objet     Arrays.sort(Object [] a)  est void y regresa el array ordenado
        //de moins à plus   de A à Z

        //All elements in the Array must implement the "comparable" Interface

        /*
        Tout les elements de l’array, tous les Employes doivent implementer l’interface comparable
        Autrement dit, on m’oblige à que la classe Employe implémente l’interface comparable
        Si je clique sur comparable on voit qu’il y a une unique méthode, qui compare objets

        compare (T o)

        T est le type de l'objet

        Interface Comparable<T>
        */


        //On va dire dans le principal qu’avant d’imprimer, il l’ordonne
        Arrays.sort(misEmpleados);//sort(Object[] a)    ordonne un Array dans l'ordre spécifié avec la méthode    compareTo(object obj)

        //On doit aller à Empleado et implementer l'interface Comparable
        //et ca va nous donner erreur
        //Marque erreur… pourquoi ?
        //Cette classe doit remplir les requisitos, avec le comportement, qui marque l’interface
        //Cette classe Employe doit inclure la méthode de l’interface comparable

        //On doit donc construire notre méthode compareTo
        //Quand on écrit la méthode dans la classe on met public pour qu’elle soit accessible
        //Public int car elle return an int
        System.out.println();

        for (Empleado e : misEmpleados) {
            System.out.println(e.getNOM() + ", salaire: " + e.getSalaire() + " " + e.getDebutContrat());
        }

        System.out.println();

        //--------------------------------------------------------------------------------------------------------------
        //          On va utiliser le principe de substitution avec 2 classes
        //--------------------------------------------------------------------------------------------------------------

        Comparable ejemplo = new Empleado("Ellie", 50000, 2011, 5, 6);

        //Esto seria igual de valido para instanceof
        //Empleado ejemplo = new Empleado("Ellie", 50000, 2011, 5, 6);

        /*
        On peut pas instancier directement une interface mais on peut utiliser le principe de substitution
        de telle sorte que si la class Employe implement Comparable (interface) On peut créer une instance
        appartenant à l'interface mais avec la classe qui l'implemente ( qui hérite de celle-ci)
        */
        if (jefeRH instanceof Jefe) {//lo cual es cierto, igual si ponemos Empleado en vez de Comparable
            System.out.println("Si es");//si es porque lo habiamos metido en el tab de empleados
        }

        if (ejemplo instanceof Comparable) {//lo cual es cierto, igual si ponemos Empleado en vez de Comparable
            System.out.println("ejemplo es un objeto de tipo Empleado que implementa Comparable");
        }

        //l’instruction instanceof est très utile, au moment de programmer en java et que l’on va
        // créer un programme complexe, qui ait beaucoup de classes qui héritent l’une de l’autre,
        // il est probable qu’on aura besoin de corroborer si une instance appartient à une classe ou non.
        //On peut demander si jefeRH est une instance de la class Employe

        //Grâce à que Chef hérite d’Employe et on peut faire la même chose avec l’interface.
        //Si l’on execute ce programme, 1 il nous dire que c de type Chef,
        //Directeur_commercial est une instance d’Employe grace à que Chef hérite d’Employe

        //aunque no metiera jefeRH en empleado o jefe en comparable     o Empleado en comparable
        //igual me diria que jefeRH es una instancia de Empleado ya que Jefe herita de empleado que a la vez herita de Comparable
        //Jefe seria entonces una instancia de jefe empleado y comparable
        //Empleado de empleado y de Comparable ya que herita de esta

        //On peut donc utiliser instanceof avec classes et avec interfaces

        //Es como un padre el hijo y el nieto,  al heredar  el nieto tiene el mismo apellido que el padre y el abuelo
        //y el padre el mismo apellido que el abuelo

        //ESTAMOS EN CONDITION DE CREAR AHORA NUESTRAS PROPIAS INTERFACES : trabajadores y jefes

        /*
        clase Empleado                                  Interface   Trabajadores
                 |                                                       |
                 |                                                       |
        clase   Jefe                                    Interface     Jefes

        On va commencer par créer l’interface Jefes

        Quelle utilité ou sens a pouvoir créer dans notre programme une interface Jefes ?

        Imaginons, que pueden hacer los Jefes ou que tienen que hacer los jefes ? y que no puede hacer un empleado?

        Plusieurs choses : prendre des décisions

        En raison de cela, nous créons une interface Jefes qui ait une méthode prendreDecisions() ; et de cette manière
        nous obligeons aux futurs programmeurs qui construisent une classe qui construit n’importe quel type de Jefe
        doive implementer l’interface Jefes, et qu’en implementant Jefes ils soient obligés de développer une méthode
        prendre décisions()

        Nous voulons donc déterminer le comportement que vont avoir les classes de notre programme que construisent
        Jefes car nous en tant que programmeurs voulons que toutes les classes qui construissent Jefes aient à
        prendre décisions. Point commun que tous les Jefes doivent prendre des décisions

        //--------------------------------------------------------------------------------------------------------------
        //                        Une interface peut etre public ou default
        //                        Pas private ni protected
        //--------------------------------------------------------------------------------------------------------------

        //Probamos Jefe con el metodo de la classe implementada Jefes
        //el metodo es prendreDecisions(String decision)

        */
        System.out.println();
        System.out.println(jefeRH.prendreDecisions("salir temprano hoy!"));

        // Si dans le futur un programmeur crée une classe différente qui hérite ou non d’Employe, c pareil
        // ya que una interface puede ser utilizada por cualquier clase independientement de si hereda de otra, etc

        // Mais crée une classe qui construise Jefes, s’il implement l’interface Jefes on l’oblige
        // à construire la méthode prendre decisions

        // Avec abstract class j’étais obligé de développer la methode en chaque classe qui héritait de ma abstract
        // class…cette méthode avait a chaque fois le mm nom mais different contenu !!!
        // Avec interface je dois obligatoirement inicializar la methode abstract de l’interface que j’implemente
        // juste dans cette classe.
        //**********Bueno en realidad creo que esto tb se podia hacer con abstract// DESCONFIAR

        // Si j’hérite de cette classe j’aurai aussi cette méthode mais je ne serai pas obligé de la inicializar !!!
        // Quand on crée plusieurs interfaces on peut créer aussi une hierarchie si besoin !
        // L’interface est utile pour une classe qui est déjà en train d’hériter !!

        //si necesitaramos que un Empleado tambien puede utilizar el metodo prendreDecisions()
        //esto daria un error porque no lo tiene, estariamos entonces obligados a

        // Employe implements Comparable, Jefes{}

        //es decir tendriamos que implementar la interface que contiene el metodo
        //esto nos obligaria a declarar el metodo o los metodos de la interface

        //Une classe peut implémenter plusieurs interfaces.

        // Dans ce cas ce que l’on doit se demander quelle tâche doit réaliser tout salarié,
        // que ce soit un Employe ou que ce soit un Chef. Comportement

        //On va se mettre dans la situation suivante : Imaginos que le programme qu’on fait corresponde
        // à une série d’Employes et Chefs d’une Entreprise.

        //Et cette Entreprise a comme habitude chaque année ( à noel par ex) de donner un bonus à tous les salaries, tous.

        //Ce serait bien de créer une interface qu’on pourrait appeler salaries qui ait une méthode donne_bonus()

        // Quand on crée une interface avec cette méthode nous sommes obligés à que toutes les classes qui
        // implémentent la interface salaries soient obligées de de développer la méthode donne_bonus() ;

        /*--------------------------------------------------------------------------------------------------------------
        On va créer l’interface Bonus
        Public abstract double donne_bonnus (double bonus) ; //par convention on les met pas public abstract
        Dans les méthodes d’une interface

        *Imaginons que dans cette entreprise que ce bonus doit etre minimum 1500 euros + en fonction des effort
         on lui donne plus ou moins .

         Comme le bonus doit avoir une valeur minimale, on crée une constante

         Toute les constantes sont par default public static final double bonus_base=1500 ;

         Static car appartient à l’interface salaries

         Final constante
        --------------------------------------------------------------------------------------------------------------*/

        //--------------------------------------------------------------------------------------------------------------
        //SE PUEDE CREAR UNA JERARQUIA ENTRE INTERFACES , Jefes PUEDE EN CONSECUENCIA extends Bonus   (heredar)
        //--------------------------------------------------------------------------------------------------------------

        //On vient donc de créer notre première hiérarchie d’Interfaces
        //una interdace no implements otra interface, una interface hereda otra interface

        //--------------------------------------------------------------------------------------------------------------
        //Les classes qui implementent l’interface Jefes sont en train d’implementer 2 méthodes, celle qui appartient
        // à Jefes et celle qui appartient à Bonus
        //--------------------------------------------------------------------------------------------------------------

        //Quand on enregistre, on voit que il y a une erreur dans le principal car maintenant on a une hierarchie
        // d’interfaces et Chefs extends Bonus

        //On doit donc aussi développer la méthode de l’autre interface (mere)

        //DESPUES VAMOS A Empleados para que esta implemente Bonus ya que TODOS LOS EMPLEADOS DEBEN TENER BONUS
        //empleado o jefe
        //sin embargo el metodo donneBonus en empleado sera diferente que el de Jefe y no tendra prime par defaut
        System.out.println();

        System.out.println(jefeRH.getNOM() + " : " + jefeRH.donneBonus(300));
        System.out.println(misEmpleados[0].getNOM() + " : " + misEmpleados[0].donneBonus(300));

    }
}
