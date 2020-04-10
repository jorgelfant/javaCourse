package i_poo.j_array_list;

import java.util.Random;

public class ClassRandom {
    public static void main(String[] args) {//atajo psvm


        Random aleatorio = new Random();//importamos la classe Random y creamos un objeto de tipo Random
        //--------------------------------------------------------------------------------------------------------------
        //int rep = 1 + (int) (Math.random() * 2);    //para indicar que va del 1 al 2
        //esto significa que las respuestas seran 0 y 1  y a cualquiera de esas 2 rep se sumara el 1 + del inicio
        //las respuestas seran entonces en vez de 0 y 1    1 y 2

        // int rep = aleatorio.nextInt(1);       //CA MARCHE AUSSI AVEC INT   si ponemos 1 es como deci que ponga ...<1 osea solo da 0
        //aleatorio.nextInt(5);  .....<5  osea 0 1 2 3 o 4
        // int rep = 1 + aleatorio.nextInt(1);  aumentaria de 1 todos los numero posibles osea ahora 1 2 3 4 5

        //--------------------------------------------------------------------------------------------------------------

        boolean nousAime = aleatorio.nextBoolean();//este metodo da un valor boolean aleatoire TRUE OU FALSE

        //On aura besoin de 2 variables  une qui nous dise si elle nous aime et une autre qui dit qu'elle nous aime pas
        //donc boolean
        System.out.println("Tu m'aimes ??");
        //--------------------------------------------------------------------------------------------------------------
        //                      Thread.sleep();  pour faire une pause
        //--------------------------------------------------------------------------------------------------------------

        try {//Try catch important pour que cela marche , car Thread.sleep(2000); peut generer des erreurs s'il fonctionne pas bien
            Thread.sleep(2000);    //On utilise la class THREAD et sa methode .sleep() pour mettre une pause avant de continuer le programme
        } catch (InterruptedException e) {//CATCH EST COMME UN IF
            e.printStackTrace();
        }

        //--------------------------------------------------------------------------------------------------------------
        //                                        REPONSE
        //--------------------------------------------------------------------------------------------------------------

        System.out.println("Hummm.....");//TEMPS DE REFLEXION

        //--------------------------------------------------------------------------------------------------------------
        //                      Thread.sleep();  pour faire une pause
        //--------------------------------------------------------------------------------------------------------------

        try {//Try catch important pour que cela marche , car Thread.sleep(2000); peut generer des erreurs s'il fonctionne pas bien
            Thread.sleep(2000);    //On utilise la class THREAD et sa methode .sleep() pour mettre une pause avant de continuer le programme
        } catch (InterruptedException e) {//CATCH EST COMME UN IF
            e.printStackTrace();
        }
        //2000 = 2s

        //--------------------------------------------------------------------------------------------------------------
        //                                        REPONSE
        //--------------------------------------------------------------------------------------------------------------

        if (nousAime) {
            System.out.println("Je t'aime mon chéri");
        } else {
            System.out.println("Je ne t'aime pas");
        }
    }
}
