package b_condicionales;

import java.util.Scanner;

public class m_max_mil_min {
  public static void main(String[] args) {
    //MAX MIL  ET MIN
    int n1, n2, n3, max, mil, min, temp,suma1,suma2,inter;
    Scanner sc = new Scanner(System.in);

    System.out.println("Digitar 1er numero");
    n1 = sc.nextInt();
    System.out.println("Digitar 2do numero");
    n2 = sc.nextInt();
    System.out.println("Digitar 3er numero");
    n3 = sc.nextInt();

/*MAYOR MINIMO MEDIO 1ra opcion
    if (n1 > n2) {
      max = n1;
      mil = n2;
    } else {
      max = n2;
      mil = n1;
    }
    if (max > n3) {
      if (mil > n3) {
        min = n3;
      }
      else{
        temp=mil;
        mil=n3;
        min=temp;
      }
    }
    else{
      min=mil;
      mil=max;
      max=n3;
    }
    System.out.println("Le max est " + max + " Le milieu est " + mil + " et le min est " + min);
*/
/*MAYOR MINIMO MEDIO
    if (n1 > n2) {
      max = n1;
      mil = n2;
    } else {
      max = n2;
      mil = n1;
    }
    if (n3 < max) {
      if (n3 < mil) {
        min = n3;
      } else {
        min = mil;
        mil = n3;
      }
    } else {
      min = mil;
      mil = max;
      max = n3;
    }
    System.out.println("Le max est " + max + " Le milieu est " + mil + " et le min est " + min);
    */
    //MAYOR MINIMO MEDIO 2da OPCION
    if (n1 > n2 && n1 > n3) {
      max = n1;
    } else if (n2 > n1 && n2 > n3) {
      max = n2;
    } else {
      max = n3;
    }
    if (n1 < n2 && n1 < n3) {
      min = n1;
    } else if (n2 < n1 && n2 < n3) {
      min = n2;
    } else {
      min = n3;
    }
    suma1=n1+n2+n3;
    suma2=max+min;
    inter=suma1-suma2;
    System.out.println("Le max est " + max + " Le milieu est " + inter + " et le min est " + min);

    /*MAYOR
    if(n1>n2){
      max=n1;
    } else{
      max=n2;
    }if(n3>max){
      max=n3;
    }
    */
    /*if (n1 > n2 && n1 > n3) {
      max = n1;
    }else if (n2 > n1 && n2 > n3) {
      max = n2;
    } else {
      max = n3;
    }*/
    //System.out.println("Le max est " + max);
  }
}
