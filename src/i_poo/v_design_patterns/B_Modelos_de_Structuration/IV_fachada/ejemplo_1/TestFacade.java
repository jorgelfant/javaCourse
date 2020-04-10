package i_poo.v_design_patterns.B_Modelos_de_Structuration.IV_fachada.ejemplo_1;

public class TestFacade {
  ClasseA classeA;
  ClasseB classeB;
  ClasseC classeC;
  ClasseD classeD;

  public TestFacade() {
    classeA = new ClasseA();
    classeB = new ClasseB();
    classeC = new ClasseC();
    classeD = new ClasseD();
  }

  public void methode1() {
    System.out.println("Methode1 : ");
    classeA.methodeA();
    classeD.methodeD();
    classeC.methodeC();
  }

  public void methode2() {
    System.out.println("Methode2 : ");
    classeB.methodeB();
    classeC.methodeC();
  }
}
