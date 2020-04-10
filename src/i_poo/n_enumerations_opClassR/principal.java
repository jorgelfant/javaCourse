package i_poo.n_enumerations_opClassR;

public class principal {
    // OPTION CON ENUM  : MODIFICAMOS ESTE METODO AFIN DE UTILIZAR AHORA LOS ENUM
    //estamos obligados a usar los metodos en la clase del main2 (fuera del main2)
    public void faites(Langage param) {
        if (param.equals(Langage.JAVA)) {
            System.out.println("Faites à la façon n°1");
        } else {
            System.out.println("Faites à la façon n°2");
        }
    }

    //******************************************************************************************************************
    // IMPOSSIBLE DE CREER DES OBJETS AVEC UN TYPE ENUM EN DEHORS DE CET enum  Langage hola=new Langage(), ne marchera pas
    // Les données formant notre enum (Langage)  sont directamente construidos en el enum
    // el constructor es private, no se puede acceder desde afuera!! asi los valores dentro del enum no se pueden modificar
    //ils sont directement construits dedans
    //******************************************************************************************************************
    public static void main(String[] args) {
        //OPCION CON ENUM EN EL MAIN apenas intengo poner un valor no comprendido en el enum Langage me da error
        //COMO no se pueden construir objetos con un type ENUM estamos obligados a construir en el main2 los objetos
        //con el nombre de la clase que engloba el main2 en este caso Libro_main
        principal ae = new principal();
        ae.faites(Langage.JAVA);//valido enum
        ae.faites(Langage.PHP);//valido enum
        // ae.fait(4);//int no valido si lo borramos todoo funciona bien, sino habra un error , exception

        //puisque la méthode attend un certain type d'argument, et que vous lui en passez un autre :
        // supprimez la dernière ligne, le code fonctionnera très bien.
        //AHORA EL METODO POR EJEMPLO SOLO ACCEPTA ARGUMENTOS DE TIPO Langage, que hemos declarado en el enum

        //Maintenant, nous avons un mécanisme protégé : seuls des arguments valides peuvent être passés en paramètres
        //de la méthode.
    //------------------------------------------------------------------------------------------------------------------
        System.out.println();

        //for esto nos permite obtener los valores de nuestros objetos de tipo Enum (langage)
        for (Langage indice : Langage.values()) {//al utiliser parametros en los objetos, esto me imprimera lo que hay en ellos
            if (indice.equals(Langage.JAVA)) {   //y ya no simplemente el nombre del objeto  JAVA( "Langage Java")
                System.out.println("J'aime le : " + indice);
            } else {
                System.out.println(indice);
            }
        }//Langage.valueOf(String) para obtener el valor del objeto  Langage.valueOf("JAVA") dara "Langage Java"
        //System.out.println(Langage.valueOf(Langage.class,"JAVA")); dara lo mismo  "Langage Java"
    //------------------------------------------------------------------------------------------------------------------
        System.out.println();

        Langage l1 = Langage.JAVA;
        Langage l2 = Langage.PHP;

        l1.getEditor(); //Ou Langage.JAVA.getEditor();
        l2.getEditor(); //Ou Langage.PHP.getEditor();
    }

//Utilisation d'une enum PRIMERA VERSION
    //IMPRIMIRIA:
    /*
    J'aime le : JAVA
    C
    CPLUS
    PHP          */

    //Vous disposez ainsi d'un petit aperçu de l'utilisation des énumérations. Vous aurez pu constater
    // que la méthode toString() retourne le nom de l'objet défini dans l'énumération.

    /*------------------------------------------------------------------------------------------------------------------
    À présent, étoffons tout cela en redéfinissant justement cette méthode. Pour ce faire, nous allons ajouter un
    paramètre dans notre énumération, un constructeur et ladite méthode redéfinie. Voici notre nouvelle énumération
    (résultat en figure suivante) :  VER Langage
     -----------------------------------------------------------------------------------------------------------------*/

    //Utilisation d'une enum SEGUNDA VERSION con constructor y parametros, imprime lo que hay en parametros
    /*
    J'aime le : Langage Java
    Langage C
    Langage C++
    Langage PHP
    */

    //------------------------------------------------------------------------------------------------------------------
    /*
    Vous voyez ce que je vous disais : les énumérations ne sont pas très difficiles à utiliser et nos programmes y
    gagnent en rigueur et en clarté.

        .Une énumération est une classe contenant une liste de sous-objets.
        .
        .Une énumération se construit grâce au mot clé enum.
        .
        .Les enum héritent de la classe java.lang.Enum.
        .
        .Chaque élément d'une énumération est un objet à part entière.
        .
        .Vous pouvez compléter les comportements des objets d'une énumération en ajoutant des méthodes.
    */
    //UN OBJETO TIENE POR DEFECTO LIGADO EL toString() cuando se imprime solo
    //JAVA.toString()  es igual que JAVA    si redefinimos aqui el toString para que return name;
    //entonces asi no pongamos toString() este estara sobreentendido y para Java, imprimira "Langage Java", el parametro

    //si no redefinimos el toString(), entonces imprimira JAVA ---->para JAVA("Langage Java", "Eclipse")
    //osea el nombre del objeto y no su valor que esta entre parentesis
}


