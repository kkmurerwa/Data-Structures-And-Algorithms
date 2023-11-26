package codechallenges;

import java.util.Arrays;

/**
 * LeetCode 746 - Min Cost Climbing Stairs
 *
 * You are given an integer array cost where cost[i] is the cost of ith step on a staircase. Once you pay the cost, you
 * can either climb one or two steps. You can either start from the step with index 0, or the step with index 1.
 *
 * Return the minimum cost to reach the top of the floor.
 *
 * Example 1:
 * Input: cost = [10,15,20]
 * Output: 15
 * Explanation: You will start at index 1.
 * - Pay 15 and climb two steps to reach the top.
 * The total cost is 15.
 *
 * Example 2:
 * Input: cost = [1,100,1,1,1,100,1,1,100,1]
 * Output: 6
 * Explanation: You will start at index 0.
 * - Pay 1 and climb two steps to reach index 2.
 * - Pay 1 and climb two steps to reach index 4.
 * - Pay 1 and climb two steps to reach index 6.
 * - Pay 1 and climb one step to reach index 7.
 * - Pay 1 and climb two steps to reach index 9.
 * - Pay 1 and climb one step to reach the top.
 * The total cost is 6.
 *
 * Constraints:
 * 2 <= cost.length <= 1000
 * 0 <= cost[i] <= 999
 */
public class MinCostClimbingStairs {
    public static void main(String[] args) {
        int[] input = new int[] { 10, 15, 20 };
        System.out.println("Min Cost Input 1: " + minCostBU(input)  + " Expected: 15");

        int[] input2 = new int[] { 1, 100, 1, 1, 1, 100, 1, 1, 100, 1 };
        System.out.println("Min Cost Input 2: " + minCostBU(input2)  + " Expected: 6");
    }

    public static int minCostBU(int[] cost) {
        int[] memo = new int[2];

        memo[1] = cost[0];

        for (int i = 1; i < cost.length; i ++) {
            int temp = cost[i] + Math.min(memo[1], memo[0]);
            memo[0] = memo[1];
            memo[1] = temp;
        }

        return Math.min(memo[1], memo[0]);
    }
}
