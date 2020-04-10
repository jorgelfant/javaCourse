package e_vectores_uni;

import java.util.Scanner;

public class t_2TabEn1 {
    public static void main(String[] args) {
/*Leer 2 arreglos de 5 numeros enteros cada uno que estan ordenados crecientemente.
Copiar(fusionar) los 2 arreglos en un tercero, de forma que los numeros sigan ordenados.
*/
        int[] tab1 = new int[5];
        int[] tab2 = new int[5];
        int[] tabF = new int[10];

        Scanner sc = new Scanner(System.in);

        //estos booleans podrian ir definidos aqui e iniciados en el boucle
        boolean ordenado1 = true;// esto seria util en el cado de do while donde pondria que ascendente
        //es verdadero y que entre la 1ra vez y si cambia a falso la condicion
        boolean ordenado2 = true;//ya no se cumple; vuelve arriba tons si el boolean iniciado no esta dentro
        //del boucle entonces el boolean no puede cambiar su valor y seguira siendo falso
        //la ventaja del do while es que podriamos verificar el boucle con una sola boolean ascendente
        //con esto nos damos cuenta que a parte de la condicion del while, el boolean debe poder cambiar
        // a true o false dentro de la boucle con un do while o con un while


//j'ai choisi pour cet exercise de compare a chaque fois les 2 atableau a la fois
        // se podria haver hecho el ingres y comprobacion del 1ro y luego en otro while ingreso
        //y comprobacion del 2do
        do {//Remplissage
            for (int i = 0; i < 10; i++) {
                System.out.println("Ingrese un numero");
                if (i < 5) {
                    tab1[i] = sc.nextInt();
                } else {
                    tab2[i - 5] = sc.nextInt();
                }
            }//hubiera podido ser un boucle por tableau de 5
            for (int i = 0; i < tab1.length - 1; i++) {//chequear si estan ordenados
                if (tab1[i] > tab1[i + 1]) {//esta condicion es extremadamente importante para que la condicion funcione
                    ordenado1 = false;
                }
            }//las condiciones funcionan en el caso que sea ascendente o no pero si estan desordenados los arreglos
            //no funciona, es por eso que es importante considerar un if y un else if es decir un verdadero y un falso
            for (int i = 0; i < tab2.length - 1; i++) {//chequear si estan ordenados
                if (tab2[i] > tab2[i + 1]) {//esta condicion es extremadamente importante para que la condicion funcione
                    ordenado2 = false;//si este else if al momento de verificar no sabria que hacer en caso contrario a la 1 condicion
                }
            }
            /*Problema recurrente al ingresar 1 2 3 10 9    o  10 9 8 1 2  lee solo lo uo ultimo pensando que el 1 es descendente
             * y que el 2do ejemplo es ascendente, es por esta razon que es importante tener un if y un else if para que esto no pase
             * y un else en caso ninguna condicion se aplique*/
            //esto calcula el orden hacendente de un tableau independientemente uno del otro
            if (ordenado1 && ordenado2) {
                System.out.println("En buena hora los 2 arreglos estan en orden cresciente");
            } else {
                System.out.println("Ingrese el orden correcto");
            }
        } while (!ordenado1 || !ordenado2);
        //FUSION  esto lo pude tb haber hecho en 2 pasos haciendo un for para el tab1 y otro pal tab2
        for (int i = 0; i < tabF.length; i++) {
            if (i < 5) {
                tabF[i] = tab1[i];
            } else {
                tabF[i] = tab2[i - 5];
            }
        }

        boolean desciende;
        int temp;
        do {
            desciende = true;
            int i = 0;//esto resetea a 0 por eso debe estar dentro del 1er while
            int j = tabF.length - 1;
            while (i < j) {
                if (tabF[i] > tabF[i + 1]) {
                    temp = tabF[i];
                    tabF[i] = tabF[i + 1];
                    tabF[i + 1] = temp;
                    desciende = false;
                }
                i++;
            }
        } while (!desciende);
        //IMPRESSION
        for (int indice : tabF) {
            System.out.print(indice + " " );
        }
    }
}
