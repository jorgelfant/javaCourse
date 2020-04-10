package i_poo.q_collections.collections_II_HashSet;

import java.util.HashSet;
import java.util.Set;

public class CuentasClientes {
    public static void main(String[] args) {
        //COLLECTIONS II Ejemplo de BANCO y clientes: 4 clientes
        //Cada cliente tendra un 1) nombre 2) n° de cuenta  3)Saldo
        //luego Haremos nuestra collection donde almacenaremos estos clientes que vamos a crear

        //1) Crear una clase que construya a estos clientes con sus caracteristicas
        //2) crear una collection
        //3) Agregar los objetos (clientes) a la collection.
        //4) Recorrer la collection.

        //Objetos de la clase cliente
        Cliente cliente1 = new Cliente("Jorge", "00001", 200_000);
        Cliente cliente2 = new Cliente("Carol", "00002", 250_000);
        Cliente cliente3 = new Cliente("Maria", "00003", 400_000);
        Cliente cliente4 = new Cliente("Claudia", "00004", 80_000);
        //mismo cliente si nos basamos en que tiene el mismo numero de cuenta
        //el nombre y el saldo no tienen importancia, ya que eso se puede repetir, el factor determinante es n° cuenta
        Cliente cliente5 = new Cliente("Jorge", "00001", 200_000);

        //Vemos las diapositivas o recurrimos a la API de JAVA para ver en la descripcion de las colecciones
        //cual es la mas adecuada para nuestro ejemplo
        //Tiene sentido que los clientes se repitan? no tiene sentido que aparezca el mismo cliente
        //con la misma cuenta y saldo 2 veces, cada cliente debe aparecer una unica vez.
        //En otro tipo de ejemplo si tendra sentido.

        //Nos hace falta una collection que no permita repeticiones
        //Deberemos preguntarnos si vamos a agregar y borrar muchas veces
        //Si las operaciones van a ser de solo lectura

        //en funcion de estas preguntar escojeremos la collecion adecuada, en nuestro caso puede ser Set
        //por el momento no queremos ordenar, talvez en el futuro si querramos ordenar talvez por salario, etc

        //nos conviene por el momento una interface (collection de tipo set)
        //Cliente vendria a ser un dato de TIPO GENERICO (GENERICITE)

        //rapida, no duplicados, no ordenacion, no acceso aleatorio
        Set<Cliente> clientesBanco = new HashSet<>();//Set al ser una interface no puede ser instanciado, necesitamos
        //pasar por sus clases hijas que la implementan, elegimos una clase
        //el metodo add permite agregar siempre y cuando el elemento no se encuentre ya en la coleccion

        clientesBanco.add(cliente1);//agregamos clientes
        clientesBanco.add(cliente2);
        clientesBanco.add(cliente3);
        clientesBanco.add(cliente4);
        //despues de reescribir equals y hashCode, add se dara cuenta cuando hay elementos repetidos y no los agregara
        clientesBanco.add(cliente5);

        //RECORREMOS COLLECTION con un for , for each
        for (Cliente indice : clientesBanco) {
            System.out.println(" cliente: " + indice.getNombre() + ", N° Cuenta: " + indice.getNumeroCuenta() + ", Saldo: " +
                    indice.getSaldo() + ", hashCode: " + indice.hashCode());
        }

       /*IMPRESION: vemos que no se imprime ordenado, RESULTADO ANTES DE SOBREESCRIBIR LOS METODOS equals et hashCode
            cliente: Maria, N° Cuenta: 00003, Saldo: 400000.0
            cliente: Carol, N° Cuenta: 00002, Saldo: 250000.0
            cliente: Jorge, N° Cuenta: 00001, Saldo: 200000.0
            cliente: Claudia, N° Cuenta: 00004, Saldo: 80000.0
       */
        //REESCRIBIMOS EN LA CLASE los metodos equals() y hashCode() y vemos que al querer meter un 5to cliente
        // que es el mismo que el primero es decir que un cliente ya existente, entonces add() no lo agrega porque ya
        //esta dentro, y no lo quiere repetir (basandose en el numero de cuenta)

        /*Impresion luego de redefinir los metodos, vemos que el doublon no se agrega
            cliente: Maria, N° Cuenta: 00003, Saldo: 400000.0
            cliente: Claudia, N° Cuenta: 00004, Saldo: 80000.0
            cliente: Jorge, N° Cuenta: 00001, Saldo: 200000.0
            cliente: Carol, N° Cuenta: 00002, Saldo: 250000.0
        */
        //si cambiaramos el numero de cuenta si lo agregaria

        /*On peut parcourir ce type de collection avec un objet Iterator ou extraire de cet objet un tableau d'Object :

         HashSet hs = new HashSet();
           hs.add("toto");
           hs.add(12);
           hs.add('d');

           Iterator it = hs.iterator();
           while(it.hasNext())
             System.out.println(it.next());

           System.out.println("\nParcours avec un tableau d'objet");
           System.out.println("-----------------------------------");

           Object[] obj = hs.toArray();
           for(Object o : obj)
             System.out.println(o);
        */
    }
}
