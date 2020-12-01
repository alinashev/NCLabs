package ua.edu.sumdu.j2se.alina.tasks;

public abstract class AbstractTaskList {

    protected abstract void add(Task task);

    protected abstract boolean remove(Task task);

    protected abstract int size();

    protected abstract Task getTask(int index);

    public AbstractTaskList incoming(int from, int to){
        AbstractTaskList subtasksList;
        if(this.getClass().getSimpleName().equals("ArrayTaskList")){
            subtasksList = TaskListFactory.createTaskList(ListTypes.type.ARRAY);
        }
        else {
            subtasksList = TaskListFactory.createTaskList(ListTypes.type.LINKED);
        }
        for (int i = 0; i < this.size(); i++) {
            if(getTask(i) != null && getTask(i).nextTimeAfter(from) != -1 && getTask(i).nextTimeAfter(from) <= to){
                subtasksList.add(getTask(i));
            }
        }
        return subtasksList;

    }
}
