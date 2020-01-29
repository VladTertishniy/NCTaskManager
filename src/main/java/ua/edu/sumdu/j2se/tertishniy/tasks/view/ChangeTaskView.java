package ua.edu.sumdu.j2se.tertishniy.tasks.view;

import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class ChangeTaskView extends View {
    public static int printMenu() {
        System.out.println("1. Change title.");
        System.out.println("2. Change time.");
        System.out.println("3. Change start time, end time and interval.");
        System.out.println("4. Change active.");
        System.out.println("5. Return to the main menu.");
        Scanner taskChangeOptionNumberScanner = new Scanner(System.in);
        int actionNumber;
        try {
            actionNumber = taskChangeOptionNumberScanner.nextInt();
            if (actionNumber < 1 || actionNumber > 5) {
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
        return actionNumber;
    }

    public static int enterTaskNumberToChange(int amOfTasks) {
        System.out.println("Enter the number of the task you want to change");
        Scanner taskChangeNumberScanner = new Scanner(System.in);
        int taskNumber;
        try {
            taskNumber = taskChangeNumberScanner.nextInt();
            if (taskNumber < 1 || taskNumber > amOfTasks) {
                System.out.println("Incorrect value! Please, try again.");
                return enterTaskNumberToChange(amOfTasks);
            }
        } catch (InputMismatchException e) {
            System.out.println("Incorrect value! Please, try again.");
            return enterTaskNumberToChange(amOfTasks);
        }
        catch (NoSuchElementException | IllegalStateException e) {
            System.out.println("Error! Please, try again.");
            return enterTaskNumberToChange(amOfTasks);
        }
        return taskNumber - 1;
    }

    public static int enterActivity() {
        System.out.println("1. Set active = true.");
        System.out.println("2. Set active = false.");
        Scanner activityNumberScanner = new Scanner(System.in);
        int numberOfActivity;
        try {
            numberOfActivity = activityNumberScanner.nextInt();
            if (numberOfActivity < 1 || numberOfActivity > 2) {
                System.out.println("Incorrect value! Please, try again.");
                return enterActivity();
            }
        } catch (InputMismatchException e) {
            System.out.println("Incorrect value! Please, try again.");
            return enterActivity();
        }
        catch (NoSuchElementException | IllegalStateException e) {
            System.out.println("Error! Please, try again.");
            return enterActivity();
        }
        return numberOfActivity;
    }
}
