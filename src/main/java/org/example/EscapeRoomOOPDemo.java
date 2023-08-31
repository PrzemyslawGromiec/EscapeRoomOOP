package org.example;

import org.example.items.Door;
import org.example.items.Item;
import org.example.items.Key;
import org.example.items.Window;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class EscapeRoomOOPDemo {
    public static void main(String[] args) {
        List<Item> userItems = new ArrayList<>();
        GameStatus gameStatus = new GameStatus(userItems);
        Key key = new Key("key");
        userItems.add(new Door("door", key ));
        userItems.add(key);
        userItems.add(new Window("window"));

        while (gameStatus.isRunning()) {
            System.out.println("Available items:");
            for (Item userItem : userItems) {
                System.out.println(userItem.getName());
            }

            Scanner scanner = new Scanner(System.in);
            String choice = scanner.nextLine();

            boolean isPresent = false;

            for (Item userItem : userItems) {
                if (userItem.getName().equals(choice)) {
                    System.out.println("Using:" + userItem.getName());
                    userItem.use(gameStatus);
                    isPresent = true;
                    break;
                }
            }
            System.out.println("Is item in your list? " + isPresent);

        }
    }
}