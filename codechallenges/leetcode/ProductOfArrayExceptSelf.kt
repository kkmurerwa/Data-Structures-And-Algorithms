package codechallenges.leetcode

/**
 * LeetCode 238: Product of Array Except Self
 *
 * Given an integer array nums, return an array answer such that answer[i] is equal to the product of all the elements of nums except nums[i].
 *
 * The product of any prefix or suffix of nums is guaranteed to fit in a 32-bit integer.
 *
 * You must write an algorithm that runs in O(n) time and without using the division operation.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [1,2,3,4]
 * Output: [24,12,8,6]
 * Example 2:
 *
 * Input: nums = [-1,1,0,-3,3]
 * Output: [0,0,9,0,0]
 *
 *
 * Constraints:
 *
 * 2 <= nums.length <= 105
 * -30 <= nums[i] <= 30
 * The product of any prefix or suffix of nums is guaranteed to fit in a 32-bit integer.
 *
 *
 * Follow up: Can you solve the problem in O(1) extra space complexity? (The output array does not count as extra space for space complexity analysis.)
 */
fun main() {
    val input1 = intArrayOf(1, 2, 3, 4)
    println("${productExceptSelf(input1).contentToString()} expected [24, 12, 8, 6]")

    val input2 = intArrayOf(-1, 1, 0, -3, 3)
    println("${productExceptSelf(input2).contentToString()} expected [0, 0, 9, 0, 0]")
}

fun productExceptSelf(nums: IntArray): IntArray {
    val result = IntArray(nums.size)

    result[0] = 1
    for (i in 1..<nums.size) {
        result[i] = result[i-1] * nums[i-1]
    }

    var postFix = nums[nums.size - 1]
    for (i in (nums.size - 2) downTo 0) {
        result[i] *= postFix
        postFix *= nums[i]
    }
    return result
}