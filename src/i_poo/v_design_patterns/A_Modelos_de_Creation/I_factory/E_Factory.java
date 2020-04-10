package i_poo.v_design_patterns.A_Modelos_de_Creation.I_factory;


public class E_Factory {
  public static void main(String[] args) {
    //******************************************************************************************************************
    //                                              Encapsulation
    //******************************************************************************************************************
    /*
    Les méthodes de fabrication permettent d'encapsuler la création des objets. Ce qui peut être utile lorsque le
    processus de création est très complexe, s'il dépend par exemple de fichiers de configuration ou d'entrées utilisateur.

    L'exemple ci-dessous présente un programme qui crée des icônes à partir de fichiers d'images. Ce programme sait
    traiter plusieurs formats d'images représentés chacun par une classe :
    */
  }
}
//******************************************************************************************************************
//                                              Hors du main
//******************************************************************************************************************
/*
                                    interface ImageReader {
                                      public DecodedImage getDecodedImage();
                                    }

                                    class GifReader implements ImageReader {
                                      public GifReader(InputStream in) {
                                        // Vérifier qu'il s'agit d'une image GIF,
                                        // lancer une exception si ce n'est pas le cas,
                                        // décoder l'image sinon.
                                      }

                                      public DecodedImage getDecodedImage() {
                                        return decodedImage;
                                      }
                                    }

                                    class JpegReader implements ImageReader {
                                      //... même principe

                                    }
*/
//**********************************************************************************************************************
//                    Chaque fois que le programme lit une image, il doit créer le lecteur adapté à partir
//                    d'informations trouvées dans le fichier. Cette partie peut être encapsulée dans une
//                    méthode de fabrication :
//**********************************************************************************************************************
/*
                                  class ImageReaderFactory {
                                    public static ImageReader getImageReader(InputStream is) {
                                      int imageType = figureOutImageType(is);

                                      switch (imageType) {
                                        case ImageReaderFactory.GIF:
                                          return new GifReader(is);
                                        case ImageReaderFactory.JPEG:
                                          return new JpegReader(is);
                                        // etc.
                                      }
                                    }
                                  }

 */
//Le type d'image et le lecteur correspondant peuvent ici être stockés dans un tableau associatif, ce qui évite
// la structure switch et donne une fabrique facilement extensible.
//osea guardarlos en un tableau y verificar con los elementos que ponemos en el tab Gif JPEG etc
