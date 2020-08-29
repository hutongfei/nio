package com.my.design;

/**
 * 建造者模式(建造者模式注重零部件的组装过程)
 * 四要素
 * 1产品角色，它是包含多个组成部件的复杂对象，由具体建造者来创建其各个滅部件
 * 3具体建造者，实现 Builder 接口，完成复杂产品的各个部件的具体创建方法
 * 2抽线建造者Builder，它是一个包含创建产品各个子部件的抽象方法的接口，通常还包含一个返回复杂产品的方法 getResult()
 * 4指挥者,它调用建造者对象中的部件构造与装配方法完成复杂对象的创建，在指挥者中不涉及具体产品的信息
 */
public class Build {

  public static void main(String[] args) {
    Builder builder = new ConcreteBuilder();
    Director director = new Director(builder);
    BProduct bProduct = director.construct();
    bProduct.show();

  }
}

/**
 * 产品角色，有多个零部件组件
 */
class BProduct{
  private String partA;
  private String partB;
  private String partC;

  public void  show() {
    System.out.println(getPartA() + "   " + getPartB() + "   "+ getPartC());
  }

  public String getPartA() {
    return partA;
  }

  public void setPartA(String partA) {
    this.partA = partA;
  }

  public String getPartB() {
    return partB;
  }

  public void setPartB(String partB) {
    this.partB = partB;
  }

  public String getPartC() {
    return partC;
  }

  public void setPartC(String partC) {
    this.partC = partC;
  }
}

/**
 * 抽线建造者
 */
abstract class Builder{
  BProduct bProduct = new BProduct();
  public abstract void buildPartA();
  public abstract void buildPartB();
  public abstract void buildPartC();

  public BProduct getResult() {

    return bProduct;
  }
}

/** 具体建造者 **/
class ConcreteBuilder extends Builder {

  @Override
  public void buildPartA() {
    bProduct.setPartA("建造者A");
    System.out.println("建造PartA..");
  }

  @Override
  public void buildPartB() {
    bProduct.setPartB("建造者B");
    System.out.println("建造PartB..");
  }

  @Override
  public void buildPartC() {
    bProduct.setPartC("建造者C");
    System.out.println("建造PartC..");
  }

  @Override
  public BProduct getResult() {
    return super.getResult();
  }
}

/**
 * 指挥者 调用建造者的方法完成复杂的方法调用
 */
class Director{
  private Builder builder = null;

  public Director(Builder build) {
    this.builder = build;
  }
  /**产品构建与组装方法 **/
  public BProduct construct() {

    builder.buildPartA();
    builder.buildPartB();
    builder.buildPartC();
    return builder.getResult();
  }


}



