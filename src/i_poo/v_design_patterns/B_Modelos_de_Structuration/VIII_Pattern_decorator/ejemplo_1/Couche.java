package i_poo.v_design_patterns.B_Modelos_de_Structuration.VIII_Pattern_decorator.ejemplo_1;

public class Couche extends Patisserie {

  protected Patisserie pat;
  protected String nom;

  public Couche(Patisserie pat){//constructeur
    this.pat=pat;
  }

  public String preparer() {//encadenara las clases al invocar preparer() de un clase , este ira a buscar el metodo preparer()
    String str = pat.preparer();// de el objeto de la clase que hemos puesto como argumento entre parentesis
    return str + nom;           //asi encadenamos los metodos de manera recursiva, un metodo va a buscar al mismo metodo del
                                //elmento que se encuentra en argumento   Couche(Patisserie pat)
  }
}
/*
De izquierda a derecha a derecha se empiezan a ejecutar los metodos de cada objeto pero desde el primero, se quedan extension
al momento de invocar el metodo preparer() que va a buscar el metodo preparer() del elemento que se encuntra en argumento
asi la tension existe porque el metodo preparer() enlaza estos objetos, y comienza a arrojar resultados de derecha a izquierda
y asi liberando la tension, perminitiendo que una vez terminada la invocacion de preparer(à se imprrima luego el nombre.

si poniamos el nombre primero y luego la invocacion del metodo entonces se hubiera impreso primero el nombre y luego se hubiera
hecho la invocacion y enlazamiento de los objetos a travez de preparer()

Vous avez pu voir que l'invocation des méthodes se faisait en allant jusqu'au dernier élément pour remonter ensuite
la pile d'invocations. Pour inverser ce fonctionnement, il vous suffit d'inverser les appels dans la méthodepreparer():
affecter d'abord le nom de la couche et ensuite le nom du décorateur.

                                       public String preparer() {
                                         String str = pat.preparer();
                                         return nom + str ;

                                       }
*/
