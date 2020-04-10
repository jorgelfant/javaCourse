package i_poo.u_Streams_secuencias_flujos_de_datos.d_java.nio2;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class L_LECTURE_ECRITURE_EXEMPLES {
  public static void main(String[] args) {

    Path pathName = Paths.get("C:/Users/Jorge/Desktop/dictionnaire.txt");
    int bufSize = 1024;
/*
    try {
      conByteBuffered(pathName);//tiempo 9327
    } catch (IOException e) {
      e.printStackTrace();
    }

    try {
      conByteBufferedModificado(pathName,bufSize);//tiempo 9214
    } catch (IOException e) {
      e.printStackTrace();
    }*/
/*
    try {
      conreadLines(pathName);     //de Files  tiempo 1599
    } catch (IOException e) {
      e.printStackTrace();
    }*/
     /*
    try {
      conMappedByteBuffer(pathName);//de Files tiempo 861 16715
    } catch (IOException e) {
      e.printStackTrace();
    }
*/
    try {
      conBufferedReader(pathName);//de Files tiempo 861 16715
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
  //********************************************************************************************************************
  //                                          METODO FUERA DEL MAIN
  //********************************************************************************************************************
  public static void conByteBuffered(Path pathName) throws IOException {
    FileChannel fileChannel = FileChannel.open(pathName);
    long size = fileChannel.size();

    ByteBuffer buf = ByteBuffer.allocate((int) size);
    fileChannel.read(buf);
    buf.flip();//set limit = current position, and set position = 0;
    long time = System.currentTimeMillis();
    for (int i = 0; i < size; i++) {
      System.out.print((char) buf.get());
    }
    fileChannel.close();
    System.out.println(System.currentTimeMillis() - time);
  }
  //********************************************************************************************************************
  //                                          METODO FUERA DEL MAIN
  //********************************************************************************************************************
  public static void conByteBufferedModificado(Path pathName, int bufSize) throws IOException {
    FileChannel fileChannel = FileChannel.open(pathName);
    ByteBuffer buf = ByteBuffer.allocate(bufSize);

    long time = System.currentTimeMillis();

    while (fileChannel.read(buf) != -1) {
      buf.flip();
      while (buf.hasRemaining()) {
        System.out.print((char) buf.get());
      }
      buf.clear();
    }
    fileChannel.close();
    System.out.println(System.currentTimeMillis() - time);
  }
  //********************************************************************************************************************
  //                               CON Files  bcp plus rapide
  //********************************************************************************************************************
  public static void conMappedByteBuffer(Path pathName) throws IOException {
    FileChannel fileChannel = FileChannel.open(pathName);
    MappedByteBuffer buffer = fileChannel.map(FileChannel.MapMode.READ_ONLY, 0, fileChannel.size());
    long time = System.currentTimeMillis();
    buffer.load();
    for (int i = 0; i < fileChannel.size(); i++) {
      System.out.print((char) buffer.get());
    }
    System.out.println(System.currentTimeMillis() - time);
  }

  //********************************************************************************************************************
  //                               CON Files  bcp plus rapide
  //********************************************************************************************************************
  public static void conreadLines(Path pathName) throws IOException {
    List<String> lista = Files.readAllLines(pathName, Charset.forName("ISO-8859-1"));
    long time = System.currentTimeMillis();

    for (int i = 0; i < lista.size(); i++) {
      System.out.println(lista.get(i));
    }

    System.out.println(System.currentTimeMillis() - time);
  }

  //********************************************************************************************************************
  //                               CON Files  bcp plus rapide
  //********************************************************************************************************************
  public static void conBufferedReader(Path pathName) throws IOException {
    BufferedReader buf = Files.newBufferedReader(pathName, Charset.forName("ISO-8859-1"));
    long time = System.currentTimeMillis();

    while (buf.readLine() != null) {
      System.out.println(buf.readLine());
    }

    System.out.println(System.currentTimeMillis() - time);
  }


}
