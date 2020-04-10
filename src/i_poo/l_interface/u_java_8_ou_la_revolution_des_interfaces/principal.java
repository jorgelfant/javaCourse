package i_poo.l_interface.u_java_8_ou_la_revolution_des_interfaces;

public class principal {
    public static void main(String[] args) {
        //JAVA 8 ou LA REVOLUTION DES INTERFACES
        /*
        Nous avons vu beaucoup de concepts jusqu'ici et je vous ai d'ailleurs dit que l'héritage
        multiple n'existait pas en JAVA.

        Et bien:

        ****************************************************************************************************************
        JAVA 8 ET SON LOT DE NOUVEAUTES PERMET AUX INTERFACES DE DEFINIR DES METHODES AVEC UN COMPORTEMENT PAR DEFAUT
        ET DE DEFINIR DE "METHODES STATIQUES"
        ****************************************************************************************************************

        ****************************************************************************************************************
        La partie que l'on a traité avant (Pattern strategy etc) était déjà assez complexe, voilà pk on traite ce
        chapitre que maintenant. DONC en gros ce chapitre n'est vrai qu'à partir de JAVA 8 et que si l'on développe
        pour un environnement avec JAVA 7. N'UTILISEZ PAS CE QUE L'ON VERRA ICI !
        ****************************************************************************************************************
        */

        //**************************************************************************************************************
        //                                      DES METHODES STATIQUES
        //**************************************************************************************************************
        /*
        Je vous avais dit qu'une interface est une classe 100% abstraite, CE N'EST PLUS LE CAS DEPUIS JAVA 8
        car cette interface est valide et ce code fonctionne parfaitement :

        public interface Reproduction {

	      public static void description() {
	      	System.out.println("Méthode statique dans une interface");
	      }
       }*/

        //Nous pouvons même rajouter un niveau d'interface supplémentaire.
        //Pondre et mitose, ces 2 interface peuvent heriter(extends) de l'interface reproduction (elles auraient donc
        //ou heriteraient le contenu de reproduction, ainsi on pourrait redefinir les methodes statiques de reproduction
        //superClass    Reproducion.description(); dans la propre methode description de ces 2 interface qui deviennent
        //à la foi sublInterface de la interface Reproduction

        //UN NOUVEAU CODE EST TJRS FONCTIONNEL

        Reproducion.description();
        Pondre.description();//reescribe description del padre agregando dentro al mismo tiempo el metodo del padre
        Mitose.description();//reescribe description del padre agregando dentro al mismo tiempo el metodo del padre

        System.out.println();
        //IMPRIMERAIT
        /*
          Méthode statique dans une interface
          Méthode statique dans une interface
          Redéfinie dans Pondre.java
          Méthode statique dans une interface
          Redéfinie dans Mitose.java
        */
        Pondre yo=new Alien();//el hijo dentro del padre , se imprimiran los metodos del hijo Alien
        yo.reproduire();

        System.out.println();

        Alien tu=new Alien();//Alien directo imprime el metodo del padre que el reescribio (su propio metodo)
        tu.reproduire();
        /*--------------------------------------------------------------------------------------------------------------
        Bon, ce n'est pas très compliqué. Mains si nous ajoutons une méthode abstraite dans notre interface mère et
        que nous ajoutons une classe qui implémente nous deux interfaces filles, que se passerait-il ? Et bien
        pas grand chose puisque nous devrons redéfinir la méthode en question dans notre classe.
        --------------------------------------------------------------------------------------------------------------*/

        /*-------------------------------------------IMPORTANT----------------------------------------------------------
        Mais depuis Java 8, il est possible d'ajouter un comportement par défaut à des méthodes
        dans une interface grâce au mot clé DEFAULT.
        --------------------------------------------------------------------------------------------------------------*/
        //DONC MNT DEPUIS JAVA 8 une interface peut avoir des methodes statics et des methodes avec DEFAULT
        /*
        En résumé
        Avec Java 8, une interface n'est plus une classe 100% abstraite.

        Elle peut contenir du code sous deux formes :

        avec des méthodes statiques;

        avec une définition par défaut d'une méthode.
        */

    }
}
