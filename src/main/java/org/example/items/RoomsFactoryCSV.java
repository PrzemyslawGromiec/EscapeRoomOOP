package org.example.items;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class RoomsFactoryCSV implements RoomsFactory {

    @Override
    public List<Item> getItemsForRoom(int roomNumber) {
        try {
            return convertNamesToItems(roomNumber);
        } catch (FileNotFoundException e) {
            System.out.println("ERROR");
            return new ArrayList<>();
        }
    }


    public List<Item> convertNamesToItems(int roomNr) throws FileNotFoundException {
        List<Item> nameToItemList = new ArrayList<>();
        List<String> namesFromCSVFile = lineNR(roomNr);
        //Key key = new Key("key");

        for (String name : namesFromCSVFile) {
            if ("window".equals(name)) {
                nameToItemList.add(new Window("window"));
            } else if ("door".equals(name)) {
                nameToItemList.add(new Door("door", new Key("key")));
            } else if ("key".equals(name)) {
                nameToItemList.add(new Key("key"));
            } else if ("box".equals(name)) {
                nameToItemList.add(new Box("box", new Key("key")));
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
}
