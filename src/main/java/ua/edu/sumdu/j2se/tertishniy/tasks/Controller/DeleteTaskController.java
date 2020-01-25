package ua.edu.sumdu.j2se.tertishniy.tasks.Controller;

import ua.edu.sumdu.j2se.tertishniy.tasks.Model.ArrayTaskList;
import ua.edu.sumdu.j2se.tertishniy.tasks.Model.Task;
import ua.edu.sumdu.j2se.tertishniy.tasks.View.PrintInfoOfTasksView;

import java.util.Scanner;

public class DeleteTaskController extends Controller {
    public static void deleteTask (ArrayTaskList arrayTaskList) {
        PrintInfoOfTasksView.printListOfTasks(arrayTaskList);
        System.out.println("Enter the number of the task you want to delete");
        Scanner taskDeleteScanner = new Scanner(System.in);
        int indexDelete = taskDeleteScanner.nextInt() - 1;
        Task taskDelete = arrayTaskList.getTask(indexDelete);
        if (arrayTaskList.remove(taskDelete)) {
            System.out.println("Task successfully " + taskDelete.getTitle() + " deleted!");
        }
    }
}
