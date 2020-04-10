package i_poo.a_ville_heritage_capital;

//EXCEPTION PERSONNALISEE 1
class NombreHabitantException extends Exception {
    public NombreHabitantException() {//Constructeur par default
        System.out.println("Vous essayez d'instancier une classe Ville avec un nombre d'habitants négatif !");
    }

    public NombreHabitantException(int nbr) {////deuxième constructeur dans notre classe NombreHabitantException qui prend un nombre d'habitants en paramètre
        System.out.println("Instanciation avec un nombre d'habitants négatif");
        System.out.println("\t => " + nbr);
    }
}

