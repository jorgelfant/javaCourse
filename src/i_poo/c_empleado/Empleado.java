package i_poo.c_empleado;

import java.util.Date;
import java.util.GregorianCalendar;

//On mélangera les classes construites par nous et celles pre définies par java
public class Empleado {//les variables peuvent aller avant ou après le constructeur , java s'en fout

    //On utilise la variable arretContrat
    private String nom;
    private double salaire;
    private Date debutContrat;//date n'est pas dans la classe par défaut, il faut l'importer de l'api
    //il y a 2 classes date,  on prendra la deuxième appartenant à la classe util

    //GregorianCalendar a bcp de constructeur , on utilisera le deuxième constructeur
    //GregorianCalendar(int year,int month, int dayOfMonth)
    //el metodo gergorianCalendar() utiliza anio mes y dia

    //******************************************************************************************************************
    //                                          CONSTRUCTEUR
    //******************************************************************************************************************
    public Empleado(String nom, double salaire, int annee, int mois, int jour) {
        this.nom = nom;
        this.salaire = salaire;
        GregorianCalendar calendrier = new GregorianCalendar(annee, mois - 1, jour);//creation objet calendrier
        debutContrat = calendrier.getTime();//este metodo return un variable(objeto) de tipo Date
        //getTime() no es un metodo de GregorienCalendrier sino de su clase padre (herencia) Calendar
        /*
        Date	getTime()
                Returns a Date object representing this Calendar's time value (millisecond offset from the Epoch").
        */
    }

    //******************************************************************************************************************
    //                                          GETTERS
    //******************************************************************************************************************
    public String getNom() {
        return nom;
    }

    public Date getDebutContrat() {
        return debutContrat;
    }
    //******************************************************************************************************************
    //                                     METHODE D'AUGMENTATION
    //******************************************************************************************************************

    public void setSalaire(double salaire) {//cambio
        this.salaire = salaire;
    }

    public void augmentation(double pourcentage) {//aumentacion
        double augmentation = salaire * (pourcentage / 100);//10%  10/100
        salaire += augmentation;
    }

    public double getSalaire() {
        return salaire;
    }

    //******************************************************************************************************************
    //                                     METHODE D'AUGMENTATION
    //******************************************************************************************************************
}

