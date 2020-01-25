package ua.edu.sumdu.j2se.tertishniy.tasks.Controller;

import ua.edu.sumdu.j2se.tertishniy.tasks.Model.ArrayTaskList;
import ua.edu.sumdu.j2se.tertishniy.tasks.Model.Task;
import ua.edu.sumdu.j2se.tertishniy.tasks.Model.Tasks;
import ua.edu.sumdu.j2se.tertishniy.tasks.View.PrintInfoOfTasksView;

import java.time.LocalDateTime;
import java.util.Map;
import java.util.Set;
import java.util.SortedMap;

public class PrintCalendarController extends Controller {
    public static void printCalendar (ArrayTaskList arrayTaskList) {
        System.out.println("Enter start date:");
        EnterLocalDateTimeController enterLocalDateTimeController = new EnterLocalDateTimeController();
        LocalDateTime startCalendar = enterLocalDateTimeController.getDate();
        System.out.println("Enter end date:");
        LocalDateTime endCalendar = enterLocalDateTimeController.getDate();
        SortedMap<LocalDateTime, Set<Task>> result = Tasks.calendar(arrayTaskList, startCalendar, endCalendar);
        for (Map.Entry<LocalDateTime, Set<Task>> element: result.entrySet()) {
            Set<Task> setOfTasks = element.getValue();
            LocalDateTime date = element.getKey();
            System.out.println("For " + date.toString() + " you have: ");
            PrintInfoOfTasksView.printInfoAboutTasks(setOfTasks);
            /*int count = 1;
            for (Task task:setOfTasks) {
                if (task.isRepeated()) {
                    System.out.println( count + 1 + ". Title: " + task.getTitle() + "; Repeat interval: " + task.getRepeatInterval() + "; Start time: " + task.getStartTime() + "; End time: " + task.getEndTime() + "; Active: " + task.isActive());
                } else {
                    System.out.println( count + 1 + ". Title: " + task.getTitle() + "; Time:" + task.getTime() + "; Active: " + task.isActive());
                }
                count++;
            }*/
        }
    }
}
