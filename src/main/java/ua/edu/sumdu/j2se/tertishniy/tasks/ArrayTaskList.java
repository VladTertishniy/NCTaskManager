package ua.edu.sumdu.j2se.tertishniy.tasks;

import java.util.Arrays;
import java.util.Objects;

public class ArrayTaskList extends AbstractTaskList {

    private Task [] taskList = new Task [5];
    private int amOfTasks;

    public ArrayTaskList() {
    }

    public ArrayTaskList(int amount){
        if(amount < 1){
            throw new IllegalArgumentException("The length of the list can not be less than 0");
        }
        taskList = new Task[amount];
    }

    public void add(Task task) {
        if(task == null){
            throw new IllegalArgumentException("Try to add an empty task");
        }
        if(amOfTasks == taskList.length){
            Task [] temp = new Task[(int)(taskList.length * 1.2) + 1];
            for(int i = 0; i < /*taskList.length*/amOfTasks; i++){
                temp[i] = taskList[i];
            }
            taskList = temp;
        }
        taskList[amOfTasks] = task;
        amOfTasks++;
    }

    public boolean remove(Task task){
        if(task == null){
            throw new IllegalArgumentException("Try to remove an empty task");
        }
        if(amOfTasks >= 1){
            for(int i = 0; i < amOfTasks; i++){
                if(taskList[i].equals(task)){
                    taskList[i] = taskList[amOfTasks - 1];
                    taskList[amOfTasks - 1] = null;
                    amOfTasks--;
                    return true;
                }
            }
        }
        return false;
    }

    public int size(){
        return amOfTasks;
    }

    public Task getTask(int index){
        if(index < amOfTasks && index >= 0){
            return taskList[index];
        }
        else{
            return null;
        }
    }

    /*public ArrayTaskList incoming(int from, int to){
        if (from < 0) {
            throw new IllegalArgumentException("The from must be greater than 0");
        }
        if (to <= 0) {
            throw new IllegalArgumentException("The to must be greater than 0");
        }
        ArrayTaskList subset = new ArrayTaskList();
        for(int i = 0; i < amOfTasks; i++) {
            if(taskList[i].nextTimeAfter(from) > from &&  taskList[i].nextTimeAfter(from) <= to) {
                if(taskList[i].isActive()){
                    subset.add(taskList[i]);
                }
            }
        }
        return subset;
    }*/

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ArrayTaskList)) return false;
        ArrayTaskList that = (ArrayTaskList) o;
        return amOfTasks == that.amOfTasks &&
                Arrays.equals(taskList, that.taskList);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(amOfTasks);
        result = 31 * result + Arrays.hashCode(taskList);
        return result;
    }
}
