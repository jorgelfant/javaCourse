package d_funciones;

import java.util.Scanner;

public class z_LaFiesta {
    public static void main(String[] args) {
        //A una fiesta asistieron personas de diferentes edades y sexos.construir un algoritmo dadas las
        //edades y sexos de las personas. Calcular
        //1. cuantas personas asistieron a la fiesta
        //cuantos hombres y cuantas mujeres
        //promedio de edades por sexo
        //La edad de la persona mas joven que asistio
        //No se permiten menores de edad a la fiesta
        //Ingresar datos hasta que se ingrese la edad 0
        int conteoH = 0;
        int conteoM = 0;
        int sumaTotal;
        int sumaEdadH = 0;
        int promedioEdadH;
        int sumaEdadM = 0;
        int promedioEdadM;
        int edad = 1;
        char sexo;
        int masJoven = 999;

        while (edad != 0) {
            Scanner sc = new Scanner(System.in);

            System.out.println("Ingrese su edad o '0' para terminar");
            edad = sc.nextInt();
            if (edad != 0) {//pa que ya cuente cuando ponemos 0 y solo salga
                if (edad < 18) {
                    System.out.println("Usted no puede entrar a la fiesta, fuera!");
                } else {
                    sc.nextLine();
                    do {
                        System.out.println("Ingrese su genero, 'm' o 'f'");
                        sexo = sc.nextLine().charAt(0);
                    }
                    while (sexo != 'm' && sexo != 'f');//solo podra ser masculino o femenino gracias a este filtro puedo

                    if (sexo == 'm') {                   //hacer un if y else y no dos if
                        conteoH++;
                        sumaEdadH += edad;
                    } else {
                        conteoM++;
                        sumaEdadM += edad;
                    }
                    //persona mas joven tomara en cuenta solo a aquellos que son mayores de 18
                    if (edad < masJoven) {
                        masJoven = edad;
                    }
                }
            }
        }//no se puede dividir entre 0 en el caso que solo hubieran mujeros y 0 mujeres por eso usamos los condicionales
        sumaTotal = conteoH + conteoM;
        System.out.print("A la fiesta asistieron ");
        if (conteoH == 0) {
            System.out.println("solo " + conteoM + " mujeres");
            promedioEdadM = sumaEdadM / conteoM;//no se puede dividir entre 0 en el caso que solo hubieran mujeros y 0 mujeres
            System.out.println("el promedio de edad por sexo es, Mujeres: " + promedioEdadM + " y ningun hombre");
        } else if (conteoM == 0) {
            System.out.println("solo " + conteoH + " hombres");
            promedioEdadH = sumaEdadH / conteoH;//no se puede dividir entre 0 en el caso que solo hubieran mujeros y 0 hombres
            System.out.println("el promedio de edad por sexo es, Hombres: " + promedioEdadH + " y ninguna mujer");
        } else {
            promedioEdadM = sumaEdadM / conteoM;
            promedioEdadH = sumaEdadH / conteoH;
            System.out.println(sumaTotal + " personas" + " de los cuales " + conteoH + " hombres y " + conteoM + " mujeres");
            System.out.println("el promedio de edades por sexo es, Hombres: " + promedioEdadH + " Mujeres : " + promedioEdadM);
        }
        System.out.println("el invitado mas joven tiene " + masJoven);
    }
}
