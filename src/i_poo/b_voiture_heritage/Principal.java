package i_poo.b_voiture_heritage;

public class Principal {
    public static void main(String[] args) {
        Camionnette renault = new Camionnette(2, 1);
        System.out.println(renault.getRoues());

        renault.setColor("orange");
        System.out.println(renault.getColor());
        //On peut donc réutiliser le code de Vehicule
        //Cette classe peut aussi avoir ses méthodes propres

        //Pour l'héritage il faut suivre la méthode   "...est un?  une voiture est un véhicule? par ex
    }
}
