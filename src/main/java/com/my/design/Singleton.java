package com.my.design;

/**
 * 懒汉式
 */
public class Singleton {

  private static Singleton singleton = null;

  private Singleton() {}

  public static Singleton getInstance() {
    if (singleton == null) {
      singleton = new Singleton();
    }
    return singleton;
  }
}
