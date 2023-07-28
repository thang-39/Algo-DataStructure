package Test;

public class QueueTest {
    public static void main(String[] args) {
        Queue1<Integer> a = new Queue1<>();
        a.enqueue(1);
        a.enqueue(2);

        System.out.println(a.dequeue());
        System.out.println(a.dequeue());
        System.out.println(a.dequeue());

    }
}
