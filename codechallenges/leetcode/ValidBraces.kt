package codechallenges.leetcode

import java.util.ArrayDeque

fun main() {
    println(validBraces("([{}])"))
}

fun validBraces(braces: String): Boolean {
    val stack = ArrayDeque<Char>()

    for(i in braces.indices) {
        val brace = braces[i]
        if (brace == '(' || brace == '[' || brace == '{') {
            stack.push(brace)
        } else {
            if (stack.isEmpty()) {
                return false
            }

            val last = stack.pop()
            if ((brace == ')' && last != '(') ||
                (brace == ']' && last != '[') ||
                (brace == '}' && last != '{')) {
                return false
            }
        }
    }

    return stack.isEmpty()
}