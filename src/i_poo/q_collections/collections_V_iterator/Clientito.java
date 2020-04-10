package i_poo.q_collections.collections_V_iterator;

import java.util.Objects;

public class Clientito {

    private String nombre;
    private String numeroCuenta;
    private double saldo;


    public Clientito(String nombre, String numeroCuenta, double saldo) {//Constructor
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
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Clientito)) return false;
        Clientito cliente = (Clientito) o;
        return numeroCuenta.equals(cliente.numeroCuenta);
    }

    @Override
    public int hashCode() {
        return Objects.hash(numeroCuenta);
    }
}
