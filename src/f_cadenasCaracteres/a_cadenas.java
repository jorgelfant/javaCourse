package f_cadenasCaracteres;

public class a_cadenas {
  public static void main(String[] args) {
    String hola = "Hola jorge";
    String hola2 = " que tal";
    String num = "15";
    int numero = 15;

    System.out.println(hola.length());//da 10

    System.out.println(hola.substring(0, 6));//da hola j 0<6 no abarca el 6 sino hasta el 5

    System.out.println(hola.concat(hola2));//concatena una frase a otra

    System.out.println(hola.charAt(0));//leta del string

    System.out.println(Integer.parseInt(num) + 5);//convierte string a int

    System.out.println(String.valueOf(numero));//convierte int a string

    System.out.println(String.valueOf(hola.toUpperCase()));//up

    System.out.println(String.valueOf(hola.toLowerCase()));//low
  }
}