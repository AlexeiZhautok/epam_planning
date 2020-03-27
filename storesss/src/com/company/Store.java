package com.company;

import java.util.ArrayList;
import java.util.List;

public class Store {
    private String name;
    private List<Item> items = new ArrayList<Item>();
    private ArrayList<String> feedbackList = new ArrayList<>();


    public Store(String name) {
        this.name = name;
    }

    public List<Item> getItems() {
        return items;
    }

    public ArrayList<String> getFeedbackList() {
        return feedbackList;
    }

    @Override
    public String toString() {
        return "Store{" +
                "name='" + name + '\'' +
                ", items=" + items +
                ", feedbackList=" + feedbackList +
                '}';
    }
}