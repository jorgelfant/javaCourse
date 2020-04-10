package i_poo.u_Streams_secuencias_flujos_de_datos.b_openclassRoom;

import java.io.*;

public class FilesUtils {
    //Estos metodos trabajn entre ellos pa copiar archivos y directorios
    public static void copyDirectory(File source, File target) throws IOException {
        if (source.isDirectory()) {
            target.mkdir();

            for (String f : source.list()) {
                copyDirectory(new File(source, f), new File(target, f));//recursividad
            }
        } else {
            try (InputStream in = new FileInputStream(source); OutputStream out = new FileOutputStream(target)) {
                byte[] buf = new byte[1024];
                while ((in.read(buf)) > 0) {
                    out.write(buf);
                }
            }
        }
    }
/*
OU
public void copy(File sourceLocation, File targetLocation) throws IOException {
    if (sourceLocation.isDirectory()) {
        copyDirectory(sourceLocation, targetLocation);
    } else {
        copyFile(sourceLocation, targetLocation);
    }
}

private void copyDirectory(File source, File target) throws IOException {
    if (!target.exists()) {
        target.mkdir();
    }

    for (String f : source.list()) {
        copy(new File(source, f), new File(target, f));
    }
}

private void copyFile(File source, File target) throws IOException {
    try (
            InputStream in = new FileInputStream(source);
            OutputStream out = new FileOutputStream(target)
    ) {
        byte[] buf = new byte[1024];
        int length;
        while ((length = in.read(buf)) > 0) {
            out.write(buf, 0, length);
        }
    }
}
*/

}
