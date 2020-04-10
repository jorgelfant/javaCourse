package i_poo.i_packages;//declaration du package

public class principal {
    public static void main(String[] args) {
        /*
        Les packages
Lorsque nous avons été confrontés pour la première fois aux packages, c'était pour importer la classe Scanner via
l'instruction import java.util.Scanner;. Le fonctionnement des packages est simple à comprendre : ce sont comme
des dossiers permettant de ranger nos classes. Charger un package nous permet d'utiliser les classes qu'il contient.

Il n'y aura rien de franchement compliqué dans ce chapitre si ce n'est que nous reparlerons un peu de la portée
des classes Java.

Il existe aussi une convention de nommage pour les packages :

.ceux-ci doivent être écrits entièrement en minuscules ;

.les caractères autorisés sont alphanumériques (de a à v_design_patterns, de 0 à 9) et peuvent contenir des points (.) ;

.tout package doit commencer par com, edu, gov, mil, net, org ou les deux lettres identifiant un pays (ISO Standard 3166, 1981) ;
« fr » correspond à la France, « en » correspond à l'Angleterre (pour England)etc.

aucun mot clé Java ne doit être présent dans le nom, sauf si vous le faites suivre d'un underscore (« _ »), comme ceci : com.sdz.package_.

Comme ce cours est issu du Site du Zéro, j'ai pris le nom à l'envers : « sdz.com » nous donne « com.sdz ». Pour le cas
qui nous occupe, appelons-le com.sdz.A. Cliquez sur Finish pour créer le package. Et voilà : celui-ci est prêt à
l'emploi.

Je vous invite à aller voir dans le dossier où se trouvent vos codes sources : vous constaterez qu'il y a l'arborescence
du dossier com/sdz/A dans votre dossier src.

Vous conviendrez que la création d'un package est très simple. Cependant, je ne peux pas vous laisser sans savoir que
la portée de vos classes est affectée par les packages…

//----------------------------------------------------------------------------------------------------------------------
//                         DROITS D'ACCES DANS LES PACKAGES
//----------------------------------------------------------------------------------------------------------------------

 Lorsque vous avez créé votre première classe, vous avez vu qu'Eclipse met systématiquement le mot clé public devant
 la déclaration de la classe. Je vous avais alors dit que public class Ville et class Ville étaient sensiblement
 différents et que le mot clé public influait sur la portée de notre classe. En fait, une classe déclarée avec le
 mot clé public sera visible même à l'extérieur de son package, les autres ne seront accessibles que depuis l'intérieur
 du package : on dit que leur portée est default.

 Afin de vous prouver mes dires, je vous invite à créer un second package : je l'ai appelé « com.sdz.test2 ».
 Dans le premier package, com.sdz.A, créez une classe A de portée public et une classe B de portée default,
 comme ceci (j'ai volontairement déclaré les variables d'instance public afin d'alléger l'exemple) :


        Vous aurez remarqué que les classes contenues dans un package ont en toute première instruction la déclaration
        de ce package.

        Maintenant que cela est fait, afin de faire le test, créez une classe contenant la méthode principal,
        toujours dans le même package
        */
    }

}
