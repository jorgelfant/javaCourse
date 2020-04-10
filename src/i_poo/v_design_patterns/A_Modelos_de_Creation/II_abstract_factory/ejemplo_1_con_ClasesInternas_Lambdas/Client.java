package i_poo.v_design_patterns.A_Modelos_de_Creation.II_abstract_factory.ejemplo_1_con_ClasesInternas_Lambdas;

public class Client {
  public static void main(String[] args) {
    //******************************************************************************************************************
    //                          ProduitA1 / ProduitB1 / ProduitA2 / ProduitB2  Con LAMBDAS
    //******************************************************************************************************************
    //Lambdas , Interfacec avec une seule methode abstrat
    //aqui desarollo ese unico metodo abstracto de 2 maneras diferentes
    ProduitA ProduitA1 = () -> System.out.println("ProduitA1.methodeA()");//como si la classe ProduitA1 existiera
    ProduitA ProduitA2 = () -> System.out.println("ProduitA2.methodeA()");//como si la classe ProduitA1 existiera

    ProduitB ProduitB1 = () -> System.out.println("ProduitB1.methodeB()");//como si la classe ProduitB1 existiera
    ProduitB ProduitB2 = () -> System.out.println("ProduitB2.methodeB()");//como si la classe ProduitB2 existiera

    //******************************************************************************************************************
    //                          ProduitFactory1 y ProduitFactory2  Con clases internas
    //******************************************************************************************************************
    //SOlo se pueden usar lambas cuando la interface solo tiene un metodo abstracto, INTERFACE FONCTIONNELLE
    //como nuestro ejemplo tiene 2 metodos abstractos, mejor usar clases internas
    ProduitFactory produitFactory1 = new ProduitFactory() {
      @Override
      public ProduitA getProduitA() {
        return  ProduitA1;
      }
      @Override
      public ProduitB getProduitB() {
        return ProduitB1;
      }
    };
    //******************************************************************************************************************
    ProduitFactory produitFactory2 = new ProduitFactory() {
      @Override
      public ProduitA getProduitA() {
        return  ProduitA2;
      }
      @Override
      public ProduitB getProduitB() {
        return  ProduitB2;
      }
    };
    //en lugar de crear ProduitA1 etc y llenarlo con produitFactory1.getProduitA() pa luego usar el metodo, puedo hacer solo esto
    //resumir
    System.out.println("Utilisation de la premiere fabrique");
    produitFactory1.getProduitA().methodeA();
    produitFactory1.getProduitB().methodeB();

    System.out.println("Utilisation de la seconde fabrique");
    produitFactory2.getProduitA().methodeA();
    produitFactory2.getProduitB().methodeB();

   //Une fabrique concrète est généralement un singleton.

  }
}
























