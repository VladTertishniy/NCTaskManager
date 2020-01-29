package ua.edu.sumdu.j2se.tertishniy.tasks.view;

import ua.edu.sumdu.j2se.tertishniy.tasks.model.ArrayTaskList;
import ua.edu.sumdu.j2se.tertishniy.tasks.model.Task;

import java.time.LocalDateTime;
import java.util.Map;
import java.util.Set;
import java.util.SortedMap;

public class PrintInfoOfTasksView {
    public static void printArrayTaskListOfTasks(ArrayTaskList arrayTaskList) {
        int count = 0;
        for (Task task: arrayTaskList) {
            System.out.println( count + 1 + ". " + task.getTitle());
            count++;
        }
    }

    public static void printInfoAboutTasks (ArrayTaskList arrayTaskList) {
        int count = 0;
        for (Task task: arrayTaskList) {
            if (task.isRepeated()) {
                System.out.println( count + 1 + ". Title: " + task.getTitle() + "; Repeat interval: " + task.getRepeatInterval() + "; Start time: " + task.getStartTime() + "; End time: " + task.getEndTime() + "; Active: " + task.isActive());
                count++;
            } else {
                System.out.println( count + 1 + ". Title: " + task.getTitle() + "; Time:" + task.getTime() + "; Active: " + task.isActive());
                count++;
            }
        }
    }

    public static void printInfoAboutTasks (Set<Task> setOfTasks) {
        int count = 0;
        for (Task task: setOfTasks) {
            if (task.isRepeated()) {
                System.out.println( count + 1 + ". Title: " + task.getTitle() + "; Repeat interval: " + task.getRepeatInterval() + "; Start time: " + task.getStartTime() + "; End time: " + task.getEndTime() + "; Active: " + task.isActive());
                count++;
            } else {
                System.out.println( count + 1 + ". Title: " + task.getTitle() + "; Time:" + task.getTime() + "; Active: " + task.isActive());
                count++;
            }
        }
    }

    public static void printCalendarListOfTasks(SortedMap<LocalDateTime, Set<Task>> result) {
        for (Map.Entry<LocalDateTime, Set<Task>> element: result.entrySet()) {
            Set<Task> setOfTasks = element.getValue();
            LocalDateTime date = element.getKey();
            System.out.println("For " + date.toString() + " you have: ");
            PrintInfoOfTasksView.printInfoAboutTasks(setOfTasks);
        }
    }
}
