package i_poo.c_empleado_heritage_casting;

public class Principal {
    public static void main(String[] args) {
        //On va créer un objet de la classe Jefe
        Jefe jefeRH = new Jefe("Jorge", 60000, 2010, 3, 25);
        jefeRH.setPrime(3000);//doy prime
        System.out.println(jefeRH.getSalaire());//va utilisar el metodo redefinido

        //ARREGLO MIS EMPLEADOS
        Empleado[] misEmpleados = new Empleado[6];

        misEmpleados[0] = new Empleado("Jorge", 60000, 2010, 3, 5);
        misEmpleados[1] = new Empleado("Maria", 35000, 2015, 5, 2);
        misEmpleados[2] = new Empleado("Carol", 20000, 2013, 7, 3);
        misEmpleados[3] = new Empleado("Claudia", 50000, 2011, 1, 25);
        //On avait dit qu'on pouvait utiliser un objet de la Sous classe tant que le programme attend un objet de la SuperClass
        misEmpleados[4] = jefeRH;
        //on fourni a la super class un objet de la sous classe (fille)  Corivance de variables, jefeRH est un empleado
        misEmpleados[5] = new Jefe("July", 70000, 2001, 1, 5);

        for (Empleado e : misEmpleados) {
            System.out.println(e.getIdObjeto() + " " + e.getSalaire());//llama a getSalaire() de empleado para los primeros 4 y el ultimo el nuevo getSalaire()
        }

        /*
        On a fait les 2 derniers objets de 2 formes differentes,  le 1 car jefeRH car on voulait lui ajouter une prime !
        Le 2 on l’a juste instancié
        Imaginos que pour le 2eme objet chef on veut aussi etablire une prime


        //On pourrait penser que en faisant ceci cela marcherait mais on voit que les methodes de chef n’apparaissent meme pas
          misEmpleados[5].setPrime(200);  misEmpleados[5] ne detecte meme pas les methodes de chef

          esto es sobre todoo porque para que una clase hija utilise sus metodos (reescritos)  como si sucede con salario
          estos tendrian que estar tambien en la classe padre Empleados que es la que conovoca al metodo en nuestro ejemplo..
          lo cual no es el caso con setPrime(int  ...) por ejemplo

          PK on les voit pas ? CAR on fait reference a misEmpleados ( tableau de type Empleado) car le tableau continue
          d’etre de type employe donc je peux pas utiliser la methode setPrime(200)
        */

        //ALTERNATIVE :

        //--------------------------------------------------------------------------------------------------------------
        //FAIRE UNE REFUNDITION ou CASTING pour convertir ce qu’il y a stocké dans une position qu’en principe est
        // de type employe en objet de type chef para poder aplicar los metodos de Jefe como setPrime()  etc
        //--------------------------------------------------------------------------------------------------------------

        //hacemos igual que como hacemos con los numeros primitivos

        //misEmpleados[5] = new Jefe("July", 70000, 2001, 1, 5);
        Jefe convertido=(Jefe)misEmpleados[5];//es como devolver el objeto a donde pertenece dentro de misEmpleados[5] hay un Jefe
        //Jefe convertido2=(Jefe)misEmpleados[0]; esto da error porque en misEmpleados[0] hay un empleado que no siempre es un Jefe
        convertido.setPrime(200);//AHORA SI FUNCIONA OU ((Jefe)misEmpleados[5]).setPrime(200);
        System.out.println(convertido.getSalaire());

        //EN REALIAD ES COMO SI SE DEGRADARA DE UN ESCALON PARA LLEGAR AL HIJO

        //Ce casting on peut le fair grace a la regle de ‘’est un ? »

        //Par contre si on essai de convertir un employe en chef, le code donne error !! car un chef
        //est toujours un employe mais un employe n’est pas tjrs un chef. DESIGN DE L’HERITAGE

        /*
        Un chef est un chef (qui est un employe)

        Un employé n’est pas tjrs un chef
        FAIRE ATTENTION !

        */

    }
}
