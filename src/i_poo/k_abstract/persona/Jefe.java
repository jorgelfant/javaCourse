package i_poo.k_abstract.persona;

public class Jefe extends Empleado {
    public Jefe(String NOM, double salaire, int annee, int mois, int jour){
        super( NOM,  salaire,  annee,  mois,  jour);
    }

    //EN ESTE CASO Jefe HEREDA DE EMPLEADO, EMPLEADO HEREDAD DE PERSONA (que es abstracta)
    //pero EMPLEADO no es ABSTRACT porque dentro de el no hay metodo declarado como abstract
    //no es porque el hereda de una clase abstract que el (Empleado ) se vuelve abstract, esto solo lo obliga a
    //inicializar o construir el metodo de la classe abstract

    //OSEA QUE CREO que Jefe posederia el metodo de Empleado y aqui podriamos modificarlo, al no heredar directamente
    //de persona y al ser Jefe el nieto, Jefe heredaria de Empleado ( que a su vez hereda de Personne)
    //pero si Personne y Empleado tienen un mismo nombre de un metodo, Jefe va cojer el mas cercano es decir el de su padre
    //que es el mas directo (Empleado)

    //AQUI PODRIA SOBREESCRIBIR EL METODO DE Empleado pero ya seria opcional , en pocas palabras
    //ABSTRACT y POLIMORPHISMO COHABITAN EN ESTE TIPO DE CASOS


    /*
                                                    ***********
                                                      Personne      (ABSTRACT) metodo declarado
                                                    ***********
                                                         |
                                                         |
          /----------------------------------------------/------------------------------------------------\
    ***********                                    ***********                                      ***********
      Empleado (hija)                                 Alumno(hija)                                  Ama de casa(hija)
    ***********                                    ***********                                      ***********
    metodo inicializado                         metodo inicializado                               metodo inicializado
         |
         |
         |
         |
    ***********
        Jefe   (nieta)
    ***********
    metodo de Empleado Sobreescrito(opcional)

    */

}
