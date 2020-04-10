package i_poo.l_interface.animal_con_interface_Rintintin;

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
