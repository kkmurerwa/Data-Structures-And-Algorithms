package codechallenges.interviews.microsoft;

/**
 * You are given an array A of N positive integers. In one move, you can pick a segment (a contiguous fragment) of A
 * and a positive integer X and then increase all elements within that segment by X.
 * An array is strictly increasing if each element (except for the last one) is smaller than the next element.
 * Write a function:
 * class Solution i public int solution(int[] A); }
 * that, given an array A of N integers, returns the minimum number of moves needed to make the array strictly increasing.
 * Examples:
 * 1. Given A = [4, 2, 4, 1, 3, 5], the function should return 2.
 * 2. Given A = [3, 5, 7, 71, the function should return 1.
 * 3. Given A = [1, 5, 6, 10], the function should return 0.
 * Write an efficient algorithm for the following assumptions:
 * • N is an integer within the range [1.100,000);
 * • each element of array A is an integer within the range (1.1,000,000,000). This assumption does not have to hold
 */
public class MinimumMovesForStrictlyIncrementingArray {
    public static void main(String[] args) {
        int[] arr1 = {1,2,3,4};
        System.out.println("sol1: " + solution(arr1) + "\nexpected: 0");

        int[] arr2 = {3,5,7,7};
        System.out.println("sol2: " + solution(arr2) + "\nexpected: 1");

        int[] arr3 = {4,2,4,1,3,5};
        System.out.println("sol3: " + solution(arr3) + "\nexpected: 2");
    }

    public static int solution(int[] arr) {
        // Split array into sections of strictly increasing numbers
        int moves = 0;
        int prev = arr[0];

        for (int i = 1; i < arr.length; i++) {
            if (arr[i] <= prev) {
                moves += 1;
            }
            prev = arr[i];
        }

        return moves;
    }
}
