package ua.edu.sumdu.j2se.tertishniy.tasks.controller;

import org.apache.log4j.Logger;
import ua.edu.sumdu.j2se.tertishniy.tasks.model.ArrayTaskList;
import ua.edu.sumdu.j2se.tertishniy.tasks.model.Task;
import ua.edu.sumdu.j2se.tertishniy.tasks.view.AddDeleteTaskView;
import ua.edu.sumdu.j2se.tertishniy.tasks.view.ChangeTaskView;
import ua.edu.sumdu.j2se.tertishniy.tasks.view.EnterLocalDateTimeView;
import ua.edu.sumdu.j2se.tertishniy.tasks.view.PrintInfoOfTasksView;

import java.time.LocalDateTime;

public class ChangeTaskController extends Controller {

    final static Logger logger = Logger.getLogger(ChangeTaskController.class);

    public static void changeTask (ArrayTaskList arrayTaskList) {
        logger.info("Change task operation started.");
        PrintInfoOfTasksView.printArrayTaskListOfTasks(arrayTaskList);
        int indexChange = ChangeTaskView.enterTaskNumberToChange(arrayTaskList.size());
        Task taskChange = arrayTaskList.getTask(indexChange);
        int answerNumber;
        while (true) {
            answerNumber = ChangeTaskView.printMenu();
            switch (answerNumber) {
                case 1:
                    String title = AddDeleteTaskView.enterTitleOfTask();
                    taskChange.setTitle(title);
                    logger.info("Change title task operation finished.");
                    break;
                case 2:
                    EnterLocalDateTimeView enterLocalDateTimeViewCase2 = new EnterLocalDateTimeView();
                    LocalDateTime time = enterLocalDateTimeViewCase2.getDate("Enter the time");
                    taskChange.setTime(time);
                    logger.info("Change time task operation finished.");
                    break;
                case 3:
                    EnterLocalDateTimeView enterLocalDateTimeViewCase3 = new EnterLocalDateTimeView();
                    LocalDateTime start = enterLocalDateTimeViewCase3.getDate("Enter the start time");
                    LocalDateTime end = enterLocalDateTimeViewCase3.getDate("Enter the end time");
                    int interval = AddDeleteTaskView.enterInterval();
                    taskChange.setTime(start, end, interval);
                    logger.info("Change start and end time task operation finished.");
                    break;
                case 4:
                    int active = ChangeTaskView.enterActivity();
                    if (active == 1) {
                        taskChange.setActive(true);
                    } else if (active == 2) {
                        taskChange.setActive(false);
                    }
                    logger.info("Change activity task operation finished.");
                    break;
                case 5:
                    logger.info("Change task operation finished.");
                    return;
            }
        }
    }
}
