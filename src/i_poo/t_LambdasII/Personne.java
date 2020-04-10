package i_poo.t_LambdasII;

public class Personne {

    private String nom;
    private int age;

    public Personne(int age, String nombre) {
        this.age = age;
        this.nom = nombre;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getAge() {
        return age;
    }

    public String getNom() {
        return nom;
    }


}
