package ua.edu.sumdu.j2se.tertishniy.tasks;


public class LinkedTaskList extends AbstractTaskList {

    private Node head;
    private Node tail;
    private int amOfTasks;

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

    public int size(){
        return amOfTasks;
    }

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
