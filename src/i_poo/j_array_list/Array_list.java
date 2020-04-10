package i_poo.j_array_list;

import java.util.ArrayList;

public class Array_list {
    public static void main(String[] args) {

        //Array_list OU Tableau dinamique on pourra modifier la taille au fur et à mesure de l'execution de se programme
        //un tableau normal a une taille fixe int []=new int[2]; je ne peux pas modifier la taille de mon tableau

        Integer ein = 1;
        Integer zwei = 2;
        //type
        ArrayList<Integer> tab = new ArrayList<Integer>();//il faut l'importer  il se trouve dans util
        //Array_list est surtout utilisé pour le type evolué (String por ex) objetos quoi

        //--------------------------------------------------------------------------------------------------------------
        //                             METHODES CLASSIQUES DE ArrayList
        //--------------------------------------------------------------------------------------------------------------
        tab.add(ein);//.add()  para agregar   0
        tab.add(zwei);//.add()  para agregar  1
        tab.add(3);//.add()  para agregar     2

        tab.set(1, ein);//.set()  para modificar un indice, seleccionamos el indice e insertamos un objeto diferente .set(index,String e)
        //O tab.set(1,5); ponemos de frente el numero en el indice 1 se pondria 5  set solo modifica cuando ya esta ocupado el indice (con add)

        //--------------------------------------------------------------------------------------------------------------
        //                                   RECUPERATION DES DONNEES
        //--------------------------------------------------------------------------------------------------------------
        System.out.println(tab.get(0));//ponemos el indice y nos devuelve el contenido de este indice
        System.out.println(tab.get(1));//ponemos el indice y nos devuelve el contenido de este indice
        System.out.println(tab.get(2));//ponemos el indice y nos devuelve el contenido de este indice

        System.out.println("Tamanio : " + tab.size());//au lieu de length on utilise la methode .size() cuando ta vacio da 0

        //--------------------------------------------------------------------------------------------------------------
        //                                  IMPRESSION DE TOUS LES ELEMENTS
        //--------------------------------------------------------------------------------------------------------------

        for (int i = 0; i < tab.size(); i++) {
            System.out.print(tab.get(i) + " ");
        }

        System.out.println();
        //--------------------------------------------------------------------------------------------------------------
        //                                            CONTAINS  permite saber si el tab contiene un determinado elemento
        //--------------------------------------------------------------------------------------------------------------

        if (tab.contains(3)) {    //nombre del objeto en parametro  (object o) return un boolean true o false
            System.out.println("SI ESTA EN EL TAB EN EL INDICE " + tab.indexOf(3));

        } else {
            System.out.println("NO ESTA EN EL TAB");
        }

        //--------------------------------------------------------------------------------------------------------------
        //                                             IndexOf  permite tambien buscar el indice de un element
        //--------------------------------------------------------------------------------------------------------------

        System.out.println(tab.indexOf(3));    //indice del objeto  (object o)     return un int del indice
        //ESTO NOS DA EL INDICE DEL ELEMENTO
        //SI EL ELEMENTO SE ENCUENTRA REPETIDO EN VARIOS INDICES, ESTA FUNCION SOLO NOS DA EL INDICE DEL PRIMERO que ENCUENTRA
        //SI EL OBJETO PEDIDO NO ESTA EN EL TAB ENTONCES NOS RETURN UN -1

        //--------------------------------------------------------------------------------------------------------------
        //                            METODHE POUR SUPPRIMER UN ELEMENT SITUE DANS UN INDICE DETERMINE
        //--------------------------------------------------------------------------------------------------------------

        tab.remove(0);   //podemos especificar el nombre del objeto (ein) o el indice
        //borra el elemento del indice 0 que es en este caso 1
        for (int i = 0; i < tab.size(); i++) {
            System.out.print(tab.get(i) + " ");
        }
        System.out.println();

        //AL BORRAR UN ELEMENTO (contrariamente a un arreglo normal que queria con 0 ) EL OBJETO BORRADO DESAPARECE
        //Y LOS NUMEROS SE CORREN PARA LLENAR EL VACIO
        //1 2 3 5   borro el 2 lo que daria
        //1 3 5   ahora 1 estaria en el indice 0     3 en el 1   y 5 en el 2

        //--------------------------------------------------------------------------------------------------------------
        //                            METODHE POUR NETTOYER OU VIDER TOTALEMENT LE TABLEAU
        //--------------------------------------------------------------------------------------------------------------

        tab.clear();//borra los elementos del tab

        if (tab.isEmpty()) {//METHODO PARA SABER SI EL TAB TA VACIO
            System.out.println("El tab esta ahora vacio");
        } else {
            System.out.println("El tab esta lleno");
        }
        System.out.println("Tamanio : " + tab.size());
    }
    //Wrapper il s'agit d'un objet qui va encapsuler un type primitif, grâce à ca on peut les utiliser dans les ArrayList
    //et utiliser des methodes vu qu'il s'agit des objets
    //INCONVENIENTS, leur taille est plus grande en memoire (plus d'octets)

    //ENVELOPPEUR (WRAPPER)     |   TYPE PRIMITIF

    //Character                     char
    //Byte                          byte
    //Short                         short
    //Integer                       int
    //Long                          long
    //Float                         float
    //Double                        double
    //Boolean                       boolean
}
