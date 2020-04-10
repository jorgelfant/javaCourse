package i_poo.r_genericité.B_clasesGenericas_propias;

public class ClasesGenericasPropias {
    public static void main(String[] args) {
        //CLASES GENERICAS PROPIAS
    /*
    Como crear nuestras propias clases genericas
    empezaremos por crear una clase pareja
*/

        //Probamos nuestra clase generica Pareja
        // el constructor al llamarlo inicia  primero=null que es un objeto de tipo generico T primero
        Pareja<String> una = new Pareja<>();//hemos instanciado nuesta clase generica Pareja que gestionara objetos <String>
        //setPrimero(String nuevoValor): void -Pareja      el ide reconoce cual es el valor de tipo generico que queremos cambiar
        //             T                                   que en este caso es String
        una.setPrimero("Juan"); //primero="Juan"
        System.out.println(una.getPrimero());//para recuperar el valor
//**********************************************************************************************************************
        Persona pers1 = new Persona("Ana");

        Pareja<Persona> dos = new Pareja<>();
        dos.setPrimero(pers1);//modificamos el objeto   pasa de primero=null a  primero=pers1
        System.out.println(dos.getPrimero());//dara la referencia del objeto (en persona creamos un toString) pal nombre
        //asi nos devolvera el nombre que pusimos en el parametro del objeto persona
//**********************************************************************************************************************
        System.out.println();
        System.out.println();

        Pareja<Integer> tres = new Pareja<>();
        tres.add(1);
        tres.add(2);
        tres.add(3);
        tres.add(4);
        tres.add(5);
        tres.add(6);
        tres.add(7);
        tres.add(8);
        tres.add(9);
        tres.add(10);
        tres.add(11);
        tres.add(12);
        tres.add(13);
        tres.add(14);
        tres.add(15);
        tres.add(16);
        tres.add(17);
        tres.add(18);
        tres.add(19);
        tres.add(20);
        tres.add(21);

        System.out.println("Indice : " + tres.get(20));
        //aun asi como puse que mi Tab era Object, acceptara mas cosas que Integer lo cual es un problema
        //solo resolvimos el hecho de poder agregar sin limite
        System.out.println("Tamanio => " + tres.size());

        for (int i = 0; i < tres.size(); i++) {
            System.out.println(tres.get(i));
        }
    }
}
