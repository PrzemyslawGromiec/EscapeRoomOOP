package org.example;

import org.example.items.Door;
import org.example.items.Item;
import org.example.items.Key;
import org.example.items.Window;

import java.util.ArrayList;
import java.util.List;

public class EscapeRoomOOPDemo {
    public static void main(String[] args) {
        List<Item> userItems = new ArrayList<>();
        userItems.add(new Door("door"));
        userItems.add(new Key("key"));
        userItems.add(new Window("window"));

        System.out.println("Available items:");
        for (Item userItem : userItems) {
            System.out.println(userItem.getName());
        }
    }
}