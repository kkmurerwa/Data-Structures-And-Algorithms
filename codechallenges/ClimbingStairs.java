package codechallenges;

/**
 * LeetCode 70 - Climbing Stairs
 * You are climbing a staircase. It takes n steps to reach the top.
 *
 * Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?
 *
 * Example 1:
 * Input: n = 2
 * Output: 2
 * Explanation: There are two ways to climb to the top.
 * 1. 1 step + 1 step
 * 2. 2 steps
 *
 * Example 2:
 * Input: n = 3
 * Output: 3
 * Explanation: There are three ways to climb to the top.
 * 1. 1 step + 1 step + 1 step
 * 2. 1 step + 2 steps
 * 3. 2 steps + 1 step
 *
 */
public class ClimbingStairs {
    static int[] memo;
    public static void main(String[] args) {
        int n = 5;
        memo = new int[n + 1];

        System.out.println("Ways(TD): " + waysToClimbDpTD(n));
        System.out.println("Ways(BU): " + waysToClimbDpBU(n));
    }

    /**
     * Solution using top-down DP approach.
     * TC => O(n)
     * SC => O(n)
     *
     * @param n denotes the number of stairs to climb
     * @return the number of ways the stairs can be climbed
     */
    public static int waysToClimbDpTD(int n) {
        if (memo[n] != 0) {
            return memo[n];
        }
        int result;
        if (n <= 2) {
            result = n;
        } else {
            result = waysToClimbDpTD(n - 1) + waysToClimbDpTD(n - 2);
        }
        memo[n] = result;

        return result;
    }

    /**
     * Solution using bottom-up DP approach.
     * TC => O(n)
     * SC => O(1)
     *
     * @param n denotes the number of stairs to climb
     * @return the number of ways the stairs can be climbed
     */
    public static int waysToClimbDpBU(int n) {
        int[] memo = new int[2];

        memo[0] = 1;
        memo[1] = 1;

        for (int i = 2; i <= n; i ++) {
            int temp = memo[1] + memo[0];
            memo[0] = memo[1];
            memo[1] = temp;
        }

        return memo[1];
    }
}
