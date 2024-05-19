package java.dp;

public class Fibonacci {

    // tabulation (bottom-up approach)
    // Dynamic programming
    public int fib(int n) {

        int[] arr = new int[n + 1];
        arr[0] = 0;
        arr[1] = 1;

        for (int i = 2; i <= n; i++) {
            arr[i] = arr[i - 1] + arr[i - 2];
        }
        return arr[n];  // Return the nth Fibonacci number (building with i, up to n)
    }
    
    public static void main(String[] args) {
        Fibonacci fn = new Fibonacci();
        System.out.println(fn.fib(1));
        System.out.println(fn.fib(2));
        System.out.println(fn.fib(3));
        System.out.println(fn.fib(4));
        System.out.println(fn.fib(5));
        System.out.println(fn.fib(6));
        System.out.println(fn.fib(7));
        System.out.println(fn.fib(8));
        System.out.println(fn.fib(9));
        ;

    }
}