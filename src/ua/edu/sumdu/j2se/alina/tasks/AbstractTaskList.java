package ua.edu.sumdu.j2se.alina.tasks;

import java.util.stream.Stream;

public abstract class AbstractTaskList implements Iterable {

    protected abstract void add(Task task);

    protected abstract boolean remove(Task task);

    protected abstract int size();

    protected abstract Task getTask(int index);

    public abstract Stream<Task> getStream();

    public final AbstractTaskList incoming(int from, int to){
        AbstractTaskList subtasksList;
        if(this.getClass().getSimpleName().equals("ArrayTaskList")){
            subtasksList = TaskListFactory.createTaskList(ListTypes.type.ARRAY);
        }
        else {
            subtasksList = TaskListFactory.createTaskList(ListTypes.type.LINKED);
        }
        getStream().filter(task -> {
            int nextTime = task.nextTimeAfter(from);
            return nextTime != -1 && nextTime < to;
        }).forEach(subtasksList::add);
        return subtasksList;
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }
}