package com.my.design;

/**
 * 静态工厂模式
 */
public class FactoryV2 {

  private static FCommonV2 fCommonV2 = null;

  public static FCommonV2 getProduct2V2() {
    fCommonV2 = new Product2V2();
    return fCommonV2;
  }

  public static FCommonV2 getProduct1V2() {
    fCommonV2 = new Product1V2();
    return fCommonV2;
  }

}

class Product1V2 implements FCommonV2 {

  public Product1V2() {
  }

  @Override
  public void method() {
    System.out.println("this is Product1V2");
  }
}

class Product2V2 implements FCommonV2 {

  public Product2V2() {
  }

  @Override
  public void method() {
    System.out.println("this is Product2V2");
  }
}

interface FCommonV2 {

  void method();
}