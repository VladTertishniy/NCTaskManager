package ua.edu.sumdu.j2se.tertishniy.tasks.Controller;

import ua.edu.sumdu.j2se.tertishniy.tasks.Model.ArrayTaskList;
import ua.edu.sumdu.j2se.tertishniy.tasks.Model.Task;
import ua.edu.sumdu.j2se.tertishniy.tasks.View.ChangeTaskView;
import ua.edu.sumdu.j2se.tertishniy.tasks.View.PrintInfoOfTasksView;

import java.time.LocalDateTime;
import java.util.Scanner;

public class ChangeTaskController extends Controller {
    public static void changeTask (ArrayTaskList arrayTaskList) {
        PrintInfoOfTasksView.printListOfTasks(arrayTaskList);
        System.out.println("Enter the number of the task you want to change");
        Scanner taskChangeScanner = new Scanner(System.in);
        int indexChange = taskChangeScanner.nextInt() - 1;
        Task taskChange = arrayTaskList.getTask(indexChange);
        int x = 0;
        while (100 != x) {
            ChangeTaskView.printMenu();
            x = taskChangeScanner.nextInt();
            switch (x) {
                case 1:
                    Scanner scannerCase1 = new Scanner(System.in);
                    System.out.println("Enter the title");
                    String title = scannerCase1.nextLine();
                    taskChange.setTitle(title);
                    break;
                case 2:
                    System.out.println("Enter the time");
                    EnterLocalDateTimeController enterLocalDateTimeControllerCase2 = new EnterLocalDateTimeController();
                    LocalDateTime time = enterLocalDateTimeControllerCase2.getDate();
                    taskChange.setTime(time);
                    break;
                case 3:
                    Scanner scannerCase3 = new Scanner(System.in);
                    System.out.println("Enter the start time");
                    EnterLocalDateTimeController enterLocalDateTimeControllerCase3 = new EnterLocalDateTimeController();
                    LocalDateTime start = enterLocalDateTimeControllerCase3.getDate();
                    System.out.println("Enter the end time");
                    LocalDateTime end = enterLocalDateTimeControllerCase3.getDate();
                    System.out.println("Enter the interval");
                    int interval = scannerCase3.nextInt();
                    taskChange.setTime(start, end, interval);
                    break;
                case 4:
                    Scanner scannerCase4 = new Scanner(System.in);
                    System.out.println("1. Set active = true.");
                    System.out.println("2. Set active = false.");
                    int active = scannerCase4.nextInt();
                    if (active == 1) {
                        taskChange.setActive(true);
                    } else if (active == 2) {
                        taskChange.setActive(false);
                    }
                    break;
                case 5:
                    return;
            }
        }
    }
}
