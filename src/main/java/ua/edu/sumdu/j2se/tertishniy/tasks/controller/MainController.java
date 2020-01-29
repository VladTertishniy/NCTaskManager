package ua.edu.sumdu.j2se.tertishniy.tasks.controller;

import ua.edu.sumdu.j2se.tertishniy.tasks.model.ArrayTaskList;
import ua.edu.sumdu.j2se.tertishniy.tasks.view.MainView;
import ua.edu.sumdu.j2se.tertishniy.tasks.view.PrintInfoOfTasksView;

public class MainController extends Controller {
    @Override
    public void run(ArrayTaskList arrayTaskList) {
        while (true) {
            int x = MainView.printMenu();
            switch (x) {
                case 1:
                    AddTaskController.addTask(arrayTaskList);
                    break;
                case 2:
                    ChangeTaskController.changeTask(arrayTaskList);
                    break;
                case 3:
                    DeleteTaskController.deleteTask(arrayTaskList);
                    break;
                case 4:
                    PrintInfoOfTasksView.printInfoAboutTasks(arrayTaskList);
                    break;
                case 5:
                    PrintCalendarController.printCalendar(arrayTaskList);
                    break;
                case 6:
                    return;
            }
        }
    }
}
