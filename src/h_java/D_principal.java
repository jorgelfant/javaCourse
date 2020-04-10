package h_java;

public class D_principal {
    public static void main(String[] args) {
        String[] tab = {"toto", "tata", "titi", "tete"};
        parcourirTableau(tab);
        System.out.println(toString(tab));
    }

    static void parcourirTableau(String[] tab) {//metodo 1
        for (String str : tab)
            System.out.println(str);
    }

    static String toString(String[] tab) {//metodo 2 con return
        System.out.println("Méthode toString() !\n----------");
        String retour = "";

        for (String str : tab) {
            retour += str + "\n";
        }
        return retour;
    }
}
/* RESULTADO
toto
tata
titi
tete
Méthode toString() !
----------
toto
tata
titi
tete
 */