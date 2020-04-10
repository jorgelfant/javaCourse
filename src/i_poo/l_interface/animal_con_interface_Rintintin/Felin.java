package i_poo.l_interface.animal_con_interface_Rintintin;

public abstract class Felin extends Animal {

    public void deplacement() {
        System.out.println("Je me déplace en meute");
    }
}
//Una clase qui hereda de una clase abstract debe inicializar los metodos abstractos de la clase madre obligatoriamente
//si este no fuera el caso, habria un error, sauf si:

//  .Una clase puede ser abstract y no contener ningun metodo abstracto esto podria ser util cuando queremos crear
//  crear objetos con sus clases hijas y meterlos en esta clase madre , que elle ne pourra pas créer des objets seule
//  car une classe abstraibte ne peut pas être instancier


//  .Sin embargo una clase que posee al menos un metodo abstracto, debe ser siempre abstracto
//  En nuestro ejemplo Canin y Felin heredan directamente de Animal, en teoria deberian inicializar entonces
//  los 2 metodos abstractos de la clase madre, SIN EMBARGO esta 2 clases van tambien a ser madres y tener subclases

//Sabemos que los Canin y Felin depen tener el metodo deplacement() pero que no se desplazan igual, entonces
// los inicializamos en cada uno y les damos un contenido diferente

//Sin embargo queda un metodo abstracto (de los 2 que tenemos en Animal) que no hemos inicializado, tenemos entonces un error
// en Canin y felin.

//2 SOLUTIONES : 1. una clase puede ser abstracta y no tener clases abstractas
//               2. Una clase que tiene almenos una clase abstracta debe ser declarada abstract

// LAS CLASES HIJAS DE ANIMAL, han inicializado solo uno de los metodos abstract de Animal, estas 2 clases poseen
// sin embargo los 2 ya que heredan de Animal, al no inicializarlo, es como si el estuviera declarado dentro
// (como en Animal) por lo que la declaramos abstract, y al hacer esto, si esta clase tiene hijos, sus clases hijas
//deberan inicializar obligatoriamente el 2do metodo

//en las clases nietas debe ir en consecuencia de manera obligatoria, el metodo abstract crier()
//que es como si heredaramos directamente del abuelo Animal
// ver circulito verde al lado del metodo
