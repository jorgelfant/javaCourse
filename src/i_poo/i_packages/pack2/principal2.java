package i_poo.i_packages.pack2;

import i_poo.i_packages.pack1.A;
//import poo.i_packages.pack1.B; //da error a la clase B default que solo se ve en su propio PACKAGE en este caso pack1

public class principal2 {
    public static void main(String[] args) {
        A a = new A();//PUBLIC class A
        //B b = new B();//class B     default    DA ERROR por su portéé défault
        //AUCUN PROBLEME ICI CAR NOUS SOMMES DANS LE MEME PACKAGE

        /*
        Vous pouvez constater qu'Eclipse n'aime ni l'instruction import com.sdz.test.B, ni l'instruction B b = new B();.
         Cela est dû à la déclaration de notre classe. J'irai même plus loin : si vous essayez de modifier la variable
         d'instance de l'objet A, vous aurez le même problème. Donc, ceci : a.b.str = "toto"; n'est pas non plus autorisé
         dans ce package ! La seule façon de corriger le problème est de déclarer la classe B public. Rappelez-vous que
         seule la classe A avait été déclarée ainsi.
        */
       // a.b.str = "toto";//même la variable public de class B (qui es default) n'est pas accessible
        //solution declararla public

        /*
        Un package est un ensemble de dossiers et de sous-dossiers.

        .Le nom du package est soumis à une convention de nommage.

        .Si vous voulez utiliser un mot clé Java dans le nom de votre package, vous devez le faire suivre d'un underscore (« _ »).

        .Les classes déclarées public sont visibles depuis l'extérieur du package qui les contient.

        .Les classes n'ayant pas été déclarées public ne sont pas visibles depuis l'extérieur du package qui les contient.

        .Si une classe déclarée public dans son package a une variable d'un type ayant une portée default, cette dernière ne
         pourra pas être modifiée depuis l'extérieur de son package.
        */

    }
}
