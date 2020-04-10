package i_poo.t_ReferencesDeMethodes.MetodosPorReferencia;


import java.util.Arrays;
import java.util.List;

public class principal {
    public static void main(String[] args) {//devuelve una lista de tipo List
        List<Usuario> usuarios = Arrays.asList(
                new Usuario("Codi 1"),
                new Usuario("Codi 2"));
        //   ou juste         usuario     sin Usuario ni parentesis
        //  usuarios.forEach( usuario -> System.out.println(usuario.getNombre()));     forEach devuelve un metodo
        usuarios.forEach((Usuario usuario) -> System.out.println(usuario.getNombre()));

      /* metodo de consumer que es lo que va como parametro en el forEach
        default Consumer<T> andThen(Consumer<? super T> after) {
            Objects.requireNonNull(after);
            return (T t) -> { accept(t); after.accept(t); };
        } */
        System.out.println("******");

        //**************************************************************************************************************
        //                                          Metodo estatico
        //**************************************************************************************************************
        usuarios.forEach(uno::mostrarNombre);
        System.out.println("******");
        //**************************************************************************************************************
        //                          Metodo de instancia de clase  (metodo de objeto)
        //**************************************************************************************************************
        usuarios.forEach(dos::mostrarNombre);
        System.out.println("******");
        //**************************************************************************************************************
        //                                    Referencia a un metodo de un objeto arbitrario
        //esto funciona porque es un metodo que imprime nombre this.nombre osea un nombre que pertenece a la misma clase Usuario
        //**************************************************************************************************************
        usuarios.forEach(Usuario::imprimirNombre);
        System.out.println("******");
        //**************************************************************************************************************
        //                                       Referencia a constructor
        //**************************************************************************************************************
        //Usuario porque el metodo de la interfaceCF devuelve un tipo Usuario
        //   Usuario crearUsuario(String nombre);
        InterfaceCF cf = Usuario::new; //aqui decimos que hara el metodo interno de InterfaceCF, en este caso crear objeto tipo Usuario
        Usuario u1 = cf.crearUsuario("Codi 1");
        Usuario u2 = cf.crearUsuario("Codi 2");
        Usuario u3 = cf.crearUsuario("Codi 3");

        System.out.println(u1.getNombre());
        System.out.println(u2.getNombre());
        System.out.println(u3.getNombre());

    }
}
