package i_poo.a_ville_heritage_capital;

public class Principal {
    public static void main(String[] args) {
        /*
        Imaginons que, dans le programme réalisé précédemment, nous voulions créer un autre type d'objet :
        des objetsCapitale. Ceux-ci ne seront rien d'autre que des objets Ville avec un paramètre en plus
        un monumento para exemple

        On va pas recoder tout le contenu de la classe Ville dans une nouvelle class
        mais en plus, si vous aviez à modifier le fonctionnement de la catégorisation de nos objets Ville,
        vous auriez aussi à effectuer la modification dans la nouvelle classe… Ce n'est pas terrible.

        Nous pourrons créer autant de classes dérivées, par rapport à notre classe de base, que nous le souhaitons.
        De plus, nous pourrons nous servir d'une classe dérivée comme d'une classe de base pour élaborer encore
        une autre classe dérivée.
        */
        //esta utiliza el constructor par default que no implement la Exception
        Capital ciudad1 = new Capital();//por el momento no tengo constructor en capital, java busca entonces
        //el constructor de la clase madre, en este caso el constructor par defaut
        //Si creamos un constructor ya propio de la classe hija entonce java adoptara el nuevo constructor propio de capital
        System.out.println(ciudad1.decrisToi());//METHODO DE SU CLASE MADRE VILLE HEREDADO EN CAPITAL
        //ON EST EN TRAIN D'APPELER LE CONSTRUCTEUR DE LA CLASSE MERE DE MANIERE TACITE
        //CAR POUR L'INSTANT Capital n'a pas de CONSTRUCTEUR
        /*
        C'est bien la preuve que notre objet Capitale possède les propriétés de notre objetVille.
        Les objets hérités peuvent accéder à toutes les méthodes public(ce n'est pas tout à fait vrai…
        Nous le verrons avec le mot clé protected) de leur classe mère, dont la méthode decrisToi()dans
        le cas qui nous occupe.
        */
        try {//Antigua manera, un catch despues de otro , normalment los catch deben tener contenido
            Capital ciudad2 = new Capital("Lima", 1000000, "Pérou", "Plaza de armas");
            System.out.println(ciudad2.decrisToi());
        } catch (NombreHabitantException e) {
        } catch (NomVilleException e) {
            e.printStackTrace();
        }
        try {//multi catch desde java 7
            Ville villeAvecException = new Ville("Lima", -50, "Perou");
        } catch (NombreHabitantException | NomVilleException e) {//crea un objeto exception por default, en el constructor por defaut pusimos un mensaje
            //Vous essayez d'instancier une classe Ville avec un nombre d'habitants négatif !
            // System.out.println("Hay un error");//esta instruccion no seria entonces necesaria pero bueno igual la dejamos..
            //e.printStackTrace();
        }
        //COMO CAPITAL HEREDA DE VILLE TB DEBO IMPLEMENTAR LA EXCEPTION EN el constructor con throws
        //y luego en el mail hacer el try catch

        /*
        Attention, il faut que vous soyez préparés à une chose : le code que j'ai utilisé fonctionne très bien, mais
        il y a un autre risque, l'instance de mon objet Ville a été déclarée dans le bloc try{…}catch{…} et cela
        peut causer beaucoup de problèmes.

        la déclaration de l'objet Ville est faite dans un sous-bloc d'instructions, celui du bloc try{…}. Et rappelez-vous :
        une variable déclarée dans un bloc d'instructions n'existe que dans celui-ci ! Ici, la variable villeAvecException n'existe pas
        en dehors de l'instruction try{…}. Pour pallier ce problème, il nous suffit de déclarer notre objet en dehors
        du bloc try{…} et de l'instancier à l'intérieur

        Mais que se passera-t-il si nous déclarons une Ville avec un nombre d'habitants négatif pour tester notre exception ?
        En remplaçant « 12000 » par « -12000 » dans l'instanciation de notre objet ? C'est simple : en plus d'une
        exception levée pour le nombre d'habitants négatif, vous obtiendrez aussi une NullPointerException.
        ya que el objeto decrada el null osea no hay nada dentro

        Voyons ce qu'il s'est passé :

                .Nous avons bien déclaré notre objet en dehors du bloc d'instructions.

                .Au moment d'instancier celui-ci, une exception est levée et l'instanciation échoue ! (car nbr negatif)

                .La clause catch{} est exécutée : un objet NombreHabitantException est instancié.

                .Lorsque nous arrivons sur l'instruction « System.out.println(v.toString()); », notre objet est null !

                .Une NullPointerException est donc levée !

        Ce qui signifie que si l'instanciation échoue dans notre bloc try{}, le programme plante ! Pour résoudre
        ce problème, on peut utiliser une simple clause finally avec, à l'intérieur, l'instanciation d'un objet
        Ville par défaut si celui-ci est null :
        */
//DEPUIS JAVA 7 MULTI CATCH
        Ville villeAvecException2 = null;//declaration al exterieur du try pour qu'il existe dans le program et nn seulemnt en try
        try {
            villeAvecException2 = new Ville("Li",-80 , "Perou");
        } catch (NombreHabitantException | NomVilleException e) {//crea un objeto exception por default, en el constructor por defaut pusimos un mensaje
            //Vous essayez d'instancier une classe Ville avec un nombre d'habitants négatif !
            //System.out.println("Hay un error");
            System.out.println(e.getMessage());//como es NombreHabitantException la primera condicion (lanzamiento except)
            //que pusimos en el constructor throw new NombreHabitantException(pNbre); esta sera la primera en ejecutarse
            //y como getmessage del constructor de NombreHabitantException no tiene message por eso da NULL
            //si en los 2 if que pusimos en el constructor NomVilleException hubiera estado primero entonces este seria prioritaire
        } finally {//si el objeto no se implementa villeAvecException2, porque tiene nbr negatif y nos da una exception
            //para mas adelante poder usar el metodo del objeto, este debe ser creado de todas formas:
            if (villeAvecException2 == null) {//si esta vacio
                villeAvecException2 = new Ville();//llenamos la variable objeto con un un new ville(), por defecto
            }
        }
        System.out.println(villeAvecException2.decrisToi());//y asi esta instruccion funciona el objeto no es nulo
    }                                                       //y se pueden entonces usar los metodos

    // Pas besoin de capturer une exception sur l'instanciation de notre objet ici : le code n'est considéré
    // comme dangereux que sur le constructeur avec paramètres. y aqui no tiene parametres, (variables estas por defecto)

    /*
    Et si on exécute le même code que précédemment, on peut voir le nouveau message de notre exception s'afficher.

    Ce n'est pas mal, avouez-le ! Sachez également que l'objet passé en paramètre de la clause catch a des méthodes
    héritées de la classe Exception : vous pouvez les utiliser si vous le voulez et surtout, si vous en avez l'utilité.
    Nous utiliserons certaines de ces méthodes dans les prochains chapitres. Je vais vous faire peur : ici, nous avons
    capturé une exception, mais nous pouvons en capturer plusieurs !

    Si vous mettez un nom de ville de moins de 3 caractères et un nombre d'habitants négatif, c'est l'exception
    du nombre d'habitants qui sera levée en premier, et pour cause : il s'agit de la première condition dans
    notre constructeur. Lorsque plusieurs exceptions sont gérées par une portion de code, pensez bien à mettre
    les blocs catch dans un ordre pertinent.
    */


}
