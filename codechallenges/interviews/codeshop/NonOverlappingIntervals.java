package codechallenges.interviews.codeshop;

import java.util.Arrays;
import java.util.Comparator;

public class NonOverlappingIntervals {
    public static void main(String[] args) {
        int[][] intervals1 = {
            {1, 2},
            {2, 3},
            {3, 4},
            {1, 3}
        };
        System.out.println("sol: " + eraseOverlapIntervals(intervals1) + ", expected: 1");

        int[][] intervals2 = {
            {1, 2},
            {1, 2},
            {1, 2}
        };
        System.out.println("sol: " + eraseOverlapIntervals(intervals2) + ", expected: 2");

        int[][] intervals3 = {
            {1, 2},
            {2, 3}
        };
        System.out.println("sol: " + eraseOverlapIntervals(intervals3) + ", expected: 0");
    }

    public static int eraseOverlapIntervals(int[][] intervals) {
        if (intervals.length == 0) {
            return 0;
        }

        Arrays.sort(intervals, Comparator.comparingInt(a -> a[1]));

        int end = intervals[0][1];
        int count = 0;

        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] < end) {
                count++;
            } else {
                end = intervals[i][1];
            }
        }

        return count;
    }
}
