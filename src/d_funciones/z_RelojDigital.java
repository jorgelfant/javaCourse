package d_funciones;

public class z_RelojDigital {
    public static void main(String[] args) {
        //Realizar reloj digital que nunca pare
        //Tambien se debe hacer que espere un segundo real para darle mas realismo
        int horas = 0;
        int minutos = 0;
        int segundos = 0;

        while (true) {
            //Mostrar
            if (horas < 10) {
                System.out.print("0");
            }
            System.out.print(horas + ":");
            if (minutos < 10) {
                System.out.print("0");
            }
            System.out.print(minutos + ":");
            if (segundos < 10) {
                System.out.print("0");
            }
            System.out.print(segundos);
            segundos = segundos + 1;
            //Comprobar el tiempo
            if (segundos == 60) {
                minutos += 1;
                segundos = 0;
                if (minutos == 60) {
                    horas += 1;
                    minutos = 0;
                    if (horas == 24) {
                        horas = 0;
                    }
                }
            }
            System.out.println();
        }
    }
}
