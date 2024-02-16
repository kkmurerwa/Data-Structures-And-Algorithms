package codechallenges.leetcode;

/**
 * LeetCode 153 - Find Minimum in Rotated Sorted Array
 *
 * There is an integer array nums sorted in ascending order (with distinct values).Prior to being passed to your
 * function, nums is possibly rotated at an unknown pivot index k (1 <= k < nums.length) such that the resulting array
 * is [nums[k], nums[k+1], ..., nums[n-1], nums[0], nums[1], ..., nums[k-1]] (0-indexed).
 *
 * For example, [0,1,2,4,5,6,7] might be rotated at pivot index 3 and become [4,5,6,7,0,1,2].
 *
 * Given the array nums after the possible rotation and an integer target, return the index of target if it is in nums,
 * or -1 if it is not in nums.
 *
 * You must write an algorithm with O(log n) runtime complexity.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [4,5,6,7,0,1,2], target = 0
 * Output: 4
 * Example 2:
 *
 * Input: nums = [4,5,6,7,0,1,2], target = 3
 * Output: -1
 * Example 3:
 *
 * Input: nums = [1], target = 0
 * Output: -1
 *
 *
 * Constraints:
 *
 * 1 <= nums.length <= 5000
 * -104 <= nums[i] <= 104
 * All values of nums are unique.
 * nums is an ascending array that is possibly rotated.
 * -104 <= target <= 104
 */
public class MinimumInSortedRotatedArray {
    public static void main(String[] args) {
        int[] input1 = new int[] { 3,4,5,1,2 };
        System.out.println("Min Value: " + minInSortedArray(input1) + " Expected: 1");

        int[] input2 = new int[] { 4,5,6,7,0,1,2 };
        System.out.println("Min Value: " + minInSortedArray(input2) + " Expected: 0");

        int[] input3 = new int[] { 11,13,15,17 };
        System.out.println("Min Value: " + minInSortedArray(input3) + " Expected: 11");

        int[] input4 = new int[] { 1 };
        System.out.println("Min Value: " + minInSortedArray(input4) + " Expected: 1");

        int[] input5 = new int[] { 3,1,2 };
        System.out.println("Min Value: " + minInSortedArray(input5) + " Expected: 1");
    }

    public static int minInSortedArray(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        int min = Integer.MAX_VALUE;

        while (left <= right) {
            int mid = left + ((right - left) / 2);
            min = Math.min(min, nums[mid]);

            if (nums[right] < nums[mid]) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return min;
    }
}
