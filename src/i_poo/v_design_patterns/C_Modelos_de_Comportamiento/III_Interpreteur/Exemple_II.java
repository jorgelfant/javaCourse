package i_poo.v_design_patterns.C_Modelos_de_Comportamiento.III_Interpreteur;

public class Exemple_II {
//======================================================================================================================
//             3) Exemple_II uses Expression class to create rules and then parse them.
//======================================================================================================================
  //Rule: Robert and John are male
  public static Expressionn getMaleExpression(){
    Expressionn robert = new TerminalExpression("Robert");//F
    Expressionn john = new TerminalExpression("John");//V
    return new OrExpression(robert, john);
  }

  //Rule: Julie is a married women
  public static Expressionn getMarriedWomanExpression(){
    Expressionn julie = new TerminalExpression("Julie");//V
    Expressionn married = new TerminalExpression("Married");//V
    return new AndExpression(julie, married);
  }

//=====================================================MAIN=============================================================

  public static void main(String[] args) {
    Expressionn isMale = getMaleExpression();
    Expressionn isMarriedWoman = getMarriedWomanExpression();

    System.out.println("John is male? " + isMale.interpret("John"));
    System.out.println("Julie is a married women? " + isMarriedWoman.interpret("Married Julie"));
    /*
       John is male? true
       Julie is a married women? true
    */
  }
}

/*
Interpreter pattern provides a way to evaluate language grammar or expression. This type of pattern comes under
behavioral pattern. This pattern involves implementing an expression interface which tells to interpret a particular
context. This pattern is used in SQL parsing, symbol processing engine etc.

Implementation
We are going to create an interface Expression and concrete classes implementing the Expression interface. A class
TerminalExpression is defined which acts as a main interpreter of context in question. Other classes OrExpression,
AndExpression are used to create combinational expressions.

InterpreterPatternDemo, our demo class, will use Expression class to create rules and demonstrate parsing of expressions.


                                            ----------------------------------------
                                            |        InterpreterPatternDemo        |
                                            ----------------------------------------
                                            |                                      |
                                            ----------------------------------------
                                            | + getMaleExpression() : void         |
                                            | + getmarriedWomenExpression() : void |
                                            ----------------------------------------
                                                              |
                                                              | uses
                                                             \/
    -------------------------------------------------------------------------------------------------------------
                                                        INTERFACE
    |                                     ----------------------------------------                               |
    |                                     |              Expression              |                               |
    |                                     ----------------------------------------                               |
    |                                     |                                      |                               |
    |                                     ----------------------------------------                               |
    |                                     |                                      |                               |
    |                                     |  + interpreter(conexte)              |                               |
    |                                     ----------------------------------------                               |
    |                                                       /\                                                   |
    |                                                       | implement                                          |
    |                                                       |                                                    |
    |                  ---------------------------------------------------------------------------               |
    |                 |                                     |                                    |               |
    |    --------------------------            ---------------------------          ---------------------------  |
    |    |   TerminalExpression   |            |      AndExpression      |          |      OrExpression       |  |
    |    --------------------------            ---------------------------          ---------------------------  |
    |    |   - data : String      |            | - expre1 : Expression   |          | - expre1 : Expression   |  |
    |    --------------------------            | - expre2 : Expression   |          | - expre2 : Expression   |  |
    |    | + interpreter(conexte) |            ---------------------------          ---------------------------  |
    |    --------------------------            | + AndExpression()       |          | + OrExpression()        |  |
    |                                          | + interpret() : boolean |          | + interpret() : boolean |  |
    |                                          --------------------------           ---------------------------  |
    |                                                                                                            |
    |                                                                                                            |
    -------------------------------------------------------------------------------------------------------------

*/

//======================================================================================================================
//                                       1) Create an expression interface.
//======================================================================================================================
interface Expressionn {
  public boolean interpret(String context);
}

//======================================================================================================================
//                           2) Create concrete classes implementing the above interface.
//======================================================================================================================
class TerminalExpression implements Expressionn {

  private String data;

  public TerminalExpression(String data) {
    this.data = data;
  }

  @Override
  public boolean interpret(String context) {
    if (context.contains(data)) {
      return true;
    }
    return false;
  }
}
//================================================================

class OrExpression implements Expressionn {

  private Expressionn expr1 = null;
  private Expressionn expr2 = null;

  public OrExpression(Expressionn expr1, Expressionn expr2) {
    this.expr1 = expr1;
    this.expr2 = expr2;
  }

  @Override
  public boolean interpret(String context) {
    return expr1.interpret(context) || expr2.interpret(context);
  }
}

//================================================================

class AndExpression implements Expressionn {

 private Expressionn expr1 = null;
 private Expressionn expr2 = null;

 public AndExpression(Expressionn expr1, Expressionn expr2) {
   this.expr1 = expr1;
   this.expr2 = expr2;
 }

 @Override
 public boolean interpret(String context) {
   return expr1.interpret(context) && expr2.interpret(context);
 }
}


