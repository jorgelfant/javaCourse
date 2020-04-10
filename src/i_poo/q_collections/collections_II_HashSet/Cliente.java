package i_poo.q_collections.collections_II_HashSet;

public class Cliente {

    private String nombre;
    private String numeroCuenta;
    private double saldo;


    public Cliente(String nombre, String numeroCuenta, double saldo) {//Constructor
        this.nombre = nombre;
        this.numeroCuenta = numeroCuenta;
        this.saldo = saldo;
    }

    //SETTERS AND GETTERS
    public void setNombre(String nombre) {

        this.nombre = nombre;
    }

    public String getNombre() {

        return nombre;
    }

    public void setNumeroCuenta(String numeroCuenta) {

        this.numeroCuenta = numeroCuenta;
    }

    public String getNumeroCuenta() {

        return numeroCuenta;
    }

    public void setSaldo(double saldo) {

        this.saldo = saldo;
    }

    public double getSaldo() {

        return saldo;
    }

    //equals et hashcode lo que hace que 2 clientes se repitan es que tengan el mismo "numero de cuenta"
    //sin embargo que tengan el mismo nombre o saldo no quiere decir que sean el mismo

}
