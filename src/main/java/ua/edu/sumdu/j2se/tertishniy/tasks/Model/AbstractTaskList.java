package ua.edu.sumdu.j2se.tertishniy.tasks.Model;

import java.io.Serializable;
import java.util.stream.Stream;

public abstract class AbstractTaskList implements Iterable<Task>, Serializable, Cloneable {

    abstract public void add(Task task);
    abstract public boolean remove(Task task);
    abstract public int size();
    abstract public Task getTask(int index);
    abstract public Stream<Task> getStream();
    abstract public AbstractTaskList getInstance();

    /*public final AbstractTaskList incoming(LocalDateTime from, LocalDateTime to) {

        *//*if(from < 0) {
            throw new IllegalArgumentException("The execution start can not be less than 0");
        }
        if(to < 0) {
            throw new IllegalArgumentException("The execution finish can not be less than 0");
        }
        if(to <= from) {
            throw new IllegalArgumentException("The execution finish can not be less or equal to execution start");
        }*//*

        *//*AbstractTaskList subset;

        try{
            subset = (AbstractTaskList) clone();
        } catch (CloneNotSupportedException ex) {
            throw new RuntimeException(ex);
        }

        Iterator<Task> subsetIterator = subset.iterator();
        while (subsetIterator.hasNext()){
            subsetIterator.next();
            subsetIterator.remove();
        }*//*

        *//*for(int i = 0; i < size(); i++) {
            if(getTask(i).nextTimeAfter(from).isAfter(from) &&  getTask(i).nextTimeAfter(from).isBefore(to) || getTask(i).nextTimeAfter(from).equals(to)) {
                if(getTask(i).isActive()) {
                    subset.add(getTask(i));
                }
            }
        }
        return subset;*//*
        *//*AbstractTaskList subset = getInstance();
        this.getStream().filter(task -> task.nextTimeAfter(from).isAfter(from) && task.nextTimeAfter(from).isBefore(to) && task.nextTimeAfter(from).equals(to) && task.isActive()).forEach(subset::add);
        return subset;*//*
    }*/
}
