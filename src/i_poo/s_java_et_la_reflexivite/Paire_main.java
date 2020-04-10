package i_poo.s_java_et_la_reflexivite;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Paire_main {
    public static void main(String[] args) {
        //Hemos creado la clase Paire
        //Le but du jeu consiste à CREER UN OBJET Paire SANS UTILISER l'OPERATEUR new.

        /*Pour instancier un nouvel objet Paire, commençons par récupérer ses constructeurs.
          Ensuite, nous préparons un tableau contenant les données à insérer, puis invoquons la méthode toString().*/

        //Regardez comment procéder ; attention, il y a moult exceptions :

        String nom = Paire.class.getName();//nombre de la clase y lo almacenamos en un string nom

        try {
            //Ahora creamos un objet Class
            Class cl = Class.forName(nom); //nom contiene el nombre de la clase con Class.forName(String nameClass) lo recuperamos
            //y lo insertamos en el objeto de tipo Class que va contener ahora el tipo Paire

            //Nouvelle Instance de la classe Paire...con esto creamos un objeto Paire con el constructor 1 par default
            Object o1 = cl.newInstance();//el metodo newInstance() return un Object

            //On crée les paramètres du constructeur ...para poder crear un objeto Paire con el constructor 2
            Class[] types = new Class[]{String.class, String.class};

            //On récupère le constructeur avec les 2 paramètres
            Constructor ct = cl.getConstructor(types);

            //On instancie l'objet avec le constructeur surchargé...
            Object o2 = ct.newInstance(new String[]{"valeur 1 ", "valeur 2"});

            // Nous pouvons maintenant appeler la méthode toString() du deuxième objet…
            // Oh et puis soyons fous, appelons-la sur les deux :

            //On va chercher la méthode toString, elle n'a aucun paramètre
            Method m = cl.getMethod("toString", null);
            //La méthode invoke exécute la méthode sur l'objet passé en paramètre
            //Pas de paramètre, donc null en deuxième paramètre de la méthode invoke !

            System.out.println("----------------------------------------");
            //Invocation dynamique de méthodes
            System.out.println("Méthode " + m.getName() + " sur o2: " + m.invoke(o2, null));
            System.out.println("Méthode " + m.getName() + " sur o1: " + m.invoke(o1, null));
        } catch (SecurityException e) {
            e.printStackTrace();
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }

        /* IMPRIME
        Instantiation !
        Instantiation avec des paramètres !
        */

        /* IMPRESSION CON LOS METODOS
        Instantiation !
        Instantiation avec des paramètres !
        ----------------------------------------
        Méthode toString sur o2: Je suis un objet qui a pour valeur valeur 1  - valeur 2
        Méthode toString sur o1: Je suis un objet qui a pour valeur null - null
        */

        /*
        Voilà : nous venons de créer deux instances d'une classe sans passer par l'opérateur new. Mieux encore,
        nous avons pu appeler une méthode de nos instances ! Je ne vais pas m'attarder sur ce sujet, mais gardez
        en tête que cette façon de faire, quoique très lourde, pourrait vous être utile.

        Sachez que certains frameworks (ensemble d'objets offrant des fonctionnalités pour développer) utilisent
        la réflexivité afin d'instancier leurs objets (je pense notamment à des frameworks basés sur des fichiers
        de configuration XML tels que Hibernate, Struts, Spring…). L'utilité de ceci vous semble-t-elle évidente ?
        Même si vous ne savez pas les utiliser, peut-être avez-vous déjà entendu parler de ces frameworks Java.

        Maintenant, vous n'allez pas utiliser ce genre de technique tous les jours. Cependant, il est possible que
        vous ayez besoin, pour une raison quelconque, de stocker le nom d'une classe Java dans une base de données
        afin, justement, de pouvoir l'utiliser plus tard. Dans ce cas, lorsque votre base de données vous fournira
        le nom de la classe en question, vous pourrez la manipuler dynamiquement.

          .Lorsque votre JVM interprète votre programme, elle crée automatiquement un objet Class pour chaque classe chargée.

          .Avec un tel objet, vous pouvez connaître absolument tout sur votre classe.

          .L'objet Class utilise des sous-objets tels que Method, Field et Constructor qui permettent de travailler
           avec vos différents objets ainsi qu'avec ceux présents dans Java.

          .Grâce à cet objet, vous pouvez créer des instances de vos classes Java sans utiliser new.

       J'espère que cette partie vous a plu et que vous avez appris plein de bonne choses !
       J'ai volontairement omis de parler des flux et des threads dans cette partie. Je préfère avoir
       des cas bien concrets à vous soumettre pour ça...

       Bon : je sais que beaucoup d'entre vous l'attendent avec impatience, alors voici la partie sur
       la programmation événementielle !

        */


    }
}
