package i_poo.l_interface.animal_con_interface_Rintintin;

public class Teorie {
    /*------------------------------------------------------------------------------------------------------------------
    Admettons que l'architecture que nous avons développée dans les chapitres précédents forme une bonne base.
    Que se passerait-il si un autre développeur vous demandait d'utiliser vos objets dans un autre type d'application ?
    Ici, nous ne nous sommes occupés que de l'aspect générique des animaux que nous avons créés. Cependant, la personne
    qui vous a contacté, elle, développe une application pour un chenil.

    La contrainte principale, c'est que vos chiens devront apprendre à faire de nouvelles choses telles que :
    .faire le beau ;
    .faire des câlins ;
    .faire une « léchouille ».

    *Je ne vois pas le problème… Tu n'as qu'à ajouter ces méthodes dans la classeAnimal! ???
    *
    ------------------------------------------------------------------------------------------------------------------*/

    /*------------------------------------------------------------------------------------------------------------------
    Ouh là ! Vous vous rendez compte que vous obtiendrez des lions qui auront la possibilité de faire le beau ?
    Dans ce cas, on n'a qu'à mettre ces méthodes dans la classeChien, mais j'y vois deux problèmes :

    1.vous allez devoir mettre en place une convention de nommage entre le programmeur qui va utiliser vos objets et vous.
    Vous ne pourrez pas utiliser la méthodefaireCalin(), alors que le programmeur oui ;

    2.si vous faites cela, adieu au
    polymorphisme ! Vous ne pourrez pas appeler vos objets par le biais d'un supertype. Pour pouvoir accéder à ces
    méthodes, vous devrez obligatoirement passer par une référence à un objetChien. Pas terrible, tout ça !
    ------------------------------------------------------------------------------------------------------------------*/

    /*------------------------------------------------------------------------------------------------------------------
    Tu nous as dit que pour utiliser au mieux le polymorphisme, nous devions définir les méthodes au plus haut niveau
    de la hiérarchie. Alors du coup, il faut redéfinir un supertype pour pouvoir utiliser le polymorphisme !
    ------------------------------------------------------------------------------------------------------------------*/
    /*------------------------------------------------------------------------------------------------------------------
    Oui, et je vous rappelle que l'héritage multiple est interdit en Java. Et quand je dis interdit, je veux dire que
    Java ne le gère pas ! Il faudrait pouvoir développer un nouveau supertype et s'en servir dans nos classesChien.
    Eh bien nous pouvons faire cela avec des interfaces.

    En fait, les interfaces permettent de créer un nouveau supertype ; on peut même en ajouter autant que l'on le veut
    dans une seule classe ! Quant à l'utilisation de nos objets, la convention est toute trouvée. Pourquoi ?
    Parce qu'une interface n'est rien d'autre qu'une classe 100 % abstraite ! Allez : venons-en aux faits !
    ------------------------------------------------------------------------------------------------------------------*/


}
