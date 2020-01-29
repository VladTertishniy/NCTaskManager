package ua.edu.sumdu.j2se.tertishniy.tasks.controller;

import ua.edu.sumdu.j2se.tertishniy.tasks.model.ArrayTaskList;
import ua.edu.sumdu.j2se.tertishniy.tasks.model.Task;
import ua.edu.sumdu.j2se.tertishniy.tasks.view.AddDeleteTaskView;
import ua.edu.sumdu.j2se.tertishniy.tasks.view.ChangeTaskView;
import ua.edu.sumdu.j2se.tertishniy.tasks.view.EnterLocalDateTimeView;
import ua.edu.sumdu.j2se.tertishniy.tasks.view.PrintInfoOfTasksView;

import java.time.LocalDateTime;

public class ChangeTaskController extends Controller {
    public static void changeTask (ArrayTaskList arrayTaskList) {
        PrintInfoOfTasksView.printArrayTaskListOfTasks(arrayTaskList);
        int indexChange = ChangeTaskView.enterTaskNumberToChange(arrayTaskList.size());
        Task taskChange = arrayTaskList.getTask(indexChange);
        int x;
        while (true) {
            x = ChangeTaskView.printMenu();
            switch (x) {
                case 1:
                    String title = AddDeleteTaskView.enterTitleOfTask();
                    taskChange.setTitle(title);
                    break;
                case 2:
                    EnterLocalDateTimeView enterLocalDateTimeViewCase2 = new EnterLocalDateTimeView();
                    LocalDateTime time = enterLocalDateTimeViewCase2.getDate("Enter the time");
                    taskChange.setTime(time);
                    break;
                case 3:
                    EnterLocalDateTimeView enterLocalDateTimeViewCase3 = new EnterLocalDateTimeView();
                    LocalDateTime start = enterLocalDateTimeViewCase3.getDate("Enter the start time");
                    LocalDateTime end = enterLocalDateTimeViewCase3.getDate("Enter the end time");
                    int interval = AddDeleteTaskView.enterInterval();
                    taskChange.setTime(start, end, interval);
                    break;
                case 4:
                    int active = ChangeTaskView.enterActivity();
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
