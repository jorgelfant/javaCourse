package i_poo.v_design_patterns.A_Modelos_de_Creation.III_Builder_Fluent.ejemplo_5_Pattern_Command;

public class Main {
  public static void main(String[] args) {
    //******************************************************************************************************************
    //                                       Le design pattern command
    //******************************************************************************************************************
    /*
    Il s’agit en fait d’un design pattern command, dont la méthode void execute() a été sournoisement transformée en build().
    Le rôle du design pattern command est en effet très similaire à celui du pattern builder :
    « Encapsuler toutes les informations nécessaires pour effectuer une action séparément à une date ultérieure«


    //******************************************************************************************************************
    //                         Cas particulier : les classes tiers et le inner-builder command
    //******************************************************************************************************************

    Si votre builder-command doit faire appel à des classes services tiers, il peut-être nécessaire d’en faire
    une inner-class d’une classe service
 */
  }
}
/*
                          class Human {
                            String owner;

                            public Human(String owner) {
                              this.owner = owner;
                            }
                          }

                          class Boat {
                            Human captain;
                            //...
                          }

                          //outer class
                          class BoatService {
                            @Autowired
                            Dao dao;

                            //inner class
                            class BoatBuilder {
                              //...
                              Boat build() {
                                //...
                                //l'inner classe accès aux attribut de l'outer class
                                boat.setCaptain(dao.findHuman(ownerName));
                                return boat;
                              }
                            }

                            Boat buildBoat(String ownerName) {
                              return new BoatBuilder().withOwnerName("Hadock").build();
                            }

                            Boat buildBoatWithoutCaptain(String ownerName) {
                              return new BoatBuilder().build();
                            }
                          }
*/
