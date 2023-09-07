package org.example.items;

import org.example.GameStatus;
import org.example.items.Item;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Window extends Item {
    private boolean isOpen;
    public Window(String name) {
        super(name);
        isOpen = false;
    }

    public void use( GameStatus gameStatus) throws FileNotFoundException {
        isOpen = !isOpen;
        System.out.println(isOpen ? "Window open" : "Window closed");
        checkAllWindowOpenAndAddDoor(gameStatus);

    }

    private void checkAllWindowOpenAndAddDoor(GameStatus gameStatus) throws FileNotFoundException {
        boolean allWindowsOpen = false;

        for (Item item : gameStatus.getRoomItems()) {
            if (item instanceof Window && !((Window) item).isOpen) {
                allWindowsOpen = true;
                break;
            }
        }
        if (!allWindowsOpen) {
            Door door = new Door("Hidden door");
            gameStatus.getRoomItems().add(door);
            System.out.println(door.getName() + " is visible now in your room!");
        }
    }
}
