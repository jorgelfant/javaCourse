package i_poo.v_design_patterns.A_Modelos_de_Creation.II_abstract_factory.ejemplo_1;

public class ProduitFactory1 extends T_MiClasse implements ProduitFactory {

  public ProduitA getProduitA() {
    return new ProduitA1();
  }

  public ProduitB getProduitB() {
    return new ProduitB1();
  }
}
