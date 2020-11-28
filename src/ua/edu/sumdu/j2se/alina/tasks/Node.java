package ua.edu.sumdu.j2se.alina.tasks;

public class Node {
    private Task element;
    private Node next;
    private Node previous;

    public Node(Task element) {
        this.element = element;
    }

    public Task getElement() {
        return element;
    }

    public void setNext(Node next) {
        this.next = next;
    }

    public Node getNext() {
        return next;
    }

    public void setPrevious(Node previous) {
        this.previous = previous;
    }

    public Node getPrevious() {
        return previous;
    }
}
