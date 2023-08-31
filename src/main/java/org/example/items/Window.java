package org.example.items;

import org.example.items.Item;

public class Window extends Item {
    private boolean isOpen;
    public Window(String name) {
        super(name);
        isOpen = false;
    }

    public void use() {
        isOpen = !isOpen;
        System.out.println(isOpen ? "Window open" : "Window closed");;
    }
}
