package org.example.items;

import org.example.GameStatus;

import java.util.List;

public class Door extends Item {
    private Key key;
    public Door(String name, Key key) {
        super(name);
        this.key = key;
    }

    @Override
    public void use(GameStatus gameStatus) {
        if (!gameStatus.getItems().contains(key)) {
            System.out.println("Opening doors. End of the game.");
            gameStatus.setRunning(false);
        } else {
            System.out.println("You must use key first.");
        }
    }


}
