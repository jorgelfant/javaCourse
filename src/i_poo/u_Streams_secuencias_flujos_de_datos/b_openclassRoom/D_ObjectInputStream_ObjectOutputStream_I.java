package i_poo.u_Streams_secuencias_flujos_de_datos.b_openclassRoom;

import java.io.*;

//Packages à importer afin d'utiliser l'objet File


public class D_ObjectInputStream_ObjectOutputStream_I {
    public static void main(String[] args) {
        /*
        Vous devez savoir que lorsqu'on veut écrire des objets dans des fichiers, on appelle ça la « sérialisation » :
        c'est le nom que porte l'action de sauvegarder des objets ! Cela fait quelque temps déjà que vous utilisez
        des objets et, j'en suis sûr, vous avez déjà souhaité que certains d'entre eux soient réutilisables.
        Le moment est venu de sauver vos objets d'une mort certaine ! Pour commencer, nous allons voir comment
        sérialiser un objet de notre composition.

        Voici ce que nous allons faire :

            .nous allons créer deux ou trois objetsGame;

            .nous allons les sérialiser dans un fichier de notre choix ;

            .nous allons ensuite les désérialiser afin de pouvoir les réutiliser.
        */
        /*
        Vous avez sûrement déjà senti comment vous allez vous servir de ces objets,
        mais travaillons tout de même sur l’exemple que voici :
        */
        //Nous déclarons nos objets en dehors du bloc try/catch
        ObjectInputStream ois;
        ObjectOutputStream oos;
        try {//abrimos el Stream
            oos = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(new File("game.txt"))));

            //Nous allons écrire chaque objet Game dans le fichier
            oos.writeObject(new Game("Assassin Creed", "Aventure", 45.69));
            oos.writeObject(new Game("Tomb Raider", "Plateforme", 23.45));
            oos.writeObject(new Game("Tetris", "Stratégie", 2.50));
            //Ne pas oublier de fermer le flux ! Cerramos el Stream
            oos.close();

            //On récupère maintenant les données !
            //abrimos el Stream
            ois = new ObjectInputStream(new BufferedInputStream(new FileInputStream(new File("game.txt"))));
            //La désérialisation d'un objet peut engendrer uneClassNotFoundException, pensez donc à la capturer !
            try {//exception porque al leer el objeto puede que no se sepa a que clase pertenece y esto podria dar un error
                System.out.println("Affichage des jeux :");
                System.out.println("*************************\n");
                System.out.println(((Game) ois.readObject()).toString());//cast porque el objeto es de tipo Game
                System.out.println(((Game) ois.readObject()).toString());
                System.out.println(((Game) ois.readObject()).toString());
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }

            ois.close();//cerramos el stream

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    /*IMPRESION
    Affichage des jeux :
    *************************

    Nom du jeu : Assassin Creed
     Style de jeu : Aventure
     Prix du jeu : 45.69

    Nom du jeu : Tomb Raider
     Style de jeu : Plateforme
     Prix du jeu : 23.45

    Nom du jeu : Tetris
     Style de jeu : Stratégie
     Prix du jeu : 2.5

     Ce qu'il se passe est simple : les données de vos objets sont enregistrées dans le fichier.
     Mais que se passerait-il si notre objet Game avait un autre objet de votre composition en son sein ?...
     Nous allons maintenant implémenter une notice par défaut dans notre objetGame.

     Al modificar y ejecutar el programa tenemos un error una exception
     java.io.NotSerializableException: poo.u_Streams_secuencias_flujos_de_datos.b_openclassRoom.Notice
     Erreur de sérialisation.

     Esto es porque en mi classe Game uno de los parametros es de tipo objeto y este objeto (Notice) no esta
     implementando serializable

     Eh non, votre code ne compile plus ! Il y a une bonne raison à cela : votre objetNoticen'est pas sérialisable,
     une erreur de compilation est donc levée. Maintenant, deux choix s'offrent à vous :

        1) soit vous faites en sorte de rendre votre objet sérialisable ;

        2) soit vous spécifiez dans votre classe Game que la variable notice n'a pas à être sérialisée.

     Pour la première option, c'est simple, il suffit d'implémenter l'interface sérialisable dans notre classeNotice.
     Pour la seconde, "il suffit de déclarer votre variable :transient"; comme ceci :

     "private transient Notice notice";

     Vous aurez sans doute remarqué que nous n'utilisons pas la variable notice dans la méthode toString()de notre
     objet Game. Si vous faites ceci, que vous sérialisez puis désérialisez vos objets, la machine virtuelle vous
     renverra l’exceptionNullPointerException à l'invocation de la dite méthode. Eh oui ! L'objet Notice est ignoré :
     il n'existe donc pas !

     Esto ya que estariamos poniendo el valor de una variable que esta invisible/ignorada, osea se point a algo qu eno se ve
     voila!

    */
}

//**********************************************************************************************************************
//                              Afuera de la clase principal class Game
//**********************************************************************************************************************
//Voici la classe avec laquelle nous allons travailler :
class Game implements Serializable {
    private String nom, style;
    private double prix;
    //propiedad que acabo de agregar que hace que al momento de importar el objeto hay un error porque no ta seriaizado esta clase
    //2d opcion pa corregir el problema:
    //cette variable ne sera pas sérialisée al poner transient y sera ignorada
    //Elle sera tout bonnement ignorée ! esto se hace con el mot clé "transient"
    private transient Notice notice;

    public Game(String nom, String style, double prix) {
        this.nom = nom;
        this.style = style;
        this.prix = prix;
        //propiedad que acabo de agregar
        this.notice = new Notice();//por defecto la creation de este objeto inicia el String langue="Français";
    }

    public String toString() {
        return "Nom du jeu : " + this.nom + "\nStyle de jeu : " + this.style + "\nPrix du jeu : " + this.prix + "\n";
    }
}

/*
si une superclasse implémente l'interfaceSerializable, ses enfants seront considérés comme sérialisables.
*/
//**********************************************************************************************************************
//                              Afuera de la clase principal class Notice
//**********************************************************************************************************************
 class Notice/*implements serializable*/ {//1era opcion pa corregir el problema "serializar el objeto "
    private String langue ;
    public Notice(){
        this.langue = "Français";
    }
    public Notice(String lang){
        this.langue = lang;
    }
    public String toString() {
        return "\t Langue de la notice : " + this.langue + "\n";
    }
}