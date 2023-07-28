package Test;

/**
 * author: Hoàng Phương Nam
 */
public class OPQ2_20230727_HOANGPHUONGNAM {

    public class Queue<T> extends Thread{
        private Node<T> front;
        private Node<T> rear;

        private static class Node<T>{
            T data;
            Node<T> next;

            Node(T data) {
                this.data = data;
                this.next = null;
            }
        }

        public Queue() {
            front = null;
            rear = null;
        }
        public void createQueue(T item) {
            Node<T> newNode = new Node<>(item);

            if (front == null) {
                front = newNode;
            } else {
                rear.next = newNode;
            }
            rear = newNode;
        }

        public synchronized T dequeue() {
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

        public void display() {
            Node<T> current = front;

            if (front == null) {
                System.out.println("List is empty");
                return;
            }
            System.out.println("Nodes of list: ");
            while (current != null) {
                System.out.println(current.data + "");
                current = current.next;
            }
            System.out.println();
        }
        @Override
        public void run() {
            display();
        }

    }
}