package i_poo.v_design_patterns.B_Modelos_de_Structuration.VIII_Pattern_decorator.ejemplo_1;

public class Main{
  public static void main(String[] args){
    Patisserie pat = new CoucheChocolat(new CoucheCaramel(new CoucheBiscuit(new CoucheChocolat(new Gateau()))));
    //CoucheChocolat hola= new CoucheChocolat(new CoucheBiscuit(new CoucheChocolat(new Gateau())));
    System.out.println(pat.preparer());
  }
}
/*
Je suis un gâteau et je suis constitué des éléments suivants.
	- une couche de chocolat.
	- une couche de biscuit.
	- une couche de caramel.
	- une couche de chocolat.
*/

/*LO QUE TA ENTRE PARENTESIS en PARAMETRO SE EJECUTA PRIMERO

J'ai agrémenté l'exemple d'une couche de biscuit, mais je pense que tout cela est assez représentatif de la façon
dont fonctionnent des flux d'entrée/sortie en Java. Vous devriez réussir à saisir tout cela sans souci. Le fait est
que vous commencez maintenant à avoir en main des outils intéressants pour programmer, et c'est sans compter les
outils du langage : vous venez de mettre votre deuxième pattern de conception dans votre mallette du programmeur.

Vous avez pu voir que l'invocation des méthodes se faisait en allant jusqu'au dernier élément pour remonter ensuite
la pile d'invocations. Pour inverser ce fonctionnement, il vous suffit d'inverser les appels dans la méthodepreparer():
affecter d'abord le nom de la couche et ensuite le nom du décorateur.

      .Les classes traitant des entrées/sorties se trouvent dans le packagejava.io.

      .Les classes que nous avons étudiées dans ce chapitre sont héritées des classes suivantes :

            .InputStream, pour les classes gérant les flux d'entrée ;

            .OutputStream, pour les classes gérant les flux de sortie.

      .La façon dont on travaille avec des flux doit respecter la logique suivante :

             .ouverture de flux ;

             .lecture/écriture de flux ;

             .fermeture de flux.

      .La gestion des flux peut engendrer la levée d'exceptions :FileNotFoundException,IOExceptionetc.

      .L'action de sauvegarder des objets s'appelle la « sérialisation ».

      .Pour qu'un objet soit sérialisable, il doit implémenter l'interfaceSerializable.

      .Si un objet sérialisable comporte un objet d'instance non sérialisable, une exception sera levée lorsque vous
       voudrez sauvegarder votre objet.

      .L'une des solutions consiste à rendre l'objet d'instance sérialisable, l'autre à le déclarertransientafin qu'il
       soit ignoré à la sérialisation.

      .L'utilisation de buffers permet une nette amélioration des performances en lecture et en écriture de fichiers.

      .Afin de pouvoir ajouter des fonctionnalités aux objets gérant les flux, Java utilise le pattern « decorator ».

      .Ce pattern permet d'encapsuler une fonctionnalité et de l'invoquer de façon récursive sur les objets étant
       composés de décorateurs.


*/
