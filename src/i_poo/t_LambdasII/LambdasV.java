package i_poo.t_LambdasII;

import java.util.function.Supplier;

public class LambdasV {
    public static void main(String[] args) {
        /*
        Nous allons terminer ce chapitre par le plus facile (une fois n'est pas coutume...).
        Cette dernière se contente de retourner ce que nous lui avons demander de retourner...                        */

        Supplier<String> s1 = () -> new String("hello !");//Ou simplement   "hello !"
        System.out.println(s1.get());
        Supplier<Personne> s2 = () -> new Personne(50, "Dédé");
        System.out.println(s2.get());

        /*Ce code parle de lui-même. L'objet 's1' va systématiquement retourner un nouvel objet String et 's2' va, lui,
        systématiquement retourner un objet Personne comme le montre le résultat ci-dessous :

        hello !
        #Nom : Dédé - âge : 50#

        Nous venons de voir comment utiliser certaines interface fonctionnelles présentes dans Java 8 avec les lambdas.
        Avant d'en terminer avec ce chapitre nous devons voir une autre façon d'exploiter ces interfaces fonctionnelles,
        grâce aux références de méthode.


        */
    }
}
