package i_poo.m_clases_internas;

import javax.swing.*;


public class Principale_InnerClass {
    public static void main(String[] args) {
        //Une classe dans une classe (inner class)
        //COMO SU NOMBRE LO INDICA, SE TRATA DE UNA CLASE DENTRO DE OTRA

        /*
        Public class clase1{

            class clase2{
              codigo de la clase2
            }

            codigo de la clase1
        }
        */
        /*--------------------------------------------------------------------------------------------------------------
        *UTILIDAD DE LAS CLASES INTERNAS:

        .PODER ACCEDER A LOS ATRIBUTOS PRIVATE DE UNA CLASE DESDE OTRA CLASE (SETTER GETTER antes)

        .LA CLASE INTERNA (al interior de una clase) PUEDE ACCEDER a los ATRIBUTOS PRIVATE de la CLASE
         QUE LA ENGLOBA como si FUERAN SUS PROPIOS ATRIBUTOS SIN NECESIDAD DE USAR SETTERS y GETTERS

        .ESCONDER ESTA CLASE INTERNA DE OTRAS CLASES QUE ESTEN EN EL MISMO PACKAGE, ES COMO ENCAPSULAR
         UNA CLASE. SI NO QUIERES QUE SE ACCEDA A ESTA CLASE DESDE OTRA CLASE. ESTA ESTARIA ENCAPSULADA.

        .POSIBILIDAD DE CREER CLASES INTERNAS ANONIMAS UTILIZADAS PARA GESTIONAR EVENTS.

        .CUANDO UNA CLASE DEBE ACCEDER A LOS ATRIBUTOS DE OTRA CLASE, PERO UNICAMENTE ESTA DEBE ACCEDER
         A ESTOS ATRIBUTOS, y no otras CLASES.  NO SE NECESITARIAN SETTERS y GETTERS
        --------------------------------------------------------------------------------------------------------------*/
        /*--------------------------------------------------------------------------------------------------------------
                                           Y PORQUE SERIAN NECESARIAS ??
        --------------------------------------------------------------------------------------------------------------*/
        // .PARA ACCEDER a los CAMPOS PRIVATE de una CLASE desde OTRA CLASE
        // .PARA OCULTAR una CLASE de otras CLASSES del mismo PACKAGE
        // .PARA CREAR CLASES "ANONIMAS" , muy UTILES PARA GESTIONAR EVENTOS y RETROLLAMADAS
        // .CUANDO SOLO UNA CLASE DEBE ACCEDER A LOS CAMPOS DE OBJETO DE OTRA CLASE



        //VAMOS A USAR EL EJEMPLO DEL ejercicio Temporisateur
        /*--------------------------------------------------------------------------------------------------------------
        Et on va rajouter une instruction pour qu’en plus d’imprimer l’heure tous les 5 secondes, sonne le kling

        On utilisera la "abstract class Toolkit" espece de pont entre notre système d’exploitation, les ressources
        de ce système et nos programmes en java

        Avec Toolkit on peut par exemple à la resolution qui a notre écran  (3840x2160)

        Ou les ressouces de son du système
        --------------------------------------------------------------------------------------------------------------*/
       /*

        DameHora listener = new DameHora();//se hace un objeto con el constructor par defaut de la interface ( que DameHora implementa)
        //esto solo tiene una classe inicializada propia a la interface ActionListener
        Timer monTemporisador = new Timer(5000, listener);// objeto de tipo Timer  metodo:start();
        monTemporisador.start();
        //cada 5 segundos se ejecuta el metodo del objet de tipo Dame hora : impresion y sonido
        //Et ca sonne en meme temps. On fera le meme exemple avec des classes internes
        JOptionPane.showMessageDialog(null, "Pulsa aceptar para detener");

        System.exit(0);
       */
        /*--------------------------------------------------------------------------------------------------------------
                                         EJEMPLO CLASES INTERNAS , intentaremos hacer algo como el Temporisador
        --------------------------------------------------------------------------------------------------------------*/
        //Ensuite on crée après la classe principale, une autre class
        //On va lui dire l’intervalle et s’il va faire du son ou pas
        //Despues de haber creado la clase Reloj2 venimos aqui
        Reloj miReloj=new Reloj(3000,true);
        //Ensuite on va lui dire de demarrer l’horloge, avec la méthode enMarche
        miReloj.enMarche();
        JOptionPane.showMessageDialog(null, "Appuyer sur accepter pour arrêter");
        System.exit(0);



    }
}
