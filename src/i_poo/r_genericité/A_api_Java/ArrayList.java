package i_poo.r_genericité.A_api_Java;

public class ArrayList {
    //usamos object que es la super clase padre de todos para trabajar con la herencia
    private int i = 0;//contador
    private Object[] datosElemento;//declaramos un array de tipo Object


    public ArrayList(int z) {
        datosElemento = new Object[z];
    }

    public Object get(int i) {
        return datosElemento[i];
    }

    public void add(Object o) {
        datosElemento[i] = o;
        i++;
    }

    public  void imprimir() {//CETTE FONCTIION POURRAIT imprimer
        System.out.println("Imprimir datos: ");
        for (int i = 0; i < datosElemento.length; i++) {
            System.out.println(datosElemento[i]);
        }
    }
}
