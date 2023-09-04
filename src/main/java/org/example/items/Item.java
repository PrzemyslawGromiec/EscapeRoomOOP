package org.example.items;

import org.example.GameStatus;

import java.io.FileNotFoundException;
import java.util.List;

public abstract class Item {
    private String name;

    public Item(String name) {
        this.name = name;
    }

    public abstract void use(GameStatus gameStatus) throws FileNotFoundException;
    public String getName() {
        return name;
    }


}
