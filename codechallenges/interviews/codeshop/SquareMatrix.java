package codechallenges.interviews.codeshop;

import java.util.Arrays;
import java.util.HashSet;

public class SquareMatrix {
    public static void main(String[] args) {
        int[][] matrix1 = {
            {1, 2, 3},
            {4, 5, 5},
            {4, 8, 9}
        };
        System.out.println("sol: " + Arrays.toString(solution(matrix1)) + ", expected: [15, 1, 1]");

        int[][] matrix2 = {
            {2, 2, 2, 2},
            {2, 3, 2, 3},
            {2, 2, 2, 3},
            {2, 2, 2, 2}
        };
        System.out.println("\nsol: " + Arrays.toString(solution(matrix2)) + ", expected: [9, 4, 4]");
    }

    public static int[] solution(int[][] matrix) {
        int n = matrix.length;
        int[] result = new int[3];

        // Sum of the main diagonal
        for (int i = 0; i < n; i++) {
            result[0] += matrix[i][i];
        }

        // Count of rows with repeating elements
        HashSet<Integer> set = new HashSet<>();
        for (int[] ints : matrix) {
            for (int j = 0; j < n; j++) {
                if (!set.add(ints[j])) {
                    result[1]++;
                    break;
                }
            }
            set.clear();
        }

        // Count of columns with repeating elements
        for (int j = 0; j < n; j++) {
            for (int[] ints : matrix) {
                if (!set.add(ints[j])) {
                    result[2]++;
                    break;
                }
            }
            set.clear();
        }

        return result;
    }
}
