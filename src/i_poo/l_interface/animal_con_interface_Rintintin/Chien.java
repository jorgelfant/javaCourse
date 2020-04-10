package i_poo.l_interface.animal_con_interface_Rintintin;

public class Chien extends Canin implements Rintintin {

    public Chien() {//Constructeur par defaut

    }

    public Chien(String couleur, int poids) {
        this.setCouleur(couleur);
        this.setPoids(poids);
    }

    public void crier() {//methodo a implementar obligado por que es abstrata en Animal (superClass)( que pasa por canin)
        System.out.println("Yo fais waoouuu");
    }

    /*------------------------------------------------------------------------------------------------------------------
            METODOS DE LA INTERFACE RINTINTIN que deben ser inicializados obigatoriamente
     -----------------------------------------------------------------------------------------------------------------*/

    public void faireCalin() {
        System.out.println("Je te fais un GROS CÂLIN");
    }

    public void faireLeBeau() {
        System.out.println("Je fais le beau !");
    }

    public void faireLechouille() {
        System.out.println("Je fais de grosses léchouilles...");
    }

    /*
    L'ordre des déclarations est primordial. Vous devez mettre l'expression d'héritage avant l'expression
    d'implémentation, sinon votre code ne compilera pas.

    cuando una classe hereda una clase e implementa un interface, extends debe ir antes de implements
    */
}
