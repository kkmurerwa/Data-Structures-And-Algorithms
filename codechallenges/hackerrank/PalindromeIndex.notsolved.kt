package codechallenges.hackerrank

/**
 * Given a string of lowercase letters in the range ascii[a-z], determine the index of a character that can be removed to make the string a palindrome. There may be more than one solution, but any will do. If the word is already a palindrome or there is no solution, return -1. Otherwise, return the index of a character to remove.
 *
 * Example
 *
 * Either remove 'b' at index  or 'c' at index .
 *
 * Function Description
 *
 * Complete the palindromeIndex function in the editor below.
 *
 * palindromeIndex has the following parameter(s):
 *
 * string s: a string to analyze
 * Returns
 *
 * int: the index of the character to remove or
 * Input Format
 *
 * The first line contains an integer , the number of queries.
 * Each of the next  lines contains a query string .
 *
 * Constraints
 *
 * All characters are in the range ascii[a-z].
 * Sample Input
 *
 * STDIN   Function
 * -----   --------
 * 3       q = 3
 * aaab    s = 'aaab' (first query)
 * baa     s = 'baa'  (second query)
 * aaa     s = 'aaa'  (third query)
 * Sample Output
 *
 * 3
 * 0
 * -1
 * Explanation
 *
 * Query 1: "aaab"
 * Removing 'b' at index  results in a palindrome, so return .
 *
 * Query 2: "baa"
 * Removing 'b' at index  results in a palindrome, so return .
 *
 * Query 3: "aaa"
 * This string is already a palindrome, so return . Removing any one of the characters would result in a palindrome, but this test comes first.
 *
 * Note: The custom checker logic for this challenge is available here.
 */
fun main() {
    val input1 = "aaab"
    println("${palindromeIndex(input1)} expected 3")

    val input2 = "baa"
    println("${palindromeIndex(input2)} expected 0")

    val input3 = "aaa"
    println("${palindromeIndex(input3)} expected -1")

    val input4 = "abba"
    println("${palindromeIndex(input4)} expected -1")

    val input5 = "abc"
    println("${palindromeIndex(input5)} expected 2")
}

fun palindromeIndex(s: String): Int {
    // Eliminate palindromes and return -1
    var nonMatching = 0
    var l = 0
    var r = s.length - 1

    while (l < r) {
        if (s[l] != s[r]) {
            nonMatching++
        }
        l++
        r--
    }

    if (nonMatching == 0 ||  nonMatching > 1) {
        return -1
    }

    return 1
}