package i_poo.t_LambdasII;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class LambdasIV {
    public static void main(String[] args) {
        /*
        Je pense que vous avez compris le principe maintenant, donc vous devriez comprendre au premier coup d'oeil
        le code ci-dessous qui se contente de vérifier que l'objet Personne a un âge supérieur à 20 :
        */
        List<Personne> lPersonne = Arrays.asList(// este metodo pide como parametro (T... a) que significa FluentApiTest acepta varios objetos genericos
                new Personne(10, "toto"),
                new Personne(20, "titi"),
                new Personne(30, "tata"),
                new Personne(40, "tutu")
        );

        Predicate<Personne> predicate = (Personne p) -> p.getAge() > 20;
        for (Personne p : lPersonne) {
            if(predicate.test(p))//metodo boolean
                System.out.println(p.getNom() + " a l'âge requis !");
        }
        /*
        Avec comme sortie dans la console :

          tata a l'âge requis !
          tutu a l'âge requis !
        */
    }
}
