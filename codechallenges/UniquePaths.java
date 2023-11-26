package codechallenges;

/**
 * LeetCode 62 - Unique Paths
 *
 * There is a robot on an m x n grid. The robot is initially located at the top-left corner (i.e., grid[0][0]). The
 * robot tries to move to the bottom-right corner (i.e., grid[m - 1][n - 1]). The robot can only move either down or
 * right at any point in time.
 *
 * Given the two integers m and n, return the number of possible unique paths that the robot can take to reach the
 * bottom-right corner.
 *
 * The test cases are generated so that the answer will be less than or equal to 2 * 109.
 *
 * Example 1:
 * Input: m = 3, n = 7
 * Output: 28
 *
 * Example 2:
 * Input: m = 3, n = 2
 * Output: 3
 * Explanation: From the top-left corner, there are a total of 3 ways to reach the bottom-right corner:
 * 1. Right -> Down -> Down
 * 2. Down -> Down -> Right
 * 3. Down -> Right -> Down
 *
 * Constraints:
 * 1 <= m, n <= 100
 */
public class UniquePaths {
    static int[][] memo;
    public static void main(String[] args) {
        int m = 2;
        int n = 2;
        memo = new int[m][n];

        System.out.println("Unique Paths TD: " + uniquePathsTD(m, n) + " Expected: 2");
        System.out.println("Unique Paths BU: " + uniquePathsBU(m, n) + " Expected: 2");

        int m2 = 3;
        int n2 = 7;
        memo = new int[m2][n2];

        System.out.println("Unique Paths TD: " + uniquePathsTD(m2, n2) + " Expected: 28");
        System.out.println("Unique Paths BU: " + uniquePathsBU(m2, n2) + " Expected: 28");
    }

    public static int uniquePathsTD(int m, int n) {
        int keyM = m - 1;
        int keyN = n - 1;

        // Get from memo if exists
        if (memo[keyM][keyN] != 0) {
            return memo[keyM][keyN];
        }

        int result;
        if (m == 1 || n == 1) {
            result = 1;
        } else {
            result = uniquePathsTD(m - 1, n) + uniquePathsTD(m, n - 1);
        }

        memo[keyM][keyN] = result;

        if (keyN < m && keyM < n) {
            memo[keyN][keyM] = result;
        }

        return memo[keyM][keyN];
    }

    public static int uniquePathsBU(int m, int n) {
        int[][] myMemo = new int[m][n];

        for (int i = 0; i < myMemo.length; i ++) {
            int[] curr = myMemo[i];

            for (int j = 0; j < curr.length; j ++) {
                if (j == 0 || i == 0) {
                    myMemo[i][j] = 1;
                } else {
                    myMemo[i][j] = myMemo[i - 1][j] + myMemo[i][j - 1];
                }
            }
        }

        return myMemo[m - 1][n - 1];
    }
}
