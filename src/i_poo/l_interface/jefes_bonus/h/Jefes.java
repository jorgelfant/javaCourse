package i_poo.l_interface.jefes_bonus.h;

public interface Jefes extends Bonus {
    //Les méthodes d’une interfaces doivent tjrs etre public abstract
    //On peut les mettre public abstract ou
    //Les sous-entendre (ne pas les mettre) java les sousentend
    //Ceci est la manière de déclare une méthode dans une interface, ils sont définis mais pas développés

    //public abstract es redundante ya que las interfaces solo aceptan metodos public abstract

    public abstract String prendreDecisions(String decision);//inicializada en la clase que la implements y se prueba en el principal

    //On va dire a notre classe d’implementer l’interface Jefes qu’on vient de créer
    //*Une de raisons de devoir utiliser les interfaces était le problème de l’héritage simple

    // Jefe hérite déjà d’Empleado, si on n’avait pas les interfaces, et ce que l’on a fait dans
    // l’interface on l’avait fait dans une abstract class, comment je lui dis maintenant qu’en
    // plus d’hériter d’Employe hérite aussi de la abstract class.
    // Pas possible car java n’a pas d’héritage multiple

    // On met un paramettre en la methode abstract de l’interface car on s’en servira
    // quand on developpera cette méthode dans la classe qui implemente cette interface

    //------------------------------------------------------------------------------------------------------------------
    //SE PUEDE CREAR UNA JERARQUIA ENTRE INTERFACES , Jefes PUEDE EN CONSECUENCIA extends Bonus   (heredar)
    //------------------------------------------------------------------------------------------------------------------
}

