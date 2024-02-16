package codechallenges.leetcode

/**
 * LeetCode 5: Longest Palindromic Substring
 *
 * Given a string s, return the longest
 * palindromic
 *
 * substring
 *  in s.
 *
 *
 *
 * Example 1:
 *
 * Input: s = "babad"
 * Output: "bab"
 * Explanation: "aba" is also a valid answer.
 * Example 2:
 *
 * Input: s = "cbbd"
 * Output: "bb"
 *
 *
 * Constraints:
 *
 * 1 <= s.length <= 1000
 * s consist of only digits and English letters.
 */

fun main(){
    val res = longestPalindrome("babad")
    println("res: $res expected: bab or aba")

    val res2 = longestPalindrome("cbbd")
    println("res: $res2 expected: bb")

    val res3 = longestPalindrome("ccc")
    println("res: $res3 expected: ccc")
}

fun longestPalindrome(s: String): String {
    if (s.length <= 1) {
        return s
    }

    var res = ""

    for (i in 1..<s.length) {
        val curr = s[i]
        val sb = StringBuilder()
        sb.append(curr)

        var left = i - 1
        var right = i + 1

        // Check if middle elements are two
        if (curr == s[left]) {
            sb.append(s[left])
            left -= 1

            while (right < s.length) {
                if (s[right] != curr) {
                    break
                }

                sb.append(s[right])
                right += 1
            }
        }

        if (sb.length > res.length) {
            res = sb.toString()
        }

        while (left >= 0 && right < s.length) {
            if (sb.length == s.length) {
                return s
            }

            if (s[left] == s[right]) {
                sb.append(s[right])
                sb.insert(0, s[left])

                if (sb.length > res.length) {
                    res = sb.toString()
                }

                left -= 1
                right += 1
            } else {
                break
            }
        }
    }
    return res
}