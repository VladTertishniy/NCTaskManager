package ua.edu.sumdu.j2se.tertishniy.tasks.View;

import ua.edu.sumdu.j2se.tertishniy.tasks.Model.ArrayTaskList;
import ua.edu.sumdu.j2se.tertishniy.tasks.Model.Task;

import java.util.Set;

public class PrintInfoOfTasksView {
    public static void printListOfTasks (ArrayTaskList arrayTaskList) {
        int count = 0;
        for (Task task: arrayTaskList) {
            System.out.println( count + 1 + ". " + task.getTitle());
        }
        /*for (int i = 0; i < arrayTaskList.size(); i++) {
            System.out.println(i + ". " + arrayTaskList.getTask(i).getTitle());
        }*/
    }

    public static void printInfoAboutTasks (ArrayTaskList arrayTaskList) {
        int count = 0;
        for (Task task: arrayTaskList) {
            if (task.isRepeated()) {
                System.out.println( count + 1 + ". Title: " + task.getTitle() + "; Repeat interval: " + task.getRepeatInterval() + "; Start time: " + task.getStartTime() + "; End time: " + task.getEndTime() + "; Active: " + task.isActive());
            } else {
                System.out.println( count + 1 + ". Title: " + task.getTitle() + "; Time:" + task.getTime() + "; Active: " + task.isActive());
            }
        }
    }

    public static void printInfoAboutTasks (Set<Task> setOfTasks) {
        int count = 0;
        for (Task task: setOfTasks) {
            if (task.isRepeated()) {
                System.out.println( count + 1 + ". Title: " + task.getTitle() + "; Repeat interval: " + task.getRepeatInterval() + "; Start time: " + task.getStartTime() + "; End time: " + task.getEndTime() + "; Active: " + task.isActive());
            } else {
                System.out.println( count + 1 + ". Title: " + task.getTitle() + "; Time:" + task.getTime() + "; Active: " + task.isActive());
            }
        }
    }
}
