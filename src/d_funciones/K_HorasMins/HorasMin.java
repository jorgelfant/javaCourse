package d_funciones.K_HorasMins;

import java.util.Scanner;

public class HorasMin {
  public static void main(String[] args) {
    int minutos;
    Scanner sc = new Scanner(System.in);
    System.out.println("Ingrese los minutos");
    minutos = sc.nextInt();
    horasM(minutos);

  }

  private static void horasM(int minutos) {
    int horas = minutos / 60;
    int minuto = minutos % 60;
    System.out.println("En " + minutos + " minutos " + " hay " + horas + " horas " + " y " + minuto + " minutos");
  }
}
