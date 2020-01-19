package ua.edu.sumdu.j2se.tertishniy.tasks.Model;

import java.util.*;
import java.util.stream.Stream;

public class ArrayTaskList extends AbstractTaskList {

    private Task [] taskList = new Task [5];
    private int amOfTasks;

    public ArrayTaskList() {
    }

    @Override
    public Stream<Task> getStream() {
        return new ArrayList<>(Arrays.asList(taskList).subList(0, amOfTasks)).stream();
    }

    public ArrayTaskList(int amount){
        if(amount < 1){
            throw new IllegalArgumentException("The length of the list can not be less than 0");
        }
        taskList = new Task[amount];
    }

    @Override
    public AbstractTaskList getInstance() {
        return new ArrayTaskList();
    }

    @Override
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

    @Override
    public boolean remove(Task task){
        if(task == null){
            throw new IllegalArgumentException("Try to remove an empty task");
        }
        if(amOfTasks >= 1){
            for(int i = 0; i < amOfTasks; i++){
                if(taskList[i].equals(task)){
                    for(int CurrentElement = i; i <= amOfTasks - 2; i++){
                        taskList[i] = taskList[i + 1];
                    }
                    taskList[amOfTasks - 1] = null;
                    amOfTasks--;
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public int size(){
        return amOfTasks;
    }

    @Override
    public Task getTask(int index){
        if(index < amOfTasks && index >= 0){
            return taskList[index];
        }
        else{
            return null;
        }
    }

    @Override
    public Iterator<Task> iterator(){
        return new ArrayTaskListIterator();
    }

    private class ArrayTaskListIterator implements Iterator<Task> {

        private boolean wasMoved;
        private int indexCurrentElement = -1;

        @Override
        public boolean hasNext() {
            return indexCurrentElement + 1 <= amOfTasks - 1;
        }

        @Override
        public Task next() {
            if(indexCurrentElement + 1 > amOfTasks - 1){
                throw new NoSuchElementException();
            }else{
                wasMoved = true;
                return taskList[++indexCurrentElement];
            }
        }

        @Override
        public void remove() {
            if(!wasMoved) {
                throw new IllegalStateException();
            }else{
                for(int i = indexCurrentElement; i <= amOfTasks - 2; i++){
                    taskList[i] = taskList[i + 1];
                }
                taskList[amOfTasks - 1] = null;
                wasMoved = false;
                amOfTasks--;
                indexCurrentElement--;
            }
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
    public ArrayTaskList clone() throws CloneNotSupportedException {
        ArrayTaskList clone = (ArrayTaskList) super.clone();
        clone.taskList = new Task[amOfTasks];
        for(int i = 0; i < amOfTasks; i++){
            clone.taskList[i] = taskList[i]/*.clone()*/;
        }
        return clone;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ArrayTaskList)) return false;
        ArrayTaskList tasks = (ArrayTaskList) o;
        return amOfTasks == tasks.amOfTasks &&
                Arrays.equals(taskList, tasks.taskList);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(amOfTasks);
        result = 31 * result + Arrays.hashCode(taskList);
        return result;
    }
}
