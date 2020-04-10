package i_poo.k_abstract.persona;

public class Alumno extends Persona {

    private String carrera;

    public Alumno(String NOM, String carrera) {
        super(NOM);
        this.carrera = carrera;
    }

    public String getCarreran() {
        return carrera;
    }
   //ABSTRACT iniciado en esta classe hija qui hereda de persona
    public String donne_description() {
        return "nombre: " + super.getNOM() + " Carrera: " + this.carrera;
    }
}
