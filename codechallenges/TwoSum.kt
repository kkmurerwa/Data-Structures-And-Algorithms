package codechallenges

fun main() {

}

// Sol 1: Two nested loops ==> TC: O(n^2), SC: O(1)
// Sol 2: Create hashmap of all elements, get diff, check if exists in map ==> TC: O(2n), SC: O(n)
// Sol 3: One pass hash table ==> TC: O(n), SC: O(n)

// Sol 1: You already have this.

// Sol 2
fun twoSumWithHashMapTwoPasses(nums: IntArray, target: Int): IntArray {
    val map = mutableMapOf<Int, Int>()

    // Add all elements to map
    for (i in nums.indices) {
        map[nums[i]] = i
    }

    // Pass while checking if exists
    for (i in nums.indices) {
        val diff = target - nums[i]
        if (map.containsKey(diff) && map[diff] != i) {
            return intArrayOf(i, map[diff]!!)
        }
    }

    return intArrayOf()
}

// Sol 3
fun twoSumWithHashMapSinglePass(nums: IntArray, target: Int): IntArray {
    val map = mutableMapOf<Int, Int>()

    // Add to map while checking if solution has been encountered
    for (i in nums.indices) {
        val diff = target - nums[i]
        if (map.containsKey(diff)) {
            return intArrayOf(i, map[diff]!!)
        }

        map[nums[i]] = i
    }

    return intArrayOf()
}

