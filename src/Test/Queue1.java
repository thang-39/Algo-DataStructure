package Test;

public class Queue1<T> {
    private Node<T> front;
    private Node<T> rear;

    private static class Node<T> {
        T data;
        Node<T> next;

        Node(T data) {
            this.data = data;
            this.next = null;
        }
    }

    public Queue1() {
        front = null;
        rear = null;
    }

    public void enqueue(T item) {
        Node<T> newNode = new Node<>(item);

        if (front == null) {
            front = newNode;
        } else {
            rear.next = newNode;
        }
        rear = newNode;
    }

    public T dequeue() {
        if (front == null) {
            throw new IllegalStateException("Queue is empty");
        }

        T item = front.data;
        front = front.next;

        if (front == null) {
            rear = null;
        }
        return item;
    }
}