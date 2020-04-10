package i_poo.v_design_patterns.C_Modelos_de_Comportamiento.V_Mediator;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class Exemple_I extends JFrame implements ActionListener {
  Mediator med = new Mediator();

  Exemple_I() {
    JPanel p = new JPanel();
    p.add(new BtnView(this, med));
    p.add(new BtnBook(this, med));
    p.add(new BtnSearch(this, med));
    getContentPane().add(new LblDisplay(med), "North");
    getContentPane().add(p, "South");
    setSize(400, 200);
    setVisible(true);
  }

  public void actionPerformed(ActionEvent ae) {
    Command comd = (Command) ae.getSource();
    comd.execute();
  }

  //MAIN
  public static void main(String[] args) {
    new Exemple_I();
  }
}

//======================================================================================================================
//            Intermédiaire de communication entre les classes pour réduire leur inter-dépendances
//======================================================================================================================
/*
Le patron de conception Médiateur fournit une interface unifiée pour un ensemble d'interfaces d'un sous-système.
Il est utilisé pour réduire les dépendances entre plusieurs classes.

Lorsqu'un logiciel est composé de plusieurs classes, les traitements et les données sont répartis entre toutes
ces classes. Plus il y a de classes, plus le problème de communication entre celles-ci peut devenir complexe.
En effet, plus les classes dépendent des méthodes des autres classes plus l'architecture devient complexe. Cela
ayant des impacts sur la lisibilité du code et sa maintenabilité dans le temps.

Le modèle de conception Médiateur résout ce problème. Pour ce faire, le Médiateur est la seule classe ayant
connaissance des interfaces des autres classes. Lorsqu'une classe désire interagir avec une autre, elle doit
passer par le médiateur qui se chargera de transmettre l'information à la ou les classes concernées.
*/

//======================================================================================================================
//                                         Médiateur concret
//======================================================================================================================

class Mediator {
  BtnView btnView;
  BtnSearch btnSearch;
  BtnBook btnBook;
  LblDisplay show;

  void registerView(BtnView v) {
    btnView = v;
  }

  void registerSearch(BtnSearch s) {
    btnSearch = s;
  }

  void registerBook(BtnBook b) {
    btnBook = b;
  }

  void registerDisplay(LblDisplay d) {
    show = d;
  }

  void book() {
    btnBook.setEnabled(false);
    btnView.setEnabled(true);
    btnSearch.setEnabled(true);
    show.setText("booking...");
  }

  void view() {
    btnView.setEnabled(false);
    btnSearch.setEnabled(true);
    btnBook.setEnabled(true);
    show.setText("viewing...");
  }

  void search() {
    btnSearch.setEnabled(false);
    btnView.setEnabled(true);
    btnBook.setEnabled(true);
    show.setText("searching...");
  }
}

//======================================================================================================================
//                                          Interface Collègue
//======================================================================================================================

interface Command {
  void execute();
}
//======================================================================================================================
//                                        Un collègue concret
//======================================================================================================================

class BtnView extends JButton implements Command {
  Mediator med;

  BtnView(ActionListener al, Mediator m) {
    super("View");
    addActionListener(al);
    med = m;
    med.registerView(this);
  }

  public void execute() {
    med.view();
  }
}

//=====================================================


class BtnSearch extends JButton implements Command {
  Mediator med;

  BtnSearch(ActionListener al, Mediator m) {
    super("Search");
    addActionListener(al);
    med = m;
    med.registerSearch(this);
  }

  public void execute() {
    med.search();
  }
}

//=====================================================

class BtnBook extends JButton implements Command {
  Mediator med;

  BtnBook(ActionListener al, Mediator m) {
    super("Book");
    addActionListener(al);
    med = m;
    med.registerBook(this);
  }

  public void execute() {
    med.book();
  }
}

//=====================================================
class LblDisplay extends JLabel {
  Mediator med;

  LblDisplay(Mediator m) {
    super("Just start...");
    med = m;
    med.registerDisplay(this);
    setFont(new Font("Arial", Font.BOLD, 24));
  }
}

/*
Collègue
     Définit l'interface de communication entre objets Collègues.
MédiateurConcret
    Implémente l'interface Médiateur et coordonne la communication entre les objets Collègues. Il connaît tous les objets Collègues et comment ils communiquent.
CollègueConcret
    Communique avec les autres Collègues à travers son Médiateur.
*/
