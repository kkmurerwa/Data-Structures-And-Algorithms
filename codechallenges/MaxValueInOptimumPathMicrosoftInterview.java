package codechallenges;

import java.util.Arrays;

public class MaxValueInOptimumPathMicrosoftInterview {
    public static void main(String[] args) {
        System.out.println("Task 2: Microsoft Interview");

        println("Input:\n[3,4,6]\n[6,5,4]");
        int result = solution(new int[]{3, 4, 6}, new int[]{6, 5, 4});
        println("Max number: " + result + " expected 5");

        println("\nInput:\n[1,2,1,1,1,4]\n[1,1,1,3,1,1]");
        int result2 = solution(new int[]{1,2,1,1,1,4}, new int[]{1,1,1,3,1,1});
        println("Max number: " + result2 + " expected 2");

        println("\nInput:\n[-5,-1,-3]\n[-5,5,-2]");
        int result3 = solution(new int[]{-5,-1,-3}, new int[]{-5,5,-2});
        println("Max number: " + result3 + " expected -1");
    }

    public static int solution(int[] A, int[] B) {
        int n = A.length;
        int maxNum = Math.max(B[n - 1], A[0]);

        int[] maxValues = new int[2];
        maxValues[0] = B[n - 1];
        maxValues[1] = B[n - 1];

        for (int i = n - 2; i >= 0; i--) {
            if (i + 1 == n - 1) {
                maxValues[0] = A[i+1] + maxValues[0];
            } else {
                maxValues[0] = A[i+1] + Math.min(maxValues[0], maxValues[1]);
            }
            maxValues[1] = B[i] + maxValues[1];

            int min = Math.min(maxValues[0], maxValues[1]);
            if (maxValues[0] == min) {
                maxNum = Math.max(maxNum, A[i+1]);
            } else {
                maxNum = Math.max(maxNum, B[i]);
            }
        }

        return maxNum;
    }

    public static void println(Object o) {
        System.out.println(o);
    }
}
