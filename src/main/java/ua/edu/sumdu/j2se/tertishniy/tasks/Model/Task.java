package ua.edu.sumdu.j2se.tertishniy.tasks.Model;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Objects;

public class Task implements Cloneable, Serializable {
    private String title;
    private LocalDateTime time;
    private LocalDateTime end;
    private int interval;
    private LocalDateTime start;
    private boolean active;
    private boolean repeated;

    public Task(String title, LocalDateTime time) {
        if (time == null) {
            throw new IllegalArgumentException("The time must be greater than 0");
        } else
        if (title == null) {
            throw new IllegalArgumentException("The title of task must be set");
        }
        this.title = title;
        this.time = time;
        this.active = false;
    }

    public Task(String title, LocalDateTime start, LocalDateTime end, int interval) {
        if (title == null) {
            throw new IllegalArgumentException("The title of task must be set");
        }
        /*if (end <= 0) {
            throw new IllegalArgumentException("The end must be greater than 0");
        }*/
        if (interval <= 0) {
            throw new IllegalArgumentException("The interval must be greater than 0");
        }
        /*if (start < 0) {
            throw new IllegalArgumentException("The start must be greater than 0");
        }*/
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

    public LocalDateTime getTime(){

        if (repeated) {
            return start;
        }
        else return time;
    }

    public void setTime(LocalDateTime time){
        /*if (time < 0) {
            throw new IllegalArgumentException("The time must be greater than 0");
        }*/
        if (repeated) {
            this.time = time;
            repeated = false;
        }
        else this.time = time;
    }

    public LocalDateTime getStartTime(){
        if (!repeated) return time;
        else return start;
    }

    public LocalDateTime getEndTime(){
        if (!repeated) return time;
        else return end;
    }

    public int getRepeatInterval(){
        if (repeated) {
            return interval;
        }
        else return 0;
    }

    public void setTime(LocalDateTime start, LocalDateTime end, int interval){
        /*if (end <= 0) {
            throw new IllegalArgumentException("The end must be greater than 0");
        }*/
        if (interval <= 0) {
            throw new IllegalArgumentException("The interval must be greater than 0");
        }
        /*if (start < 0) {
            throw new IllegalArgumentException("The start must be greater than 0");
        }*/
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

    public LocalDateTime nextTimeAfter(LocalDateTime current) {
        /*if (current < 0) {
            throw new IllegalArgumentException("Current time can not be less than 0");
        }*/
        if (active && !repeated){
            if (current.isBefore(time)) return time;
            else return null;
        } else if (active) {
            if (current.isAfter(end)) return null;
            else if (current.isBefore(start)) return  start;
            else {
                LocalDateTime checkTime = start;
                while (checkTime.isBefore(end) || checkTime.equals(end)) {
                    if (checkTime.isAfter(current)) return checkTime;
                    else checkTime = checkTime.plusSeconds(interval);
                }
            }
        }
        return null;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Task)) return false;
        Task task = (Task) o;
        /*return getTime() == task.getTime() &&
                end == task.end &&
                interval == task.interval &&
                start == task.start &&
                isActive() == task.isActive() &&
                isRepeated() == task.isRepeated() &&
                Objects.equals(getTitle(), task.getTitle());*/
        if (!((Task) o).repeated){
            return end == task.end &&
                    interval == task.interval &&
                    start == task.start &&
                    isActive() == task.isActive() &&
                    isRepeated() == task.isRepeated() &&
                    Objects.equals(getTitle(), task.getTitle());
        }else {
            return getTime() == task.getTime() &&
                    Objects.equals(getTitle(), task.getTitle()) &&
                    isActive() == task.isActive() &&
                    isRepeated() == task.isRepeated();
        }
    }

    @Override
    public int hashCode() {
        return Objects.hash(getTitle(), getTime(), end, interval, start, isActive(), isRepeated());
    }

    @Override
    public Task clone() throws CloneNotSupportedException {
        Task temp = (Task) super.clone();
        temp.title = this.title;
        return temp;
    }

    @Override
    public String toString() {
        return "Task{" +
                "title='" + title + '\'' +
                ", time=" + time +
                ", end=" + end +
                ", interval=" + interval +
                ", start=" + start +
                ", active=" + active +
                ", repeated=" + repeated +
                '}';
    }
}
