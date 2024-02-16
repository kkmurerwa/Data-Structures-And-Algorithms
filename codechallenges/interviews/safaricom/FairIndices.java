package codechallenges.interviews.safaricom;

import java.util.Arrays;

/**
 * You are given two arrays A and B consisting of N integers each. Index K is named fair if the four sums(A[0]+...A[K-1]),
 * (A[K]+...+A[N-1]),(B[0]+...+B[K-1]) and (B[K]+...+B[N-1]) are all equal, In other words, K is the index where the two
 * arrays, A and B, can be split (into two non-empty arrays each) in such a way that the sums of the resulting arrays’
 * elements are equal. For example, given arrays A = [4,-1, 0, 3] and B = [-2, 5, 0, 3], index K = 2 is fair. The sums
 * of the subarrays are all equal: 4+(-1) = 3; 0+3 = 3; -2 + 5 = 3 and 0 + 3 = 3. Now you have to figure out the number
 * of fair indexes.
 *
 * 2<=N<=100000
 * -1000000000<=a[i],b[i]<=1000000000 (0<=i<N)
 */
public class FairIndices {
    public static void main(String[] args) {
        int[] arr1 = new int[] { 4,-1, 0, 3 };
        int[] arr2 = new int[] { -2, 5, 0, 3 };

        int res = getIndex(arr1, arr2);
    }

    public static int getIndex(int[] arr1, int[] arr2) {
        int[] prep = new int[arr1.length];
        int[] suff = new int[arr2.length];

        int sumPrep = 0;
        for (int i = 0; i < arr1.length; i++) {
            sumPrep += arr1[i];
            prep[i] = sumPrep;
        }

        int sumSuff = 0;
        for (int i = arr2.length - 1; i >= 0; i--) {
            sumSuff += arr2[i];
            suff[i] = sumSuff;
        }

        System.out.println("Prep: " + Arrays.toString(prep));
        System.out.println("Suff: " + Arrays.toString(suff));

        return 1;
    }
}
