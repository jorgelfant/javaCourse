package g_vectores_Bid;

import java.util.Scanner;

public class i_Temperaturas {
    public static void main(String[] args) {
        //Crear una matriz de 5x7, donde 5 representan la semana de un mes y 7 los dias de la semana
        //La estructura registrara la temperatura diaria de una cabina de pago, estos oscilan entre 7 y 38 grados
        //La matriz debera ser llenada de forma aleatoria para el mes de mayo donde el primer dia inica el
        //lunes y el ultimo (31) se ubica el miercoles

        //Se debe hacer:
        //1 Obtener la temperatura mas alta y baja de la semana y que dia se produjo(lunes, marte, etc)
        //2 Promedio temperatura de la semana
        //3 Temperatura mas alta del mes y su dia

        //Podemos decir que 0 Lunes 1 Martes Miercoles 2 Jueves 3 Viernes 4 Sabado 5 Domingo 6
        int semanas;
        int dias;
        int limite;
        Scanner sc = new Scanner(System.in);
        //******************************************************************************************************************
        //                            INGRESAR SEMANAS Y DIAS
        //******************************************************************************************************************
        System.out.println("Ingrese el numero de semanas");
        semanas = sc.nextInt();
        System.out.println("Ingrese el numero de dias");
        dias = sc.nextInt();
        int[][] semanas_dias = new int[semanas][dias];

        String[] diasSemana = {"lunes", "Martes", "Miercoles", "Jueves", "Viernes", "Sabado", "Domingo"};
        for (int i = 0; i < diasSemana.length; i++) {
            System.out.print(diasSemana[i].charAt(0) + "" + diasSemana[i].charAt(1) + " ");
        }
        System.out.println();
        //******************************************************************************************************************
        //         Necesitamos numeros de temperatura aleatorios entre 7 y 38 grados
        //******************************************************************************************************************
        for (int i = 0; i < semanas; i++) {
            if (i == semanas - 1) {// semana 4     5-1=4
                limite = 3;//semana 4 ultima semana 0 1 2 3 4
            } else {
                limite = 7;
            }
            for (int j = 0; j < limite; j++) {//dias
                semanas_dias[i][j] = 7 + (int) (Math.random() * 32);//temperaturas aleatorias
            }
        }
        //******************************************************************************************************************
        //                            Leemos la matriz con las temperaturas
        //******************************************************************************************************************
        for (int i = 0; i < semanas; i++) {
            if (i == semanas - 1) {//4
                limite = 3;//miercoles
            } else {
                limite = 7;
            }
            for (int j = 0; j < limite; j++) {
                if (semanas_dias[i][j] < 10) {//si el valor es 9    8 se le agrega 09 08 para cuadrar
                    System.out.print("0" + semanas_dias[i][j] + " ");
                } else {
                    System.out.print(semanas_dias[i][j] + " ");
                }
            }
            System.out.println();
        }
        //******************************************************************************************************************
        //                     HAYAMOS TEMPERATURA MAS ALTA Y MAS BAJA DE CADA SEMANA
        //******************************************************************************************************************
        int max;//REINICIAMOS MAX lo cual es necesario cuando buscamos varios valores a la vez
        int min;

        int[] posMax = new int[5];
        int[] posMin = new int[5];
        int[] maxi = new int[5];
        int[] mini = new int[5];

        for (int i = 0; i < semanas; i++) {
            max = semanas_dias[i][0];//REINICIAMOS MAX lo cual es necesario cuando buscamos varios valores a la vez
            min = semanas_dias[i][0];//ESTE REINICIO SE HACE DESPUES DE CADA FILA

            if (i == semanas - 1) {//4
                limite = 3;//miercoles
            } else {
                limite = 7;
            }
            for (int j = 0; j < limite; j++) {
                if (semanas_dias[i][j] > max) {
                    max = semanas_dias[i][j];
                    posMax[i] = j;
                }
                if (semanas_dias[i][j] < min) {
                    min = semanas_dias[i][j];
                    posMin[i] = j;
                }
            }
            maxi[i] = max;
            mini[i] = min;
        }
        System.out.println();
        //******************************************************************************************************************
        //   1                           MAX ET MIN ET POSICION POR SEMANA
        //******************************************************************************************************************
        int[] fechas = {0, 7, 14, 21, 28};//PA DAR FECHAS esto +1 porque viernes es 6 y no 7 por ejemplo  y 0 en lugar de uno
        for (int i = 0; i < 5; i++) {//5
            System.out.println("Semana " + (i + 1) + "= max temp: " + maxi[i] + "° el " + diasSemana[posMax[i]] + " " +
                    ((fechas[i] + 1) + posMax[i]) + " de mayo " + ", min temp: " + mini[i] + "° el " + diasSemana[posMin[i]] + " "
                    + ((fechas[i] + 1) + posMin[i]) + " de mayo ");
        }
        System.out.println();
        //******************************************************************************************************************
        //   1                           PROMEDIO TEMPERATURA DE LA SEMANA
        //******************************************************************************************************************
        int suma;
        int conteo;
        int[] promedios = new int[5];

        for (int i = 0; i < promedios.length; i++) {
            suma = 0;
            conteo = 0;
            for (int j = 0; j < dias; j++) {
                suma = suma + semanas_dias[i][j];
                conteo++;
            }
            promedios[i] = suma / conteo;//promedio
        }
        //Mostramos los promedios de cada semana
        for (int i = 0; i < promedios.length; i++) {
            System.out.println("Promedio de la semana " + (i + 1) + " = " + promedios[i] + "°");
        }
        System.out.println();
        //******************************************************************************************************************
        //   1                           TEMPERATURA MAS ALTA DEL MES Y SU DIA
        //******************************************************************************************************************
        //traemos el tab de maximas temperaturas hecho antes y ponemos su primer valor como max hipotetico
        int maxTempMes = maxi[0];
        int posMaxTempMes = posMax[0];
        for (int i = 0; i < 5; i++) {
            if (maxi[i] > maxTempMes) {
                maxTempMes = maxi[i];
                posMaxTempMes = posMax[i];//sincroniza el valor de posMax cuyos indices valen de 1 a 7
            }
        }
        //**************************************************************************************************************
        int repetidos = 0;
        int[] fechaMax = new int[5];//pa dar fechas en los dias maximos
        int[] repetidosPos = new int[5];
        int contenedor = 0;//para que el else pueda acceder a la fecha la inizialisamos a 0

        for (int i = 0; i < 5; i++) {
            if (maxTempMes == maxi[i]) {//por ejemplo 38 == 38 35 38 36 36 ?
                repetidos++;              //                   0  1  2  3  4
                repetidosPos[i] = posMax[i];
                fechaMax[i] = (fechas[i] + 1) + posMax[i];// en caso hayan varios dias repetidos
                contenedor = fechaMax[i];//para que el else que viene despues pueda acceder a la fecha ( en caso haya solo uno)
            } else {
                repetidosPos[i] = 8;//un numero qu eno ta comprendido entre 0 y 6 para que luego en la condicion de repetidosPos
            }                     //le pueda decir que me imprima todos los que no son 8 , porque con 0 no m imprime el lunes
        }
        //**************************************************************************************************************
        if (repetidos > 1) {
            System.out.print("La maxima temperatura del mes fue " + maxTempMes + "°, se repitio " + repetidos + " veces los dias ");
            for (int i = 0; i < repetidosPos.length; i++) {
                if (repetidosPos[i] != 8)//todos los dias que no sean coincidentes seran 8
                    System.out.print(diasSemana[repetidosPos[i]] + " " + fechaMax[i] + " de mayo ");
            }
        } else {
            System.out.print("La maxima temperatura del mes fue " + maxTempMes + "° el " + diasSemana[posMaxTempMes] + " " + contenedor + " de mayo");
        }
    }
}

