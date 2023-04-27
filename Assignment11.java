
/**
 * Assignment #11:
 * Name: Cameron Brethauer 
 * StudentID: 1224723136
 * Lecture: TThu 10:30AM
 * Description: This is the main class of the program that takes all of the other classes' methods and
 * adds them to the case statements in the menu to make the program functional.
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Assignment11 {
    public static void main(String[] args) {
        ZyBoxLiveStore store = new ZyBoxLiveStore();
        boolean quit = false;
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("Welcome to CS ZyBox Live, your #1 online store for video games!\n"
                + "With its vast selection of titles, lightning-fast download speeds, and prices so low they'll make your head spin,\n"
                + "ZyBox Live is the ultimate destination for gamers everywhere.\nAnd the best part? You don't even have to leave your house to get there!");

        while (!quit) {
            System.out.println("\nPlease choose from the following options:");
            System.out.println("A - Add a game to the store");
            System.out.println("R - Remove a game from the store");
            System.out.println("C - Count games in the store");
            System.out.println("L - List all games in the store (sorted by price from low to high)");
            System.out.println("F - Find a game in the store (by price)");
            System.out.println("P - Find the most popular game");
            System.out.println("V - Calculate total store value");
            System.out.println("Q - Quit\n");

            try {
                String choice = reader.readLine();

                switch (choice.toUpperCase()) {
                    case "A":
                        System.out.println(
                                "Enter game details: name, description, price, downloads (separated by commas)");
                        String[] gameDetails = reader.readLine().split("\\s*,\\s*");
                        Game gameToAdd = new Game(gameDetails[0], gameDetails[1], Double.parseDouble(gameDetails[2]),
                                Integer.parseInt(gameDetails[3]));
                        store.setRoot(store.addGameToStore(store.getRoot(), gameToAdd));
                        System.out.println(gameToAdd.getName() + " is available for purchase.");
                        break;
                    case "R":
                        System.out.println("Please enter the name of the game to be removed:");
                        String gameName = reader.readLine();
                        Game game = store.searchByName(store.getRoot(), gameName);
                        if (game != null) {
                            store.setRoot(store.removeGameFromStore(store.getRoot(), game.getPrice()));
                            System.out.println("Game " + gameName + " was removed successfully.");
                        } else {
                            System.out.println("Game " + gameName + " not found.");
                        }
                        break;
                    case "C":
                        int count = store.countGamesInStore(store.getRoot());
                        System.out.println("The store offers " + count + " game(s).");
                        
                        break;
                    case "L":
                        if (store.getRoot()==null)
                            System.out.println("No games in the store.");
                        else
                            store.listGamesByPrice(store.getRoot());
                        break;
                    case "F":
                        System.out.println("Please enter the price:");
                        double price = Double.parseDouble(reader.readLine());
                        Game searchResult = store.searchByPrice(store.getRoot(), price);
                        if (searchResult != null) {
                            System.out.print("Game found: ");
                            System.out.println(searchResult.toString());
                        } else {
                            System.out.println("No price match found.");
                        }
                        break;
                    case "P":
                        Game result = store.searchMostPopularGame(store.getRoot());
                        if (result != null) {
                            System.out.println("Most popular game found:");
                            System.out.println(result.toString());
                        } else {
                            System.out.println("No games in the store.");
                        }
                        break;
                    case "V":
                        double value = store.calculateStoreValue(store.getRoot());
                        System.out.printf("The store has $%.2f worth of games.\n", value);
                        break;
                    case "Q":
                        quit = true;
                        System.out.println("Thank you for making MS ZyBox Live the #1 online store!");
                        break;
                    default:
                        System.out.println("Invalid choice, please try again.");
                        break;
                }
            } catch (IOException e) {
                System.out.println("Error reading input. Please try again.");

            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please try again.");

            } catch (ArrayIndexOutOfBoundsException e) {
                System.out.println("Wrong number of parameters. Please try again.");
            }
        }
    }
}