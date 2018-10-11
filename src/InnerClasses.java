package com.il.java.concepts;

/**
 * Created by cesaregb on 11/19/16.
 */
public class InnerClasses {

  private int val1;
  private int val2;
  private B bVal;

  class A {
    private int valA;
    private int valB;

    public int getValA() {
      return valA;
    }

    public void setValA(int valA) {
      this.valA = valA;
    }

    public int getValB() {
      return valB;
    }

    public void setValB(int valB) {
      this.valB = valB;
    }

    public B getParentB() {
      return bVal;
    }
  }

  static class B {
    private int valZ;
    private int valY;

    public int getValZ() {
      return valZ;
    }

    public void setValZ(int valZ) {
      this.valZ = valZ;
    }

    public int getValY() {
      return valY;
    }

    public void setValY(int valY) {
      this.valY = valY;
    }
  }

  public int getVal1() {
    return val1;
  }

  public void setVal1(int val1) {
    this.val1 = val1;
  }

  public int getVal2() {
    return val2;
  }

  public void setVal2(int val2) {
    this.val2 = val2;
  }

  public B getbVal() {
    return bVal;
  }

  public void setbVal(B bVal) {
    this.bVal = bVal;
  }
}
