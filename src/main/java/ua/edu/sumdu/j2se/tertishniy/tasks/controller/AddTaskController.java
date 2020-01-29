package ua.edu.sumdu.j2se.tertishniy.tasks.controller;

import ua.edu.sumdu.j2se.tertishniy.tasks.model.ArrayTaskList;
import ua.edu.sumdu.j2se.tertishniy.tasks.model.Task;
import ua.edu.sumdu.j2se.tertishniy.tasks.view.AddDeleteTaskView;
import ua.edu.sumdu.j2se.tertishniy.tasks.view.EnterLocalDateTimeView;

import java.time.LocalDateTime;

public class AddTaskController extends Controller {
    public static void addTask (ArrayTaskList arrayTaskList) {
        int answerNumber = AddDeleteTaskView.printRepeatedQuestion();
        switch (answerNumber) {
            case 1:
                String repeatedTaskTitle = AddDeleteTaskView.enterTitleOfTask();
                EnterLocalDateTimeView enterLocalDateTimeViewRepeated = new EnterLocalDateTimeView();
                LocalDateTime start = enterLocalDateTimeViewRepeated.getDate("Enter start of task:");
                LocalDateTime end = enterLocalDateTimeViewRepeated.getDate("Enter end of task:");
                int interval = AddDeleteTaskView.enterInterval();
                Task repeatedTask = new Task(repeatedTaskTitle, start, end, interval);
                arrayTaskList.add(repeatedTask);
                break;
            case 2:
                String notRepeatedTaskTitle = AddDeleteTaskView.enterTitleOfTask();
                EnterLocalDateTimeView enterLocalDateTimeViewNotRepeated = new EnterLocalDateTimeView();
                LocalDateTime time = enterLocalDateTimeViewNotRepeated.getDate("Enter time of task:");
                Task notRepeatedTask = new Task(notRepeatedTaskTitle, time);
                arrayTaskList.add(notRepeatedTask);
                break;
        }
    }
}
