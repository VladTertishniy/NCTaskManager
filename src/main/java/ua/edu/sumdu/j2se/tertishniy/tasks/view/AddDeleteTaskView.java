package ua.edu.sumdu.j2se.tertishniy.tasks.view;

import org.apache.log4j.Logger;
import ua.edu.sumdu.j2se.tertishniy.tasks.model.Task;

import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class AddDeleteTaskView extends View {

    final static Logger logger = Logger.getLogger(AddDeleteTaskView.class);

    public static int printRepeatedQuestion() {
        logger.info("Print repeated question.");
        System.out.println("Task is repeated?");
        System.out.println("1. Yes.");
        System.out.println("2. No.");
        int answer;
        Scanner taskScanner = new Scanner(System.in);
        try {
            answer = taskScanner.nextInt();
            if (answer < 1 || answer > 2) {
                System.out.println("Incorrect value! Please, try again.");
                logger.info("User enter incorrect value.");
                return printRepeatedQuestion();
            }
        } catch (InputMismatchException e) {
            System.out.println("Incorrect value! Please, try again.");
            logger.info("User enter incorrect value.");
            return printRepeatedQuestion();
        }
        catch (NoSuchElementException | IllegalStateException e) {
            System.out.println("Error! Please, try again.");
            logger.info("Error: " + e.getMessage());
            return printRepeatedQuestion();
        }
        return answer;
    }

    public static String enterTitleOfTask() {
        logger.info("Enter title of task operation started.");
        Scanner scannerCase2 = new Scanner(System.in);
        System.out.println("Enter title of task:");
        try {
            logger.info("Enter title of task operation finished.");
            return scannerCase2.nextLine();
        } catch (NoSuchElementException | IllegalStateException e) {
            System.out.println("Error! Please, try again.");
            logger.info("Error: " + e.getMessage());
            return enterTitleOfTask();
        }
    }

    public static int enterInterval() {
        logger.info("Enter interval operation started.");
        int interval;
        System.out.println("Enter an interval:");
        Scanner scanner = new Scanner(System.in);
        try {
            interval = scanner.nextInt();
            if (interval <= 0) {
                System.out.println("Incorrect value! Please, try again.");
                logger.info("User enter incorrect value.");
                return enterInterval();
            }
        } catch (InputMismatchException e) {
            System.out.println("Incorrect value! Please, try again.");
            logger.info("User enter incorrect value.");
            return enterInterval();
        }
        catch (NoSuchElementException | IllegalStateException e) {
            System.out.println("Error! Please, try again.");
            logger.info("Error: " + e.getMessage());
            return enterInterval();
        }
        logger.info("Enter interval operation finished.");
        return interval;
    }

    public static int getDeleteNumberTask(int amOfTasks) {
        logger.info("Get delete number of operation started.");
        System.out.println("Enter the number of the task you want to delete");
        Scanner taskDeleteScanner = new Scanner(System.in);
        int deleteNumber;
        try {
            deleteNumber = taskDeleteScanner.nextInt();
            if (deleteNumber <= 0 || deleteNumber > amOfTasks) {
                System.out.println("Incorrect value! Please, try again.");
                logger.info("User enter incorrect value.");
                return getDeleteNumberTask(amOfTasks);
            }
        } catch (InputMismatchException e) {
            System.out.println("Incorrect value! Please, try again.");
            logger.info("User enter incorrect value.");
            return getDeleteNumberTask(amOfTasks);
        }
        catch (NoSuchElementException | IllegalStateException e) {
            System.out.println("Error! Please, try again.");
            logger.info("Error: " + e.getMessage());
            return getDeleteNumberTask(amOfTasks);
        }
        logger.info("Get delete number of operation finished.");
        return deleteNumber - 1;
    }

    public static void printSuccessfullyDeleting(Task taskDelete) {
        logger.info("Task successfully deleted!");
        System.out.println("Task " + taskDelete.getTitle() + " successfully deleted!");
    }
}
