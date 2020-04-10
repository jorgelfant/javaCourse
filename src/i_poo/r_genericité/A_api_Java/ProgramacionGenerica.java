package i_poo.r_genericité.A_api_Java;

public class ProgramacionGenerica {
    public static void main(String[] args) {
        //PROGRAMACION GENERICA
        //Que es y porque es importante?

        /*
        Consiste en escribir un codigo de programacion que podamos usar para objetos de diversos tipos
        **********************************************************
                                        REUTILIZACION DEL CODIGO
                                     ******************************************************************

        con esto evitamos tener que crear una clase diferente para cada tipo de objeto que vayamos a manejar
        con un ArrayList por ejemplo podemos gestionar objetos de tupo String o crear otro ArrayList
        y gestionar objetos de tipo File, esto modificando el parametro de tipo que va entre los corchetes
        ArrayList<Clase> myclass=new ArrayList<>();

        Asi tenemos una unica clase de java ArrayList por ejemplo que podemos usar con diferentes tipos de clases
        String, File Empleado etc

        Se llama generica porque hacemos uso de una clase que maneja objetos en general (clases en general)

        sirve pa manejar objetos en general

************************************************************************************************************************
                                     Podemos hacer lo mismo sin la programacion generica??
************************************************************************************************************************

SI , utilizando la herencia podemos crear una unica clase que sea capable de manejar objetos de diferente tipo

en java tenemos por ejemplo la super clase cosmica Object, de la que heredan todas las demas.

Sin embargo, usarlo de esta forma trae diversons inconvenientes

                                                 *****************
                                                 *    Object     *
                                                 *****************
                                                         |
                                                  INCONVENIENTES

                               1) Uso continuo del casting,  dificil de leer

                               2) Compilacion del codigo, mucho casting complica el codigo

                               3) No posibilidad de comprobacion de errores en tiempo de compilacion
                                  cuando trabajamos de esta manera, es decir que cuando creamos con
                                  la herencia na clase que controle toodo tipo de objetos, pues los
                                  errores van a verse en tiempo de ejecucion es decir al ejecutar el codigo
                                  y no en tiempo de compilacion que es cuando escribimos el codigo
                                  estariamos obligador a controlar estos errores con exceptiones

************************************************************************************************************************
                                   VENTAJAS DE USAR LA PROGRAMACION GENERICA
************************************************************************************************************************
                               1) Mayor sencillez en el codigo de programacion

                               2) Reutilizacion del codigo en numeros escenarios

                               3) comprobacion de errores en tiempo de compilacion

  siempre es mas sencillo que salga un error en tiempo de compilacion que sera subrayado en rojo mientras estamos
  escribiendo que tener ese error en tiempo de ejecucion.

  La version generica de JAVA aparacio a partir de la version 5.0, esta no existia antes

  ArrayList no existia antes por ejemplo.

  Vamos al escenario en el que programamos en java antes de la version 5.0 y que tenemos que crear nosotros
  esta clase ArrayList que pueda manera toodo tipo de objetos.

  Asi veremos los inconvenientes de trabajar de esa manera antigua.









        */



    }
}
