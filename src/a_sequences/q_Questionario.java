package a_sequences;

import java.util.Scanner;

public class q_Questionario {
  public static void main(String[] args) {
    /*Un profesor prepara 3 cuestionarios para una evaluacion final:A B y C.
    se sabe que se tarda 5 minutos en revisar el cuestionario A,
    8 en revisar el cuestionario B
    6 en el C.
    La cantidad de examenes de cada tipo se entran por teclado.
    Cuantas horas y cuantos minutos se tardara en revisar todas los examenes*/
    int a = 5;
    int b = 8;
    int c = 6;
    int numeroE;
    int tiempo_examen = a + b + c;//19 minutos
    int tiempoT;
    int horas;
    int minutos;

    Scanner sc = new Scanner(System.in);

    System.out.println("Cuantos examenes hay ?");
    numeroE = sc.nextInt();
    tiempoT = numeroE * tiempo_examen;

    horas = tiempoT / 60;
    minutos = tiempoT % 60;

    System.out.println("Se tarda " + horas + " horas y " + minutos + " minutos en revisar " + numeroE + " examens");
  }
}
