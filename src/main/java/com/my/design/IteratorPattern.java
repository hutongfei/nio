package com.my.design;

import java.util.ArrayList;
import java.util.List;

/**
 * 迭代模式
 */
public class IteratorPattern {

    public static void main(String[] args) {
        ConcreteAggregate agg = new ConcreteAggregate();
        agg.add("aaa");
        agg.add("bbb");
        agg.add("cc");

        Iterator iterator = agg.getIterator();

        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }

}

interface Aggregate {
    public void add(Object obj);

    public void remove(Object obj);

    public Iterator getIterator();
}

/**
 * 操作类
 */
class ConcreteAggregate implements Aggregate {
    private List<Object> list = new ArrayList<Object>();

    public void add(Object obj) {
        list.add(obj);
    }

    public void remove(Object obj) {
        list.remove(obj);
    }

    public Iterator getIterator() {
        return (new ConcreteIterator(list));
    }
}

//抽象迭代器
interface Iterator {
    Object first();

    Object next();

    boolean hasNext();
}

// 具体迭代器
class ConcreteIterator implements Iterator {
    private List<Object> list = null;
    private int index = -1;

    public ConcreteIterator(List<Object> list) {
        this.list = list;
        index++;
    }

    @Override
    public Object first() {
        if (index == -1) {
            return list.get(++index) != null ? list.get(++index) : null;
        }
        return null;
    }

    @Override
    public Object next() {
        return list.get(index++);
    }

    @Override
    public boolean hasNext() {
        return index > -1 && index < list.size();
    }
}