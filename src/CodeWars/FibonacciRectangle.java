package CodeWars;

import java.math.BigInteger;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public class FibonacciRectangle {

    public static Map<BigInteger, BigInteger> fibonacciCache = new HashMap<>();
    public static void main(String[] args) {
        System.out.println(perimeter(BigInteger.valueOf(2)));
    }
    public static BigInteger perimeter(BigInteger n) {
        return fibonacci(n.add(BigInteger.ONE))
                .multiply(BigInteger.TWO)
                .add(fibonacci(n)).multiply(BigInteger.TWO);
    }


    public static BigInteger fibonacci(BigInteger n) {
        if ( n.equals(BigInteger.ZERO)) {
            return BigInteger.ZERO;
        }

        if ( n.equals(BigInteger.ONE)) {
            return BigInteger.ONE;
        }

        if (fibonacciCache.containsKey(n)) {
            return fibonacciCache.get(n);
        }

        BigInteger nthFibonacciNum = fibonacci(n.subtract(BigInteger.TWO))
                .add(fibonacci(n.subtract(BigInteger.ONE)));
        fibonacciCache.put(n, nthFibonacciNum);
        return nthFibonacciNum;
    }
}
