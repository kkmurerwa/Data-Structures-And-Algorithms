package codechallenges.hackerrank

/**
 * You are given a string containing characters  and  only. Your task is to change it into a string such that there are no matching adjacent characters. To do this, you are allowed to delete zero or more characters in the string.
 *
 * Your task is to find the minimum number of required deletions.
 *
 * Example
 *
 * Remove an  at positions  and  to make  in  deletions.
 *
 * Function Description
 *
 * Complete the alternatingCharacters function in the editor below.
 *
 * alternatingCharacters has the following parameter(s):
 *
 * string s: a string
 * Returns
 *
 * int: the minimum number of deletions required
 * Input Format
 *
 * The first line contains an integer , the number of queries.
 * The next  lines each contain a string  to analyze.
 *
 * Constraints
 *
 * Each string  will consist only of characters  and .
 * Sample Input
 *
 * 5
 * AAAA
 * BBBBB
 * ABABABAB
 * BABABA
 * AAABBB
 * Sample Output
 *
 * 3
 * 4
 * 0
 * 0
 * 4
 * Explanation
 *
 * The characters marked red are the ones that can be deleted so that the string does not have matching adjacent characters.
 *
 */
fun main() {
    val input1 = "AAAA"
    println("${alternatingCharacters(input1)} expected 3")

    val input2 = "BBBBB"
    println("${alternatingCharacters(input2)} expected 4")

    val input3 = "ABABABAB"
    println("${alternatingCharacters(input3)} expected 0")

    val input4 = "AAABBB"
    println("${alternatingCharacters(input4)} expected 4")

    val input5 = "ABBABBAA"
    println("${alternatingCharacters(input5)} expected 3")
}

fun alternatingCharacters(s: String): Int {
    var count = 0
    var prev = s[0]

    for (i in 1..<s.length) {
        if (prev == s[i]) {
            count += 1
        }

        prev = s[i]
    }

    return count
}
