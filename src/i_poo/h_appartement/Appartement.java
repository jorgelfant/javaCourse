package i_poo.h_appartement;

import java.util.Scanner;

public class Appartement {
    //private int prix;
    private int nbrePieces;
    private Piece[] tab;

    //------------------------------------------------------------------------------------------------------------------
    //                                        CONSTRUCTOR
    //------------------------------------------------------------------------------------------------------------------

    public Appartement(int nbrePieces) {//o que se llene de manera automatica solo poniendo un numero que sera el tamanio
        Scanner sc = new Scanner(System.in);
        this.nbrePieces = nbrePieces;
        //this.tab=tab;  en caso de que el parametro sea un arreglo que lleno en el principal
        this.tab = new Piece[this.nbrePieces];//se crea el tableau con el numero(tamanio) dado

        for (int i = 0; i < this.tab.length; i++) {//lo llenamos uno a uno con un for
            System.out.println("Ingrese el nombre de la pieza " + (i + 1));
            String nom = sc.nextLine();
            System.out.println("Ingrese el largo");
            int longueur = sc.nextInt();
            System.out.println("Ingrese el ancho");
            int largeur = sc.nextInt();

            tab[i] = new Piece(nom, longueur, largeur);
            sc.nextLine();//pa que funque despues de int y que quiero poner luego un String
        }
    }

    //------------------------------------------------------------------------------------------------------------------
    //                                      OBTENIR DATOS
    //------------------------------------------------------------------------------------------------------------------

    public String toString() {
        String surface = "";
        System.out.println("Composition de l'appartement T" + this.nbrePieces);

        for (int i = 0; i < tab.length; i++) {
            surface = surface.concat(this.tab[i].toString()) + "\n";//toString() de Piece a cada objeto en tab[i]
        }
        return surface;
    }

    //------------------------------------------------------------------------------------------------------------------
    //                                      OBTENIR EL OBJETO tab
    //------------------------------------------------------------------------------------------------------------------

    public Piece[] dar() {//esto es util para poder usar el objeto tab[] (que es private aqui), en el principal
        return tab;
    }

    //System.out.println(appart.dar()[0].getTypePiece());
    //------------------------------------------------------------------------------------------------------------------
    //                                      OBTENIR Surface TOTALE
    //------------------------------------------------------------------------------------------------------------------
    public String surfaceTotal() {

        int surface = 0;
        for (int i = 0; i < tab.length; i++) {
            surface = surface + this.tab[i].surface();//toString() de Piece a cada objeto en tab[i]
        }
        return "La surface totale est de " + surface + " m2";
    }
}



