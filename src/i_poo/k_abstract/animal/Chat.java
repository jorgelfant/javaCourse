package i_poo.k_abstract.animal;

public class Chat extends Felin {

    public Chat() {// constructor par defaut

    }
    public Chat(String couleur, int poids) {//nuevo constructor
        this.setCouleur(couleur);
        this.setPoids(poids);
    }

    public void crier() {
        System.out.println("Yo fais Miauuuouuuu");
    }
}
