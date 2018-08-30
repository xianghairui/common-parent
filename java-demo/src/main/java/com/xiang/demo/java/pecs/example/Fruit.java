package com.xiang.demo.java.pecs.example;

/**
 * Auther: xianghairui
 * Date: 2018/8/30 18:24
 * Description:
 */
public class Fruit {

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Fruit{" +
                "name='" + name + '\'' +
                '}';
    }
}
