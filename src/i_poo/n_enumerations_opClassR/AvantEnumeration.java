package i_poo.n_enumerations_opClassR;

public class AvantEnumeration {
   //OPCION SIN ENUM
    public static final int PARAM1 = 1;
    public static final int PARAM2 = 2;

    public void fait(int param) {
        if (param == PARAM1) {//option 1
            System.out.println("Faites à la façon n°1");
        }
        if (param == PARAM2) {//option 2
            System.out.println("Faites à la façon n°2");
        }
    }

    public static void main(String[] args) {//TraitementTest
     //OPCION SIN ENUM EN EL MAIN nada me impedia poner un valor no valido
        AvantEnumeration ae = new AvantEnumeration();
        ae.fait(AvantEnumeration.PARAM1);
        ae.fait(AvantEnumeration.PARAM1);
        ae.fait(4);

    }
}
//IMPRIMIRIA:
//Faites à la façon n°1
//Faites à la façon n°1

//Avant les énumérations, des erreurs étaient possibles

/*Je viens de vous montrer non seulement le principe dont je vous parlais, mais aussi sa faiblesse.
Vous voyez que rien ne vous empêche de passer un paramètre inattendu à une méthode : c'est ce qui s'est passé
à la dernière ligne de notre test. Ici, rien de méchant, mais vous conviendrez tout de même que le comportement
de notre méthode est faussé !

Bien sûr, vous pourriez créer un objet qui vous sert de paramètre de la méthode. Eh bien c'est à cela que servent
les enum : fabriquer ce genre d'objet de façon plus simple et plus rapide.*/
