package com.my.design;

/**
 * 模板方法模式
 */
public class Template {
}
abstract class AbstractClass{
    public void TemplateMethod() //模板方法
    {
        SpecificMethod();
        abstractMethod1();
        abstractMethod2();
    }
    public void SpecificMethod() //具体方法
    {
        System.out.println("抽象类中的具体方法被调用...");
    }
    public abstract void abstractMethod1(); //抽象方法1
    public abstract void abstractMethod2(); //抽象方法2
}

class ChildClass extends AbstractClass{



    @Override
    public void abstractMethod1() {
        System.out.println("abstractMethod1 被调用");
    }

    @Override
    public void abstractMethod2() {
        System.out.println("abstractMethod2 被调用");
    }
}
