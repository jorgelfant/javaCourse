package a_sequences;

import java.util.Scanner;

public class i_aumento {
  public static void main(String[] args) {//Calcular el nuevo salario de un obrero si obtuvo un incremento de 25%
    //sobre su salario anterior
    int salario, aumento, salarioN;
    Scanner sc = new Scanner(System.in);
    System.out.println("Ingrese su salario");
    salario = sc.nextInt();
    aumento = salario * 25 / 100;
    salarioN = salario + aumento;

    System.out.println("Su nuevo salario es " + salarioN);
  }
}
