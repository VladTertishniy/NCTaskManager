package ua.edu.sumdu.j2se.tertishniy.tasks;

public class Task {
    private String title;
    private int time;
    private int end;
    private int interval;
    private int start;
    private boolean active;
    private boolean repeated;

    public Task(String title, int time) {
        this.title = title;
        this.time = time;
        this.active = false;
    }

    public Task(String title, int end, int interval, int start) {
        this.title = title;
        this.end = end;
        this.interval = interval;
        this.start = start;
        this.active = false;
    }

    public String getTitle() {
        return title;
    }

    public boolean isActive() {
        return active;
    }

    public void setTitle(String title) {
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
        if (!repeated) {
            return interval;
        }
        else return 0;
    }

    public void setTime(int start, int end, int interval){
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
}
