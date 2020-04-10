package i_poo.t_classAnonymes;

public class Z_classes_Anonymes {
    public static void main(String[] args) {


        //Créez des classes anonymes, des interfaces fonctionnelles, des lambdas et des références de méthode

    /*Dans ce chapitre nous allons voir des notions que vous utiliserez très souvent dans vos projets car
     elles permettent de créer des programmes en allégeant considérablement votre code.

     Hormis les classes anonymes, les autres sujets traités dans ce chapitre sont des nouveautés de Java 8
     et ne peuvent être utilisées que dans un environnement supérieur ou égal à celui-ci.               */

        //Les classes anonyme
        // ********************

    /*Dans un chapitre précédent nous avons vu toute la puissance des interfaces. Mais vous avez dû vous
    rendre compte que que vous vous retrouvez alors avec un nombre de classes assez conséquent...
    Les classes anonymes permettent de faire exactement la même chose que ce que nous avons fait précédemment
    avec toute nos interfaces et classes abstraites mais sans avoir a créer de façon explicite une classe.

    Il n'y a rien de compliqué dans cette façon de procéder, mais je me rappelle avoir été déconcerté lorsque
    je l'ai rencontrée pour la première fois.

    Les classes anonymes sont le plus souvent utilisées pour la gestion d'actions ponctuelles, lorsque créer
    une classe pour un seul traitement est trop lourd. Rappelez-vous du code que nous avons utilisez pour
    tester le changement de comportement d'un personnage dans le chapitre sur les interfaces :
    */
        //Personnage pers = new Guerrier();

        //Aqui he creado un Guerrier de cual todos sus comportamientos son diferentes
        Personnage superGuerrero = new Guerrier(new EspritCombatif() {
            @Override
            public void combat() {
                System.out.println("Je me bats comme un sayayin !");
            }
        }, new Soin() {
            @Override
            public void soigner() {
                System.out.println("Mon energie se régénére toute seule");
            }
        }, new Deplacement() {
            @Override
            public void deplacer() {
                System.out.println("Je vole dans les airs à grande vitesse !");
            }
        });
        superGuerrero.combattre();
        superGuerrero.soigner();
        superGuerrero.seDeplacer();

        System.out.println();

        //**************************************************************************************************************
        //                  CLASSES ANONYMES au lieu de CLASSES (comportements qui heritent de l'interface)
        //**************************************************************************************************************
        //Esto me evita crear clases (comportements) que hereden de cada interface redefiniendo el metodo
        EspritCombatif pistolet = new EspritCombatif() {
            public void combat() {
                System.out.println("Je me bats avec mon pistolet ");
            }
        };
        // pistolet.combat();
        // Version Lambda en una linea
        EspritCombatif pistoletL = () -> System.out.println("Je me bats avec mon pistolet ");

        EspritCombatif fusil = new EspritCombatif() {
            public void combat() {
                System.out.println("Je tire avec mon fusil ");
            }
        };
        //fusil.combat();
        // Version Lambda en una linea
        EspritCombatif fusilL = () -> System.out.println("Je tire avec mon fusil ");

        EspritCombatif couteau = new EspritCombatif() {
            public void combat() {
                System.out.println("Je coupe avec mon couteau ! ");
            }
        };
        //couteau.combat();
        // Version Lambda en una linea
        EspritCombatif couteauL = () -> System.out.println("Je coupe avec mon couteau ");

        //**************************************************************************************************************

        Soin premiersSoins = new Soin() {
            public void soigner() {
                System.out.println("Je sonne les premiers soins ");
            }
        };
        //premiersSoins.soigner();
        // Version Lambda en una linea
        Soin premiersSoinsL = () -> System.out.println("Je sonne les premiers soins ");

        Soin operation = new Soin() {
            public void soigner() {
                System.out.println("Je fais des opérations");
            }
        };
        //operation.soigner();
        // Version Lambda en una linea
        Soin operationL = () -> System.out.println("Je fais des opérations");

        //**************************************************************************************************************

        Deplacement courir = new Deplacement() {
            public void deplacer() {
                System.out.println("Je cours vite !");
            }
        };
        //courir.deplacer();
        // Version Lambda en una linea
        Deplacement courirL = () -> System.out.println("Je cours vite !");

        //**************************************************************************************************************

        System.out.println();

        //UTILISATION D'UNE CLASSE ANONYME
        //Aqui estamos ejecutando el metodo directamente sin pasar por la creacion de una nueva clase que tendria este metodo

        Personnage pers = new Guerrier();
        pers.setEspritCombatif(fusil);//fusil es una clase anonima definida mas arriba
        pers.combattre();

        pers.setDeplacement(courir);
        pers.seDeplacer();
        /*
        pers.soigner();
        pers.setSoin(new Operation());
        pers.soigner();
        */
        // En suivant cet exemple, une classe anonyme permettant de modifier le comportement
        // de soin de notre personnage ressemblera à ceci :
        pers.setSoin(new Soin() {
            public void soigner() {
                System.out.println("Je soigne avec une classe anonyme !");
            }
        });
        pers.soigner();
        // Meme chose avec une lambda:
        // pers.setSoin(() -> System.out.println("Je soigne avec une classe anonyme !"));

        System.out.println();

        Personnage[] tPers = {new Guerrier(), new Civil(), new Medecin()};

        for (int i = 0; i < tPers.length; i++) {
            System.out.println("\nInstance de  " + tPers[i].getClass().getName());
            System.out.println("*********************************************");
            tPers[i].combattre();
            tPers[i].soigner();
            tPers[i].seDeplacer();
        }
        System.out.println();

        /* L'une des particularités de cette méthode, c'est que cette action n'est définie que pour cet objet.
        Nous devons seulement redéfinir la (ou les) méthode(s) de l'interface ou de la classe abstraite,
        que vous connaissez bien maintenant, dans un bloc d'instructions ; d'où les accolades après l'instanciation,
        comme le montre la figure suivante.                                                                           */

        /*
        Pourquoi appelle-t-on cela une classe « anonyme » ?
        ---------------------------------------------------

        C'est simple : procéder de cette manière revient à créer une classe fille sans être obligé de créer
        cette classe de façon explicite. L'héritage se produit automatiquement.Seulement, la classe créée
        n'a pas de nom, l'héritage s'effectue de façon implicite ! Nous bénéficions donc de tous les avantages
        de la classe mère en ne redéfinissant que la méthode qui nous intéresse.

        Sachez aussi que les classes anonymes peuvent être utilisées pour implémenter des classes abstraites.
        Je vous conseille d'effectuer de nouveaux tests en utilisant notre exemple du pattern strategy ; mais
        cette fois, plutôt que de créer des classes, créez des classes anonymes.

       *Les classes anonymes sont soumises aux mêmes règles que les classes « normales » :
        ----------------------------------------------------------------------------------

            .utilisation des méthodes non redéfinies de la classe mère ;

            .obligation de redéfinir toutes les méthodes d'une interface ;

            .obligation de redéfinir les méthodes abstraites d'une classe abstraite.


        *Cependant, ces classes possèdent des restrictions à cause de leur rôle et de leur raison d'être :
         -------------------------------------------------------------------------------------------------
             .elles ne peuvent pas être déclarées  abstract  ;

             .elles ne peuvent pas non plus être déclarées  static  ;

             .elles ne peuvent pas définir de constructeur ;

             .elles sont automatiquement déclarées  final  : on ne peut dériver de cette classe, l'héritage
              est donc impossible !

            Il y a moyen d'écrire encore moins de code avec les lambdas mais, avant, je dois vous parler du pillier
            des lambdas :

            les interfaces fonctionnelles
        */


    }
}
