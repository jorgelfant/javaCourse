package i_poo.t_InterfacesFonctionnelles;

public class InterfacesFonctionnelles {
    public static void main(String[] args) {
        /*les interfaces fonctionnelles

        Ce concept, introduit depuis Java 8, permet de définir une interface n'ayant "qu'une et une seule
        méthode abstraite" : c'est grâce à cette restriction qu'il sera possible d'utiliser les lambdas car,
        lors de l'exécution, Java pourra automatiquement déterminer quelle est la signature de la méthode
        que la lambda remplace et tout sera automatique.

        Dans notre exemple précédent, notre interface Soin est une interface fonctionnelle car elle n 'a
        qu'une méthode à redéfinir (Single Abstract Method, ou interface SAM). Comme je vous le disais,
        ce type d'interface sera le pillier de l'utilisation des lambdas donc, pour s'assurer que le contrat
        est bien respecté, Java propose d'annoter l'interface avec  @FunctionalInterface  , comme ceci :

        @FunctionalInterface
        public interface Soin {
        	public void soigne();
        	//public String toto(int i); //deuxième méthode abstraite qui provoque une erreur quand il y a @FunctionalInterface
        }
                               Problème dans l'interface fonctionnelle

        Dès lors, si vous ajoutez une méthode abstraite (même avec une signature différente),
        Java vous indiquera qu'il y a un problème.

        Mais vous avez tout à fait le droit d'avoir une interface fonctionnelle avec des méthodes par défaut,
        comme le montre l'image ci-dessous :

        @FunctionalInterface
        public interface Soin {

        	public void soigne();

        	public default String toto(int i) {
                return "Tout est ok ! ";
            }
       }
                Méthode par défaut dans une interface fonctionnelle
        */


        /*
        Java 8 vient avec de nombreuses interfaces fonctionnelles prédéfinies dans le package java.util.function
        dont le détail est disponible à l'adresse suivante :

        https://docs.oracle.com/javase/8/docs/api/java/util/function/package-summary.html

        Nous en reparlerons à la fin de ce chapitre et nous aurons l'occasion d'en utiliser avec les lambdas,
        vous verrez, c'est magique !
        */
    }
}
