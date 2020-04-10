package d_funciones.a_numberPow;

public class FuncionCnBis {
  //el metodo no es estatic no hara falta poner el nombre de la clase antes de invocarlo, sin embarco habra que
  //crear un objeto de esta clase para poner utilizar el metodo
  public int cincoNumero(int numero) {
    int cubo;
    cubo = (int)Math.pow(numero, 5);
    return cubo;
  }
}
