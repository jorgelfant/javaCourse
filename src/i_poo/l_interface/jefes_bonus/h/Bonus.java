package i_poo.l_interface.jefes_bonus.h;

public interface Bonus {
    /*public static final*/ double bonusBase = 1500;//public static final es tambien redundante xq la interface acepta solo constantes static
    //STATIC car ca appartient à l'interface Bonus
    //final porque es contante y no cambiara

    /*public abstract*/ String donneBonus(double bonus);//public abstract se pone aunque no lo pongamos, cuando lo ponemos

    // es redondante ya que java lo pone automaticamente en la interface
    // aunque no pongamos nada ya que la interface solo acepta metodos abstract
    //voilà porque es redundante ponerlo

    //Imaginons que dans cette entreprise que ce bonus doit etre minimum 1500 euros + en fonction des effort
    //on lui donne plus ou moins .

    //comme le bonus doit avoir une valeur minimal on crée une constante

    //------------------------------------------------------------------------------------------------------------------
    //SE PUEDE CREAR UNA JERARQUIA ENTRE INTERFACES , Jefes PUEDE EN CONSECUENCIA extends Bonus (heredar)
    //------------------------------------------------------------------------------------------------------------------
}
