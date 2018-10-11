package com.il.java.concepts;

/**
 * Created by cesaregb on 11/19/16.
 */
public class Caller {

  public static void main(String[] args) {
    InnerClasses ic = new InnerClasses();
    ic.setbVal(new InnerClasses.B());
    ic.getbVal().setValY(100);
    InnerClasses.B b = new InnerClasses.B();
    InnerClasses.A a = ic.new A();
    System.out.println(a.getParentB().getValY());


    System.out.printf("hola %d, %s", 2, "bla bla bla");
    System.out.println("akdalkd");

  }
}
