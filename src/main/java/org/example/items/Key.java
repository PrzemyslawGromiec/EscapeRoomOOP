package org.example.items;

import org.example.GameStatus;

import java.io.FileNotFoundException;

public class Key extends Item{
    public Key(String name) {
        super(name);
    }

    @Override
    public void use (GameStatus gameStatus) throws FileNotFoundException {
        gameStatus.getRoomItems().remove(this);
        gameStatus.getUserItems().add(this);
    }


}
