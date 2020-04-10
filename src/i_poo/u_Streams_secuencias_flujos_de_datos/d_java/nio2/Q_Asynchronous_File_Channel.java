package i_poo.u_Streams_secuencias_flujos_de_datos.d_java.nio2;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousFileChannel;
import java.nio.channels.CompletionHandler;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.concurrent.Future;

public class Q_Asynchronous_File_Channel {
  public static void main(String[] args) throws IOException {
   /*

   I can understand why network apps would use multiplexing (to not create too many threads), and why programs would use
   async calls for pipelining (more efficient). But I don't understand the efficiency purpose of AsynchronousFileChannel.

   It's a channel that you can use to read files asynchronously, i.e. the I/O operations are done on a separate thread,
   so that the thread you're calling it from can do other things while the I/O operations are happening.

   For example: The read() methods of the class return a Future object to get the result of reading data from the file.
   So, what you can do is call read(), which will return immediately with a Future object. In the background, another
   thread will read the actual data from the file. Your own thread can continue doing things, and when it needs the
   read data, you call get() on the Future object. That will then return the data (if the background thread hasn't completed
   reading the data, it will make your thread block until the data is ready). The advantage of this is that your thread
   doesn't have to wait the whole length of the read operation; it can do some other things until it really needs the data.

   The advantage of this is that you don't need two threads.

   //**********************************************************************************************************************

   The main reason I can think of to use asynchronous IO is to better utilize the processor. Imagine you have some
   application which does some sort of processing on a file. And also let's assume you can process the data contained
   in the file in chunks. If you don't make use of asynchronous IO then your application will probably behave something
   like this:

          1. Read a block of data. No processor utilization at this point as you're blocked waiting for the data to be read.
          2. process the data you just read. At this point your application will start consuming CPU cycles as it processed the data.
          3. If more data to read, goto #1.

   The processor utilization will go up and then to zero and then up and then to zero, ... . Ideally you want to not
   be idle if you want your application to be efficient and process the data as fast as possible. A better approach would be:

          1. Issue async read
          2. When read completes issue next async read and then process data

   The first step is the bootstrapping. You have no data yet so you have to issue a read. From then on, when you get
   notified a read has completed you issue another async read and then process the data. The benefit here is that by the
   time you finish processing the chunk of data the next read has probably finished, so you always have data available
   to process and thus you're more efficiently using the processor. If your processing finishes before the read has finished
   you might need to issue multiple asynchronous reads so that you have more data to process.

   //**********************************************************************************************************************
   .Creating an AsynchronousFileChannel
   .Reading Data
   .Reading Data Via a Future
   .Reading Data Via a CompletionHandler
   .Writing Data
   .Writing Data Via a Future
   .Writing Data Via a CompletionHandler

   In Java 7 the AsynchronousFileChannel was added to Java NIO. The AsynchronousFileChannel makes it possible
   to read data from, and write data to files asynchronously. This tutorial will explain how to use the AsynchronousFileChannel.*/

    //*******************************************************************************************************************
    //                                Creating an AsynchronousFileChannel
    //*******************************************************************************************************************
    /*You create an AsynchronousFileChannel via its static method open(). Here is an example of creating
      an AsynchronousFileChannel:*/
    Path path = Paths.get("data/test.xml");

    AsynchronousFileChannel fileChannel = AsynchronousFileChannel.open(path, StandardOpenOption.READ);

   /*The first parameter to the open() method is a Path instance pointing to the file the AsynchronousFileChannel
    is to be associated with.

    The second parameter is one or more open options which tell the AsynchronousFileChannel what operations is
    to be performed on the underlying file. In this example we used the StandardOpenOption.READ which means that
    the file will be opened for reading.*/

    //*******************************************************************************************************************
    //                                             Reading Data
    //*******************************************************************************************************************
   /*You can read data from an AsynchronousFileChannel in two ways. Each way to read data call one of the read() methods
     of the AsynchronousFileChannel. Both methods of reading data will be covered in the following sections.*/

    //*******************************************************************************************************************
    //                                    1) Reading Data Via a Future
    //*******************************************************************************************************************
   /*The first way to read data from an AsynchronousFileChannel is to call the read() method that returns a Future.
     Here is how calling that read() method looks:*/

                                  //Future<Integer> operation = fileChannel.read(buffer, 0);

   /*This version of the read() method takes ByteBuffer as first parameter. The data read from the AsynchronousFileChannel
     is read into this ByteBuffer. The second parameter is the byte position in the file to start reading from.

     The read() method return immediately, even if the read operation has not finished. You can check the when the read
     operation is finished by calling the isDone() method of the Future instance returned by the read() method.

     Here is a longer example showing how to use this version of the read() method:                                   */

    AsynchronousFileChannel fileChannel2 = AsynchronousFileChannel.open(path, StandardOpenOption.READ);

    ByteBuffer buffer = ByteBuffer.allocate(1024);
    long position = 0;

    Future<Integer> operation2 = fileChannel2.read(buffer, position);

    while (!operation2.isDone()) ;

    buffer.flip();
    byte[] data = new byte[buffer.limit()];
    buffer.get(data);
    System.out.println(new String(data));
    buffer.clear();

    /*This example creates an AsynchronousFileChannel and then creates a ByteBuffer which is passed to the read()
      method as parameter, along with a position of 0. After calling read() the example loops until the isDone() method
      of the returned Future returns true. Of course, this is not a very efficient use of the CPU - but somehow you need
      to wait until the read operation has completed.

      Once the read operation has completed the data read into the ByteBuffer and then into a String and printed
      to System.out .                                                                                                 */

    //*******************************************************************************************************************
    //                                   2) Reading Data Via a CompletionHandler
    //*******************************************************************************************************************
   /*The second method of reading data from an AsynchronousFileChannel is to call the read() method version that
     takes a CompletionHandler as a parameter. Here is how you call this read() method:                               */
    fileChannel.read(buffer, position, buffer, new CompletionHandler<Integer, ByteBuffer>() {
      @Override
      public void completed(Integer result, ByteBuffer attachment) {
        System.out.println("result = " + result);

        attachment.flip();
        byte[] data = new byte[attachment.limit()];
        attachment.get(data);
        System.out.println(new String(data));
        attachment.clear();
      }

      @Override
      public void failed(Throwable exc, ByteBuffer attachment) {

      }
    });

  /*Once the read operation finishes the CompletionHandler's completed() method will be called. As parameters to
    the completed() method are passed an Integer telling how many bytes were read, and the "attachment" which was
    passed to the read() method. The "attachment" is the third parameter to the read() method. In this case it was
    the ByteBuffer into which the data is also read. You can choose freely what object to attach.

    If the read operation fails, the failed() method of the CompletionHandler will get called instead.*/

  }
}
