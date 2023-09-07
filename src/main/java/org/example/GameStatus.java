package org.example;

import org.example.items.*;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

public class GameStatus {
    private boolean running = true;
    private int roomNr;
    private List<Item> roomItems;
    private RoomsFactory roomsFactory;
    private List<Item> userItems = new ArrayList<>();
    private List<Boolean> status = new ArrayList<>();

    public GameStatus(List<Item> roomItems)  {
        this.roomItems = roomItems;
        this.roomNr = 4;
//        this.currentRoomItems = convertNamesToItems(lineNR(roomNr)); //todo refactor
       // roomsFactory = new RoomsFactoryCSV();
        roomsFactory = new RoomsFactoryMemory();
        roomItems.addAll(roomsFactory.getItemsForRoom(roomNr));
    }

    public List<Item> getRoomItems() throws FileNotFoundException {
        return roomItems;
    }

    public void nextRoom() throws FileNotFoundException {
        roomItems.clear();
        roomItems.addAll(roomsFactory.getItemsForRoom(++roomNr));
    }


    public void setRunning(boolean running) {
        this.running = running;
    }

    public boolean isRunning() {
        return running;
    }


    public int getRoomNr() {
        return roomNr;
    }

    public List<Item> getUserItems() {
        return userItems;
    }

    public List<Boolean> getStatus() {
        return status;
    }
}


