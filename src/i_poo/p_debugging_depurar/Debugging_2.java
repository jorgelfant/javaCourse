package i_poo.p_debugging_depurar;

public class Debugging_2 {
    public static void main(String[] args) {
        Suma operacion1=new Suma();
        Resta operacion2=new Resta();
        Multiplicacion operacion3=new Multiplicacion();
        Division operacion4=new Division();

        System.out.println(operacion1.calculo(7,8));
        System.out.println(operacion2.calculo(7,8));
        System.out.println(operacion3.calculo(7,8));//cuando llega aqui hace de nuevo una suma
        System.out.println(operacion4.calculo(7,8));
        //mis clases tienen el mismo metodo y como hacen cosas parecidad y he usado copy paste de una clase a otra
        //pa copiar el metodo cuando voy por ejemplo a multiplicacion puede pasar que me olvide de modificar el metodo
        //y en vez de hacer una multiplicacion pues se esta haciendo una suma return a + b,
        //esto ocasiona que en la clase principal

        //como es un programa sencillo encontrariamos rapidamente donde esta el fallo
        //pero imaginemos que se trata de un programa con muchas lineas de codigo y muchos ficheros
        //como depurar un programa que tiene varios ficheros???
        //Aqui es donde entra en juego el boton step into o tecla f5 (en eclipse)

        //lo primero como siempre es introducir un punto de interrupcion un breakpoint
        //en el main2 por ejemplo hacemos un break point en el primer sout y luego cliqueamos en debugger

        //empezamos aqui Suma operacion1=new Suma(); y luego bajamos manualmento una a una hasta multiplicacions
        //que es lo que nos interesa
        //y con step into la flecha amarilla hace abajo lo que hacemos es entrar al fichero que estamos llamando (f7)
        //y ademas seniala la linea de lo que estamos returnando mostrandonos en el fichero, el valor que hemos dado a los argumentos
        //con step out salimos de ese fichero y volvemos al main2 donde nos quedamos
        //asi me permite entrar rapidamente al fichero en cuestion y me muestra lo que se esta retornando  y me permite
        //entonces darme cuenta del error que he cometido
        //se ven al lado de los parametros sus valores y si dejo el puntero sobre el resultado muestra cuanto es esto
    }
}
