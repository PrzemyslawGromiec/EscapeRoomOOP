package org.example.items;

import java.util.List;

public class Key extends Item{
    public Key(String name) {
        super(name);
    }

    @Override
    public void use (List<Item> items) {
        items.remove(this);
    }
}
