package a_sequences;

import java.util.Scanner;

public class h_salario {
  public static void main(String[] args){//Dadas las horas trabajadas y el valor por hora calcular su salario
    int horasT,valorH,salario;

    Scanner sc=new Scanner(System.in);
    System.out.println("Cuantas horas ha trabajado");
    horasT=sc.nextInt();
    System.out.println("Cual es el pago por hora");
    valorH=sc.nextInt();

    salario=horasT*valorH;

    System.out.println("su salario es " + salario + " euros");
  }
}
