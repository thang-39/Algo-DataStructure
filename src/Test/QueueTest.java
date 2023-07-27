package Test;

public class QueueTest {
    public static void main(String[] args) {
        Queue<Integer> a = new Queue<>();
        a.enqueue(1);
        a.enqueue(2);

        System.out.println(a.dequeue());
        System.out.println(a.dequeue());
        System.out.println(a.dequeue());

    }
}
