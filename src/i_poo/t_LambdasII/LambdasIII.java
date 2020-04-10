package i_poo.t_LambdasII;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

public class LambdasIII {
    public static void main(String[] args) {
        /*
        java.util.function.Consumer<T>
        ------------------------------

        Encore plus simple que la précédente interface car celle-ci ne retourne rien, elle se contente de "consommer"
        un objet, donc d'y appliquer un traitement, comme par exemple ajouter 13 ans à l'age d'un objet  Personne.
        */

        List<Personne> lPersonne = Arrays.asList(
                new Personne(10, "toto"),
                new Personne(20, "titi"),
                new Personne(30, "tata"),
                new Personne(40, "tutu")
        );

        System.out.println(lPersonne);
        //interface fonctionne sur generico   asi en la funcion puedo usar tipos genericos como Personne en parametros
        Consumer<Personne> c = (Personne p) -> p.setAge(p.getAge() + 13);

        for (Personne p : lPersonne) {
            c.accept(p);
        }
        System.out.println(lPersonne);

        /*
        Ce qui nous donne :

        [#Nom : toto - âge : 10#, #Nom : titi - âge : 20#, #Nom : tata - âge : 30#, #Nom : tutu - âge : 40#]
        [#Nom : toto - âge : 23#, #Nom : titi - âge : 33#, #Nom : tata - âge : 43#, #Nom : tutu - âge : 53#]


        Cette interface a aussi une méthode par défaut   andThen()  où nous pouvons appliquer encore d'autre choses.
        C'est simple non ? Alors continuons !
        */
    }
}
