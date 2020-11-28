package ua.edu.sumdu.j2se.alina.tasks;

import java.util.Arrays;

public class ArrayTaskList  {
    private Task [] tasksList = {};

    public void add(Task task){
        tasksList = Arrays.copyOf(tasksList, tasksList.length + 1);
        tasksList [tasksList.length- 1] = task;
    }

    public boolean remove(Task task){
        boolean removed = false;
        for (int i = 0; i < tasksList.length; i++){
            if(task == tasksList[i]){
                removed = true;
                tasksList[i] = null;
                break;
            }
        }
        if(removed) {
            Task[] tempList = new Task[tasksList.length - 1];
            int j = 0;
            for (int i = 0; i < tasksList.length; i++) {
                if (tasksList[i] != null) {
                    tempList[j] = tasksList[i];
                    j++;
                }
            }
            tasksList = tempList;
        }
        return removed;
    }

    public int size(){
        return tasksList.length;
    }

    public Task getTask(int index){
        if(index < tasksList.length && index >= 0) {
            return tasksList[index];
        }else {
            throw new IndexOutOfBoundsException();
        }
    }

    public ArrayTaskList incoming(int from, int to){
        ArrayTaskList subtasksList = new ArrayTaskList();
        for (int i = 0; i < tasksList.length; i++) {
            if(getTask(i) != null && getTask(i).nextTimeAfter(from) != -1 && getTask(i).nextTimeAfter(from) <= to){
                subtasksList.add(getTask(i));
            }
        }
        return subtasksList;
    }

}