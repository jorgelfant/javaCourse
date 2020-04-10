package i_poo.l_interface.u_java_8_ou_la_revolution_des_interfaces;

public interface Mitose extends Reproducion{

    public static void description(){
        Reproducion.description();//metodo static de la Interface mère que j'implemente
        System.out.println("Redéfinie dans Mitose.java");
    }
    //AVEC default et static on peut mnt initialiser des methodes dans un INTERFACE
    default void reproduire(){
        System.out.println("Je me divise !");
    }
}
