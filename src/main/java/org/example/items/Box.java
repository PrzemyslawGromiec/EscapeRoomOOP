package org.example.items;

import org.example.GameStatus;

import java.io.FileNotFoundException;
import java.util.List;

public class Box extends Item{

    private Key key;

    public Box(String name, Key key) {
        super(name);
        this.key = key;
    }

    @Override
    public void use(GameStatus gameStatus) throws FileNotFoundException {
        gameStatus.getRoomItems().add(key);
        gameStatus.getRoomItems().remove(this);

        // gdy w pokoju jest box, to gracz musi najpierw wybrac box, zeby pokazal sie klucz
        //moze rowniez byc haslo do boxu

    }
}
