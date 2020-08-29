package com.my.design;

/**
 * 原型模式
 */
public class Prototype implements Cloneable {
    public static void main(String[] args) throws CloneNotSupportedException {
        Prototype prototype = new Prototype();
        prototype.setId(1);
        prototype.setName("张三");

        Prototype pro = (Prototype)prototype.clone();
        System.out.println(pro.getId() + pro.getName());
    }
    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    private Integer id;

    private String name;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
