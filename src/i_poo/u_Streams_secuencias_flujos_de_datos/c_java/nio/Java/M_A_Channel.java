package i_poo.u_Streams_secuencias_flujos_de_datos.c_java.nio.Java;

public class M_A_Channel {
  public static void main(String[] args) {
    /*
      Java NIO (New IO) is an alternative IO API for Java (from Java 1.4), meaning alternative to the
      standard Java IO and Java Networking API's. Java NIO offers a different way of working with IO than
      the standard IO API's.

      //****************************************************************************************************************
      //                               Java NIO: Channels and Buffers
      //****************************************************************************************************************
      In the standard IO API you work with byte streams and character streams. In NIO you work with channels
      and buffers. Data is always read from a channel into a buffer, or written from a buffer to a channel.

      //****************************************************************************************************************
      //                               Java NIO: Non-blocking IO
      //****************************************************************************************************************
      Java NIO enables you to do non-blocking IO. For instance, a thread can ask a channel to read data into a buffer.
      While the channel reads data into the buffer, the thread can do something else. Once data is read into the buffer,
      the thread can then continue processing it. The same is true for writing data to channels.

      //****************************************************************************************************************
      //                               Java NIO: Selectors
      //****************************************************************************************************************
      Java NIO contains the concept of "selectors". A selector is an object that can monitor multiple channels for events
      (like: connection opened, data arrived etc.). Thus, a single thread can monitor multiple channels for data.

      How all this works is explained in more detail in the next text in this series - the Java NIO overview.

      Java NIO has more classes and components than these, but the Channel, Buffer and Selector forms the core of the
      API, in my opinion. The rest of the components, like Pipe and FileLock are merely utility classes to be used in
      conjunction with the three core components. Therefore, I'll focus on these three components in this NIO overview.
      The other components are explained in their own texts elsewhere in this tutorial. See the menu at the top corner
      of this page.

       //****************************************************************************************************************
      //                                Channels and Buffers
      //****************************************************************************************************************

      Typically, all IO in NIO starts with a Channel. A Channel is a bit like a stream. From the Channel data can be read
      into a Buffer. Data can also be written from a Buffer into a Channel. Here is an illustration of that:


                                            Channel   ---------> Buffer

                                            Channel   <--------- Buffer

                  Java NIO: Channels read data into Buffers, and Buffers write data into Channels

      There are several Channel and Buffer types. Here is a list of the primary Channel implementations in Java NIO:

          .ByteBuffer
          .CharBuffer
          .DoubleBuffer
          .FloatBuffer
          .IntBuffer
          .LongBuffer
          .ShortBuffer

      These Buffer's cover the basic data types that you can send via IO: byte, short, int, long, float, double and characters.

      Java NIO also has a MappedByteBuffer which is used in conjunction with memory mapped files. I'll leave this Buffer
      out of this overview though.

      //****************************************************************************************************************
      //                                   Selectors
      //****************************************************************************************************************

      A Selector allows a single thread to handle multiple Channel's. This is handy if your application has many
      connections (Channels) open, but only has low traffic on each connection. For instance, in a chat server.

      Here is an illustration of a thread using a Selector to handle 3 Channel's:

                                           Thread
                                             |
                                             |
                                  ------- Selector -------
                                  |          |           |
                                  |          |           |
                              Channel     Channel      Channel

                      Java NIO: A Thread uses a Selector to handle 3 Channel's

       To use a Selector you register the Channel's with it. Then you call it's select() method. This method
       will block until there is an event ready for one of the registered channels. Once the method returns,
       the thread can then process these events. Examples of events are incoming connection, data received etc.
     *******************************************************************************************************************

     Java NIO Channels are similar to streams with a few differences:

       .You can both read and write to a Channels. Streams are typically one-way (read or write).
       .Channels can be read and written asynchronously.
       .Channels always read to, or write from, a Buffer.

      //****************************************************************************************************************
      //                                   Channel Implementations
      //****************************************************************************************************************

      Here are the most important Channel implementations in Java NIO:

       .FileChannel
       .DatagramChannel
       .SocketChannel
       .ServerSocketChannel

       The FileChannel reads data from and to files.

       The DatagramChannel can read and write data over the network via UDP.

       The SocketChannel can read and write data over the network via TCP.

       The ServerSocketChannel allows you to listen for incoming TCP connections, like a web server does.
       For each incoming connection a SocketChannel is created.
    */

    //Basic Channel Example
    /*
    RandomAccessFile aFile = new RandomAccessFile("data/A_nio-data.txt", "rw");
    FileChannel inChannel = aFile.getChannel();

    ByteBuffer buf = ByteBuffer.allocate(48);

    int bytesRead = inChannel.read(buf);
    while (bytesRead != -1) {

      System.out.println("Read " + bytesRead);
      buf.flip();

      while(buf.hasRemaining()){
        System.out.print((char) buf.get());
      }

      buf.clear();
      bytesRead = inChannel.read(buf);
    }
    aFile.close();
    */


    //Notice the buf.flip() call. First you read into a Buffer. Then you flip it. Then you read out of it.
    // I'll get into more detail about that in the next text about Buffer's.
  }
}
