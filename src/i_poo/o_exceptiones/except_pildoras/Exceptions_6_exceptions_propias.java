package i_poo.o_exceptiones.except_pildoras;

import javax.swing.*;

public class Exceptions_6_exceptions_propias {
    //CREACION DE EXCEPTIONES PROPIAS y PORQUE SURGE LA NECESIDAD DE CREAR NUESTRAS PROPIAS EXCEPTIONS
    public static void main(String[] args) {//MAIN
        String mail = JOptionPane.showInputDialog("Introduce mail");

        try {
            examinaMail(mail);
        } catch (Exception e) {
            System.out.println("La direccion de email no es correcta");
            e.printStackTrace();//METODO MUY USADO para orientar a un programador diferente sobre la exception
            System.out.println(e.getMessage());
        }                       //IMPRIME LA PILA DE LLAMADA (imprime el mensaje de error)
    }                           //tendremos el mensaje del catch y luego tambien poo.o_exceptiones.except_pildoras.Logitud_mail_erronea:El mail es muy corto

    //d'ou l'importance de créer un constructeur par defaut et un avec parametres
    //afin de mieux orienter un autre programmeur..tenemos mas pistas..esto ayuda mucho al programador
    //METHODO
    public static void examinaMail(String mail) throws Logitud_mail_erronea {
        int arroba = 0;
        boolean punto = false;

        if (mail.length() <= 3) {          //este mensaje no seria necesario si en el main2 capturamos el error
            throw new Logitud_mail_erronea("El mail es muy corto");//exception propia decidimos que el error se produsca aqui
        } else {                             //mi clase propia qui hereda de Exception tiene 2 constructores
            //nosotros elegimos, si elegimos el primero, podemos personalizar un mensaje
            for (int i = 0; i < mail.length(); i++) { //al interior de los parentesis
                if (mail.charAt(i) == '.') {
                    punto = true;
                }
                if (mail.charAt(i) == '@') {
                    arroba++;
                }
            }

            if (arroba == 1 && punto) {
                System.out.println("Es correctoo");
            } else {
                System.out.println("Incorrecto");
            }
        }
    }
}
/*
ni ArrayIndexOutOfBonds que vimos en el ejemplo anterior ni EOFException se adaptan exactamente a nuestro programa
(on avait bricolé ) ya que el tipo de exception que poniamos no correspondia en realidad al tipo de error que podiamos
tener. EOFException sirve para leer ficheros de texto y que si por ejemplo tenemos un fichero de 10 lineas y solo hay 3
entonces se produce una exception EOFException. y el error de mail.length<3  no corresponde con el tipo de error
que pusimos en ese punto con throw

En la API DE JAVA NO TENIAMOS O CONOCEMOS UNA EXCEPTION QUE SE ADAPTE AL TIPO DE ERROR QUE PODRIA DARNOS EL mail.length<3
del ejercicio anterior.

Es en estas circunstancias que uno debe crear sus propias excepciones PARA QUE EL PROGRAMA TENGA SENTIDO.
ya que si alguien lee el codigo y ve esto EOFException va a pensar que estamos trabajando con ficheros externos
que es pa lo que sirve esta exception.  lo cual "NO ES EL CASO"

LA EXCEPTION QUE LANZA EL METODO DEBE CONCORDAR CON EL TIPO DE ERROR( exception)
osea el throw y throws deben ser iguales. Y como no tengo en la API una exception que se adapte a este tipo de error
pues nos vemos obligados a crear nuestra propia exception!!!!

COMO HACERR???

Crear una clase que herede de Exception , ya que recordemos que esta clase gestiona los IOEXxception y RuntimeException
Exception o IOException nos obligaria a implementar la exception mientras que RuntimeException seria opcional
*/

//CREATION DE NUESTRA PROPIA CLASE: que herede de Exception

//una vez creada la clase, lo suyo es que estas clases de exceptiones
//propias tengas 2 constructores: uno por default y otro con parametros
//El lo recomendado aunque no es necesario que tengas 2 constructores
class Logitud_mail_erronea extends Exception {//mas general que IOEXCEPTION

    //constructor default
    public Logitud_mail_erronea() {
    }

    //constructor 2 que pida string()
    public Logitud_mail_erronea(String msj_error) {//Exception in thread "main2" poo.o_exceptiones.except_pildoras.Logitud_mail_erronea: El mail es muy corto
        super(msj_error);//llamamos al constructor del padre
    }
}//ES RECOMENDADO TENER 2 CONSTRUCTORES CUANDO CREAMOS UNA CLASS PROPIA de EXCEPTION, sin parametros y con String
//Luego vamos al metodo y lanzamos el tipo de la classe de exception
//y luego le decimos donde lanzarla
