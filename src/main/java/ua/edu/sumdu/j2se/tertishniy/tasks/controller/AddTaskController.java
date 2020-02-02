package ua.edu.sumdu.j2se.tertishniy.tasks.controller;

import org.apache.log4j.Logger;
import ua.edu.sumdu.j2se.tertishniy.tasks.model.ArrayTaskList;
import ua.edu.sumdu.j2se.tertishniy.tasks.model.Task;
import ua.edu.sumdu.j2se.tertishniy.tasks.view.AddDeleteTaskView;
import ua.edu.sumdu.j2se.tertishniy.tasks.view.EnterLocalDateTimeView;

import java.time.LocalDateTime;

public class AddTaskController extends Controller {

    final static Logger logger = Logger.getLogger(AddTaskController.class);

    public static void addTask (ArrayTaskList arrayTaskList) {
        logger.info("Add task operation started.");
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
                logger.info("Add task operation finished.");
                break;
            case 2:
                String notRepeatedTaskTitle = AddDeleteTaskView.enterTitleOfTask();
                EnterLocalDateTimeView enterLocalDateTimeViewNotRepeated = new EnterLocalDateTimeView();
                LocalDateTime time = enterLocalDateTimeViewNotRepeated.getDate("Enter time of task:");
                Task notRepeatedTask = new Task(notRepeatedTaskTitle, time);
                arrayTaskList.add(notRepeatedTask);
                logger.info("Add task operation finished.");
                break;
        }
    }
}
