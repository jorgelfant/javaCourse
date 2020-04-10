package i_poo.n_enumerations_opClassR;

public enum Langage {
    //Une énumération se déclare comme une classe, mais en remplaçant le mot-clé class par enum.
    //Autre différence : les énumérations héritent de la classe java.lang.Enum.
//----------------------------------------------------------------------------------------------------------------------
    //Voici à quoi ressemble une énumération : PRIMERA VERSION
    /*
    JAVA,
    C,
    CPLUS,
    PHP;
     */
    //OBJETOS DE TIPO Langage ( de enum )   enum remplaza a class

//Rien de difficile ! Avec cela, vous obtenez une structure de données qui encapsule quatre « objets ».
// En fait, c'est comme si vous aviez un objet JAVA, un objet C, un objet CPlus et un objet PHP partageant
// tous les mêmes méthodes issues de la classe java.lang.Object comme n'importe quel autre objet : equals(), toString(), etc.

//Vous constatez aussi qu'il n'y a pas de déclaration de portée, ni de type : les énumérations s'utilisent
// comme des variables statiques déclarées public : on écrira par exemple Langage.JAVA. De plus, vous pouvez
// recourir à la méthode values() retournant la liste des déclarations de l'énumération dont vous trouverez
// un exemple à la figure suivante et sur son code : VER clase Libro_main

    //----------------------------------------------------------------------------------------------------------------------
    //Voici à quoi ressemble une énumération : SEGUNDA VERSION
    //Utilisation d'un constructeur avec une enum
    //SE PUEDEN TENER VARIOS PARAMETROS
    JAVA("Langage Java", "Eclipse"),
    C("Langage C", "Code Block"),
    CPlus("Langage C++", "Visual Studio"),
    PHP("Langage PHP", "PS Pad");

    private String name = "";
    private String editor = "";

    //Constructor
    Langage(String name, String editor) {
        this.name = name;
        this.editor = editor;
    }

    public void getEditor() {
        System.out.println("Editeur : " + editor);
    }
    //toString a manera de getter
    public String toString() {
        return name;
    }
    //IMPRIMIRIA EN EL for del MAIN
    /*
    J'aime le : Langage Java
    Langage C
    Langage C++
    Langage PHP
    */
}