package a_sequences;

import java.util.Scanner;

public class n_inversion3potes {
    public static void main(String[] args) {
//3 personas invierten dinero en una empresa, cada una invierte una cantidad diferente. Dar el porcentaje invertido
// con respecto al total
        int p1, p2, p3, total, porcentajep1, porcentajep2, porcentajep3;
        Scanner sc = new Scanner(System.in);

        System.out.println("Inversion persona 1");
        p1 = sc.nextInt();
        System.out.println("Inversion persona 2");
        p2 = sc.nextInt();
        System.out.println("Inversion persona 3");
        p3 = sc.nextInt();

        total = p1 + p2 + p3;
        porcentajep1 = p1 * 100 / total;
        porcentajep2 = p2 * 100 / total;
        porcentajep3 = p3 * 100 / total;

        System.out.println("El porcentaje de la primera persona es " + porcentajep1 + "\nEl porcentaje de la segunda persona es "
                + porcentajep2 + "\nEl porcentaje de la tercera persona es " + porcentajep3);
    }

}
