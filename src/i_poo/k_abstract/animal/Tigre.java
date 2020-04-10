package i_poo.k_abstract.animal;

public class Tigre extends Felin {


    public Tigre() {//Constructeur par defaut

    }

    public Tigre(String couleur, int poids) {
        this.setCouleur(couleur);
        this.setPoids(poids);
    }

    public void crier() {
        System.out.println("Yo fais grrrraaauu");
    }
}
