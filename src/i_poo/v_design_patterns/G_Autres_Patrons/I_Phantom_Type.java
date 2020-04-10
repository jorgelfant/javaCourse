package i_poo.v_design_patterns.G_Autres_Patrons;

public class I_Phantom_Type <V> {

  // Types fantômes utilisés pour marquer les méthodes
  // dont les appels seront vérifiés à la compilation.
  public static interface ReadOnly {
  }

  public static interface WriteOnly {
  }

  public static interface ReadWrite extends ReadOnly, WriteOnly {
  }
  // Des interfaces sont utilisées au lieu de classes afin que
  // ReadWrite hérite des deux types précédents.

  private String name;

  private I_Phantom_Type(String s) {
    this.name = s;
  }

  public static I_Phantom_Type<ReadWrite> pname(String s) {
    return new I_Phantom_Type<ReadWrite>(s);
  }

  public static I_Phantom_Type<ReadOnly> readOnly(String s) {
    return new I_Phantom_Type<ReadOnly>(s);
  }

  public static I_Phantom_Type<WriteOnly> readWrite(String s) {
    return new I_Phantom_Type<WriteOnly>(s);
  }

  // Opérations de conversion
  @SuppressWarnings("unchecked")
  public static I_Phantom_Type<ReadOnly> readable(I_Phantom_Type<? extends ReadOnly> pname) {
    return (I_Phantom_Type<ReadOnly>) pname;
  }

  @SuppressWarnings("unchecked")
  public static I_Phantom_Type<WriteOnly> writeable(I_Phantom_Type<? extends WriteOnly> pname) {
    return (I_Phantom_Type<WriteOnly>) pname;
  }

  // Opérations de lecture et d'écriture
  public static String get(I_Phantom_Type<? extends ReadOnly> pname) {
    return pname.name;
  }

  public static void set(I_Phantom_Type<? extends WriteOnly> pname, String v) {
    pname.name = v;
  }

  public static void main(String[] args) {
    // Nom en lecture et écriture
    I_Phantom_Type<ReadWrite> rw = pname("Test");
    System.out.println(get(rw));       // Lecture OK
    set(rw, "Exemple");                 // Écriture OK
    System.out.println(get(rw));       // Lecture OK

    // Version en lecture seule
    I_Phantom_Type<ReadOnly> ro = readable(rw);
    System.out.println(get(ro));       // Lecture OK
    //set(ro,"Autre");                 // Écriture --> erreur à la compilation

    // Version en écriture seule
    I_Phantom_Type<WriteOnly> wo = writeable(rw);
    set(wo, "Modification");            // Écriture OK
    //get(wo);                         // Lecture --> erreur à la compilation
  }
}

//======================================================================================================================
//              Utiliser un type pour détecter des erreurs plutôt que pour ses valeurs possibles
//======================================================================================================================
/*
En général, un type de données est créé afin de pouvoir utiliser ses valeurs possibles.

Un type fantôme n'est utilisé que pour ajouter une contrainte qui puisse être vérifiée à la compilation.
Cette fonctionnalité est utilisable avec la programmation fonctionnelle et également la programmation orientée objet
en utilisant les templates ou types génériques.

Les types ReadOnly, WriteOnly et ReadWrite sont des types fantômes (aucune instance existante)
utilisés uniquement pour marquer le type PName et que le compilateur puisse effectuer les vérifications.

*/


