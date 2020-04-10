package i_poo.k_abstract.animal;

public abstract class Animal {

    private int poids;
    private String couleur;


    public void setPoids(int poids) {
        this.poids = poids;
    }

    public int getPoids() {
        return poids;
    }

    public void setCouleur(String couleur) {
        this.couleur = couleur;
    }

    public String getCouleur() {
        return couleur;
    }

    /*
                                                  ****************
                                                    Animal
                                                  ****************
                                                  * poids: int
                                                  * couleur:String
                                                  * **************
                                                  * manger():void
                                                  * boire():void
                                                  * deplacement():void
                                                  * crier():void
                                                  * **************
                                                       |
                                                       |
        /----------------------\------------------------/--------------------\------------------\
  ***********             **********              ***********          ***********          **********
    Chat                     Chien                    Loup                 Lion                 tigre
  ***********             ***********             ***********          ***********           **********

  Nous avons bien notre classe mère Animal et nos animaux qui en héritent. À présent, laissez-moi vous poser
  une question. Vu que notre classe Animal est public, qu'est censé faire un objetAnimal? Quel est son poids,
  sa couleur, que mange-t-il ? Je sais, cela fait plus qu'une question. :p

  */
    public void manger() {
        System.out.println("Yo como carne");
    }

    public void boire() {
        System.out.println("Yo bebo agua");
    }

    public String toString() {
        String str = "Je suis un objet de la " + this.getClass() + ", je suis " + this.couleur + ", je pèse " + this.poids;
        return str;
    }

    public abstract void deplacement();


    public abstract void crier();

}
