package i_poo.u_Streams_secuencias_flujos_de_datos.b_openclassRoom;

import java.io.File;
import java.io.IOException;

public class G_copy_folder_subfolders_files {
    public static void main(String[] args) {
        /*
        Choose what you like:

        FileUtils from Apache Commons IO (the easiest and safest way)
        Example with FileUtils:

         File srcDir = new File("C:/Demo/source");
         File destDir = new File("C:/Demo/target");
         FileUtils.copyDirectory(srcDir, destDir);

           .Manually, example before Java 7 (CHANGE: close streams in the finally-block)
           .Manually, Java >=7

           Example with AutoCloseable feature in Java 7:

        */
        File srcDir = new File("C:/Users/Jorge/Desktop/schemes");
        File destDir = new File("C:/Users/Jorge/Desktop/test/schemes");
        try {
            FilesUtils.copyDirectory(srcDir, destDir);//llamo a la clase
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
