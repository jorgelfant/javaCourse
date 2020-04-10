package i_poo.u_Streams_secuencias_flujos_de_datos.d_java.nio2;

import java.awt.*;
import java.io.File;
import java.io.IOException;

public class M_Abrir_Archivo {
  public static void main(String[] args) {
    Desktop archivo= Desktop.getDesktop();
    try {
      archivo.open(new File("C:/Users/Jorge/Desktop/Splash.lnk"));
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}
