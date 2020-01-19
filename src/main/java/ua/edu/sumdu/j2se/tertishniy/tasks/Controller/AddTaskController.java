package ua.edu.sumdu.j2se.tertishniy.tasks.Controller;

import ua.edu.sumdu.j2se.tertishniy.tasks.Model.ArrayTaskList;
import ua.edu.sumdu.j2se.tertishniy.tasks.Model.Task;
import ua.edu.sumdu.j2se.tertishniy.tasks.View.AddTaskView;

import java.time.LocalDateTime;
import java.util.Scanner;

public class AddTaskController extends Controller {
    public static void addTask (ArrayTaskList arrayTaskList) {
        AddTaskView.printRepeatedQuestion();
        Scanner taskScanner = new Scanner(System.in);
        int isRepeated;
        isRepeated = taskScanner.nextInt();
        switch (isRepeated) {
            case 1:
                Scanner gg = new Scanner(System.in);
                System.out.println("Enter title of task:");
                String repeatedTaskTitle = gg.nextLine();
                System.out.println("Enter start of task:");
                LocalDateTime start = EnterLocalDateTimeController.getDate();
                System.out.println("Enter end of task:");
                LocalDateTime end = EnterLocalDateTimeController.getDate();
                System.out.println("Enter an interval:");
                int interval = taskScanner.nextInt();
                Task repeatedTask = new Task(repeatedTaskTitle, start, end, interval);
                arrayTaskList.add(repeatedTask);
                break;
            case 2:
                System.out.println("Enter title of task:");
                String notRepeatedTaskTitle = taskScanner.nextLine();
                System.out.println("Enter time of task:");
                LocalDateTime time = EnterLocalDateTimeController.getDate();
                Task notRepeatedTask = new Task(notRepeatedTaskTitle, time);
                arrayTaskList.add(notRepeatedTask);
                break;
        }
    }
}
