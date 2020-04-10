package i_poo.u_Streams_secuencias_flujos_de_datos.d_java.nio2;

public class X_Equivalence_Fonctionnalites_javaio_NIO2 {
  public static void main(String[] args) {
    /*
    Comme l'API NIO2 est une nouvelle API, il n'y a pas de correspondance directe entre les deux API mais le tableau
    ci-dessous fournit un résumé de l'équivalence des principales fonctionnalités.


    Fonctionnalité                        java.io                        NIO 2
-----------------------------------------------------------------------------------------------------------------
    Encapsuler un chemin                  java.io.File                   java.nio.file.Path

    Vérifier les permissions              File.canRead(),                Files.isReadable(), Files.isWritable() et
                                          File.canCrite() et             Files.isExecutable().
                                          File.canExecute()

    Vérifier le type d'élément            File.isDirectory(),            Files.isDirectory(Path, LinkOption...),
                                          File.isFile()                  Files.isRegularFile(Path, LinkOption...),

    Taille d'un fichier                   File.length()                  Files.size(Path)

    Obtenir ou modifier la date           File.lastModified() ,          Files.getLastModifiedTime(Path, LinkOption...),
    de dernière mise à jour               File.setLastModified(long)     Files.setLastModifiedTime(Path, FileTime)


                                          File.setExecutable(),          Files.setAttribute(Path, String, Object, LinkOption...)
                                          File.setReadable(),
    Modifier les attributs                File.setReadOnly(),
                                          File.setWritable()

    Déplacer un fichier                   File.renameTo()                 Files.move()

    Supprimer un fichier                  File.delete()                   Files.delete()

    Créer un fichier                      File.createNewFile()            Files.createFile()

                                          File.deleteOnExit()             Option DELETE_ON_CLOSE à utiliser sur
                                                                          la méthode createFile()

    Créer un fichier temporaire           File.createTempFile()           Files.createTempFile(Path, String, FileAttributes<?>),
                                                                          Files.createTempFile(Path, String, String, FileAttributes<?>)

    Tester l'existence d'un fichier       File.exists                     Files.exists() ou Files.notExists()

    Obtenir le chemin absolu              File.getAbsolutePath()
                                          ou                              Path.toAbsolutePath()
                                          File.getAbsoluteFile()


                                          File.getCanonicalPath()         Path.toRealPath() ou Path.normalize()
                                          ou File.getCanonicalFile()

    Convertir en URI                      File.toURI()                    Path.toURI()

    L'élément est-il caché ?              File.isHidden()                 Files.isHidden()

    Obtenir le contenu d'un répertoire    File.list() ou                  Path.newDirectoryStream()
                                          File.listFiles()

    Créer un répertoire                   File.mkdir() ou                 Path.createDirectory()
                                          File.mkdirs()

    Obtenir le contenu                    File.listRoots()                FileSystem.getRootDirectories()
    du répertoire racine


                                          File.getTotalSpace()            FileStore.getTotalSpace()

                                          File.getFreeSpace()             FileStore.getUnallocatedSpace()

                                          File.getUsableSpace()           FileStore.getUsableSpace()




    */
  }
}
