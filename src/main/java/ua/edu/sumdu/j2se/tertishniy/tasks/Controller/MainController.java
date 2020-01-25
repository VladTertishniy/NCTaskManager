package ua.edu.sumdu.j2se.tertishniy.tasks.Controller;

import ua.edu.sumdu.j2se.tertishniy.tasks.Model.ArrayTaskList;
import ua.edu.sumdu.j2se.tertishniy.tasks.View.MainView;
import ua.edu.sumdu.j2se.tertishniy.tasks.View.PrintInfoOfTasksView;

import java.util.Scanner;

public class MainController extends Controller {
    @Override
    public void run(ArrayTaskList arrayTaskList) {
        Scanner scan = new Scanner(System.in);
        int x = 0;

        while (100 != x) {
            MainView.printMenu();
            x = scan.nextInt();
            switch (x) {
                /*Add task*/
                case 1:
                    AddTaskController.addTask(arrayTaskList);
                    break;
                /*Change task*/
                case 2:
                    ChangeTaskController.changeTask(arrayTaskList);
                    break;
                /*Delete task*/
                case 3:
                    DeleteTaskController.deleteTask(arrayTaskList);
                    break;
                /*Print info about tasks*/
                case 4:
                    PrintInfoOfTasksView.printInfoAboutTasks(arrayTaskList);
                    break;
                /*Print calendar*/
                case 5:
                    PrintCalendarController.printCalendar(arrayTaskList);
                    break;
                /*Exit*/
                case 6:
                    return;
            }
        }
    }
}
