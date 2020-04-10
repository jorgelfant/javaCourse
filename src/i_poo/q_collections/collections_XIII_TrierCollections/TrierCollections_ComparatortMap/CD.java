package i_poo.q_collections.collections_XIII_TrierCollections.TrierCollections_ComparatortMap;

//class de TEST
class CD implements Comparable {

    private String auteur, titre;
    private Double prix;

    public CD(String auteur, String titre, Double prix) {
        this.auteur = auteur;
        this.titre = titre;
        this.prix = prix;
    }

    //metodo de Comparable*******************************************************************************
    //DEBERIAMOS TB AGREGAR EL CASO DEL PRIX!
    public int compareTo(Object o) {
        if (o instanceof CD) {//ou if(this.getClass().equals(CD.class))
            CD otro = (CD) o;
            //En caso tengamos un CD con mismo autor, en 2 objetos diferentes on trie sur le nom du titre
            if ((this.auteur.compareTo(otro.getAuteur()) == 0)) {//si los autores son iguales (el mismo)
                if ((this.titre.compareTo(otro.getTitre()) == 0)){
                    return this.prix.compareTo(otro.getPrix());
                }
                else{
                    return this.titre.compareTo(otro.getTitre());
                }

            }
            return this.auteur.compareTo(otro.getAuteur());//nombre del artista
        }
        return -1;
    }

    //***************************************************************************************************
    public String toString() {
        return "CD [auteur=" + auteur + ", titre=" + titre + ", prix=" + prix
                + "]";
    }

    public String getAuteur() {
        return auteur;
    }

    public String getTitre() {
        return titre;
    }

    public double getPrix() {
        return prix;
    }
}