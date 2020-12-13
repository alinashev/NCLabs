package ua.edu.sumdu.j2se.alina.tasks;

import java.util.Objects;

public class Task implements Cloneable{
    private String title;
    private int time;
    private int start;
    private int end;
    private int interval;
    private boolean active;
    private boolean noRepeated;

    public Task(String title, int time){
        if(time >= 0) {
            this.title = title;
            this.time = time;
            noRepeated = true;
        } else {
            throw new IllegalArgumentException();
        }
    }

    public Task(String title, int start, int end, int interval){
        this.title = title;
        this.start = start;
        this.end = end;
        this.interval = interval;
    }

    public String getTitle(){
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public boolean isActive(){
        return active;
    }

    public void setActive(boolean active){
        this.active = active;
    }

    public int getTime(){
        if(isRepeated()) return start;
        else return time;
    }

    public void setTime(int time) {
        this.time = time;
        if(isRepeated()) noRepeated = true;
    }

    public int getStartTime() {
        if(!isRepeated()) return time;
        else return start;
    }

    public int getEndTime() {
        if(!isRepeated()) return time;
        else return end;
    }

    public int getRepeatInterval() {
        if (!isRepeated()) return 0;
        else return interval;
    }

    public void setTime(int start, int end, int interval){
        this.start = start;
        this.end = end;
        this.interval = interval;
        if(!isRepeated()) noRepeated = false;
    }

    public boolean isRepeated(){
        return !noRepeated;
    }

    public int nextTimeAfter(int current){
        if(!isActive()){
            return -1;
        }else{
            if(!isRepeated()){
                if(time > current){
                    return time;
                }
                else return -1;
            }
            else{
                int timeSum = start;
                while(timeSum <= current){
                    timeSum += interval;
                }
                if( timeSum > end){
                    return -1;
                }
                else return timeSum;
            }
        }
    }

    @Override
    public String toString() {
        return "Task{" +
                "title='" + title + '\'' +
                ", time=" + time +
                ", start=" + start +
                ", end=" + end +
                ", interval=" + interval +
                ", active=" + active +
                ", noRepeated=" + noRepeated +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Task task = (Task) o;
        return time == task.time && start == task.start && end == task.end && interval == task.interval && active == task.active && noRepeated == task.noRepeated && Objects.equals(title, task.title);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, time, start, end, interval, active, noRepeated);
    }
    @Override
    public Task clone() throws CloneNotSupportedException {
        return (Task) super.clone();
    }
}