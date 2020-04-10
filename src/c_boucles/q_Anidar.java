package c_boucles;

public class q_Anidar {//HACER UNA X y +

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                if (i == 0 || j == 0 || i == 9 || j == 9 || i == j || j == 9 - i) {//ou i+j==9 en lugar de la ultima cond
                    System.out.print(i + "" + j + " ");
                } else {
                    System.out.print("   ");//3 espacios porque 01 antes del 0 hay un espacio + 1 y 2 son 3
                }
            }
            System.out.println();
        }
    /*
     00 01 02 03 04 05 06 07 08 09
     10 11 12 13 14 15 16 17 18 19
     20 21 22 23 24 25 26 27 28 29
     30 31 32 33 34 35 36 37 38 39
     40 41 42 43 44 45 46 47 48 49
     50 51 52 53 54 55 56 57 58 59
     60 61 62 63 64 65 66 67 68 69
     70 71 72 73 74 75 76 77 78 79
     80 81 82 83 84 85 86 87 88 89
     90 91 92 93 94 95 96 97 98 99

     (i == 0 || j == 0 || i == 9 || j ==9 || i==j)
     00 01 02 03 04 05 06 07 08 09
     10                         19
     20                         29
     30                         39
     40                         49
     50                         59
     60                         69
     70                         79
     80                         89
     90 91 92 93 94 95 96 97 98 99

     en rajoutant la derniere condicion  (i == 0 || j == 0 || i == 9 || j ==9 || i==j)

     00 01 02 03 04 05 06 07 08 09
     10 11                      19
     20    22                   29
     30       33                39
     40          44             49
     50             55          59
     60                66       69
     70                   77    79
     80                      88 89
     90 91 92 93 94 95 96 97 98 99


      if (i == 0 || j == 0 || i == 9 || j == 9 || i == j || j==9-i) ultima condicion
     00 01 02 03 04 05 06 07 08 09
     10 11                   18 19
     20    22             27    29
     30       33       36       39
     40          44 45          49
     50          54 55          59
     60       63       66       69
     70    72             77    79
     80 81                   88 89
     90 91 92 93 94 95 96 97 98 99


      for (int i = 0; i < 9; i++) {
      for (int j = 0; j < 9; j++) {
        if (i == 0 || j == 0 || i == 8 || j == 8 || i == j || j==9/2 || i==9/2|| j==8-i) {
          System.out.print(i + "" + j + " ");
        } else {
          System.out.print("   ");//3 espacios porque 01 antes del 0 hay un espacio + 1 y 2 son 3
        }
      }
      System.out.println();
    }

       00 01 02 03 04 05 06 07 08
       10 11       14       17 18
       20    22    24    26    28
       30       33 34 35       38
       40 41 42 43 44 45 46 47 48
       50       53 54 55       58
       60    62    64    66    68
       70 71       74       77 78
       80 81 82 83 84 85 86 87 88





    * */

    }
}
