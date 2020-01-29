package ua.edu.sumdu.j2se.tertishniy.tasks.controller;

import ua.edu.sumdu.j2se.tertishniy.tasks.model.ArrayTaskList;
import ua.edu.sumdu.j2se.tertishniy.tasks.model.Task;
import ua.edu.sumdu.j2se.tertishniy.tasks.model.Tasks;
import ua.edu.sumdu.j2se.tertishniy.tasks.view.EnterLocalDateTimeView;
import ua.edu.sumdu.j2se.tertishniy.tasks.view.PrintInfoOfTasksView;

import java.time.LocalDateTime;
import java.util.Set;
import java.util.SortedMap;

public class PrintCalendarController extends Controller {
    public static void printCalendar (ArrayTaskList arrayTaskList) {
        EnterLocalDateTimeView enterLocalDateTimeView = new EnterLocalDateTimeView();
        LocalDateTime startCalendar = enterLocalDateTimeView.getDate("Enter start date:");
        LocalDateTime endCalendar = enterLocalDateTimeView.getDate("Enter end date:");
        SortedMap<LocalDateTime, Set<Task>> result = Tasks.calendar(arrayTaskList, startCalendar, endCalendar);
        PrintInfoOfTasksView.printCalendarListOfTasks(result);
    }
}
