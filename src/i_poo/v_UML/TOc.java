package i_poo.v_UML;

import java.util.ArrayList;

public class TOc {
  public static void main(String[] args) {

    A a = new A();
    A a1 = new A();
    A a2 = new A();

    B b1 =new B();
    B b2 =new B();
    B b3 =new B();

    a.addB(b1);
    a.addB(b1);
    a.addB(b3);

    b1.addA(a);
    b1.addA(a1);
    b1.addA(a2);


    System.out.println(a.getArray().size());
    System.out.println();
    System.out.println(b1.getA().getArray().size());


  }
}

//===================================================
class A {
  private ArrayList<B> rb;

  public A() {
    rb = new ArrayList<B>();
  }

  public ArrayList<B> getArray() {
    return (rb);
  }

  public void remove(B b) {
    rb.remove(b);
  }

  public void addB(B b) {
    if (!rb.contains(b)) {
      if (b.getA() != null) {
        b.getA().remove(b);
      }
      b.setA(this);
      rb.add(b);
    }
  }
}

//===================================================
class B {
  private A ra;

  public B() {
  }

  public A getA() {
    return (ra);
  }

  public void setA(A a) {
    this.ra = a;
  }

  public void addA(A a) {
    if (a != null) {//si a existe
      if (!a.getArray().contains(this)) {//si el Array de a no contiene este B
        if (ra != null) {//si ra esta inicializado (existe)
          ra.remove(this);
        }
        this.setA(a);
        ra.getArray().add(this);
      }
    }
  }
}
