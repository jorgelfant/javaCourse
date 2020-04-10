package f_cadenasCaracteres;

import java.util.Scanner;

public class g_letrasAmayus2 {
    public static void main(String[] args) {
        //Ingresar una frase y modificarla convirtiendo el primer caracter de cada palabra si esta fuera una letra,
        //de minusculas a mayusculas

        String frase;
        Scanner sc = new Scanner(System.in);

        System.out.println("Ingrese una frase");
        frase = sc.nextLine();

        String fraseNueva = "";
        int conteo = 0;
        //antes que nada transformamos la 1ra a mayusculas
        //fraseNueva += Character.toUpperCase(frase.charAt(0));// ou frase.substring(i, i + 1).toUpperCase(); solo con String
        int i = 0;// otra posibilidad es no cero porque lo acabamos de utilizar antes del while pal primer caracter
        //El primer if es muy importantes para livrase de los eventuales espacios que podrian venir antes de la 1ra palabra
        while (i < frase.length()) {//Character especial para los caracteres
            if (i == 0) {// primer indice de la frase
                while (frase.charAt(i) == ' ') {//estre while recorre sin imprimir los pimeros espacios antes de la 1ra palabra
                    i++;
                }
                fraseNueva = fraseNueva.concat(frase.substring(i, i + 1).toUpperCase());//despues imprimer esto o solo esto// si while no se cumple
            } else if (frase.charAt(i) != ' ') {
                fraseNueva = fraseNueva.concat(frase.substring(i, i + 1));//imprime cada letra
            } else {
                fraseNueva = fraseNueva.concat(frase.substring(i, i + 1));//concat solo con string solamente por eso no hay charAt
                while (frase.charAt(i) == ' ') {
                    i++;//recorre los espacios luego de que se ha impreso el primero
                }
                fraseNueva = fraseNueva.concat(frase.substring(i, i + 1).toUpperCase()); //letra despues del espacio
                conteo++;//cuenta solo un espacio entre 2 palabras y no mas
            }
            i++;
        }
        //frase=fraseNueva   e imprimiriamos frase con el nuevo contenido, OPCIONAL
        System.out.println(fraseNueva);
        System.out.println("En la frase hay " + (conteo + 1) + " palabras");
    }
}