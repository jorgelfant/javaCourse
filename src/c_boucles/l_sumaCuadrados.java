package c_boucles;

public class l_sumaCuadrados {
    public static void main(String[] args) {
        //Hacer un programa que calcule la suma de los cuadrados de los 100 primeros numeros
        int suma = 0;
        int cuad;
        for (int i = 1; i <= 100; i++) {
            cuad = (int)Math.pow(i,2);//ou i*i
            suma = suma + cuad;
        }
        System.out.println("La suma de los cuadrados de los 100 primeros numeros es " + suma);
    }
}
