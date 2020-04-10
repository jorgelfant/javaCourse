package i_poo.v_design_patterns.C_Modelos_de_Comportamiento.I_Chain_of_Responsability;

public class Exemple_II {
  public static void main(String[] args) {

//======================================================================================================================
//             3) Create different types of loggers. Assign them error levels and set next logger
//                in each logger. Next logger in each logger represents the part of the chain.
//======================================================================================================================
    AbstractLogger loggerChain = getChainOfLoggers();//obtenemos el errorLogger
    //ETAPE 3 : procedemos despues de haber imbricado a imprimir
    loggerChain.logMessage(AbstractLogger.INFO, "This is an information.");//1
    loggerChain.logMessage(AbstractLogger.DEBUG, "This is an debug level information.");//2
    loggerChain.logMessage(AbstractLogger.ERROR, "This is an error information.");//3
    /*RESULTADO
          Standard Console::Logger: This is an information.
          File::Logger: This is an debug level information.
          Standard Console::Logger: This is an debug level information.
          Error Console::Logger: This is an error information.
          File::Logger: This is an error information.
          Standard Console::Logger: This is an error information.
      */
  }
  //==================================================
  //Fuera del main
  //==================================================
  private static AbstractLogger getChainOfLoggers() {//ojo este metodo retorna el condenzado del enchainage
                                               //     int
    //ETAPE 1: creamos los objetos
    AbstractLogger errorLogger = new ErrorLogger(AbstractLogger.ERROR);//3
    AbstractLogger fileLogger = new FileLogger(AbstractLogger.DEBUG);//2
    AbstractLogger consoleLogger = new ConsoleLogger(AbstractLogger.INFO);//1
    //ETAPE 2: encadenamos los objetos
    errorLogger.setNextLogger(fileLogger);//se enchaine error--> fileLogger
    fileLogger.setNextLogger(consoleLogger);//avec cet autre   fileLogger-->consoleLogger

    return errorLogger;
  }
}

//FUERA DA LA CLASE
/*
As the name suggests, the chain of responsibility pattern creates a chain of receiver objects for a request.
This pattern decouples sender and receiver of a request based on type of request. This pattern comes under
behavioral patterns.

In this pattern, normally each receiver contains reference to another receiver. If one object cannot handle the
request then it passes the same to the next receiver and so on.
*/
//==================================================================================================================
//                                         Implementation
//==================================================================================================================
/*
We have created an abstract class AbstractLogger with a level of logging. Then we have created three types of loggers
extending the AbstractLogger. Each logger checks the level of message to its level and print accordingly otherwise does
not print and pass the message to its next logger.
                                                     Abstract class
   --------------------------                ---------------------------------
   |       Main             |     uses       |   AbstractLogger              |
   --------------------------  ------------> ---------------------------------
   |  +main() : void        |                | - INFO : int                  |
   --------------------------                | - DEBUG : int                 |
                                             | - ERROR : int                 |
                                             | - level : int                 |
                                             | - nextLogger : AbstractLogger |
                                             ---------------------------------
                                             | + setNextLogger() : void      |
                                             | + logMessage() : void         |
                                             | * write() : void              |
                                             ---------------------------------
                                                            /\
                                                            |
                                                            |
                         -------------------------------------------------------------------------
                         |                                  |                                    |
---------------------------------            ---------------------------------         ---------------------------------
|    ConsoleLogger              |            |      ErrorLogger              |         |       FileLogger              |
---------------------------------            ---------------------------------         ---------------------------------
|                               |            |                               |         |                               |
---------------------------------            ---------------------------------         ---------------------------------
| + ConsoleLogger()             |            | + ErrorLogger()               |         | + FileLogger()                |
| + setNextLogger() :           |            | + setNextLogger() :           |         | + setNextLogger() :           |
| + logMessage() : void         |            | + logMessage() : void         |         | + logMessage() : void         |
| * write() : void              |            | * write() : void              |         | * write() : void              |
---------------------------------            ---------------------------------         ---------------------------------
*/
//======================================================================================================================
//                                  1) Create an abstract logger class.
//======================================================================================================================
abstract class AbstractLogger {
  public static int INFO = 1;
  public static int DEBUG = 2;
  public static int ERROR = 3;

  protected int level;
  //next element in chain or responsability
  protected AbstractLogger nextLogger;

  public void setNextLogger(AbstractLogger nextLogger) {
    this.nextLogger = nextLogger;
  }

  public void logMessage(int level, String message) {

    if (this.level <= level) {
      write(message);
    }
    if (nextLogger != null) {//es decir si el objeto con el que toy tratando a usado el metodo setNextLogger(AbstractLogger nextLogger)
      nextLogger.logMessage(level, message);// que ha puesto otro objeto de tipo AbstractLogger entre parentesis
    }//el objeto AbstractLogger que pusimos como argumento llamara recursivamente al mismo metodo y se encadenara al sgte objeto (de otra clase)
  }

  //abstract methode
  abstract protected void write(String message);
}

//======================================================================================================================
//                                  2) Create concrete classes extending the logger.
//======================================================================================================================
class ConsoleLogger extends AbstractLogger {

  public ConsoleLogger(int level) {
    this.level = level;
  }

  protected void write(String message) {
    System.out.println("Standard console::Logger: " + message);
  }
}

//***************************************************************
class ErrorLogger extends AbstractLogger {

  public ErrorLogger(int level) {
    this.level = level;
  }

  protected void write(String message) {
    System.out.println("Error Console::Logger: " + message);
  }
}

//***************************************************************
class FileLogger extends AbstractLogger {

  public FileLogger(int level) {
    this.level = level;
  }

  protected void write(String message) {
    System.out.println("File::Logger: " + message);
  }
}
