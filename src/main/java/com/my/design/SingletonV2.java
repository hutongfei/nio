package com.my.design;

/**
 * 饿汉式
 */
public class SingletonV2 {

  private static SingletonV2 singleton = new SingletonV2();

  private SingletonV2() {}

  public static SingletonV2 getInstance() {
    return singleton;
  }
}
