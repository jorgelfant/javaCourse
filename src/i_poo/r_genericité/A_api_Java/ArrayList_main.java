package i_poo.r_genericité.A_api_Java;

import java.io.File;

public class ArrayList_main {
    public static void main(String[] args) {

        //Hemos creado nuestra propia classe ArrayList
        //hacemos un objeto de tipo ArrayList
        ArrayList archivos = new ArrayList(5);//ya le estamos diciendo que va a tener 4 elementos


        archivos.add("Jorge");//0 le decimos por ejemplo que almacene un objeto de tipo String
        archivos.add("Luis");//1 recordemos que String hereda de Object
        archivos.add("Juan");//2
        archivos.add("Raul");//3

        archivos.add(new File("gestion_pedidos.accdb"));//nos deja agregar un tipo de elemento que no es de
                                                                 //del mismo tipo de clase que los otros y el IDE no marca
                                                                 //error
        String nombrePersona = (String) archivos.get(2);//aqui por ejemplo necesitariamos hacer un cast pa indicar que
        //el elemento es un String puesto que el metodo return un Object

        System.out.println(nombrePersona);


        /*
        //Con File
        archivos.add(new File("gestion_pedidos.accdb"));
        File tic=(File)archivos.get(0);//endriamos que hacer casting pa decir que el objeto es de tpo File
        System.out.println(tic);
        */
        //Por el momento funciona, aunque hay que hacer Casting

        //Imaginemos que despues de haber hecho toodo esto vamos a decirle lo siguiente; que almacene un elemento mas
        //de 4 a 5 y decirle que nos agrege no un objeto de tipo String sino un objeto de tipo file

        //No nos marca error en compilation pero a la hora de compilar esto va a dar error
        //a este ArrayList entonces por herencia le podriamos pasar elementos de diferentes clases
        //esto nos llevaria a hacer castings permanentes

        //Mientras que con el ArrayList de la API DE JAVA ya le definimos como que clase trabajaremos
        //ArrayList<String> miTab=new ArrayList<>();
        //no podriamos meter objetos de tipo File ya que hemos precisado que estos deben ser de clase String

        //Con el ArrayList de la Api nos daria error en compilacion es decir que reconoce el error antes de que
        //ejecutemos el programa

        archivos.imprimir();//imprime toodos los datos



    }
}
