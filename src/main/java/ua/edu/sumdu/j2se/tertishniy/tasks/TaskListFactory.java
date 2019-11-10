package ua.edu.sumdu.j2se.tertishniy.tasks;

import java.util.LinkedList;

public class TaskListFactory {
    	public static AbstractTaskList createTaskList(ListTypes.types type){
    	    /*if(type == ListTypes.types.LINKED){
                return new LinkedTaskList();
            }
    	    if(type == ListTypes.types.ARRAY){
    	        return new ArrayTaskList();
            }
    	    return null;*/

            switch (type) {
                case  LINKED:
                    return new LinkedTaskList();
                case ARRAY:
                    return new ArrayTaskList();
                default:
                    return null;
            }
        }
}
