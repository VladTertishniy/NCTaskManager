package ua.edu.sumdu.j2se.tertishniy.tasks;

import java.util.Objects;

public class Node {

    private Task task;
    private Node previous;
    private Node next;

    public Node(){
    }

    public Node(Task task){
        this.task = task;
    }

    public Task getTask(){
        return task;
    }

    public Node getNext(){
        return next;
    }

    public Node getPrevious(){
        return previous;
    }

    public void setNext(Node node){
        next = node;
    }

    public void setPrevious(Node node){
        previous = node;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Node)) return false;
        Node node = (Node) o;
        return Objects.equals(getTask(), node.getTask()) &&
                Objects.equals(getPrevious(), node.getPrevious()) &&
                Objects.equals(getNext(), node.getNext());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getTask(), getPrevious(), getNext());
    }
}
