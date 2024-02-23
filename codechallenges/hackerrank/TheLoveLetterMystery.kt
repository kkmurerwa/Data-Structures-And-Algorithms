package codechallenges.hackerrank

import kotlin.math.abs

/**
 * James found a love letter that his friend Harry has written to his girlfriend. James is a prankster, so he decides to meddle with the letter. He changes all the words in the letter into palindromes.
 *
 * To do this, he follows two rules:
 *
 * He can only reduce the value of a letter by , i.e. he can change d to c, but he cannot change c to d or d to b.
 * The letter  may not be reduced any further.
 * Each reduction in the value of any letter is counted as a single operation. Find the minimum number of operations required to convert a given string into a palindrome.
 *
 * Example
 *
 * The following two operations are performed: cde → cdd → cdc. Return .
 *
 * Function Description
 *
 * Complete the theLoveLetterMystery function in the editor below.
 *
 * theLoveLetterMystery has the following parameter(s):
 *
 * string s: the text of the letter
 * Returns
 *
 * int: the minimum number of operations
 * Input Format
 *
 * The first line contains an integer , the number of queries.
 * The next  lines will each contain a string .
 *
 * Constraints
 *
 *
 *  | s |
 * All strings are composed of lower case English letters, ascii[a-z], with no spaces.
 *
 * Sample Input
 *
 * STDIN   Function
 * -----   --------
 * 4       q = 4
 * abc     query 1 = 'abc'
 * abcba
 * abcd
 * cba
 * Sample Output
 *
 * 2
 * 0
 * 4
 * 2
 * Explanation
 *
 * For the first query, abc → abb → aba.
 * For the second query, abcba is already a palindromic string.
 * For the third query, abcd → abcc → abcb → abca → abba.
 * For the fourth query, cba → bba → aba.
 */
fun main() {
    val input1 = "abc"
    println("${theLoveLetterMystery(input1)} expected: 2")

    val input2 = "abcba"
    println("${theLoveLetterMystery(input2)} expected: 0")

    val input3 = "abcd"
    println("${theLoveLetterMystery(input3)} expected: 4")

    val input4 = "cba"
    println("${theLoveLetterMystery(input4)} expected: 2")
}

fun theLoveLetterMystery(s: String): Int {
    var count = 0

    var l = 0
    var r = s.length - 1

    while (l < r) {
        count += abs(s[r].code - s[l].code)

        l += 1
        r -= 1
    }

    return count
}