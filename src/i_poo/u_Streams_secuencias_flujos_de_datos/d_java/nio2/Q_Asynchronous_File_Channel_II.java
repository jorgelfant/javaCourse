package i_poo.u_Streams_secuencias_flujos_de_datos.d_java.nio2;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousFileChannel;
import java.nio.channels.CompletionHandler;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.concurrent.Future;

public class Q_Asynchronous_File_Channel_II {
  public static void main(String[] args) throws IOException {
    //*******************************************************************************************************************
    //                                      Writing Data
    //*******************************************************************************************************************

   /*Just like with reading, you can write data to an AsynchronousFileChannel in two ways. Each way to write data call
   one of the write() methods of the AsynchronousFileChannel. Both methods of writing data will be covered in the
   following sections.                                                                                                */

    //*******************************************************************************************************************
    //                                1) Writing Data Via a Future
    //*******************************************************************************************************************
   /*The AsynchronousFileChannel also enables you to write data asynchronously. Here is a full Java
     AsynchronousFileChannel write example:                                                                           */

    Path path = Paths.get("data/test-write.txt");
    AsynchronousFileChannel fileChannel = AsynchronousFileChannel.open(path, StandardOpenOption.WRITE);

    ByteBuffer buffer = ByteBuffer.allocate(1024);
    long position = 0;

    buffer.put("test data".getBytes());
    buffer.flip();

    Future<Integer> operation = fileChannel.write(buffer, position);
    buffer.clear();

    while (!operation.isDone()) ;

    System.out.println("Write done");

    /*First an AsynchronousFileChannel is opened in write mode. Then a ByteBuffer is created and some data written into it.
      Then the data in the ByteBuffer is written to the file. Finally the example checks the returned Future to see when
      the write operation has completed.

      Note, that the file must already exist before this code will work. If the file does not exist the write() method
      will throw a java.nio.file.NoSuchFileException .

      You can make sure that the file the Path points to exists with the following code:*/
    if (!Files.exists(path)) {
      Files.createFile(path);
    }

    //*******************************************************************************************************************
    //                                2) Writing Data Via a CompletionHandler
    //*******************************************************************************************************************
    /*You can also write data to the AsynchronousFileChannel with a CompletionHandler to tell you when the write is
    complete instead of a Future. Here is an example of writing data to the AsynchronousFileChannel with a CompletionHandler:*/
    Path patho = Paths.get("data/test-write.txt");
    if(!Files.exists(patho)){
      Files.createFile(patho);
    }
    AsynchronousFileChannel fileChannel2 = AsynchronousFileChannel.open(patho, StandardOpenOption.WRITE);

    ByteBuffer buffer2 = ByteBuffer.allocate(1024);
    long position2 = 0;

    buffer.put("test data".getBytes());
    buffer.flip();

    fileChannel.write(buffer, position, buffer, new CompletionHandler<Integer, ByteBuffer>() {

      @Override
      public void completed(Integer result, ByteBuffer attachment) {
        System.out.println("bytes written: " + result);
      }

      @Override
      public void failed(Throwable exc, ByteBuffer attachment) {
        System.out.println("Write failed");
        exc.printStackTrace();
      }
    });

  /*The CompletionHandler's completed() method will get called when the write operation completes. If the write fails
   for some reason, the failed() method will get called instead.

   Notice how the ByteBuffer is used as attachment - the object which is passed on to the CompletionHandler's methods.*/


  }
}
