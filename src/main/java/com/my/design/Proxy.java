package com.my.design;

/**
 * 代理模式
 * 1共同接口，2真实对象，3代理对象
 * 代理对象
 */
public class Proxy implements PCommon {
  private PCommon pCommon = null;

  public Proxy(PCommon pCommon) {
    this.pCommon = pCommon;
  }

  @Override
  public void method() {
    System.out.println("代理对象前置方法执行啦...");
    pCommon.method();
    System.out.println("代理对象后置方法执行啦...");
  }
}

/**
 * 共同接口
 */
interface PCommon{
  void method();
}

/**
 * 真实对象
 */
class Real implements PCommon{

  @Override
  public void method() {
    System.out.println("this is real method !");
  }
}
