package i_poo.v_design_patterns.A_Modelos_de_Creation.III_Builder_Fluent.ejemplo_9_builder_fluent_command_monteur;

public class Main {
  public static void main(String[] args) {
    //En théorie, si l’on voulait réaliser un builder  remplissant à la fois le rôle et la définition du Gang Of Four,
    // on aboutirait à ceci :
    //
    //  new Director(new KayakBuilder(), new LicenseBuilder()).withOwnerName("Tintin").build();
  }
}
/*
class Boat{
  Human captain;
  Propulsion propulsion;
  License licenseOwner;
}


class LicenceBuilder{
  License buildPartLicense(Boat boat, String ownerName){
    boat.setLicenseOwner(licenseService.find(ownerName));

  };
}


abstract class AbstractBoatBuilder<TBoat extends Boat>{
  abstract TBoat buildPartHull();
  abstract void buildPartPropulsion(TBoat boat);
  void buildAdministration(TBoat boat){
    if(boat.getOwnerLicense()!=null){
      boat.setCaptain(boat.getOwnerLicense().getNavigator());
      boad.setAuthorizedToNavigate(true);

    }
  };
}

class BoatDirector{
  AbstractBoatBuilder boatBuilder;
  LicenseBuilder licenseBuilder;

  BoatDirector(AbstractBoatBuilder boatBuilder, LicenseBuilder licenseBuilder){
    this.builder = builder;
    this.licenseBuilder = licenseBuilder;
  }

  String ownerName;
  BoatDirector withOwnerName(String ownerName){
    this.ownerName = ownerName;
    return this;
  }
  public Boat build(){
    Boat boat = builder.buildPartHull();
    builder.buildPartPropulsion(boat);
    licenseBuilder.buildPartLicense(boat, ownerName);
    boatBuilder.buildPartAdministation(boat);
    return boat;
  }
}

class Kayak extends Boat{

}

class KayakBuilder extends AbstractBuilder<Kayak>{

  Boat buildPartHull(){
    return new Kayak();
  };
  void buildPartPropulsion(Boat boat){
    boat.setPropulsion(new Paddle());
  }
}
*/
//**********************************************************************************************************************
//                      Pourquoi ne l’utilise-t-on pas toujours (voir pas du tout) ?
//**********************************************************************************************************************
/*
L’inconvénient de ce design est qu’il devient rapidement très volumineux, et rajoute des complexités pas toujours
justifiées: en effet suivant les cas, on n’aura pas besoin d’une construction ordonnée, de traitements complexes,
de différentes implémentations du(des) builder(s), voir même d’injecter des paramètres. Il peut alors être pertinent
d’utiliser une version « plus souple », allégée du design pattern builder.
*/
