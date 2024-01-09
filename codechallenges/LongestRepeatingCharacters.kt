package codechallenges

/**
 * LeetCode 424 - Longest Repeating Character Replacement
 *
 * You are given a string s and an integer k. You can choose any character of the string and change it to any other uppercase English character. You can perform this operation at most k times.
 *
 * Return the length of the longest substring containing the same letter you can get after performing the above operations.
 *
 * Example 1:
 *
 * Input: s = "ABAB", k = 2
 * Output: 4
 * Explanation: Replace the two 'A's with two 'B's or vice versa.
 * Example 2:
 *
 * Input: s = "AABABBA", k = 1
 * Output: 4
 * Explanation: Replace the one 'A' in the middle with 'B' and form "AABBBBA".
 * The substring "BBBB" has the longest repeating letters, which is 4.
 * There may exists other ways to achieve this answer too.
 *
 *
 * Constraints:
 *
 * 1 <= s.length <= 105
 * s consists of only uppercase English letters.
 * 0 <= k <= s.length
 */
fun main() {
    println("Sol 1 - AABABBA: ${longestRepeatingCharactersWithReplacement(" AABABBA ", 1)}")
    println("Sol 2 - AABABBA: ${longestRepeatingCharactersWithReplacementSol2(" AABABBA ", 1)}")
    println("Sol 2 - ABAB: ${longestRepeatingCharactersWithReplacementSol2(" ABAB", 2)}")
}

// Sol 1 ==> TC: O(26.n), SC: O(1)
fun longestRepeatingCharactersWithReplacement(s: String, k: Int): Int {
    var l = 0
    var r = 0
    var res = 0

    val map = hashMapOf<Char, Int>()

    while (true) {
        // Find length of max appearing letter
        var max = 0
        for (i in map.entries) {
            max = max.coerceAtLeast(i.value)
        }

        if (r >= s.length) {
            if (((r - l) - max) <= k) {
                res = res.coerceAtLeast(r - l)
            }
            break
        }

        if (((r - l) - max) <= k) {
            map[s[r]] = map.getOrDefault(s[r], 0) + 1
            res = res.coerceAtLeast(r - l)
            r += 1
        } else {
            map[s[l]] = map[s[l]]!! - 1
            l += 1
        }
    }

    return res
}

// Sol 2 ==> TC: O(n), SC: O(1)
fun longestRepeatingCharactersWithReplacementSol2(s: String, k: Int): Int {
    var l = 0
    var res = 0
    var max = 0

    val map = hashMapOf<Char, Int>()

    for (r in s.indices) {
        map[s[r]] = map.getOrDefault(s[r], 0) + 1

        max = max.coerceAtLeast(map[s[r]]!!)

        while (((r - l + 1) - max) > k) {
            map[s[l]] = map[s[l]]!! - 1
            l += 1
        }

        res = res.coerceAtLeast(r - l + 1)
    }

    return res
}