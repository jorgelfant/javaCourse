package i_poo.b_voiture_heritage;

//LES CLASSES COMMUNIQUENT ENTRE ELLES A TRAVERS LES METHODES!!!
//Nom du package tjrs en minuscules
public class Vehicule {//Un objeto tiene//propiedades//estado//comportamiento

    private int roues;
    private int longueur;
    private int largeur;
    private int puissance;
    private int poids;
    private int prix;

    private String color;

    private boolean siegesCuire, climatisation;

    //Puedes crear clases sin constructores. Aunque cuando haces esto, Java asume que tu
    //clase tiene un constructor por defecto, esto quiere decir que hay un constructor vacío aunque tú no lo pongas
    public Vehicule() {//CONSTRUCTEUR même nom que la classe CONSTRUCTEUR DE BASE AVEC ETAT INITIAL
        roues = 4;
        longueur = 2000;//cms
        largeur = 300;
        puissance = 1600;
        poids = 500;


    }

    //c'est possible de mettre les autres classes ici après le principal dans le meme package mais c'est déconseillé
    public String getRoues() {//ou int  accedemos a este valor con un metodo en la misma classe y que sera accesible del principal

        return "La voiture a " + roues + " roues";
    }

    //******************************************************************************************************************
    //                                               COLOR
    //******************************************************************************************************************
    //Si on avait pas utiliser le setter avant l’impression en console, la valeur de la couleur aurait
    // été null car la variable couleur était déclarée mais pas initiée
    public void setColor(String col) {//esto sirve para modificar/dar un valor en principal//NO para darle valor inicial (que no tiene aun)

        color = col;
    }

    public String getColor() {

        return "La couleur de la voiture est " + color;
    }

    //******************************************************************************************************************
    //                                          PROPIEDADES COMUNES
    //******************************************************************************************************************
    //PROPRIETES COMMUNES
    public String propCommunes() {
        return "La voiture a " + this.roues + " roues" + ", une largeur de " + this.largeur / 100 + " mètres" +
                " et une puissance de " + this.puissance;
    }

    //******************************************************************************************************************
    //                                            SIEGES EN CUIRE
    //******************************************************************************************************************
    //SETTER POUR LES SIEGES EN CUIRE

    public void setSiegesCuire(String siegesVoiture) {//boolean
        if (siegesVoiture.equals("oui")) {
            this.siegesCuire = true;
        } else {
            this.siegesCuire = false;
        }
    }

    //GETTER
    public String getSiegesCuire() {
        if (siegesCuire) {//==true
            return "La voiture a des sièges en cuire";
        } else {
            return "La voiture n'a pas de sièges en cuire";
        }

    }

    //******************************************************************************************************************
    //                                               CLIMATISATION
    //******************************************************************************************************************
    //SETTER POUR LA CLIMATISATION

    public void setClimatisation(String climatisation) {
        if (climatisation.equals("oui")) {
            this.climatisation = true;
        } else {
            this.climatisation = false;
        }
    }

    //GETTER POUR LA CLIMATISATION
    public String getClimatisation() {
        String clim;
        if (climatisation) {
            clim = "La voiture a une climatisation";
        } else {
            clim = "La voiture n'a pas de climatisation";
        }
        return clim;
    }

    //******************************************************************************************************************
    //******************************************************************************************************************
    //ON VA CREER un SETTER AND GETTER EN MM TEMPS, pas conseillé dans la POO
    /*
    public String poidTotal() {
        int carroserie = 500;
        poids = poids + carroserie;

        if (siegesCuire) {
            poids += 50;
        }
        if (climatisation) {
            poids += 20;
        }
        return "Le poids total est de " + poids;
    }
    */
    //******************************************************************************************************************
    //                                                      POIDS
    //******************************************************************************************************************
    //COMME CA DEVRAIT ETRE pero pa que funcione tendriamos que invocar este SETTER EN EL MAIN

    public void setPoids() {
        int carroserie = 500;
        poids = poids + carroserie;
        if (siegesCuire) {
            poids += 50;
        }
        if (climatisation) {
            poids += 20;
        }
    }

    public String getPoids() {
        return "Le poids total est de " + poids;
    }
    //*****************************************************************************************************************
    //                                                    PRIX
    //*****************************************************************************************************************

    public void setPrix() {//estoy haria el calculo del peso de manera interna y automatica
        prix = 1000;

        if (siegesCuire) {
            prix += 2000;
        }
        if (climatisation) {
            prix += 1500;
        }
    }

    public String getPrix() {
        return "Le prix total est de " + prix;
    }
}
//*****************************************************************************************************************
//                                          MANERA ALTERNATIVA
//*****************************************************************************************************************
     /*
     ESTO PARA RECURRIR A UN METODO INTERNO QUE CALCULARIA EL PESO DEL AUTO INTERNAMENTE SIN NECESIDAD DE LLAMAR
     AL METODO EN EL MAIN, YA QUE ESTE SERIA LLAMADO AUTOMATICAMENTE EN EL METODO setClimSieges, igual setPrix()

    //******************************************************************************************************************

    public void setClimSieges(String climatisation, String siegesCuire) {
         if (climatisation.equals("oui")) {
             this.climatisation = true;//siempre y cuando haya declarado en el constructor como false
         } else if (siegesCuire.equals("oui")) {
             this.siegesCuire = true;//siempre y cuando haya declarado en el constructor como false
         }
         setPoids(); //LLAMADO
         setPrix(); //LLAMADO
     }

    //******************************************************************************************************************

    private void setPoids() {//estoy haria el calculo del peso de manera interna y automatica
        int carroserie = 500;
        poids = poids + carroserie;
        if (siegesCuire) {
            poids += 50;
        }
        if (climatisation) {
            poids += 20;
        }
    }

    public String getPoids() {
        return "Le poids total est de " + poids;
    }

    //******************************************************************************************************************

    private void setPrix() {//estoy haria el calculo del peso de manera interna y automatica
        int prix=1000;

        if (siegesCuire) {
            poids += 2000;
        }
        if (climatisation) {
            poids += 1500;
        }
    }

    public String getPrix() {
        return "Le prix total est de " + prix;
    }

    //*****************************************************************************************************************
    //                                          OU
    //*****************************************************************************************************************

     public void setPoids() (String climatisation, String siegesCuire) {
        int carroserie = 500;
        poids = poids + carroserie;

         if (climatisation.equals("oui")) {
             poids += 50;
             prix+=2000;
         }
         if (climatisation.equals("non")) {
            poids += 20;
            prix+=1500;
         }
       }

        public String getPoids() {
        return "Le poids total est de " + poids;
        }

        public String getPrix() {
        return "Le prix total est de " + prix;
        }
    */
