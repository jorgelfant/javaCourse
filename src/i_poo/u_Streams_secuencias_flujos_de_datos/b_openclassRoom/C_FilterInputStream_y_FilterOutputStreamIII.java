package i_poo.u_Streams_secuencias_flujos_de_datos.b_openclassRoom;
//Packages à importer afin d'utiliser l'objet File

import java.io.*;

public class C_FilterInputStream_y_FilterOutputStreamIII {
    public static void main(String[] args) {
        /*
        Je ne vais pas passer en revue tous les objets cités un peu plus haut, mais vu que vous risquez
        d’avoir besoin des objetsData(Input/Output)Stream, nous allons les aborder rapidement, puisqu'ils
        s'utilisent comme les objetsBufferedInputStream. Je vous ai dit plus haut que ceux-ci ont des méthodes
        de lecture pour chaque type primitif : il faut cependant que le fichier soit généré par le biais
        d'unDataOutputStreampour que les méthodes fonctionnent correctement.

        Nous allons donc créer un fichier de toutes pièces pour le lire par la suite.

        CONSTRUCTOR
        DataOutputStream(OutputStream out)
                      Creates a new data output stream to write data to the specified underlying output stream.
        */
        //Nous déclarons nos objets en dehors du bloc try/catch
        DataInputStream dis;
        DataOutputStream dos;
        try {
            dos = new DataOutputStream(new BufferedOutputStream(new FileOutputStream(new File("C:/Users/Jorge/Desktop/test/intento.txt"))));
            //Nous allons écrire chaque type primitif
            //dos.writeUTF("HOLA AMIGOs");    Writes a string to the underlying output stream using modified UTF-8 encoding in a machine-independent manner.
            dos.writeBoolean(true);
            dos.writeByte(100);
            dos.writeChar('C');
            dos.writeDouble(12.05);
            dos.writeFloat(100.52f);
            dos.writeInt(1024);
            dos.writeLong(123456789654321L);
            dos.writeShort(2);
            dos.close();

            //On récupère maintenant les données !
            dis = new DataInputStream(new BufferedInputStream(new FileInputStream(new File("C:/Users/Jorge/Desktop/test/intento.txt"))));

            System.out.println(dis.readBoolean());
            System.out.println(dis.readByte());
            System.out.println(dis.readChar());
            System.out.println(dis.readDouble());
            System.out.println(dis.readFloat());
            System.out.println(dis.readInt());
            System.out.println(dis.readLong());
            System.out.println(dis.readShort());

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        /*La figure suivante correspond au résultat de ce code.
            true
            100
            C
            12.05
            100.52
            1024
            123456789654321
            2

            Le code est simple, clair et concis. Vous avez pu constater que ce type d'objet ne manque
            pas de fonctionnalités ! Jusqu'ici, nous ne travaillions qu'avec des types primitifs, mais
            il est également possible de travailler avec des objets !
        */
    }
}
