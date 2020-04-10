package i_poo.o_exceptiones.except_openclassroom;

public class Except_1 {
    public static void main(String[] args) {
        // Si on crée un nouveau projet avec seulement la classe main2 on met le code suivant :
        int j = 20, i = 0;
        try {
            System.out.println(j / i);//aislamos la parte susceptible de provocar el error
        } catch (ArithmeticException e) {//e objeto error de la clase ArithmeticException
            System.out.println("No se puede dividir / 0");
            System.out.println("Error de  tipo: " + e.getMessage());//PARA DETALLES sobre naturalz
            System.out.println("Error de  class: " + e.getClass().getName());//PARA DETALLES
        }
        System.out.println("coucou toi !");
    }
}
