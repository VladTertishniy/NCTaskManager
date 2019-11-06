package ua.edu.sumdu.j2se.tertishniy.tasks;


import java.util.LinkedList;

public abstract class LinkedTaskList {

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
        if(index + 1 <= amOfTasks && index >= 0){
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
}
