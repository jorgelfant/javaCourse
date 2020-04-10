package i_poo.u_Streams_secuencias_flujos_de_datos.c_java.nio.Java;

public class M_F_FileChannel {
  public static void main(String[] args) {
    /*

     A Java NIO FileChannel is a channel that is connected to a file. Using a file channel you can read data
     from a file, and write data to a file. The Java NIO FileChannel class is NIO's an alternative to reading
     files with the standard Java IO API.

     A FileChannel cannot be set into non-blocking mode. It always runs in blocking mode.

     //*****************************************************************************************************************
     //                                          Opening a FileChannel
     //*****************************************************************************************************************

     Before you can use a FileChannel you must open it. You cannot open a FileChannel directly. You need to obtain
     a FileChannel via an InputStream, OutputStream, or a RandomAccessFile. Here is how you open a FileChannel via a
     RandomAccessFile:

                                 RandomAccessFile aFile     = new RandomAccessFile("data/nio-data.txt", "rw");
                                 FileChannel      inChannel = aFile.getChannel();

     //*****************************************************************************************************************
     //                                         Reading Data from a FileChannel
     //*****************************************************************************************************************

     To read data from a FileChannel you call one of the read() methods. Here is an example:

                                 ByteBuffer buf = ByteBuffer.allocate(48);

                                 int bytesRead = inChannel.read(buf);

     First a Buffer is allocated. The data read from the FileChannel is read into the Buffer.

     Second the FileChannel.read() method is called. This method reads data from the FileChannel into the Buffer.
     The int returned by the read() method tells how many bytes were witten into the Buffer. If -1 is returned,
     the end-of-file is reached.

     //*****************************************************************************************************************
     //                                        Writing Data to a FileChannel
     //*****************************************************************************************************************

     Writing data to a FileChannel is done using the FileChannel.write() method, which takes a Buffer as parameter.
     Here is an example:

                                  String newData = "New String to write to file..." + System.currentTimeMillis();

                                  ByteBuffer buf = ByteBuffer.allocate(48);
                                  buf.clear();
                                  buf.put(newData.getBytes());

                                  buf.flip();

                                  while(buf.hasRemaining()) {
                                      channel.write(buf);
                                  }

     Notice how the FileChannel.write() method is called inside a while-loop. There is no guarantee of how many
     bytes the write() method writes to the FileChannel. Therefore we repeat the write() call until the Buffer
     has no further bytes to write.

     //*****************************************************************************************************************
     //                                       Closing a FileChannel
     //*****************************************************************************************************************

     When you are done using a FileChannel you must close it. Here is how that is done:

     channel.close();

     //*****************************************************************************************************************
     //                                       FileChannel Position
     //*****************************************************************************************************************

     When reading or writing to a FileChannel you do so at a specific position. You can obtain the current position
     of the FileChannel object by calling the position() method.

     You can also set the position of the FileChannel by calling the position(long pos) method.

     Here are two examples:

                             long pos channel.position();

                             channel.position(pos +123);

     If you set the position after the end of the file, and try to read from the channel, you will get -1 - the end-of-file marker.

     If you set the position after the end of the file, and write to the channel, the file will be expanded to fit the
     position and written data. This may result in a "file hole", where the physical file on the disk has gaps in the
     written data.

     //*****************************************************************************************************************
     //                                       FileChannel Size
     //*****************************************************************************************************************

     The size() method of the FileChannel object returns the file size of the file the channel is connected to.
     Here is a simple example:

                                  long fileSize = channel.size();

     //*****************************************************************************************************************
     //                                       FileChannel Truncate
     //*****************************************************************************************************************

     You can truncate a file by calling the FileChannel.truncate() method. When you truncate a file,
     you cut it off at a given length. Here is an example:

                                 channel.truncate(1024);

     This example truncates the file at 1024 bytes in length.

     //*****************************************************************************************************************
     //                                       FileChannel Force
     //*****************************************************************************************************************

     The FileChannel.force() method flushes all unwritten data from the channel to the disk. An operating system
     may cache data in memory for performance reasons, so you are not guaranteed that data written to the channel
     is actually written to disk, until you call the force() method.

     The force() method takes a boolean as parameter, telling whether the file meta data (permission etc.) should be
     flushed too.

     Here is an example which flushes both data and meta data:

                                           channel.force(true);

    */

  }
}
