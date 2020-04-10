package a_sequences;

import java.util.Scanner;

public class o_volAreaEsfera {
  public static void main(String[] args) {
    //volumen y area de una esfera
    double radio,volumen,area;
    Scanner sc=new Scanner(System.in);
    System.out.println("Ingrese el radio de la esfera");
    radio=sc.nextDouble();

    area=4*Math.PI*Math.pow(radio,2);
    volumen=((4*Math.PI)/3)*Math.pow(radio,3);
    System.out.println("Area: " + area + "\nvolumen: " +volumen);

  }
}
