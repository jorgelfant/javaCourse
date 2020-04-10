package i_poo.b_voiture;

public class VoiturePrincipale {
    public static void main(String[] args) {

        Voiture Renault = new Voiture();
        Voiture Peugeot = new Voiture();//esto va a buscar el constructeur y prends les données

        //c'est possible de mettre les autres classes ici après le principal dans le meme package mais c'est déconseillé
        System.out.println(Renault.getRoues());
        //Si on avait pas utiliser le setter avant l’impression en console, la valeur de la couleur aurait
        //été null car la variable couleur était déclarée mais pas initiée  String color;
        Renault.setColor("rojo");//esto viene a modificar el color en el principal
        System.out.println(Renault.getColor());
        System.out.println(Renault.propCommunes());

        Renault.setSiegesCuire("oui");
        System.out.println(Renault.getSiegesCuire());
        Renault.setClimatisation("oui");
        System.out.println(Renault.getClimatisation());
        Renault.setPoids();//PA AUMENTAL
        System.out.println(Renault.getPoids());
        Renault.setPrix();//PA AUMENTAL
        System.out.println(Renault.getPrix());

        //METODO ALTERNATIVO
        // Renault.setClimSieges("oui", "oui");//metodo que llamaria a otro metodo setPoids();
        //System.out.println(Renault.getPoids());

    }
    //Dans ce cas de mettre tout dans le meme fichier il doit y avoir toujours une classe qui soit public qui est
    // celle qui est considérée classe principale. Quand on a toutes les classes dans un seul fichier. La class public
    // est celle qui va donner un nom au fichier de java.

    //1
    //public class VoiturePrincipale{ la première donne le nom à la classe et on la met en public //celle-ci portera la méthode principal
    // public VoiturePrincipale(){}
    //public static void principal(String[] args) {
    //                                       }
    // }

    //2
    //Le restes des classes ne doivent pas être public
    // class Moto{
    //                   }

    //3
    // class Camion{
    //                }
    //
}
