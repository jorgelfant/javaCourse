package i_poo.o_exceptiones.except_openclassroom;

public class Except_2 {
    public static void main(String[] args) {
        try {
            System.out.println(" =>" + (1 / 0));
        } catch (ClassCastException e) {//esta clase de exception no corresponde al que 1/0 nos da que es ArithmeticException
            e.printStackTrace();//esto imprime el mensaje que hay en el parametro del constructor, en este caso par defaullt
            //lo pongamos o no no cambia nada
        } finally {//Asi que en nuestro
            System.out.println("action faite systématiquement");//se imprime esto primero luego vemos el error
        }   //ya que ni el try ni el catch funcionaron al ser ArithmeticException el tipo de exception y no ClassCastException
    }
}
/*
Lorsque vous l'exécutez, vous pouvez constater que, même si nous tentons d'intercepter une ArithmeticException
(celle-ci se déclenche lors d'un problème de cast), grâce à la clause finally, un morceau de code est exécuté
quoi qu'il arrive. Cela est surtout utilisé lorsque vous devez vous assurer d'avoir fermé un fichier, clos votre
connexion à une base de données ou un socket (une connexion réseau). Maintenant que nous avons vu cela, nous
pouvons aller un peu plus loin dans la gestion de nos exceptions.
*/
