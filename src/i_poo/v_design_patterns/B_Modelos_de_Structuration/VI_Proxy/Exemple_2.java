package i_poo.v_design_patterns.B_Modelos_de_Structuration.VI_Proxy;

public class Exemple_2 {
  public static void main(String[] args) {
//======================================================================================================================
//                         3) Use the ProxyImage to get object of RealImage class when required.
//======================================================================================================================
    Imagee image = new ProxyImagee("test_10mb.jpg");

    //image will be loaded from disk
    image.display();
    System.out.println("");

    //image will not be loaded from disk
    image.display();

    /*RESULTADO
    Loading test_10mb.jpg
    Displaying test_10mb.jpg

    Displaying test_10mb.jpg
    */
  }
}
    /*
    In proxy pattern, a class represents functionality of another class. This type of design pattern comes
    under structural pattern.

    In proxy pattern, we create object having original object to interface its functionality to outer world.
    */
//======================================================================================================================
//                                           1) Implementation
//======================================================================================================================
/*
 We are going to create an Image interface and concrete classes implementing the Image interface. ProxyImage is a a
 proxy class to reduce memory footprint of RealImage object loading.

 ProxyPatternDemo, our demo class, will use ProxyImage to get an Image object to load and display as it needs.

                                      <<nterface>>
                                ----------------------
                                |        Image       |
                                ----------------------
                                |                    |
                                ----------------------
                                | + display() : void |
                                ----------------------
                                          /\
                                          |
                                          |implements
                ----------------------------------------------------
                |                                                  |
      --------------------------                         --------------------------           -------------------------
      |       RealImage        |                         |     ProxyImage         |          |          Main          |
      --------------------------                         --------------------------          --------------------------
      | + fileName : String    |                         | + realImage: RealImage |   asks   |                        |
      --------------------------                         | +fileName : String     | <--------|                        |
      | + RealImage()          |                         --------------------------          |  +main() : void        |
      | + display() : void     |                         | + ProxyImage()         |          |                        |
      | +loadFromDisk() : void |                         | +display() : void      |          |                        |
      --------------------------                         --------------------------          --------------------------
*/

//======================================================================================================================
//                                         Create an interface.
//======================================================================================================================
 interface Imagee {
  void display();
}

//======================================================================================================================
//                         2) Create concrete classes implementing the same interface.
//======================================================================================================================
 class RealImagee implements Imagee {

  private String fileName;

  public RealImagee(String fileName){
    this.fileName = fileName;
    loadFromDisk(fileName);
  }

  @Override
  public void display() {
    System.out.println("Displaying " + fileName);
  }

  private void loadFromDisk(String fileName){
    System.out.println("Loading " + fileName);
  }
}
//***************************************************

class ProxyImagee implements Imagee {

 private RealImagee realImage;
 private String fileName;

 public ProxyImagee(String fileName){
   this.fileName = fileName;
 }

 @Override
 public void display() {
   if(realImage == null){
     realImage = new RealImagee(fileName);
   }
   realImage.display();
 }
}
