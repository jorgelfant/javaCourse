package b_condicionales;

public class n_moneda {
  public static void main(String[] args) {//hacer un programa que simule el lanzamiento de una moneda
    int aleatorio = (int) (Math.random() * 2);
    int cara = 1;
    int sello = 2;
    if (aleatorio == 1) {
      System.out.println(cara);
    }
    else{
      System.out.println(sello);
    }
  }
}
