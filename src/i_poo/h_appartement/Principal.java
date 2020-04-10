package i_poo.h_appartement;

import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Ingrese el numero de cuartos ");
        int nbrePieces = sc.nextInt();

        //El tableau d'objects le creo afuera y pongo el tab como argumento en el constructor en el principal   tab
        //Piece[] tab=new Piece[5];
        //Appartement t1 = new Appartement(tab);

        //o lo creo dentro del constructor y en el principal pongo como argumento solo el tamanio del tab    int
        Appartement appart = new Appartement(nbrePieces);

        System.out.println(appart.toString());//da datos de cada objeto piece en el objeto tab appart

        System.out.println(appart.surfaceTotal()); //da la suma se surfaces de cada pieza y asi el total
        //System.out.println(appart.dar()[0].getTypePiece());  [0] indice el objeto 0 del tab , es como poner tab[0]

        //el metodo dar() de Apartament return el objeto Piece tab[] aqui en el principal, ya que al ser privado se usa un metodo public
        //para acceder a el y asi a sus diferentes metodos de este objeto Piece

        //--------------------------------------------------------------------------------------------------------------
        //                  EN CASO LLENARA MI ARREGLO EN EL MAIN Y EL TAB EN ARGUMENTO
        //--------------------------------------------------------------------------------------------------------------
        /*
		A_Piece chambre=new A_Piece("chambre",5.0,2.5);

		A_Piece chambre2=new A_Piece("chambre d'amis",4,2.5);

		A_Piece salon=new A_Piece("Salon",4.0,5.5);

		A_Piece cuisine=new A_Piece("cuisine",4.0,3.5);

		A_Piece salleDeBain=new A_Piece("Salle de bain",1.5,2.0);

        //-----------------Crearion des tableaux d'objets ( au lieu de ints, Strings, etc)------------------------------

		//cela permer de personnaliser autant de pi�ces que l'on veut dans un appart (grace au tableau d'objetes)
		A_Piece [] f1 = {chambre,salleDeBain};

		A_Piece [] f2 = {chambre,salon, cuisine,salleDeBain};

		A_Piece [] f3 = {chambre,chambre2,salon, cuisine,salleDeBain};

       //-----------------Objets appartement (contenant les tableaux d'objets et le prix)-------------------------------

		A_Appartement t1= new A_Appartement (f1,30_000);                             //if (param�tre.equalsIgnoreCase("t1")
	                                                                                //prix=sc.nextInt();
		A_Appartement t2= new A_Appartement (f2,70_000);                            //else if (param�tre.equalsIgnoreCase("t1")
		                                                                            //prix=sc.nextInt();
		A_Appartement t3= new A_Appartement (f3,200_000);
        */

    }
}
