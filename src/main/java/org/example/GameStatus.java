package org.example;

import org.example.items.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class GameStatus {
    private boolean running = true;
    private List<Item> items;
    private int roomNr;
    private List<Item> currentRoomItems;

    public GameStatus(List<Item> items) throws FileNotFoundException {
        this.items = items;
        this.roomNr = 1;
        this.currentRoomItems = convertNamesToItems(lineNR(roomNr));
    }

    public List<Item> getCurrentRoomItems() throws FileNotFoundException {
        return currentRoomItems;
    }


    public void nextRoom() throws FileNotFoundException {
        currentRoomItems = convertNamesToItems(lineNR(roomNr++));
    }

    public List<Item> convertNamesToItems(List<String> namesFromCSVFile) throws FileNotFoundException {
        List<Item> nameToItemList = new ArrayList<>();
        namesFromCSVFile = lineNR(roomNr);
        Key key = new Key("key");
        for (String name : namesFromCSVFile) {
            if ("window".equals(name)) {
                nameToItemList.add(new Window("window"));
            } else if ("door".equals(name)) {
                nameToItemList.add(new Door("door", key));
            } else if ("key".equals(name)) {
                nameToItemList.add(key);
            } else if ("box".equals(name)) {
                nameToItemList.add(new Box("box"));
            } else {
                System.out.println("Item is not recognized: " + name);
            }
        }
        return nameToItemList; //todo implement
    }

    public List<String> lineNR(int nr) throws FileNotFoundException {
        Scanner sc = new Scanner(new File("src/main/java/org/example/rooms.csv"));
        List<String> lineNr = new ArrayList<>();
        for (int i = 0; i < nr; i++) {
            if (sc.hasNext()) {
                String fileLine = sc.nextLine();
                if (i == nr - 1) {
                    String[] lineArray = fileLine.split(";");
                    lineNr.addAll(Arrays.asList(lineArray));
                }
            } else {
                lineNr = new ArrayList<>();
            }
        }
        return lineNr;
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

    public int getRoomNr() {
        return roomNr;
    }

}
