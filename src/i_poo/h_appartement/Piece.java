package i_poo.h_appartement;

public class Piece {

    private String typePiece;
    private int longueur;
    private int largeur;

    //------------------------------------------------------------------------------------------------------------------
    //                                        Constructor
    //------------------------------------------------------------------------------------------------------------------
    public Piece(String typePiece, int longueur, int largeur) {
        this.typePiece = typePiece;
        this.longueur = longueur;
        this.largeur = largeur;

    }
    //------------------------------------------------------------------------------------------------------------------
    //                                        OBTENIR PROPIEDADES
    //------------------------------------------------------------------------------------------------------------------

    public String getTypePiece() {
        return this.typePiece;
    }

    public int getLongueur() {
        return this.longueur;
    }

    public int getLargeur() {
        return this.largeur;
    }

    //------------------------------------------------------------------------------------------------------------------
    //                                        OBTENIR SURFACE
    //------------------------------------------------------------------------------------------------------------------

    public int surface() {
        int surface;
        surface = this.largeur * this.longueur;
        return surface;
    }

    //------------------------------------------------------------------------------------------------------------------
    //                                        toString()
    //------------------------------------------------------------------------------------------------------------------
    public String toString() {
        return this.typePiece + ", a une surface de : " + this.surface() + " m2";
    }

}
