package i_poo.p_debugging_depurar;

import javax.swing.*;

public class Debugging_1 {
    public static void main(String[] args) {
        //Debugging, depurar el codigo de nuestro programa, todos los IDE pueden hacer debugging
        //PAra que sirve?
        //Habiamos visto que a la hora de programar podiamos cometer diferentes errores como por ejemplo
        //los errores de syntaxe, aprender a excribir bien  y los errores en tiempos de ejecucion
        //las exceptiones comprobadas y no comprobadas

        //SIN EMBARGO, hay ocasiones en los que uno realiza un programa y sin que hayan errores de syntaxis
        //y sin que el programa lanze exceptions ni que tengamos que controlarlas pues el programa no hace
        //lo que nosotros esperamos !   ENTONCES NOS PREGUNTAMOS PORQUE EL PROGRAMA NO FUNCIONA???

        //No nos queda mas que ponernos manos a la obra y ponernos en busca, no de ese error de sintaxis
        //que probablemente no exista, sini ponernos en busca de ese ERROR LOGICO (como cuando mi String
        //vacio NULL queria compararse a otro String, cuando para que eso funcionara faltaba String hola="";)
        //o sentencia dentro del programa que no esta del toodo correctamente planteada y para ello nos ayuda
        //el debugger (en eclipse Eclipse Debugger --->completo y complejo)

        //-----------------------------------------------------------------------------------------------------------------
        //                                                 EJEMPLO
        //-----------------------------------------------------------------------------------------------------------------
        int elementos = Integer.parseInt(JOptionPane.showInputDialog("Introduce elementos de la matriz"));
        int[] num_aleat = new int[elementos];
        //rellenamos un tab con numeros aleatorios
        for (int i = 0; i < num_aleat.length; i++) {//solucion el parentesis
            num_aleat[i] = (int) (Math.random() * 100);//sin poner (Math.random() * 100) entre parentesis, da  siempre 0
        }                                            //(int) 0.1 .02 ....1.0  int 0.1=0  y luego *100
        //Impression
        for (int indice : num_aleat) {
            System.out.println(indice);
        }

        //Se pueden introducir los puntos de interruption o pausa que querramos
        //Vemos por ejemplo que no hay error de syntaxis ni exceptions, simplemente el programa no hace lo que nosotros
        //esperamos
        //DEPURAR EL CODIGO es ver linea a linea que esta bien y que esta mal, en programas pequenios se hace al ojo
        //el problema viene cuando es un programa grande de 500 lineas o mas porque no sabemos donde esta el error
        //y es aqui donde entra en accion el debugger
        //Normalmente un programa java se ejecuta sin interruption,  al introducir un punto de interruption lo que
        //hacemos es crear una pausa en el punto del codigo que nosotros querramos para ver como van las cosas hasta ahi
        //Esto no va a solucionar todos los problemas que tengamos en el codigo por nosotros, simplemente es una ayuda
        //Debemos intuir por donde podria estar el error, y nos vamos al primer for ya que es ahi que se generan los
        //numeros aleatorios, pero imaginemos que ni mirando encontramos el error,  en ese caso introduces un punto de
        //interuption en esta linea y el programa se queda pausado ahi cuando llega a esa linea
        //doble click a la izquierda en esa linea que se ponda roja, y luego ejecutamos el debugger escarabajo rojo
        //se resalta en verde la linea donde se queda pausado el programa y el boton de stop de la consola esta activado
        //osea que el programa se encuentra en ejecucion pero pausado
        //en la parte variables sale una felchita a la izquierda de una de las variables, que se puede desplegar
        //como dijimos 5 pues estos son los 5 elementos del array y su valor
        // 0 = 0
        // 1 = 0
        // 2 = 0
        // 3 = 0
        // 4 = 0

        //i=0
        //como hemos hecho pausa al inicio dentro del for entonces significa que solo se ha rellenado el primer indice
        //con 0 y los otros por default son 0
        //mas abajo tenemos la variable i con su valor al momento de hacer pausa

        //hay flechas en la parte superior izquierda
        // STEP OVER                                     STEP INTO                        STEP OUT
        //pa avanzar una linea  mas arriba         retroceder una linea mas abajo

        //si sube la linea y luego bajamos i=0 pasara a i=1 ya que seria la segunda vez que entramos al bucle for
        //Como seria la 2da vez que entramos al for , deberiamos estar leyendo la linea dentro del for por segunda vez
        //i=1  y por lo tanto deberiamos leer el valor que esta en i[1] pero sin embargo vemos que sigue siendo 0
        //si hacemos entonces over et into con las flechitas pues ya ha ejecutado por completo el for
        //y salta al siguiente bucle for

        //con step aout, la linea sube una linea con otro click vuelve a bajar y asi sucesivamente hasta que entro las 5
        //que dijimos al for y ahora como ya acabo se salta al siguiente for que imprime los numeros en consola y termina
        //diciendo que ya no encuentra codigo

        //CONCLUSION: que hemos sacado despues de hacer esto con el debugger es que el codigo entra perfectamente en el for
        //y se ejecuta pero que la linea que esta dentro no me esta generando numero aleatorios

        //claro que aun podemos tener la duda si es este bucle for que rellena, el que falla o es este otro bucle que imprime
        //el que falla

        //hacemos otra hipotesis, ponemos 10 en vez de 5 y luego apoyamos varias veces de nuevo en step over,
        //con la diferencia que esta vez cuando lleguemos a i=5, entramos nosotros manualmente  un valor para probar
        //click derecho en el valor y ponemos setValue ponemos un numero y luego enter y luego seguimos con step over

        //Y VEMOS que al acabar e imprimir si imprimio el 85 que le dijimos en la posicion 5 osea que
        //el error no se encuentra en el for que lee (imprime) ya que si imprime lo que le damos

        // 0 = 0
        // 1 = 0
        // 2 = 0
        // 3 = 0
        // 4 = 0
        // 5 = 85
        // 6 = 0
        // 7 = 0
        // 8 = 0
        // 9 = 0

        //si antes de acabar queremos terminar entonces solo apoyamos en stop y ya , el cuadrado rojo
        //ponemos el parentesis solucionamos el problema y luego repasamos el debugger y vemos que si se rellena como debe

        //entre 2 lineas de codigo (2 interruptiones) tenemos la opcion de avanzar linea a linea de un punto aal otro,
        //o leer toodo el codigo entre una linea y la otra, o hacer solo la primera y despues que el programa se termine
        //la flecha verde resume, lo que hace es pasar de un punto de interruption al otro ejecutando todoo lo que hay
        // entre los 2

        //cuando ejecutamos el debugger de nuevo si en vez de darle a resumen pa que pase de una pausa a la otra ejecutando el codigo
        //entre ambas, si en vez de dar a resumen, le damos a step over entoces avanzara linea por linea

        //TENEMOS TAMBIEN LOS PUNTOS DE INTERRUPTION CONDICIONALES en nuestro panel tenemos la opcion brealpoints
        //en eclipse al lado de variables, en idea las bolitas rojas , este panel nos informa de todos los puntos
        //de interruption que tenemos no solamente en el PROGRAMA ABIERTO sino EN TOODO EL PROJECT
        //el panel breakpoints me informa de esos puntos aunque no este abierto el fichero.

        //QUE POSIBILIDADES TENEMOS CON LOS PUNTOS DE INTERRUPTION??
        //Imaginos que queremos que el programa se detenega en ese punto si se cumple una condicion algo que puede ser
        //muy util en determinados escenarios, imaginemos que no tenemos claro si el array se esta rellenando
        //en este caso lo que podemos hacer es decir que el punto de interruption que tenemos en la linea 30 por ejemplo
        //SE EJECUTE BAJO UNA CONDICION , y esa podria ser que por ejemplo que se ejecute si el array llega al elemento
        //siguiente
        //vamos a breakpoints, seleccionamos el punto de interruption y cliqueamos en condition
        //et introducimos la condicion
        //por ejemplo si le decimos i==5  lo que le estamos diciendo es que haga un punto de interruption
        //si la variable i=5 sino no nos vas a hacer el punto de interruption

        //CON ESTO CONSEGUIMOS es que por ejemplo si creamos un array que va a tener menos de 5 elementos
        //no nos va a hacer ningun punto de interruption
        //si creamos un array de mas de 5 elementos si!
        //es una manera de ver si nuestro array tiene 5 elementos o menos , 5 o el numero que querramos
        //si ejecutamos el debugger y yo digo 3 entonces no habra punto de interruption y el codigo continuara y saltara
        //la linea ya que i nunca llega a 5
        //si doy un numero superior pues ahi si se detiene en la linea del breakpoint
        //si pongo por ejemplo 10 se parara en esa linea y se llenara hasta el indice 4 y el resto de indices tendran por
        //defecto 0

        //y ya si queremos podemos ir ejecutando linea a linea pa seguir ejecutando el resto
        //la condicion podria tb ser num_aleat.length>=5  osea si el tab es de un tamanio 5 o mayor

        //**************************************************************************************************************
        //OTRA COSA QUE NOS PUEDE RESULTAR UTIL A LA HORA DE DEPURAR CODIGO ES el plane EXPRESIONES
        //en eclipse no aparece por defecto, hay que ir a window > show view > expressions
        //en idea seria el cuadradito rosado Evaluate expressions

        //este panel expresiones sirve pa hacer comprobaciones : imaginos que en nuestro array siempre, no sabemos porque
        //en el indice [7] pues pasa algo extranio ( solo lo imaginamos)

        //una expression es codigo de programacion para comprobar que valor puede tomar la posicion de un array
        //una variable, una condicional
        // ejemplo le decimos num_aleat[7]  lo que hacemos es decirle al panel que nos muestre el valor de esta
        //sentencia cuando ocurra en el programa si es que alguna vez ocurre
        //que tb puede ser una manera de comprobar si determinada expresion se ejecuta en nuestro programa o no

        //o obtener el valor
        //puede ser util con una variable, indice o condicional etc, y esto nos va mostrar el valor o resultado
        //asi si esto se ejecuta tendremos su valor, resultado, puede ser muy util




    }
}
