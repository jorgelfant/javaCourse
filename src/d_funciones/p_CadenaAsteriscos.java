package d_funciones;

import java.util.Scanner;

public class p_CadenaAsteriscos {
    public static void main(String[] args) {
        //Disenar un algoritmo que pida un nombre al usuario y que despliegue en pantalla
        //el nombre entre asteriscos. La cantidad de asteriscos debe ser la misma que caracteres
        //en el nombre, incluido los espacios.

        String nombre;
        Scanner sc = new Scanner(System.in);
        //una funcion que pida el nombre no funcionaria en java porque solo daria el nombre en la funcion
        //la 2da funcion no podria recuperar este nuevo valor de nombre dado
        System.out.println("Ingrese su nombre");
        nombre = sc.nextLine();
        //llamado de procedure
        System.out.println(aster(nombre));

    }

    private static String aster(String nombre) {
        String liason = "";//o un for antes de nombres y otro despues
        for (int i = 0; i < nombre.length(); i++) {
            liason = liason.concat("*");//autant de * que dans le nom... OU +='*'
        }
        return liason + "\n" + nombre + "\n" + liason;
    }

}
