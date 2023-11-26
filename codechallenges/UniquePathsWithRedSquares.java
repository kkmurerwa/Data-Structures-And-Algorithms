package codechallenges;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;

/**
 * There is a robot on an m x n grid. The robot is initially located at the top-left corner (i.e., grid[0][0]). The
 * robot tries to move to the bottom-right corner (i.e., grid[m - 1][n - 1]). The robot can only move either down or
 * right at any point in time. It cannot step on red squares though.
 *
 * Given the two integers m and n and a list of red squares, return the number of possible unique paths that the robot
 * can take to reach the bottom-right corner.
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
public class UniquePathsWithRedSquares {
    static int[][] memo;
    public static void main(String[] args) {
        int m = 2;
        int n = 2;
        memo = new int[m][n];
        int[][] redSquares = new int[][] { new int[]{ 0,1 } };

        System.out.println("Unique Paths TD: " + uniquePathsWithRedSquaresTD(m, n, redSquares) + " Expected: 1");
        System.out.println("Unique Paths BU: " + uniquePathsWithRedSquaresBU(m, n, redSquares) + " Expected: 1");

        int m2 = 3;
        int n2 = 3;
        memo = new int[m2][n2];
        int[][] redSquares2 = new int[][] { new int[]{ 0,1 }, new int[]{ 1,1 } };

        System.out.println("Unique Paths TD: " + uniquePathsWithRedSquaresTD(m2, n2, redSquares2) + " Expected: 1");
        System.out.println("Unique Paths BU: " + uniquePathsWithRedSquaresBU(m2, n2, redSquares2) + " Expected: 1");
    }

    // TODO: Not working correctly
    public static int uniquePathsWithRedSquaresTD(int m, int n, int[][] redSquares) {
        int keyM = m - 1;
        int keyN = n - 1;

        // Get from memo if exists
        if (memo[keyM][keyN] != 0) {
            return memo[keyM][keyN];
        }

        // Check if prohibited square
        int result;
        int[] currKey = new int[] { keyM, keyN };
        if (Arrays.stream(redSquares).anyMatch(arr -> Arrays.equals(arr, currKey))) {
            result = 0;
        } else if (m == 1 || n == 1) {
            result = 1;
        } else {
            result = uniquePathsWithRedSquaresTD(m - 1, n, redSquares) +
                    uniquePathsWithRedSquaresTD(m, n - 1, redSquares);
        }

        memo[keyM][keyN] = result;

        if (keyN < m && keyM < n) {
            memo[keyN][keyM] = result;
        }

        return memo[keyM][keyN];
    }

    public static int uniquePathsWithRedSquaresBU(int m, int n, int[][] redSquares) {
        int[][] myMemo = new int[m][n];

        for (int i = 0; i < myMemo.length; i ++) {
            int[] curr = myMemo[i];

            for (int j = 0; j < curr.length; j ++) {
                int[] currKey = new int[] { i, j };

                if (Arrays.stream(redSquares).anyMatch(arr -> Arrays.equals(arr, currKey))) {
                    myMemo[i][j] = 0;
                } else if (j == 0 || i == 0) {
                    if (i > 0 && myMemo[i - 1][j] == 0) {
                        myMemo[i][j] = 0;
                    } else if (j > 0 && myMemo[i][j - 1] == 0) {
                        myMemo[i][j] = 0;
                    } else {
                        myMemo[i][j] = 1;
                    }
                } else {
                    myMemo[i][j] = myMemo[i - 1][j] + myMemo[i][j - 1];
                }
            }
        }

        return myMemo[m - 1][n - 1];
    }
}
