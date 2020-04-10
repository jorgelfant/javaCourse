package i_poo.v_design_patterns.A_Modelos_de_Creation.III_Bilder_Monteur;

public class Utilisation_Builder {
  /*
  Complexité des paramètres |                                   | Peu de paramètres, mais beaucoup  | Peu de paramètres, Peu de
            VS              | Beaucoup de paramètres            | de combinaisons possibles ou      | combinaisons possibles et
  Complexité du code        |                                   | présence de paramètres optionnels | pas d'optionnels
  ----------------------------------------------------------------------------------------------------------------------
  Beacoup d'étapes,         | Builder-Monteur-command-fluent    | Builder-Monteur-command-fluent,   | . Si plusieurs
  construction complexe     | avec les classes Director et      | avec le Builder et les Director   |   implementations
                            | le(les)  Builder distinctes dans  | fusionnés, mais conserver         |   différentes ou
                            | des fichiers à part               | plusieurs méthodes partBuild      |   inconnues:
                            |                                   | distinctes                        |   ABSTRACT FACTORY
                            |                                   |                                   |
                            |                                   |                                   | . Sinon: Factory
                            |                                   |                                   |   Ne pas hésiter
                            |                                   |                                   |   à recourir aux
                            |                                   |                                   |   méthodes privées
                            |                                   |                                   |   si le besoin
                            |                                   |                                   |   se fait sentir
  ----------------------------------------------------------------------------------------------------------------------
   Appels à des classes     |
   tiers                    |        Inner Builder-Command en classe tiers
                            |
  ----------------------------------------------------------------------------------------------------------------------
  Peu de complexité, pas    |                                    |
  d'appels à des classes    |        Builder-command normal      |                    Constructor
  tiers                     |                                    |
  ---------------------------------------------------------------|
  Aucune complexité         |                                    |
  (Recopie exacte des       |                                    |
   attributs du builder     |        Builder-fluent              |
   dans l'objet produit)    |                                    |


  */
}
