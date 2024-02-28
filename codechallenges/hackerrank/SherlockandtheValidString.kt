package codechallenges.hackerrank

/**
 * Sherlock and the Valid String
 *
 * Sherlock considers a string to be valid if all characters of the string appear the same number of times. It is also valid if he can remove just  character at  index in the string, and the remaining characters will occur the same number of times. Given a string , determine if it is valid. If so, return YES, otherwise return NO.
 *
 * Example
 *
 * This is a valid string because frequencies are .
 *
 *
 * This is a valid string because we can remove one  and have  of each character in the remaining string.
 *
 *
 * This string is not valid as we can only remove  occurrence of . That leaves character frequencies of .
 *
 * Function Description
 *
 * Complete the isValid function in the editor below.
 *
 * isValid has the following parameter(s):
 *
 * string s: a string
 * Returns
 *
 * string: either YES or NO
 * Input Format
 *
 * A single string .
 *
 * Constraints
 *
 * Each character
 * Sample Input 0
 *
 * aabbcd
 * Sample Output 0
 *
 * NO
 * Explanation 0
 *
 * Given , we would need to remove two characters, both c and d  aabb or a and b  abcd, to make it valid. We are limited to removing only one character, so  is invalid.
 *
 * Sample Input 1
 *
 * aabbccddeefghi
 * Sample Output 1
 *
 * NO
 * Explanation 1
 *
 * Frequency counts for the letters are as follows:
 *
 * {'a': 2, 'b': 2, 'c': 2, 'd': 2, 'e': 2, 'f': 1, 'g': 1, 'h': 1, 'i': 1}
 *
 * There are two ways to make the valid string:
 *
 * Remove  characters with a frequency of : .
 * Remove  characters of frequency : .
 * Neither of these is an option.
 *
 * Sample Input 2
 *
 * abcdefghhgfedecba
 * Sample Output 2
 *
 * YES
 * Explanation 2
 *
 * All characters occur twice except for  which occurs  times. We can delete one instance of  to have a valid string.
 */
fun main() {
    val input1 = "aabbcd"
    println("${isValid(input1)} expected NO")

    val input2 = "aabbccddeefghi"
    println("${isValid(input2)} expected NO")

    val input3 = "abcdefghhgfedecba"
    println("${isValid(input3)} expected YES")

    val input4 = "aabbcc"
    println("${isValid(input4)} expected YES")

    val input5 = "aaaaabc"
    println("${isValid(input5)} expected NO")
}

fun isValid(s: String): String {
    val freq = HashMap<Char, Int>()

    for (i in s.indices) {
        val char = s[i]
        freq[char] = freq.getOrDefault(char, 0) + 1
    }

    var mostCommon = 0
    var mostCommonFreq = 0
    val freqOfFreq = hashMapOf<Int, Int>()
    for (entry in freq.entries) {
        val nextCount = freqOfFreq.getOrDefault(entry.value, 0) + 1
        freqOfFreq[entry.value] = nextCount

        if (nextCount > mostCommonFreq) {
            mostCommonFreq = nextCount
            mostCommon = entry.value
        }

        if (freqOfFreq.size > 2) {
            return "NO"
        }
    }

    if (freqOfFreq.size == 1) {
        return "YES"
    }

    for (entry in freqOfFreq.entries) {
        if (entry.value == 1) {
            val key = entry.key

            if (key == 1 || (key > 1 && key - 1 == mostCommon)) {
                return "YES"
            }
        }

    }

    return "NO"
}
