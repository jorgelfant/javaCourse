package i_poo.q_collections.collections_XI_Map;

public class Empleado {

    private String name;
    private double sueldo;

    public Empleado(String name) {
        this.name = name;
        this.sueldo = 2000;
    }


    public String toString() {
        return "[Nombre=" + this.name + ", sueldo= " + sueldo + "]";
    }

}
