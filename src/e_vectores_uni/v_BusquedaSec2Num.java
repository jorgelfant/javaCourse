package e_vectores_uni;

import java.util.Scanner;

public class v_BusquedaSec2Num {
    public static void main(String[] args) {
        int elementos;
        int numero;
        int pos = 0;
        int repeticiones = 0;
        boolean encontrado = false;

        Scanner sc = new Scanner(System.in);

        System.out.println("Ingrese el numero de elementos");
        elementos = sc.nextInt();
        int[] tab = new int[elementos];

        for (int i = 0; i < tab.length; i++) {
            System.out.println((i + 1) + " Ingrese un numero");
            tab[i] = sc.nextInt();
        }
        //-------------------------------------------------------------------------------------------
        //Determinar si el numero se encuentra en el arreglo
        //-------------------------------------------------------------------------------------------
        int[] tabRep = new int[elementos];//este arreglo de numero de elementos almacena el indice donde hay repeticiones
        // en un arreglo de 5 elementos por ejemplo el max de repeticiones de un n sera 5
        System.out.println("Ingrese el numero que desea buscar");
        while (!encontrado) {
            numero = sc.nextInt();
            int j = 0;
            int iter = 0;//para 2da opcion

            while (j < tab.length) {
                if (tab[j] == numero) {
                    encontrado = true;
                    pos = j; //en el caso que solo este una vez
                    // tabRep[j] += 1;//opcion 1 para almacenar las pociciones donde se encuentra un mismo numero
                    tabRep[iter] = j;  //opcion 2 almacenar en el arreglo directamente los indices
                    iter++;
                    repeticiones++;//opcion 2 recupera el valor de repeticiones fuera de la boucle( entradas en el if)
                }
                j++;
            }
            if (!encontrado) {
                System.out.println("El numero ingresado no esta en el arreglo, ingrese otro");
            }
        }
        //------------------------------------------------------------------------------------------
        //Determinar numero de repeticiones de un numero pedido OPCION 1
        //------------------------------------------------------------------------------------------
    /*System.out.println("El numero ingresado se encuentra repetido en la posicion ");
    for (int FluentApiTest = 0; FluentApiTest < tabRep.length; FluentApiTest++) {
      if (tabRep[FluentApiTest] != 0) {
        System.out.print(FluentApiTest + " ");
      }
    }*/
        //-------------------------------------------------------------------------------------------
        //Determinar numero de repeticiones de un numero pedido OPCION 2
        //-------------------------------------------------------------------------------------------
        if (repeticiones == 1) {//ou repeticiones<2
            System.out.println("El numero ingresado se encuentra en la posicion " + pos);
        } else {
            System.out.println("El numero ingresado se encuentra repetido " + repeticiones + " veces " + " en las posiciones: ");
            for (int k = 0; k < repeticiones; k++) {//numero exacto de iteraciones
                System.out.print(tabRep[k] + " ");
            }
        }

    }
}
