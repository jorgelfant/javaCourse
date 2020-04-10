package d_funciones.i_horasMinSecs;

import java.util.Scanner;

public class HorasMinsSecs {
  public static void main(String[] args) {//Programa que exprese en horas minutos y segundos un tiempo expresado en secs
    int segundo;
    Scanner sc = new Scanner(System.in);
    System.out.println("Ingrese el tiempo en segundos");
    segundo=sc.nextInt();

    cambio(segundo);//llamo a mi funcion
  }

  private static void cambio(int segundo) {
    int horas = segundo / 3600;
    int segundosRest = segundo % 3600;
    int minutos = segundosRest / 60;
    int segundos = segundosRest % 60;

    System.out.println("En " + segundo + " hay " + horas + " horas " + minutos + " minutos " + " y " + segundos + " segundos");
  }
}
