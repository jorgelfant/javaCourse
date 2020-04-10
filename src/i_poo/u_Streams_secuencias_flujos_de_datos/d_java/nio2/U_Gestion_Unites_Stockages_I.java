package i_poo.u_Streams_secuencias_flujos_de_datos.d_java.nio2;

import java.io.IOException;
import java.nio.file.FileStore;
import java.nio.file.FileSystems;
import java.nio.file.attribute.BasicFileAttributeView;
import java.nio.file.attribute.DosFileAttributeView;
import java.nio.file.attribute.PosixFileAttributeView;

public class U_Gestion_Unites_Stockages_I {
  public static void main(String[] args) {/*
    //******************************************************************************************************************
    //                             La gestion des unités de stockages
    //******************************************************************************************************************
    Les fichiers et les répertoires contenus dans un système de fichiers sont stockés dans un périphérique de stockage.
    Ces systèmes de stockages peuvent être des unités physiques sous la forme de disques (disque dur, SSD, ...) ou des
    unités logiques (partitions sur un disque, ...).

    La classe java.nio.file.FileStore encapsule un système de stockage.

    Le point d'entrée d'un système de stockage est dépendant du système d'exploitation :

         .Sous Windows : c'est un volume désigné par une lettre suivie du caractère « : », les lettres A et B sont
          réservées aux lecteurs de disquettes, la lettre C est la partition de boot, les autres lettres sont
          attribuées aux autres partitions, disques ou systèmes de stockage externes Sous Unix : c'est un point de
          montage qui correspond à un répertoire dans le système de fichiers

         .Pour obtenir une instance de la classe FileStore qui encapsule le système de stockage, il faut utiliser
          la méthode getFileStore() de la classe Files en lui passant en paramètres une instance de type Path qui
          encapsule un élément du système de fichiers correspondant au système de stockage.

    La méthode getFileStores() de la classe FileSystem permet d'obtenir une instance de type Iterable<FileStore> qui
    contient tous les systèmes de stockage accessibles.                                                               */
    //retornara el sistema       retorna las unidades de stockage C y D
    Iterable<FileStore> fileStores = FileSystems.getDefault().getFileStores();
    for (FileStore fileStore : fileStores) {
      System.out.println(fileStore);
      System.out.println("name : " + fileStore.name() + ", type : " + fileStore.type());
    }
    System.out.println();

    //******************************************************************************************************************
    //                                        supportsFileAttributView()
    //******************************************************************************************************************

    /*La méthode supportsFileAttributView() permet de vérifier si une vue relative aux méta-données est supportée
      ou non par le FileStore.*/
    for (FileStore store : FileSystems.getDefault().getFileStores()) {
      System.out.println(store);
      System.out.println("Support BasicFileAttribute : " + store.supportsFileAttributeView(BasicFileAttributeView.class));
      System.out.println("Support DosFileAttribute : " + store.supportsFileAttributeView(DosFileAttributeView.class));
      System.out.println("Support PosixFileAttribute : " + store.supportsFileAttributeView(PosixFileAttributeView.class));
    }
    System.out.println();
    //******************************************************************************************************************
    //                                          FileStore
    //******************************************************************************************************************

    /*La classe FileStore possède aussi plusieurs méthodes pour obtenir des informations concernant la taille du
      système de stockage :

         .sur l'espace totale avec la méthode getTotalSpace()
         .sur l'espace disponible avec la méthode getUsableSpace()
         .sur l'espace non alloué avec la méthode getUnallocatedSpace().                                              */


    final int UN_GIGA = 1024 * 1024 * 1024;

    for (FileStore store : FileSystems.getDefault().getFileStores()) {
      try {
        long total = store.getTotalSpace() / UN_GIGA;
        long used = (store.getTotalSpace() - store.getUnallocatedSpace()) / UN_GIGA;
        long avail = store.getUsableSpace() / UN_GIGA;
        System.out.format("%-20s total=%5dGo used=%5dGo avail=%5dGo%n", store, total, used, avail);
      } catch (IOException e) {
        e.printStackTrace();
      }
    }

  }
}
