package i_poo.u_Streams_secuencias_flujos_de_datos.a_pildoras.t_archivos_directorios_class_File;

import java.io.File;

public class FileMain {
    public static void main(String[] args) {
        //Manipulacion de archivos y directorios class File
        /*
         public class File
         extends Object
         implements Serializable, Comparable<File>


         User interfaces and operating systems use system-dependent pathname strings to name files and directories.
         This class presents an abstract, system-independent view of hierarchical pathnames. An abstract pathname
         has two components:

         1) An optional system-dependent prefix string, such as a disk-drive specifier, "/" for the UNIX root directory,
            or "\\\\" for a Microsoft Windows UNC pathname, and

         2) A sequence of zero or more string names.


         For UNIX platforms, the prefix of an absolute pathname is always "/". Relative pathnames have no prefix.
         The abstract pathname denoting the root directory has the prefix "/" and an empty name sequence.

         For Microsoft Windows platforms, the prefix of a pathname that contains a drive specifier consists of
         the drive letter followed by ":" and possibly followed by "\\" if the pathname is absolute. The prefix
         of a UNC pathname is "\\\\"; the hostname and the share name are the first two names in the name sequence.
         A relative pathname that does not specify a drive has no prefix.


         Constructors
         ------------

         Constructor and Description
         ---------------------------
         File(File parent, String child)
                    Creates a new File instance from a parent abstract pathname and a child pathname string.
         File(String pathname)
                    Creates a new File instance by converting the given pathname string into an abstract pathname.
         File(String parent, String child)
                    Creates a new File instance from a parent pathname string and a child pathname string.
         File(URI uri)
                    Creates a new File instance by converting the given file: URI into an abstract pathname.

        */

        //Veremos como manipular el sistema de archivos , ver que archivos hay en una ruta en concreto
        //hacer un listado de los archivos que hay , ver las propiedades de esos archivos y directorios
        // por ejemplo para ver si son de lectura  escritura, e incluso poder borrar y crear nuevos directorios

        //**************************************************************************************************************
        //                   Para toodo esto esto es necesario una unica  clase File
        //**************************************************************************************************************

        /*                                           Class
                                                *****************
                                                *     File      *
                                   M            *****************                                M
      ******************************                    |                    *********************
      *  String getAbsolutePath()  *--------------------|------------------- * Boolean exists()  *
      ******************************                    |                    *********************
                                   M                    |                                         M
             ***********************                    |                    **********************
             *   String getPath()  * -------------------|--------------------* String[] list()    *
             ***********************                    |                    **********************
                                   M                    |                                            M
      ******************************                    |                    **************************
      *  String getCanonicalPath() *--------------------|--------------------* boolean isDirectory()  *
      ******************************                                         **************************


      Methods
      -------
      Modifier and Type	Method and Description
      ----------------------------------------

      boolean	               canExecute()
                               Tests whether the application can execute the file denoted by this abstract pathname.

      boolean	               canRead()
                               Tests whether the application can read the file denoted by this abstract pathname.

      boolean	               canWrite()
                               Tests whether the application can modify the file denoted by this abstract pathname.

      int	                   compareTo(File pathname)
                               Compares two abstract pathnames lexicographically.

      boolean	               createNewFile()
                               Atomically creates a new, empty file named by this abstract pathname if and only
                               if a file with this name does not yet exist.

      static File	           createTempFile(String prefix, String suffix)
                               Creates an empty file in the default temporary-file directory, using the given
                               prefix and suffix to generate its name.

      static File	           createTempFile(String prefix, String suffix, File directory)
                               Creates a new empty file in the specified directory, using the given prefix and
                               suffix strings to generate its name.

      boolean	               delete()
                               Deletes the file or directory denoted by this abstract pathname.

      void	                   deleteOnExit()
                               Requests that the file or directory denoted by this abstract pathname be deleted
                               when the virtual machine terminates.

      boolean	               equals(Object obj)
                               Tests this abstract pathname for equality with the given object.

      boolean	               exists()
                               Tests whether the file or directory denoted by this abstract pathname exists.

      File	                   getAbsoluteFile()
                               Returns the absolute form of this abstract pathname.

      String	               getAbsolutePath()
                               Returns the absolute pathname string of this abstract pathname.

      File	                   getCanonicalFile()
                               Returns the canonical form of this abstract pathname.

      String	               getCanonicalPath()
                               Returns the canonical pathname string of this abstract pathname.

      long	                   getFreeSpace()
                               Returns the number of unallocated bytes in the partition named by this abstract path name.

      String	               getName()
                               Returns the name of the file or directory denoted by this abstract pathname.

      String	               getParent()
                               Returns the pathname string of this abstract pathname's parent, or null if this
                               pathname does not name a parent directory.

      File	                   getParentFile()
                               Returns the abstract pathname of this abstract pathname's parent, or null if this
                               pathname does not name a parent directory.

      String	               getPath()
                               Converts this abstract pathname into a pathname string.

      long	                   getTotalSpace()
                               Returns the size of the partition named by this abstract pathname.

      long	                   getUsableSpace()
                               Returns the number of bytes available to this virtual machine on the partition
                               named by this abstract pathname.

      int	                   hashCode()
                               Computes a hash code for this abstract pathname.

      boolean	               isAbsolute()
                               Tests whether this abstract pathname is absolute.

      boolean	               isDirectory()
                               Tests whether the file denoted by this abstract pathname is a directory.

      boolean	               isFile()
                               Tests whether the file denoted by this abstract pathname is a normal file.

      boolean	               isHidden()
                               Tests whether the file named by this abstract pathname is a hidden file.

      long	                   lastModified()
                               Returns the time that the file denoted by this abstract pathname was last modified.

      long	                   length()
                               Returns the length of the file denoted by this abstract pathname.

      String[]	               list()
                               Returns an array of strings naming the files and directories in the directory
                               denoted by this abstract pathname.

      String[]	               list(FilenameFilter filter)
                               Returns an array of strings naming the files and directories in the directory
                               denoted by this abstract pathname that satisfy the specified filter.

      File[]	               listFiles()
                               Returns an array of abstract pathnames denoting the files in the directory
                               denoted by this abstract pathname.

      File[]	               listFiles(FileFilter filter)
                               Returns an array of abstract pathnames denoting the files and directories
                               in the directory denoted by this abstract pathname that satisfy the specified filter.

      File[]	               listFiles(FilenameFilter filter)
                               Returns an array of abstract pathnames denoting the files and directories in the
                               directory denoted by this abstract pathname that satisfy the specified filter.

      static File[]	           listRoots()
                               List the available filesystem roots.

      boolean	               mkdir()
                               Creates the directory named by this abstract pathname.

      boolean	               mkdirs()
                               Creates the directory named by this abstract pathname, including any necessary
                               but nonexistent parent directories.

      boolean	               renameTo(File dest)
                               Renames the file denoted by this abstract pathname.

      boolean	               setExecutable(boolean executable)
                               A convenience method to set the owner's execute permission for this abstract pathname.

      boolean	               setExecutable(boolean executable, boolean ownerOnly)
                               Sets the owner's or everybody's execute permission for this abstract pathname.

      boolean	               setLastModified(long time)
                               Sets the last-modified time of the file or directory named by this abstract pathname.

      boolean	               setReadable(boolean readable)
                               A convenience method to set the owner's read permission for this abstract pathname.

      boolean	               setReadable(boolean readable, boolean ownerOnly)
                               Sets the owner's or everybody's read permission for this abstract pathname.

      boolean	               setReadOnly()
                               Marks the file or directory named by this abstract pathname so that only read
                               operations are allowed.

      boolean	               setWritable(boolean writable)
                               A convenience method to set the owner's write permission for this abstract pathname.

      boolean	               setWritable(boolean writable, boolean ownerOnly)
                               Sets the owner's or everybody's write permission for this abstract pathname.

      Path	                   toPath()
                               Returns a java.A_nio.file.Path object constructed from the this abstract path.

      String	               toString()
                               Returns the pathname string of this abstract pathname.

      URI	                   toURI()
                               Constructs a file: URI that represents this abstract pathname.

      URL	                   toURL()
                               Deprecated.
                               This method does not automatically escape characters that are illegal in URLs.
                               It is recommended that new code convert an abstract pathname into a URL by first
                               converting it into a URI, via the toURI method, and then converting the URI into a
                               URL via the URI.toURL method.

        */
        //**************************************************************************************************************
        //PRIMER EJEMPLO, con un archivo que en principio no existe
        //**************************************************************************************************************

        File documento = new File("C:/Users/Jorge/Desktop/ejemploFile");//crea el camino al archivo (exista o no)
        System.out.println(documento.getPath());//
        System.out.println(documento.getAbsolutePath());//me da la ruta es decir "C:/Users/Jorge/Desktop/ejemploFile" m dice dd ta
        //si solo poniamos ejemploFile nos hubiera dado la ruta completa  y no solo ejemploFile
        if (documento.exists()) {
            System.out.println("el archivo existe");
        } else {
            System.out.println("El archivo no existe");//no existe
        }

        if (documento.canRead()) {
            System.out.println("el archivo se puede leer");
        } else {
            System.out.println("el archivo no se puede leer");//no existe
        }

        if (documento.delete()) {
            System.out.println("el archivo se puede borrar");
        } else {
            System.out.println("el archivo no se puede borrar");//no existe
        }
        //crea el lista
        //System.out.println(documento.mkdir());//Creates the directory named by this abstract pathname.
        System.out.println();
        //**************************************************************************************************************
        //Como hacer un listado de toodo lo que se encuentra en la carpeta?
        //**************************************************************************************************************

        File aver = new File("C:/Users/Jorge/Desktop/Test");
        String[] lista = aver.list();//retorna un lista[] de string

        if (lista == null) {//pa tar seguro que el objeto lista existe, osea que la lista existe mejor dicho
            System.out.println("El lista esta vacio");//si no existe dira que ta vacio entonces
        } else {
            System.out.println("Files dentro de la lista Test: ");
            for (int i = 0; i < lista.length; i++) {
                System.out.println(" " + lista[i]);
                File subDrirectorio = new File(aver.getAbsolutePath(), lista[i]);//padre hijo 2do constructor
                if (subDrirectorio.isDirectory()) {
                    String[] subLista = subDrirectorio.list();
                    for (int j = 0; j < subLista.length; j++) {
                        System.out.println("   " + subLista[j]);
                    }
                }
            }
        }
        System.out.println();
        System.out.println("RECURSIVIDAD :");


        //**************************************************************************************************************
        //                             Con recursividad
        //**************************************************************************************************************
        listarDirectorios(aver);
    }

    //******************************************************************************************************************
    //                          metodo recursivo externo
    //******************************************************************************************************************
    public static void listarDirectorios(File archivo) {
        if (!archivo.isDirectory()) {
            System.out.println(archivo.getName());
        } else {
            String[] lista = archivo.list();
            for (int i = 0; i < lista.length; i++) {
                File sub = new File(archivo.getAbsolutePath(), lista[i]);//contendra el hijo en curso
                System.out.println(sub.getName());//me da su nombre
                if (sub.isDirectory()) {//me dice si es un idrectorio
                    listarDirectorios(sub);//se vuelve a llamar
                }
            }
        }
    }
}
