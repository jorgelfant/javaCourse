package a_sequences;

import java.util.Scanner;

public class j_Calificacion {
  public static void main(String[] args) {
    //Un alumno desea conocer su calificacion final en la materia algoritmos. Dicha calificacion se compone de los
    //siguientes porcentajes: 55% del promedio de sus 3 calificaciones parciales. 30% el exam final. 15% el trabajo final
    double n1, n2, n3, promedioP, examF, trabajoF, parcialC, examC, trabajoC;

    Scanner sc = new Scanner(System.in);
    System.out.println("Ingrese las notas de sus 3 parciales ");
    n1 = sc.nextDouble();
    n2 = sc.nextDouble();
    n3 = sc.nextDouble();
    promedioP = (n1 + n2 + n3) / 3;
    System.out.println("Ingrese la nota de su examen final ");
    examF = sc.nextDouble();
    System.out.println("Ingrese la nota de su examen final ");
    trabajoF = sc.nextDouble();

    parcialC = promedioP * 0.55;
    examC = examF * 0.30;
    trabajoC = trabajoF * 0.15;

    System.out.println("Su calificacion final en la materia de algoritmos es " + (parcialC + examC + trabajoC));

  }
}
