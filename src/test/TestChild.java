package test;

public class TestChild extends Test{
    @Override
    public int add(int a, int b) {
        return super.add(a, b);
    }

    public int add(long a, int b) {
        return (int) a + b;
    }
}
