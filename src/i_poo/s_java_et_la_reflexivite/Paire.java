package i_poo.s_java_et_la_reflexivite;

public class Paire {

    private String valeur1;
    private String valeur2;

    //Constructeur par defaut
    public Paire() {
        this.valeur1 = null;
        this.valeur2 = null;
        System.out.println("Instantiation !");
    }

    //Constructeur avec parametres
    public Paire(String valeur1, String valeur2) {
        this.valeur1 = valeur1;
        this.valeur2 = valeur2;
        System.out.println("Instantiation avec des paramètres !");
    }

    //setters and getters
    public void setValeur1(String valeur1) {
        this.valeur1 = valeur1;
    }

    public String getValeur1(String valeur1) {
        return valeur1;
    }

    public void setValeur2(String valeur2) {
        this.valeur2 = valeur2;
    }

    public String getValeur2(String valeur2) {
        return valeur2;
    }

    //toString
    public String toString() {
        return "Je suis un objet qui a pour valeur " + valeur1 + " - " + valeur2;
    }
}
