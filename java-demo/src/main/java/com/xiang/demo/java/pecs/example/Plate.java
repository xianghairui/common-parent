package com.xiang.demo.java.pecs.example;

/**
 * Auther: xianghairui
 * Date: 2018/8/30 18:24
 * Description:
 */
public class Plate<T> {

    private T item;

    public Plate(T item) {
        this.item = item;
    }

    public T getItem() {
        return item;
    }

    public void setItem(T item) {
        this.item = item;
    }

    @Override
    public String toString() {
        return "Plate{" +
                "item=" + item +
                '}';
    }
}
