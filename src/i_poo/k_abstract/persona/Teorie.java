package i_poo.k_abstract.persona;

public class Teorie {

        //CLASS ABSTRACT
        //on a la classe Employé et ensuite la classe Chef, imaginos que l'on continue d'étendre cet héritage vers le bas,
        //quelque chose que l'on n'a pas encore fait mais imaginons qu'en dessous de cette classe Chef, nous avons une
        // classe Directeur

        /*
                                            ****      PERSONA    ******
                                                        /
                                                     Empleado
                                                        /
                                                      Jefe
                                                       /
                                                    Directeur
         */
        //Tenant compte de cette hierarchie on doit se demander laquelle de ces classes est la plus capable ou
        //la plus spécialisée, la classe la plus puissante, celle qui peut faire le plus de choses.
        //On pourrait dire que c'est Directeur, car elle hérite de Jefe qui hérite à la fois d'Employe
        //Directeur serait donc celle qui aurait le plus de méthodes.

        //Et si on regarde la hiérarchie à l'inverse, vers le haut il arrive le contraire.
        //On voit qu'au fur et à mesure qu'on monte les classes sont moins spécialisées, PLUS GENERIQUES ou plutôt
        //moins abstraites.

        //Notre hierarchie actuelle est assez courte car on a que 2 classes + la 3ème qu'on a pas élaboré
        //Mais si nous étendions la hierarchie d'héritage vers le haut, si l'on créait une classe qui était par-dessus
        //d'Employe et qu'Employe héritait de cette classe, ON VERRAIT QUE CETTE CLASSE EST PLUS GENERIQUE que la
        //classe Employe car elle aurait moins de methodes que la classe Employe. Et qu'on dit que cette classe
        //va avoir 200 METHODES, cela revient au même, cette classe aurait quand même moins de méthodes que la classe
        //Employe ou autant de methodes

        //EMPLOYE est une PERSONE?  règle ...est un???

        //Voyons maintenant , certains méthodes que l’on a dans la classe employe : donne_salaire par exemple,
        //Cette méthodes était déclaré dans la classe employe, donc, chef et directeur l’héritent et ceci nous permet
        // de voir le salaire d’un employe , chef, directeur. *Cependant on se demande maintenant, y’ aurait-t-il un
        // sens à avoir cette méthode dans la classe personne ???
        //Une personne doit-t-elle toujours avoir un salaire ? suremen non

        //*On avait aussi la methode donne_prenom dans la classe employe, heritée par chef et directeur
        //Du coup de ces 2 méthodes lequel on pourrait amener a la classe personne ?
        //Une personne n’a pas toujours un salaire
        //Mais une personne a toujours un prénom , on pourrait donc passer cette méthode à la classe personne

        //De cette manière on s’assure que employe, chef, et directeur héritent cette méthode car ils ont tous un prénom.

        //Et le plus adéquat serait de laisse la méthode donne_salaire là ou elle est, dans la classe employe
        //Pour que ces 3 classe est la méthode donne_salaire car si dans le future on désire construire une
        // nouvelle classe de type eleve alors cette classe si on analyse la hierarchie, devrait hériter de personne
        // mais ne devrait pas hériter de employe, chef, ou directeur
        //Car un eleve n’a pas de salaire mais il a un prénom , du coup la hierarchie serait comme ca

         /*
                                            ****     PERSONA   <------------/Alumno/
                                                        ^
                                                        /
                                                     Empleado
                                                        ^
                                                        /
                                                       Jefe
                                                        ^
                                                        /
                                                    Directeur
         */
         //Du coup Alumno, herite de personne mais ecartée , sans qu’elle ait rien à voir avec employe, chef et directeur
         //De cette manière comme dans personne on a la méthode donne_prénom cette méthode est hérité par employé, chef,
         // directeur et aussi par eleve car toutes ces personnes ont un prénom, du coup l’héritage actuel a du sens avec la regle est-ce un ?

        //*Quelles autres caractéristiques communes ont les sous classes de personne,
        // UNE Description

        //On peut faire la description d’un employe, chef, directeur et de eleve : donne_description
        //Cette méthode on la créerait dans la méthode personne pour qu’elle puisse être héritée par employe, chef,
        // directeur, et aussi par eleve

        //Mais avec cette methode il arrive quelque chose de différent et c’est que la méthode description sera
        // différente car la description ou la méthode description, sera différente dans chaque OBJET

        //C’est-à-dire ; dans la methode donne-prenom on dit return prenom
        //Cependant dans la methode donne_description ce n’est pas aussi simple, car les objets ont des caracteristiques
        // differentes, employe par exemple a un id, salarire, un departement ou il travaille etc
        //Pareil pour chef et directeur.
        //*Cependant cette description valide pour ces 3 objets ne nous sert pas pour l’objet eleve

        //Car un eleve n’a ni un id ni un salaire ni un departement
        //Du coup ; c’est claire que tous les objets doivent avoir la méthode donne_description ,
        // ce qui est moins claire est comment doit être cette description, pour qu’elle soit générale

        //**************************************************************************************************************
        //Que faire dans ces cas ? Déclarer cette méthode comme ABSTRACT
        //Une méthode abstract est crée :
        //
        //Public abstract type_donnée nom-méthode() ; cette methode devra etre le plus générique possible du coup
        //
        //public abstract String donne_description() ;
        //une méthode abstract n’a pas de cle d’ouverture ni fermeture, et n’a rien à l’intérieur, elle est simplement définie
        //**************************************************************************************************************

        //**Qu’implique que la classe personne, ait à l’intérieur une méthode abstract
        //En java, dès que tu déclares une méthode en abstract, tu es obligé de déclarer aussi la classe comme abstract
        //C’est une règle de syntaxe, une obligation.

        //*Il se peut que la classe ait une seule méthode abstract ou que la classe ait 500 méthodes abstracts et 300
        // qui ne le sont pas. Peu importe
        //Dès que la classe a au moins une méthode abstract alors cette classe doit être déclarée abstract

        //*Syntaxe :

        //abstract class nom_class
        //{
        //}
        //abstract class personne
        //{
        //Et dans la classe on met le constructeur, methodes, etc
        //}

        //D’un coté on devrait declarer la methode comme abstract car c’est claire que tous les objets doivent avoir
        // une description, tous les objects qui héritent de personne, et d’un autre coté dès qu’on déclare cette
        // méthode abstract, on sera obligé de déclarer la classe personne comme abstract

        //Quand tu declares une méthode abstract dans une classe, toutes les classes qui héritent dans ce cas de
        // personne sont obligé à sobreescribir cette methode abstract.



}
