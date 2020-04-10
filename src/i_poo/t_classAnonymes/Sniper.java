package i_poo.t_classAnonymes;

public class Sniper extends Personnage {/*
    public void combattre() {
        //metodo combattre de Personnage redefinido
        if (this.getArmes().equals("fusil à pompe")) {
            System.out.println("Attaque au fusil à pompe !");
        } else {
            System.out.println("Je me sers ded mon fusil à lunette");
        }
    }
    //je me deplace a pieds
*/
    //------------------------------------------------------------------------------------------------------------------
    //SUPER IMPORTANTE AGREGAR(igual o modificado) LOS 2 CONSTRUCTORES EN LA SUBCLASE, SOLO SE PUEDE USAR EL CONSTRUCTOR
    // QUE HA SIDO REESCRITO EN LA SUBCLASSE PARA CREAR UN OBJETO DE LA SUPER CLASE
    //si solo agrego el 1ro, solo podre usar el primero
    //si agrego el 2do solo podre usar el segundo
    //si AGREGO AMBOS entonces PODRE USAR AMBOS!!!!

    //------------------------------------------------------------------------------------------------------------------
    //CONSTRUCTOR 1
    public Sniper() {
        setEspritCombatif(new EspritCombatif() {
            @Override
            public void combat() {
                System.out.println("Je tire avec mon fusil");
            }
        }); //utilizamos el seter para cambiar el valor de la variable par defaut
    }                                               //de la super classe Personnage
    //UNA PERSONA PAR DEFAUT NO UTILIZA un fusil o poistola pero el sniper si por eso redefinimos su comportamiento por defaut

    //CONSTRUCTOR 2
    public Sniper(EspritCombatif espritCombatif, Soin soin, Deplacement deplacement) {
        super(espritCombatif, soin, deplacement);
    }

    //Asi podremos construir objetos de la subclasse con cualquiera de los 2 constructores;
    //EN EL PAR DEFAUT ES OPCIONAL PONER super() ya que lo pongamos o no este pointe (automaticamente)
    // al constructeur sin parametros del padre una vez que lo reescribimos en la subclase.

}
