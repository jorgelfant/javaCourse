package i_poo.v_design_patterns.C_Modelos_de_Comportamiento.III_Interpreteur;

import java.util.ArrayList;
import java.util.Stack;

public class Exemple_I {
  public static void main(String[] args) {
    String expression = "42 4 2 - +";
    Parser p = new Parser(expression);
    System.out.println("'" + expression + "' equals " + p.evaluate());
    /*RESULTADO
    '42 4 2 - +' equals 44
    */
  }
}

//==================================================================================================================
//                                          Interpréter un langage
//==================================================================================================================
    /*
    Le patron de conception Interpréteur est utilisé pour des logiciels ayant besoin d'un langage afin de décrire
    les opérations qu'ils peuvent réaliser (exemple : SQL pour interroger une base de données).

    Le modèle de conception Interpréteur définit la grammaire de ce langage et utilise celle-ci pour interpréter
    des états dans ce langage.

    Ce patron de conception est très utile dans deux cas:

    1) lorsque le logiciel doit analyser/interpréter une chaîne algébrique. C'est un cas assez évident où le logiciel
       doit exécuter des opérations en fonction d'une équation (dessiner la courbe d'une fonction par exemple),
       lorsque le logiciel doit produire différents types de données comme résultat. Ce cas est moins évident,
       mais l'interpréteur y est très utile. Prenez l'exemple d'un logiciel capable d'afficher des données dans
       n'importe quel ordre, en les triant ou pas, etc.

    2) Ce patron définit comment interpréter les éléments du langage. Dans ce patron de conception, il y a une classe
       par symbole terminal et non-terminal du langage à interpréter. L'arbre de syntaxe du langage est représenté par
       une instance du patron de conception Objet composite.
    */

//==================================================================================================================
//                                          Diagramme de classes
//==================================================================================================================
    /*
    Le patron de conception Interpréteur peut être représenté par le diagramme de classes suivant :

                                      -------------------
                                      |    Contexte     |
                                      ------------------

                                  --------------------------
                                  |      Expresssion       |
                                  --------------------------
                                  |                        |-----------------------------------
                                  --------------------------                                  |
                                  | + interpreter(conexte) |                                  |
                                  --------------------------                                  |
                                             /\                                               |
                                             |                                                |
                                             |                                                |
                         ------------------------------------------                           |
                        |                                         |                           |
           --------------------------                 --------------------------              |
           |  ExpresssionTerminale  |                 | ExpresssionNonTerminale |<>------------
           --------------------------                 --------------------------
           |                        |                 |                        |
           --------------------------                 --------------------------
           | + interpreter(conexte) |                 | + interpreter(conexte) |
           --------------------------                 --------------------------
              Diagramme de classes UML du patron de conception Interpréteur

     L'exemple Java suivant montre comment interpréter un langage spécialisé, tel que les expressions en notation
     polonaise inversée. Dans ce langage, on donne les opérandes avant l'opérateur.
    */
//======================================================================================================================

interface Expression {
  public void interpret(Stack<Integer> s);
}

//======================================================================================================================

class TerminalExpression_Number implements Expression {
  private int number;

  public TerminalExpression_Number(int number) {
    this.number = number;
  }

  public void interpret(Stack<Integer> s) {
    s.push(number);
  }
}

//========================================================

class TerminalExpression_Plus implements Expression {
  public void interpret(Stack<Integer> s) {
    s.push(s.pop() + s.pop());
  }
}

//========================================================

class TerminalExpression_Minus implements Expression {
  public void interpret(Stack<Integer> s) {
    s.push(-s.pop() + s.pop());
  }
}

//======================================================================================================================

class Parser {
  private ArrayList<Expression> parseTree = new ArrayList<Expression>(); // only one NonTerminal Expression here

  public Parser(String s) {
    for (String token : s.split(" ")) {
      if (token.equals("+"))
        parseTree.add(new TerminalExpression_Plus());
      else if (token.equals("-"))
        parseTree.add(new TerminalExpression_Minus());
        // ...
      else
        parseTree.add(new TerminalExpression_Number(Integer.parseInt(token)));
    }
  }

  public int evaluate() {
    Stack<Integer> context = new Stack<Integer>();
    for (Expression e : parseTree)
      e.interpret(context);
    return context.pop();
  }
}





