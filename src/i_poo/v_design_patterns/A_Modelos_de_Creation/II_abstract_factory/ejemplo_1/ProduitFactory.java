package i_poo.v_design_patterns.A_Modelos_de_Creation.II_abstract_factory.ejemplo_1;

public interface ProduitFactory {
  ProduitA getProduitA();
  ProduitB getProduitB();

  /*estos 2 metodos de mi creacion crean un ProduitFactory que se retornan un ProduitFactory que ya en el main podriamos cast
    ya que dentro del primero hay un ProduitFactory1 y dentro del segundo un ProduitFactory2

  public static ProduitA giveProduitA() {
    ProduitFactory hola=new ProduitFactory1();
    return hola.getProduitA();
  }
  public static ProduitB giveProduitB() {
    ProduitFactory hola=new ProduitFactory2();
    return hola.getProduitB();
  }
  */

}
