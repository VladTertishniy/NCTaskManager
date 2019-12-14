package ua.edu.sumdu.j2se.tertishniy.tasks;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;
import java.util.SortedMap;
import java.util.TreeMap;

public class Tasks {

    public static Iterable<Task> incoming(Iterable<Task> tasks, LocalDateTime start, LocalDateTime end){
        if (start == null) {
            throw new IllegalArgumentException("From time must not be null");
        }
        if (end == null) {
            throw new IllegalArgumentException("To time must not be null");
        }
        if (start.isAfter(end)) {
            throw new IllegalArgumentException("Start time can not be less than end time");
        }
        if (tasks == null) {
            throw new IllegalArgumentException("Tasks must not be null");
        }

        ArrayTaskList subset = new ArrayTaskList();
        for (Task task:tasks) {
            LocalDateTime nextTime = task.nextTimeAfter(start);
            if (nextTime == null) {
                continue;
            }
            if (nextTime.compareTo(start) >= 0 && nextTime.compareTo(end) <= 0/*isBefore(end)*/ && task.isActive()) {
                subset.add(task);
            }
        }
        return subset;
    }

    public static SortedMap<LocalDateTime, Set<Task>> calendar(Iterable<Task> tasks, LocalDateTime start, LocalDateTime end){

        if (start == null) {
            System.err.println("Tasks.incoming: Start time must not be null");
            throw new IllegalArgumentException("Start time must not be null");
        }
        if (end == null) {
            System.err.println("Tasks.incoming: End time must not be null");
            throw new IllegalArgumentException("End time must not be null");
        }
        if (start.isAfter(end)) {
            System.err.println("Tasks.incoming: Start time can not be less than end time");
            throw new IllegalArgumentException("Start time can not be less than end time");
        }
        if (tasks == null) {
            System.err.println("Tasks.incoming: Tasks must not be null");
            throw new IllegalArgumentException("Tasks must not be null");
        }

        SortedMap<LocalDateTime, Set<Task>> result = new TreeMap<>();
        Iterable<Task> subset = incoming(tasks,start,end);
        for (Task temp : subset) {
            LocalDateTime happening = temp.nextTimeAfter(start);
            while (happening != null && !happening.isAfter(end)) {
                if (happening.isAfter(start) && !happening.isAfter(end)) {
                    if (result.containsKey(happening)) {
                        result.get(happening).add(temp);
                    } else {
                        result.put(happening, new HashSet<>());
                        result.get(happening).add(temp);
                    }
                }
                happening = temp.nextTimeAfter(happening);
            }
        }
        return result;
    }

}
