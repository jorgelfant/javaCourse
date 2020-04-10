package i_poo.v_design_patterns.G_Autres_Patrons;

public class VI_Copy_On_Write {
}
//======================================================================================================================
//             Retarder la création d'une copie privée d'une structure tant qu'elle n'est pas modifiée
//======================================================================================================================
/*
Copie sur modification

Avantage : Gagner de l'espace mémoire
=====================================

Quand plusieurs processus (légers ou non), ou classes peuvent demander des ressources impossibles à distinguer
initialement, il suffit de leur donner un pointeur commun en mémoire sur la ressource, au lieu de leur créer une
copie privée. Au moment ou un processus ou une classe modifie la ressource, une copie privée est créée.

Le patron de conception copie sur modification est une forme d'évaluation retardée.

*/
