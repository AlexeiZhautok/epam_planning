
package com.company;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

public class ItemStream {
    private Stream<Item> stream;
    private ItemCollection i_collection = new ItemCollection();

    private void UpdateStream() {
        stream.close();
        stream = i_collection.getArray().stream();
    }

    public ItemStream(ItemCollection input) {
        i_collection = input;
        stream = input.getArray().stream();
    }

    public boolean AreThereItemExpensiveThen(int i_price) {
        long result = stream.filter((Item obj) -> { return obj.getPrice() > i_price; }).count();
        UpdateStream();
        return result==0;
    }

    public int FindMaxCount() {
        int result = stream.max(Comparator.comparing(Item::getCount)).get().getCount();
        UpdateStream();
        return result;
    }

    public int FindMinCount() {
        int result = stream.min(Comparator.comparing(Item::getCount)).get().getCount();
        UpdateStream();
        return result;
    }

    public ArrayList<Item> FilterItemsWithSingleStore() {
        ArrayList<Item> result = new ArrayList<Item>(stream.filter((Item obj) -> { return obj.getStores().size() == 1; }).collect(toList()));
        UpdateStream();
        return result;
    }

    public ArrayList<Item> SortItemsByPrise() {
        ArrayList<Item> result = new ArrayList<Item>(stream.sorted(Comparator.comparing(Item::getPrice)).collect(toList()));
        UpdateStream();
        return result;
    }

    public ArrayList<Item> SortItemsByCount() {
        ArrayList<Item> result = new ArrayList<Item>(stream.sorted(Comparator.comparing(Item::getCount)).collect(toList()));
        UpdateStream();
        return result;
    }

    public ArrayList<Store> GetStores() {
        ArrayList<Store> result = new ArrayList<>(stream.flatMap(e->e.getStores().stream()).collect(Collectors.toList()));
        UpdateStream();
        return result;
    }

    public ArrayList<Store> GetStoresNoDublicates() {
        ArrayList<Store> result = new ArrayList<>(stream.flatMap(e->e.getStores().stream()).distinct().collect(Collectors.toList()));
        UpdateStream();
        return result;
    }

    public void PrintStoreForEach() {
        stream.forEach(obj -> System.out.println(obj.getStores() ));
        UpdateStream();
    }
}