package i_poo.b_voiture_heritage;

public class Camionnette extends Vehicule {
    private int capacidad_extra;
    private int plazas_extra;

    /*Une fois ces caractéristiques déclarées, on doit donner un état initial à notre objet camionnette, on a le
    constructeur de voiture hérité, mais il se peut que l’état initial d’une camionnette qui a une capacite_ extra
    et un nombre de places_supplémentaires ne soit pas le même que l’état initial d’une voiture.*/

    public Camionnette(int plazas_extra, int capacidad_extra) {
        super();//llama al constructor de la superClass ...al tener la classe padre un constructor sin atributos, este
        //se copia de maniere factuelle incluso sin poner super()

        //Super va appeler au constructeur de la super classe (classe père) dans le but de donner un état initial
        // à cet objet. Roues=4, moteur=1600 ; etc
        this.capacidad_extra = capacidad_extra;
        this.plazas_extra=plazas_extra;

    }
    //les methodes de la superClass pourront être utilisées ici
    //par contre pour importe une méthode style decrisToi() ou on utilise souvent des variables locales, si elles
    //sont private on pourra pas utiliser cette méthode. D'ou l'importance de les déclarer protected

}
