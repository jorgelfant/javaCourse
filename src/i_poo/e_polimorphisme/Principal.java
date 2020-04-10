package i_poo.e_polimorphisme;

public class Principal {
    /*
     Ce concept complète parfaitement celui de l'héritage, et vous allez voir que le polymorphisme est plus simple
     qu'il n'y paraît. Pour faire court, nous pouvons le définir en disant qu'il permet de manipuler des objets sans
     vraiment connaître leur type.

     Dans notre exemple, vous avez vu qu'il suffisait d'utiliser la méthode decrisToi()sur un objet Ville ou sur un
     objet Capitale. On pourrait construire un tableau d'objets et appeler decrisToi()sans se soucier de son contenu :
     villes, capitales, ou les deux.
    */
    public static void main(String[] args) {

        //Definition d'un tableau de Villes null
        Ville[] villes = new Ville[6];

        ////Définition d'un tableau de noms de villes et un autre de nombres d'habitants
        //**************************************************************************************************************
        //                DECLARAMOS 2 ARREGLOS UNO CON SRING de ciudades y el otro con INT habitantes
        // *************************************************************************************************************
        String[] tabVilles = {"Marseille", "Llile", "Caen", "Lyon", "Paris", "Nantes"};
        int[] tabNbreHabt = {123456, 78456, 654987, 75832165, 1594, 213};

        //Les trois premiers éléments du tabVilles seront des villes etle reste des capitales
        //**************************************************************************************************************
        //                                   LLENAMOS EL ARREGLO CON VILLES Y CAPITALES
        // *************************************************************************************************************

        for (int i = 0; i < 6; i++) {
            if (i < 3) {
                Ville V = new Ville(tabVilles[i], "France", tabNbreHabt[i]);
                villes[i] = V;//A cada pasada va llenando cada objeto
            } else {
                Capital C = new Capital(tabVilles[i], "France", tabNbreHabt[i], "Tour Eiffel");
                villes[i] = C;//A cada pasada va llenando cada objeto
                //ou villes[i]=new Capital(tabVilles[i], "France", tabNbreHabt[i], "Tour Eiffel");
            }
        }
        //**************************************************************************************************************
        //                                  IMPRESION DEL arreglo villes de objetos ville
        // *************************************************************************************************************
        for (Ville indice : villes) {
            System.out.println(indice.decrisToi() + "\n");
        }
        /*
        Nous créons un tableau de villes contenant des villes et des capitales (nous avons le droit de faire ça,
        car les objets Capitale sont aussi des objets Ville) grâce à notre première boucle for. Dans la seconde, nous
        affichons la description de ces objets… et vous voyez que la méthode polymorphe decrisToi()fait bien son travail !

        Vous aurez sans doute remarqué que je n'utilise que des objets Ville dans ma boucle : on appelle ceci la
        covariance des variables ! Cela signifie qu'une variable objet peut contenir un objet qui hérite du type de
        cette variable. Dans notre cas, un objet de type Ville peut contenir un objet de type Capitale. Dans ce cas,
        on dit que Ville est la superclasse de Capitale. La covariance est efficace dans le cas où la classe héritant
        redéfinit certaines méthodes de sa superclasse.

        Attention à ne pas confondre la surcharge de méthode avec une méthode polymorphe.

        Une méthode surchargée diffère de la méthode originale par le nombre ou le type des paramètres qu'elle prend en
        entrée.

        Une méthode polymorphe a un squelette identique à la méthode de base, mais traite les choses différemment.
        Cette méthode se trouve dans une autre classe et donc, par extension, dans une autre instance de cette autre
        classe.
        */

    }
}
