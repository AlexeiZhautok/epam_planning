
package com.company;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;
public class ItemStream {
    private Stream<Item> stream;
    private ItemCollection i_collection = new ItemCollection();
    private Stream<Item> stream2;
    private ItemCollection i_collection2 = new ItemCollection();

    private void UpdateStream() {
        stream.close();
        stream = i_collection.getArray().stream();
        stream2.close();
        stream2 = i_collection2.getArray().stream();
    }

    public ItemStream(ItemCollection input) {
        i_collection = input;
        stream = input.getArray().stream();
        i_collection2 = input;
        stream2 = input.getArray().stream();
    }

    public boolean PriceOverThen(int i_price) {
      long result = stream.filter((Item obj) -> { return obj.getPrice() > i_price; }).peek(System.out::println).count();
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

    public ArrayList<Item> SinglStoreItemNonParallel() {
        long m = System.currentTimeMillis();
        ArrayList<Item> result = new ArrayList<Item>(stream.filter((Item obj) -> { return obj.getStores().size() == 1; }).collect(toList()));
        System.out.println((double) (System.currentTimeMillis() - m));
        UpdateStream();
        return result;
    }



    public ArrayList<Item> SinglStoreItem() {
        long m = System.currentTimeMillis();
        ArrayList<Item> result = new ArrayList<Item>(stream.parallel().filter((Item obj) -> { return obj.getStores().size() == 1; }).collect(toList()));
        System.out.println((double) (System.currentTimeMillis() - m));
        UpdateStream();
//        m = System.currentTimeMillis();
//        ArrayList<Item> result2 = new ArrayList<Item>(stream2.parallel().filter((Item obj) -> { return obj.getStores().size() == 1; }).collect(toList()));
//        System.out.println((double) (System.currentTimeMillis() - m));
//        UpdateStream();

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

    public ArrayList<Store> GetAllStores() {
        ArrayList<Store> result = new ArrayList<>(stream.flatMap(e->e.getStores().stream()).distinct().collect(Collectors.toList()));
        UpdateStream();
        return result;
    }

    public void PrintStoreForEach() {
        stream.forEach(obj -> System.out.println(obj.getStores() ));
        UpdateStream();
    }
}