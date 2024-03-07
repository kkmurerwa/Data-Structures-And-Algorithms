package codechallenges.hackerrank

/**
 * In this challenge, you will determine whether a string is funny or not. To determine whether a string is funny, create a copy of the string in reverse e.g. . Iterating through each string, compare the absolute difference in the ascii values of the characters at positions 0 and 1, 1 and 2 and so on to the end. If the list of absolute differences is the same for both strings, they are funny.
 *
 * Determine whether a give string is funny. If it is, return Funny, otherwise return Not Funny.
 *
 * Example
 *
 * The ordinal values of the charcters are .  and the ordinals are . The absolute differences of the adjacent elements for both strings are , so the answer is Funny.
 *
 * Function Description
 *
 * Complete the funnyString function in the editor below.
 *
 * funnyString has the following parameter(s):
 *
 * string s: a string to test
 * Returns
 *
 * string: either Funny or Not Funny
 * Input Format
 *
 * The first line contains an integer , the number of queries.
 * The next  lines each contain a string, .
 *
 * Constraints
 *
 * Sample Input
 *
 * STDIN   Function
 * -----   --------
 * 2       q = 2
 * acxz    s = 'acxz'
 * bcxz    s = 'bcxz'
 * Sample Output
 *
 * Funny
 * Not Funny
 * Explanation
 *
 * Let  be the reverse of .
 *
 * Test Case 0:
 *
 * ,
 * Corresponding ASCII values of characters of the strings:
 *  and
 * For both the strings the adjacent difference list is [2, 21, 2].
 *
 * Test Case 1:
 *
 * ,
 * Corresponding ASCII values of characters of the strings:
 *  and
 * The difference list for string  is [1, 21, 2] and for string  is [2, 21, 1].
 */
fun main() {
    val input1 = "acxz"
    println("${funnyString(input1)} expected Funny")

    val input2 = "bcxz"
    println("${funnyString(input2)} expected Not Funny")
}

fun funnyString(s: String): String {
    // Write your code here
    var l = 0
    var r = s.length - 1

    while (l < r) {
        if (Math.abs(s[l] - s[l + 1]) != Math.abs(s[r] - s[r - 1])) {
            return "Not Funny"
        }
        l++
        r--
    }

    return "Funny"
}