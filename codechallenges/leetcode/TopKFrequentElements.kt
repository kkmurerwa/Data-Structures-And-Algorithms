package codechallenges.leetcode

/**
 * LeetCode 347: Top K Frequent Elements
 *
 * Given an integer array nums and an integer k, return the k most frequent elements. You may return the answer in any order.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [1,1,1,2,2,3], k = 2
 * Output: [1,2]
 * Example 2:
 *
 * Input: nums = [1], k = 1
 * Output: [1]
 *
 *
 * Constraints:
 *
 * 1 <= nums.length <= 105
 * -104 <= nums[i] <= 104
 * k is in the range [1, the number of unique elements in the array].
 * It is guaranteed that the answer is unique.
 *
 *
 * Follow up: Your algorithm's time complexity must be better than O(n log n), where n is the array's size.
 */
fun main() {
    val input1 = intArrayOf(1, 1, 1, 2, 2, 3)
    val k1 = 2
    println("${topKFrequent(input1, k1).contentToString()} expected [1, 2]")
}

fun topKFrequent(nums: IntArray, k: Int): IntArray {
    val map = HashMap<Int, Int>()
    val freq = MutableList<MutableList<Int>>(nums.size + 1){ mutableListOf() }

    // Create hashMap
    for (i in nums) {
        map[i] = map.getOrDefault(i, 0) + 1
    }

    // Populate freq list
    for ((key, value) in map.entries) {
        val list = freq[value]
        list.add(key)
        freq[value] = list
    }

    val res = IntArray(k)
    var insertAt = 0
    var getFrom = nums.size - 1

    println("freq: $freq")

    // Return top k
    while (insertAt < k) {
        val tempList = freq[getFrom]

        for (i in tempList) {
            res[insertAt] = i
            insertAt += 1
        }
        getFrom -= 1
    }

    return res
}
