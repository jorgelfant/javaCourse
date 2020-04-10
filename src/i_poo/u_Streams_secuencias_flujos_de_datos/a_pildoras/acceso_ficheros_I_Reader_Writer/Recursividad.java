package i_poo.u_Streams_secuencias_flujos_de_datos.a_pildoras.acceso_ficheros_I_Reader_Writer;

import java.io.File;

public class Recursividad {
    //EJEMPLO EXTERNO
    /*
    Aporto un poco mi conocimiento porque este es un ejemplo perfecto donde se puede usar recursividad
    que es un tema que no se vio para listar todos los subdirectorios y archivos de un directorio determinado,
    ya que que cuando sea un subdirectorio podríamos llamar al mismo método. Acá va el ejemplo usando recursividad:
    */
    public static void main(String args[]) {
        listarDirectorios(new File("C:/Users/Jorge/Desktop/ejemploStream.txt"));

    }

    //******************************************************************************************************************
    //                            METODO A FUERA DEL MAIN
    //******************************************************************************************************************
    public static void listarDirectorios(File directorio) {
        if (!directorio.isDirectory()) {//bolean si no se trata de un directorio sino de un archivo
            System.out.println(directorio.getName());//dame su nombre
        } else {
            String[] dirs = directorio.list(); //list() devuelve un tab[] de strings con nombres de cada directorio dentro de directorio

            for (String dir : dirs) {     //File(String parent, String child)
                File f = new File(directorio.getAbsolutePath(),dir);//directorio.getAbsolutePath() vendria a ser el directorio, dir el archivo dentro(hijo)
                System.out.println(f.getName());
                if (f.isDirectory()) {
                    listarDirectorios(f);
                }
            }

        }
    }
}

