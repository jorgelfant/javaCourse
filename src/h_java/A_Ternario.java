package h_java;

import javax.swing.*;

public class A_Ternario {
    public static void main(String[] args) {
        int numero;
    /*
    String mensaje;
    numero = Integer.parseInt(JOptionPane.showInputDialog("Ingrese un numero"));

    mensaje = (numero >2 ) ? "El numero es par" : "El numero es impar";
    JOptionPane.showMessageDialog(null, mensaje);
    */
        //O SOLO esto sin la variable mensaje
        numero = Integer.parseInt(JOptionPane.showInputDialog("Ingrese un numero"));
        JOptionPane.showMessageDialog(null, (numero % 2 == 0) ? "El numero es par" : "El numero es impar");


    }
}
