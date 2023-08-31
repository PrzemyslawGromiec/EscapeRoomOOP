package org.example;

import org.example.items.Item;

import java.util.List;

public class GameStatus {
    private boolean running = true;
    private List<Item> items;

    public GameStatus(List<Item> items) {
        this.items = items;
    }

    public void setRunning(boolean running) {
        this.running = running;
    }

    public boolean isRunning() {
        return running;
    }

    public List<Item> getItems() {
        return items;
    }
}
