package i_poo.l_interface.animal_con_interface_Rintintin;

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
