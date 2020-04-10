package i_poo.v_design_patterns.A_Modelos_de_Creation.II_abstract_factory.ejemplo_1;

public class T_MiClasse {
  //metodo static de mi creacion crea una instancia de la clase ProduitFactory1 y retorna el metodo de esta clase que da un objeto ProduitA
  //asi en el main no necesitamos crear un objeto de tipo ProduitFactory1 pa poder usar su metodo sino que defrente
  //podemos llamar a la clase y utilisar este metodo estatico que automaticamente creara un objeto de su misma clase y retornara
  //un objeto de tipo ProduitA gracias al metodo que ta dentro
  public static ProduitA giveProduitA() {
    ProduitFactory1 hola=new ProduitFactory1();
    return hola.getProduitA();
  }
  public static ProduitB giveProduitB() {
    ProduitFactory2 hola=new ProduitFactory2();
    return hola.getProduitB();
  }
}
