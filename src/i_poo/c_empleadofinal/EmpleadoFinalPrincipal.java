package i_poo.c_empleadofinal;

public class EmpleadoFinalPrincipal {

    public static void main(String[] args) {
      /*  Au moment de mettre les arguments dans les objets,  mon objet 1 dispose automatiquement
          Des variables initiées dans le constructeur : A savoir
          Nom=p_nom ; (paco)
          Section=’’Administration’’ ;

          VEREMOS TAMBIEN STATIC para dar un ID UNICO esto es util cuando tenemos muchos empleados
          y a medida que los creamos queremos que cada uno tenga su propio id

          *Si dans une classe on n’a pas de constructeurs, on est un train d’utiliser un constructeur par défaut
          * dans le cas de la classe Employe, constructeur Employe, qui serait vide, on a pas d’état initial !
          Un string donc valdria nul y un int 0
       */
        EmpleadoFinal empleado1 = new EmpleadoFinal("Luis", 50000, 1998, 3, 5); //CONSTRUCTOR 1
        EmpleadoFinal empleado2 = new EmpleadoFinal("Jorge");//CONSTRUCTOR 2
        EmpleadoFinal empleado3 = new EmpleadoFinal("Maria");//CONSTRUCTOR 2

        //**************************************************************************************************************
        //                                         DATOS OBJETO 1
        //**************************************************************************************************************

        System.out.println(empleado1.getNom());
        empleado1.setDepartamento("RRHH");//cambiamos el departamento
        System.out.println(empleado1.getDepartamento());
        System.out.println(empleado1.getIdObjeto());//esto contiene el valor de la variable statica dentro idStatico
        System.out.println(empleado1.datos());      //asi recuperamos ese valor que va aumentando cada vez que creamos un objeto

        //empleado1.setNom("Luis");

        //**************************************************************************************************************
        //                                         DATOS OBJETO 2
        //**************************************************************************************************************

        // EmpleadoFinal empleado2 = new EmpleadoFinal("MAria");
        //si crearamos el objeto y luego imprimimos sus caracteristicas podemos usar la variable static que
        //aumenta a medida que creamos objetos PERO es muy tedioso crear un objeto y al tok imprimir sus datos
        //SI ALMACENAMOS EL VALOR DE ESTATICO EN UNA VARIABLE DE INSTANCE , la variable statica seguira avanzando pero
        //su valor cada vez que se ejecuta y aumenta sera almacenado en una variable de instance para asociarla al objeto
        //ESTO NO PERMITIRA CRAR VARIOS OBJETOS de una sola VEZ y luego imprimir cuando querramos los datos
        System.out.println(empleado2.getNom());
        System.out.println(empleado2.getDepartamento());
        System.out.println(empleado2.getIdObjeto());
        System.out.println(empleado2.datos());

        //**************************************************************************************************************
        //                                         DATOS OBJETO 3
        //**************************************************************************************************************

        System.out.println(empleado3.getNom());
        System.out.println(empleado3.getDepartamento());
        System.out.println(empleado3.getIdObjeto());
        System.out.println(empleado3.datos());

        //ESTATICA
        System.out.println("Valor de Variable statica (nbre objets creados) = " + EmpleadoFinal.getIdStatico());//avanza cada vez que creamos un objeto


    }
}
