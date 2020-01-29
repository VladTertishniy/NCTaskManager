package ua.edu.sumdu.j2se.tertishniy.tasks.controller;

import ua.edu.sumdu.j2se.tertishniy.tasks.model.ArrayTaskList;
import ua.edu.sumdu.j2se.tertishniy.tasks.model.Task;
import ua.edu.sumdu.j2se.tertishniy.tasks.view.AddDeleteTaskView;
import ua.edu.sumdu.j2se.tertishniy.tasks.view.PrintInfoOfTasksView;

public class DeleteTaskController extends Controller {
    public static void deleteTask (ArrayTaskList arrayTaskList) {
        PrintInfoOfTasksView.printArrayTaskListOfTasks(arrayTaskList);
        int indexDelete = AddDeleteTaskView.getDeleteNumberTask(arrayTaskList.size());
        Task taskDelete = arrayTaskList.getTask(indexDelete);
        if (arrayTaskList.remove(taskDelete)) {
            AddDeleteTaskView.printSuccessfullyDeleting(taskDelete);
        }
    }
}
