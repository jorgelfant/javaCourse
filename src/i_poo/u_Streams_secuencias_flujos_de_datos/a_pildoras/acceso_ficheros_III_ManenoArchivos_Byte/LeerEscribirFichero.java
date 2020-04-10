package i_poo.u_Streams_secuencias_flujos_de_datos.a_pildoras.acceso_ficheros_III_ManenoArchivos_Byte;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class LeerEscribirFichero {
    private int[] almacen;
   //metodo lee() nos da la fuente de un archivo y almacena sus sinformacion (bytes) en un tab
    public void lee() {
        try {
            //File ruta = new File("C:/Users/Jorge/Desktop/Test/plano.jpg"); y esto iria entre () del FileInputStream
            FileInputStream lectura = new FileInputStream("C:/Users/Jorge/Desktop/Test/plano.jpg");
            BufferedInputStream miBuffer = new BufferedInputStream(lectura);//para accelerar
            int tamanio = miBuffer.available();//o defrente con el objeto lectura....available() metodo que da el tamanio
            //long count=0;  un iterador pa saber el numero de bytes o

            //Otra technica
            //getChannel() Returns the unique FileChannel object associated with this file input stream.
            //long tamanio = lectura.getChannel().size();//Usamos long porque es lo que devuelve el metodo size()
            almacen = new int[tamanio];
            System.out.println("La talla es " + tamanio);//nos permite conocer el tamanio del objeto imagen antes d tratarlo

            for (int i = 0; i < tamanio; i++) {
                almacen[i] = miBuffer.read();//almacenamos cada byte en un tab para poder luego escribir
                System.out.println(almacen[i]);
            }
            lectura.close();
        } catch (IOException e) {
            System.out.println("No se encontro la imagen");
            //e.printStackTrace();
        }
        //en el parametro de escribe podriamos poner el tab almacen y luego copiar el metodo aqui , que recuperaria
        //el tab almacen[] lleno y lo pondria en otro lugar bajo otro nombre
        //con esto podriamos tb deaclarar el tab [] en el interior de este metodo y no afuera como es el caso
        // public void escribe(almacen[]) asi solo con llamar lee() este haria las 2 cosas en una  OPCIONAL
    }
    //******************************************************************************************************************
    //metodo escribe sirve para recuperar la informacion ( en forma de arreglo []) del objeto y seleccionamos una nueva
    //ruta para copiar esta informacion
    public void escribe() {
        try {
            FileOutputStream escritura = new FileOutputStream("C:/Users/Jorge/Desktop/Test/plano_copia.jpg");
            for (int i = 0; i < almacen.length; i++) {
                escritura.write(almacen[i]);
            }
            escritura.close();
        } catch (IOException e) {
            System.out.println("Hay un error");
        }
    }
    //******************************************************************************************************************
    //nos permite leer la informacion de un archivo y luego copiarla en otro lugar bajo otro nombre en un solo metodo
    public void leeEscribe() {
        try {
            FileInputStream entrada = new FileInputStream("C:/Users/Jorge/Desktop/Test/plano.jpg");
            FileOutputStream salida = new FileOutputStream("C:/Users/Jorge/Desktop/Test/plano_copiaII.jpg");

            int num;
            while ((num = entrada.read()) != -1) {
                salida.write(num);
            }
            entrada.close();
            salida.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}


