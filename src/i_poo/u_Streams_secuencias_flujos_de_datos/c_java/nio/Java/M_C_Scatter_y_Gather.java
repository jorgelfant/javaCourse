package i_poo.u_Streams_secuencias_flujos_de_datos.c_java.nio.Java;

public class M_C_Scatter_y_Gather {
  public static void main(String[] args) {
    /*
    Java NIO comes with built-in scatter / gather support. Scatter / gather are concepts used in reading from,
    and writing to channels.

    A scattering read from a channel is a read operation that reads data into more than one buffer. Thus,
    the channel "scatters" the data from the channel into multiple buffers.

    A gathering write to a channel is a write operation that writes data from more than one buffer into a single channel.
    Thus, the channel "gathers" the data from multiple buffers into one channel.

    Scatter / gather can be really useful in situations where you need to work with various parts of the transmitted
    data separately. For instance, if a message consists of a header and a body, you might keep the header and body
    in separate buffers. Doing so may make it easier for you to work with header and body separately.

    Scattering Reads
    A "scattering read" reads data from a single channel into multiple buffers. Here is an illustration of that principle:

    Here is an illustration of the Scatter principle:


                           ----> Buffer
                          |
                          |
              Channel ---------> Buffer
                          |
                          |
                          -----> Buffer

             Java NIO: Scattering Read

      Here is a code example that shows how to perform a scattering read:

          ByteBuffer header = ByteBuffer.allocate(128);
          ByteBuffer body   = ByteBuffer.allocate(1024);

          ByteBuffer[] bufferArray = { header, body };

          channel.read(bufferArray);


    Notice how the buffers are first inserted into an array, then the array passed as parameter to the
    channel.read() method. The read() method then writes data from the channel in the sequence the buffers
    occur in the array. Once a buffer is full, the channel moves on to fill the next buffer.

    The fact that scattering reads fill up one buffer before moving on to the next, means that it is not suited
    for dynamically sized message parts. In other words, if you have a header and a body, and the header is
    fixed size (e.g. 128 bytes), then a scattering read works fine.


    Gathering Writes
    ----------------
    A "gathering write" writes data from multiple buffers into a single channel. Here is an illustration of that principle:

                           ----- Buffer
                          |
                          |
              Channel <--------- Buffer
                          |
                          |
                          ----- Buffer

             Java NIO: Scattering Read

    Here is a code example that shows how to perform a gathering write:

    ByteBuffer header = ByteBuffer.allocate(128);
    ByteBuffer body   = ByteBuffer.allocate(1024);

    //write data into buffers

    ByteBuffer[] bufferArray = { header, body };

    channel.write(bufferArray);

    The array of buffers are passed into the write() method, which writes the content of the buffers in the
    sequence they are encountered in the array. Only the data between position and limit of the buffers is written.
    Thus, if a buffer has a capacity of 128 bytes, but only contains 58 bytes, only 58 bytes are written from that
    buffer to the channel. Thus, a gathering write works fine with dynamically sized message parts, in contrast to
    scattering reads.



    */




  }
}
