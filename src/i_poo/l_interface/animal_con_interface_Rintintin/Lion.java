package i_poo.l_interface.animal_con_interface_Rintintin;

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
