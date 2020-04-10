package i_poo.v_design_patterns.B_Modelos_de_Structuration.VII_Flyweight;

import java.awt.*;
import java.lang.ref.WeakReference;
import java.util.Collections;
import java.util.EnumSet;
import java.util.Set;
import java.util.WeakHashMap;

public class Exemple_1 {
  public static void main(String[] args) {


  }
}
//==================================================================================================================
//                                      Flyweight Pattern (Poids-mouche)
//==================================================================================================================

//Réduire le nombre d'objets à instancier
    /*
    Le poids-mouche est un patron de conception structurel.

    Lorsque de nombreux (petits) objets doivent être manipulés, mais qu'il serait trop coûteux en mémoire
    s'il fallait instancier tous ces objets, il est judicieux d'implémenter le poids-mouche.

    Dans le cas d'une classe représentant des données, il est parfois possible de réduire le nombre d'objets
    à instancier si tous ces objets sont semblables et se différencient sur quelques paramètres. Si ces quelques
    paramètres peuvent être extraits de la classe et les passer ensuite via des paramètres des méthodes, on peut
    réduire grandement le nombre d'objets à instancier.

    Le patron poids-mouche est l'approche pour utiliser de telles classes. D'une part la classe avec ses données
    internes qui la rendent unique, et d'autre part les données externes passées à la classe en tant qu'arguments.
    Ce modèle est très pratique pour des petites classes très simples. Par exemple pour représenter des caractères
    ou des icônes à l'écran, ce type de patron de conception est apprécié. Ainsi, chaque caractère peut être
    représenté par une instance d'une classe contenant sa police, sa taille, etc. La position des caractères à
    afficher est stockée en dehors de cette classe. Ainsi, on a une et une seule instance de la classe par caractère
    et non une instance par caractère affiché à l'écran.

    Dans le patron poids-mouche, les données n'ont pas de pointeurs vers les méthodes du type de données, parce que
    cela consommerait trop d'espace mémoire. À la place, les routines sont appelées directement.

    Un exemple classique du patron poids-mouche : les caractères manipulés dans un traitement de texte. Chaque
    caractère correspond à un objet ayant une police de caractères, une taille de caractères, et d'autres données
    de formatage. Un long document contient beaucoup de caractères ainsi implémentés…
    */

//==================================================================================================================
//                                          Exemple
//==================================================================================================================
/*
  Le programme Java suivant illustre l'exemple du document de traitement de texte donné ci-dessus : les « mouches »
  sont appelées FontData dans le programme.

  Cet exemple illustre l'utilisation du poids-mouche pour réduire la mémoire allouée en chargeant seulement les
  données nécessaires pour faire quelques tâches immédiates à partir d'un grand objet Font en utilisant de plus
  petits objets FontData.
*/
enum FontEffect {
  BOLD, ITALIC, SUPERSCRIPT, SUBSCRIPT, STRIKETHROUGH
}
//****************************************************************************

final class FontData {
  /**
   * Une table de hachage faible (weak) supprime les FontData non utilisés.
   * Les valeurs doivent être encapsulées dans des WeakReferences car dans
   * la table de hachage,les valeurs sont stockées avec des références fortes.
   */
  private static final WeakHashMap<FontData, WeakReference<FontData>> FLY_WEIGHT_DATA = new WeakHashMap<FontData, WeakReference<FontData>>();

  private final int pointSize;
  private final String fontFace;
  private final Color color;
  private final Set<FontEffect> effects;

  private FontData(int pointSize, String fontFace, Color color, EnumSet<FontEffect> effects) {
    this.pointSize = pointSize;
    this.fontFace = fontFace;
    this.color = color;
    this.effects = Collections.unmodifiableSet(effects);
  }

  public static FontData create(int pointSize, String fontFace, Color color, FontEffect... effects) {

    EnumSet<FontEffect> effectsSet = EnumSet.noneOf(FontEffect.class);
    for (FontEffect fontEffect : effects) {
      effectsSet.add(fontEffect);
    }
    // seule la réduction de la quantité de mémoire occupée nous préoccupe,
    // pas le coût de création de l'objet
    FontData data = new FontData(pointSize, fontFace, color, effectsSet);
    if (!FLY_WEIGHT_DATA.containsKey(data)) {
      FLY_WEIGHT_DATA.put(data, new WeakReference<FontData>(data));
    }
    // retourner l'unique copie non modifiable avec les données spécifiées
    return FLY_WEIGHT_DATA.get(data).get();
  }

  @Override
  public boolean equals(Object obj) {
    if (obj instanceof FontData) {
      if (obj == this) {
        return true;
      }
      FontData other = (FontData) obj;
      return other.pointSize == pointSize && other.fontFace.equals(fontFace)
        && other.color.equals(color) && other.effects.equals(effects);
    }
    return false;
  }

  @Override
  public int hashCode() {
    return (pointSize * 37 + effects.hashCode() * 13) * fontFace.hashCode();
  }

  // Accesseurs de lecture, mais pas en écriture (objet non modifiable)
}
