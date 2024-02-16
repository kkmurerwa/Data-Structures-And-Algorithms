package codechallenges.leetcode;

/**
 * LeetCode 109 - Fibonacci Number
 * The Fibonacci numbers, commonly denoted F(n) form a sequence, called the Fibonacci sequence, such that each number is the sum of the two preceding ones, starting from 0 and 1. That is,
 *
 * F(0) = 0, F(1) = 1
 * F(n) = F(n - 1) + F(n - 2), for n > 1.
 * Given n, calculate F(n).
 *
 * Example 1:
 * Input: n = 2
 * Output: 1
 * Explanation: F(2) = F(1) + F(0) = 1 + 0 = 1.
 *
 * Example 2:
 * Input: n = 3
 * Output: 2
 * Explanation: F(3) = F(2) + F(1) = 1 + 1 = 2.
 *
 * Example 3:
 * Input: n = 4
 * Output: 3
 * Explanation: F(4) = F(3) + F(2) = 2 + 1 = 3.
 *
 * Constraints: 0 <= n <= 30.
 */
public class FibonacciNumber {
    static int[] memo;
    public static void main(String[] args) {
        int n = 10;
        memo = new int[n + 1];

        int nth = nthFibonacciNumber(n);

        System.out.println("Nth Fibonacci: " + nth);
    }

    /**
     * Uses the dynamic programming approach.
     * TC => O(n)
     * SC => O(n)
     *
     * @param n denotes the number of the fibonacci number in the sequence
     * @return an integer with the value of the nth indexed number in the sequence
     */
    public static int nthFibonacciNumber(int n) {
        if (memo[n] != 0) {
            return memo[n];
        }

        int result;

        if (n == 1 || n == 2) {
            result = 1;
        } else {
            result = nthFibonacciNumber(n -1) + nthFibonacciNumber(n - 2);
        }

        memo[n] = result;
        return  result;
    }

    /**
     * Uses an iterative approach.
     * TC: O(n)
     * SC: O(1)
     *
     * @param n denotes the target number in the sequence
     * @return an integer with the value of the nth indexed number in the sequence
     */
    public static int nthFibonacciNumber2(int n) {
        int count = 2;
        int[] prev = new int[]{0,1,1};

        if (n <= 2) {
            return prev[n];
        }

        while (count < n) {
            int sum = prev[1] + prev[2];
            prev[1] = prev[2];
            prev[2] = sum;
            count ++;
        }

        return prev[2];
    }
}
