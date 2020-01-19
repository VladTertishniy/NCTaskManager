package ua.edu.sumdu.j2se.tertishniy.tasks.Model;


import java.util.Iterator;
import java.util.LinkedList;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.stream.Stream;

public class LinkedTaskList extends AbstractTaskList {

    private Node head;
    private Node tail;
    private int amOfTasks;

    /*@Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof LinkedTaskList)) return false;
        LinkedTaskList tasks = (LinkedTaskList) o;
        return amOfTasks == tasks.amOfTasks &&
                Objects.equals(head, tasks.head) &&
                Objects.equals(tail, tasks.tail);
    }*/

    @Override
    public Stream<Task> getStream() {
        LinkedList<Task> linkedList = new LinkedList<>();
        for (Task task : this) {
            linkedList.add(task);
        }
        return linkedList.stream();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LinkedTaskList that = (LinkedTaskList) o;
        if (amOfTasks != that.amOfTasks) return false;
        Iterator<Task> thisIterator = iterator();
        Iterator<Task> thatIterator = that.iterator();
        while(thisIterator.hasNext()){
            if(!thisIterator.next().equals(thatIterator.next())){
                return false;
            }
        }
        return true;
    }

    @Override
    public int hashCode() {
        return Objects.hash(head, tail, amOfTasks);
    }

    @Override
    public void add(Task task){
        if(task == null){
            throw new IllegalArgumentException("Try to add an empty task");
        }
        Node newNode = new Node(task);
        if(head == null){
            head = newNode;
            tail = newNode;
            amOfTasks = 1;
            return;
        }
        tail.setNext(newNode);
        newNode.setPrevious(tail);
        tail = newNode;
        amOfTasks++;
    }

    @Override
    public AbstractTaskList getInstance() {
        return new LinkedTaskList();
    }

    @Override
    public boolean remove(Task task){
        if(task == null){
            throw new IllegalArgumentException("Try to remove an empty task");
        }
        Node temp = head;
        while(temp != null && !temp.getTask().equals(task)){
            temp = temp.getNext();
        }
        if(temp != null && temp.getTask().equals(task)){
            if(temp.getPrevious() != null){
                temp.getPrevious().setNext(temp.getNext());
                if(tail == temp){
                    tail = temp.getPrevious();
                }
            }
            if(temp.getNext() != null){
                temp.getNext().setPrevious(temp.getPrevious());
                if(head == temp){
                    head = temp.getNext();
                }
            }
            if(temp.getNext() == null && temp.getPrevious() == null){
                head = null;
                tail = null;
            }
            amOfTasks--;
            return true;
        }
        return false;
    }

    @Override
    public int size(){
        return amOfTasks;
    }

    @Override
    public Task getTask(int index){
        if (index < 0) {
            throw new IndexOutOfBoundsException("The index must be greater than 0");
        }
        if(index + 1 <= amOfTasks){
            Node temp = head;
            for(int i = 0; i < index; i++){
                temp = temp.getNext();
            }
            return temp.getTask();
        }
        else{
            return null;
        }
    }

    @Override
    public Iterator<Task> iterator(){
        return new LinkedTaskListIterator();
    }

    private class LinkedTaskListIterator implements Iterator<Task> {
        private Node temp = new Node();
        private boolean wasMoved;
        private int indexCurrentElement = -1;

        {
            temp.setNext(head);
        }

        @Override
        public Task next(){
            temp = temp.getNext();
            wasMoved = true;
            indexCurrentElement++;
            if(temp == null) {
                throw new NoSuchElementException();
            }else {
                return temp.getTask();
            }
        }

        @Override
        public boolean hasNext(){
            return (temp.getNext() != null);
        }

        @Override
        public void remove(){
            if(!wasMoved) {
                throw new IllegalStateException();
            }else {
                if(temp.getPrevious() == null){
                    head = temp.getNext();
                    temp.getNext().setPrevious(null);
                }else if(temp.getNext() == null){
                    tail = temp.getPrevious();
                    temp.getPrevious().setNext(null);
                }else{
                    temp.getPrevious().setNext(temp.getNext());
                    temp.getNext().setPrevious(temp.getPrevious());
                }
                wasMoved = false;
                amOfTasks--;
            }
        }
    }

    @Override
    public LinkedTaskList clone() throws CloneNotSupportedException {
        LinkedTaskList clone = (LinkedTaskList) super.clone();
        Iterator<Task> iterator = iterator();
        clone.head = clone.tail = null;
        clone.amOfTasks = 0;
        while(iterator.hasNext()){
            clone.add(iterator.next().clone());
        }
        return clone;
    }


    /*public LinkedTaskList incoming(int from, int to){

        if(from < 0){
            throw new IllegalArgumentException("The execution start can not be less than 0");
        }
        if(to < 0){
            throw new IllegalArgumentException("The execution finish can not be less than 0");
        }
        if(to <= from){
            throw new IllegalArgumentException("The execution finish can not be less or equal to execution start");
        }
        LinkedTaskList subset = new LinkedTaskList();
        for(int i = 0; i < size(); i++) {
            if(getTask(i).nextTimeAfter(from) > from &&  getTask(i).nextTimeAfter(from) <= to) {
                if(getTask(i).isActive()){
                    subset.add(getTask(i));
                }
            }
        }
        return subset;
    }*/
}
