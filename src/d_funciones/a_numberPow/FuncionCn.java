package d_funciones.a_numberPow;

public class FuncionCn {
//metodo declarado como estatic, hara falta poner el nombre de la clase antes del metodo Math.pow() por ejemplo
  public static int cuboNumero(int numero) {
    int cubo;
    cubo = (int)Math.pow(numero, 3);
    return cubo;
  }
}
