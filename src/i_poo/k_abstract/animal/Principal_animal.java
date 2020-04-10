package i_poo.k_abstract.animal;

public class Principal_animal {
    public static void main(String[] args) {

        // Animal ani=new Animal();  marche pas car Animal est abstract y no se pueden crear objetos con una clase abstract
        // System.out.println((Loup)ani).manger());

        // Personnellement, je ne sais pas ce que mange un objet Animal. Vous conviendrez que toutes
        // les classes ne sont pas bonnes à être instanciées !

        //C'est là qu'entrent en jeu nos classes abstraites. En fait, ces classes servent à définir une superclasse :
        // par là, vous pouvez comprendre qu'elles servent essentiellement à créer un nouveau type d'objets. Voyons
        // maintenant comment créer une telle classe.

        //Voyons à quoi cela peut servir. Vous avez vu les avantages de l'héritage et du polymorphisme. Eh bien
        // nos classes enfants hériteront aussi des méthodes abstraites, mais étant donné que celles-ci n'ont pas
        // de corps, nos classes enfants seront obligées de redéfinir ces méthodes ! Elles présentent donc des méthodes
        // polymorphes, ce qui implique que la covariance des variables pointe à nouveau le bout de son nez :

        Animal loup = new Loup();
        Animal chien = new Chien();
        loup.deplacement();
        chien.crier();

        //Attends ! Tu nous as dit qu'on ne pouvait pas instancier de classe abstraite !
        //
        //Et je maintiens mes dires : nous n'avons pas instancié notre classe abstraite. Nous avons instancié un objet
        // Loup que nous avons mis dans un objet de type Animal(il en va de même pour l'instanciation de la classe Chien).
        // Vous devez vous rappeler que l'instance se crée avec le mot clé new. En aucun cas, le fait de déclarer une
        // variable d'un type de classe donné – ici,Animal – n'est une instanciation ! Ici, nous instancions un Loup et un
        // Chien.
        //
        //Vous pouvez aussi utiliser une variable de type Object comme référence à un objet Loup, à un objet Chien etc.
        // Vous saviez déjà que ce code fonctionne :


        Object obj = new Tigre();
        ((Tigre) obj).crier();

        //En revanche, ceci pose problème :

        Object obj2 = new Loup();
        /*  Loup l = obj2; ERROR DE REFERENCE

        //Problème de référence ERROR porque no podemos poner un objeto de tipo Object en Loup
                             ya que Object es la superClass y no la inversa
                             regresamos el objeto a su tipo original
        */
        //Eh oui ! Nous essayons de mettre une référence de type Object dans une référence de type Loup: pour avertir
        // la JVM que la référence que vous voulez affecter à votre objet de type Loup est un Loup, vous devez utiliser
        // le transtypage ! Revoyons notre code :

        Loup l = (Loup) obj2; //CASTING
        //Vous prévenez la JVM que la référence que vous passez est de type Loup.


        //TODOO ESTO FUNCIONARIA TAMBIEN CON ANIMAL , PK? porque Animal posee estos metodos que son reescritos en los hijos
        Loup ll = new Loup("Gris bleuté", 20);
        ll.boire();//metodo de padre
        ll.manger();//metodo de padre
        ll.deplacement();//metodo de hijo
        ll.crier();//metodo de nieto (propia)
        System.out.println(ll.toString());//metodo sobreescrito en la super clase, y que pertenece a Object

        /*
       Pour le moment, nous n'avons de code dans aucune classe ! Les exemples que je vous ai fournis ne font rien du tout,
       mais ils fonctionneront lorsque nous aurons ajouté des morceaux de code à nos classes.
       */

        /*
        Étoffons notre exemple:

     Nous allons donc ajouter des morceaux de code à nos classes. Tout d'abord, établissons un bilan de ce que nous savons :

     Nos objets seront probablement tous de couleur et de poids différents. Nos classes auront donc le droit de modifier ceux-ci.

     Ici, nous partons du principe que tous nos animaux mangent de la viande. La méthodemanger()sera donc définie dans la classe Animal.

     Idem pour la méthode boire(). Ils boiront tous de l'eau (je vous voyais venir).

     Ils ne crieront pas et ne se déplaceront pas de la même manière. Nous emploierons donc des méthodes polymorphes et
     déclarerons les méthodesdeplacement()etcrier()abstraites dans la classeAnimal.

     La figure suivante représente le diagramme des classes de nos futurs objets. Ce diagramme permet de voir si une classe
     est abstraite : son nom est alors en italique.
        */


        //Nous voyons bien que notre classe Animal est déclarée abstraite et que nos classes filles héritent de celle-ci.
        // De plus, nos classes filles ne redéfinissent que deux méthodes sur quatre, on en conclut donc que ces
        // deux méthodes doivent être abstraites. Nous ajouterons deux constructeurs à nos classes filles :
        // un par défaut et un autre comprenant les deux paramètres d'initialisation. À cela, nous ajouterons aussi
        // les accesseurs d'usage. Mais dites donc… nous pouvons améliorer un peu cette architecture, sans pour
        // autant rentrer dans les détails !


        //Vu les animaux présents, nous aurions pu faire une sous-classe Carnivore, ou encore AnimalDomestique et
        // AnimalSauvage… Ici, nous allons nous contenter de faire deux sous-classes :Canin et Felin, qui hériteront
        // d'Animal et dont nos objets eux-mêmes hériteront !

        //Nous allons redéfinir la méthode deplacement() dans cette classe, car nous allons partir du principe que les
        // félins se déplacent d'une certaine façon et les canins d'une autre. Avec cet exemple, nous réviserons le
        // polymorphisme. La figure suivante correspond à notre diagramme mis à jour (vous avez remarqué ? J'ai ajouté
        // une méthodetoString()).


        /*
                                                 ****************
                                                    Animal
                                                  ****************
                                                  * poids: int
                                                  * couleur:String
                                                  * **************
                                                  * manger():void
                                                  * boire():void
                                                  * deplacement():void
                                                  * crier():void
                                                  * toString():String
                                                  * **************
                                                       |
                                                       |
                               \-----------------------|-----------------------\
                         *******************                            *******************
                               Canin                                           Felin
                         *******************                            *******************
                         *deplacement():void                            *deplacement():void
                         *******************                            ********************
                 /--------------|------------\---                 -/------------------|-------------------\
          ***********                **********                ***********          ***********           **********
             Loup                        Chien                  Chat                  Lion                 tigre
          ***********                ***********               ***********          ***********           **********
          *crier():void              crier():void              crier():void         crier():void          crier():void
          ***********                ***********               ***********          ***********           ***********
        */












        /*
        Afin de bien structurer vos programmes (on parle d'architecture logicielle), vous allez vous creuser
        les méninges pour savoir où ranger des comportements d'objets :

        .dans la classe mère ?

        .dans la classe fille ?

        Comment obtenir une structure assez souple pour pallier les problèmes de programmation les plus courants ?
        La réponse est dans ce chapitre.

        Une classe abstraite est quasiment identique à une classe normale. Oui, identique aux classes que
        vous avez maintenant l'habitude de coder. Cela dit, elle a tout de même une particularité :
        vous ne pouvez pas l'instancier ! Vous avez bien lu. Imaginons que nous ayons une classe A déclarée abstraite.

        public class Test{
         public static void principal(String[] args){
            A obj = new A(); //Erreur de compilation !
          }
         }

        Pour bien en comprendre l'utilité, il vous faut un exemple de situation (de programme, en fait) qui le requiert.
        Imaginez que vous êtes en train de réaliser un programme qui gère différents types d'animaux (oui, je sais :
        l'exemple est bête, mais il a le mérite d'être simple à comprendre).

        Dans ce programme, vous aurez des loups, des chiens, des chats, des lions et des tigres.
        Mais vous n'allez tout de même pas faire toutes vos classes bêtement : il va de soi que tous ces
        animaux ont des points communs ! Et qui dit points communs dit héritage. Que pouvons-nous définir
        de commun à tous ces animaux ? Le fait qu'ils aient une couleur, un poids, un cri, une façon de se déplacer,
        qu'ils mangent et boivent quelque chose.

        Nous pouvons donc créer une classe mère : appelons-la Animal. Avec ce que nous avons dégagé de commun,
        nous pouvons lui définir des attributs et des méthodes. La figure suivante représente nos classes.
        */


    }
}
