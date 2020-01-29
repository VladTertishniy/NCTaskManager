package ua.edu.sumdu.j2se.tertishniy.tasks.model;

import java.io.Serializable;
import java.util.stream.Stream;

public abstract class AbstractTaskList implements Iterable<Task>, Serializable, Cloneable {

    abstract public void add(Task task);
    abstract public boolean remove(Task task);
    abstract public int size();
    abstract public Task getTask(int index);
    abstract public Stream<Task> getStream();
    abstract public AbstractTaskList getInstance();

}
