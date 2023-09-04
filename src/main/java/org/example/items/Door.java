package org.example.items;

import org.example.GameStatus;

import java.io.FileNotFoundException;
import java.util.List;

public class Door extends Item {
    private Key key;
    public Door(String name, Key key) {
        super(name);
        this.key = key;
    }

    @Override
    public void use(GameStatus gameStatus) throws FileNotFoundException {
        if (!gameStatus.getCurrentRoomItems().contains(key)) {
            System.out.println("Opening doors.");
            gameStatus.nextRoom();
            System.out.println("You are in next room.");
        } else {
            System.out.println("You must use key first.");
        }
    }
}
