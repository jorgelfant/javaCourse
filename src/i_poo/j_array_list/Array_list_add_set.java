package i_poo.j_array_list;

import java.util.ArrayList;

public class Array_list_add_set {
    public static void main(String[] args) {
        //VAMOS A VER LA DIFERENCIA ENTRE ADD() Y SET()

        ArrayList<String> tab = new ArrayList<String>();

        tab.add("momo");//indice 0   (String e)
        tab.set(0, "toto");//esto cambia la referencia de 0 que apunta a "momo" y la referencia ahora apuntara a "toto"
        //al finalizar esto seguiriamos teniendo un solo elemento en 0

        //System.out.println(tab.get(1)); daria error porque no hay nada en index 1

        tab.add(0, "tata");//(int index  , String element)   add puede tomar 2 parametros
        //va a agregar  en 0 la referencia que apuntara a "tata" sin destruir la antigua referencia que sera desplazada
        //(creacion de indice 1) de 0 "momo" a 1

        //toto esta en 0

        //tata   ahora ponemos esto en 0
        //tata toto    tata empuja a toto   o mejor dicho a su referencia ya que son objetos (y crea indice 1)
        System.out.println(tab.get(0));//affiche rien erreur  indexOutOfBoundsException
        System.out.println(tab.get(1));

        //--------------------------------------------------------------------------------------------------------------
        //                                    FORMATO con printf
        //--------------------------------------------------------------------------------------------------------------

        //IMPRESSION CON FORMATO  s  string   d (d decimal)  int   f  float   o  octal   x   hexadecimal    e  notacion scientifica
        //  g  adapta pourcentage e ou f  en funcion del caso      c   pour chat
        //si se pone en mayuscula , el resultado estara en mayuscula
        System.out.printf("%s%s%s%s\n", "Hola ", "que ", "tal ", "amigo"); //en decimal se muestran por defecto 6 cifras despues de la coma
        System.out.printf("%x\n", 10);//hexa 10 dara a   16  f
        System.out.printf("%f\n", 2.5); //en decimal se muestran por defecto 6 cifras despues de la coma
        System.out.printf("%.2f\n", 2.555); //. despues del %  y el numero de cifras acompanado de la f
        //significa despues del .  pon 2f  2 decimales
        System.out.printf("Numero es %.2f\n", Math.PI);

        int value = 10;              //  value%
        System.out.printf("Chargement à\n%d%%\n", value);//  %%  2 veces para que entienda que debe imprimir %  y que no espere un valor   %d
        System.out.printf("%04d", 5);//4 digitos 0005  y al ultimo el numero

        //TODOS LOS System.out.printf(); etc estan explicados en la API  java.lang

        //COMO JAVA ES PURAMENTE ORIENTADO A OBJETOS, HABLAMOS A MENUDO MAS DE METODOS QUE DE FUNCIONES
        //RAPPEL, UNE METHODE PEUT CONTENIR UNE AUTRE ou PLUSIEURS, EN LA CLASS O EN EL MAIN PEU IMPORTE
        //UNE VARIABLE DECLAREE DANS UN METHODE EST VALIDE QUE DANS CETTE METHODE, ELLE EST DONC LOCALE
        //On peut pas l'utiliser ailleurs
        //VARIABLE LOCALE  ----> VARIABLE DECLAREE A L'INTERIEUR d'une METHODE

        //SCHIFT  + F10  executer le code

        /*
        int a=5;
        double b=5.3065d;
        float c=25.0f;
        long c=5621L;

        */
    }
}
