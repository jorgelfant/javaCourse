package i_poo.v_UML;

public class Voiture_2 {
  public static void main(String[] args) {
    VehiculoMejorado auto = new VehiculoMejorado(new Camioneta(2,5));

    System.out.println(auto.getRueda());
    System.out.println(auto.getCapacite());
    System.out.println(auto.getPlaza());
    System.out.println(auto);
  }
}


//**********************************************************************************************************************

final class Rueda {
  private int rueda;

  public Rueda(int rueda) {
    this.rueda = rueda;
  }

  public int getRueda() {
    return rueda;
  }
}

final class Puerta {
  private int puerta;

  public Puerta(int puerta) {
    this.puerta = puerta;
  }

  public int getPuerta() {
    return puerta;
  }
}

final class Puissance {
  private int puissance;

  public Puissance(int puissance) {
    this.puissance = puissance;
  }

  public int getPuissance() {
    return puissance;
  }
}

final class Plaza {
  private int plaza;

  public Plaza(int plaza) {
    this.plaza = plaza;
  }

  public int getPlaza() {
    return plaza;
  }
}

final class Capacite {
  private int capacite;

  public Capacite(int capacite) {
    this.capacite = capacite;
  }

  public int getCapacite() {
    return capacite;
  }
}

final class Prix {
  private int prix;

  public Prix(int prix) {
    this.prix = prix;
  }

  public int getPrix() {
    return prix;
  }
}

enum Color {
  RED, BLUE, BLACK, WHITE
}

//**********************************************************************************************************************
class VehiculoBasico {
  private final Rueda rueda;
  private final Puerta puerta;
  private final Puissance puissance;
  private final Prix prix;
  private final Color color;
  private final Plaza plaza;
  private final Capacite capacite;

  // private boolean siegesCuire, climatisation;

  public VehiculoBasico() {
    this.rueda = new Rueda(4);
    this.puerta = new Puerta(2);
    this.puissance = new Puissance(1000);
    this.color = Color.WHITE;
    this.prix = new Prix(0);
    this.plaza = new Plaza(4);
    this.capacite = new Capacite(5);
  }

  public int getRueda() {
    return rueda.getRueda();
  }

  public int getPuerta() {
    return puerta.getPuerta();
  }

  public int getPuissance() {
    return puissance.getPuissance();
  }

  public Color getColor() {
    return color;
  }

  public int getPrix() {
    return prix.getPrix();
  }

  public int getPlaza() {
    return plaza.getPlaza();
  }

  public int getCapacite() {
    return capacite.getCapacite();
  }
}

//**********************************************************************************************************************
class VehiculoMejorado {
  private final VehiculoBasico vehiculoBasico;
  private final Extra extra;

  public VehiculoMejorado(Extra extra) {
    vehiculoBasico = new VehiculoBasico();
    this.extra = extra;
  }

  public int getRueda() {
    return vehiculoBasico.getRueda() + extra.getRoues_extra();
  }

  public int getPuerta() {
    return vehiculoBasico.getPuerta();
  }

  public int getPuissance() {
    return vehiculoBasico.getPuissance();
  }

  public Color getColor() {
    return vehiculoBasico.getColor();
  }

  public int getPrix() {
    return vehiculoBasico.getPrix();
  }

  public int getPlaza() {
    return vehiculoBasico.getPlaza() + extra.getPlazas_extra();
  }

  public int getCapacite() {
    return vehiculoBasico.getCapacite() + extra.getCapacidad_extra();
  }


  public Extra getExtra() {
    return extra;
  }

  @Override
  public String toString() {
    return this.getRueda() + ", " + this.getPuerta() + ", " + this.getPuissance() + ", " + this.getPuissance() + ", " + this.getColor() + ", " + this.getExtra();
  }
}
//**********************************************************************************************************************

interface Extra {
  public int getCapacidad_extra();

  public int getPlazas_extra();

  public int getRoues_extra();
}

//**********************************************************************************************************************
class Camioneta implements Extra {
  private int capacidad_extra;
  private int plazas_extra;

  public Camioneta(int capacidad_extra, int plazas_extra) {
    this.capacidad_extra = capacidad_extra;
    this.plazas_extra = plazas_extra;
  }

  public int getCapacidad_extra() {
    return capacidad_extra;
  }

  public int getPlazas_extra() {
    return plazas_extra;
  }

  public int getRoues_extra() {
    return 0;
  }

  @Override
  public String toString() {
    return this.capacidad_extra + " " + this.plazas_extra;
  }
}
//**********************************************************************************************************************

class Camion implements Extra {
  private int roues_extra;

  public Camion(int roues_extra) {
    this.roues_extra = roues_extra;
  }

  public int getRoues_extra() {
    return roues_extra;
  }

  public int getCapacidad_extra() {
    return 0;
  }

  public int getPlazas_extra() {
    return 0;
  }

  @Override
  public String toString() {
    return this.roues_extra + " ";
  }
}


