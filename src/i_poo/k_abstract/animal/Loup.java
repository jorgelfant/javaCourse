package i_poo.k_abstract.animal;

public class Loup extends Canin {

    public Loup() {//Constructeur par defaut

    }

    public Loup(String couleur, int poids) {
        this.setCouleur(couleur);
        this.setPoids(poids);
    }

    public void crier() {
        System.out.println("Yo fais Aouuuuuu");
    }
}
