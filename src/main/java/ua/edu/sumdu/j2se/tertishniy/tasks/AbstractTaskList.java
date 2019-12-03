package ua.edu.sumdu.j2se.tertishniy.tasks;

import java.util.stream.Stream;

public abstract class AbstractTaskList implements Iterable<Task>, Cloneable {

    abstract public void add(Task task);
    abstract public boolean remove(Task task);
    abstract public int size();
    abstract public Task getTask(int index);
    abstract public Stream<Task> getStream();

    abstract public AbstractTaskList getInstance();

    public final AbstractTaskList incoming(int from, int to) {

        if(from < 0) {
            throw new IllegalArgumentException("The execution start can not be less than 0");
        }
        if(to < 0) {
            throw new IllegalArgumentException("The execution finish can not be less than 0");
        }
        if(to <= from) {
            throw new IllegalArgumentException("The execution finish can not be less or equal to execution start");
        }

        /*AbstractTaskList subset;

        try{
            subset = (AbstractTaskList) clone();
        } catch (CloneNotSupportedException ex) {
            throw new RuntimeException(ex);
        }

        Iterator<Task> subsetIterator = subset.iterator();
        while (subsetIterator.hasNext()){
            subsetIterator.next();
            subsetIterator.remove();
        }*/
        AbstractTaskList subset = getInstance();

        for(int i = 0; i < size(); i++) {
            if(getTask(i).nextTimeAfter(from) > from &&  getTask(i).nextTimeAfter(from) <= to) {
                if(getTask(i).isActive()) {
                    subset.add(getTask(i));
                }
            }
        }
        return subset;
    }
}
