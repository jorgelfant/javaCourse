package i_poo.l_interface.personnage_pattern_strategy;

import i_poo.l_interface.personnage_pattern_strategy.combat.CombatCouteau;
import i_poo.l_interface.personnage_pattern_strategy.combat.EspritCombatif;
import i_poo.l_interface.personnage_pattern_strategy.combat.Pacifiste;
import i_poo.l_interface.personnage_pattern_strategy.deplacement.Deplacement;
import i_poo.l_interface.personnage_pattern_strategy.deplacement.Marcher;
import i_poo.l_interface.personnage_pattern_strategy.soin.AucunSoin;
import i_poo.l_interface.personnage_pattern_strategy.soin.Operation;
import i_poo.l_interface.personnage_pattern_strategy.soin.Soin;

public class principal {
    public static void main(String[] args) {


        /*--------------------------------------------------------------------------------------------------------------
        Nous allons partir du principe que vous avez un code qui fonctionne, c'est-à-dire un ensemble de classes liées
        par l'héritage, par exemple. Nous allons voir ici que, en dépit de la puissance de l'héritage, celui-ci atteint
        ses limites lorsque vous êtes amenés à modifier la hiérarchie de vos classes afin de répondre à une demande
        (de votre chef, d'un client etc.).

        Le fait de toucher à votre hiérarchie peut amener des erreurs indésirables, voire des absurdités : tout cela
        parce que vous allez changer une structure qui fonctionne à cause de contraintes que l'on vous impose.
        Pour remédier à ce problème, il existe un concept simple (il s'agit même d'un des fondements de la
        programmation orientée objet) : l'ENCAPSULATION !

        Nous allons parler de cette solution en utilisant un design pattern (ou « modèle de conception » en français).
        Un design pattern est un patron de conception, une façon de construire une hiérarchie des classes permettant
        de répondre à un problème. Nous aborderons le PATTERN STRATEGY, qui va nous permettre de remédier à la limite
        de l'héritage. En effet, même si l'héritage offre beaucoup de possibilités, il a ses limites.
        --------------------------------------------------------------------------------------------------------------*/

        /*--------------------------------------------------------------------------------------------------------------
                                          POSONS LE PROBLEME
        ----------------------------------------------------------------------------------------------------------------
        Mettons-nous dans la peau de développeurs d'une nouvelle société qui crée des jeux vidéos.
        Le dernier titre en date, "Z-Army", un jeu de guerre très réaliste, a été un succès international!

        Le patron est content et nous aussi. Vous vous basés sur une architecture vraiment simple afin de créer
        et utiliser des personnages comme le montre la figure suivante:

                                             ********************
                                             *    Personnage    *
                                             * ******************
                                             *                  *
                                             * ******************
                                             * seDeplacer():void*
                                             ********************
                                               ^              ^
                                               |              |
                                               |              |
                                               |              |
                                  ******************       ******************
                                  *    Guerrier    *       *    Medecin     *
                                  ******************       ******************
                                  *                *       *                *
                                  ******************       ******************
                                  *combattre():void*       *soigner():void  *
                                  ******************       ******************

                                              Hiérarchie des classes

         ---------------------------------------------------------------------------------------------------------------
         Les guerriers savent se battre tandis que les médecins soignent les blessés sur le champ de bataille.
         Et c'est maintenant que commencent les ennuis !

         Le patron vous confie le projet "Z-Army 2: the return of the revenge", et nous on dit :
         "YES ! mon architecture fonctionne à merveille, je la garde" (Pour la réutiliser bien sûr!

         Un mois plus tard, le patron nous convoque dans un bureau et nous dit:

         "Nous avons fait une étude de marché, et il semblerait que les joueurs aimeraient se battre aussi avec
          les médecins!  "

         Nous trouvons l'idée séduisante et avons déjà pensé à la solution: déplacer la méthode combattre()
         dans la superClass ///Personnage///, afin de la refédinir dans la classe ///Medecin///

                                             ********************
                                             *    Personnage    *
                                             * ******************
                                             *                  *
                                             * ******************
                                             * seDeplacer():void*
                                             * ******************
                                             * combattre():void *
                                             ********************
                                               ^              ^
                                               |              |
                                               |              |
                                               |              |
                                  ******************       ******************
                                  *    Guerrier    *       *    Medecin     *
                                  ******************       ******************
                                  *                *       *                *
                                  ******************       ******************
                                  *                *       *soigner():void  *
                                  ******************       ******************

                                              Hiérarchie des classes
                                         Déplacement de la méthode combattre()

           Mnt les Guerrier et les Médecins ont la methode combattre() et médecin peut en plus de cela soigner()

           -------------------------------------------------------------------------------------------------------------
           A la seconde étude de marché, le patron annonce que nous allons devoir créer des :
           .Civils
           .Snipers
           .Chirurgiens

           Toute une panoplie de personnages spécialisés dans leur domaine, comme le montre la figure suivante

                                             ********************
                                             *    Personnage    *
      *******************                    * ******************                 *******************
      *      Civil      *                    *                  *                 *   chirurgien    *
      *******************   ------------>    * ******************  <------------  *******************
      *                 *                    * seDeplacer():void*                 *                 *
      *******************                    * ******************                 *******************
      *                 *                    * combattre():void *                 *  soigner():void *
      *******************                    ********************                 *******************
                                            ^   ^              ^
                          _________________/    |              |
                        /                       |              |
            ************ /                      |              |
            *   Sniper *                        |              |
            ************                        |              |
            *          *          ******************       ******************
            ************          *    Guerrier    *       *    Medecin     *
            *          *          ******************       ******************
            ************          *                *       *                *
                                  ******************       ******************
                                  *                *       *soigner():void  *
                                  ******************       ******************

                                             Hiérarchie des classes
                                    Avec de nouveaux Personnages spécialisés

           -------------------------------------------------------------------------------------------------------------
           À ce stade, vous devriez remarquer que :

           .Le code contenu dans la méthode seDeplacer() est dupliqué dans toutes les classes ; il est identique dans
            toutes celles citées ci-dessus ;

           .le code de la méthode combattre() des classes Chirurgien et Civil est lui aussi dupliqué !

           /////La duplication de code est une chose qui peut générer des problèmes dans le futur. Je m'explique.///////

           Pour le moment, votre chef ne vous a demandé que de créer quelques classes supplémentaires.
           Qu'en serait-il si beaucoup de classes avaient ce même code dupliqué ? Il ne manquerait plus que
           votre chef vous demande de modifier à nouveau la façon de se déplacer de ces objets, et vous courrez
           le risque d'oublier d'en modifier un. Et voilà les incohérences qui pointeront le bout de leur nez !

           -------------------------------------------------------------------------------------------------------------
           No problemo ! Tu vas voir ! Il suffit de mettre un comportement par défaut pour le déplacement et pour
           le combat dans la superclasse Personnage.
           -------------------------------------------------------------------------------------------------------------

           Effectivement, votre idée se tient. Donc, cela nous donne ce qui suit :
        **/
    /*
        Personnage[] tpers = {new Guerrier(), new Chirurgien(), new Civil(), new Sniper(), new Medecin()};

        for (Personnage p : tpers) {
            System.out.println("\nInstance de " + p.getClass().getName());
            System.out.println("**************************************");
            p.combattre();
            p.seDeplacer();
            p.soigner();
        }
    */
         /*-------------------------------------------------------------------------------------------------------------
         Apparemment, ce code vous donne ce que vous voulez ! Mais une chose me chiffonne : vous ne pouvez pas
         utiliser les classes Medecin et Chirurgien de façon POLYMORPHE, vu que la méthode soigner() leur est propre !
         On pourrait définir un comportement par défaut (ne pas soigner) dans la superclasse Personnage et le tour
         serait joué.
         -------------------------------------------------------------------------------------------------------------*/

        /*--------------------------------------------------------------------------------------------------------------
        Au même moment, votre chef rentre dans votre bureau et vous dit : « Nous avons bien réfléchi, et il serait de
        bon ton que nos guerriers puissent administrer les premiers soins. » À ce moment précis, vous vous délectez
        de votre capacité d'anticipation ! Vous savez que, maintenant, il vous suffit de redéfinir
        la méthode soigner() dans la classe concernée, et tout le monde sera content !

        Seulement voilà ! Votre chef n'avait pas fini son speech : « Au fait, il faudrait affecter un comportement à
        nos personnages en fonction de leurs armes, leurs habits, leurs trousses de soin… Enfin, vous voyez ! Les
        comportements figés pour des personnages de jeux, de nos jours, c'est un peu ringard ! »

        Vous commencez à voir ce dont il retourne : vous devrez apporter des modifications à votre code, encore et
        encore. Bon : pour des programmeurs, cela est le train-train quotidien, j'en conviens. Cependant, si nous
        suivons les consignes de notre chef et que nous continuons sur notre lancée, les choses vont se compliquer.
        --------------------------------------------------------------------------------------------------------------*/

        /*-------------------------------------------------------------------------------------------------------------
                                                UN PROBLEME SUPPLEMENTAIRE
         -------------------------------------------------------------------------------------------------------------*/
        // Attelons-nous à appliquer les modifications dans notre programme. Selon les directives de notre chef,
        // nous devons gérer des comportements différents selon les accessoires de nos personnages : il faut
        // utiliser des variables d'instance pour appliquer l'un ou l'autre comportement.


        /*
                                             ********************
                                             *    Personnage    *
                                             ********************
                                             *  armes:String    *
                                             ********************
                                             *  chaussure:String*
                                             ********************
                                             * sacDeSoin:String *
                                             ********************
                                             *                  *
      *******************                    * ******************                 *******************
      *      Civil      *                    * seDeplacer():void*                 *   chirurgien    *
      *******************   ------------>    * ******************  <------------  *******************
      *                 *                    * combattre():void *                 *                 *
      *******************                    * ******************                 *******************
      *                 *                    * soigner():void   *                 *                 *
      *******************                    ********************                 *******************
                                            ^   ^              ^
                          _________________/    |              |
                        /                       |              |
            ************ /                      |              |
            *   Sniper *                        |              |
            ************                        |              |
            *          *          ******************       ******************
            ************          *    Guerrier    *       *    Medecin     *
            *          *          ******************       ******************
            ************          *                *       *                *
                                  ******************       ******************
                                  *                *       *                *
                                  ******************       ******************
                                  *
                                           Modification de nos classes

         Afin de simplifier l'exemple, nous n'allons utiliser que des objetsString.
        */

        /*--------------------------------------------------------------------------------------------------------------
        Vous avez remarqué que nos personnages posséderont des accessoires.
        Selon ceux-ci, nos personnages feront des choses différentes. Voici les recommandations de notre chef bien-aimé :

              *le guerrier peut utiliser un couteau, un pistolet ou un fusil de sniper ;

              *le sniper peut utiliser son fusil de sniper ainsi qu'un fusil à pompe ;

              *le médecin a une trousse simple pour soigner, mais peut utiliser un pistolet ;

              *le chirurgien a une grosse trousse médicale, mais ne peut pas utiliser d'arme ;

              *le civil, quant à lui, peut utiliser un couteau seulement quand il en a un ;

              *tous les personnages hormis le chirurgien peuvent avoir des baskets pour courir;

        Il va nous falloir des mutateurs (inutile de mettre les méthodes de renvoi (getXXX), nous ne nous servirons
        que des mutateurs !) pour ces variables, insérons-les dans la superclasse ! Bon ! Les modifications sont faites,
        les caprices de notre cher et tendre chef sont satisfaits ? Voyons cela tout de suite.
        --------------------------------------------------------------------------------------------------------------*/
        /*
        Personnage[] tpers = {new Guerrier(), new Chirurgien(), new Civil(), new Sniper(), new Medecin()};
        String[] tArmes = {"pistolet", "pistolet", "couteau", "fusil a pompe", "couteau"};

        for (int i = 0; i < tpers.length; i++) {
            System.out.println("\nInstance de " + tpers[i].getClass().getName());
            System.out.println("**************************************");
            tpers[i].combattre();
            tpers[i].setArmes(tArmes[i]);
            tpers[i].combattre();
            tpers[i].seDeplacer();
            tpers[i].soigner();
        }
        */
        /*--------------------------------------------------------------------------------------------------------------
        Vous constatez avec émerveillement que votre code fonctionne très bien. Les actions par défaut sont respectées,
        les affectations d'actions aussi. Tout est parfait !

        Vraiment ? Vous êtes sûrs de cela ? Pourtant, je vois du code dupliqué dans certaines classes ! En plus,
        nous n'arrêtons pas de modifier nos classes. Dans le premier opus de « Z-Army », celles-ci fonctionnaient
        pourtant très bien ! Qu'est-ce qui ne va pas ?

        Là-dessus, votre patron rentre dans votre bureau pour vous dire : « Les actions de vos personnages doivent
        être utilisables à la volée et, en fait, les personnages peuvent très bien apprendre au fil du jeu. »
        Les changements s'accumulent, votre code devient de moins en moins lisible et réutilisable, bref c'est
        l'enfer sur Terre.

        Faisons un point de la situation :

            .du code dupliqué s'insinue dans votre code ;

            .à chaque modification du comportement de vos personnages, vous êtes obligés de retoucher
             le code source de la (ou des) classe(s) concernée(s) ;

            .votre code perd en « réutilisabilité » et du coup, il n'est pas extensible du tout !(heritable)
        --------------------------------------------------------------------------------------------------------------*/
        /*-------------------------------------------------------------------------------------------------------------
                                   Une solution SIMPLE et ROBUSTE : le « pattern strategy »
         -------------------------------------------------------------------------------------------------------------*/
        /*
        Après toutes ces émotions, vous allez enfin disposer d'une solution à ce problème de modification du code source !
        Si vous vous souvenez de ce que j'ai dit, un des fondements de la programmation orientée objet est l'encapsulation.

        Le pattern strategy est basé sur ce principe simple d'ENCAPSULATION

        Bon, vous avez compris que le PATTERN STRATEGY consiste à:
        ----------------------------------------------------------------------------------------------------------------
                              CREER DES OBJETS AVEC DES DONNEES, DES METHODES (voire les deux) :
        ----------------------------------------------------------------------------------------------------------------
        c'est justement ce qui change dans votre programme !

        Le principe de base de ce pattern est le suivant :

        ----------------------------------------------------------------------------------------------------------------
                            « ISOLEZ CE QUI VARIE DANS VOTRE PROGRAMME ET ENCAPSULEZ-LE ! »
        ----------------------------------------------------------------------------------------------------------------

        Déjà, quels sont les éléments qui ne cessent de varier dans notre programme ?

          *La méthode combattre().

          *La méthode seDeplacer().

          *La méthode soigner().

        Ce qui serait vraiment grandiose, ce serait de:
        ----------------------------------------------------------------------------------------------------------------
        AVOIR LA POSSIBILITE de ne MODIFIER SEULEMENT COMPORTEMENTS et NON les OBJETS qui ont ces COMPORTEMENTS ! Non ?
        ----------------------------------------------------------------------------------------------------------------

        Là, je vous arrête un moment : vous venez de fournir la solution. Vous avez dit : « ce qui serait vraiment
        grandiose, ce serait d'avoir la possibilité de NE MODIFIER QUE LES COMPORTEMENTS et non les objets qui ont
        ces comportements ».

        Lorsque je vous ai présenté les DIAGRAMMES UML, je vous ai fourni une astuce pour bien différencier les liens
        entre les objets. Dans notre cas, nos classes héritant de Personnage héritent aussi de ses comportements et,
        par conséquent, on peut dire que nos classes filles sont des Personnage.

        Les comportements de la classe mère semblent ne pas être au bon endroit dans la hiérarchie. Vous ne savez
        plus quoi en faire et vous vous demandez s'ils ont vraiment leur place dans cette classe ? Il vous suffit
        de sortir ces comportements de la classe mère, de créer une classe abstraite ou une interface symbolisant
        ce comportement et d'ordonner à votre classePersonnaged'avoir ces comportements. Le nouveau diagramme des
        classes se trouve sur la figure suivante.

        Lo que vamos a hacer es utilizando en pattern strategy qui consiste a encapsular en un objeto lo que varia
        metodos (comportamientos) en el programa que se repiten, pero que hacen cosas diferentes y que tenemos
        que estar reescribiendo a cada rato. Lo que debe cambiar es el comportamiento y no el objeto en si.

        Osea en vez de estar reescribiendo a cada rato, tendriamos los diferentes comportamientos listos y encapsulados
        por ejemplo una interface ATACAR con un metodo attaque() que sus clases hijas deben implementar
        por ejemplo tendriamos 3 clases ataqueCuchillo  ataquePistola  ataquePunio qui al implementar la interface
        deberian implementar el metodo poe ejemplo



                                               Interface atacar
                                               ataque():void
                     __________________________________|____________________________________
                    /                                  |                                    \
        //ataqueCuchillo//                     //ataquePistola//                      //ataquePunio//
           diria "yo ataca con cuchillo"          diria "yo ataco con pistola"           diria "yo ataco a punio limpio"

           asi podriamos tener:

           atacar objeto=new ataqueCuchillo();  sirviendonos del polymorphismo y covariance de variable ya que atacar es padre de ataqueCuchillo
           atacar objeto=new ataquePistola();  sirviendonos del polymorphismo y covariance de variable ya que atacar es padre de ataqueCuchillo
           atacar objeto=new ataquePunio();  sirviendonos del polymorphismo y covariance de variable ya que atacar es padre de ataqueCuchillo

           la superClass tendra entonces variables de tipo objeto atacar (que es a su vez superClass de las 3 otras)
           asi si tenemos una variable
           atacar objeto=new ataqueCuchillo();
           y tuilizamos el metodo ataque() sera el metodo del hijo que sera llamado ya que el objeto d tipo atacar contiene
           un objeto de tipo attaqueCuchillo

           ASI: objeto.ataque();  llama al metodo del hijo que esta creado en el padre
           y esto podria ir en el metodo de la super classe Personnage

           Asi cuando uso el metodo combattre no tendria que preocuparme por escribir en cada clase hija Guerrier Medecin
           etc, sino que al asignarle  //ataqueCuchillo//      //ataquePistola//          //ataquePunio//
           contenido en la interface, la frase seria asignada en funcion de la que escojemos, esto nos evita el trabajo
           de reescribir a cada rato un contenido diferente en cada subClasse de Personnage.

           asi esto tendria ya la frase escrita en funcion del comportamiento elejido y no tendriamos que reescribir
           a cada rato que creamos una nueva clase que hereda de personaje por ejemplo

           de la misma manera que un Guerrier, Medecin etc es un personaje
           Personnage person=new Guerrier()

         ---------------------------------------------------------------------------------------------------------------
                              debemos ver si los comportamientos estan en el lugar indicado
         ---------------------------------------------------------------------------------------------------------------

                                                           Vamos a instanciar objetos de tipo interface (abstract o class normal)

            1                       SUPERCLASS
     ****************          ***********************
     *    Civil                *    Personnage       *                                                           ________3________
     ****************          ***********************  ----------------------utiliza------------------------->  | <<Interface>> |
     *                -------> *Combat:EspritCombatif*                                  _______2_________        _________________
     ****************  extends ***********************  ----------utiliza------------>  | <<Interface>> |        |   Soin        |
     *                         *  chaussure:String   *            ________1________      _________________        _________________
     ****************          ***********************--utiliza-->|<<Interface>> |      |  Deplacement  |        |soigner():void |
                               * sacDeSoin:String    *            _________________     _________________        _________________
                               ***********************            |EspritCombatif|      |deplacer():void|            ^         ^
             2                 *                     *            ________________      _________________            |         |
     ****************          ***********************            |combat():void |            ^     ^                |         |
     *   Sniper     *          * seDeplacer():void   *            _________________           |     |      implements|         |implements
     **************** -------> ***********************              ^         ^               |     |                |         |
     *              * extends  * combattre():void    *    implements|         |implements     |     |                |         |
     ****************          * *********************    *******1*******   *******2********  |     |     ********5******   ********6******
     *              *          * soigner():void      *    *CombatCouteau*   *CombatPistolet*  |     |     *PremiersSoins*   *  Operation  *
     ****************          ***********************    ***************   ****************  |     |     ***************   ***************
                                ^  ^           ^          *             *   *              *  |     |     *             *   *             *
                    ___________/   |           |          ***************   ****************  |     |     ***************   ***************
            3      / extends       |extends    |extends   *             *   *              *  |     |     *             *   *             *
       ************                |           |          ***************   ****************  |     |     ***************   ***************
       * Guerrier *                |           |                                              |     |
       ************             4  |          5|                                   implements |     |implements
       *          *      *************       ************                                     |     |
       ************      *  Medecin  *       *Chirurgien*                           *****3******   *****4******
       *          *      *************       ************                           * Marcher  *   *  Courir  *
       ************      *           *       *          *                           ************   ************
                         *************       ************                           *          *   *          *
                         *           *       *          *                           ************   ************
                         *************       ************                           *          *   *          *
                                                                                    ************   ************

                                                        Nouveau diagramme des classes

            Vous apercevez une nouvelle entité sur ce diagramme, l'interface, facilement reconnaissable, ainsi qu'une
            nouvelle flèche symbolisant l'implémentation d'interface entre une classe concrète et une interface.
            N'oubliez pas que votre code doit être souple et robuste et que — même si ce chapitre vous montre les
            limites de l'héritage — le polymorphisme est inhérent à l'héritage (ainsi qu'aux implémentations d'interfaces).

            Il faut vous rendre compte qu'utiliser une interface de cette manière revient à créer un supertype de
            variable ; du coup, nous pourrons utiliser les classes héritant de ces interfaces de façon polymorphe
            sans nous soucier de savoir la classe dont sont issus nos objets ! Dans notre cas, notre classe Personnage
            comprendra des objets de type EspritCombatif, Soinet Deplacement!

            Avant de nous lancer dans le codage de nos nouvelles classes, vous devez observer que leur nombre a
            considérablement augmenté depuis le début. Afin de pouvoir gagner en clarté, nous allons gérer nos
            différentes classes avec différents packages.

            Comme nous l'avons remarqué tout au long de ce chapitre, les comportements de nos personnages sont
            trop épars pour être définis dans notre superclassePersonnage. Vous l'avez dit vous-mêmes :
            il faudrait que l'on ne puisse modifier que les comportements et non les classes héritant
            de notre superclasse !

            Les interfaces nous servent à créer un supertype d'objet ; grâce à elles, nous utiliserons
            des objets de type :

                . EspritCombatif qui présentent une méthode combat();

                . Soin qui présentent une méthode soigner();

                . Deplacement qui présentent une méthodedeplace().

            Dans notre classe Personnage, nous avons ajouté une instance de chaque type de comportement, vous avez
            dû les remarquer : il y a ces attributs dans notre schéma ! Nous allons développer un comportement
            par défaut pour chacun d'entre eux et affecter cet objet dans notre superclasse. Les classes filles,
            elles, comprendront des instances différentes correspondant à leurs besoins.

         ---------------------------------------------------------------------------------------------------------------
                              Du coup, que fait-on des méthodes de la superclasse Personnage?
         ---------------------------------------------------------------------------------------------------------------

            Nous les gardons, mais plutôt que de redéfinir ces dernières, la superclasse va invoquer la méthode de
            comportement de chaque objet. Ainsi, nous n'avons plus à redéfinir ou à modifier nos classes !
            La seule chose qu'il nous reste à faire, c'est d'affecter une instance de comportement à nos objets.
            Vous comprendrez mieux avec un exemple. Voici quelques implémentations de comportements.

            HE definido un package soin, deplacement, combat   cada uno comprendera la interface (super type d'objet
            como una super class, y sus subclasses)

            Tendriamos esto: * pa indicar el package

            *combat     --->con su interface y sus 3 subclases que la implementan
            *deplacement    --->con su interface y sus 3 subclases que la implementan
            *soin       --->con su interface y sus 3 subclases que la implementan
             Chirurgien
             Civil
             Guerrier
             principal
             Medecin
         (SC)Personnage
             Sniper

             APRES CECI ON S'ATAQUE A LA SUPER CLASSE "PERSONNAGE"
             ON A TOUT MODIFIER aJOUTER LES CONSTRUCTEURS (1 par defaut et l'autre avec parametres)

             on a vider les subclasses de Personnages tout en redefinissant ou plutot changeant el comportement
             que l'on veut donner à chaque subclasse

             il faut ajouter le constructeur car sino chaque subclasse prendre par defaut le constructeur
             sans parametres de Personnage, car si la super classe a un constructeur sans parametres
             la subclasses le choisit de maniere automatique meme s'il y a d'autres constructeur, voila

          ---------------------------------------------------------------------------------------------------------------
                              SUPER IMPORTANTE , en cada subclasse necesitamos reescribir los constructores del padre
                              aquel sin parametros par default, y los otros con parametros
                              si queremos usar el otro constructor de la super classe debemos tb importarlo en la subclase,
                              sino no funcionara ya que al hacer por ejemplo
                              Personnage fff=new PErsonnage(pacifista, noSeCurar,caminante);//variables de tipo objeto
                                             -------------------------------------------

                              la machine virtual que solo reconoce à los constructores de las subclasses cuando estos
                              son reescritos en la subclase. SINO NO FUNCIONA
                              si tengo solo uno para defaut igual lo debo copiar en la subclase

                              ver el constructor (en pointillé) de nuestro objeto y no lo va a reconocer
                              y no se pueden construir objetos de tipo personnage porque es una class abstract
                              solo la hemos usado como patron de disenio ( aunque no le hayamos agregado metodos abstractos)

         ---------------------------------------------------------------------------------------------------------------

        */
        EspritCombatif var1 = new CombatCouteau();
        Soin var2 = new AucunSoin();
        Deplacement var3 = new Marcher();

        Personnage tireur = new Sniper();//el comportamiento par defaut sans parametres serait qu'il tire
        tireur.combattre();//esto daria je tire avec mon fusil, salvo si modificamos esto en los argumentos

        //el comportamiento par defaut sans parametres serait qu'il tire
        Personnage nuevoTireur = new Sniper(var1, var2, var3);//tb podria ser: (new CombatCouteau(),new AucunSoin,Marcher)
        nuevoTireur.combattre();                              //es decir crear los objetos en los armumentos

        EspritCombatif var4 = new Pacifiste();
        nuevoTireur.setEspritCombatif(var4);//ou new Pacifiste(
        nuevoTireur.combattre();
        /*
        IMPRESION
        Je tire avec mon fusil !
        Je me bats au couteau !
        Je ne combats pas !

        SERIA BUENO REDEFINIR UN toString
        */
        System.out.println();

        Personnage[] tPers = {new Guerrier(), new Civil(), new Medecin()};

        for (int i = 0; i < tPers.length; i++) {
            System.out.println("\nInstance de  " + tPers[i].getClass().getSimpleName());
            System.out.println("*********************************************");
            tPers[i].combattre();
            tPers[i].soigner();
            tPers[i].seDeplacer();
        }
        System.out.println();
        /*IMPRIME
        Instance de  poo.l_interface.personnage_pattern_strategy.Guerrier
        *********************************************
        Je combats au pistolet !
        Je ne donne AUCUN soin !
        Je me déplace en marchant.

        Instance de  poo.l_interface.personnage_pattern_strategy.Civil
        *********************************************
        Je ne combats pas !
        Je ne donne AUCUN soin !
        Je me déplace en marchant.

        Instance de  poo.l_interface.personnage_pattern_strategy.Medecin
        *********************************************
        Je ne combats pas !
        Je donne les premiers soins.
        Je me déplace en marchant.
        */
        /*
        Vous pouvez voir que nos personnages ont tous un comportement par défaut qui leur convient bien !
        Nous avons spécifié, dans le cas où cela s'avère nécessaire, le comportement par défaut d'un
        personnage dans son constructeur par défaut :

          .le guerrier se bat avec un pistolet ;

          .le médecin soigne.
        */

        //**************************************************************************************************************
        //Voyons maintenant comment indiquer à nos personnages de faire autre chose. Eh oui, la façon dont
        // nous avons arrangé tout cela va nous permettre de changer dynamiquement le comportement de chaque
        // Personnage. Que diriez-vous de faire faire une petite opération chirurgicale à notre objet Guerrier?
        //
        //Pour ce faire, vous pouvez redéfinir son comportement de soin avec son mutateur présent dans la superclasse
        // en lui passant une implémentation correspondante !

        Personnage pers=new Medecin();
        pers.soigner();//par defaut donne les premiers soins et n'opere pas
        pers.setSoin(new Operation());
        pers.soigner();
        /*IMPRIME
         Je donne les premiers soins. (par defaut)
         Je pratique des opérations !
        */

        /*
        En testant ce code, vous constaterez que le comportement de soin de notre objet a changé dynamiquement sans
        que nous ayons besoin de changer la moindre ligne de son code source ! Le plus beau dans le fait de travailler
        comme cela, c'est qu'il est tout à fait possible d'instancier des objets Guerrier avec des comportements différents.

           .Une classe est définie comme abstraite avec le mot cléabstract.

           .Les classes abstraites sont à utiliser lorsqu'une classe mère ne doit pas être instanciée.

           .Une classe abstraite ne peut donc pas être instanciée.

           .Une classe abstraite n'est pas obligée de contenir de méthode abstraite.

           .Si une classe contient une méthode abstraite, cette classe doit alors être déclarée abstraite.

           .Une méthode abstraite n'a pas de corps.

           .Une interface est une classe 100 % abstraite.

           .Aucune méthode d'une interface n'a de corps.

           .Une interface sert à définir un supertype et à utiliser le polymorphisme.

           .Une interface s'implémente dans une classe en utilisant le mot cléimplements.

           .Vous pouvez implémenter autant d'interfaces que vous voulez dans vos classes.

           .Vous devez redéfinir toutes les méthodes de l'interface (ou des interfaces) dans votre classe.

           .Le pattern strategy vous permet de rendre une hiérarchie de classes plus souple.

           .Préférez encapsuler des comportements plutôt que de les mettre d'office dans l'objet concerné.
        */

    }
}
