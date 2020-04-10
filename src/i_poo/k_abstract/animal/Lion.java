package i_poo.k_abstract.animal;

public class Lion extends Felin {

    public Lion() {//Constructeur par defaut

    }

    public Lion(String couleur, int poids) {
        this.setCouleur(couleur);
        this.setPoids(poids);
    }

    public void crier() {
        System.out.println("Yo fais grrrrrr");
    }
}
