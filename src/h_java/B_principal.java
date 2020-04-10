package h_java;

public class B_principal {
    public static void main(String[] args) {

        int[] tableau = B_datos.rellenarArreglo(5);
        //esto me llena el arreglo y me permite retornar la referencia al arreglo con esto guardamos la direccion del array en otro array..no necesitamos crearlo

        //System.out.println(tableau);// esto contiene la referencia del tableau que retorna el metodo rellenarArreglo

       /*Si intentaramos esto da error porque tableau posede solo una copia de la direccion del arreglo...con este for no se muestran los datos
         tableau no existe en tant que tel , no lo hemos creado, es como si fuera un reflejo o algo que apunta a otro lugar
         for(int i=0;i<tableau.length;i++) {
            System.out.println(tableau[i]);
        }
       */

        //una copia de la direccion del arreglo va como argumento, y el ciclo for dentro de esta funcion permite imprimir
        B_datos.imprimir(tableau);//esto me imprime el arreglo

        //O SOLAMENTE UNA LINEA
        // B_datos.imprimir(B_datos.rellenarArreglo(5));
    }
}
