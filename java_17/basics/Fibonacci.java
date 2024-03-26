package java_17.basics;

import java.util.Arrays;

public class Fibonacci {
    
    public static void main(String[] args) {
        allFib(10);
    }
    
    public static void allFib(int n) {
        int[] memo = new int[n+1];
        for (int i = 0; i < n; i++) {
            System.out.println((i + 1) + ": " + fib(i, memo));
            System.out.println("In loop " + Arrays.toString(memo));
        }
        System.out.println(Arrays.toString(memo));
    }

    public static int fib(int n, int[] memo) {
        System.out.println(Arrays.toString(memo));
        if (n <= 0) {
            return 0;
        } else if (n == 1) {
            memo[n] = 1;
            return 1;
        } else if (memo[n] > 0) {
            return memo[n];
        }

        memo[n] = fib(n-1, memo) + fib(n - 2, memo);
        return memo[n];
    }
}
