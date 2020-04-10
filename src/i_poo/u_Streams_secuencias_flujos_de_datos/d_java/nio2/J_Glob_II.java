package i_poo.u_Streams_secuencias_flujos_de_datos.d_java.nio2;

//import javafx.scene.shape.Path;

import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;

public class J_Glob_II {
  public static void main(String[] args) {
    /*
    Glob	                        Description
    -------------------------------------------
    *.txt	                        Matches all files that has extension as txt.
    *.{html,htm}	                Matches all files that has extension as html or htm. { } are used to group patterns
                                  and , comma is used to separate patterns.

    ?.txt	                        Matches all files that has any single charcter as name and extension as txt.
    *.*	                          Matches all files that has . in its name.
    C:\\Users\\*	                Matches any files in C: ‘Users’ directory in Windows file system. Backslash
                                  is used to escape a special character.
    /home/**	                    Matches /home/foo and /home/foo/bar on UNIX platforms. ** matches strings of
                                  characters corssing directory boundaries.
    [xyz].txt	                    Matches a file name with single character ‘x’ or ‘y’ or ‘v_design_patterns’ and extension as txt.
                                  Square brackets [ ] are used to sepcify a character set.
    [a-c].txt	                    Matches a file name with single character ‘a’ or ‘b’ or ‘c’ and extension as txt. Hypehen – is
                                  used to specify a range and used in [ ]
    [!a].txt	                    Matches a file name with single character that is not ‘a’. ! is used for negation.
    */
    String glob = "glob:*.txt";//ou "glob:**/*.zip"      ->  aaa/bbb/BuilderPatternDemo.zip
    String path = "C:/Users/Jorge/Desktop/test2";//ou "D:/"

    try {
      match(path, glob);
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
 //metodo fuera del main    que buscar    donde buscar
  public static void match(String path, String glob ) throws IOException {

    final PathMatcher pathMatcher = FileSystems.getDefault().getPathMatcher(glob);
    Files.walkFileTree(Paths.get(path), new SimpleFileVisitor<Path>() {

      @Override
      public FileVisitResult visitFile(Path path, BasicFileAttributes attrs) throws IOException {
        if (pathMatcher.matches(path.getFileName())) {//vbvbvb.java  con getFileName()  ..sino seria aa/bb/cc/dd.java la ruta normal
          System.out.println(path);                   //y se necesitaria precisar el el glob la arborescence ***/*.java por ejemplo
        }
        return FileVisitResult.CONTINUE;
      }

      @Override
      public FileVisitResult visitFileFailed(Path file, IOException exc) throws IOException {
        return FileVisitResult.CONTINUE;
      }
    });
  }
}
