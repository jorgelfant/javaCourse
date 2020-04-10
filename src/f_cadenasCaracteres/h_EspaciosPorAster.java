package f_cadenasCaracteres;

import java.util.Scanner;

public class h_EspaciosPorAster {
    public static void main(String[] args) {
        //Sustituir todos los espacios en blanco de una frase por un *
        // hola que tal
        String frase;
        String frase2 = "";//debe ser inicializada
        Scanner sc = new Scanner(System.in);

        System.out.println("Ingrese una frase");
        frase = sc.nextLine();

        int i = 0;

        while (i < frase.length()) {//ou con for et if y else, los i++ estarian solo en el for
            if (frase.charAt(i) != ' ') {
                frase2 = frase2.concat(frase.substring(i, i + 1));
            } else {//el else solo pedia tranformar los espacios en alterisco que se hace solo con
                frase2 = frase2.concat("*");//esto//y esto
                while (frase.charAt(i) == ' ') {
                    i++;
                }
                frase2 = frase2.concat(frase.substring(i, i + 1));
            }
            i++;
        }//faltaria una primera condicion como en los 2 ejercicios precedentes pa que no imprima asteriscos antes de la 1era letra
        System.out.println(frase2);
    }
}
