package a_sequences;

import java.util.Scanner;

public class j_hms {
  public static void main(String[] args) {//Calcular cantidad de segundos que estan incluidos en el numero de
    //horas, minutos y segundos ingresados por el usuario
    int horas, minutos, segundos, segundosTotal;
    Scanner sc = new Scanner(System.in);
    System.out.println("Ingrese las horas");
    horas = sc.nextInt();
    System.out.println("Ingrese los minutos");
    minutos = sc.nextInt();
    System.out.println("Ingrese las segundos");
    segundos = sc.nextInt();

    horas = horas * 3600;
    minutos = minutos * 60;
   //opcional a ne pas faire segundos = segundos * 1;

    segundosTotal = horas + minutos + segundos;
    System.out.println("El total de segundos es " + segundosTotal);

  }
}
