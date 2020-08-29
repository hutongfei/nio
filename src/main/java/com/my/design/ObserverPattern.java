package com.my.design;

import java.util.ArrayList;
import java.util.List;

/**
 * 观察者（Observer）模式的定义：指多个对象间存在一对多的依赖关系，
 * 当一个对象的状态发生改变时，所有依赖于它的对象都得到通知并被自动更新。
 * 这种模式有时又称作发布-订阅模式、模型-视图模式，它是对象行为型模式。
 * 抽象主题（Subject）角色：也叫抽象目标类，它提供了一个用于保存观察者对象的聚集类和增加、删除观察者对象的方法，以及通知所有观察者的抽象方法。
 * 具体主题（Concrete    Subject）角色：也叫具体目标类，它实现抽象目标中的通知方法，当具体主题的内部状态发生改变时，通知所有注册过的观察者对象。
 * 抽象观察者（Observer）角色：它是一个抽象类或接口，它包含了一个更新自己的抽象方法，当接到具体主题的更改通知时被调用。
 * 具体观察者（Concrete Observer）角色：实现抽象观察者中定义的抽象方法，以便在得到目标的更改通知时更新自身的状态。
 */
public class ObserverPattern {
    public static void main(String[] args) {
        Subject subject = new Sub1();

        Observer o1 = new Observer1();
        Observer o2 = new Observer2();

        subject.add(o1);
        subject.add(o2);

        subject.notifyObserver();


    }
}

interface Subject {
    void add(Observer observer);

    void remove(Observer observer);

    void notifyObserver();
}

class Sub1 implements Subject {
    private List<Observer> list = new ArrayList<>();

    @Override
    public void add(Observer observer) {
        list.add(observer);
    }

    @Override
    public void remove(Observer observer) {
        list.remove(observer);
    }

    @Override
    public void notifyObserver() {
        for (Observer o : list) {
            o.response();
        }
    }
}


interface Observer {
    public void response();
}

class Observer1 implements Observer {

    @Override
    public void response() {
        System.out.println("观察者1做出反应");
    }
}

class Observer2 implements Observer {

    @Override
    public void response() {
        System.out.println("观察者2做出反应");
    }
}