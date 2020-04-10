package i_poo.l_interface.animal_con_interface_Rintintin;

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
