package i_poo.j_array_list;

import java.util.Random;
import java.util.Scanner;

public class NomCapitales {


    public static void main(String[] args) {
        //DAR LOS NOMBRES DE LAS CAPITALES DE ESTOS PAISES
        Scanner sc = new Scanner(System.in);

        String[][] paysCap = {{"Pérou", "Lima"},
                {"Allemagne", "Berlin"},
                {"Usa", "Washington", "New York", "Texas"},
                {"Portugal", "Lisbon"},
                {"France", "Paris"},
                {"Russie", "Moscou"},
                {"Brésil", "Brasilia"}};
        //si quiero aumentar mas paises con sus capitales el calculo sera automatico
        //--------------------------------------------------------------------------------------------------------------
        //                   I.HAREMOS QUE SE NOS PIDA CADA CAPITAL DE CADA PAIS DE MANERA ALEATORIA
        //en cada ejecucion habra un orden distinto al anterior, los numeros se almacenaran en el tab aleat
        //--------------------------------------------------------------------------------------------------------------
        //AUTRE MANIERE DE FAIRE declarer 2 variables
        //String pays =paysCap[aleatoire][0]   et avec un sout demander 1 a 1 dentro de un for  (problema el aleatorio puede repetirse)
        //String capital=paysCap[aleatoire][1]    si esto es igual a reponse  etc
        //0<7 //no sabemos cuantas vueltas habran entre numero repetidos y no ( mas de 7 seguro) por eso while

        String reponse;
        int count = 0;
        int aleat[] = new int[paysCap.length];

        int i = 0;
        while (i < paysCap.length) {//while PADRE

            Random aleatoire = new Random();//por qu'il propose au hasard un numero a chaque iteration
            int numero = aleatoire.nextInt(paysCap.length); //de 0 al numero del tab
            //--------------------------------------------------------------------
            boolean siEsta = false;//para imaginarse que se repite como hipotesis
            //--------------------------------------------------------------------
            for (int j = 0; j < i; j++) {//0 < 0 1 2 3 4 5 6  este for determina si el numero esta repetido o no
                if (numero == aleat[j]) {
                    siEsta = true;
                }
            }
            //-------------------Hipotesis de numero no repetido--------------------
            if (!siEsta) {//solo pondra el numero en el arreglo si este no esta ya en el, y luego avanzara
                aleat[i] = numero;//porque el for de mas arriva no se ejecuta la 1ra vez y el valor viene a meterse en el aleat[0]
                //por eso lo ponemos aqui o sea fuera del for
                int k = 1;
                boolean correcta = false;
                System.out.println("Quelle est la capitale de " + paysCap[numero][0] + " ?");
                //hubieramos puesto reponse = sc.nextLine(); pero como queremos que para algunos paises poder ingresar varias rep , lo ponemos en el sgt while
                while (k < paysCap[numero].length && !correcta) {
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
                            System.out.println(paysCap[numero][0] + " a " + (paysCap[numero].length - 1) + " capitales, il te restent " + (paysCap[numero].length - 1 - k) + " essais");
                        }
                    }
                    k++;
                }
                i++;//lo ponemos aqui pa que avanze solo si un numero no es repetido
            }
        }
        sc.close();//cerramos el objeto scanner
        System.out.println("C'est terminé " + "<<SCORE :" + count + "/" + paysCap.length + ">>");

    }
}
