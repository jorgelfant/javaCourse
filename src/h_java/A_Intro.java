package h_java;

import javax.swing.*;

public class A_Intro {
  public static void main(String[] args) {
    String cadena;
    int entero;
    char letra;
    double decimal;
    //INPUT ALTERNATIVA A SCANNER   JOptionPane.showInputDialog("");
    cadena = JOptionPane.showInputDialog("Ingrese una frase");//pide un objeto string es un objeto
    entero = Integer.parseInt(JOptionPane.showInputDialog("Ingrese un entero"));
    letra = JOptionPane.showInputDialog("Ingrese una letra").charAt(0);
    decimal = Double.parseDouble(JOptionPane.showInputDialog("Ingrese un double"));

    //OUTPOUT JOptionPane.showMessageDialog(null,""); //primero nul y luego la variable
    JOptionPane.showMessageDialog(null, "La cadena es " + cadena);
    JOptionPane.showMessageDialog(null, "El numero entero es " + entero);
    JOptionPane.showMessageDialog(null, "La letra es " + letra);
    JOptionPane.showMessageDialog(null, "El decimal es " + decimal);

    //OTRA COSA
    /*
    int x=5,y;
    y=x++; //esto valdria 5 porque seria como poner y='x=x+1'; y solo coje el valor de x
           //ya que el aumento viene como sifijo osea que aumenta despues de haber dado
           //el valor de x a y

    lo que pasa aqui es que tamos asignando 1ro el valor de x a y y luego x se incrementa
    System.out.println(y)   y valdra 5
    System.out.println(x)   x valdra 6

    SIN EMBARGO sin en lugar de x++   usamos ++x
    y='x+1=x'

    esto aumentara el valor antes de asignarlo
    int x=5,y;
    y=++x; aumenta primero el valor de x porque ++ es prefijo y ya no sufijo

    System.out.println(y)   y valdra 6
    System.out.println(x)   x valdra 6

    */
  }
}
