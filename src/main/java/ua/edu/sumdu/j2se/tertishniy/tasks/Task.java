package ua.edu.sumdu.j2se.tertishniy.tasks;

import java.util.Objects;

public class Task {
    private String title;
    private int time;
    private int end;
    private int interval;
    private int start;
    private boolean active;
    private boolean repeated;

    public Task(String title, int time) {
        if (time < 0) {
            throw new IllegalArgumentException("The time must be greater than 0");
        }
        if (title == null) {
            throw new IllegalArgumentException("The title of task must be set");
        }
        this.title = title;
        this.time = time;
        this.active = false;
    }

    public Task(String title, int start, int end, int interval) {
        if (title == null) {
            throw new IllegalArgumentException("The title of task must be set");
        }
        if (end <= 0) {
            throw new IllegalArgumentException("The end must be greater than 0");
        }
        if (interval <= 0) {
            throw new IllegalArgumentException("The interval must be greater than 0");
        }
        if (start < 0) {
            throw new IllegalArgumentException("The start must be greater than 0");
        }
        this.title = title;
        this.end = end;
        this.interval = interval;
        this.start = start;
        this.active = false;
        this.repeated = true;
    }

    public String getTitle() {
        return title;
    }

    public boolean isActive() {
        return active;
    }

    public void setTitle(String title) {
        if (title == null) {
            throw new IllegalArgumentException("The title of task must be set");
        }
        this.title = title;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public int getTime(){

        if (repeated) {
            return start;
        }
        else return time;
    }

    public void setTime(int time){
        if (time < 0) {
            throw new IllegalArgumentException("The time must be greater than 0");
        }
        if (repeated) {
            this.time = time;
            repeated = false;
        }
        else this.time = time;
    }

    public int getStartTime(){
        if (!repeated) return time;
        else return start;
    }

    public int getEndTime(){
        if (!repeated) return time;
        else return end;
    }

    public int getRepeatInterval(){
        if (repeated) {
            return interval;
        }
        else return 0;
    }

    public void setTime(int start, int end, int interval){
        if (end <= 0) {
            throw new IllegalArgumentException("The end must be greater than 0");
        }
        if (interval <= 0) {
            throw new IllegalArgumentException("The interval must be greater than 0");
        }
        if (start < 0) {
            throw new IllegalArgumentException("The start must be greater than 0");
        }
        if (!repeated) {
            this.repeated = true;
            this.start = start;
            this.end = end;
            this.interval = interval;
        }
        else {
            this.start = start;
            this.end = end;
            this.interval = interval;
        }
    }

    public boolean isRepeated(){
        return repeated;
    }

    public int nextTimeAfter(int current) {
        if (current < 0) {
            throw new IllegalArgumentException("Current time can not be less than 0");
        }
        if (active && !repeated){
            if (current < time) return time;
            else return -1;
        } else if (active) {
            if (current > end) return -1;
            else if (current < start) return  start;
            else {
                int checkTime = start;
                while (checkTime <= end) {
                    if (checkTime > current) return checkTime;
                    else checkTime += interval;
                }
            }
        }
        return -1;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Task)) return false;
        Task task = (Task) o;
        return getTime() == task.getTime() &&
                end == task.end &&
                interval == task.interval &&
                start == task.start &&
                isActive() == task.isActive() &&
                isRepeated() == task.isRepeated() &&
                Objects.equals(getTitle(), task.getTitle());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getTitle(), getTime(), end, interval, start, isActive(), isRepeated());
    }
}
