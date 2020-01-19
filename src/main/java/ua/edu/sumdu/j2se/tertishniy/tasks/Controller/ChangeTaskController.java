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
        ChangeTaskView.printMenu();
        int x = 0;
        while (100 != x) {
            x = taskChangeScanner.nextInt();
            switch (x) {
                case 1:
                    System.out.println("Enter the title");
                    String title = taskChangeScanner.nextLine();
                    taskChange.setTitle(title);
                case 2:
                    System.out.println("Enter the time");
                    LocalDateTime time = EnterLocalDateTimeController.getDate();
                    taskChange.setTime(time);
                case 3:
                    System.out.println("Enter the start time");
                    LocalDateTime start = EnterLocalDateTimeController.getDate();
                    System.out.println("Enter the end time");
                    LocalDateTime end = EnterLocalDateTimeController.getDate();
                    System.out.println("Enter the interval");
                    int interval = taskChangeScanner.nextInt();
                    taskChange.setTime(start, end, interval);
                case 4:
                    System.out.println("1. Set active = true.");
                    System.out.println("2. Set active = false.");
                    int active = taskChangeScanner.nextInt();
                    if (active == 1) {
                        taskChange.setActive(true);
                    } else if (active == 2) {
                        taskChange.setActive(false);
                    }
                case 5:
                    break;
                case 6:
                    System.exit(0);
            }
        }
    }
}
