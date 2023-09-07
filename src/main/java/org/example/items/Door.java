package org.example.items;

import org.example.GameStatus;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

public class Door extends Item {
    private Key[] keys;

    public Door(String name, Key... keys) {
        super(name);
        this.keys = keys;
    }

    @Override
    public void use(GameStatus gameStatus) throws FileNotFoundException {
        List<Key> keys = new ArrayList<>();
        Collections.addAll(keys, this.keys);
        if (new HashSet<>(gameStatus.getUserItems()).containsAll(keys)) {
            System.out.println("You are in the next room.");
            gameStatus.nextRoom();
        } else {
            System.out.println("You need to use proper key first!");
        }
    }




    // kazde drzwi powinny byc zamkniete
    // potrzebny jest klucz -> jesli jest box, to klucz nie powinienen byc pokazywany, dopiero po otwarciu boxu, musi sie pokazac
    //wtedy mozna otwierac drzwi
}
