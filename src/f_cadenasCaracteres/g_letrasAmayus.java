package f_cadenasCaracteres;

import java.util.Scanner;

public class g_letrasAmayus {
    public static void main(String[] args) {
        //Ingresar una frase y modificarla convirtiendo el primer caracter de cada palabra si esta fuera una letra,
        //de minusculas a mayusculas

        String frase;
        Scanner sc = new Scanner(System.in);

        System.out.println("Ingrese una frase");
        frase = sc.nextLine();

        String fraseNueva = "";
        int conteo = 0;
        // ou frase.substring(i, i + 1).toUpperCase(); solo con String
        int i = 0;
        while (i < frase.length()) {//Character especial para los caracteres
            if (frase.charAt(i) != ' ') {
                if (i == 0) {
                    fraseNueva += Character.toUpperCase(frase.charAt(i));
                } else {
                    fraseNueva += frase.charAt(i);//imprime cada letra
                }
            } else {
                if (i != 0) {//solo imprime un espacio cuando no estamos en la primera letra o espacio
                    fraseNueva += frase.charAt(i); //esto en caso de que hubieran espacios antes de la 1 letra de la frase
                    conteo++;//pa que no cuente el espacio antes de la primera letra
                }
                while (frase.charAt(i) == ' ') {//avanza los espacios
                    i++;
                }
                fraseNueva += Character.toUpperCase(frase.charAt(i));
            }
            i++;
        }
        System.out.println(fraseNueva);
        System.out.println("En la frase hay " + (conteo + 1) + " palabras");
    }
}
//  =+ se piuede remplazar con concat