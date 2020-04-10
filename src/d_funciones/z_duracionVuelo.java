package d_funciones;

import java.util.Scanner;

public class z_duracionVuelo {
    public static void main(String[] args) {
        //Se ingresa la HORA y MINUTOS de salida y la HORA y MINUTOS de llegada
        //de un avion. Se desea saber la duracion del vuelo en minutos.
        //Tener en cuenta que se deben validar los datos, que el vuelo puede pasarse de la
        //medianoche y que no dura mas de 24 horas.

        //Entrada:
        int horaSalida;
        int minutosSalida;
        int horaLlegada;
        int minutosLlegada;
        //Salida:
        int duracion;
        //condiciones y restricciones: el vuelo puede pasar de medianoche y no dura mas de 24h
        Scanner sc = new Scanner(System.in);
        do {
            System.out.println("Ingrese la hora de salida");
            horaSalida = sc.nextInt();
            System.out.println("Ingrese los minutos");
            minutosSalida = sc.nextInt();

            System.out.println("Ingrese la hora de llegada");
            horaLlegada = sc.nextInt();
            System.out.println("Ingrese los minutos");
            minutosLlegada = sc.nextInt();
            if (horaSalida > 24 || horaLlegada > 24 || minutosSalida > 60 || minutosLlegada > 60) {
                System.out.println("Los datos no han sido ingresados correctamente, vuelva a intentarlo");
            }
        } while (horaSalida > 24 || horaLlegada > 24 || minutosSalida > 60 || minutosLlegada > 60);

        //Conversion de horas y minutos en solo minutos  19<2
        if (horaSalida > horaLlegada) {//caso 1
            horaLlegada = 24 + horaLlegada;//para poder restarlo a eso las h y m de salida
        }
        if (horaLlegada == horaSalida && (minutosSalida > minutosLlegada || minutosSalida == minutosLlegada)) {//caso 2
            horaLlegada = 24 + horaLlegada;//para poder restarlo a eso las h y m de salida
        }
        duracion = ((horaLlegada * 60) + minutosLlegada) - ((horaSalida * 60) + minutosSalida);

        if (duracion >= 1440) {//24*60=1440 si se pasa esto significa que el vuelo dura mas de 24h ex: 3:41 y llego 3:20
            System.out.print("El vuelo no puede durar mas de 24 horas ");
        } else {
            System.out.print("La duracion del vuelo es " + duracion + " minutos o ");
            //CODICIONES PARA EL AFFICHAGE
            if ((duracion / 60) < 10) {
                System.out.print("0");
            }
            System.out.print(duracion / 60 + "h");

            if ((duracion % 60) < 10) {
                System.out.print("0");
            }
            System.out.print(duracion % 60 + "m");
        }
    }
}
