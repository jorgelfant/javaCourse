package i_poo.k_abstract.persona;

public class Persona_principal {
    public static void main(String[] args) {
        /*
        Empleado empleado1=new Empleado("Jorge",  80000,  2000,  5,  5);
        System.out.println(empleado1.getDebutContrat());
        */
        //OJO : NO SE PUEDE CONSTRUIR CON PERSONA, se puede usar pero como padre (COVARIANCE DE VARIABLES) EST-UN??
        //en el caso d eun arreglo si, el punto es que un objeto de tipo persona no podria usar los metodos etc
        //UN OBJETO PERTENECIENTE A UNA CLASSE ABSTRACTA NO PUEDE SER INICIALIZADO

        // esto no funcionaria por ejemplo
        // Personne person=new Personne("Jorge",  80000,  2000,  5,  5);  daria error
        // Personne person = new Empleado("Jorge", 80000, 2000, 5, 5); esto si funcionaria (EST un???) covariance

        Persona[] personas = new Persona[3];
        personas[0] = new Empleado("Jorge", 80000, 2000, 5, 5);
        personas[1] = new Alumno("Gerardo", "Cocina");
        personas[2] = new Jefe("Luis", 80000, 2000, 5, 5);//hereda metodo de su padre directo (Empleado)

        for (Persona indices : personas) {//cada hijo con su propre metodo se imprime ( el padre posee el metodo) asi que
            System.out.println(indices.donne_description());//puede ser el que ponga el tipo
        }
        //RESULTADO:
        /*
        dame datos, Nom: Jorge 1 debut contrat: Fri May 05 00:00:00 CEST 2000 salaire: 80000.0
        nombre: Gerardo Carrera: Cocina
        dame datos, Nom: Luis 2 debut contrat: Fri May 05 00:00:00 CEST 2000 salaire: 80000.0
        */

        //La diference entre SOBREESCRIBIR (OVERWRITE) une méthode d’une classe dans une autre classe
        // pour qu’elle fonctionne différemment POLYMORPHISME

        //ABSTRACT MARCA EL DESIGN EN LA JERARQUIA DE LA HERENCIA

        /*
        EL OBJETIVO DE UNA CLASE ABSTRACT es marcar el diseno de herencia de las subclasses, osea obligarlas a que
        escriban un determinado metodo.

        De esta forma como programador estamos estableciendo una logica muy importante en el diseno de nuestro programa
        que seria el sgte: OBLIGATORIAMENTE todas las personas deben tener una descripcion!!! no se entiende persona
        que no tenga descripcion.

        solo que esta descripcion obligatoria no return lo mismo en cada clase que herede de persona ( empleado, jefe alumno etc)
        UNA CLASE NORMAL un metodo siempre retorna lo mismo por ejemplo NOM   return NOM es lo mismo pa todas las subclases

       MIENTRAS QUE LA METHODE ABSTRAITE NO RETURN LO MISMO PERO TODAS LAS HIJAS DEBEN TENERLO

       Asi si un programador diferente, pretende crear una clase que herede de mi clase abstracta persona, lo obligo
       a que su clase lleve el metodo donne _description porque no tendria sentido una clase que herede de persona (abstract)
       que no lleve una descripcion ( segun la logica que quiero que tenga mi programa)

       PORQUE NO CREAR UNA CLASE NORMAL CON EL METODO donne_description y herardo??????????????
       --> PORQUE AL HEREDARLO EN UNA SUBCLASE , ESTA TENDRIA EL METODO TAL Y COMO SE DECLARO EN PERSONA
           (QUE YA NO SERIA ABSTRACT) y esto tiene un problema.

       A LO MEJOR ESTE METODO donne_description() no me sirve, porque no es la misma description de un ALUMNO o un
       EMPLEADO QUE LA DE UNA PERSONA.

       incluso nombre, yo podria querer que el alumno sea identificado por id y no por nombre osea que meme si ponemos
       solo el nombre en el metodo donne_descriptin de persona, la cosa comenzaria a complicarse

       IMAGINa que alumno hereda de persona (no abstracta) y que la descripcion no se ajusta exactamente a la descripcion
       como la quiero.

       SE PODRIA SOBREECRIBIR! (POLIMORPHISME) SI!  pero en ese caso sobreescribirlo ya seria algo opciona! por parte
       del programador y yo como disenador del programa quiero que cada subclase de persona tenga su propio metodo
       donne_description. Imagina que el programador que crea una clase que hereda de persona se olvida de SOBREESCRIBIR
       el metodo donne_description????  el se quedaria con el metodo heredado que no se ajusta a lo que la clase necesita



        */

    }
}
