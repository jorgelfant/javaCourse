package i_poo.v_design_patterns.B_Modelos_de_Structuration.VIII_Pattern_decorator.ejemplo_1;

public class CoucheBiscuit extends Couche {
  public CoucheBiscuit(Patisserie pat) {
    super(pat);
    this.nom = "\t- une couche de biscuit.\n";
  }
}
