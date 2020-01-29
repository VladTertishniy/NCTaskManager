package ua.edu.sumdu.j2se.tertishniy.tasks.view;

import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class MainView extends View {

    public static int printMenu() {
        System.out.println("Choose an action:");
        System.out.println("1. Add task.");
        System.out.println("2. Change task.");
        System.out.println("3. Delete task.");
        System.out.println("4. Print info about tasks.");
        System.out.println("5. Print calendar.");
        System.out.println("6. Exit.");
        Scanner scanner = new Scanner(System.in);
        int menuNumber;
        try {
            menuNumber = scanner.nextInt();
            if (menuNumber < 1 || menuNumber > 6) {
                System.out.println("Incorrect value! Please, try again.");
                return printMenu();
            }
        } catch (InputMismatchException e) {
            System.out.println("Incorrect value! Please, try again.");
            return printMenu();
        }
        catch (NoSuchElementException | IllegalStateException e) {
            System.out.println("Error! Please, try again.");
            return printMenu();
        }
        return menuNumber;
    }
}
