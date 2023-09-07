package org.example.items;

import org.example.GameStatus;

import java.io.FileNotFoundException;

public class Room extends Item{
    public Room(String name) {
        super(name);
    }

    @Override
    public void use(GameStatus gameStatus) throws FileNotFoundException {

    }
}
