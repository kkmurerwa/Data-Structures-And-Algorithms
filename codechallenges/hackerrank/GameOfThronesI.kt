package codechallenges.hackerrank

/**
 * Dothraki are planning an attack to usurp King Robert's throne. King Robert learns of this conspiracy from Raven and plans to lock the single door through which the enemy can enter his kingdom.
 *
 * door
 *
 * But, to lock the door he needs a key that is an anagram of a palindrome. He starts to go through his box of strings, checking to see if they can be rearranged into a palindrome. Given a string, determine if it can be rearranged into a palindrome. Return the string YES or NO.
 *
 * Example
 *
 * One way this can be arranged into a palindrome is . Return YES.
 *
 * Function Description
 * Complete the gameOfThrones function below.
 *
 * gameOfThrones has the following parameter(s):
 *
 * string s: a string to analyze
 * Returns
 *
 * string: either YES or NO
 * Input Format
 *
 * A single line which contains .
 *
 * Constraints
 *
 *  |s|
 *  contains only lowercase letters in the range
 * Sample Input 0
 *
 * aaabbbb
 * Sample Output 0
 *
 * YES
 * Explanation 0
 *
 * A palindromic permutation of the given string is bbaaabb.
 *
 * Sample Input 1
 *
 * cdefghmnopqrstuvw
 * Sample Output 1
 *
 * NO
 * Explanation 1
 *
 * Palindromes longer than 1 character are made up of pairs of characters. There are none here.
 *
 * Sample Input 2
 *
 * cdcdcdcdeeeef
 * Sample Output 2
 *
 * YES
 * Explanation 2
 *
 * An example palindrome from the string: ddcceefeeccdd.
 */
fun main() {
    val input1 = "aaabbbb"
    println("${gameOfThrones(input1)} expected YES")

    val input2 = "cdefghmnopqrstuvw"
    println("${gameOfThrones(input2)} expected NO")

    val input3 = "cdcdcdcdeeeef"
    println("${gameOfThrones(input3)} expected YES")
}

fun gameOfThrones(s: String): String {
    val map = hashMapOf<Char, Int>()

    for (i in s.indices) {
        val char = s[i]

        map[char] = map.getOrDefault(char, 0) + 1
    }

    var notDivisibleByTwo = 0
    for (value in map.values) {
        if (value % 2 != 0) {
            notDivisibleByTwo += 1
        }
    }

    return if (notDivisibleByTwo <= 1) "YES" else "NO"
}



