package i_poo.o_exceptiones.except_pildoras;

import javax.swing.*;
import java.util.Scanner;

public class Exceptions_8_finally {
    public static void main(String[] args) {
        //clausula finally
        //NUESTRO PROGRAMA AQUI HACE 2 TAREAS , calcular las areas y calcular el peso ideal
        //queremos que si la primera parte que calcula las areas (switch) falla pues que no se pare el programa
        //y continue a la 2da parte

        Scanner sc = new Scanner(System.in);

        System.out.println("Elije una opcion:\n1. Cuadrado\n2. Rectangulo\n3. " + "Triángulo\n4. Círculo");
        try  {
            figura = sc.nextInt();//y si ponemos texto en vez de int..da un fallo
            // sc.close(); IMPORTANTE Cierra la conexion de la consola; en este caso si try no se ejecuta pues la
        } catch (Exception e) {//conexion tampoco se cerraria porque la pusimos dentro sc.close(); asi FluentApiTest mejor sacarla
            System.out.println("Ha ocurrido un error");
        } finally {//lo de finally se ejecuta siempre
            sc.close();//la ponemos aqui pa que la cierre si o si sea try o sea catch osea que se ejecute siempre
            //Habran veces en las que necesitemos que cuando se ejecutan exceptiones o no, se ejecute un codigo
            //hay caso es los que es imprescindible usar finally
        }//finally con ficheros y bases de datos

        switch (figura) {

            case 1:
                int lado = Integer.parseInt(JOptionPane.showInputDialog("In" + "troduce el lado:"));
                System.out.println(Math.pow(lado, 2));

                break;
            case 2:
                int base = Integer.parseInt(JOptionPane.showInputDialog("In" + "troduce la base:"));
                int altura = Integer.parseInt(JOptionPane.showInputDialog("In" + "troduce la altura: "));

                System.out.println("El área del rectángulo es: " + base * altura);

                break;
            case 3:
                base = Integer.parseInt(JOptionPane.showInputDialog("In" + "troduce la base:"));
                altura = Integer.parseInt(JOptionPane.showInputDialog("In" + "troduce la altura: "));
                System.out.println("El área del triángulo es: " + (base * altura) / 2);
                break;
            case 4:
                int radio = Integer.parseInt(JOptionPane.showInputDialog("In" + "troduce el radio: "));
                System.out.println("El área del círculo es: ");
                System.out.println(Math.PI * (Math.pow(radio, 2)));

                break;
            default://si puse como valor a figura un String el error ya esta controlado, y luego pasaria a default
                System.out.println("La opción no es correcta.");//ya que el valor de figura no seria ni 1 ni 2 ni 3 ni 4
        }
        //---------------------------------SEGUNDA PARTE-------------------------------

        int altura = Integer.parseInt(JOptionPane.showInputDialog("Introduce " + "tu altura en cm: "));

        System.out.printf("Si eres hombre tu peso ideal es: %d kg.\n", altura - 110);
        System.out.printf("Si eres mujer tu peso ideal es: %d kg.", altura - 120);

    }

    //fuera del main2
    static int figura;
}
