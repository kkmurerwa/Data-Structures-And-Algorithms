package codechallenges.leetcode;

/**
 * Find the sum of numbers from 1 to n.
 */
public class SumOfNNumbers {
    public static void main(String[] args) {
        int n = 2;
        System.out.println("Sum of nums until " + n + " is " + sumOfNNumbersDp(n));
    }

    /**
     * A DP solution for the problem
     *
     * @param n denotes the limit of the summation
     * @return the sum of all the numbers from 1 to n
     */
    public static int sumOfNNumbersDp(int n) {
        if (n > 1) {
            return n + sumOfNNumbersDp(n - 1);
        }

        return n;
    }
}
