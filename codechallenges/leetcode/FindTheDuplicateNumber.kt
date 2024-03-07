package codechallenges.leetcode

/**
 * LeetCode 287: Find the Duplicate Number
 *
 * Given an array of integers nums containing n + 1 integers where each integer is in the range [1, n] inclusive.
 *
 * There is only one repeated number in nums, return this repeated number.
 *
 * You must solve the problem without modifying the array nums and uses only constant extra space.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [1,3,4,2,2]
 * Output: 2
 * Example 2:
 *
 * Input: nums = [3,1,3,4,2]
 * Output: 3
 *
 *
 * Constraints:
 *
 * 1 <= n <= 105
 * nums.length == n + 1
 * 1 <= nums[i] <= n
 * All the integers in nums appear only once except for precisely one integer which appears two or more times.
 *
 *
 * Follow up:
 *
 * How can we prove that at least one duplicate number must exist in nums?
 * Can you solve the problem in linear runtime complexity?
 */
fun main() {
    val input1 = intArrayOf(1, 3, 4, 2, 2)
    println("${findDuplicate(input1)} expected 2")
}

fun findDuplicateBruteForce(nums: IntArray): Int {
    for (i in nums.indices) {
        for (j in i + 1 until nums.size) {
            if (nums[i] == nums[j]) {
                return nums[i]
            }
        }
    }

    return -1
}

fun findDuplicate(nums: IntArray): Int {
    // Floyd's Tortoise and Hare (Cycle Detection)
    var tortoise = nums[0]
    var hare = nums[0]

    do {
        tortoise = nums[tortoise]
        hare = nums[nums[hare]]
    } while (tortoise != hare)

    tortoise = nums[0]

    while (tortoise != hare) {
        tortoise = nums[tortoise]
        hare = nums[hare]
    }

    return tortoise
}