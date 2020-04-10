package g_vectores_Bid;

public class a_matriz {
  public static void main(String[] args) {
    //Es un arreglo de M*N elementos organizados en dos dimensiones donde M es el numero de final y N el numero
    //de columnas

    //Para representar una matriz se necesita un nombre de matriz acompana do de 2 indices
    int[][] tab = new int[3][3];  //ou int[][] tab={{1,2,3},{4,5,6},{7,8,9}}
    //el mas facil que crear un arreglo de 9 alementos, aqui es mas facil de encontrar los elementos es decir
    tab[0][0]=1;
    tab[0][1]=2;
    tab[0][2]=3;

    tab[1][0]=4;
    tab[1][1]=5;
    tab[1][2]=6;

    tab[3][0]=7;
    tab[3][1]=8;
    tab[3][2]=9;
    //   col col col
    //   0   1   2
    //0  1   2   3  fila 1
    //1  4   5   6  fila 2
    //2  7   8   9  fila 3


  }
}
