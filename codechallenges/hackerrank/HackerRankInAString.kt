package codechallenges.hackerrank

/**
 * We say that a string contains the word hackerrank if a subsequence of its characters spell the word hackerrank. Remeber that a subsequence maintains the order of characters selected from a sequence.
 *
 * More formally, let  be the respective indices of h, a, c, k, e, r, r, a, n, k in string . If  is true, then  contains hackerrank.
 *
 * For each query, print YES on a new line if the string contains hackerrank, otherwise, print NO.
 *
 * Example
 *
 * This contains a subsequence of all of the characters in the proper order. Answer YES
 *
 *
 * This is missing the second 'r'. Answer NO.
 *
 *
 * There is no 'c' after the first occurrence of an 'a', so answer NO.
 *
 * Function Description
 *
 * Complete the hackerrankInString function in the editor below.
 *
 * hackerrankInString has the following parameter(s):
 *
 * string s: a string
 * Returns
 *
 * string: YES or NO
 * Input Format
 *
 * The first line contains an integer , the number of queries.
 * Each of the next  lines contains a single query string .
 *
 * Constraints
 *
 * Sample Input 0
 *
 * 2
 * hereiamstackerrank
 * hackerworld
 * Sample Output 0
 *
 * YES
 * NO
 * Explanation 0
 *
 * We perform the following  queries:
 *
 *
 * The characters of hackerrank are bolded in the string above. Because the string contains all the characters in hackerrank in the same exact order as they appear in hackerrank, we return YES.
 *  does not contain the last three characters of hackerrank, so we return NO.
 * Sample Input 1
 *
 * 2
 * hhaacckkekraraannk
 * rhbaasdndfsdskgbfefdbrsdfhuyatrjtcrtyytktjjt
 * Sample Output 1
 *
 * YES
 * NO
 */
fun main() {
    val input1 = "hereiamstackerrank"
    println("${hackerrankInString(input1)} expected YES")

    val input2 = "hackerworld"
    println("${hackerrankInString(input2)} expected NO")

    val input3 = "hhaacckkekraraannk"
    println("${hackerrankInString(input3)} expected YES")

    val input4 = "knarrekcah"
    println("${hackerrankInString(input4)} expected NO")

    val input5 = "hackerrank"
    println("${hackerrankInString(input5)} expected YES")

    val input6 = "hackeronek"
    println("${hackerrankInString(input6)} expected NO")

    val input7 = "abcdefghijklmnopqrstuvwxyz"
    println("${hackerrankInString(input7)} expected NO")

    val input8 = "rhackerank"
    println("${hackerrankInString(input8)} expected NO")

    val input9 = "ahankercka"
    println("${hackerrankInString(input9)} expected NO")

    val input10 = "hacakaeararanaka"
    println("${hackerrankInString(input10)} expected YES")

    val input11 = "hhhhaaaaackkkkerrrrrrrrank"
    println("${hackerrankInString(input11)} expected YES")

    val input12 = "crackerhackerknar"
    println("${hackerrankInString(input12)} expected NO")

    val input13 = "hhhackkerbanker"
    println("${hackerrankInString(input13)} expected NO")
}

fun hackerrankInString(s: String): String {
    val hackerrank = "hackerrank"
    var bottom = 0
    var found = 0

    for (i in hackerrank.indices) {
        while (bottom < s.length) {
            if (s[bottom] == hackerrank[i]) {
                found += 1
                bottom += 1
                break
            }

            bottom += 1
        }

        if (bottom == s.length) {
            break
        }
    }

    return if (found == hackerrank.length) "YES" else "NO"
}