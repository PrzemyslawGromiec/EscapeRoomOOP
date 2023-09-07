package org.example.items;

import java.util.ArrayList;
import java.util.List;

public class RoomsFactoryMemory implements RoomsFactory {
    @Override
    public List<Item> getItemsForRoom(int roomNumber) {
        if (roomNumber == 1) {
            return createRoomNr1();
        } else if (roomNumber == 2) {
            return createRoomNr2();
        } else if (roomNumber == 3) {
            return createRoomNr3();
        } else if (roomNumber == 4) {
            return createRoomNr4();
        }
        return new ArrayList<>();
    }

    public List<Item> createRoomNr1() {
        List<Item> roomItems = new ArrayList<>();
        Key bigKey = new Key("Big key");
        Key smallKey = new Key("Small key");
        roomItems.add(bigKey);
        roomItems.add(new Door("Big door", bigKey));
        roomItems.add(new Window("Window"));
        roomItems.add(smallKey);
        return roomItems;
    }

    public List<Item> createRoomNr2() {
        List<Item> roomItems = new ArrayList<>();
        Key key1 = new Key("First Half Of The Key");
        Key key2 = new Key("Second half of the key");
        Door door = new Door("Special key door", key1, key2);
        roomItems.add(key1);
        roomItems.add(key2);
        roomItems.add(door);
        return roomItems;
    }

    private List<Item> createRoomNr3() {
        List<Item> roomItems = new ArrayList<>();
        Key key1 = new Key("Hidden key");
        Key key2 = new Key("Little key");
        Box box = new Box("Magic box", key1);
        Door door = new Door("Double locked door", key1, key2);
        roomItems.add(key2);
        roomItems.add(box);
        roomItems.add(door);
        return roomItems;
    }

    private List<Item> createRoomNr4() {
        List<Item> roomItems = new ArrayList<>();
        Window window1 = new Window("Small window");
        roomItems.add(window1);
        roomItems.add(new Window("Wide window"));
        roomItems.add(new Window("Roof window"));
        return roomItems;
    }

}
