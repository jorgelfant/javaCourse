package i_poo.u_Streams_secuencias_flujos_de_datos.b_openclassRoom;

import java.io.File;

public class A_PrincipalFile {
    public static void main(String[] args) {
        //Gérez les flux d'entrée et de sortie

        //Création de l'objet File
        File f = new File("C:/Users/Jorge/Desktop/test/test.txt");
        System.out.println("Chemin absolu du fichier : " + f.getAbsolutePath());
        System.out.println("Nom du fichier : " + f.getName());
        System.out.println("Est-ce qu'il existe ? " + f.exists());
        System.out.println("Est-ce un répertoire ? " + f.isDirectory());
        System.out.println("Est-ce un fichier ? " + f.isFile());

        System.out.println("Affichage des lecteurs à la racine du PC : ");
        for (File file : File.listRoots()) {//ou File.listRoots() ya que se trata de un metodo static   public static File[] listRoots()
            System.out.println(file.getAbsolutePath());
            try {
                int i = 1;
                //On parcourt la liste des fichiers et répertoires//files que esten en C: y luego en D:
                for (File nom : file.listFiles()) {
                    //S'il s'agit d'un dossier, on ajoute un "/"
                    System.out.print("\t\t" + (nom.isDirectory() ? nom.getName() + "/" : nom.getName()));
                    if ((i % 4) == 0) {//cada 4 impresiones se pasara a la linea siguiente
                        System.out.print("\n");
                    }
                    i++;
                }
                System.out.println("\n");
            } catch (NullPointerException e) {
                System.out.println("No hay Files en C: o D:");
                //L'instruction peut générer une NullPointerException
                //s'il n'y a pas de sous-fichier !
            }

        }
    }

    /*Vous conviendrez que les méthodes de cet objet peuvent s'avérer très utiles ! Nous venons d'en essayer
      quelques-unes et nous avons même listé les sous-fichiers et sous-dossiers de nos lecteurs à la racine du PC.
      Vous pouvez aussi effacer le fichier grâce la méthodedelete(), créer des répertoires avec la méthodemkdir()
      (le nom donné à ce répertoire ne pourra cependant pas contenir de point («.»)) etc.

      Maintenant que vous en savez un peu plus sur cet objet, nous pouvons commencer à travailler avec notre fichier !*/
}
/*Resultado impresion

Chemin absolu du fichier : C:\Users\Jorge\Desktop\test\test.txt
Nom du fichier : test.txt
Est-ce qu'il existe ? true
Est-ce un répertoire ? false
Est-ce un fichier ? true
Affichage des lecteurs à la racine du PC :
C:\
		$Recycle.Bin/		$SysReset/		asc_rdflag		audio.log
		Config.Msi/		Dokumente und Einstellungen/		hiberfil.sys		install.log
		MSI/		MSOCache/		MyFavorite/		NVIDIA/
		pagefile.sys		PerfLogs/		Program Files/		Program Files (x86)/
		ProgramData/		Programme/		Recovery/		setup.log
		swapfile.sys		System Volume Information/		Users/		wifisetup.log
		Windows/

D:\
		$RECYCLE.BIN/		AIEEEEEE/		BOOK/		coupon_1429180679_.pdf
		DIVERS/		DOWNLOADS/		ENGLISH/		FILME/
		FORMATO NUEVO miPc/		FORMATO NUEVO miPc Downloads/		FOTOS/		INSTALACION/
		label_1429180679_.pdf		material_doc.ico		PROJET DE FIN D'ETUDES/		ruby_doc.ico
		SPIELE GAMES/		System Volume Information/		Windows.iso
*/