package b_condicionales;

import java.util.Scanner;

public class m_ascend {
  public static void main (String [] args){
    //Programa que pida 2 sumeros y los imprima en forma ascendente
    int n1,n2;
    Scanner sc=new Scanner(System.in);
    System.out.println("Primer numero");
    n1=sc.nextInt();
    System.out.println("Segundo numero");
    n2=sc.nextInt();

    if (n1<n2){
      System.out.println("Impression ascendente " + n1 + " " + n2);
    }
    else{
      System.out.println("Impression ascendente " + n2 + " " + n1);
    }//ou mettre max et min yy al final imprimir min, max
  }
}
