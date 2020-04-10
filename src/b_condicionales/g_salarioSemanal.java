package b_condicionales;

import java.util.Scanner;

public class g_salarioSemanal {
  public static void main(String[] args) {/*Un obrero necesita calcular su salario semanal el cual se obtiene
  de la siguiente manera:
  si trabaja 40 horas o menos se le paga 16 euros
  si trabaja mas de 40 horas se le paga 16 euros por las primeras 40 horas y 20 por cada extra
  */
    int horasT,salarioS,horasE;
    Scanner sc = new Scanner(System.in);
    System.out.println("Ingrese un numero de horas trabajadas");
    horasT=sc.nextInt();

    if (horasT<=40) {
      salarioS=horasT*16;
    }
    else{
      horasE=horasT-40;
      salarioS=(40*16)+(horasE*20);
    }
System.out.println("El salario del obrero es "+ salarioS);
  }
}
