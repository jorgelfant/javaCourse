package i_poo.u_Streams_secuencias_flujos_de_datos.c_java.nio.Java;

public class M_H_ServerSocketChannel {
  public static void main(String[] args) {
    /*
     A Java NIO ServerSocketChannel is a channel that can listen for incoming TCP connections, just like
     a ServerSocket in standard Java Networking. The ServerSocketChannel class is located in the
     java.nio.channels package.

     Here is an example:

                           ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();

                           serverSocketChannel.socket().bind(new InetSocketAddress(9999));

                           while(true){
                               SocketChannel socketChannel = serverSocketChannel.accept();

                               //do something with socketChannel...
                           }


      //****************************************************************************************************************
      //                              Opening a ServerSocketChannel
      //****************************************************************************************************************

      You open a ServerSocketChannel by calling the ServerSocketChannel.open() method. Here is how that looks:

                      ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();

      //****************************************************************************************************************
      //                              Closing a ServerSocketChannel
      //****************************************************************************************************************
      Closing a ServerSocketChannel is done by calling the ServerSocketChannel.close() method. Here is how that looks:

                      serverSocketChannel.close();

      //****************************************************************************************************************
      //                              Listening for Incoming Connections
      //****************************************************************************************************************

      Listening for incoming connections is done by calling the ServerSocketChannel.accept() method.
      When the accept() method returns, it returns a SocketChannel with an incoming connection. Thus,
      the accept() method blocks until an incoming connection arrives.

      Since you are typically not interested in listening just for a single connection, you call the
      accept() inside a while-loop. Here is how that looks:

                      while(true){
                      SocketChannel socketChannel =
                              serverSocketChannel.accept();

                      //do something with socketChannel...
                      }

      Of course you would use some other stop-criteria than true inside the while-loop.

      //****************************************************************************************************************
      //                              Non-blocking Mode
      //****************************************************************************************************************

      A ServerSocketChannel can be set into non-blocking mode. In non-blocking mode the accept() method returns
      immediately, and may thus return null, if no incoming connection had arrived. Therefore you will have to check
      if the returned SocketChannel is null. Here is an example:

                        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();

                        serverSocketChannel.socket().bind(new InetSocketAddress(9999));
                        serverSocketChannel.configureBlocking(false);

                        while(true){
                            SocketChannel socketChannel =
                                    serverSocketChannel.accept();

                            if(socketChannel != null){
                                //do something with socketChannel...
                                }
                        }

    */
  }
}
