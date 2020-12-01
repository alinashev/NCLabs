package ua.edu.sumdu.j2se.alina.tasks;

import java.util.Arrays;

public class ArrayTaskList extends AbstractTaskList {
    private Task [] tasksList = {};

    @Override
    public void add(Task task){
        tasksList = Arrays.copyOf(tasksList, tasksList.length + 1);
        tasksList [tasksList.length- 1] = task;
    }

    @Override
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
    @Override
    public int size(){
        return tasksList.length;
    }

    @Override
    public Task getTask(int index){
        if(index < tasksList.length && index >= 0) {
            return tasksList[index];
        }else {
            throw new IndexOutOfBoundsException();
        }
    }
}
