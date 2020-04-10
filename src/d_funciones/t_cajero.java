package d_funciones;

import java.util.Scanner;

public class t_cajero {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int montant;

        int stock = 0;
        int plafond;
        int retire = 0;
        int choix;
        char reponse = 'o';

        do {//Condicion ObjectA
            System.out.println("Bonjour, Quel est le montant que vous souhaitez retirer");
            System.out.println("Montants disponibles à partir de 20 euros");
            montant = sc.nextInt();
            plafond = 0;//reset
            do {
                plafond = plafond + montant;//si yo pongo retirar 5000 de golpe esto hace tb que el plafon sea 5000 x montant
                stock = stock + montant;//va contar siempre y cuando no exceda el plafond
                if (stock < 5000) {
                    if (plafond <= 1000) {
                        if (montant <= 20) {//antes de estos if pondria a FluentApiTest tipo de billetes asciende el monto 100 50 etc
                            System.out.println("ok");
                        } else if (montant <= 50) {
                            System.out.println("ok");
                        } else if (montant <= 100) {
                            System.out.println("ok");
                        } else if (montant <= 200) {
                            System.out.println("ok");
                        } else if (montant <= 500) {
                            System.out.println("ok");
                        } else if (montant <= 1000) {
                            System.out.println("ok");
                        } else {
                            System.out.println("ok");
                        }

                        System.out.println("Prenez vos billets");
                        sc.nextLine();
                        do {
                            System.out.println("Souhaitez-vous effectuer un autre retrait ?, 'o'pour continuer ou 'n' pour arreter");
                            reponse = sc.nextLine().charAt(0);
                        }while (reponse != 'o' && reponse != 'n');///hace una entras suplementaria , quitarlo y poner while
                        if (reponse == 'o') {
                            do {
                                System.out.println("Saisissez le montant");
                                montant = sc.nextInt();
                            } while (montant <= 0);
                        } else {
                            System.out.println("Au revoir");
                        }
                    } else {
                        System.out.println("Vous avez dépassé votre plafond, veuillez contacter votre banque");
                    }
                }
            }while (plafond <= 1000 && reponse == 'o');//respuesta guarda el valor no, lo que permite salir de este do while
            System.out.println();
        } while (stock < 5000);

        System.out.println("Ce distributeur n'a plus de billets, Veuillez trouver un autre");

/*
    int billete100 = montant / 100;//7;
    int billete50 = (montant % 100) / 50;
    ;
    int billete20 = ((montant % 100) % 50) / 20;//36/20=1
    int billete10 = (((montant % 100) % 50) % 20) / 10;//16/10=1
    int billete5 = ((((montant % 100) % 50) % 20) % 10) / 5;//16/10=1
    int billete1 = ((((montant % 100) % 50) % 20) % 10) % 5
*/
    }
}
/*
  private static void retirer(int montant) {
    //possibilités 10 20 50 et 100 euros

*/


