package com.xiang.demo.java.pecs.example;

/**
 * Auther: xianghairui
 * Date: 2018/8/30 18:24
 * Description:
 */
public class Apple extends Fruit {

    private String apple;

    public String getApple() {
        return apple;
    }

    public void setApple(String apple) {
        this.apple = apple;
    }

    @Override
    public String toString() {
        return "Apple{" +
                "apple='" + apple + '\'' +
                '}';
    }
}
