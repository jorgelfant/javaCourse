package i_poo.t_InterfacesFonctionnelles;

@FunctionalInterface
public interface Soin {//Soin est une interface fonctionnelle car elle a qu'une méthode à redéfinir
    // ce type d'interface sera le pillier de l'utilisation des lambdas donc, pour s'assurer
    // que le contrat est bien respecté, Java propose d'annoter l'interface avec  @FunctionalInterface
    // Dès lors, si vous ajoutez une méthode abstraite (même avec une signature différente),
    // Java vous indiquera qu'il y a un problème.

    /*public abstract*/void soigner(); //Single Abstract Method, ou interface SAM)
    //public String toto(int i); //deuxième méthode abstraite qui provoque une erreur quand il y a @FunctionalInterface

    //Mais vous avez tout à fait le droit d'avoir une interface fonctionnelle avec des méthodes par défaut,
    public default String toto(int i) {
        return "Tout est ok ! ";
    }
}
