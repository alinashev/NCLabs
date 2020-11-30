package ua.edu.sumdu.j2se.alina.tasks;

public class LinkedTaskList{
    private Node first;
    private Node last;
    private int size;

    public void add(Task task){
        Node newNode = new Node(task);
        if (first == null) {
            newNode.setNext(null);
            newNode.setPrevious(null);
            first = newNode;
            last = newNode;
        } else {
            last.setNext(newNode);
            newNode.setPrevious(last);
            last = newNode;
        }
        size++;
    }

    public boolean remove(Task task) {
        Node current = first;
        Node previous = null;

        while (current != null) {
            if (current.getElement().equals(task)) {
                if (previous != null) {
                    previous.setNext(current.getNext());
                    if (current.getNext() == null) {
                        last = previous;
                    }
                } else {
                    first = first.getNext();
                    if (first == null) {
                        last = null;
                    }
                }
                size--;
                return true;
            }
            previous = current;
            current = current.getNext();
        }
        return false;
    }

    public int size(){
        return size;
    }


    public Task getTask(int index){
        Node node = first;
        if (index == 0){
            return node.getElement();
        }else {
            if (node.getNext() != null) {
                for(int i = 0; i < index; i++){
                    node = node.getNext();
                }
                return node.getElement();
            }else {
                return null;
            }
        }
    }

    public LinkedTaskList incoming(int from, int to){
        LinkedTaskList subtasksList = new LinkedTaskList();
        for (int i = 0; i < subtasksList.size(); i++) {
            if(getTask(i) != null && getTask(i).nextTimeAfter(from) != -1 && getTask(i).nextTimeAfter(from) <= to){
                subtasksList.add(getTask(i));
            }
        }
        return subtasksList;
    }
}

