package codechallenges.hackerrank

/**
 * Two Strings
 *
 * Given two strings, determine if they share a common substring. A substring may be as small as one character.
 *
 * Example
 *
 *
 * These share the common substring .
 *
 *
 *
 * These do not share a substring.
 *
 * Function Description
 *
 * Complete the function twoStrings in the editor below.
 *
 * twoStrings has the following parameter(s):
 *
 * string s1: a string
 * string s2: another string
 * Returns
 *
 * string: either YES or NO
 * Input Format
 *
 * The first line contains a single integer , the number of test cases.
 *
 * The following  pairs of lines are as follows:
 *
 * The first line contains string .
 * The second line contains string .
 * Constraints
 *
 *  and  consist of characters in the range ascii[a-z].
 * Output Format
 *
 * For each pair of strings, return YES or NO.
 *
 * Sample Input
 *
 * 2
 * hello
 * world
 * hi
 * world
 * Sample Output
 *
 * YES
 * NO
 * Explanation
 *
 * We have  pairs to check:
 *
 * , . The substrings  and  are common to both strings.
 * , .  and  share no common substrings.
 */
fun main() {
    val s1 = "hello"
    val s2 = "world"
    println("${twoStrings(s1, s2)} expected YES")

    val s3 = "hi"
    val s4 = "world"
    println("${twoStrings(s3, s4)} expected NO")
}

fun twoStrings(s1: String, s2: String): String {
    // Sol: Convert to set, check if sets overlap
    val set1 = mutableSetOf<Char>()

    for (i in s1.indices) {
        val char = s1[i]
        set1.add(char)
    }

    for (i in s2.indices) {
        val char = s2[i]
        if (set1.contains(char)) {
            return "YES"
        }
    }

    return "NO"
}