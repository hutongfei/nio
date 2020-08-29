package com.my.design;

/**
 * 普通工厂模式
 */
public class Factory {

  public FCommon getProduct(String source) {
    FCommon fCommon = null;
    if (source.equals("product1")) {
      fCommon = new Product1();
    } else if (source.equals("product2")) {
      fCommon = new Product2();
    }

    return fCommon;
  }

}

class Product1 implements FCommon {

  public Product1() {
  }

  @Override
  public void method() {
    System.out.println("this is Product1");
  }
}

class Product2 implements FCommon {

  public Product2() {
  }

  @Override
  public void method() {
    System.out.println("this is Product1");
  }
}

interface FCommon {

  void method();
}