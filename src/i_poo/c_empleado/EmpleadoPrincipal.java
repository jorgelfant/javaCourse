package i_poo.c_empleado;

public class EmpleadoPrincipal {
    //Imaginemos un programa para establecer nominas
    //                            EMPLEADO
    // NOMBRE             SUELDO            FECHA ALTA          SUBIR SUELDO
    public static void main(String[] args) {
        Empleado Jorge = new Empleado("Jorge", 3000, 1986, 3, 5);

        System.out.println(Jorge.getSalaire());//conocer salario


        Jorge.setSalaire(4000);                //Cambiar el salario
        System.out.println(Jorge.getSalaire());

        Jorge.augmentation(10);     //o aumentarlo en porcentaje
        System.out.println(Jorge.getSalaire());

        System.out.println(Jorge.getDebutContrat());//objeto Date con las fechas

        //PODRIA TB CREAR UN ARREGLO DE EMPLEADOS
        // Empleado[] empleados = new Empleado[3];
        //empleados[0]=new Empleado("Luis",2000,1990,5,3);  etc

        //O
        //for(Empleado indices:empleados){
        //     Pedir datos  y las variables recibidas ponerlas en los argumentos
        //    indices=new Empleado("Luis",2000,1990,5,3); y asi ir llenando
        //   }

        //ET imprimir
        //for(Empleado indices:empleados){
        // indices.aumentation(10);
        //   }

        //for(Empleado indices:empleados){
        // system.out.println("Nom"+indices.getNOM +.......);
        //   }

    }
}

