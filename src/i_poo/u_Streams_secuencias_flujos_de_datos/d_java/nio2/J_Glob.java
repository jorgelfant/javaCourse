package i_poo.u_Streams_secuencias_flujos_de_datos.d_java.nio2;

import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.nio.file.PathMatcher;
import java.nio.file.Paths;

public class J_Glob {
  public static void main(String[] args) {
    /*
    Un glob est un pattern qui est appliqué sur des noms de fichiers ou de répertoires :
    c'est une version simplifiée des expressions régulières adaptée aux noms d'éléments d'un système de fichiers.

    Plusieurs méthodes de la classe Files attendent un glob en paramètre.

    L'interface PathMatcher définit une méthode pour des objets dont le but est de réaliser des comparaisons
    sur des chemins.


    Méthode                                           Rôle
    -------                                           ----
    Boolean matches(Path path)                        Renvoie une booléen qui précise si le chemin correspond au pattern

    Pour obtenir une instance de type PathMatcher, il faut invoquer la méthode getPathMatcher() de la classe FileSystem
    qui attend en paramètre une chaîne de caractères précisant la syntaxe et le pattern.
    */
    //PathMatcher interface de la clase java.A_nio.file
    Path path = Paths.get("C:/Users/Jorge/Desktop/test2");

    PathMatcher matcher = FileSystems.getDefault().getPathMatcher("glob:*.java");
    if (matcher.matches(path)) {
      System.out.println(path);
    }

    /*
    --------------------------------------------------------------------------------------------------------------------
     Motif                    Rôle
     -----                    ----
     *                        Aucun ou plusieurs caractères
     **                       Aucun ou plusieurs sous-répertoires
     ?                        Un caractère quelconque
     {}                       Un ensemble de motifs exemple : {htm, html}


                              Un ensemble de caractères.

                              Exemple : [A-Z] : toutes les lettres majuscules

                              [0-9] : tous les chiffres

     []                       [a-v_design_patterns,A-Z] : toutes les lettres indépendamment de la casse

                              Chaque élément de l'ensemble est séparé par un caractère virgule

                              Le caractère - permet de définir une plage de caractères

                              A l'intérieur des crochets, les caractères *, ? et / ne sont pas interprétés


     \                       	Il permet d'échapper des caractères pour éviter qu'ils ne soient interprétés.
                              Il sert notamment à échapper le caractère \ lui-même

     Les autres caractères Ils se représentent eux-mêmes sans être interprétés
    --------------------------------------------------------------------------------------------------------------------

    Exemples :

    Glob                      	Explication
    ----                        -----------

    *.html                      tous les fichiers ayant l'extension .html

    ???                         trois caractères quelconques

    *[0-9]*                     tous les fichiers qui contiennent au moins un chiffre

    *.{htm, html}               tous les fichiers dont l'extension est htm ou html

    I*.java                     tous les fichiers dont le nom commence par un i majuscule et possède une extension .java

    Chaque implémentation de type FileSystem permet d'obtenir une instance de type PathMatcher en utilisant
    la méthode getPathMatcher() qui attend en paramètre un objet de type String contenant la syntaxe et le motif.
    */

    String pattern = "glob:*.{text}";
    PathMatcher matcher2 = FileSystems.getDefault().getPathMatcher("glob:" + pattern);

    /*
    Le paramètre contient la syntaxe du motif suivi du caractère deux-points et du motif qui sera utilisé pour
    vérifier la correspondance. Dans l'exemple ci-dessus, la syntaxe utilisée est de type glob.

    La syntaxe glob est simple mais il est aussi possible d'utiliser une expression régulière en précisant
    la syntaxe regex.

    Une implémentation peut proposer le support d'autres syntaxes. Il est aussi possible de définir sa propre
    implémentation de l'interface PathMatcher.

    L'interface PathMatcher ne possède qu'une seule méthode nommée matches() qui attend en paramètre un objet
    de type Path et renvoie un booléen.
    */
    PathMatcher matcher3 = FileSystems.getDefault().getPathMatcher("glob:*.{java,class}");

    Path filename = Paths.get("C:/Users/Jorge/Desktop/test2");
    if (matcher3.matches(filename)) {
      System.out.println(filename);
    }
    /*
    Il faut être vigilent lors de la définition du motif utilisé par le glob car le motif s'applique sur l'ensemble du chemin.
    */
    try {
      testGlob();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  public static void testGlob() throws IOException {

    final Path file1 = Paths.get("C:/java/test/test.java");
    final Path file2 = Paths.get("C:/java/test/test.txt");
    final Path file3 = file1.getFileName();

    String pattern = "glob:**/*.{java,class}";
    System.out.println("Pattern " + pattern);

    PathMatcher matcher = FileSystems.getDefault().getPathMatcher(pattern);

    System.out.println(file1 + " " + matcher.matches(file1));
    System.out.format("%-22s %b\n", file2, matcher.matches(file2));
    System.out.format("%-22s %b\n", file3, matcher.matches(file3));

    System.out.println();

    pattern = "glob:*.java";
    System.out.println("Pattern " + pattern);

    matcher = FileSystems.getDefault().getPathMatcher(pattern);
    System.out.println(file1 + " " + matcher.matches(file1));
    System.out.format("%-22s %b\n", file3, matcher.matches(file3));
  }
}
