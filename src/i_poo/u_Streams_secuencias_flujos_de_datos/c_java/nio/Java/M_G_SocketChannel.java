package i_poo.u_Streams_secuencias_flujos_de_datos.c_java.nio.Java;

public class M_G_SocketChannel {
  public static void main(String[] args) {

    /*
      A Java NIO SocketChannel is a channel that is connected to a TCP network socket.
      It is Java NIO's equivalent of Java Networking's Sockets. There are two ways a SocketChannel can be created:

      1. You open a SocketChannel and connect to a server somewhere on the internet.
      2. A SocketChannel can be created when an incoming connection arrives at a ServerSocketChannel.

      //****************************************************************************************************************
      //                              Opening a SocketChannel
      //****************************************************************************************************************

      Here is how you open a SocketChannel:
                  SocketChannel socketChannel = SocketChannel.open();
                  socketChannel.connect(new InetSocketAddress("http://jenkov.com", 80));


      //****************************************************************************************************************
      //                              Closing a SocketChannel
      //****************************************************************************************************************
      You close a SocketChannel after use by calling the SocketChannel.close() method. Here is how that is done:

                   socketChannel.close();

      //****************************************************************************************************************
      //                              Reading from a SocketChannel
      //****************************************************************************************************************
      To read data from a SocketChannel you call one of the read() methods. Here is an example:

                   ByteBuffer buf = ByteBuffer.allocate(48);
                   int bytesRead = socketChannel.read(buf);

      First a Buffer is allocated. The data read from the SocketChannel is read into the Buffer.

      Second the SocketChannel.read() method is called. This method reads data from the SocketChannel into the Buffer.
      The int returned by the read() method tells how many bytes were witten into the Buffer. If -1 is returned, the
      end-of-stream is reached (the connection is closed).

      //****************************************************************************************************************
      //                              Writing to a SocketChannel
      //****************************************************************************************************************

      Writing data to a SocketChannel is done using the SocketChannel.write() method, which takes a Buffer as parameter.
      Here is an example:

                  String newData = "New String to write to file..." + System.currentTimeMillis();

                  ByteBuffer buf = ByteBuffer.allocate(48);
                  buf.clear();
                  buf.put(newData.getBytes());

                  buf.flip();

                  while(buf.hasRemaining()) {
                      channel.write(buf);
                  }

      Notice how the SocketChannel.write() method is called inside a while-loop. There is no guarantee of how many
      bytes the write() method writes to the SocketChannel. Therefore we repeat the write() call until the Buffer
      has no further bytes to write.

      //****************************************************************************************************************
      //                              Non-blocking Mode
      //****************************************************************************************************************

      You can set a SocketChannel into non-blocking mode. When you do so, you can call connect(), read() and write()
      in asynchronous mode.

      connect()
      ---------
      If the SocketChannel is in non-blocking mode, and you call connect(), the method may return before a connection is
      established. To determine whether the connection is established, you can call the finishConnect() method, like this:

                           socketChannel.configureBlocking(false);
                           socketChannel.connect(new InetSocketAddress("http://jenkov.com", 80));

                           while(! socketChannel.finishConnect() ){
                               //wait, or do something else...
                           }

      write()
      ------
      In non-blocking mode the write() method may return without having written anything. Therefore you need to call the
      write() method in a loop. But, since this is already being done in the previous write examples, no need to do anything
      differently here.

      read()
      -----
      In non-blocking mode the read() method may return without having read any data at all. Therefore you need to
      pay attention to the returned int, which tells how many bytes were read.

      Non-blocking Mode with Selectors
      --------------------------------
      The non-blocking mode of SocketChannel's works much better with Selector's. By registering one or more
      SocketChannel's with a Selector, you can ask the Selector for channels that are ready for reading, writing etc.
      How to use Selector's with SocketChannel's is explained in more detail in a later text in this tutorial.
    */
  }
}
