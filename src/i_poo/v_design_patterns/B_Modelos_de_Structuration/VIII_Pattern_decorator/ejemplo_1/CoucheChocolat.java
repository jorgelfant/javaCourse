package i_poo.v_design_patterns.B_Modelos_de_Structuration.VIII_Pattern_decorator.ejemplo_1;

public class CoucheChocolat extends Couche {
  public CoucheChocolat(Patisserie pat) {
    super(pat);
    this.nom = "\t- une couche de chocolat.\n";
  }
}
