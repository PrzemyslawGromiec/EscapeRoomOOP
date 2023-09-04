package org.example;

import org.example.items.Door;
import org.example.items.Item;
import org.example.items.Key;
import org.example.items.Window;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class EscapeRoomOOPDemo {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner scanner = new Scanner(System.in);

        List<Item> userItems = new ArrayList<>();
        GameStatus gameStatus = new GameStatus(userItems);

        while (gameStatus.isRunning()) {
            List<Item> currentRoomItems = gameStatus.getCurrentRoomItems();
            System.out.println("Available items:");
            for (Item userItem : currentRoomItems) {
                System.out.println(userItem.getName());
            }

            System.out.println("\nEnter you choice below:");
            String choice = scanner.nextLine();
            boolean isPresent = false;

            for (Item userItem : currentRoomItems) {
                if (userItem.getName().equals(choice)) {
                    System.out.println("Using:" + userItem.getName());
                    userItem.use(gameStatus);
                    isPresent = true;
                    break;
                }
            }

            if(!isPresent) {
                System.out.println("Item not found in the room.");
            }
            System.out.println("Is item in your list? " + isPresent);

        }
    }
}