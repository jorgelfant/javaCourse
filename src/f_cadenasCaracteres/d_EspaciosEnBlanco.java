package f_cadenasCaracteres;

import java.util.Scanner;

public class d_EspaciosEnBlanco {
    public static void main(String[] args) {

        String cadena;
        Scanner sc = new Scanner(System.in);

        System.out.println("Ingrese una cadena");
        cadena = sc.nextLine();
//nno importa si es uno o muchos espacios

        int conteo = 0;
        char nueva;//almacena la cadena sin espacios
        for (int i = 0; i < cadena.length(); i++) {
            nueva = cadena.charAt(i);
            if (nueva == ' ') {
                for (int j = nueva; j < cadena.length(); j++) {
                    nueva = cadena.charAt(i + 1);
                    System.out.print(nueva);//funciona sin este print tb
                }
                conteo++;
            } else {
                System.out.print(nueva);
            }
        }
        System.out.println();
        System.out.println(conteo);
        //------------------------------------------------------------------------------------------------------------------
        //                                        2DO METODO MAS EFICAZ CON WHILE
        //------------------------------------------------------------------------------------------------------------------
        String juntar = "";
        int i = 0;
        while (i < cadena.length()) {//ou while
            if (cadena.charAt(i) != ' ') {//imprimo quiere decir que i es una letra si no es un espacio
                juntar += cadena.charAt(i);//-1 - 2 etc  ou acev concat()
                i++;
            } else {//caso contrario en el que i es un espacio no hago nada y paso al siguiente//necesario el else
                i++;  //si else i++ aumentaria siempre despues del if osea podria aumentar 2 posiciones ne una pasada en vez de una
            }
        }
        System.out.println(juntar);
//------------------------------------------------------------------------------------------------------------------
        //                                        3DO METODO MAS EFICAZ CON CONCAT
        //------------------------------------------------------------------------------------------------------------------
        String junto = "";
        int j = 0;
        while (j < cadena.length()) {//ou while
            if (cadena.charAt(j) != ' ') {//imprimo quiere decir que i es una letra si no es un espacio
                junto = junto.concat(cadena.substring(j, j + 1));//-1 - 2 etc  ou acev concat()
                j++;
            } else {//caso contrario en el que i es un espacio no hago nada y paso al siguiente//necesario el else
                j++;  //si else i++ aumentaria siempre despues del if osea podria aumentar 2 posiciones ne una pasada en vez de una
            }
        }
        System.out.println(junto);

    }

}
