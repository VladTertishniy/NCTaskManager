package ua.edu.sumdu.j2se.tertishniy.tasks.view;

import ua.edu.sumdu.j2se.tertishniy.tasks.model.Task;

import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class AddDeleteTaskView extends View {

    public static int printRepeatedQuestion() {
        System.out.println("Task is repeated?");
        System.out.println("1. Yes.");
        System.out.println("2. No.");
        int answer;
        Scanner taskScanner = new Scanner(System.in);
        try {
            answer = taskScanner.nextInt();
            if (answer < 1 || answer > 2) {
                System.out.println("Incorrect value! Please, try again.");
                return printRepeatedQuestion();
            }
        } catch (InputMismatchException e) {
            System.out.println("Incorrect value! Please, try again.");
            return printRepeatedQuestion();
        }
        catch (NoSuchElementException | IllegalStateException e) {
            System.out.println("Error! Please, try again.");
            return printRepeatedQuestion();
        }
        return answer;
    }

    public static String enterTitleOfTask() {
        Scanner scannerCase2 = new Scanner(System.in);
        System.out.println("Enter title of task:");
        try {
            return scannerCase2.nextLine();
        } catch (NoSuchElementException | IllegalStateException e) {
            System.out.println("Error! Please, try again.");
            return enterTitleOfTask();
        }
    }

    public static int enterInterval() {
        int interval;
        System.out.println("Enter an interval:");
        Scanner scanner = new Scanner(System.in);
        try {
            interval = scanner.nextInt();
            if (interval <= 0) {
                System.out.println("Incorrect value! Please, try again.");
                return enterInterval();
            }
        } catch (InputMismatchException e) {
            System.out.println("Incorrect value! Please, try again.");
            return enterInterval();
        }
        catch (NoSuchElementException | IllegalStateException e) {
            System.out.println("Error! Please, try again.");
            return enterInterval();
        }
        return interval;
    }

    public static int getDeleteNumberTask(int amOfTasks) {
        System.out.println("Enter the number of the task you want to delete");
        Scanner taskDeleteScanner = new Scanner(System.in);
        int deleteNumber;
        try {
            deleteNumber = taskDeleteScanner.nextInt();
            if (deleteNumber <= 0 || deleteNumber > amOfTasks) {
                System.out.println("Incorrect value! Please, try again.");
                return getDeleteNumberTask(amOfTasks);
            }
        } catch (InputMismatchException e) {
            System.out.println("Incorrect value! Please, try again.");
            return getDeleteNumberTask(amOfTasks);
        }
        catch (NoSuchElementException | IllegalStateException e) {
            System.out.println("Error! Please, try again.");
            return getDeleteNumberTask(amOfTasks);
        }
        return deleteNumber - 1;
    }

    public static void printSuccessfullyDeleting(Task taskDelete) {
        System.out.println("Task " + taskDelete.getTitle() + " successfully deleted!");
    }
}
