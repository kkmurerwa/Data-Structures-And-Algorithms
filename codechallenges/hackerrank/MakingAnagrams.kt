package codechallenges.hackerrank

import kotlin.math.abs

/**
 * Making Anagrams
 *
 * We consider two strings to be anagrams of each other if the first string's letters can be rearranged to form the second string. In other words, both strings must contain the same exact letters in the same exact frequency. For example, bacdc and dcbac are anagrams, but bacdc and dcbad are not.
 *
 * Alice is taking a cryptography class and finding anagrams to be very useful. She decides on an encryption scheme involving two large strings where encryption is dependent on the minimum number of character deletions required to make the two strings anagrams. Can you help her find this number?
 *
 * Given two strings,  and , that may not be of the same length, determine the minimum number of character deletions required to make  and  anagrams. Any characters can be deleted from either of the strings.
 *
 * Example.
 *
 *
 * The only characters that match are the 's so we have to remove  from  and  from  for a total of  deletions.
 *
 * Function Description
 *
 * Complete the makingAnagrams function in the editor below.
 *
 * makingAnagrams has the following parameter(s):
 *
 * string s1: a string
 * string s2: a string
 * Returns
 *
 * int: the minimum number of deletions needed
 * Input Format
 *
 * The first line contains a single string, .
 * The second line contains a single string, .
 *
 * Constraints
 *
 * It is guaranteed that  and  consist of lowercase English letters, ascii[a-z].
 * Sample Input
 *
 * cde
 * abc
 * Sample Output
 *
 * 4
 * Explanation
 *
 * Delete the following characters from our two strings to turn them into anagrams:
 *
 * Remove d and e from cde to get c.
 * Remove a and b from abc to get c.
 *  characters have to be deleted to make both strings anagrams.
 */
fun main() {
    val input1_1 = "cde"
    val input1_2 = "abc"
    println("${makingAnagrams(input1_1, input1_2)} expected: 4")

    val input2_1 = "absdjk"
    val input2_2 = "djflad"
    println("${makingAnagrams(input2_1, input2_2)} expected: 6")

    val input3_1 = "absdjkvuahdakejfnfauhdsaavasdlkj"
    val input3_2 = "djfladfhiawasdkjvalskufhafablsdkashlahdfa"
    println("${makingAnagrams(input3_1, input3_2)} expected: 19")
}

fun makingAnagrams(s1: String, s2: String): Int {
    val map1 = HashMap<Char, Int>()

    for (i in s1.indices) {
        map1[s1[i]] = map1.getOrDefault(s1[i], 0) + 1
    }

    for (i in s2.indices) {
        map1[s2[i]] = map1.getOrDefault(s2[i], 0) - 1
    }

    var res = 0
    for (value in map1.values) {
        res += abs(value)
    }

    return res
}