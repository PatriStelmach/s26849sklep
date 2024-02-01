package com.example.shopee_s26849;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
@Component
public class Storage
{
    public List<Item> itemStorage = new ArrayList<>();
    private static Storage instance;

    public Storage()
    {
        Item beer = new Item("beer", 69);
        Item milk = new Item("milk", 42.0);

        itemStorage.add(beer);
        itemStorage.add(milk);

    }

    public static Storage getInstance()
    {
        if (instance == null) {
            instance = new Storage();
        }
        return instance;
    }

    public void addItem(Item item)
    {
        itemStorage.add(item);
    }

    public List<Item> getItemStorage()
    {
        return itemStorage;
    }

}
