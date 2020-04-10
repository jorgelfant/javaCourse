package i_poo.v_design_patterns.C_Modelos_de_Comportamiento.X_Strategy;

import java.util.Random;

public class Exemple_I {
  public static void main(String[] args) {
    // notre acteur
    SeigneurDeLaGuerre kevin = new SeigneurDeLaGuerre();

    // les aléas du système
    Random ram = new Random();
    Meteo[] tabMeteo = Meteo.values();
    Meteo meteo = tabMeteo[ram.nextInt(tabMeteo.length)];

    // une liaison tardive
    switch (meteo) {
      case IlFaitBeau:
        kevin.Strategie(new DefoncerLePontLevisDeFace());
        break;

      case IlYADuBrouillard:
        kevin.Strategie(new PasserParLaFaceNord());
        break;

      case IlFaitTropChaudPourTravailler:
        kevin.Strategie(new AttendreQueLaVilleSeRende());
        break;

      case IlPleut:
        kevin.Strategie(new SeMarierAvecLaCousineDuDuc());
        break;

      default:
        try {
          throw new Exception("Nan finalement seigneur de la guerre c'est " + "pas cool comme job : vous décidez d'aller élever "
            + "des chèvres dans le Larzac.");
        } catch (Exception e) {
          e.printStackTrace();
        }
    }

    // une exécution aux petits oignons
    kevin.PrendreLaVille();
  }
}

//======================================================================================================================
//                  Changer dynamiquement de stratégie (algorithme) selon le contexte
//======================================================================================================================
/*
Le patron stratégie est un patron de conception de type comportemental grâce auquel des algorithmes peuvent
être sélectionnés à la volée au cours de l'exécution selon certaines conditions, comme les stratégies utilisées
en temps de guerre.

Le patron de conception stratégie est utile pour des situations où il est nécessaire de permuter dynamiquement
les algorithmes utilisés dans une application. Le patron stratégie est prévu pour fournir des moyens de définir
une famille d'algorithmes, encapsuler chacun comme objet, et les rendre interchangeables. Le patron stratégie
laisse les algorithmes changer indépendamment des clients qui les emploient.
*/
//======================================================================================================================
//                                             Utilisation
//======================================================================================================================
//Dès lors qu'un objet peut effectuer plusieurs traitements différents, dépendant d'une variable ou d'un état.
/// <summary> La manière dont le grand général guidera ses troupes </summary>
interface IStrategie {
  void MettreEnOeuvre();
}

//==========================================================================
/// <summary> Ce grand homme qui fera bientôt des choix décisifs </summary>
class SeigneurDeLaGuerre {
  /// <summary> une stratégie générique </summary>
  private IStrategie _strategie;

  /// <summary> comment changer de stratégie </summary>
  public void Strategie(IStrategie value) {
    this._strategie = value;
  }

  /// <summary> délégation de la tâche </summary>
  public void PrendreLaVille() {
    _strategie.MettreEnOeuvre();
  }
}

//==========================================================================
class DefoncerLePontLevisDeFace implements IStrategie {
  public void MettreEnOeuvre() {
    System.out.println("Prendre la ville de face en défonçant le pont levis.");
  }
}

//==========================================================================
class PasserParLaFaceNord implements IStrategie {
  public void MettreEnOeuvre() {
    System.out.println("Prendre la ville en escaladant la muraille nord.");
  }
}

//==========================================================================
class AttendreQueLaVilleSeRende implements IStrategie {
  public void MettreEnOeuvre() {
    System.out.println("Attendre qu'il n'y ait plus rien à manger en ville " + "et que tout le monde meure de faim.");
  }
}

//==========================================================================
class SeMarierAvecLaCousineDuDuc implements IStrategie {
  public void MettreEnOeuvre() {
    System.out.println("Organiser un mariage avec la cousine du Duc " + "alors qu'elle rejoint la ville de retour des baléares "
      + "et inviter toute la ville à une grande fête.");
  }
}

//==========================================================================
/// <summary> Différentes situations </summary>
enum Meteo {
  IlFaitBeau,
  IlYADuBrouillard,
  IlFaitTropChaudPourTravailler,
  IlPleut
}
