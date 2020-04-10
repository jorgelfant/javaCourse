package i_poo.k_abstract.animal;

public class Chien extends Canin {

    public Chien() {//Constructeur par defaut

    }

    public Chien(String couleur, int poids) {
        this.setCouleur(couleur);
        this.setPoids(poids);
    }

    public void crier() {
        System.out.println("Yo fais waoouuu");
    }
}
