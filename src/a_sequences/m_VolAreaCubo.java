package a_sequences;

import java.util.Scanner;

public class m_VolAreaCubo {
  public static void main(String[] args) {//volumen y area de un cubo
    //volumen =a*a*a
    //area=6*(a*a)
    int area,volumen,a;
    Scanner sc=new Scanner(System.in);
    System.out.println("Insertar el lado del cubo");
    a=sc.nextInt();
    area=6*(a*a);
    volumen=a*a*a;

    System.out.println("El area del cubo es " + area + " y el volumen es " + volumen);

  }
}
