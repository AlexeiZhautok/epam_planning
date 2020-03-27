package com.company;

import java.util.ArrayList;
import java.util.List;

public class Item {
    private String name;
    private int price;
    private int count;
    private List<Store> stores = new ArrayList<Store>();


    public Item(String name, int price, int count, ArrayList<Store> stores) {
        this.name = name;
        this.price = price;
        this.count = count;
        this.stores = stores;
    }

    @Override
    public String toString() {
        return "Item{" +
                "name='" + name + '\'' +
                ", price=" + price +
                ", count=" + count +
                ", stores=" + stores +
                '}';
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    public int getCount() {
        return count;
    }

    public List<Store> getStores() {
        return stores;
    }
}