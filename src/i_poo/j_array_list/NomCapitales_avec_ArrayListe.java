package i_poo.j_array_list;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class NomCapitales_avec_ArrayListe {
    public static void main(String[] args) {
        //DAR LOS NOMBRES DE LAS CAPITALES DE ESTOS PAISES
        Scanner sc = new Scanner(System.in);

        String[][] paysCap = getPaysCap();
        //si quiero aumentar mas paises con sus capitales el calculo sera automatico
        //--------------------------------------------------------------------------------------------------------------
        //                   I.HAREMOS QUE SE NOS PIDA CADA CAPITAL DE CADA PAIS DE MANERA ALEATORIA
        //--------------------------------------------------------------------------------------------------------------

        int numero;
        String reponse;
        int count = 0;
        ArrayList<Integer> tab = new ArrayList<Integer>();

        for (int i = 0; i < paysCap.length; i++) {
            //CHOISIR UN PAYS DE MANIERE ALEATOIRE el do while se asegura que tengamos un numero no repetido
            do {//pa poder acceder al menos una vez
                Random aleatorio = new Random();
                numero = aleatorio.nextInt(paysCap.length);//almacenara a cada pasada el numero aleatorio
            } while (tab.contains(numero));//Si el tab contiene el numero, vuelve a pedirme otro

            tab.add(numero);//du coup estamos seguro que no lo contiene asi que podemos continuar

            boolean correcta = false;
            int j = 1;
            System.out.println("Cual es la capital de " + paysCap[numero][0]);

            while (j < paysCap[numero].length && !correcta) {
                reponse = sc.nextLine();//para que haga de nuevo la pregunta y compare el numero de veces que paysCap[aleat[i]].length

                int l = 1;
                while (l < paysCap[numero].length && !correcta) {
                    if (paysCap[numero][l].equalsIgnoreCase(reponse)) {//va a buscar la respuesta
                        correcta = true;
                    }
                    l++;
                }
                //-------Determinamos s la respuesta es correcta o no-------------------
                if (correcta) {
                    System.out.println("Respuesta correcta !!");
                    count++;
                } else {
                    System.out.println("Mauvaise réponse");
                    if (paysCap[numero].length > 2) {//porque cada fila tiene 2 elementos pais y capital y yo quiero las que tienen mas
                        System.out.println(paysCap[numero][0] + " a " + (paysCap[numero].length - 1) + " capitales, il te restent " + (paysCap[numero].length - 1 - j) + " essais");
                    }
                }
                j++;
            }
        }
        sc.close();//cerramos el objeto scanner
        System.out.println("C'est terminé " + "<<SCORE :" + count + "/" + paysCap.length + ">>");
    }

    //FUNCION K RETURNE TABLEAU
    private static String[][] getPaysCap() {

        String[][] arreglo = {{"Pérou", "Lima"},
                {"Allemagne", "Berlin"},
                {"Usa", "Washington", "New York", "Texas"},
                {"Portugal", "Lisbon"},
                {"France", "Paris"},
                {"Russie", "Moscou"},
                {"Brésil", "Brasilia"}};

        return arreglo;
    }
}
