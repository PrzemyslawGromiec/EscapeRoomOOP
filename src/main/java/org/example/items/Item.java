package org.example.items;

import java.util.List;

public abstract class Item {
    private String name;

    public Item(String name) {
        this.name = name;
    }

    public abstract void use(List<Item> items);
    public String getName() {
        return name;
    }
}
